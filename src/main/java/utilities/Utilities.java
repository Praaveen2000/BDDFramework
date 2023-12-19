package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Utilities {
	
	public static String generateEmailWithTimeStamp()
	{
		return "tester"+timeStamp()+"@gmail.com";
	}
	
	public static String timeStamp()
	{
		return new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy").format(new Date());
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
