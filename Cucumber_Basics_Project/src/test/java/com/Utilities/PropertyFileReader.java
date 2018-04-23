package com.Utilities;

import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import com.config.Configuration;



public  class PropertyFileReader {

	/*Author : Arpan Saini
	USE : To get the value of a property from property config file place at location: "Config.environmentFileLocationProperty"   
	 */	

	public   String configpropertyReader(String key){

		//Code To Read the Property File		
		Properties properties = new Properties();
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(Configuration.environmentFileLocationProperty);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			//Reads a property list (key and element pairs) from the input byte stream
			properties.load(fileInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Return the value of the key passed
		return properties.getProperty(key);  
	}

	/*Author : Arpan Saini
	USE : To get the value of a property from property  file passed in the method   
	 */	

	public   String propertyFileReader(String propertyFile,  String key){

		//Code To Read the Property File		
		Properties properties = new Properties();
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(propertyFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			//Reads a property list (key and element pairs) from the input byte stream
			properties.load(fileInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Return the value of the key passed
		return properties.getProperty(key);  
	}

	
	/*Author : Arpan Saini
	  USE : To Print All properties and it's value on console from a given file   
	 */	
	public  void printAllProperties(String propertyFile){

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(Configuration.environmentFileLocationProperty);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties properties = new Properties();
		try {
			properties.load(fileInput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fileInput.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Enumeration<Object> enuKeys = properties.keys();
		while (enuKeys.hasMoreElements()) {
			String key = (String) enuKeys.nextElement();
			String value = properties.getProperty(key);
			System.out.println(key + ": " + value);


		}

	}
}
