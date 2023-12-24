package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {
	
	public static String generateEmailWithTimeStamp()
	{
		return "tester"+timeStamp()+"@gmail.com";
	}
	
	public static String timeStamp()
	{
		return new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy").format(new Date());
	}
	
	public static void getScreenShot(WebDriver driver)
	{
		try {
			FileHandler.copy(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File(System.getProperty("user.dir")+"/Screenshots/screenshot"+timeStamp()+".png"));
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static byte[] getScreenShotAsBytes(WebDriver driver)
	{
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
	
	
	public static String readFromProperties(String key)
	{
		Properties property = new Properties();
		
		FileInputStream stream = null;
		
		try {
			stream = new FileInputStream(new File(System.getProperty("user.dir")+"/src/test/resources/config/Config.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			property.load(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return property.getProperty(key); 
	}
}
