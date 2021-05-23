package com.test.mayurThapan.pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
	
	private WebDriver driver;
	
	private By orderHistory = By.cssSelector(".myaccount-link-list a[title='Orders']");
	private By clktshirt = By.cssSelector("#block_top_menu .sf-menu  a[title='T-shirts']");
	
	

	public ProfilePage(WebDriver driver) {
		this.driver=driver;
	}

	
	public TshirtCatalog clickTshirt() throws NumberFormatException, IOException{
		
		driver.findElements(clktshirt).get(1).click();
	     return new TshirtCatalog(driver);
	}

}
