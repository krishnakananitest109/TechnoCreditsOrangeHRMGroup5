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
		/*
		 * Following alert checks if the expected and actual url for login page is same; 
		 * If both urls are different then 
		 */
		Assert.assertEquals("Expected Login URL is not matching with the Actual one.",expectedURL, actualURL);

	}

}
