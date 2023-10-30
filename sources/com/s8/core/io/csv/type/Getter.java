package com.s8.core.io.csv.type;

public interface Getter {


	public abstract String get(Object object) throws IllegalArgumentException, IllegalAccessException;
}
