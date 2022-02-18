package TestAutomation.Selenium.OrangeHRMPOM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RadiobuttonTask {
	
	WebDriver driver;
	
	@BeforeTest
	@Parameters("BrowserName")
	public void setup(String BrowserName) {
		driver = TestAutomation.Selenium.WebDriverFactory.getWebDriver(BrowserName);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	@Test
	public void testRadioandCheckbox() throws InterruptedException
	{
		driver.get("https://prasoonr-trials73.orangehrmlive.com/client/#/pim/employees/13/personal_details");
		
		LoginPage loginPage=new LoginPage(driver);
		
		loginPage.enterUserName("Admin")
					.enterPassword("U@qBLVtm09")
					.clickLoginButton()
					.clickRadioButton()
					.clickCheckBox1()
					.clickCheckBox2();
	}

}
