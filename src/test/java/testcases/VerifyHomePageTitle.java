package testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import util.Utilities;

public class VerifyHomePageTitle {

	WebDriver driver;

	
	@Test(groups = {"sanity"})
	public void verifyHomePageTitle() {
		driver = Utilities.launchApplication(Utilities.readProperty("url"));
		String actualTitle = driver.getTitle();
		String expectedTitle = "omayo (QAFox.com)";

		// hard assert
		assertEquals(actualTitle, expectedTitle);
		
		System.out.println("After execution");

		// assertEquals(actualTitle, expectedTitle,"title is missmatched");

		// assertNotEquals(actualTitle, expectedTitle);
		// assertNotEquals(actualTitle, expectedTitle,"title is matched");

		// assertTrue(actualTitle.equals(expectedTitle));
		// assertTrue(actualTitle.equals(expectedTitle), "title missmatched");

		// assertFalse(actualTitle.equals(expectedTitle),"title matched");

	}

}
