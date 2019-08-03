package com.qx.io.csv.mapped.type;

import java.lang.reflect.Field;

import com.qx.base.QxScientificUnit;

public class StringFieldMapping extends FieldMapping {

	public StringFieldMapping(Field field) {
		super(field);
	}

	@Override
	public void set(String value, Object object, QxScientificUnit unit)
			throws NumberFormatException, IllegalArgumentException, IllegalAccessException {
		field.set(object, value);
	}

	@Override
	public String get(Object object, QxScientificUnit unit)
			throws IllegalArgumentException, IllegalAccessException {
		return (String) field.get(object);
	}
}