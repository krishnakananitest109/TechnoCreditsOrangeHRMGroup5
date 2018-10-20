package com.technocredits.orangeHRM.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

	Properties prop=null;
	public Properties initializePropertyFile(String propFileName) {
		
		File file=new File(propFileName+".properties");
		try {
			System.out.println("Null pointer");
			FileInputStream input= new FileInputStream(file);
			
			prop=new Properties();
			
			prop.load(input);
			System.out.println(prop.getProperty("Username is herr- "+"usernameXpath"));
		}catch(FileNotFoundException e) {
			e.getMessage();
		}
		catch(IOException e) {
			e.getMessage();
		}
		return prop;
	}
}
