package com.test.mayurThapan.pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage {
	
	private WebDriver driver;
	
	private By orderHistory = By.cssSelector(".myaccount-link-list a[title='Orders']");
	private By clktshirt = By.cssSelector("#block_top_menu .sf-menu  a[title='T-shirts']");
	private By profileName = By.cssSelector(".header_user_info .account span");
	private By personlInfo = By.cssSelector(".myaccount-link-list a[title='Information']");
	
	

	public ProfilePage(WebDriver driver) {
		this.driver=driver;
	}

	public boolean orderHistoryButtonExist() {
		
		return driver.findElement(orderHistory).isDisplayed();
		 
	}
	
	public String  getUserName() {
		
		return driver.findElement(profileName).getText().trim();
		 
	}
	
	public TshirtCatalog clickTshirt() throws NumberFormatException, IOException{
		
		driver.findElements(clktshirt).get(1).click();
	     return new TshirtCatalog(driver);
	}

	
	public PersonalInfoPage clickPerSonalInfo() throws NumberFormatException, IOException{
		
		driver.findElement(personlInfo).click();
	     return new PersonalInfoPage(driver);
	}
}
