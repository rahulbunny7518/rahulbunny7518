package TestAutomation.Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TestExplicit {
	
	
	@Test
	public void method() throws InterruptedException
	{
		//String driverPath = "C:\\Users\\Rahul_Narendhula\\Documents\\browsers\\geckodriver-v0.30.0-win64\\geckodriver.exe";
		//System.setProperty("webdriver.gecko.driver", driverPath);
		//WebDriver driver = new FirefoxDriver();
		
		WebDriver driver=util.DriverUtil.getBrowserInstance("firefox");
		driver.manage().window().maximize();
	

		driver.get("https://prasoonr-trials73.orangehrmlive.com/");

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@class='password-input']")).sendKeys("U@qBLVtm09");
		driver.findElement(By.xpath("//img[@class=\"icon login-icon\"]")).click();
		
		driver.findElement(By.partialLinkText("Admin")).click();
		driver.findElement(By.partialLinkText("User Management")).click();
		
		driver.findElement(By.partialLinkText("Users")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td/ng-include[span='amanda']/parent::td/parent::tr//i['ohrm_edit']"))).click();

		
	
		//driver.findElement(By.xpath("//td/ng-include[span='amanda']/parent::td/parent::tr//i['ohrm_edit']")).click();
		
		Thread.sleep(5000);
		
		WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"modal-holder\"]/div/div/div/div[2]/form/oxd-decorator[3]/div/div[1]/div/div[2]/div/button"))).click();
		driver.findElement(By.id("bs-select-3-2")).click();
		
		driver.findElement(By.id("modal-save-button")).click();
		
	}
	

}
