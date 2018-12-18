package com.technocredits.orangeHRM.base;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.technocredits.orangeHRM.constant.ChromeDriverPath;
import com.technocredits.orangeHRM.constant.LoginConfigurationPath;

public class PredefinedMethods {
	static WebDriver driver;
	static WebDriverWait wait;

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
		getElement(locator).sendKeys(value);

	}

	public String getText(String locator) {
		return getElement(locator).getText();

	}
	/*
	 * click method is the wrapper method of click() for performing click action.
	 * 
	 */
	public void click(String locator) {
		WebElement element = getElement(locator);
		boolean clickableFlag = verifyElementToBeClickable(element);
		if(clickableFlag){
			element.click();
		}
		
	}

	public String getAttribute(String locator, String attributeValue) {
		return getElement(locator).getAttribute(attributeValue);
	}
	/*
	 * checkURL method check if the login is done successfully, based on comparing
	 * currentURL after login operation.
	 */
	public boolean checkURL(String URL) {
		boolean flagURL = false;
		String currentURL = driver.getCurrentUrl();
		System.out.println("Expected URL-> " + URL);
		System.out.println("Actual URL-> " + currentURL);
		if (currentURL.equalsIgnoreCase(URL)) {
			System.out.println("Both URLs are same");
			return flagURL = true;
		} else {
			System.out.println("Both URLs are not matching");
			return flagURL;
		}

	}
	
	public String getURL(){
		return driver.getCurrentUrl();
	}
	
	public String splitString(String locator, String splitRegex, int index){
		String[] arr = locator.split(splitRegex);
		return arr[index];
		
	}
	
	final private String getLocatorValue(String locator){
		return splitString(locator, "]:-",1);
	}
	
	final private String getLocatorType(String locator){
		String loactorType = splitString(locator, "]:-",0);
		return loactorType.substring(1).toUpperCase();
	}
	
	public boolean verifyElementToBeClickable(WebElement ele){
		try{
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ele));
		}catch (Exception e) {
			System.out.println("element is not clickable");
			return false;
		}
		
		return true;
		
	}
	
	public boolean verifyElementToBeVisible(String locator) throws Exception{
		
		WebElement element = getElement(locator);
		try{
			element = wait.until(ExpectedConditions.visibilityOf(element));
		}catch (Exception e) {
			System.out.println("element is not visible");
			return false;
		}
		
		return true;
		
	}
	public WebElement getElement(String locator){
		
		
		String locatorType= getLocatorType(locator);
		String locatorValue= getLocatorValue(locator);
		WebElement element=null;
		wait = new WebDriverWait(driver, 30);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		switch(locatorType){
		case "XPATH":
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
			//element=driver.findElement(By.xpath(locatorValue));
			
			
			js.executeScript("arguments[0].style.border='red solid 3px'", element);
			break;
			
		case "ID":
			element=driver.findElement(By.id(locatorValue));
			break;
			
		case "NAME":
			element=driver.findElement(By.name(locatorValue));
			break;
		case "CSSSELECTOR":
			element=driver.findElement(By.cssSelector(locatorValue));
			break;
		case "LINKTEXT":
			element=driver.findElement(By.linkText(locatorValue));
			break;
		case "PARTIALLINKTEXT":
			element=driver.findElement(By.partialLinkText(locatorValue));
			break;
		}
	
		
		
		return element;
	}
	
	public void expandMenu(String locator){
		Actions action = new Actions(driver);
		
		action.moveToElement(getElement(locator)).build().perform();
		
	}
	
	public boolean fieldValidationMessageEnabled(String locator){
		String newlocator=locator+"/following::span[1]";
		if(getElement(newlocator).isEnabled()){
			//getFieldErrorMessage(locator);
			return true;
		}
		else{
			return false;
		}
	}
	
	public String getFieldErrorMessage(String locator){
		String newLocator = locator+"/following::span[1]";
		return getElement(newLocator).getText();
	}
	
	public void selectValueFromDropDown(String locator, String value) {
		
		Select dropDown = new Select(getElement(locator));
		dropDown.selectByVisibleText(value);
	}

	
}
