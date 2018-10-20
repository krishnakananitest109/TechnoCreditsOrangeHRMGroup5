package com.technocredits.orangeHRM.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.technocredits.orangeHRM.constant.CONSTANT;

public class PropertyFileReader {
	
	Properties prop = null;
	
	public Properties initializePropertyFile(String propFileName) throws IOException{
		File file = new File(CONSTANT.PROPERTIES+ File.separator +propFileName + ".properties");
		
		FileInputStream input = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(input);
		
		return prop;
	}

}
