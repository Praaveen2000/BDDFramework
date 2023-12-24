package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import factory.BrowserFactory;
import utilities.elementUtils;

public class RegisterPage {
	
	WebDriver driver;
	
	elementUtils utils;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
		utils = new elementUtils(driver);
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPasswordField;
	
	public void enterFirstName(String firstName)
	{
		utils.sendTextToElement(firstNameField, BrowserFactory.EXPLICIT_WAIT_TIME, firstName);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']//following-sibling::div")
	private WebElement firstNameWarnMsg;
	
	public String getFirstNameWarnMsg()
	{
		return utils.getTextOfElement(firstNameWarnMsg, BrowserFactory.EXPLICIT_WAIT_TIME);
	}
	
	public void enterLastName(String lastName)
	{
		utils.sendTextToElement(lastNameField, BrowserFactory.EXPLICIT_WAIT_TIME, lastName);
	}
	
	@FindBy(xpath="//input[@id='input-lastname']//following-sibling::div")
	private WebElement lastNameWarnMsg;
	
	public String getLastNameWarnMsg()
	{
		return utils.getTextOfElement(lastNameWarnMsg, BrowserFactory.IMPLICIT_WAIT_TIME);
	}
	
	public void enterEmail(String email)
	{
		utils.sendTextToElement(emailField, BrowserFactory.EXPLICIT_WAIT_TIME, email);
	}
	
	@FindBy(xpath="//input[@id='input-email']//following-sibling::div")
	private WebElement emailWarnMsg;
	
	public String getEmailWarnMsg()
	{
		return utils.getTextOfElement(emailWarnMsg, BrowserFactory.EXPLICIT_WAIT_TIME);
	}
	
	public void enterTelephone(String telephone)
	{
		utils.sendTextToElement(telephoneField, BrowserFactory.EXPLICIT_WAIT_TIME, telephone);
	}
	
	@FindBy(xpath="//input[@id='input-telephone']//following-sibling::div")
	private WebElement telephoneWarnMsg;
	
	public String getTelephoneWarnMsg()
	{
		return utils.getTextOfElement(telephoneWarnMsg, BrowserFactory.EXPLICIT_WAIT_TIME);
	}
	
	public void enterPassword(String password)
	{
		utils.sendTextToElement(passwordField, BrowserFactory.EXPLICIT_WAIT_TIME, password);
	}
	
	@FindBy(xpath="//input[@id='input-password']//following-sibling::div")
	private WebElement passwordWarnMsg;
	
	public String getPasswordWarnMsg()
	{
		return utils.getTextOfElement(passwordWarnMsg, BrowserFactory.EXPLICIT_WAIT_TIME);
	}
	
	public void enterConfirmPassword(String lastName)
	{
		utils.sendTextToElement(confirmPasswordField, BrowserFactory.EXPLICIT_WAIT_TIME, lastName);
	}
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement agreePrivacyPolicy;
	
	public void clickPrivacyPolicy()
	{
		utils.clickOnElement(agreePrivacyPolicy, BrowserFactory.EXPLICIT_WAIT_TIME);
	}
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueBtn;
	
	public AccountSuccessPage clickOnContinue()
	{
		utils.clickOnElement(continueBtn, BrowserFactory.EXPLICIT_WAIT_TIME);
		
		return new AccountSuccessPage(driver);
	}
	
	@FindBy(xpath="//input[@name='newsletter' and @value='1']")
	private WebElement yesForNewsLetter;
	
	public void clickYesForNewsLetter()
	{
		utils.clickOnElement(yesForNewsLetter, BrowserFactory.EXPLICIT_WAIT_TIME);
	}
	
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement registerPageHeader;
	
	public String getRegisterPageHeaderText()
	{
		return utils.getTextOfElement(registerPageHeader, BrowserFactory.EXPLICIT_WAIT_TIME);
	}
	
	@FindBy(css="div[class*='alert']")
	private WebElement warnMsgHeader;
	
	public String getWarnMsgText()
	{
		return utils.getTextOfElement(warnMsgHeader, BrowserFactory.EXPLICIT_WAIT_TIME);
	}
	
}
