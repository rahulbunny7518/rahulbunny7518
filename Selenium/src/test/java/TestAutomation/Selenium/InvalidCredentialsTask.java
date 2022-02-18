package TestAutomation.Selenium;

import static org.testng.Assert.assertEquals;

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
		driver = WebDriverFactory.getWebDriver(BrowserName);
		
	}
	@Test
	public void testdriver() {
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@class='password-input']")).sendKeys("U@qBLVtm0");
		driver.findElement(By.xpath("//img[@class=\"icon login-icon\"]")).click();

		
		assertEquals("https://prasoonr-trials73.orangehrmlive.com/securityAuthentication/retryLogin", driver.getCurrentUrl());

	}

}
