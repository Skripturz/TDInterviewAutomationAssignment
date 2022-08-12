package com.td.Utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.td.PageActions.BaseActions;

import io.cucumber.java.Scenario;

public class ScreenshotGenerator extends BaseActions 
{
	static WebDriver driver;
	
	public ScreenshotGenerator(WebDriver webDriver)
	{
		this.driver=webDriver;
	}
	
	
	public static void before(Scenario scenario)
	{
		logMessage("----------------------------------------------------------------------");
		logMessage("STARING SCENARIO - " + scenario.getName());
		logMessage("----------------------------------------------------------------------");
	}
	
	
	public static void after(Scenario scenario)
	{
		if(scenario.isFailed())
			takeScreenshot(scenario);
		
		logMessage("----------------------------------------------------------------------");
		logMessage("SCENARIO RESULT - " + scenario.getName() + " : " + scenario.getStatus());
		logMessage("----------------------------------------------------------------------");
	}
	
	
	public static void takeScreenshot(Scenario scenario)
	{
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png","error.png");
	}
}
