package com.td.StepDefs;

import com.td.PageActions.SignInPageAction;


import io.cucumber.java.en.Then;


public class SignInPageStepDef {

	SignInPageAction signInPage = new SignInPageAction();
	
	
	@Then("Verify email address prompt is displayed")
	public void verifyEmailAddressIsDisplayed(){
		signInPage.verifyEnterEmailorMobilePromptExists();
	}
	
}
