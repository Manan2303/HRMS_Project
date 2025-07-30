package pageObject;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends basePage {
	
	public loginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// locators 
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement user_name;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath ="//button[normalize-space()='Login']")
	WebElement Login_btn;
	
	
	
	public void user_id(String user) {
		user_name.sendKeys(user);
	}

	public void user_pass(String pass) {
		password.sendKeys(pass);
	}
	
	public void login() {
		Login_btn.click();
	}

}

