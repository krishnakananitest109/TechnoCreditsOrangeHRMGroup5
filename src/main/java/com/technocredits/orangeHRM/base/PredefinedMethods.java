package com.technocredits.orangeHRM.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


//Selenium Wrapper Class
public class PredefinedMethods {
	WebDriver driver=null;

	public void initialization() {
		System.setProperty("webdriver.chrome.driver",
				"C://chetan.phadke//Backup//Data from D//software//chromedriver_win32//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	
	public PredefinedMethods() {
		// TODO Auto-generated constructor stub

/*		driver = new ChromeDriver();*/
	}

	public void setText(String locator, String value) {
		driver.findElement(By.xpath(locator)).sendKeys(value);

	}
	public void clickOnLoginPage(String locator) {
		driver.findElement(By.xpath(locator)).click();
	}
}
