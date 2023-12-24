package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import factory.BrowserFactory;
import utilities.elementUtils;

public class HomePage {
	
	WebDriver driver;
	
	elementUtils utils;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
		utils = new elementUtils(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropDown;
	
	@FindBy(linkText="Login")
	private WebElement loginBtn;
	
	public void clickOnMyAccount() 
	{
		utils.clickOnElement(myAccountDropDown, BrowserFactory.EXPLICIT_WAIT_TIME);
	}
	
	public LoginPage clickOnLogin()
	{
		utils.clickOnElement(loginBtn, BrowserFactory.EXPLICIT_WAIT_TIME);
		
		return new LoginPage(driver);
	}
	
	@FindBy(linkText="Register")
	private WebElement registerBtn;
	
	public RegisterPage clickOnRegister()
	{
		utils.clickOnElement(registerBtn, BrowserFactory.EXPLICIT_WAIT_TIME);
		
		return new RegisterPage(driver);
	}
	
	@FindBy(name="search")
	private WebElement searchBox;
	
	public void enterSearchBoxField(String product)
	{
		utils.sendTextToElement(searchBox, BrowserFactory.EXPLICIT_WAIT_TIME, product);
	}
	
	@FindBy(xpath="//span[@class='input-group-btn']/button")
	private WebElement searchBtn;
	
	public SearchResultsPage clickSearchBtn()
	{
		utils.clickOnElement(searchBtn, BrowserFactory.EXPLICIT_WAIT_TIME);
		
		return new SearchResultsPage(driver);
	}

}
