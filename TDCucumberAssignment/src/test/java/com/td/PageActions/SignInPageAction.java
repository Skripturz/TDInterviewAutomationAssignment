package com.td.PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;


public class SignInPageAction extends BaseActions{
	
	public SignInPageAction() {
		super();
	}
	
	//Label for E-mail address or mobile phone number
    By enterEmailorMobileLabel = By.xpath("//label[contains(text(),'E-mail address or mobile phone number')]");
    
  
 
    //Getters
	public WebElement getEnterEmailorMobileLabel() {
		return element(enterEmailorMobileLabel);
	}
	
	public void verifyEnterEmailorMobilePromptExists() {
		
		Assert.assertTrue(getEnterEmailorMobileLabel().isDisplayed());
	}
	

}
