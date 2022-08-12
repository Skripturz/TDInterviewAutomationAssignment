package com.td.PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class AmazonProductPageAction extends BaseActions{
	
	public AmazonProductPageAction() {
		super();
	}
	
	//Buy Now
    By buyNowButton = By.xpath("//span[@id='submit.buy-now']");

    
    //Getters
	public WebElement getBuyNowButton() {
		return element(buyNowButton);
	}
	
	
	public void clickBuyNowButton() {
		getBuyNowButton().click();
	}

	

}
