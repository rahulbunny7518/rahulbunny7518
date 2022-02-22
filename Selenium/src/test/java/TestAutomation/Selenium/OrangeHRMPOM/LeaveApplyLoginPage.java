package TestAutomation.Selenium.OrangeHRMPOM;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeaveApplyLoginPage {

	//Leave Assignment 

	private final WebDriver driver;
	
	
	@FindBy(id = "txtUsername")
	private WebElement userName;

	@FindBy(id = "txtPassword")
	private WebElement password;
	
	@FindBy(xpath="//img[@class=\"icon login-icon\"]")
	private WebElement loginButton;

	



	@FindBy(linkText="Leave")
	private WebElement leaveButton;

	@FindBy(linkText="Apply")
	private WebElement applyButton;

	@FindBy(xpath="//input[@class='select-dropdown']")
	private WebElement leaveType;

	@FindBy(xpath="//li/span[contains(text(),'Sick Leave - US')]")
	private WebElement sickLeave;


	@FindBy(xpath="//input[@id='from']")
	private WebElement fromDate;
	
	
	@FindBy(xpath="//input[@id='to']")
	private WebElement toDate;
	
	@FindBy(xpath="//span[text()='From date should be before to date']")
	private WebElement errorMessage;
	
	@FindBy(xpath="//div/textarea[@id='comment']")
	private WebElement comment;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement applyButtonSubmit;
	
	@FindBy(xpath="//h4[text()='Overlapping Leave Request Found']")
	private WebElement popupMessage;
	
	@FindBy(xpath="//a[text()='Close']")
	private WebElement closePopup;
	
	@FindBy(xpath="//a[text()='Check Leave Balance']")
	private WebElement leaveBalance;
	
	@FindBy(xpath="//span[text()='0.00']")
	private WebElement availableBalance;
	
	@FindBy(xpath="//a[text()='Close']")
	private WebElement leaveBalancePopup;
	

	
	public LeaveApplyLoginPage(WebDriver driver) {

		this.driver = driver;

		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);

	}
	
	
	
	public LeaveApplyLoginPage enterUserName(String userName)
	{
		this.userName.sendKeys(userName);
		return this;
	}

	public LeaveApplyLoginPage enterPassword(String password)
	{
		this.password.sendKeys(password);
		return this;
	}

	public LeaveApplyLoginPage clickLoginButton() throws InterruptedException
	{
		this.loginButton.click();
		//this.form.submit();
		return this;
	}
	
	
	
	
	


	public LeaveApplyLoginPage clickLeaveButton()
	{
		this.leaveButton.click();
		return this;
	}

	public LeaveApplyLoginPage clickApplyButton() throws InterruptedException
	{
		this.applyButton.click();
		Thread.sleep(10000);
		return this;
	}
	public LeaveApplyLoginPage clickLeaveType()
	{
		this.leaveType.click();
		return this;
	}
	public LeaveApplyLoginPage clickSickLeave()
	{
		this.sickLeave.click();
		return this;
	}
	
	public LeaveApplyLoginPage sendFromDate(String fromDate) throws InterruptedException 
	{
		Thread.sleep(5000);

		
		/*
		 * try { Thread.sleep(5000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

		
		this.fromDate.click();
		this.fromDate.clear();
		this.fromDate.sendKeys(fromDate);
		
		
		
		return this;
	}
	
	
	
	public LeaveApplyLoginPage sendToDate(String toDate) throws InterruptedException  
	{
		Thread.sleep(5000);

		/*
		 * try { Thread.sleep(5000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		
		
		this.toDate.click();
		this.toDate.clear();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'to')]")));
		//this.ToDateInput.sendKeys(todate);
	
		this.toDate.sendKeys(toDate);
		
		

		return this;
	}
	
	public LeaveApplyLoginPage validatingErrorMessage() 
	{
		this.fromDate.click();//without this date is not updating and error message is not displaying 
		
		String error=this.errorMessage.getText();
		System.out.println(error);
		assertNotNull(error);
		assertEquals(error, "From date should be before to date");
		
		String errorColor=this.errorMessage.getCssValue("color");
		assertEquals(errorColor, "rgba(244, 67, 54, 1)");
		
		
		
		return this;
	}
	
	public LeaveApplyLoginPage sendComment()
	{
		this.comment.click();
		this.comment.sendKeys("Applying Leave");
		return this;
	}
	
	public LeaveApplyLoginPage clickApplyButtonSubmit() throws InterruptedException
	{
		this.applyButtonSubmit.click();
		Thread.sleep(5000);
		return this;
	}
	
	public LeaveApplyLoginPage verifyingPopupMessage()
	{
		String popupText=this.popupMessage.getText();
		
		assertNotNull(popupText);
		assertEquals(popupText, "Overlapping Leave Request Found");
		
		return this;
	}
	
	
	public LeaveApplyLoginPage closingPopup()
	{
		this.closePopup.click();
		return this;
	}
	
	public LeaveApplyLoginPage clickingLeaveBalancePopup()
	{
		this.leaveBalance.click();
		return this;
	}
	
	public LeaveApplyLoginPage verifyingAvailableBalance()
	{
		String balanceDays=this.availableBalance.getText();
		assertNotNull(balanceDays);
		
		assertEquals(balanceDays, "0.00");
		return this;
	}
	
	public LeaveApplyLoginPage closingLeaveBalancePopup()
	{
		this.leaveBalancePopup.click();
		return this;
	}
	





}
