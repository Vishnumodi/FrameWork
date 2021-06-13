package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	WebDriverWait wait;
	private String Babamoni_OrderNow_Bttn = "(//a[@href=\"/speisekarte/baba-noni/koppstr/\"])[4]";
	private String Blattgold_OrderNow_Bttn = "(//a[@href=\"/speisekarte/blattgold/mariahilferstr/\"])[6]";
	private String Mamacita_OrderNow_Bttn = "(//a[@href=\"/speisekarte/mamacita/wallenstein/\"])[3]";
	private String BestFruende_OrderNow_Bttn = "(//a[@href=\"/speisekarte/baba-noni/koppstr/\"])[4]";
	private String HolyChicken_OrderNow_Bttn = "(//a[@href=\"/speisekarte/baba-noni/koppstr/\"])[4]";
	private String gangnamKitchen_OrderNow_Bttn = "(//a[@href=\"/speisekarte/baba-noni/koppstr/\"])[4]";

	public HomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20000);
	}

	public void Click_Mamacita_OrderNow_Bttn() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Mamacita_OrderNow_Bttn)));
		WebElement webElement = driver.findElement(By.xpath(Mamacita_OrderNow_Bttn));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", webElement);
		driver.findElement(By.xpath(Mamacita_OrderNow_Bttn)).click();
	}

}
