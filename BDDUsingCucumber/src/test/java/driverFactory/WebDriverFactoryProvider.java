package driverFactory;

public class WebDriverFactoryProvider {
	
	public static DriverFactory getWebDriverFactory(String platformName)
	{
		DriverFactory factory=null;
		
		if(platformName.equalsIgnoreCase("LocalWebDriver"))
		{
			factory=new WebDriverFactory();
		}
		else if(platformName.equalsIgnoreCase("GridWebDriver"))
		{
			factory=new WebGridDriverFactory();
		}
		else if(platformName.equalsIgnoreCase("SAUCEWebDriver"))
		{
			factory=new WebSAUCEDriverFactory();
		}
		
		return factory;
		
	}

}
