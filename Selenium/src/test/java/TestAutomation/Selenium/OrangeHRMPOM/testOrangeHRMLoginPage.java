package TestAutomation.Selenium.OrangeHRMPOM;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import TestAutomation.Selenium.WebDriverFactory;

public class testOrangeHRMLoginPage {
	
WebDriver driver;
	
	@BeforeTest
	@Parameters("BrowserName")
	public void setup(String BrowserName) {
		driver = WebDriverFactory.getWebDriver(BrowserName);
		
	}
	
	@Test
	public void testloginFunctionality() throws InterruptedException
	{
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");

		LoginPage loginPage=new LoginPage(driver);
		
		loginPage.enterUserName("Admin")
					.enterPassword("U@qBLVtm09")
					.clickLoginButton()
					.printElementInputFields();
		
	}
	
	//@Test(priority=2)
	public void testLoginFunctionalityWithoutEnteringEachElement() throws InterruptedException
	{
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");

		LoginPage loginPage=new LoginPage(driver);
		loginPage.login("Admin", "U@qBLVtm09");
		
	}

}
