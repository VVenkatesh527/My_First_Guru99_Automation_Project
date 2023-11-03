package com.java.properties.concepts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	public static FileInputStream inputstream = null;
	
	public static void main(String[] args) {

		
		String filePath = System.getProperty("user.dir")+"\\venkatesh.properties";
		System.out.println(filePath);
		
		File file = new File(filePath);
		System.out.println(" File Object ---> " +file);
		
		try {
			inputstream	 = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("File InputStream ---> " +inputstream);
		Properties prop = new Properties();
		
        try {
			prop.load(inputstream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Property Load  ---> " +prop);
		
	
	}
}