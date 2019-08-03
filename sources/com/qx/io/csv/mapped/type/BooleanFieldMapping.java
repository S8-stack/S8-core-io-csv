package com.qx.io.csv.mapped.type;

import java.lang.reflect.Field;

import com.qx.base.units.QxScientificUnit;

public class BooleanFieldMapping extends FieldMapping {

	public BooleanFieldMapping(Field field) {
		super(field);
	}

	@Override
	public void set(String value, Object object, QxScientificUnit unit)
			throws NumberFormatException, IllegalArgumentException, IllegalAccessException {
		field.setBoolean(object, Boolean.valueOf(value));
	}

	@Override
	public String get(Object object, QxScientificUnit unit)
			throws IllegalArgumentException, IllegalAccessException {
		return Boolean.toString(field.getBoolean(object));
	}
}