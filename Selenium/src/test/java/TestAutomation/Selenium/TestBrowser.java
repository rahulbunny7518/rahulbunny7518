package TestAutomation.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestBrowser {
	
	@Test
	public void LoadWebDriverUsingXpath() {

		String driverPath = "C:\\Users\\Rahul_Narendhula\\Documents\\browsers\\geckodriver-v0.30.0-win64\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.orangehrm.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id=\"myText\"]")).sendKeys("abc@xyz.com");
		driver.findElement(By.xpath("//input[@id=\"linkadd\"]")).click();
		
		
		driver.findElement(By.id("Form_submitForm_subdomain")).sendKeys("https:abc.com");
		driver.findElement(By.id("Form_submitForm_Name")).sendKeys("Don't worry");
		driver.findElement(By.id("Form_submitForm_Contact")).sendKeys("9575759859");
		
			
		WebElement testDropdown=driver.findElement(By.xpath("//select[@id='Form_submitForm_Country']"));
		Select dropdown=new Select(testDropdown);
		dropdown.selectByVisibleText("India");
		
		
		  WebElement testdrop=driver.findElement(By.id("Form_submitForm_State"));
		  Select drop=new Select(testdrop); 
		  drop.selectByVisibleText("Telangana");
		  
		  //driver.findElement(By.id("recaptcha-anchor-label")).click(); //captcha wont works

		  //driver.findElement(By.id("Form_submitForm_action_request")).click();
		  
		  driver.findElement(By.xpath("//a[@href='/contact-sales/']")).click();
		  driver.findElement(By.id("Form_submitForm_FullName")).sendKeys("abcdef");
		  driver.findElement(By.id("Form_submitForm_CompanyName")).sendKeys("Company123");
		  driver.findElement(By.id("Form_submitForm_JobTitle")).sendKeys("Automation");
		  
		  WebElement dp=driver.findElement(By.id("Form_submitForm_NoOfEmployees"));
		  Select ddown=new Select(dp);
		  ddown.selectByIndex(1);
		  
		  driver.findElement(By.id("Form_submitForm_Contact")).sendKeys("11234567890");
		  driver.findElement(By.id("Form_submitForm_Email")).sendKeys("abc@gmail.com");
		  driver.findElement(By.id("Form_submitForm_Comment")).sendKeys("tets automation ");

		  

		  
		 
	}
	
	
	
	
	//@Test
	public void login()
	{

		String driverPath = "C:\\Users\\Rahul_Narendhula\\Documents\\browsers\\geckodriver-v0.30.0-win64\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		WebDriver driver = new FirefoxDriver();
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@class='password-input']")).sendKeys("U@qBLVtm09");
		driver.findElement(By.xpath("//img[@class=\"icon login-icon\"]")).click();
		
		Actions actions=new Actions(driver);
		//actions.moveToElement(driver.findElement(By.))

		
	}
	
	
	
	/*
	 * public void locateUsingId() { String driverPath =
	 * "C:\\Users\\Rahul_Narendhula\\Documents\\browsers\\geckodriver-v0.30.0-win64\\geckodriver.exe";
	 * System.setProperty("webdriver.gecko.driver", driverPath); WebDriver driver =
	 * new FirefoxDriver(); driver.get("https://www.orangehrm.com/");
	 * driver.findElement(By.id("myText")).sendKeys("123@gmail.com");
	 * driver.findElement(By.id("linkadd")).click(); }
	 */

}
