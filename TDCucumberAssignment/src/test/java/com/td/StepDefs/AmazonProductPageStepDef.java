package com.td.StepDefs;

import com.td.PageActions.AmazonProductPageAction;

import io.cucumber.java.en.And;

public class AmazonProductPageStepDef {

	AmazonProductPageAction amazonProductPage = new AmazonProductPageAction();
	
	
	@And("Click buy now")
	public void buyNowKindleReader() {
		amazonProductPage.clickBuyNowButton();
		
	}
	
	
    
}
