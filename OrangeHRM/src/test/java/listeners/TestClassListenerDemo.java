package listeners;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import driverFactory.WebDriverFactoryProvider;
import pages.LoginPage;

@Listeners(TestListenerImpl.class)
public class TestClassListenerDemo {
	
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
		
		context.setAttribute("WebDriver",driver);

	}
	
	
	@Test
	public void testloginFunctionality() throws InterruptedException
	{

		LoginPage login=new LoginPage(driver);
		
		login.enterUserName(this.orangeHRMUsername)
			.enterPassword(this.orangeHRMPassword)
			.clickLoginButton()
			.logOut();
		
		
		assertTrue(false);
		
	}

}
