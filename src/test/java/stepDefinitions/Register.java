package stepDefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BrowserFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.RegisterPage;
import pages.AccountSuccessPage;
import utilities.Utilities;

public class Register {
	
	WebDriver driver;
	
	HomePage homePage;
	
	RegisterPage registerPage;
	
	AccountSuccessPage accountSuccessPage;
	
	@Given("User navigates to register page of the application")
	public void user_navigates_to_register_page_of_the_application() {
		
		driver = BrowserFactory.getDriver();
		
		homePage = new HomePage(driver);
		
		homePage.clickOnMyAccount();
		
		registerPage = homePage.clickOnRegister();
	}

	@When("User enters the below fields")
	public void user_enters_the_below_fields(DataTable dataTable) {
		
	   Map<String,String> dataMap = dataTable.asMap(String.class,String.class);
		
	   registerPage.enterFirstName(dataMap.get("firstName"));
	   registerPage.enterLastName(dataMap.get("lastName"));
	   registerPage.enterEmail(Utilities.generateEmailWithTimeStamp());
	   registerPage.enterTelephone(dataMap.get("telephone"));
	   registerPage.enterPassword(dataMap.get("password"));
	   registerPage.enterConfirmPassword(dataMap.get("password"));
	}
	
	@When("User selects Privacy Policy")
	public void user_selects_privacy_policy() {
	    
		registerPage.clickPrivacyPolicy();
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		
		accountSuccessPage = registerPage.clickOnContinue();
	}

	@Then("User should successfully create an account")
	public void user_should_successfully_create_an_account() {
		
		Assert.assertEquals("Your Account Has Been Created!", accountSuccessPage.getTextOfWarnMsg());
	}

	@When("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
	   
		registerPage.clickYesForNewsLetter();
	}
	
	@When("User enters the below fields with duplicate email")
	public void User_enters_the_below_fields_with_duplicate_email(DataTable dataTable)
	{
		   Map<String,String> dataMap = dataTable.asMap(String.class,String.class);
		   
		   registerPage.enterFirstName(dataMap.get("firstName"));
		   registerPage.enterLastName(dataMap.get("lastName"));
		   registerPage.enterEmail(dataMap.get("email"));
		   registerPage.enterTelephone(dataMap.get("telephone"));
		   registerPage.enterPassword(dataMap.get("password"));
		   registerPage.enterConfirmPassword(dataMap.get("password"));
	}

	@Then("User should not able to create an account")
	public void user_should_not_able_to_create_an_account() {
		
		Assert.assertEquals("Register Account",registerPage.getRegisterPageHeaderText());   
	}

	@Then("User gets a proper warning message about duplicate email address")
	public void user_gets_a_proper_warning_message_about_duplicate_email_address() {
		
		Assert.assertTrue(registerPage.getWarnMsgText().contains("Warning: E-Mail Address is already registered!"));
	}

	@Then("User gets a proper warning message about the empty mandatory fields")
	public void user_gets_a_proper_warning_message_about_the_empty_mandatory_fields() {
		
		Assert.assertTrue(registerPage.getWarnMsgText().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertTrue(registerPage.getFirstNameWarnMsg().contains("First Name must be between 1 and 32 characters!"));
		Assert.assertTrue(registerPage.getLastNameWarnMsg().contains("Last Name must be between 1 and 32 characters!"));
		Assert.assertTrue(registerPage.getEmailWarnMsg().contains("E-Mail Address does not appear to be valid!"));
		Assert.assertTrue(registerPage.getTelephoneWarnMsg().contains("Telephone must be between 3 and 32 characters!"));
		Assert.assertTrue(registerPage.getPasswordWarnMsg().contains("Password must be between 4 and 20 characters!"));
	}

}
