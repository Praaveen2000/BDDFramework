package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BrowserFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SearchResultsPage;

public class Search {
	
	WebDriver driver;
	
	@Given("User is on the homepage of the application")
	public void user_is_on_the_homepage_of_the_application() {
	    driver = BrowserFactory.getDriver();
	}

	@When("User enters a valid product {string} into the searchBox")
	public void user_enters_a_valid_product_into_the_search_box(String validProduct) {
	    
		HomePage homePage = new HomePage(driver);
		
		homePage.enterSearchBoxField(validProduct);
	}

	@When("Clicks on searchbutton")
	public void clicks_on_searchbutton() {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.clickSearchBtn();
	}

	@Then("User should be able to find results for the product")
	public void user_should_be_able_to_find_results_for_the_product() {
		
		SearchResultsPage resultPage = new SearchResultsPage(driver);
		
	    Assert.assertTrue(resultPage.getDisplayStatusOfValidResult());
	}

	@When("User enters a invalid product {string} into the searchBox")
	public void user_enters_a_invalid_product_into_the_search_box(String invalidProduct) {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.enterSearchBoxField(invalidProduct);
	}
	
	@When("User does not enters a product into the searchBox")
	public void user_does_not_enters_a_product_into_the_search_box() {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.enterSearchBoxField("");
	}

	@Then("User should get a proper warning message about results not found")
	public void user_should_get_a_proper_warning_message_about_results_not_found() {
		
		SearchResultsPage resultPage = new SearchResultsPage(driver);
		
		Assert.assertEquals("There is no product that matches the search criteria.", resultPage.getTextOfInvalidResultWarnMsg()); 
	}

}
