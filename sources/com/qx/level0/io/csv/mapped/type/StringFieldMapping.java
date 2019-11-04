package com.qx.level0.io.csv.mapped.type;

import java.lang.reflect.Field;

import com.qx.base.units.SI_Unit;

public class StringFieldMapping extends FieldMapping {

	public StringFieldMapping(Field field) {
		super(field);
	}

	@Override
	public void set(String value, Object object, SI_Unit unit)
			throws NumberFormatException, IllegalArgumentException, IllegalAccessException {
		field.set(object, value);
	}

	@Override
	public String get(Object object, SI_Unit unit)
			throws IllegalArgumentException, IllegalAccessException {
		return (String) field.get(object);
	}
}