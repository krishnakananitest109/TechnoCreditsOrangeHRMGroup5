package com.technocredits.orangeHRM.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.technocredits.orangeHRM.pages.pim.PIM_AddEmployeePage;
import com.technocredits.orangeHRM.pojoClasses.Employee;
import com.technocredits.orangeHRM.util.TestDataFromExcel;

public class PIM_AddEmployee extends CommonTest {
	
	String empId;
	
	//positive test
	
	void verifyUserIsAbleToNavigateToAddEmployee(){
		login("Admin", "admin123");
		PIM_AddEmployeePage pimAddEmployeeInstance = goTo_PIM_AddEmployee("AddEmployeeTab");
		String actualURL = pimAddEmployeeInstance.navigateToPIM_AddEmployee();
		String expectedURL = "https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee";
		Assert.assertEquals(actualURL, expectedURL);
		
	}
	
	//negative test
	void verifyFirstNameAndLastNameIsRequired(){
		login("Admin", "admin123");
		PIM_AddEmployeePage pimAddEmployeeInstance = goTo_PIM_AddEmployee("AddEmployeeTab");
		String actualURL = pimAddEmployeeInstance.navigateToPIM_AddEmployee();
		String expectedURL = "https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee";
		Assert.assertEquals(actualURL, expectedURL);
		
		//fieldIsRequired(pimAddEmployeeInstance);
	}
	

	void verifyFirstNameIsRequired(){
		login("Admin", "admin123");
		PIM_AddEmployeePage pimAddEmployeeInstance = goTo_PIM_AddEmployee("AddEmployeeTab");
		String actualURL = pimAddEmployeeInstance.navigateToPIM_AddEmployee();
		String expectedURL = "https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee";
		Assert.assertEquals(actualURL, expectedURL);
		
		boolean isFieldRequired = fieldIsRequired(pimAddEmployeeInstance,"firstName","Parmar");
		Assert.assertTrue(isFieldRequired, "FirstName is required");
		System.out.println("First name is required");
	}
	
	
	void verifyLastNameIsRequired(){
		login("Admin", "admin123");
		PIM_AddEmployeePage pimAddEmployeeInstance = goTo_PIM_AddEmployee("AddEmployeeTab");
		String actualURL = pimAddEmployeeInstance.navigateToPIM_AddEmployee();
		String expectedURL = "https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee";
		Assert.assertEquals(actualURL, expectedURL);
		
		boolean isFieldRequired = fieldIsRequired(pimAddEmployeeInstance,"lastName","Alisha");
		Assert.assertTrue(isFieldRequired, "LastName is required");
		System.out.println("Last name is required");
	}
	
	
	void addEmployee(){
		login("Admin", "admin123");
		PIM_AddEmployeePage pimAddEmployeeInstance = goTo_PIM_AddEmployee("AddEmployeeTab");
		String actualURL = pimAddEmployeeInstance.navigateToPIM_AddEmployee();
		String expectedURL = "https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee";
		Assert.assertEquals(actualURL, expectedURL);
		
		empId = pimAddEmployeeInstance.addEmployeeDetails("Alisha", "", "Parmar","",false);
		System.out.println("Employee ID-"+empId);
	}
	
	
	void verifyUserNameIsValid(){
		login("Admin", "admin123");
		PIM_AddEmployeePage pimAddEmployeeInstance = goTo_PIM_AddEmployee("AddEmployeeTab");
		String actualURL = pimAddEmployeeInstance.navigateToPIM_AddEmployee();
		String expectedURL = "https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee";
		Assert.assertEquals(actualURL, expectedURL);
		
		//pimAddEmployeeInstance.addEmployeeDetails("Alisha", "", "Parmar");
		String actualErr = pimAddEmployeeInstance.validateUserName("username","Alis");
		String expectedErr = "Should have at least 5 characters";
		
		Assert.assertEquals(actualErr, expectedErr);
		 
	}
	
	
	void verifyRequiredField_FirstName(){
		login("Admin", "admin123");
		PIM_AddEmployeePage pimAddEmployeeInstance = goTo_PIM_AddEmployee("AddEmployeeTab");
		String actualURL = pimAddEmployeeInstance.navigateToPIM_AddEmployee();
		String expectedURL = "https://opensource-demo.ora"
				+ "ngehrmlive.com/index.php/pim/addEmployee";
		Assert.assertEquals(actualURL, expectedURL);
		
		boolean flag = pimAddEmployeeInstance.verifyRequiredFieldOnAddEmployeePage("firstName", "");
		Assert.assertTrue(flag);
	}
	
	
	void verifyRequiredField_LastName(){
		login("Admin", "admin123");
		PIM_AddEmployeePage pimAddEmployeeInstance = goTo_PIM_AddEmployee("AddEmployeeTab");
		String actualURL = pimAddEmployeeInstance.navigateToPIM_AddEmployee();
		String expectedURL = "https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee";
		Assert.assertEquals(actualURL, expectedURL);
		
		boolean flag = pimAddEmployeeInstance.verifyRequiredFieldOnAddEmployeePage("lastName", "");
		Assert.assertTrue(flag);
	}
	
	
	void verifyRequiredField_UserName(){
		login("Admin", "admin123");
		PIM_AddEmployeePage pimAddEmployeeInstance = goTo_PIM_AddEmployee("AddEmployeeTab");
		String actualURL = pimAddEmployeeInstance.navigateToPIM_AddEmployee();
		String expectedURL = "https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee";
		Assert.assertEquals(actualURL, expectedURL);
		
		boolean flag = pimAddEmployeeInstance.verifyRequiredFieldOnAddEmployeePage("username", "");
		Assert.assertTrue(flag);
	}
	
