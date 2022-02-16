package TestAutomation.Selenium;

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
		//String driverPath2 = "C:\\Users\\Rahul_Narendhula\\Documents\\browsers\\chromedriver_win32\\chromedriver.exe";
		//System.setProperty("webdriver.chrome.driver", driverPath2);
		//WebDriver driver = new ChromeDriver();
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@class='password-input']")).sendKeys("U@qBLVtm09");
		driver.findElement(By.xpath("//img[@class=\"icon login-icon\"]")).click();
		
		driver.findElement(By.partialLinkText("Admin")).click();
		driver.findElement(By.partialLinkText("User Management")).click();
		driver.findElement(By.partialLinkText("Users")).click();
		//driver.findElement(By.xpath("//div[@id='preloader']")).click();
		
		Thread.sleep(24000);
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/section/div[2]/ui-view/div/div/crud-panel/div/div/list/table/tbody/tr[6]/td[9]/i")).click();
		
		
		Thread.sleep(3000);
		WebElement admindropdown = driver.findElement(By.xpath(
				"/html/body/div[3]/div/div/div/div[2]/form/oxd-decorator[3]/div/div[1]/div/div[1]/button/div/div/div"));
		Thread.sleep(3000);

		Select dropdown = new Select(admindropdown);
		Thread.sleep(3000);
		dropdown.selectByIndex(1);
		//dropdown.selectByVisibleText("Global Admin");
		Thread.sleep(3000);
		driver.findElement(By.id("modal-save-button")).click();

	}
}
