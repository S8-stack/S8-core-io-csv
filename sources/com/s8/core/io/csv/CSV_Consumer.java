package com.s8.core.io.csv;

public interface CSV_Consumer<T> {

	
	public void consumeRow(T object);
	
}
