package TestAutomation.Selenium.OrangeHRMPOM;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LeaveAssignment {
	
WebDriver driver;
	
	@BeforeTest
	@Parameters("BrowserName")
	public void setup(String BrowserName) {
		driver = TestAutomation.Selenium.WebDriverFactory.getWebDriver(BrowserName);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	@Test
	public void testLeaveTask() throws InterruptedException
	{
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");

		LoginPage loginPage=new LoginPage(driver);
		
		loginPage.enterUserName("Admin")
					.enterPassword("U@qBLVtm09")
					.clickLoginButton()
					.clickLeaveButton()
					.clickApplyButton()
					.clickLeaveType()
					.clickSickLeave()
					.clickfromDateDropdown()
					.clickfromDate()
					.clicktoDateDropdown()
					.clicktoDate();
		
		//assertEquals(driver.findElement(By.linkText("From date should be before to date")).getText();), "From date should be before to date");
		assertNotNull(driver.findElement(By.linkText("From date should be before to date")));
	}


}
