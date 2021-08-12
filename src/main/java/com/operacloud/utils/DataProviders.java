package com.operacloud.utils;

import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;

/*import org.json.JSONObject;
import org.json.simple.parser.JSONParser;*/
import org.testng.annotations.DataProvider;


public class DataProviders {
	File projectdataFolder = new File("./data");

	@DataProvider(name = "loginDetails")
	public void Details() {

		File[] jsonFiles = projectdataFolder.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.equalsIgnoreCase("loginOpenTaps.json");
			}
		});
	
		System.out.println(jsonFiles.length);
		String[] data = new String[jsonFiles.length];
		for (int i = 0; i < jsonFiles.length; i++) {
			data[i] = jsonFiles[i].getPath();
		}

	}

	/*
	 * public JSONObject extractData_JSON(String file) throws Exception { FileReader
	 * reader = new FileReader(file); JSONParser jsonParser = new JSONParser();
	 * 
	 * return (JSONObject) jsonParser.parse(reader); }
	 */
}
