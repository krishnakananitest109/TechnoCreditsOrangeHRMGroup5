package com.technocredits.orangeHRM.reports;

import java.io.File;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Demo1 {
	
	@Test
	public void demoTest(){
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(new File(".//reports//Pim.html"));
		ExtentReports extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		
		ExtentTest logger = extent.createTest("DemoTest1");
		logger.log(Status.INFO, "login");
		logger.log(Status.PASS, "title verified");
		
		extent.flush();
		
		ExtentTest logger1 = extent.createTest("DemoTest2");
		logger1.log(Status.FAIL, "tets failed");
		
		extent.flush();
		
	}

}
