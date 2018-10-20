package com.technocredits.orangeHRM.testcases;

import org.testng.annotations.Test;

public class LoginTest extends CommonTest {

	@Test

	public void loginTest() {
		login("Admin", "admin123");

	}

}
