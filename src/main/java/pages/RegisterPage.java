package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
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
		firstNameField.sendKeys(firstName);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']//following-sibling::div")
	private WebElement firstNameWarnMsg;
	
	public String getFirstNameWarnMsg()
	{
		return firstNameWarnMsg.getText();
	}
	
	public void enterLastName(String lastName)
	{
		lastNameField.sendKeys(lastName);
	}
	
	@FindBy(xpath="//input[@id='input-lastname']//following-sibling::div")
	private WebElement lastNameWarnMsg;
	
	public String getLastNameWarnMsg()
	{
		return lastNameWarnMsg.getText();
	}
	
	public void enterEmail(String email)
	{
		emailField.sendKeys(email);
	}
	
	@FindBy(xpath="//input[@id='input-email']//following-sibling::div")
	private WebElement emailWarnMsg;
	
	public String getEmailWarnMsg()
	{
		return emailWarnMsg.getText();
	}
	
	public void enterTelephone(String telephone)
	{
		telephoneField.sendKeys(telephone);
	}
	
	@FindBy(xpath="//input[@id='input-telephone']//following-sibling::div")
	private WebElement telephoneWarnMsg;
	
	public String getTelephoneWarnMsg()
	{
		return telephoneWarnMsg.getText();
	}
	
	public void enterPassword(String password)
	{
		passwordField.sendKeys(password);
	}
	
	@FindBy(xpath="//input[@id='input-password']//following-sibling::div")
	private WebElement passwordWarnMsg;
	
	public String getPasswordWarnMsg()
	{
		return passwordWarnMsg.getText();
	}
	
	public void enterConfirmPassword(String lastName)
	{
		confirmPasswordField.sendKeys(lastName);
	}
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement agreePrivacyPolicy;
	
	public void clickPrivacyPolicy()
	{
		agreePrivacyPolicy.click();
	}
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueBtn;
	
	public void clickOnContinue()
	{
		continueBtn.click();
	}
	
	@FindBy(xpath="//input[@name='newsletter' and @value='1']")
	private WebElement yesForNewsLetter;
	
	public void clickYesForNewsLetter()
	{
		yesForNewsLetter.click();
	}
	
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement registerPageHeader;
	
	public String getRegisterPageHeaderText()
	{
		return registerPageHeader.getText();
	}
	
	@FindBy(css="div[class*='alert']")
	private WebElement warnMsgHeader;
	
	public String getWarnMsgText()
	{
		return warnMsgHeader.getText();
	}
	
	
	
	
	
	
	

}
