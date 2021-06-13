package platform;

import org.openqa.selenium.WebDriver;

public class URLProvider extends ConfigClass {
	WebDriver driver;

	public URLProvider(WebDriver driver) {
		this.driver = driver;
	}

	public void Load_URL() {
		driver.get(Url);
		driver.manage().window().maximize();
	}

}
