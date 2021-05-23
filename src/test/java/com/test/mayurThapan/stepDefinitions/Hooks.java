package com.test.mayurThapan.stepDefinitions;


import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.test.mayurThapan.baseSetup.Base;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	public static Base base;

	@Before
	public void tearUp(Scenario scenario) throws IOException {
		base = new Base();
		printScenarioName(scenario);
	}
	
	 @After
	    public void tearDown(Scenario scenario) {
	        if (scenario.isFailed()) {
	            final byte[] screenshot = ((TakesScreenshot) base.getDriver())
	                    .getScreenshotAs(OutputType.BYTES);
	            scenario.embed(screenshot, "image/png");
	        }
	        closeBrowser();
	    }
	
	public void printScenarioName(Scenario scenario) {
		scenario.getName();
	}
	
	public void closeBrowser() {
		base.getDriver().close();
	}

}

