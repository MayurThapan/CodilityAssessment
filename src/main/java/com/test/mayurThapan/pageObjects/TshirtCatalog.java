package com.test.mayurThapan.pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.test.mayurThapan.utills.BaseActions;

public class TshirtCatalog extends BaseActions {
	
	private WebDriver driver;
	private By figureBox = By.cssSelector(".product_list li .product_img_link");
	private By addcart = By.cssSelector(".right-block a[title='Add to cart']");
	private By checkout = By.cssSelector("#layer_cart  a[title='Proceed to checkout']");
	private By tshirtDesc= By.id("layer_cart_product_title");
	private By tshirtClrSize= By.id("layer_cart_product_attributes");
	private By tshirtQuantity= By.id("layer_cart_product_quantity");
	private By totalPrice = By.cssSelector(".cart-prices-line .ajax_block_cart_total");
	
	
	private WebElement figure;
	 
	 
	public TshirtCatalog(WebDriver driver) throws NumberFormatException, IOException {
		super(driver);
		
		this.driver=driver;
	}

	
	public void hoverOverFigure(){
		
		figure = driver.findElement(figureBox);
		Actions actions = new Actions(driver);
		actions.moveToElement(figure).perform();
	}
	
	public void addCartClick() {
		waitForElementToBeVisible(driver.findElement(addcart));
		driver.findElement(addcart).click();
		waitForElementToBeVisible(driver.findElement(checkout));
	}
	
	
	public String getTshirtDesc() {
		return(driver.findElement(tshirtDesc).getText().trim());
	}
	
	public String getTshirtColor() {
		return(driver.findElement(tshirtClrSize).getText().split(",")[0].trim());
	}

	public String getTshirtSize() {
		return(driver.findElement(tshirtClrSize).getText().split(",")[1].trim());
	}

	public String getTshirtQuantity() {
		return(driver.findElement(tshirtQuantity).getText().trim());
	}
	
	public String getTotalPrice() {
		return(driver.findElement(totalPrice).getText().trim());
	}
	
	
	public CartSummary clickCheckoutButton() throws NumberFormatException, IOException{
		
//		waitForElementToBeVisible(driver.findElement(checkout));
	     driver.findElement(checkout).click();
	     return new CartSummary(driver);
	}

	
	
	
}
