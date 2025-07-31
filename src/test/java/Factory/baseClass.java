package Factory;


//All the reusable methods like initilize the browser , screen shot, create random number and string etc....

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



public class baseClass {

	static WebDriver driver;
	static Properties pr;
	static Logger logger; 

	
	public static Properties getProperties() throws IOException
	{		 
		FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\cofig.properties");
		pr=new Properties();
		pr.load(file);
		return pr;
	}

	@SuppressWarnings("deprecation")
	public static WebDriver browserInilize()throws IOException
	{
		pr=getProperties();

		String executionEnv =pr.getProperty("execution_env");
		String browser =pr.getProperty("browser").toLowerCase();
		String os =pr.getProperty("os").toLowerCase();

		if (executionEnv.equalsIgnoreCase("remote")) {
			DesiredCapabilities capability = new DesiredCapabilities();

			//Operating System

			switch(os) {
			case "windows":
				capability.setPlatform(Platform.WINDOWS);
				break;

			case "mac":
				capability.setPlatform(Platform.MAC);
				break;

			case "linus":
				capability.setPlatform(Platform.LINUX);
				break;
			default:
				System.out.println("No matching OS");
				return null;
			}

			// For browser

			switch (browser) {
			case "chrome":
				capability.setBrowserName("chrome");
				break;
			case "edge":
				capability.setBrowserName("MicrosoftEdge");
				break;
			case "firefox":
				capability.setBrowserName("firefox");
				break;
			default:
				System.out.println("No matching browser");
				return null;
			}

			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capability);

		}

		else if(executionEnv.equalsIgnoreCase("local"))
		{
			switch(browser.toLowerCase()) 
			{
			case "chrome":
				driver=new ChromeDriver();
				break;
			case "edge":
				driver=new EdgeDriver();
				break;
			case "firefox":
				driver=new FirefoxDriver();
				break;
			default:
				System.out.println("No matching browser");
				driver=null;
			}
		}
		driver.manage().deleteAllCookies(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

		return driver;
	}

	//return the driver 
	public static WebDriver getDriver() {
		return driver;
	}


	public static Logger getLogger() 
	{		 
		logger=LogManager.getLogger(); //Log4j
		return logger;
	}

}

