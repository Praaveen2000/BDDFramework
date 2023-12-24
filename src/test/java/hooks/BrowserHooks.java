package hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import factory.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.Utilities;

public class BrowserHooks {
	
	WebDriver driver;
	
	@Before
	public void setup()
	{
		driver = BrowserFactory.initialiseBrowser(Utilities.readFromProperties("browserName"));  
	}
	
	@After
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			Utilities.getScreenShot(driver);
			
			byte[] testScreenShot = Utilities.getScreenShotAsBytes(driver);
			
			scenario.attach(testScreenShot, "image/png", scenario.getName()); 
		}
		
		driver.quit();
	}

}
