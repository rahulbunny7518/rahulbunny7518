package uiAutromation.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class PunchInAndOut {
	
	private final WebDriver driver;
	
	@FindBy(xpath="//input[@id='date']")
	private WebElement punchInOutDate;
	
	@FindBy(xpath="//input[@id='time']")
	private WebElement punchInOutTime;
	
	@FindBy(xpath="//button[text()='In']")
	private WebElement inButton;
	
	@FindBy(xpath="//button[text()='Out']")
	private WebElement outButton;
	
	
	@FindBy(xpath="//span[text()='Overlapping records found']")
	private WebElement overlappingMessage;
	
	public PunchInAndOut(WebDriver driver)
	{
		this.driver=driver;
		AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}
	
	
	
	public PunchInAndOut providingPunchIn(String punchInDate,String punchInTime) throws InterruptedException
	{
		
		this.punchInOutDate.click();
		this.punchInOutDate.clear();
		
		this.punchInOutDate.sendKeys(punchInDate);
		
		this.punchInOutTime.click();
		this.punchInOutTime.clear();
		
		this.punchInOutTime.sendKeys(punchInTime);
		Thread.sleep(5000);
		this.inButton.click();
		Thread.sleep(5000);
		return this;
	}
	
	
	public PunchInAndOut providingPunchOut(String punchOutDate,String punchOutTime) throws InterruptedException
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
	
	
	public PunchInAndOut overlappingMessageVerification(String message,String punchInTime)
	{
		this.punchInOutTime.click();
		this.punchInOutTime.clear();
		
		this.punchInOutTime.sendKeys(punchInTime);
		
		String overlappingMessage=this.overlappingMessage.getText();
		System.out.println(overlappingMessage);
		assertEquals(overlappingMessage, message);
		return this;
	}
	
	

}
