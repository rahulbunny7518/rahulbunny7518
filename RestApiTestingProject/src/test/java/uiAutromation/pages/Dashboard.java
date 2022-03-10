package uiAutromation.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.paulhammant.ngwebdriver.NgWebDriver;

public class Dashboard {
	
	private final WebDriver driver;
	
	@FindBy(xpath="//li[@id='menu_attendance_Attendance']/a/span[text()='Attendance']")
	private WebElement attendance;
	
	
	@FindBy(xpath="//span[text()='My Attendance Sheet']")
	private WebElement attendanceSheet;
	
	@FindBy(xpath="//span[text()='Punch In/Out']")
	private WebElement punchInOut;
	
	JavascriptExecutor js;
	NgWebDriver ngDriver;
	
	
	public Dashboard(WebDriver driver)
	{
		this.driver=driver;
		
		AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this);
		
		js=(JavascriptExecutor) driver;
		ngDriver=new NgWebDriver(js);
	}
	
	
	public Dashboard clickAttendanceButton()
	{
		this.attendance.click();
		return this;
	}
	

	//Navigating to attendance sheet
	public AttendanceSheet clickAttendanceSheetAndVerifyUrl() throws InterruptedException
	{
		this.attendanceSheet.click();
		
		assertTrue(driver.getCurrentUrl().endsWith("my_attendance_sheet"));
		//Thread.sleep(5000);
		//ngDriver.waitForAngularRequestsToFinish();
		
		return new AttendanceSheet(driver);
	}
	
	// Navigating to PunchInAndOutPage
	public PunchInAndOut clickPunchInOutAndVerifyUrl() throws InterruptedException {
		this.punchInOut.click();
		//Thread.sleep(5000);
		// assertTrue(driver.getCurrentUrl().endsWith("my_punch_in_out"));
		return new PunchInAndOut(driver);
	}

}
