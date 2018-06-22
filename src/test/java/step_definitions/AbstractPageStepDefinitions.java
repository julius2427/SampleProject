package step_definitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbstractPageStepDefinitions {
	protected WebDriver driver;
	private String environment;

	protected WebDriver getDriver() {
		if(driver == null) {
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		return driver;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	public String getEnvironment() {
		return environment;
	}
}