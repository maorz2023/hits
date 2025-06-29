package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.Base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
	 @Before
	    public void setup() {
	        Base.initializeDriver();
	    }

	    @After
	    public void tearDown() {
	        Base.quitDriver();
	    }

	    @AfterStep
	    public void takeScreenshot(Scenario scenario) {
	        byte[] screenshot = ((TakesScreenshot) Base.driver).getScreenshotAs(OutputType.BYTES);
	        scenario.attach(screenshot, "image/png", "Step Screenshot");
	    }
}
