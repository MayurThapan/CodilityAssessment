package com.test.mayurThapan.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {


		private WebDriver driver;
		
		private By signin= By.cssSelector(".login");
		
		public HomePage(WebDriver driver){
	        this.driver = driver;
	    }

		
		public SignInPage clickSignin() {
			driver.findElement(signin).click();
		    return new SignInPage(driver);
		}
		
		
}
