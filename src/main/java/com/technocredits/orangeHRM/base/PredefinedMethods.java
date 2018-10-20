package com.technocredits.orangeHRM.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedMethods {
	static WebDriver driver;
	
	/*public PredefinedMethods() {
		driver = new ChromeDriver();
	}*/
	public void initializeBrowser(){
		if(driver == null){
			System.setProperty("webdriver.chrome.driver", "D:\\OrangeHRM\\OrangeHRM\\src\\main\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			//driver = new FirefoxDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		}
			
	}
	
	public void setText(String locator, String value){
		driver.findElement(By.xpath(locator)).sendKeys(value);
	}
	
	public void click(String locator){
		driver.findElement(By.xpath(locator)).click();
	}
}
