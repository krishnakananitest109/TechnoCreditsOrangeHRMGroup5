package com.technocredits.orangeHRM.reports;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.technocredits.orangeHRM.constant.ChromeDriverPath;

public class ReportClass {
	
	String s = "maulik";
	static WebDriver driver;
	ExtentReports extent;
	ExtentTest logger;
	
	@BeforeMethod
	public void beforeTest()
	{
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(new File(".//reports/mmk-oct18.html"));
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
	}
	
	@Test
	public void doTest()
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\maulik.kanani\\Downloads\\3rd_Party_Jars\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("http://automationbykrishna.com");
		 driver.manage().window().maximize();
		 Assert.assertEquals(true, false);
	}
	
	public static String getScreenshot()
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		String path=System.getProperty("user.dir")+"/Screenshot/mmk_"+System.currentTimeMillis()+".png";
		
		File destination=new File(path);
		
		try 
		{
			FileUtils.copyFile(src, destination);
		} catch (IOException e) 
		{
			System.out.println("Capture Failed "+e.getMessage());
		}
		
		return path;
	}
	
	@AfterMethod
	public void afterTest(ITestResult result) throws IOException
	{
		logger=extent.createTest(result.getMethod().getMethodName());
		System.out.println(ITestResult.FAILURE);
		if(result.getStatus() == ITestResult.FAILURE)
		{
			String temp=getScreenshot();
			logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			//logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		extent.flush();
		driver.quit();
	}
	
}

