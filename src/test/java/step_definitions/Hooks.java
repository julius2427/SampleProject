package step_definitions;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.Before;

public class Hooks extends AbstractPageStepDefinitions{
	WebDriver driver = getDriver();
	
	@Before
	public void openBrowser() throws MalformedURLException{
		System.out.println("Called Open Browser");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
/*	@After
	public void closeBrowser() {
		driver.quit();
	}*/
}