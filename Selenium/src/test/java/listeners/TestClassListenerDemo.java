package listeners;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestAutomation.Selenium.OrangeHRMPOM.LoginPage;

@Listeners(TestListenerImpl.class)
public class TestClassListenerDemo {
	
	WebDriver driver;
	
	
	
	
	@BeforeClass
	//@Parameters("BrowserName")
	public void setup(ITestContext context) {
		driver = TestAutomation.Selenium.WebDriverFactory.getWebDriver("Firefox");
		
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		context.setAttribute("WebDriver",driver);

		
		
	}
	
	@Test
	public void testloginFunctionality() throws InterruptedException
	{

		LoginPage loginPage=new LoginPage(driver);
		
		loginPage.enterUserName("Admin")
					.enterPassword("U@qBLVtm09")
					.clickLoginButton();
		
		assertTrue(false);
		
	}

}
