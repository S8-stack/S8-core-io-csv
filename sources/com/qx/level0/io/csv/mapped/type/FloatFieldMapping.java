package com.qx.level0.io.csv.mapped.type;

import java.lang.reflect.Field;

import com.qx.level0.utilities.units.SI_Unit;

public class FloatFieldMapping extends FieldMapping {

	public FloatFieldMapping(Field field) {
		super(field);
	}

	@Override
	public void set(String value, Object object, SI_Unit unit)
			throws NumberFormatException, IllegalArgumentException, IllegalAccessException {
		field.setFloat(object, (float) unit.convertBack(Float.valueOf(value)));
	}

	@Override
	public String get(Object object, SI_Unit unit)
			throws IllegalArgumentException, IllegalAccessException {
		return Double.toString(unit.convert(field.getFloat(object)));
	}
}
