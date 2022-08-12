package com.td.StepDefs;

import com.td.Utils.PropFileHandler;
import com.td.PageActions.AmazonPageAction;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class AmazonPageStepDef {

	AmazonPageAction amazonPage = new AmazonPageAction();
	
	
	@Given("Launch website")
	public void launch()
	{
		amazonPage.launchApplication(PropFileHandler.readProperty("appUrl"));
	}
	
	
	@When("search for kindle reader")
	public void buyNowKindleReader() {
		amazonPage.clickHamburgerMenu();
		amazonPage.clickKindleFromDigitalContentAndDevices();
		amazonPage.clickKindleFromKindleEReaderMenu();
		
	}
	   
}
