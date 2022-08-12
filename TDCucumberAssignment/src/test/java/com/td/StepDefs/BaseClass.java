package com.td.StepDefs;

import com.td.PageActions.BaseActions;
import com.td.Utils.BaseFunctions;

import io.cucumber.core.gherkin.Step;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BaseClass {
	
	static int flow=0;
	
	@Before
	public void before() {
		flow=0;
	}
	
	@After
	public void after(Scenario scenario) {
		if(scenario.isFailed()) {
			System.out.println("failing step--"+scenario.getName());
			final byte[] screenshot = BaseActions.takeScreenshot();
		    scenario.attach(screenshot, "image/png",scenario.getName()+".png");
		   
		} BaseFunctions.closeSession();
		
	}
	
	@AfterStep
	public void afterStep(Scenario scenario) {
		BaseActions.takeScreenshotAfterStep(String.valueOf(flow)+"of"+scenario.getName());
		flow++;
		
	}
	
	

}
