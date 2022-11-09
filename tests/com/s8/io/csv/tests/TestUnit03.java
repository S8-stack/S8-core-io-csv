package com.s8.io.csv.tests;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.s8.io.csv.CSV_Engine;

public class TestUnit03 {

	public static void main(String[] args) throws Exception {
		CSV_Engine<ASME_B16_5_WeldingNeckFlangeModel> engine 
			= new CSV_Engine<>(ASME_B16_5_WeldingNeckFlangeModel.class, QxUnit.FACTORY);
		InputStream inputStream = new FileInputStream(new File("data/ASME_B16.5_welded_neck_flanges.csv"));
		engine.forEachRow(inputStream, item -> {
			System.out.println(item);
		});
		
	}

}
