package com.qx.level0.io.csv.mapped.type;

import com.qx.level0.utilities.units.SI_Unit;

public interface Getter {


	public abstract String get(Object object, SI_Unit unit) throws IllegalArgumentException, IllegalAccessException;
}
