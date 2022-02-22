package TestAutomation.Selenium;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LeaveTask {
	
	
	
	
	/*
	 * WebDriver driver;
	 * 
	 * @BeforeTest
	 * 
	 * @Parameters("BrowserName") public void setup(String BrowserName) {
	 * driver=WebDriverFactory.getWebDriver(BrowserName);
	 * 
	 * }
	 */
	 
	 
	
	
	@Test
	public void applyLeave() throws InterruptedException
	{

		
		WebDriver driver=WebDriverFactory.getWebDriver("Firefox");
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@class='password-input']")).sendKeys("U@qBLVtm09");
		driver.findElement(By.xpath("//img[@class=\"icon login-icon\"]")).click();
		
		
		driver.findElement(By.partialLinkText("Leave")).click();
		driver.findElement(By.partialLinkText("Apply")).click();
		
	
		Thread.sleep(10000);
		
		

		driver.findElement(By.xpath("//input[@value='-- Select --']")).click();
		
		driver.findElement(By.xpath("//li/span[contains(text(),'Sick Leave - US')]")).click();
		
		driver.findElement(By.xpath("//input[contains(@id,'from')]")).sendKeys("Mon, 21 Feb 2022");
		
		driver.findElement(By.xpath("//input[contains(@id,'to')]")).click();
		driver.findElement(By.xpath("//input[contains(@id,'to')]")).clear();

		
		driver.findElement(By.xpath("//input[contains(@id,'to')]")).sendKeys("Mon, 28 Feb 2022");
		
		String temp=driver.findElement(By.xpath("//span[contains(text(),'From date should be before to date')]")).getText();
		System.out.println(temp);
		assertEquals(temp, "From date should be before to date");
		
		
		driver.findElement(By.xpath("//textarea[contains(@id,'comment')]")).sendKeys("Leave");
		
		driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
		
		
		
		
		//driver.findElement(By.xpath("//td/div[@aria-label='Tue, 22 Feb 2022'][@data-pick='1645468200000'][contains(text(),'22')]")).click();
		
		//driver.findElement(By.xpath("//td/div[@aria-label='Wed, 02 Feb 2022'][contains(text(),'2')]")).click();
		//driver.findElement(By.xpath("//input[@id='from']")).sendKeys("Mon, 21 Feb 2022");
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//input[@id='to']")).sendKeys("Mon, 28 Feb 2022");
		
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='to']"))).sendKeys("Tue, 01 Feb 2022");
		
		//String temp=driver.findElement(By.xpath("//span[contains(text(),'From date should be before to date')]")).getText();
		//System.out.println(temp);
		//assertEquals(temp, "From date should be before to date");
		

		//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/section/div[2]/ui-view/div/div/form/div[1]/materializecss-decorator[1]/div/sf-decorator[1]/div/div/ul/li[1]/span"))).click();
			
		
		
		
		
		
		
		//WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(50));
		//wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/section/div[2]/ui-view/div/div/form/div[1]/materializecss-decorator[1]/div/sf-decorator[1]/div/div/ul/li[1]/span"))).click();
		
		//driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/section/div[2]/ui-view/div/div/form/div[1]/materializecss-decorator[1]/div/sf-decorator[1]/div/div/input")).click();
		//driver.findElement(By.partialLinkText("Sick Leave - US")).click();

	}

}
