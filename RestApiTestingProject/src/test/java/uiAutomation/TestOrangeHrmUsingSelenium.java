package uiAutomation;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import driverFactory.WebDriverFactoryProvider;
import uiAutromation.pages.AttendanceSheet;
import uiAutromation.pages.Dashboard;
import uiAutromation.pages.Login;
import uiAutromation.pages.PunchInAndOut;

public class TestOrangeHrmUsingSelenium {
	

	private WebDriver driver;
	private String browserName; 
	private String orangeHRMUsername;
	private String orangeHRMPassword;
	private String platformname;

	
	
	@BeforeClass
	public void setup(ITestContext context) throws MalformedURLException
	{
		browserName=context.getCurrentXmlTest().getParameter("BrowserName");
		platformname=context.getCurrentXmlTest().getParameter("OrangeHRMTestExecutionPlatform");
		
		String orangeHRMURL=context.getCurrentXmlTest().getParameter("OrangeHRMBaseURL");
		this.orangeHRMUsername=context.getCurrentXmlTest().getParameter("OrangeHRMUsername");
		this.orangeHRMPassword=context.getCurrentXmlTest().getParameter("OrangeHRMPassword");
		
		driver=WebDriverFactoryProvider.getWebDriverFactory(platformname).getWebDriver(browserName);
		
		driver.get(orangeHRMURL);
		driver.manage().window().maximize();
	}
	
	
	@Test(priority=1)
	public void testLoginPage()
	{
		Login login=new Login(driver);
		login.enterUsername(orangeHRMUsername)
				.enterPassword(orangeHRMPassword)
				.clickLoginButton();
	}
	
	@Test(priority=2)
	public void testDeletePunchInOutRecordsAndGetTotalHoursBeforePunch() throws InterruptedException
	{
		Dashboard dashboard=new Dashboard(driver);
		dashboard.clickAttendanceButton()
					.clickAttendanceSheetAndVerifyUrl() //this method will navigate to AttendanceSheet Page
		
					.deletePunchInandPunchoutOperations()

					.getTotalHoursBeforePunchInAndOut();
	}
	
	@Test(priority=3)
	public void testPunchInOutAndVerifyPunchOutTimeGreaterThanPunchInTime() throws InterruptedException
	{
		Dashboard dashboard=new Dashboard(driver);

		dashboard.clickPunchInOutAndVerifyUrl() //this method will navigate to PunchInAndOut page 
		
					.providingPunchIn("Fri, 18 Mar 2022", "10:00")
					.verifyPunchOutTimeShouldbeGreaterThanPunchInTime("Fri, 18 Mar 2022", "09:00")
					.providingPunchOut("Fri, 18 Mar 2022", "16:00");
					
		
	}
	

	@Test(priority=4)
	public void testOverlappingMessage() throws InterruptedException
	{
		
		PunchInAndOut punchInAndOut=new PunchInAndOut(driver);
		punchInAndOut
					 .overlappingMessageVerification("10:01");
	}
	
	
	
	@Test(priority=5)
	public void testTotalHoursAfterPunchAndVerify() throws InterruptedException
	{
		Dashboard dashboard=new Dashboard(driver);
		dashboard 
				.clickAttendanceSheetAndVerifyUrl()//This method will navigate to AttendanceSheet Page
		
			   .getTotalHoursAfterPunchInAndOut()
			   .deletePunchInandPunchoutOperations()
			   .verifyTotalHours();
	}
	
}
