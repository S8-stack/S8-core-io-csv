package com.qx.io.csv.mapped.type;

import java.lang.reflect.Field;

import com.qx.base.units.SI_Unit;


public class DoubleFieldMapping extends FieldMapping {


	public DoubleFieldMapping(Field field) {
		super(field);
	}

	@Override
	public void set(String value, Object object, SI_Unit unit)
			throws NumberFormatException, IllegalArgumentException, IllegalAccessException {
		field.setDouble(object, unit.convertBack(Double.valueOf(value)));
	}

	@Override
	public String get(Object object, SI_Unit unit)
			throws IllegalArgumentException, IllegalAccessException {
		return Double.toString(unit.convert(field.getDouble(object)));
	}
}