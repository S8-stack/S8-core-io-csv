package com.qx.level0.io.csv.mapped.type;

import java.lang.reflect.Field;

import com.qx.base.units.SI_Unit;

public class ShortFieldMapping extends FieldMapping {

	public ShortFieldMapping(Field field) {
		super(field);
	}

	@Override
	public void set(String value, Object object, SI_Unit unit)
			throws NumberFormatException, IllegalArgumentException, IllegalAccessException {
		field.setShort(object, Short.valueOf(value));
	}

	@Override
	public String get(Object object, SI_Unit unit)
			throws IllegalArgumentException, IllegalAccessException {
		return Short.toString(field.getShort(object));
	}
}