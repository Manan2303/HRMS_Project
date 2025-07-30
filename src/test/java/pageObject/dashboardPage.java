package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class dashboardPage extends basePage{

	public dashboardPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	// locator 
	@FindBy(xpath = "//h6[normalize-space()='Dashboard']")
	WebElement AccountText;

	//Acton method

	public boolean Dashboard() {
		try {
			return(AccountText.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
	}


}
