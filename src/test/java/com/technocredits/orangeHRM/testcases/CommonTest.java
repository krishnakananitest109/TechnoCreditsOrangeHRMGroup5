package com.technocredits.orangeHRM.testcases;

import com.technocredits.orangeHRM.pages.LoginPage;

public class CommonTest {

	/*
	 * login method will call some abstracted methods- for launching browser and
	 * sending the locators for username, password and login-button.
	 */
	void login(String uname, String password) {
		LoginPage loginpageInstance = LoginPage.getInstance();

		loginpageInstance.enterValueForLoginPage("usernameXpath", uname);
		System.out.println("Username entered-> " + uname + " successfully!");
		loginpageInstance.enterValueForLoginPage("passwordXpaht", password);
		System.out.println("Password entered-> " + password + " successfully!");
		loginpageInstance.clickOnLoginPage("loginButton");

		boolean loginSuccessfulFlag = loginpageInstance
				.checkURLOnLoginPage("https://opensource-demo.orangehrmlive.com/index.php/dashboard");

		if (loginSuccessfulFlag == true) {
			System.out.println("Login done successfully!");
		} else {
			System.out.println("Login Failure");
		}

	}
}
