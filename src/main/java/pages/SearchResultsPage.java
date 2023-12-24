package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import factory.BrowserFactory;
import utilities.elementUtils;

public class SearchResultsPage {
	
	WebDriver driver;
	
	elementUtils utils;
	
	public SearchResultsPage(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
		utils = new elementUtils(driver);
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement validResultLink;
	
	public boolean getDisplayStatusOfValidResult()
	{
		return utils.elementIsDisplayed(validResultLink, BrowserFactory.EXPLICIT_WAIT_TIME);
	}

	@FindBy(xpath="//div[@id='content']/input//following-sibling::p")
	private WebElement invalidResultWarnMsg;
	
	public String getTextOfInvalidResultWarnMsg()
	{
		return utils.getTextOfElement(invalidResultWarnMsg, BrowserFactory.EXPLICIT_WAIT_TIME);
	}

	

}
