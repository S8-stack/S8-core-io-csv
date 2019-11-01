package com.qx.io.csv.mapped.type;

import java.lang.reflect.Field;

import com.qx.base.units.SI_Unit;

public class BooleanFieldMapping extends FieldMapping {

	public BooleanFieldMapping(Field field) {
		super(field);
	}

	@Override
	public void set(String value, Object object, SI_Unit unit)
			throws NumberFormatException, IllegalArgumentException, IllegalAccessException {
		field.setBoolean(object, Boolean.valueOf(value));
	}

	@Override
	public String get(Object object, SI_Unit unit)
			throws IllegalArgumentException, IllegalAccessException {
		return Boolean.toString(field.getBoolean(object));
	}
}