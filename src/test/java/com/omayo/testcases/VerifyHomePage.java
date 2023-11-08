package com.omayo.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.omayo.pages.HomePage;

import util.Utilities;

public class VerifyHomePage {

	WebDriver driver;
	HomePage homePage;

	@BeforeMethod
	public void lanchBrowser() {
		driver = Utilities.launchApplication(Utilities.readProperty("url"));
		homePage = new HomePage(driver);
		System.out.println("Changes");
	}

	@Test
	public void verifyHomePage() {

		Reporter.log("Laptop checkbox verification started");
		assertFalse(homePage.isLaptopCheckBoxChecked(), "Laptop checkbox is checked");
		Reporter.log("Laptop checkbox verification end");
		Reporter.log("Button 1 verification started");
		assertFalse(homePage.verifyButton1IsDisabled(), "Button 1 is enabled");
		Reporter.log("Button 1 verification done");
		Reporter.log("table options verification started");
		assertEquals(homePage.getTableOptionsAsStrings(), Arrays.asList("Kishore", "22", "Delhi", "Manish", "25",
				"Pune", "Praveen", "29", "Bangalore", "Dheepthi", "31", "Mumbai"));
		Reporter.log("table options verification done");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
