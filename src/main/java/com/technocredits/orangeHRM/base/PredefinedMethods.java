package com.technocredits.orangeHRM.base;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.technocredits.orangeHRM.constant.ChromeDriverPath;
import com.technocredits.orangeHRM.constant.LoginConfigurationPath;

public class PredefinedMethods {
	WebDriver driver;

	/*
	 * initialization method launches browser, Chrome browser for now. It opens the
	 * OrangeHRM demo site.
	 * 
	 */
	public void initialization() {
		System.setProperty("webdriver.chrome.driver",
				ChromeDriverPath.PROPERTIES + File.separator + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	/*
	 * setText method is the wrapper method of sendKeys() for adding Text to
	 * TextField.
	 * 
	 */
	public void setText(String locator, String value) {
		driver.findElement(By.xpath(locator)).sendKeys(value);

	}

	/*
	 * click method is the wrapper method of click() for performing click action.
	 * 
	 */
	public void click(String locator) {
		driver.findElement(By.xpath(locator)).click();
	}

	/*
	 * checkURL method check if the login is done successfully, based on comparing
	 * currentURL after login operation.
	 */
	public String getURL() {
		
		String currentURL = driver.getCurrentUrl();
		
		return currentURL;
	}
}
