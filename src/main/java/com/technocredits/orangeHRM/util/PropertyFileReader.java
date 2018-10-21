package com.technocredits.orangeHRM.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.technocredits.orangeHRM.constant.LoginConfigurationPath;

public class PropertyFileReader {

	Properties prop;

	/*
	 * Below method will load the LoginPageProperties that will read Locators for
	 * Login Page only.
	 * 
	 * @param propFileName will load the Configurations file and read the key, value
	 * from the file.
	 * 
	 * @return loginPageProperties object.
	 */
	public Properties initializePropertyFile(String propFileName) {

		File file = new File(LoginConfigurationPath.PROPERTIES + File.separator + propFileName + ".properties");
		try {
			FileInputStream input = new FileInputStream(file);
			// Creating the property class Reference.
			prop = new Properties();
			// load method will read property list in key, value pairs.
			prop.load(input);

		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
		return prop;
	}
}
