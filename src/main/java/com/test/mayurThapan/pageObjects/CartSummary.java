package com.test.mayurThapan.pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.test.mayurThapan.utills.BaseActions;

public class CartSummary extends BaseActions{
	
	private WebDriver driver;
	
	private By sumryPTC = By.cssSelector(".standard-checkout");
	private By addressPTC = By.cssSelector("button[name='processAddress']");
	private By shipPTC = By.cssSelector("button[name='processCarrier']");
	private By trms = By.cssSelector("#uniform-cgv input");
	private By pymt = By.cssSelector(".payment_module .bankwire");
	private By cnfmOrdr = By.cssSelector(".cart_navigation [type='submit']");
	private By bkToOrder = By.cssSelector(".cart_navigation [title='Back to orders']");
	private By box = By.className("box");
	
	
	public CartSummary(WebDriver driver) throws NumberFormatException, IOException {
		super(driver);
		
		this.driver=driver;
	}
	
	public void sumryPTCclick() {
		waitForElementToBeVisible(driver.findElement(sumryPTC));
		driver.findElement(sumryPTC).click();
	}
	
	public void addressPTCclick() {
		waitForElementToBeVisible(driver.findElement(addressPTC));
		driver.findElement(addressPTC).click();
	}
	
	public void trmsCheck() {
		scrollDown(driver.findElement(trms));
		driver.findElement(trms).click();
	}
	
	public void shipPTCclick() {
		waitForElementToBeVisible(driver.findElement(shipPTC));
		driver.findElement(shipPTC).click();
	}
	
	public void pymtclick() {
		waitForElementToBeVisible(driver.findElement(pymt));
		driver.findElement(pymt).click();
	}
	
	public void cnfmOrdrClick() {
		waitForElementToBeVisible(driver.findElement(cnfmOrdr));
		driver.findElement(cnfmOrdr).click();
	}
	
	public String getOrderReference() {
		
		return (driver.findElement(box).getText().split("your order reference ")[1]
				.split(" in the subject")[0].trim());
		
	}
	
	
	public OrderHistory clickbkToOrder() throws NumberFormatException, IOException{
		
		waitForElementToBeVisible(driver.findElement(bkToOrder));
	     driver.findElement(bkToOrder).click();
	     return new OrderHistory(driver);
	}

}
