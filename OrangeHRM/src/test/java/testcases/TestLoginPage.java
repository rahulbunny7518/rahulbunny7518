package testcases;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import driverFactory.WebDriverFactoryProvider;
import pages.LoginPage;

public class TestLoginPage {
	
	private WebDriver driver;
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
	public void passMethod()
	{
		LoginPage login=new LoginPage(driver);
		login.enterUserName(this.orangeHRMUsername)
			.enterPassword(this.orangeHRMPassword)
			.clickLoginButton()
			.logOut();
		System.out.println("method1");
		
	}
	
	@Test
	public void testLoginWithProxy()
	{
		LoginPage login=new LoginPage(driver);
		login.enterUserNameWithFindElement(this.orangeHRMUsername)
			.enterPassword(this.orangeHRMPassword)
			.clickLoginButton()
			.logOut();
	}
	
	
	@AfterMethod
	public void setStatus(ITestResult result) {

		if (platformname.equalsIgnoreCase("SAUCEWebDriver")) {
			String resultFortest = result.isSuccess() ? "passed" : "failed";
			((RemoteWebDriver) driver).executeScript("sauce:job-result=" + resultFortest);
		}
	}
	
	@AfterClass
	public void close()
	{
		driver.close();
		driver.quit();
	}
	

}
