package com.test.mayurThapan.testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(  
	    features = "src/test/resources/features/",
	    glue="com.test.mayurThapan.stepDefinitions",
	    tags= {"@qtTest"},
	    
	    //,strict=true,monochrome=true,
	    plugin= {"pretty","html:target/cucumber","json:target/cucumber.json","junit:target/cukes.xml"})
public class CodilityCucumberRunner {

}
