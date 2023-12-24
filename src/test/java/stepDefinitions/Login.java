package stepDefinitions;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BrowserFactory;
import io.cucumber.java.en.*;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.Utilities;

public class Login {
	
	WebDriver driver;
	
	LoginPage loginPage;
	
	AccountPage accountPage;
	
	HomePage homePage;
	
	@Given("User navigates to the login page of the application")
	public void User_navigates_to_the_login_page_of_the_application()
	{
		driver = BrowserFactory.getDriver();
		
		homePage = new HomePage(driver);
		
		homePage.clickOnMyAccount();
		
		loginPage = homePage.clickOnLogin();
	}
	
	@When("^User enters valid email address (.+) into email field$")
	public void User_enters_valid_email_address_into_email_field(String validEmail)
	{	
		loginPage.enterEmail(validEmail);
	}
	
	@When("^enters valid password (.+) into password field$")
	public void enters_valid_password_into_password_field(Integer validPassword) {
		
		loginPage.enterPassword(String.valueOf(validPassword));
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		
		accountPage = loginPage.clickOnLogin();
	}
    
	@Then("User should get logged into their account successfully")
	public void user_should_get_logged_into_their_account_successfully() {
	    
		Assert.assertTrue(accountPage.displayStatusOfEditAccountLink());
	}

	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
		
		loginPage.enterEmail(Utilities.generateEmailWithTimeStamp());
	}

	@When("^enters invalid password (.+) into password field$")
	public void enters_invalid_password_into_password_field(Integer invalidPassword) {
		
		loginPage.enterPassword(String.valueOf(invalidPassword));
	}

	@Then("User should not get logged into their account")
	public void user_should_not_get_logged_into_their_account() {
		
	    Assert.assertTrue(loginPage.displayStatusOfLoginBtn());
	}

	@Then("gets a proper warning message for credentials mismatch")
	public void gets_a_proper_warning_message_for_credentials_mismatch() {
		
	    Assert.assertTrue(loginPage.displayStatusOfWarnMsg());
	} 

	@When("User does not enter email into email field")
	public void user_does_not_enter_email_into_email_field() {
		
		loginPage.enterEmail("");
	}

	@When("does not enter password into password field")
	public void does_not_enter_password_into_password_field() {
		
		loginPage.enterPassword("");
	}

}
