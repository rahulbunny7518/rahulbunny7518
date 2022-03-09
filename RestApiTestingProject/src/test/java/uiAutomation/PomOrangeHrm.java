package uiAutomation;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PomOrangeHrm {
	
	private final WebDriver driver;
	
	@FindBy(id="txtUsername")
	private WebElement username;
	
	@FindBy(id="txtPassword")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement login;
	
	@FindBy(xpath="//li[@id='menu_attendance_Attendance']/a/span[text()='Attendance']")
	private WebElement attendance;
	
	@FindBy(xpath="//span[text()='My Attendance Sheet']")
	private WebElement attendanceSheet;
	
	//@FindBy(xpath="//div/button[@data-id='attendanceSheet']")
    //private WebElement periodDropdown;
	
	@FindBy(xpath="//span[text()='Punch In/Out']")
	private WebElement punchInOut;
	
	@FindBy(xpath="//div/button[@data-id='attendanceSheet']")
	private WebElement punchInOutDate;
	
	@FindBy(xpath="//input[@id='time']")
	private WebElement punchInOutTime;
	
	@FindBy(xpath="//button[text()='In']")
	private WebElement inButton;
	
	@FindBy(xpath="//button[text()='Out']")
	private WebElement outButton;
	
	
	
	public PomOrangeHrm(WebDriver driver)
	{
		this.driver=driver;
		
		AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}
	
	
	public PomOrangeHrm enterUsername(String username)
	{
		this.username.sendKeys(username);
		return this;
		
	}
	
	public PomOrangeHrm enterPassword(String password)
	{
		this.password.sendKeys(password);
		return this;
		
	}
	
	public PomOrangeHrm clickLoginButton()
	{
		this.login.click();
		assertTrue(driver.getCurrentUrl().endsWith("dashboard"));
		
		return this;
	}
	
	public PomOrangeHrm clickAttendanceButton()
	{
		this.attendance.click();
		return this;
	}
	
	public PomOrangeHrm clickAttendanceSheetAndVerifyUrl() throws InterruptedException
	{
		this.attendanceSheet.click();
		
		assertTrue(driver.getCurrentUrl().endsWith("my_attendance_sheet"));
		Thread.sleep(5000);
		return this;
	}
	
	
	public PomOrangeHrm clickPunchInOutAndVerifyUrl() throws InterruptedException
	{
		this.punchInOut.click();
		Thread.sleep(5000);
		//assertTrue(driver.getCurrentUrl().endsWith("my_punch_in_out"));
		return this;
	}
	
	public PomOrangeHrm providingPunchIn(String punchInDate,String punchInTime) throws InterruptedException
	{
		this.punchInOutDate.click();
		this.punchInOutDate.clear();
		
		this.punchInOutDate.sendKeys(punchInDate);
		
		this.punchInOutTime.click();
		this.punchInOutTime.clear();
		
		this.punchInOutTime.sendKeys(punchInTime);
		this.inButton.click();
		Thread.sleep(5000);
		return this;
	}
	
	
	public PomOrangeHrm providingPunchOut(String punchOutDate,String punchOutTime) throws InterruptedException
	{
		this.punchInOutDate.click();
		this.punchInOutDate.clear();
		
		this.punchInOutDate.sendKeys(punchOutDate);
		

		this.punchInOutTime.click();
		this.punchInOutTime.clear();
		
		this.punchInOutTime.sendKeys(punchOutTime);
		this.outButton.click();
		Thread.sleep(5000);
		return this;
	}
	

}
