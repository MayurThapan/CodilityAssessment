package com.test.mayurThapan.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.test.mayurThapan.baseSetup.Base;
import com.test.mayurThapan.pageObjects.CartSummary;
import com.test.mayurThapan.pageObjects.HomePage;
import com.test.mayurThapan.pageObjects.OrderHistory;
import com.test.mayurThapan.pageObjects.PersonalInfoPage;
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
	private PersonalInfoPage pi;
	private String OrderReference;
	private String PurchasedTshrtDesc;
	private String PurchasedTshrtColor;
	private String PurchasedTshrtSize;
	private String newFirstName;
	
	
    
	private Base base  = Hooks.base;
	private static final Logger logger = LogManager.getLogger(TestSteps.class);
 


	@Given("^User login with credentials: username as  \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_login_with_credentials_username_as_and_password_as(String userName, String passWord) throws Throwable {
		hp = new HomePage(base.getDriver());
		si= hp.clickSignin();
		si.setUsername(userName);
		byte[] decodedPassword = Base64.getDecoder().decode(passWord.getBytes());
		si.setPassword(new String(decodedPassword) );
		pp = si.clickLoginButton();
	}

	@Given("^User is on myAccount page$")
	public void user_is_on_myAccount_page() throws Throwable {
		assertTrue(pp.orderHistoryButtonExist());
	
	}

	@When("^User select a T-shirt$")
	public void user_select_a_T_shirt() throws Throwable {

		tc = pp.clickTshirt();
		
	}

	@When("^User add T-shirt in cart$")
	public void user_add_T_shirt_in_cart() throws Throwable {
	
		tc.hoverOverFigure();
		tc.addCartClick();
	}

	@When("^Record the T-Shirt details$")
	public void record_the_T_Shirt_details() throws Throwable {
		PurchasedTshrtDesc=tc.getTshirtDesc();
		PurchasedTshrtColor=tc.getTshirtColor();
		PurchasedTshrtSize=tc.getTshirtSize();

	}

	@When("^User follows complete Proceed to checkout process$")
	public void user_follows_complete_Proceed_to_checkout_process() throws Throwable {
	
		cs=tc.clickCheckoutButton();
		cs.sumryPTCclick();
		cs.addressPTCclick();
		cs.trmsCheck();
		cs.shipPTCclick();
	}

	@When("^User make the payment and confirm the order$")
	public void user_make_the_payment_and_confirm_the_order() throws Throwable {
		cs.pymtclick();
		cs.cnfmOrdrClick();
		System.out.println(cs.getOrderReference());
		OrderReference = cs.getOrderReference();
	}

	@Then("^User receieve order confirmation details$")
	public void user_receieve_order_confirmation_details() throws Throwable {
		oh = cs.clickbkToOrder();
		
		oh.openAddedItemDetails(OrderReference);
	
	
	}

	@Then("^Verify the details on Order History page\\.$")
	public void verify_the_details_on_Order_History_page() throws Throwable {
		assertEquals(PurchasedTshrtDesc, oh.getOrderHistoryProdDetailDesc());
		assertEquals(PurchasedTshrtColor, oh.getOrderHistoryProdDetailColor());
		assertEquals(PurchasedTshrtSize, oh.getOrderHistoryProdDetailSize());
	
	}

	

	@When("^User decides to edit his personal information$")
	public void user_decides_to_edit_his_personal_information() throws Throwable {
	
		pi=pp.clickPerSonalInfo();
	}

	@When("^User update the First name$")
	public void user_update_the_First_name() throws Throwable {
		
		newFirstName=pi.getRandomName();
		pi.setFirstname(newFirstName.toUpperCase());
	}

	@When("^User enter the password \"([^\"]*)\" and submit$")
	public void user_enter_the_password_and_submit(String passwd) throws Throwable {
	    
		byte[] decodedPassword = Base64.getDecoder().decode(passwd.getBytes());
		pi.setPasswd(new String(decodedPassword));
		pi.clickSubmitButton();
	}

	@Then("^User receieve success Information \"([^\"]*)\"$")
	public void user_receieve_success_Information(String successInfo) throws Throwable {

		assertEquals(successInfo, pi.getSuccessLableText()); 
	}

	@Then("^User can view the Updated Name dislayed on the top right corner\\.$")
	public void user_can_view_the_Updated_Name_dislayed_on_the_top_right_corner() throws Throwable {
	assertEquals(newFirstName.toUpperCase(),  pi.getUpdatedUserName().toUpperCase());
	}


}
