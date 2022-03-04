package practice;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src\\test\\resources\\features\\userEdit.feature",glue="practice")

public class TestRunner extends AbstractTestNGCucumberTests {
	
	
}
