package com.s8.core.io.csv.type;

import java.lang.reflect.InvocationTargetException;


public interface Setter {
	

	public abstract void set(String value, Object object)
			throws NumberFormatException,
			IllegalArgumentException,
			IllegalAccessException,
			InvocationTargetException;
	
	
}
