package TestAutomation.Selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Testdriver {
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
		driver.findElement(By.xpath("//input[@class='password-input']")).sendKeys("U@qBLVtm09");
		driver.findElement(By.xpath("//img[@class=\"icon login-icon\"]")).click();
		

	}



}