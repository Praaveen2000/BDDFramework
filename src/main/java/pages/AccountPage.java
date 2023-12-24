package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import factory.BrowserFactory;
import io.opentelemetry.api.internal.Utils;
import utilities.elementUtils;

public class AccountPage {
	
	WebDriver driver;
	
	elementUtils utils;
	
	public AccountPage(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
		utils = new elementUtils(driver);
	}
	
	@FindBy(linkText="Edit your account information")
	private WebElement editYourAccount;
	
	public boolean displayStatusOfEditAccountLink()
	{
		return utils.elementIsDisplayed(editYourAccount, BrowserFactory.EXPLICIT_WAIT_TIME);
	}

}
