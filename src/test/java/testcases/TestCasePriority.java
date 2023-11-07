package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.Utilities;

public class TestCasePriority {

	WebDriver driver;
	SoftAssert verify;

	@BeforeMethod
	public void setup() {
		driver = Utilities.launchApplication(Utilities.readProperty("url"));
		verify = new SoftAssert();
	}

	@Test(priority = 1,groups = {"regression"},enabled = false) 
	public void verifyPageTitle() {
		verify.assertEquals(driver.getTitle(), "omayo (QAFox.com)");
	}

	@Test(priority = 0, groups = {"regression"})
	public void verifyPageUrl() {
		verify.assertEquals(driver.getCurrentUrl(), "https://omayo.blogspot.com/");

	}

	@AfterMethod
	public void tearDowm() {
		verify.assertAll();
		driver.quit();
	}

}
