Automation assessment
=========================================================

### [Java - Selenium Webdriver- Maven - Junit]
---
#### Summary:

As suggested, automated two scenarios which were asked in Codility test

#### System Requirement:

* JDK 1.8 or above
* Maven 3.1 or above
* Eclipse or IDE of choice in case there is need to update the script. (optional)


#### Gherkin Scenarios

All the scenarios are  kept in **./src/test/resources/** folder

##### Executing scenarios from command line using Tags  

For executing all the scenarios use below:
mvn clean test -Dcucumber.options="src/test/resources/features/Scenarios.feature"

For executing specific scenarios using tag use below:
mvn clean test  "-Dcucumber.options=--tags @qtTest"


##### Properties File

Url,Timeout and Browser can be configured from global.properties file
I have used Chrome to automate scenarios and this framework currently supports only Chrome.


#### Result Files:	
The Test Execution Results will be stored in the  folder directory  **./target/cucumber/** once the test has completed.

We have attached the execution report in .zip format at below location in .git
https://github.com/MayurThapan/CodilityAssessment/blob/main/cucumber.zip

Reports will also capture the screenshot if test fails. 

#### Further Improvements:

* Implement utilities for keeping test data in separate files
* Implement Logging 
* Integrating with CI/CD tools say Jenkins
* Parallel execution
* Customize framework for sending execution results in automated emails and posting execution results in say Slack
* Support for executing tests remotely in Selenium grid or say Browser stack
* Support for different Browsers/OS for browser compatiblity testing
* Integration with Restful libraries say RestAssured
* Reusable components





     







