package TestAutomation.Selenium.OrangeHRMPOM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LeaveLoginPageTest {
	
WebDriver driver;
	

@BeforeTest
@Parameters("BrowserName")
public void setup(@Optional("Chrome") String BrowserName) {
	driver = TestAutomation.Selenium.WebDriverFactory.getWebDriver(BrowserName);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://prasoonr-trials73.orangehrmlive.com/");
	driver.manage().window().maximize();

	
	
}

	
	@Test(priority=1)
	public void testLeaveApply() throws InterruptedException
	{
		


		LeaveApplyLoginPage loginPage=new LeaveApplyLoginPage(driver);
		
		loginPage.
		enterUserName("Admin")
		.enterPassword("U@qBLVtm09")
		.clickLoginButton()
		.clickLeaveButton()
					.clickApplyButton()
					.clickLeaveType()
					.clickSickLeave()
					.sendFromDate("Mon, 21 Feb 2022")
					.sendToDate("Wed, 02 Feb 2022")
					.validatingErrorMessage()
					.sendFromDate("Mon, 21 Feb 2022")
					.sendToDate("Mon, 28 Feb 2022")
					.sendComment()
					.clickApplyButtonSubmit()
					.verifyingPopupMessage()
					.closingPopup()
					.clickingLeaveBalancePopup()
					.verifyingAvailableBalance()
					.closingLeaveBalancePopup();
					
	}
	
	@Test(priority=2)
	public void testLeaveList()
	{
		LeaveListLogin leaveList=new LeaveListLogin(driver);
		leaveList.clickLeaveButton()
		.clickLeaveListButton()
		.enterFromDate("Thu, 20 Jan 2022")
		.selectSubUnit()
		.selectArchitecture()
		.selectAll()
		.searchClick()
		.verifyRecordsNotFound();
	}


}
