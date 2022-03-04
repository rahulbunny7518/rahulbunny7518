package homeTasks;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import driverFactory.WebDriverFactoryProvider;
import pages.Dashboard;
import pages.LoginPage;

public class TestAdminTask {
	
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
	}
	
	@Test
	public void testAdminFunctionalityMethod() throws InterruptedException
	{
		LoginPage login=new LoginPage(driver);
		login.enterUserName(this.orangeHRMUsername)
			.enterPassword(this.orangeHRMPassword)
			.clickLoginButton();
		
		
		AdminTaskLoginPage admin=new AdminTaskLoginPage(driver);
		
		admin.clickAdminButton()
				.clickUserManagementButton()
				.clickUsersButton()
				.clickEditButton()
				.selectAdminDropDown()
				.selectGlobalAdmin()
				.clickSaveButton()
				.verifyingUserRoles()
				
				.clickEditButton()
				.selectAdminDropDown()
				.removingGlobalAdmin()
				.clickSaveButton()
				.verifyingUserRolesAfter();
		
		Dashboard logout=new Dashboard(driver);
		logout.logOut();
				
		
	}

}
