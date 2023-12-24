package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import factory.BrowserFactory;
import utilities.elementUtils;

public class AccountSuccessPage {
	
	WebDriver driver;
	
	elementUtils utils;
	
	public AccountSuccessPage(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
		utils = new elementUtils(driver);
	}
	
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement warnMsgHeader;
	
	public String getTextOfWarnMsg()
	{
		return utils.getTextOfElement(warnMsgHeader, BrowserFactory.EXPLICIT_WAIT_TIME);
	}

}
