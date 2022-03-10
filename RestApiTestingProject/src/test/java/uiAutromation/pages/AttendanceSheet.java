package uiAutromation.pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paulhammant.ngwebdriver.NgWebDriver;

public class AttendanceSheet {
	
	private final WebDriver driver;
	
	@FindBy(xpath="//li[@id='date_2022-03-18']")
	private WebElement deleteButton;
	
	@FindBy(xpath="//div[text()='Total Time']/parent::span/div[@class='pay-hours-duration pay-hours-duration-0']")
	private WebElement totalPayhours;
	
	
	List<WebElement> deletedetails;
	
	@FindBy(xpath="//button[@data-icon='delete_forever']")
	private WebElement acceptingdeletePopUp;

	JavascriptExecutor js;
	NgWebDriver ngDriver;
	
	public AttendanceSheet(WebDriver driver)
	{

		
		this.driver=driver;
		
		AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
		
		js=(JavascriptExecutor) driver;
		ngDriver=new NgWebDriver(js);
	}
	

	
	public AttendanceSheet deletePunchInandPunchoutOperations() throws InterruptedException {
		this.deleteButton.click();
		Thread.sleep(6000);
		//ngDriver.waitForAngularRequestsToFinish();
		
		
		
		this.deletedetails=driver.findElements(By.xpath("//div[@class='timesheetDate'][(text()='18 Mar')]//parent::span//parent::div//parent::li//div[@aria-label='Delete']"));
		
		for(WebElement deleteoption:deletedetails) {
		
			deleteoption.click();
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-icon='delete_forever']")));
			acceptingdeletePopUp.click();
		}
		Thread.sleep(6000);
		//ngDriver.waitForAngularRequestsToFinish();
		return this;
	
	}
	
	

	static String payHoursBeforePunchInAndOut;
	static int totaltimebeforpunchinminutes;
	
	public AttendanceSheet getTotalHoursBeforePunchInAndOut()
	{
		payHoursBeforePunchInAndOut=this.totalPayhours.getText();
		System.out.println("Total time before punchin "+payHoursBeforePunchInAndOut);
		totaltimebeforpunchinminutes = HoursToMinutes.convertHoursToMinutes(payHoursBeforePunchInAndOut);
		System.out.println("Total time before conversion into minutes "+totaltimebeforpunchinminutes);
		
		return this;
	}
	
	static String payHoursAfterPunchInAndOut;
	static int totaltimeafterpunchinminutes;

	
	public AttendanceSheet getTotalHoursAfterPunchInAndOut()
	{
		payHoursAfterPunchInAndOut=this.totalPayhours.getText();
		System.out.println("Total time before punchin "+payHoursAfterPunchInAndOut);
		totaltimeafterpunchinminutes = HoursToMinutes.convertHoursToMinutes(payHoursAfterPunchInAndOut);
		System.out.println("Total time before conversion into minutes "+totaltimeafterpunchinminutes);
		
		return this;
	}
	
	
	public AttendanceSheet verifyTotalHours() {
		totaltimebeforpunchinminutes=totaltimebeforpunchinminutes+360;
		assertEquals(totaltimebeforpunchinminutes,totaltimeafterpunchinminutes);
		return this;
		}
	
	
	
}
