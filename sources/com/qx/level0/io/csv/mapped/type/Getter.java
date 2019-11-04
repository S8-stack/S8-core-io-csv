package com.qx.level0.io.csv.mapped.type;

import com.qx.base.units.SI_Unit;

public interface Getter {


	public abstract String get(Object object, SI_Unit unit) throws IllegalArgumentException, IllegalAccessException;
}
