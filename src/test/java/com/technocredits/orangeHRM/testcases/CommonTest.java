package com.technocredits.orangeHRM.testcases;

import com.technocredits.orangeHRM.pages.LoginPage;
import com.technocredits.orangeHRM.pages.pim.PIM_AddEmployeePage;

public class CommonTest {

	/*
	 * login method will call some abstracted methods- for launching browser and
	 * sending the locators for username, password and login-button.
	 */
	void login(String uname, String password) {
		LoginPage loginpageInstance = LoginPage.getInstance();
		loginpageInstance.enterValueForLoginPage("usernameXpath", uname);
		System.out.println("Username entered-> " + uname + " successfully!");
		loginpageInstance.enterValueForLoginPage("passwordXpath", password);
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
	
	
	public PIM_AddEmployeePage goTo_PIM_AddEmployee(String subtab){
		PIM_AddEmployeePage pimAddEmployeeInstance = PIM_AddEmployeePage.getInstance();
		
		pimAddEmployeeInstance.goto_PIM_AddEmployee("PIMTab",subtab);
		return pimAddEmployeeInstance;
	}
	
	public void allRequiredFields(PIM_AddEmployeePage pimAddEmployeeInstance){
		
		//pimAddEmployeeInstance.fieldIsRequired_validate("SaveButton");
	}
	
	public boolean fieldIsRequired(PIM_AddEmployeePage pimAddEmployeeInstance, String fieldName, String value){
		
		if(fieldName=="firstName"){
			if(pimAddEmployeeInstance.firstNameIsRequired_validate(fieldName)){

				return true;
			}
			else{
				return false;
			}
		}else if(fieldName=="lastName"){
			if(pimAddEmployeeInstance.firstNameIsRequired_validate(fieldName)){

				return true;
			}
			else{
				return false;
			}
		}
		return false;
		
	}
	
	
}
