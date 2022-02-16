package TestAutomation.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class WebDriverFactory {
	static WebDriver driver;

	public static WebDriver getWebDriver(String BrowserName) {
		if(BrowserName.equals("Firefox") ){
			//System.out.println("I am here");
			String driverPath = "C:\\Users\\Rahul_Narendhula\\Documents\\browsers\\geckodriver-v0.30.0-win64\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", driverPath);
			driver=new FirefoxDriver();
			
		}
		else if(BrowserName.equals("Chrome") ){
			String driverPath = "C:\\Users\\Rahul_Narendhula\\Documents\\browsers\\chromedriver_win32\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver=new ChromeDriver();

		}
		else {
			System.out.println("Browser not found");
			driver=null;
		}
		return driver;
	}



}