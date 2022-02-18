package TestAutomation.Selenium;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestAssign2 {
	
	@Test
	public void method() throws InterruptedException
	{
		String driverPath = "C:\\Users\\Rahul_Narendhula\\Documents\\browsers\\geckodriver-v0.30.0-win64\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://prasoonr-trials73.orangehrmlive.com/");

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@class='password-input']")).sendKeys("U@qBLVtm09");
		driver.findElement(By.xpath("//img[@class=\"icon login-icon\"]")).click();
		
		
		driver.findElement(By.partialLinkText("Admin")).click();
		driver.findElement(By.partialLinkText("User Management")).click();
		driver.findElement(By.partialLinkText("Users")).click();
		
		
		driver.findElement(By.xpath("//td/ng-include[span='amanda']/parent::td/parent::tr//i['ohrm_edit']")).click();
		Thread.sleep(5000);
		

		driver.findElement(By.xpath("//*[@id=\"modal-holder\"]/div/div/div/div[2]/form/oxd-decorator[3]/div/div[1]/div/div[2]/div/button")).click();
		driver.findElement(By.id("bs-select-3-2")).click();
		
		driver.findElement(By.id("modal-save-button")).click();
		
		Thread.sleep(5000);
	
		
		String str=driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/section/div[2]/ui-view/div/div/crud-panel/div/div/list/table/tbody/tr[6]/td[3]/ng-include/span")).getText();
		String arr[]=str.split(",");
		//System.out.println(arr[2]);
		assertEquals(arr[2]," Global Admin");
		
		
		
		driver.findElement(By.xpath("//td/ng-include[span='amanda']/parent::td/parent::tr//i['ohrm_edit']")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/form/oxd-decorator[3]/div/div[1]/div/div[2]/div/button/i[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"bs-select-6-0\"]")).click();
		driver.findElement(By.id("modal-save-button")).click();
		
		Thread.sleep(5000);
	
		String str2=driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/section/div[2]/ui-view/div/div/crud-panel/div/div/list/table/tbody/tr[6]/td[3]/ng-include/span")).getText();
		String arr2[]=str2.split(",");
		assertEquals(arr2.length,2);
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div[2]/div[1]/div/div[2]/a/span[2]/i")).click();
		driver.findElement(By.id("logoutLink")).click();




	}
}
