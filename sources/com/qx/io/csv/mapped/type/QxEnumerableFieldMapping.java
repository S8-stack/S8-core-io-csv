package com.qx.io.csv.mapped.type;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import com.qx.base.QxEnumerable;
import com.qx.base.QxScientificUnit;
import com.qx.base.QxEnumerable.Prototype;

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
	public String get(Object object, QxScientificUnit unit) throws IllegalArgumentException, IllegalAccessException {
		QxEnumerable enumerable = (QxEnumerable) field.get(object);
		return enumerable.getName();
	}

	@Override
	public void set(String value, Object object, QxScientificUnit unit)
			throws NumberFormatException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		QxEnumerable enumerable = proto.getByName(value);
		field.set(object, enumerable);
	}

}
