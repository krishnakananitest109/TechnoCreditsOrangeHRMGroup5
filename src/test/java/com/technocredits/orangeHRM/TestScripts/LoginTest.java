package com.technocredits.orangeHRM.TestScripts;

import java.io.IOException;

import org.testng.annotations.Test;


public class LoginTest extends CommonTest{

	/*To login 
	 * calling login() method from CommonTest by passing username and password
	 */
	@Test
	public void doLogin() throws IOException{
		login("Admin","admin123");
		System.out.println("updates");
	}
}
