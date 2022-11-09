package com.s8.io.csv.type.fields;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import com.s8.io.csv.QxEnumerable;
import com.s8.io.csv.QxEnumerable.Prototype;

public class QxEnumerableFieldMapping extends FieldMapping {
	
	private QxEnumerable.Prototype<? extends QxEnumerable> proto;
	
	@SuppressWarnings("unchecked")
	public QxEnumerableFieldMapping(Field field) 
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		super(field);
		Class<?> type = field.getType();
		Field protoStaticField = type.getField("PROTOTYPE");
		proto = (Prototype<? extends QxEnumerable>) protoStaticField.get(null);	
	}

	@Override
	public String get(Object object) throws IllegalArgumentException, IllegalAccessException {
		QxEnumerable enumerable = (QxEnumerable) field.get(object);
		return enumerable.getName();
	}

	@Override
	public void set(String value, Object object)
			throws NumberFormatException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		QxEnumerable enumerable = proto.getByName(value);
		field.set(object, enumerable);
	}

}
