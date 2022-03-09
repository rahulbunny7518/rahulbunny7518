package driverFactory;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebSAUCEDriverFactory extends DriverFactory{

	// setting up SAUCE properties/credenials

	private static final String hubURL="http://localhost:4444/wd/hub";
	public RemoteWebDriver getWebDriver(String browserName) throws MalformedURLException
	{
		RemoteWebDriver driver=null;
		
		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("username", "oauth-rahulbunny7518-271c5");
		//sauceOptions.setCapability("password", "oauth-prasoon.rana-5c24c"); // in case of password as credentials
		sauceOptions.setCapability("accessKey", "247a2857-dfbb-4e1a-8eca-ba431305191e");
		sauceOptions.setCapability("browserVersion", "latest");
		
		URL url = new URL("https://oauth-rahulbunny7518-271c5:247a2857-dfbb-4e1a-8eca-ba431305191e@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
		
		if(browserName.equalsIgnoreCase("CHROME"))
		{
			ChromeOptions options=new ChromeOptions();
			options.setCapability("sauce:options", sauceOptions);
			driver=new WebDriverProxy(new RemoteWebDriver(url,options));
		}
		else if(browserName.equalsIgnoreCase("FIREFOX"))
		{
			FirefoxOptions options=new FirefoxOptions();
			options.setCapability("sauce:options", sauceOptions);
			driver=new WebDriverProxy(new RemoteWebDriver(url,options));
		}
		else {
			driver=null;
		}
		return driver;
		

	}



}
