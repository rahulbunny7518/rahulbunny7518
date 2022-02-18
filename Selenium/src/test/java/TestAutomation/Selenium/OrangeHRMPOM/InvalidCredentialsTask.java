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
		
		
		
		driver.get("https://prasoonr-trials73.orangehrmlive.com/client/#/pim/employees/13/personal_details");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@class='password-input']")).sendKeys("U@qBLVtm09");
		driver.findElement(By.xpath("//img[@class=\"icon login-icon\"]")).click();
		
		Thread.sleep(20000);
		
		driver.findElement(By.xpath("//label[@for='30_Yes']")).click();
		driver.findElement(By.xpath("//label[@for='26Dairy-Free']")).click();
		driver.findElement(By.xpath("//label[@for='26Gluten-Free']")).click();
		
		
	}
		

	

}
