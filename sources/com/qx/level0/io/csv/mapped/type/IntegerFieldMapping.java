package com.qx.level0.io.csv.mapped.type;

import java.lang.reflect.Field;

import com.qx.level0.utilities.units.SI_Unit;


public class IntegerFieldMapping extends FieldMapping {

	public IntegerFieldMapping(Field field) {
		super(field);
	}

	@Override
	public void set(String value, Object object, SI_Unit unit)
			throws NumberFormatException, IllegalArgumentException, IllegalAccessException {
		field.setInt(object, Integer.valueOf(value));
	}

	@Override
	public String get(Object object, SI_Unit unit)
			throws IllegalArgumentException, IllegalAccessException {
		return Integer.toString(field.getInt(object));
	}
}