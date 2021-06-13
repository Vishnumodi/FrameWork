package platform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserClass {

	public WebDriver driver;
	String env_path = System.getenv("drivers");

	public WebDriver StartDriver(String browserType) {
		if (browserType.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//drivers//chromeDriver/chromedriver.exe");
			driver = new ChromeDriver();
		}

		if (browserType.equalsIgnoreCase("Mozila")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "//drivers//GeckoDriver/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		if (browserType.equalsIgnoreCase("Safari")) {

		}

		if (browserType.equalsIgnoreCase("IE")) {

		}

		return driver;
	}

}
