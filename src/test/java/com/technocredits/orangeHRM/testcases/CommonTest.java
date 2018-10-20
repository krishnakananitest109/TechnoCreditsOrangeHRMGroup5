package com.technocredits.orangeHRM.testcases;

import com.technocredits.orangeHRM.pages.LoginPage;

public class CommonTest {

		void login(String uname, String password) {
			LoginPage loginpageInstance= LoginPage.getInstance();
			//Xpath for username
			loginpageInstance.enterValueForLoginPage("usernameXpath", uname);
			//Xpath for password
			loginpageInstance.enterValueForLoginPage("passwordXpaht", password);
			//Xpath for Submit button
			loginpageInstance.clickOnLoginPage("loginButton");
			
		}
}
