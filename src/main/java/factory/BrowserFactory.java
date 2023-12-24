package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.Utilities;

public class BrowserFactory {
	 
	public static final int IMPLICIT_WAIT_TIME = 20;
	
	public static final int PAGELOAD_WAIT_TIME = 20;
	
	public static final int EXPLICIT_WAIT_TIME = 20;
	
	static WebDriver driver = null;
	
	public static WebDriver initialiseBrowser(String browserName)
	{	
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_TIME));
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGELOAD_WAIT_TIME));
		
		driver.get(Utilities.readFromProperties("url"));
		
		return driver;
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
}
