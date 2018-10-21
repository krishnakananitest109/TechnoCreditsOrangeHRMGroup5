package com.technocredits.orangeHRM.testcases;

import com.technocredits.orangeHRM.pages.LoginPage;

public class CommonTest {
	LoginPage loginpageInstance;
	/*
	 * login method will call some abstracted methods- for launching browser and
	 * sending the locators for username, password and login-button.
	 */
	void login(String uname, String password) {
		loginpageInstance= LoginPage.getInstance();

		loginpageInstance.enterValueForLoginPage("usernameXpath", uname);
		System.out.println("Username entered-> " + uname + " successfully!");
		loginpageInstance.enterValueForLoginPage("passwordXpaht", password);
		System.out.println("Password entered-> " + password + " successfully!");
		loginpageInstance.clickOnLoginPage("loginButton");

	}
	
	String  checkURL() {
		String currentURL=loginpageInstance.checkURLOnLoginPage();
		return currentURL;
		
		
	}
}
