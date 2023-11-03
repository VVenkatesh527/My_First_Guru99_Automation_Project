package com.java.properties.concepts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException; 
import java.util.Properties;

public class readfileProperties {

	public static void main(String[] args) throws FileNotFoundException {
		try {
			readFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void readFile() throws IOException {
		
		String filePath = System.getProperty("user.dir") + "\\venkatesh.properties";
		File fileName = new File(filePath);
		FileInputStream iptStream  = new FileInputStream(fileName);
		Properties getprop = new Properties();
		getprop.load(iptStream);
		System.out.println(getprop.getProperty("browser"));
	}
	
}