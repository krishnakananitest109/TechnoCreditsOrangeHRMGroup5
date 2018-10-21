package com.technocredits.orangeHRM.constant;

import java.io.File;

public class LoginConfigurationPath {
	/*
	 * PROPERTIES variable holds the path for LoginPageProperties file, It is used
	 * in PropertyFileReader for reading the configuration.
	 */
	public static final String PROPERTIES = System.getProperty("user.dir") + File.separator + "src" + File.separator
			+ "main" + File.separator + "java" + File.separator + "com" + File.separator + "technocredits"
			+ File.separator + "orangeHRM" + File.separator + "config";
}
