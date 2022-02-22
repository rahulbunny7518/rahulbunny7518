package TestAutomation.Selenium.OrangeHRMPOM;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LeaveListLogin {
	private final WebDriver driver;

	public LeaveListLogin(WebDriver driver) {

		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);
		// PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Leave")
	private WebElement leaveButton;
	
	@FindBy(xpath="//span[text()='Leave List']")
	private WebElement leaveListButton;

	@FindBy(xpath = "//input[contains(@id,'from')]")
	private WebElement SelectFromDate;

	@FindBy(xpath = "//label[contains(.,'All')]")
	private WebElement ShowLeaveStatuscCheckBoxAll;

	@FindBy(xpath = "//*[@id=\"subunit_inputfileddiv\"]/div/input")
	private WebElement SubunitDropDown;

	@FindBy(xpath = "//span[contains(.,'Architecture Team')]")
	private WebElement Architecture;

	@FindBy(xpath = "//button[contains(.,'Search')]")
	private WebElement searchbutton;

	@FindBy(xpath = "//div[@class='toast-message'][contains(.,'No Records Found')]")
	private WebElement ToastMessage;
	
	public LeaveListLogin clickLeaveButton()
	{
		this.leaveButton.click();
		return this;
	}
	
	public LeaveListLogin clickLeaveListButton()
	{
		this.leaveListButton.click();
		return this;
	}

	public LeaveListLogin enterFromDate(String fromdate) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.SelectFromDate.click();
		this.SelectFromDate.clear();
		this.SelectFromDate.sendKeys(fromdate);
		return this;

	}

	public LeaveListLogin selectSubUnit() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.SubunitDropDown.click();
		return this;
	}

	public LeaveListLogin selectArchitecture() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.Architecture.click();
		return this;
	}

	public LeaveListLogin selectAll() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.ShowLeaveStatuscCheckBoxAll.click();
		return this;
	}

	public LeaveListLogin searchClick() {

		this.searchbutton.click();
		return this;
	}

	public LeaveListLogin verifyRecordsNotFound() {
		Boolean result = this.ToastMessage.isDisplayed();
		assertTrue(result);
		return this;
	}

}