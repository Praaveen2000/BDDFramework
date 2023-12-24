package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import factory.BrowserFactory;
import utilities.elementUtils;

public class LoginPage {
	
	WebDriver driver;
	
	elementUtils utils;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
		utils = new elementUtils(driver);
	}
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailField;
	
	public void enterEmail(String email)
	{
		utils.sendTextToElement(emailField, BrowserFactory.EXPLICIT_WAIT_TIME, email);
	}
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordField;
	
	public void enterPassword(String pass)
	{
		utils.sendTextToElement(passwordField, BrowserFactory.EXPLICIT_WAIT_TIME, pass);
	}
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginBtn;
	
	public AccountPage clickOnLogin()
	{
		utils.clickOnElement(loginBtn, BrowserFactory.EXPLICIT_WAIT_TIME);
		
		return new AccountPage(driver);
	}
	
	public boolean displayStatusOfLoginBtn()
	{
		return utils.elementIsDisplayed(loginBtn, BrowserFactory.EXPLICIT_WAIT_TIME);
	}
	
	@FindBy(css="div[class*='alert']")
	private WebElement warnMsgHeader;
	
	public boolean displayStatusOfWarnMsg()
	{
		return utils.elementIsDisplayed(warnMsgHeader, BrowserFactory.EXPLICIT_WAIT_TIME);
	}
	

}
