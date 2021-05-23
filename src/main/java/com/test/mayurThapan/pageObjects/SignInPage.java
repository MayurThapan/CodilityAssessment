package com.test.mayurThapan.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
	
	private WebDriver driver;
	private By userName = By.id("email");
	private By passWord = By.id("passwd");
	private By submit = By.id("SubmitLogin");
	

	public SignInPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void setUsername(String username){
		driver.findElement(userName).sendKeys(username);
	}
	
	public void setPassword(String password){
	    driver.findElement(passWord).sendKeys(password);
	}
	
	public ProfilePage clickLoginButton(){
	     driver.findElement(submit).click();
	     return new ProfilePage(driver);
	}

}
