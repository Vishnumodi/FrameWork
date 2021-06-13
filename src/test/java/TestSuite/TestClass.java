package TestSuite;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObject.HomePage;
import PageObject.MomaCitaPage;
import platform.BrowserClass;
import platform.ConfigClass;
import platform.URLProvider;

public class TestClass extends ConfigClass {

	BrowserClass browser;
	URLProvider urlprovider;
	HomePage homepge;
	SoftAssert softAssert;
	MomaCitaPage momacita;

	@BeforeMethod
	public void openBrowser() {
		browser = new BrowserClass();
		driver = browser.StartDriver(driver_type);
		homepge = new HomePage(driver);
		momacita = new MomaCitaPage(driver);
		urlprovider = new URLProvider(driver);
		urlprovider.Load_URL();
		softAssert = new SoftAssert();
		driver.findElement(By.xpath("//button[@class='agree-cookie']")).click();
	}

	@Test
	public void addTocartTest() throws InterruptedException {
		homepge.Click_Mamacita_OrderNow_Bttn();
		String CurrentUrl = driver.getCurrentUrl();
		// Verifying the momacitapage url
		softAssert.assertEquals(Mamacitapage_URL, CurrentUrl, "Momacita page url not matching");
		String address = "Seidengasse 44, 1070 Wien, Austria";
		momacita.addressTextBox_insert(address);
		Thread.sleep(1000);
		momacita.Click_addressSubmit_bttn();
		String addressInCart = momacita.get_addressFromtheCart();
		softAssert.assertEquals(address, addressInCart, "Entered address and address in cart not maching");
		Thread.sleep(2000);
		momacita.click_cheesyPorkBurrito_Addcart();
		Thread.sleep(2000);
		momacita.click_AddtoCartButton();
		softAssert.assertTrue(momacita.get_cartItems().contains("Cheesy Pork Burrito"),
				"Entered address and address in cart not maching");
		softAssert.assertAll();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
