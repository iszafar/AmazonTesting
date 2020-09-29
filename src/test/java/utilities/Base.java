package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {

	protected WebDriver driver;
	protected Properties prop;

	@BeforeMethod
	public void setupDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("src/main/java/properties/main.properties");
		prop.load(fis);
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/usr/webdrivers/chromedriver1");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/usr/webdrivers/geckodriver1");
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.ie.driver", "/usr/webdrivers/IEDriverServer");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

//	@AfterMethod
	public void closingSite() {
		driver.close();
	}
}
