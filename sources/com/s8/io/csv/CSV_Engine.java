package com.s8.io.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.s8.io.csv.type.CSV_TypeHandler;
import com.s8.io.csv.type.Setter;

/**
 * 
 * @author pc
 *
 * @param <T>
 */
public class CSV_Engine<T> {

	public final static String DELIMITERS = "[ ]*,[ ]*";

	public final static String TAG_REGEX = "([a-zA-Z0-0\\-_#\\?]+) *(\\[([a-zA-Z0-9\\.\\-]+)\\])?";

	private Pattern tagPattern;

	private CSV_Unit.Base unitsFactory;


	private Constructor<T> constructor;

	private CSV_TypeHandler typeHandler;

	/**
	 * 
	 * @param type
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws NoSuchFieldException 
	 */
	public CSV_Engine(Class<T> type) 
			throws 
			NoSuchMethodException, 
			SecurityException, 
			NoSuchFieldException, 
			IllegalArgumentException, 
			IllegalAccessException 
	{
		super();
		initialize(type, null);
	}


	/**
	 * 
	 * @param type
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws NoSuchFieldException 
	 */
	public CSV_Engine(Class<T> type, CSV_Unit.Base factory) 
			throws 
			NoSuchMethodException, 
			SecurityException, 
			NoSuchFieldException, 
			IllegalArgumentException, 
			IllegalAccessException 
	{
		super();
		initialize(type, factory);
	}


	private void initialize(Class<T> type, CSV_Unit.Base unitsFactory) 
			throws 
			NoSuchMethodException, 
			SecurityException, 
			NoSuchFieldException, 
			IllegalArgumentException, 
			IllegalAccessException {

		constructor = type.getConstructor(new Class<?>[]{});

		typeHandler = new CSV_TypeHandler(type);

		// compile tag regex in a pattern
		tagPattern = Pattern.compile(TAG_REGEX);

		this.unitsFactory = unitsFactory;
	}





	/**
	 * 
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	public T[] toArray(InputStream inputStream) throws IOException {
		List<T> list = new ArrayList<T>();
		forEachRow(inputStream, object -> list.add(object));
		int length = list.size();

		@SuppressWarnings("unchecked")
		T[] array = (T[]) Array.newInstance(typeHandler.getType(), length);
		list.toArray(array);
		return array;
	}



	/**
	 * 
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	public void forEachRow(InputStream inputStream, CSV_Consumer<T> consumer) throws IOException {

		// read headers

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		String headerLine = reader.readLine();
		String[] headers = headerLine.split(DELIMITERS);
		int n = headers.length;

		Setter[] setters = new Setter[n];

		try {
			String tag, unit;
			for(int i=0; i<n; i++){
				Matcher matcher = tagPattern.matcher(headers[i]);
				matcher.find();
				tag = matcher.group(1);
				unit = matcher.group(3);
				setters[i] = typeHandler.getSetter(tag, 
						(unit!=null && unitsFactory!=null) ? unitsFactory.getUnit(unit) : null);

			}
		}
		catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
			throw new IOException(e.getMessage());
		}

		
		String line = reader.readLine();
		while(line!=null) {
			T object = null;
			try {
				String[] values = line.split(DELIMITERS);
				object = constructor.newInstance(new Object[]{});
				for(int i=0; i<n; i++){
					setters[i].set(values[i], object);
				}
			}
			catch (InstantiationException 
					| IllegalAccessException 
					| IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
				throw new IOException("Failed to parse file due to: "+e.getMessage());
			}

			consumer.consumeRow(object);
			line = reader.readLine();
		}
	}
	
	
	
	/**
	 * 
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	public List<T> toList(InputStream inputStream) throws IOException {
		List<T> output = new ArrayList<T>();
		forEachRow(inputStream, object -> output.add(object));
		return output;
	}
}

