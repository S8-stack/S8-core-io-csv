package com.qx.io.csv.mapped.type;

import com.qx.base.units.QxScientificUnit;

public interface Getter {


	public abstract String get(Object object, QxScientificUnit unit) throws IllegalArgumentException, IllegalAccessException;
}
