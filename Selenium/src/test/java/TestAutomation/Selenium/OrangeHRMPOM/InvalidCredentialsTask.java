package TestAutomation.Selenium.OrangeHRMPOM;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class InvalidCredentialsTask {
	
	WebDriver driver;
	@BeforeTest
	@Parameters("BrowserName")
	public void setup(String BrowserName) {
		driver = TestAutomation.Selenium.WebDriverFactory.getWebDriver(BrowserName);
		
	}
	
	@Test
	public void testLoginFunctionalityForWrongPassword() throws InterruptedException
	{
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		LoginPage loginPage=new LoginPage(driver);
		
		loginPage.enterUserName("Admin")
					.enterPassword("U2hdhdhj")
					.clickLoginButton();
		assertTrue(driver.getCurrentUrl().endsWith("securityAuthentication/retryLogin"));
		
		assertNotNull(driver.findElement(By.xpath("//*[@class='col s12']")));
		
		
		
		
	}
		

	

}
