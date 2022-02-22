package hubnode;

import java.net.MalformedURLException;
import java.net.URL;



import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



public class WebGridDriverFactory {

	private static final String hubURL = "http://192.168.8.111:4444/wd/hub";

	public static WebDriver getWebDriver(String BrowserName)throws MalformedURLException {
		WebDriver driver = null;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setPlatform(Platform.WIN10);

		if(BrowserName.equalsIgnoreCase("CHROME")) {
			//String driverPath = "C:\\Users\\Rahul_Narendhula\\Documents\\browsers\\chromedriver_win32\\chromedriver.exe";
			//System.setProperty("webdriver.chrome.driver", driverPath);
			//driver = new ChromeDriver();

			capabilities.setBrowserName("chrome");

			driver = new RemoteWebDriver((new URL(hubURL)),capabilities);

		}else if (BrowserName.equalsIgnoreCase("FIREFOX")) {
			//String driverPath = "C:\\Users\\Rahul_Narendhula\\Documents\\browsers\\geckodriver-v0.30.0-win64\\geckodriver.exe";
			//System.setProperty("webdriver.gecko.driver", driverPath);
			//driver = new FirefoxDriver();

			capabilities.setBrowserName("firefox");

			driver = new RemoteWebDriver((new URL(hubURL)),capabilities);
		}else {
			System.out.println("Browser not found");
			driver=null;
		}
		return driver;
	}

}