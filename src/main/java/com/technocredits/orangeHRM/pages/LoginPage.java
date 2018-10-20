package com.technocredits.orangeHRM.pages;

import java.io.IOException;
import java.util.Properties;

import com.technocredits.orangeHRM.base.PredefinedMethods;
import com.technocredits.orangeHRM.util.PropertyFileReader;

public class LoginPage extends PredefinedMethods{
	private static LoginPage loginPage = null;
	Properties loginPageProperties;
	
	private LoginPage() throws IOException{
		initializeBrowser();
		PropertyFileReader propreader = new PropertyFileReader();
		loginPageProperties = propreader.initializePropertyFile("LoginPageProperties");
	}
	
	public static LoginPage getInstance() throws IOException{
		if(loginPage == null)
			loginPage = new LoginPage();
		return loginPage;
	}
	public void enterValueForLoginPage(String locator, String value){
		setText(loginPageProperties.getProperty(locator),value);
	}
	
	public void clickOnLoginPage(String locator){
		click(loginPageProperties.getProperty(locator));
	}
	
}

