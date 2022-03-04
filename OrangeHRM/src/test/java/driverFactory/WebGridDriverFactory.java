package driverFactory;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



public class WebGridDriverFactory extends DriverFactory{

	private static final String hubURL = "http://192.168.8.111:4444/wd/hub";

	public WebDriver getWebDriver(String BrowserName)throws MalformedURLException {
		WebDriver driver = null;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setPlatform(Platform.WIN10);

		if(BrowserName.equalsIgnoreCase("CHROME")) {
			
			capabilities.setBrowserName("chrome");

			driver = new RemoteWebDriver((new URL(hubURL)),capabilities);

		}else if (BrowserName.equalsIgnoreCase("FIREFOX")) {
			

			capabilities.setBrowserName("firefox");

			driver = new RemoteWebDriver((new URL(hubURL)),capabilities);
		}else {
			System.out.println("Browser not found");
			driver=null;
		}
		return driver;
	}

}