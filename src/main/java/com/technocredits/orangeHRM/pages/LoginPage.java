package com.technocredits.orangeHRM.pages;

import java.io.IOException;
import java.util.Properties;

import com.technocredits.orangeHRM.base.PredefinedMethods;
import com.technocredits.orangeHRM.util.PropertyFileReader;

public class LoginPage extends PredefinedMethods{
	private static LoginPage loginPage;
	Properties loginPageProperties;
	
	/*Making constructor as private for LoginPage, so no one would be able to create object for LoginPage directly. 
	 *We want only 1 single instance to be created. Creating object from getInstance() method.
	 */
	private LoginPage() throws IOException{
		initializeBrowser();
		PropertyFileReader propreader = new PropertyFileReader();
		loginPageProperties = propreader.initializePropertyFile("LoginPageProperties");
	}
	
	/*To create instance for LoginPage, using singleton design pattern, 
	 * if Object is already created, return that, else create new instance.
	 */
	
	public static LoginPage getInstance() throws IOException{
		if(loginPage == null)
			loginPage = new LoginPage();
		return loginPage;
	}
	
	/* Generic method to enter value into login page */
	
	public void enterValueForLoginPage(String locator, String value){
		setText(loginPageProperties.getProperty(locator),value);
	}
	
	/*Method to click on login page after enetering username and password */
	
	public void clickOnLoginPage(String locator){
		click(loginPageProperties.getProperty(locator));
	}
	
}

