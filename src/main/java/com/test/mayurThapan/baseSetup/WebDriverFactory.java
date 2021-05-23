package com.test.mayurThapan.baseSetup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

	public static WebDriver driver;
	public static Properties prop;
	String driverPath;


	public WebDriver getDriver(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			return  getChromeDriver();
		}
		else {
			System.out.println("Browser still not supported");
			return null;
		}

	}

	public WebDriver getChromeDriver() {
		driverPath = "src/test/resources/drivers/chromedriver.exe";
		if (OS.isFamilyWindows()) {
			System.setProperty("webdriver.chrome.driver",driverPath );
			driver = new ChromeDriver();
		}	
		return  driver;
	}

}
