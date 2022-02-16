package TestAutomation.Selenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task {
	
	
	WebDriver driver;
	
	
	@BeforeClass
	public void setup()
	{
		String driverPath = "C:\\Users\\Rahul_Narendhula\\Documents\\browsers\\geckodriver-v0.30.0-win64\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}
	
	
	@Test
	public void todo()
	{
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");

	}
	
	
	
	
	
	
	
	@AfterClass
	public void after()
	{
		driver.close();
	}
	
	

}
