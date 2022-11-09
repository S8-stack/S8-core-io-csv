package com.s8.io.csv.tests;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.s8.io.csv.CSV_Engine;

public class TestUnit02 {

	public static void main(String[] args) throws Exception {
		CSV_Engine<NominalPipeSize> engine = new CSV_Engine<>(NominalPipeSize.class, QxUnit.FACTORY);
		InputStream inputStream = new FileInputStream(new File("data/nominal_pipe_sizes.csv"));
		engine.forEachRow(inputStream, item -> {
			System.out.println(item);
		});
		
	}

}
