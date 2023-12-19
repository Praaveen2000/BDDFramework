package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailField;
	
	public void enterEmail(String email)
	{
		emailField.sendKeys(email);
	}
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordField;
	
	public void enterPassword(String pass)
	{
		passwordField.sendKeys(pass);
	}
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginBtn;
	
	public void clickOnLogin()
	{
		loginBtn.click();
	}
	
	public boolean displayStatusOfLoginBtn()
	{
		return loginBtn.isDisplayed();
	}
	
	@FindBy(css="div[class*='alert']")
	private WebElement warnMsgHeader;
	
	public boolean displayStatusOfWarnMsg()
	{
		return warnMsgHeader.isDisplayed();
	}
	

}
