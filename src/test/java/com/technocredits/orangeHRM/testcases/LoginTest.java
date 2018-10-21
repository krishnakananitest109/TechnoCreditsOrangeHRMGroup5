package com.technocredits.orangeHRM.testcases;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class LoginTest extends CommonTest {

	@Test
	/*
	 * Below method will perform Login on OrangeHRM Login Page
	 * 
	 * @param username and password for login.
	 */
	public void loginTest() {
		login("Admin", "admin123");
		String expectedURL="https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		String actualURL=checkURL();
		
		Assert.assertEquals(expectedURL, actualURL);

	}

}
