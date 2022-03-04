package TestAutomation.BDDUsingCucumber;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src\\test\\resources\\features\\loginWithOutline.feature",
		glue="TestAutomation.BDDUsingCucumber",
		tags="@basicTest")


public class TestLoginPage extends AbstractTestNGCucumberTests{
	
	
}
