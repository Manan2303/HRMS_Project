package stepsDefinition;

import org.openqa.selenium.WebDriver;
import org.junit.Assert;

import Factory.baseClass;
import io.cucumber.java.en.*;
import pageObject.dashboardPage;
import pageObject.loginPage;

public class loginSteps {


	WebDriver driver;
	loginPage lp;
	dashboardPage dp;

	@Given("User navigate the login page of the application")
	public void user_navigate_the_login_page_of_the_application() {
		baseClass.getLogger().info("Inherit login page and redirect the driver");
		lp=new loginPage(baseClass.getDriver());
	}

	@When("user enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String username, String password) {
		baseClass.getLogger().info("Enter user name and password");
		lp=new loginPage(baseClass.getDriver());
		lp.user_id(username);
		lp.user_pass(password);
	}

	@When("the user clicks on the Login button")
	public void the_user_clicks_on_the_login_button() {
		baseClass.getLogger().info("Click on login button");
		lp=new loginPage(baseClass.getDriver());
		lp.login();
	}


	@Then("the user should be redirected to Application Dashboard")
	public void the_user_should_be_redirected_to_application_dashboard() {
		baseClass.getLogger().info("User successfully redirect to dashboard");
		dp= new dashboardPage(baseClass.getDriver());
		boolean target = dp.Dashboard();
		System.out.println(target);
		Assert.assertEquals(target,true);
		System.out.println("Login Successfully - User redirect to dashboard");
		
	}



}
