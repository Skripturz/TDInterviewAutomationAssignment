package com.td.Utils;

import java.text.Format;
import org.openqa.selenium.JavascriptExecutor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class BaseFunctions 
{
	public static WebDriver driver;
	public static String browser;
	PropFileHandler obj;
//	protected BaseFunctions(WebDriver webDriver)
//	{
//		this.driver=webDriver;
//	}
	
	public static void logMessage(String msg)
	{
		Reporter.log(msg, true);
	}
	
	protected void hardWait(int sec)
	{
		try {
			Thread.sleep(sec*1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void waitToSync()
	{
		try {
			Thread.sleep(2000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	protected static String getCurrentTimestamp()
	{
		Format formatter = new SimpleDateFormat("ddMMyyHHmmss");
		String timestamp = formatter.format(new Date());
		return timestamp;
	}
	
	public static String getCurrentTimestamp(String format)
	{
		Format formatter = new SimpleDateFormat(format);
		String timestamp = formatter.format(new Date());
		return timestamp;
	}
	
	protected void clickUsingJS(By elem)
	{
		WebElement e = element(elem);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", e);
	}
	
	
	protected void executeJS(String script)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(script);
	}
	
	
	protected void scrollIntoElement(By elem)
	{
		WebElement element = element(elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	protected void scrollIntoElement(WebElement elem)
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem);
	}
	
	
	protected List<WebElement> elements(By elementToken)
	{
		return driver.findElements(getLocator(elementToken, ""));
	}
	
	
	protected WebElement element(By elementToken)
	{   hardWait(2);// putting hard wait for demo purpose
		return driver.findElement(getLocator(elementToken, ""));
	}
	
	
	protected By getLocator(By elementToken, String replacement)
	{
		if (!replacement.isEmpty())
		{
			String loc = elementToken.toString().replaceAll("\'", "\\\"");
			String type = loc.split(":", 2)[0].split(",")[0].split("\\.")[1];
			String variable = loc.split(":", 2)[1].replaceAll("\\$\\{.+?\\}", replacement);
			return getBy(type, variable);
		}
		
		else
			return elementToken;
	}
	
	
	private By getBy(String locatorType, String locatorValue)
	{
		switch (Locators.valueOf(locatorType)) 
		{
		case id:
			return By.id(locatorValue);
		case xpath:
			return By.xpath(locatorValue);
		case css:
		case cssSelector:
			return By.cssSelector(locatorValue);
		case name:
			return By.name(locatorValue);
		case classname:
			return By.className(locatorValue);
		case linktext:
			return By.linkText(locatorValue);
		default:
			return By.id(locatorValue);
		}
	}
	public void initializeSession()
	{
		logMessage("**************************************** Session Started *****************************************");
		obj = new PropFileHandler();
		
		browser=obj.readProperty("browser");
		
		logMessage("Browser is: "+browser.toUpperCase());
		
		System.setProperty("webdriver.chrome.driver","src/test/resources/SeleniumWebdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(Integer.parseInt(PropFileHandler.readProperty("implicitTimeout")), TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(PropFileHandler.readProperty("pageLoadTimeout")), TimeUnit.SECONDS);
		//Screenshot generator
	}
	
	
	public static void closeSession()
	{
		driver.quit();
		logMessage("*************************************** Session Closed **************************************");
	}
	
	
	public void launchApplication(String url)
	{	initializeSession();
	   System.out.println(url);
		driver.get(url);
		logMessage("Product URL: "+url);
	}
	
	
	public void waitForElementToBeVisible(By locator) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
