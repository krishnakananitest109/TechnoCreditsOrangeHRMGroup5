package com.technocredits.orangeHRM.testcases;

import org.testng.annotations.Test;

public class LoginTest extends CommonTest {

	@Test
	/*
	 * Below method will perform Login on OrangeHRM Login Page
	 * 
	 * @param username and password for login.
	 */
	public void loginTest() {
		login("Admin", "admin123");

	}

}
