#Author: mayurthapan@gmail.com


@tag
Feature: Following are the assigned Test scenarios

Background: Users login to application with valid credentials
#Password is encrypted.
 Given User login with credentials: username as  "mayurthapan@gmail.com" and password as "MkFVRzE5NjY="


  @qtTest @Order
  Scenario: Order T-shirt and Verify in Order History
    Given User is on myAccount page
    When User select a T-shirt 
    And User add T-shirt in cart
    And Record the T-Shirt details
    And User follows complete Proceed to checkout process
    And User make the payment and confirm the order
    Then User receieve order confirmation details
    And Verify the details on Order History page.


  @qtTest @UpdateFirstName
  Scenario: Update personal Information (First Name) in My Account
    Given User is on myAccount page
    When User decides to edit his personal information 
    And User update the First name 
 #Password is encrypted.
    And User enter the password "MkFVRzE5NjY=" and submit
    Then User receieve success Information "Your personal information has been successfully updated."
    And User can view the Updated Name dislayed on the top right corner.

 
