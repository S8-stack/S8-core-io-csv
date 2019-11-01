package com.qx.io.csv.mapped.type;

import java.lang.reflect.Field;

import com.qx.base.units.SI_Unit;

public class LongFieldMapping extends FieldMapping {

	public LongFieldMapping(Field field) {
		super(field);
	}

	@Override
	public void set(String value, Object object, SI_Unit unit)
			throws NumberFormatException, IllegalArgumentException, IllegalAccessException {
		field.setLong(object, Long.valueOf(value));
	}

	@Override
	public String get(Object object, SI_Unit unit)
			throws IllegalArgumentException, IllegalAccessException {
		return Long.toString(field.getLong(object));
	}
}
