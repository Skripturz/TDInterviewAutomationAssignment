package com.td.PageActions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.td.Utils.BaseFunctions;
import com.td.Utils.PropFileHandler;

import io.cucumber.java.Scenario;

public class BaseActions extends BaseFunctions
{
	public static WebDriver driver;
	public static String browser;
	PropFileHandler obj;
	
	
//	public BaseClass()
//	{
//		super(driver);
//	}
	
	
//	public void initializeSession()
//	{
//		logMessage("**************************************** Session Started *****************************************");
//		obj = new PropFileHandler();
//		
//		browser=PropFileHandler.readProperty("browser");
//		
//		logMessage("Browser is: "+browser.toUpperCase());
//		
//		System.setProperty("webdriver.chrome.driver","src/test/resources/SeleniumWebdrivers/chromedriver.exe");
//		driver = new ChromeDriver();
//		
////		driver.manage().window().maximize();
////		driver.manage().deleteAllCookies();
////		driver.manage().timeouts().implicitlyWait(Integer.parseInt(PropFileHandler.readProperty("implicitTimeout")), TimeUnit.SECONDS);
////		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(PropFileHandler.readProperty("pageLoadTimeout")), TimeUnit.SECONDS);
//		//Screenshot generator
//	}
//	
//	
//	public void closeSession()
//	{
//		driver.quit();
//		logMessage("*************************************** Session Closed **************************************");
//	}
//	
//	
//	public void launchApplication(String url)
//	{	initializeSession();
//		driver.get(url);
//		logMessage("Product URL: "+url);
//	}
	
	public static byte[] takeScreenshot()
	{	driver=BaseFunctions.driver;
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
	
	public static void takeScreenshotAfterStep(String step) {
		driver=BaseFunctions.driver;
		File screenshot= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+File.separator+"target"+File.separator+"ScreenshotAfterStep"+File.separator+getCurrentTimestamp()+"Step_"+step+".png");
		
		try {
			FileUtils.copyFile(screenshot, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
