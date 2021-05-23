package com.test.mayurThapan.pageObjects;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.test.mayurThapan.utills.BaseActions;

public class PersonalInfoPage extends BaseActions {

	private WebDriver driver;
	private By fstname = By.id("firstname");
	private By passwd = By.id("old_passwd");
	private By submit = By.cssSelector(".form-group .button-medium");
	private By updatedProfileName = By.cssSelector(".header_user_info .account span");
	
	private By successText = By.cssSelector(".alert.alert-success");
	
	public PersonalInfoPage(WebDriver driver) throws NumberFormatException, IOException {
		super (driver);
		this.driver=driver;
	}

	public void setFirstname(String username){
		driver.findElement(fstname).clear();
		driver.findElement(fstname).sendKeys(username);
	}
	
	public void setPasswd(String username){
		driver.findElement(passwd).sendKeys(username);
	}
	

	
	public void clickSubmitButton(){
		
		driver.findElement(submit).click();
		waitForElementToBeVisible(driver.findElement(successText));
	}
	
	public String  getUpdatedUserName() {
		return driver.findElement(updatedProfileName).getText().trim()
				.split("\\s+")[0].trim();
	}
	
	public String  getSuccessLableText() {
		return driver.findElement(successText).getText().trim();
	}
	
}
