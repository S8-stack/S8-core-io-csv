package com.qx.io.csv.mapped.type;

import java.lang.reflect.Field;

import com.qx.base.units.QxScientificUnit;


public class DoubleFieldMapping extends FieldMapping {


	public DoubleFieldMapping(Field field) {
		super(field);
	}

	@Override
	public void set(String value, Object object, QxScientificUnit unit)
			throws NumberFormatException, IllegalArgumentException, IllegalAccessException {
		field.setDouble(object, unit.toIS(Double.valueOf(value)));
	}

	@Override
	public String get(Object object, QxScientificUnit unit)
			throws IllegalArgumentException, IllegalAccessException {
		return Double.toString(unit.fromIS(field.getDouble(object)));
	}
}