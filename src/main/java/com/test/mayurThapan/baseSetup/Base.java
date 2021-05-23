package com.test.mayurThapan.baseSetup;

import static com.test.mayurThapan.utills.ConfigPropertyReader.getProperty;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

import com.test.mayurThapan.pageObjects.HomePage;

public class Base {
	public static WebDriver driver;
	public static Properties prop;
	public WebDriverFactory wdFactory;
	public static String browser;
    public HomePage hp;

    
    

	public Base() throws IOException {
		wdFactory= new WebDriverFactory();
		configureBrowser();
		launchApplication(getProperty("url"));
		initPages();
	}
	
	public void initPages() throws NumberFormatException, IOException {
		hp = new HomePage(driver);
	}

	private void configureBrowser() throws IOException {
		driver = wdFactory.getDriver(getBrowser());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(getProperty("timeout")), TimeUnit.SECONDS);
	}

	public void launchApplication(String baseurl) throws IOException {
		System.out.println("\n" + "The test browser is :- " + getBrowser() + "\n");
		deleteAllCookies();
		driver.get(baseurl);
		System.out.println("\nThe application url is :- " + baseurl);
	}


	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}
	public WebDriver getDriver() {
		return this.driver;
	}

	public static String getBrowser() throws IOException {
		browser = getProperty("browser");
		return browser;
	}


}
