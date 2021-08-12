/* $Hader: odi/odiqa/repexp/testhome/testcases/com/oracle/tests/qatests/REBrowseTabTopologyTests/selenium/REBrowseTabUpdateObjectsTests.java 
 * st_odi_smane_repexp6/1 2010/01/15 04:35:43 smane Exp $ */

/* Copyright (c) 2010, 2016, Oracle and/or its affiliates. 
All rights reserved.*/

/*
 DESCRIPTION
 <short description of component this file declares/defines>

 PRIVATE CLASSES
 <list of private classes defined - with one-line descriptions>

 NOTES
 <other useful comments, qualifications, etc.>

 CREATED    (MM/DD/YY)
  prishriv - 24/03/15 - Properties file reader created

*/
package com.operacloud.utils;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;

public class ReadProperties {
	static Map<String,String> hm=new HashMap<String, String>();
	static{
		String temp;
		System.setProperty("prop.file","config.properties");
		String fileSeparator=System.getProperty("file.separator");
		System.getProperty("prop.file");
		String filename=System.getProperty("prop.file");
		if(! (filename.startsWith("C:") || filename.startsWith("/")))
			filename=System.getProperty("build-common.dir")+fileSeparator+filename;
		try{

			System.out.println("prop.file value is "+filename);
			BufferedReader bif=new BufferedReader(new FileReader(new File(System.getProperty("prop.file"))));
			while((temp=bif.readLine())!=null){
				temp=temp.trim();
				System.out.println("Parsing property::"+temp);
				if(temp.startsWith("#") || temp.equals("") || !temp.contains("="))
					continue;
			hm.put(temp.split("=")[0].toLowerCase(), temp.split("=")[1]);
			}
		}
		catch(Exception e){
			System.out.println("Error message while reading properties file through reader :");
			e.printStackTrace();
			
		}
		
	}
	
	public static String getProperty(String key){
		if(!hm.containsKey(key.toLowerCase()))
			return null;
		return hm.get(key.toLowerCase());
	}

}
