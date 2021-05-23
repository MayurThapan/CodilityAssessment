package com.test.mayurThapan.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.test.mayurThapan.baseSetup.Base;
import com.test.mayurThapan.pageObjects.CartSummary;
import com.test.mayurThapan.pageObjects.HomePage;
import com.test.mayurThapan.pageObjects.OrderHistory;
import com.test.mayurThapan.pageObjects.ProfilePage;
import com.test.mayurThapan.pageObjects.SignInPage;
import com.test.mayurThapan.pageObjects.TshirtCatalog;



//@RunWith(Cucumber.class)

public class TestSteps {
	private HomePage hp;
	private CartSummary cs;
	private TshirtCatalog tc;
	private ProfilePage pp;
	private SignInPage si;
	private OrderHistory oh;
	private String OrderReference;
	private String PurchasedTshrtDesc;
	private String PurchasedTshrtColor;
	private String PurchasedTshrtSize;
	
	
    
	private Base base  = Hooks.base;
	private static final Logger logger = LogManager.getLogger(TestSteps.class);
 



@Given("^login with credentials \"([^\"]*)\" \"([^\"]*)\"$")
public void login_with_credentials(String arg1, String arg2) throws Throwable {
	hp = new HomePage(base.getDriver());
	si= hp.clickSignin();
	si.setUsername(arg1);
	si.setPassword(arg2);
	pp = si.clickLoginButton();
	tc = pp.clickTshirt();
	

}

@When("^Buy the Tshirt$")
public void buy_the_Tshirt() throws Throwable {

	tc.hoverOverFigure();
	tc.addCartClick();
	PurchasedTshrtDesc=tc.getTshirtDesc();
	PurchasedTshrtColor=tc.getTshirtColor();
	PurchasedTshrtSize=tc.getTshirtSize();
	cs=tc.clickCheckoutButton();
	cs.sumryPTCclick();
	cs.addressPTCclick();
	cs.trmsCheck();
	cs.shipPTCclick();
	cs.pymtclick();
	cs.cnfmOrdrClick();
	System.out.println(cs.getOrderReference());
	OrderReference = cs.getOrderReference();
	
	
}

@Then("^Navigate To OrgerSummary$")
public void navigate_To_OrgerSummary() throws Throwable {

	oh = cs.clickbkToOrder();
	
	oh.openAddedItemDetails(OrderReference);

	assertEquals(PurchasedTshrtDesc, oh.getOrderHistoryProdDetailDesc());
	assertEquals(PurchasedTshrtColor, oh.getOrderHistoryProdDetailColor());
	assertEquals(PurchasedTshrtColor, oh.getOrderHistoryProdDetailSize());

}

	
	

}
