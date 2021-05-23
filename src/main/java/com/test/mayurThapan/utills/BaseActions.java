package com.test.mayurThapan.utills;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.test.mayurThapan.utills.ConfigPropertyReader.getProperty;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class BaseActions {

	public WebDriver driver;
	WebDriverWait wait;

	public BaseActions(WebDriver driver) throws NumberFormatException, IOException {
		this.driver= driver;
		this.wait = new WebDriverWait(driver,Integer.parseInt(getProperty("timeout")) );

	}
	public WebElement element(By locator) {
		return driver.findElement(locator);
	}
	
	public List<WebElement> elements(By locator) {
		return driver.findElements(locator);
	}
	
	
	
	public void waitForPageToLoadCompletely() {
		ExpectedCondition<Boolean> expectation = new
				ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 300);
			wait.until(expectation);
		} catch (Throwable error) {
		}
	}


	public WebElement waitForElementToBeVisible(WebElement element) {
		return (WebElement) wait.until(ExpectedConditions.visibilityOf(element));
	}

	public WebElement waitForElementToBeClickable(WebElement element) {
		return (WebElement) wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void resetImplicitTimeout(int newTimeOut) {
		driver.manage().timeouts().implicitlyWait(newTimeOut, TimeUnit.SECONDS);
	}


	public  WebElement waitExplicitlyXPath(String xpath) {
		WebDriverWait wait;
		wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		return element;
	}

	
	protected Object executeJavascript1(String script) {

		return ((JavascriptExecutor) driver).executeScript(script);
	}

	protected String executeJavascriptWithReturnValue(String script) {
		return ((JavascriptExecutor) driver).executeScript("return " + script).toString();
	}

	 protected void scrollDown(WebElement element) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	    }

	 public boolean waitForElementToBeInVisible(By locator) {
	        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator)) != null;
	    }	

	 
	 public void waitForFrameToBeAvailableAndSwitchToIt(By locator) {
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	    }

	 public void dragAndDropOfElement(WebElement fromElement, WebElement toElement) {
	        Actions act =new Actions(driver);
	        act.dragAndDrop(fromElement, toElement).build().perform();
	    }
}
