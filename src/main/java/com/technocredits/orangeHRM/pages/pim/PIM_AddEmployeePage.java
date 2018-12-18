package com.technocredits.orangeHRM.pages.pim;

import java.util.Properties;

import com.technocredits.orangeHRM.base.PredefinedMethods;
import com.technocredits.orangeHRM.pages.LoginPage;
import com.technocredits.orangeHRM.pojoClasses.Employee;
import com.technocredits.orangeHRM.util.PropertyFileReader;

public class PIM_AddEmployeePage extends PredefinedMethods {

	private static PIM_AddEmployeePage pim_AddEmployeeInstance;
	Properties pimPageAddEmployeeProperties;

	/*
	 * Constructor that will initialize the LoginPageProperties configuration.
	 */
	private PIM_AddEmployeePage() {
		PropertyFileReader propReader = new PropertyFileReader();
		pimPageAddEmployeeProperties = propReader.initializePropertyFile("PIM_AddEmployeeProperties");
	}

	/*
	 * getInstance method will follow singleton pattern and disallows multiple
	 * object creation.
	 * 
	 * @return returns loginPageInstance
	 */
	public static PIM_AddEmployeePage getInstance() {
		if (pim_AddEmployeeInstance == null)
			pim_AddEmployeeInstance = new PIM_AddEmployeePage();

		return pim_AddEmployeeInstance;
	}

	public String navigateToPIM_AddEmployee(){
		return getURL();
	}
	
	public void goto_PIM_AddEmployee(String Tab, String subTab) {
		expandMenu(pimPageAddEmployeeProperties.getProperty(Tab));
		click(pimPageAddEmployeeProperties.getProperty(subTab));
	}
	
	public boolean firstNameIsRequired_validate(String lastName){
		setText(pimPageAddEmployeeProperties.getProperty("lastName"), lastName);
		click(pimPageAddEmployeeProperties.getProperty("SaveButton"));
		if(fieldValidationMessageEnabled(pimPageAddEmployeeProperties.getProperty("firstName"))){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void allRequiredFields_validate(String button){
		click(pimPageAddEmployeeProperties.getProperty(button));
		fieldValidationMessageEnabled(pimPageAddEmployeeProperties.getProperty("firstName"));
	}
	
	public String addEmployeeDetails(String firstName, String middleName, String lastName, String photographLocation, boolean createLoginCrentialsOrNot){
		
		setText(pimPageAddEmployeeProperties.getProperty("firstName"), firstName);
		setText(pimPageAddEmployeeProperties.getProperty("middleName"), middleName);
		setText(pimPageAddEmployeeProperties.getProperty("lastName"), lastName);
		String empId = getAttribute(pimPageAddEmployeeProperties.getProperty("employeeId"),pimPageAddEmployeeProperties.getProperty("attributeType"));
			click(pimPageAddEmployeeProperties.getProperty("SaveButton"));
		if(getURL().contains(empId)){
			return empId;
		}else{
			return "Employee not created";
		}
		
		
	}
	
	public String addEmployeeDetails(Employee e){
		
		
		setText(pimPageAddEmployeeProperties.getProperty("firstName"), e.getFirstName());
		setText(pimPageAddEmployeeProperties.getProperty("middleName"), e.getMiddleName());
		setText(pimPageAddEmployeeProperties.getProperty("lastName"), e.getLastName());
		String empId = getAttribute(pimPageAddEmployeeProperties.getProperty("employeeId"),"value");
			click(pimPageAddEmployeeProperties.getProperty("SaveButton"));
		if(getURL().contains(empId)){
			return empId;
		}else{
			return "Employee not created";
		}
		
		
	}

	public String addLoginCredentials(String firstName, String middleName, String lastName, String username, String password){
		setText(pimPageAddEmployeeProperties.getProperty("firstName"), firstName);
		setText(pimPageAddEmployeeProperties.getProperty("middleName"), middleName);
		setText(pimPageAddEmployeeProperties.getProperty("lastName"), lastName);
		
		click(pimPageAddEmployeeProperties.getProperty("checkBoxLoginCredentials"));
		setText(pimPageAddEmployeeProperties.getProperty("username"), username);
		setText(pimPageAddEmployeeProperties.getProperty("password"), password);
		setText(pimPageAddEmployeeProperties.getProperty("confirmPassword"), password);
		
		click(pimPageAddEmployeeProperties.getProperty("SaveButton"));
		
		if(fieldValidationMessageEnabled(pimPageAddEmployeeProperties.getProperty("usernameRequiredErrorMsg"))){
			return getFieldErrorMessage(pimPageAddEmployeeProperties.getProperty("usernameRequiredErrorMsg"));
		}else{
			return "";
		}
		
		
	}
	
	public boolean verifyRequiredFieldOnAddEmployeePage(String field, String value){
		String locator = pimPageAddEmployeeProperties.getProperty(field);
		String locator_err = pimPageAddEmployeeProperties.getProperty(field+"_err");
		setText(pimPageAddEmployeeProperties.getProperty(field), value);
		click(pimPageAddEmployeeProperties.getProperty("SaveButton"));
		try {
			return verifyElementToBeVisible(locator_err);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public String validateUserName(String field, String value){
		click(pimPageAddEmployeeProperties.getProperty("checkBoxLoginCredentials"));
		String locator = pimPageAddEmployeeProperties.getProperty(field);
		String locator_err = pimPageAddEmployeeProperties.getProperty(field+"_err");
		setText(pimPageAddEmployeeProperties.getProperty(field), value);
		click(pimPageAddEmployeeProperties.getProperty("SaveButton"));
		
		try{
			if(verifyElementToBeVisible(locator_err)){
				return getText(locator_err);
			}
			
		}catch (Exception e) {
			System.out.println("element isn't visible - Username is valid");
		}
		return "username is valid";
		
	}
	
	public String navigateToPIM_EmployeeList(){
		return getURL();
	}
	
	public void searchBy(String field, String value, boolean clickonSearchButton){
		
		if(field.contains("empName") || field.contains("empId") || field.contains("supervisor")){
			setText(pimPageAddEmployeeProperties.getProperty(field), value);
		}else{
			selectValueFromDropDown(pimPageAddEmployeeProperties.getProperty(field), value);
		}
		
		
		if(clickonSearchButton){
			click(pimPageAddEmployeeProperties.getProperty("searchButton"));
		}else{
			System.out.println("no search");
		}
	}
}
