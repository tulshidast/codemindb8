package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.Utilities;

public class VerifyHomePageUrl {

	WebDriver driver;

	@Test(groups = {"sanity"})
	public void verifyHomePageTitle() {
		driver = Utilities.launchApplication(Utilities.readProperty("url"));
		String actualTitle = driver.getCurrentUrl();
		String expectedTitle = "https://omayo.blogspot.com/";

		SoftAssert verify = new SoftAssert();

		// hard assert
		verify.assertEquals(actualTitle, expectedTitle);

		System.out.println("After execution");

		// verify.assertEquals(actualTitle, expectedTitle,"title is mismatched");

		// verify.assertNotEquals(actualTitle, expectedTitle);
		// verify.assertNotEquals(actualTitle, expectedTitle,"title is matched");

		// verify.assertTrue(actualTitle.equals(expectedTitle));
		// verify.assertTrue(actualTitle.equals(expectedTitle), "title mismatched");

		// verify.assertFalse(actualTitle.equals(expectedTitle),"title matched");

		verify.assertAll();

	}

}
