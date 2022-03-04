package listeners;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import driverFactory.WebDriverFactoryProvider;

@Listeners(ReporterListener.class) // this is important 

public class ReporterListenerTestClass {
	
	
	
	WebDriver driver;
	private String orangeHRMUsername;
	private String orangeHRMPassword;
	private String platformname;
	
	
	@BeforeClass
	public void setup(ITestContext context) throws MalformedURLException
	{
		String browserName=context.getCurrentXmlTest().getParameter("BrowserName");
		platformname=context.getCurrentXmlTest().getParameter("OrangeHRMTestExecutionPlatform");
		
		String orangeHRMURL=context.getCurrentXmlTest().getParameter("OrangeHRMBaseURL");
		this.orangeHRMUsername=context.getCurrentXmlTest().getParameter("OrangeHRMUsername");
		this.orangeHRMPassword=context.getCurrentXmlTest().getParameter("OrangeHRMPassword");
		
		driver=WebDriverFactoryProvider.getWebDriverFactory(platformname).getWebDriver(browserName);
		
		driver.get(orangeHRMURL);
		driver.manage().window().maximize();
		context.setAttribute("WebDriver", driver);
	}
	
	

	@Test
	public void firstMethod() {
		assertTrue(true);
	}

	@Test
	public void secondMethod() {
		assertTrue(false);
	}

	@Test(dependsOnMethods = {"firstMethod"})
	public void thirdMethod() {
		assertTrue(true);
	}

}
