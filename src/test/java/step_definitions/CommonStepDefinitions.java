package step_definitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CommonStepDefinitions extends CommonFunctions{
	WebDriver driver = getDriver();
	@Given("^I want to grab list of test cases$")
	public void i_want_to_grab_list_of_test_cases() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		KeywordFramework.main(driver, "ContactUs");
		Thread.sleep(1000);
	}

	@Then("^I validate the outcomes$")
	public void i_validate_the_outcomes() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}
}
