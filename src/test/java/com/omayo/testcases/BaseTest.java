package com.omayo.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import util.Utilities;

public class BaseTest {

	WebDriver driver;

	@BeforeMethod
	public void lanchBrowser() {
		driver = Utilities.launchApplication(Utilities.readProperty("url"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
