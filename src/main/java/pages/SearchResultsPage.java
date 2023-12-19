package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
	
	WebDriver driver;
	
	public SearchResultsPage(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement validResultLink;
	
	public boolean getDisplayStatusOfValidResult()
	{
		return validResultLink.isDisplayed();
	}

	@FindBy(xpath="//div[@id='content']/input//following-sibling::p")
	private WebElement invalidResultWarnMsg;
	
	public String getTextOfInvalidResultWarnMsg()
	{
		return invalidResultWarnMsg.getText();
	}

	

}
