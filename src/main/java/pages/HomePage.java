package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropDown;
	
	@FindBy(linkText="Login")
	private WebElement loginBtn;
	
	public void clickOnMyAccount() 
	{
		myAccountDropDown.click();
	}
	
	public void clickOnLogin()
	{
		loginBtn.click();
	}
	
	@FindBy(linkText="Register")
	private WebElement registerBtn;
	
	public void clickOnRegister()
	{
		registerBtn.click();
	}
	
	@FindBy(name="search")
	private WebElement searchBox;
	
	public void enterSearchBoxField(String product)
	{
		searchBox.sendKeys(product);
	}
	
	@FindBy(xpath="//span[@class='input-group-btn']/button")
	private WebElement searchBtn;
	
	public void clickSearchBtn()
	{
		searchBtn.click();
	}

}
