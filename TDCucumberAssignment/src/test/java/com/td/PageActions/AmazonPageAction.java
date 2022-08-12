package com.td.PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AmazonPageAction extends BaseActions{
	
	public AmazonPageAction() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	//Menu
    By hamburgerMenu = By.xpath("//i[@class='hm-icon nav-sprite']");
    
    //Digital Content And Devices Menu
    By kindleDCM = By.xpath("//div[text()='digital content and devices']/parent::li/following-sibling::li[3]/a/div[contains(text(),'Kindle')]");
    
    //Kindle E-Reader Menu
    By kindleERM = By.xpath("//div[text()='kindle e-readers']/parent::li/following-sibling::li[1]/a[contains(text(),'Kindle')]");
    
    
    
  
    //Getters
	public WebElement getHamburgerMenuButton() {
		return element(hamburgerMenu);
	}
	
	public WebElement getKindleFromDigitalContentAndDevicesMenu() {
		return element(kindleDCM);
	}
	
	public WebElement getKindleFromKindleEReaderMenu() {
		return element(kindleERM);
	}
	
	
	public void clickHamburgerMenu() {
		 getHamburgerMenuButton().click();
	}
	
	public void clickKindleFromDigitalContentAndDevices() {
		getKindleFromDigitalContentAndDevicesMenu().click();
	}
	
	
	public void clickKindleFromKindleEReaderMenu() {
		getKindleFromKindleEReaderMenu().click();
	}
	
	

}
