package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MomaCitaPage {
	WebDriver driver;
	WebDriverWait wait;

	private String addressTextBox = "//input[@class=\"blattgold--form-road honest-geo pac-target-input\"]";
	private String addressSubmit_bttn = "//input[@class=\"btn--honest blattgold--form-banner-submit\"]";
	private String addressInCart = "//p[@id=\"customer_address\"]/span";

	////////////// AddcartButton///////////////////////////////
	private String cheesyPorkBurrito_Addcart = "(//div[@class=\"image-link-container\"])[1]";
	private String WickedclassicoBurrito_Addcart = "(//button[@class=\"buybox--button bare-element\"])[2]";
	private String addtoCartButton = "//button[@name=\"In den Warenkorb\"]";
	private String cartItems = "//div[@class=\"bundle--item\"]/div[2]/span";

	public MomaCitaPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20000);
	}

	public void addressTextBox_insert(String address) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addressTextBox)));
		driver.findElement(By.xpath(addressTextBox)).sendKeys(address);
	}

	public void Click_addressSubmit_bttn() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addressSubmit_bttn)));
		driver.findElement(By.xpath(addressSubmit_bttn)).click();
	}

	public String get_addressFromtheCart() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addressInCart)));
		String address = driver.findElement(By.xpath(addressInCart)).getText();
		return address;
	}

	public void click_cheesyPorkBurrito_Addcart() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cheesyPorkBurrito_Addcart)));
		try {
			driver.findElement(By.xpath(cheesyPorkBurrito_Addcart)).click();
		} catch (Exception e) {
			e.printStackTrace();
			driver.navigate().refresh();
			WebElement webElement = driver.findElement(By.xpath(cheesyPorkBurrito_Addcart));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", webElement);
			driver.findElement(By.xpath(cheesyPorkBurrito_Addcart)).click();
		}

	}

	public void click_AddtoCartButton() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addtoCartButton)));
		WebElement webElement = driver.findElement(By.xpath(addtoCartButton));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", webElement);
		driver.findElement(By.xpath(addtoCartButton)).click();

	}

	public String get_cartItems() {
		int size = driver.findElements(By.xpath(cartItems)).size();
		List<WebElement> mylist = driver.findElements(By.xpath(cartItems));
		String items = "";
		for (int i = 0; i < size; i++) {
			items = items + mylist.get(i) + " ";
		}
		return items;
	}

}