	//With pojo class
	
	void addEmployeeWithPojo(){
		login("Admin", "admin123");
		PIM_AddEmployeePage pimAddEmployeeInstance = goTo_PIM_AddEmployee("AddEmployeeTab");
		String actualURL = pimAddEmployeeInstance.navigateToPIM_AddEmployee();
		String expectedURL = "https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee";
		Assert.assertEquals(actualURL, expectedURL);
		
		Employee emp = new Employee();
		emp.setFirstName("Alisha");
		emp.setMiddleName("");
		emp.setLastName("Parmar");
		empId = pimAddEmployeeInstance.addEmployeeDetails(emp);
		System.out.println("Employee ID-"+empId);
	}
	
	@Test(dataProvider="ExcelReaddata")
	void searchEmployee(String empName, String id, String employmentStatus, String supervisorname, String subUnit, String currentStatus, String a){
		login("Admin", "admin123");
		PIM_AddEmployeePage pimAddEmployeeInstance = goTo_PIM_AddEmployee("employeeListtab");
		String actualURL = pimAddEmployeeInstance.navigateToPIM_EmployeeList();
		String expectedURL = "https://opensource-demo.orangehrmlive.com/index.php/pim/viewEmployeeList/reset/1";
		Assert.assertEquals(actualURL, expectedURL);
		
		
		pimAddEmployeeInstance.searchBy("empNameSearch", empName, false);
		pimAddEmployeeInstance.searchBy("empIdSearch", id, true);
		
		//pimAddEmployeeInstance.searchBy("employmentStatusSearch", "Full-Time Permanent", true);
	}
	
	@DataProvider(name="ExcelReaddata")
	public String[][] readExcelData() throws IOException{
		
		TestDataFromExcel testDataFromExcel = new TestDataFromExcel("D:\\OCT_Framework_New workspace_PIM\\TechnoCreditsOrangeHRMGroup5\\Test data\\Testdata_Assignment1.xlsx","data");
		
		String[][] testData = testDataFromExcel.getData();
		return testData;
	}
}
