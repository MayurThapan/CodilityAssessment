package com.test.mayurThapan.pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.mayurThapan.utills.BaseActions;

public class OrderHistory extends BaseActions {
	
	private WebDriver driver;
	private By items = By.cssSelector("#order-list tbody tr");	
	private By productName=By.cssSelector("p.product-name");
	private By history_Detail =By.cssSelector(".history_detail a");
	private By history_link= By.className("history_link");
	private By prodDetails =By.cssSelector("#order-detail-content .item .bold label");

	public OrderHistory(WebDriver driver) throws NumberFormatException, IOException {
		super (driver);
		this.driver=driver;
	}

	public void openAddedItemDetails(String referenceID) {
		List<WebElement> allItems = driver.findElements(items);
        for(WebElement item:allItems) {
          if(item.findElement(history_link).getText().equals(referenceID)) {
        	  item.findElement(history_Detail).click();
          }	       	 
        }    	
	
	}
	
	public String getOrderHistoryProdDetailDesc() {
		scrollDown(driver.findElement(prodDetails));
		return(driver.findElement(prodDetails).getText().trim().split("- Color")[0].trim());
	}
	
	public String getOrderHistoryProdDetailColor() {
		scrollDown(driver.findElement(prodDetails));
		return(driver.findElement(prodDetails).getText().trim().split("Color :")[1].trim()
				.split(", Size")[0].trim());
	}
	
	public String getOrderHistoryProdDetailSize() {
		scrollDown(driver.findElement(prodDetails));
		return(driver.findElement(prodDetails).getText().trim().split("Size :")[1].trim()
				.split(", Size")[0].trim());
	}
	
}
