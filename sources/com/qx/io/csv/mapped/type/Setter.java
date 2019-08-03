package com.qx.io.csv.mapped.type;

import java.lang.reflect.InvocationTargetException;

import com.qx.base.units.QxScientificUnit;


public interface Setter {
	

	public abstract void set(String value, Object object, QxScientificUnit unit)
			throws NumberFormatException,
			IllegalArgumentException,
			IllegalAccessException,
			InvocationTargetException;
	
	
}
