package actionsandJS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Dashboard {

	private final WebDriver driver;
	
	@FindBy(className = "dashboard-complete-widget")
	private WebElement source;
	
	@FindBy()
	private WebElement target;
	
	public Dashboard(WebDriver driver) {
		
		this.driver = driver;
		
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}

	public LeaveList navigateToLeaveList() {
		
		driver.navigate().to("https://prasoonr-trials73.orangehrmlive.com/client/#/leave/view_leave_list");
		return new LeaveList(driver);
		
		
	}

	public void dragAndDrop() {
		
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();
		
		
	}
	
}
