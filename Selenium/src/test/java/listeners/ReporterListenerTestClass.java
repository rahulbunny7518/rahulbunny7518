package listeners;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ReporterListener.class)

public class ReporterListenerTestClass {

	@Test
	public void firstMethod() {
		assertTrue(true);
	}

	@Test
	public void secondMethod() {
		assertTrue(false);
	}

	@Test(dependsOnMethods = {"firstMethod"})
	public void thirdMethod() {
		assertTrue(true);
	}

}
