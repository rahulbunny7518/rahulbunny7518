package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtil {
	
	public static WebDriver getBrowserInstance(String str)
	{
		if(str.equals("firefox"))
		{
			String driverPath = "C:\\Users\\Rahul_Narendhula\\Documents\\browsers\\geckodriver-v0.30.0-win64\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", driverPath);
			WebDriver driver = new FirefoxDriver();
			
			return driver;
			
		
		}
		else if(str.equals("chrome"))
		{
			String driverPath = "C:\\Users\\Rahul_Narendhula\\Documents\\browsers\\chromedriver_win32\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverPath);
			WebDriver driver = new ChromeDriver();
			return driver;
		
		}
		return null;
	}

}
