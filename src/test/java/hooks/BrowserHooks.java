package hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import factory.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.Utilities;

public class BrowserHooks {
	
	WebDriver driver;
	
	@Before
	public void setup()
	{
		BrowserFactory.initialiseBrowser(Utilities.readFromProperties("browserName")); 
		
		driver = BrowserFactory.getDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(Utilities.readFromProperties("url"));
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}

}
