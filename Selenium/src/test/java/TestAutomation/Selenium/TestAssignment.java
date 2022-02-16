package TestAutomation.Selenium;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestAssignment {

	@Test
	public void login() throws InterruptedException {

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
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/section/div[2]/ui-view/div/div/crud-panel/div/div/list/table/tbody/tr[6]/td[8]/i")).click();
		

		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"modal-holder\"]/div/div/div/div[2]/form/oxd-decorator[3]/div/div[1]/div/div[2]/div/button")).click();
		driver.findElement(By.id("bs-select-3-2")).click();
		//save
		driver.findElement(By.id("modal-save-button")).click();
		
		Thread.sleep(5000);
		
		String str=driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/section/div[2]/ui-view/div/div/crud-panel/div/div/list/table/tbody/tr[6]/td[3]/ng-include/span")).getText();
		String arr[]=str.split(",");
		//System.out.println(arr[2]);
		assertEquals(arr[2]," Global Admin");
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/section/div[2]/ui-view/div/div/crud-panel/div/div/list/table/tbody/tr[6]/td[8]/i")).click();
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



		
		
		 //WebElement admindropdown=driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/form/oxd-decorator[3]/div/div[1]/div/div[1]/button/div/div/div"));
		 //Thread.sleep(3000);

		 //Select dropdown=new Select(admindropdown); 
		 //Thread.sleep(3000);
		 //dropdown.selectByIndex(1);
		 //dropdown.selectByVisibleText("Global Admin");
		 //Thread.sleep(3000);
		// driver.findElement(By.id("modal-save-button")).click();
		
		
		
		
		
		
		/*
		 * Actions actions= new Actions(driver); actions
		 * .moveToElement(driver.findElement(By.xpath(
		 * "/html/body/div[1]/div/div/div[2]/section/div[2]/ui-view/div/div/crud-panel/div/div/list/table/tbody/tr[6]/td[8]/i"
		 * ))).click().perform();
		 * 
		 * Actions actions2=new Actions(driver); actions2
		 * .moveToElement(driver.findElement(By.xpath("//button[@data-id='adminrole']"))
		 * ) .moveToElement(driver.findElement(By.xpath(
		 * "/html/body/div[3]/div/div/div/div[2]/form/oxd-decorator[3]/div/div[1]/div/div[1]/div/div/ul/li[3]/a/span"
		 * ))).click()
		 * .moveToElement(driver.findElement(By.xpath("//*[@id=\"modal-save-button\"]"))
		 * ).click().perform();
		 */
		
		
		
		
		
		
		//driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/section/div[2]/ui-view/div/div/crud-panel/div/div/list/table/tbody/tr[6]/td[8]/i")).click();
		
		//List<WebElement> arr=(List<WebElement>) driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/section/div[2]/ui-view/div/div/crud-panel/div/div/list/table/tbody/tr[6]/td[3]/ng-include/span"));
		
		//String value=arr.get(3).getText();
		//assertEquals(value,"Global Admin");
		
		/*
		 * Actions actions=new Actions(driver); actions
		 * .moveToElement(driver.findElement(By.xpath(
		 * "/html/body/div[3]/div/div/div/div[2]/form/oxd-decorator[3]/div/div[1]/div/div[2]/div/button/i[2]"
		 * ))) .moveToElement(driver.findElement(By.xpath(
		 * "//*[@id=\\\"modal-save-button\\\"]"))).click() .build().perform();
		 */
		
		/*
		 * String homeWindow=driver.getWindowHandle(); Set<String>
		 * windows=driver.getWindowHandles();
		 * 
		 * driver.switchTo().window(windows.toArray()[1].toString());
		 */
		
		
		 


		

	}

}
