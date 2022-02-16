package TestAutomation.Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LeaveTask {
	
	
	WebDriver driver;
	@Test
	public void applyLeave()
	{

		
		driver=WebDriverFactory.getWebDriver("Firefox");
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@class='password-input']")).sendKeys("U@qBLVtm09");
		driver.findElement(By.xpath("//img[@class=\"icon login-icon\"]")).click();
		
		
		driver.findElement(By.partialLinkText("Leave")).click();
		driver.findElement(By.partialLinkText("Apply")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/section/div[2]/ui-view/div/div/form/div[1]/materializecss-decorator[1]/div/sf-decorator[1]/div/div/ul/li[1]/span"))).click();
		
		//driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/section/div[2]/ui-view/div/div/form/div[1]/materializecss-decorator[1]/div/sf-decorator[1]/div/div/ul/li[1]/span")).click();
		driver.findElement(By.partialLinkText("Sick Leave - US")).click();

	}

}
