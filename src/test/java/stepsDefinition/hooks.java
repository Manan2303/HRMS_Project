package stepsDefinition;

import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Factory.baseClass;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class hooks {

	WebDriver driver;
	Properties pr;

	@Before
	public void setup() throws IOException {
		driver = baseClass.browserInilize();
		pr = baseClass.getProperties();  // initialize pr first

		String url = pr.getProperty("appURL");  // now it's safe to use
		
		System.out.println(url);
		driver.get(url);  // reading url through properties file
		driver.manage().window().maximize();
	}

	@After
	public void teardown() {
		driver.quit();
	}

	@AfterStep
	public void addScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}
}