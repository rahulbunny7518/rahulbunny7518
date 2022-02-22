package actionsandJS;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeaveList {
	
	private final WebDriver driver;
	
	@FindBy(className = "action-comment")
	private WebElement commentAction;

	@FindBy(className = "modal-close")
	private WebElement modalCloseButton;
	
	@FindBy(xpath = "//div[@id=\"viewLeaveEntitlement\"]//i[@data-tooltip=\"Configure\"]")
	private WebElement configureButton;

	public LeaveList(WebDriver driver) {
		
		this.driver = driver;
		
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);
	}

	public LeaveList clickOnComment() {
		
		commentAction.click();
		
		return this;
	}
	
	public LeaveList configure() {
		
		configureButton.click();
		return this;
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    //wait.until(ExpectedConditions.alertIsPresent());
	    //return driver.switchTo().alert();
	    
		//driver.switchTo().activeElement();
		//return this;
	}
	
	public LeaveList closePopup() {
		
		modalCloseButton.click();
		
		return this;
	}


}

