package utilities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class elementUtils {
	
	WebDriver driver;
	
	public elementUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String getTextOfElement(WebElement element, long durationInSecs)
	{
		WebElement webElement = waitForElementVisibility(element, durationInSecs);
		
		return webElement.getText();
	}
	
	public boolean elementIsDisplayed(WebElement element, long durationInSecs)
	{
		WebElement webElement = waitForElementVisibility(element, durationInSecs);
		
		return webElement.isDisplayed();
	}
	
	public void clickOnElement(WebElement element, long durationInSecs)
	{
		WebElement webElement = waitForElement(element, durationInSecs);
		
		webElement.click();
	}
	
	public void sendTextToElement(WebElement element, long durationInSecs, String inputText)
	{
		WebElement webElement = waitForElement(element, durationInSecs);
		
		webElement.click();
		
		webElement.clear();
		
		webElement.sendKeys(inputText);
	}
	
	public WebElement waitForElement(WebElement element, long durationInSecs) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSecs));
		
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void selectOptionInDropDown(WebElement element, String dropDownOption)
	{
		Select selectDropDown = new Select(element);
		
		selectDropDown.selectByVisibleText(dropDownOption);
	}
	
	public void acceptAlert(WebElement element, long durationInSecs)
	{
		Alert alert = waitForAlert(durationInSecs);
		
		alert.accept();
	}
	
	public Alert waitForAlert(long durationInSecs)
	{
		Alert alert;
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSecs));
		
		alert = wait.until(ExpectedConditions.alertIsPresent());
		
		return alert; 
	}
	
	public void mouseHoverAndClick(WebElement element, long durationInSecs)
	{
		WebElement webElement = waitForElementVisibility(element, durationInSecs);
		
		Actions action = new Actions(driver);
		
		action.moveToElement(webElement).click().build().perform();
	}
	
	public WebElement waitForElementVisibility(WebElement element, long durationInSecs) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSecs));
		
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void jsClick(WebElement element)
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		
		jsExecutor.executeScript("arguments[0].click()", element);
	}
	
	public void jsClick(WebElement element, String inputText)
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		
		jsExecutor.executeScript("arguments[0].value='"+inputText+"'", element);
	}

}
