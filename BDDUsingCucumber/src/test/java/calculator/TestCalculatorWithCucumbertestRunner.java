package calculator;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;


@CucumberOptions(
		features = "src\\test\\resources\\features\\calculator.feature",
		glue = {"calculator"},
		dryRun=true,
		tags="@DataTable"
		)



public class TestCalculatorWithCucumbertestRunner {
	
	private TestNGCucumberRunner runner;
	private static WebDriver driver;
	private String platformname;
	private String browserName;
	
	@BeforeClass
	public void setUp(ITestContext context) {
		runner = new TestNGCucumberRunner(this.getClass());
		
		browserName = context.getCurrentXmlTest().getParameter("BrowserName");
		platformname = context.getCurrentXmlTest().getParameter("OrangeHRMTestExecutionPlatform");
		
	}

	@Test(groups="cucumber",dataProvider="scenarios")
	public void testCucumberScenario(PickleWrapper pickle, FeatureWrapper feature) {
		runner.runScenario(pickle.getPickle());
	}

	@DataProvider
	public Object[][] scenarios(){
		return runner.provideScenarios();
	}

	@AfterClass
	public void tearDown() {
		runner.finish();
	}
}