package com.technocredits.orangeHRM.pages;


import java.util.Properties;

import com.technocredits.orangeHRM.util.PropertyFileReader;

public class LoginPage extends com.technocredits.orangeHRM.base.PredefinedMethods {

	private static LoginPage loginPageInstance = null;
	Properties loginPageProperties;

	/*
	 * Constructor that will initialize the LoginPageProperties configuration.
	 */
	private LoginPage() {
		initialization();
		PropertyFileReader propReader = new PropertyFileReader();
		loginPageProperties = propReader.initializePropertyFile("LoginPageProperties");
	}

	/*
	 * getInstance method will follow singleton pattern and disallows multiple
	 * object creation.
	 * 
	 * @return returns loginPageInstance
	 */
	public static LoginPage getInstance() {
		if (loginPageInstance == null)
			loginPageInstance = new LoginPage();

		return loginPageInstance;
	}

	/*
	 * enterValueForLoginPage method sends the locator and value to be entered for
	 * login.
	 */
	public void enterValueForLoginPage(String key, String value) {
		setText(loginPageProperties.getProperty(key), value);
	}

	/*
	 * clickOnLoginPage method sends the locator for submit button for performing
	 * submit action.
	 */
	public void clickOnLoginPage(String key) {
		click(loginPageProperties.getProperty(key));
	}

	/*
	 * Confirms that login is done successful by checking the Existing URL with
	 * hardcoded one.
	 * 
	 */
	public String checkURLOnLoginPage() {
		
		 String URL = getURL();
		 return URL; 
  }


}
