package com.technocredits.orangeHRM.TestScripts;

import java.io.IOException;

import com.technocredits.orangeHRM.base.PredefinedMethods;
import com.technocredits.orangeHRM.pages.LoginPage;

public class CommonTest extends PredefinedMethods{

	void login(String username,String password) throws IOException{
		LoginPage loginpageInstance = LoginPage.getInstance();
		loginpageInstance.enterValueForLoginPage("usernameTextfield", username);
		loginpageInstance.enterValueForLoginPage("passwordTextfield", password);
		loginpageInstance.clickOnLoginPage("loginButton");
		
		
	}
	
	
}