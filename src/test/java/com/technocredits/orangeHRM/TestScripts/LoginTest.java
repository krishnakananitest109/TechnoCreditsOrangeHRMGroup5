package com.technocredits.orangeHRM.TestScripts;

import java.io.IOException;

import org.testng.annotations.Test;


public class LoginTest extends CommonTest{

	@Test
	public void doLogin() throws IOException{
		login("Admin","admin123");
		System.out.println("updates");
	}
}

