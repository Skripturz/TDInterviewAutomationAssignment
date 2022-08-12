package com.td.Runner;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.td.PageActions.BaseActions;
import com.td.Utils.BaseFunctions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/FeatureFiles/", glue = "com.td.StepDefs", tags = "@smoke", plugin = {"pretty","html:target/cucumber_htmls/cucumber_report.html","json:target/cucumber/report.json"},monochrome=true)
// We can have separate runners for fixed tests, for ex: smoke, regression, etc.
public class TestRunner extends AbstractTestNGCucumberTests
{
	
	
	@BeforeClass     
	public void initiateSession()
	{
	}

	@AfterClass
	public void closeSession()
	{
	//	BaseFunctions.closeSession();
	}
	
}
