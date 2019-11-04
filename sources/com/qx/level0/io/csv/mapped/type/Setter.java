package com.qx.level0.io.csv.mapped.type;

import java.lang.reflect.InvocationTargetException;

import com.qx.level0.utilities.units.SI_Unit;


public interface Setter {
	

	public abstract void set(String value, Object object, SI_Unit unit)
			throws NumberFormatException,
			IllegalArgumentException,
			IllegalAccessException,
			InvocationTargetException;
	
	
}
