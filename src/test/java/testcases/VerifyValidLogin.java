package testcases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Utilities;

public class VerifyValidLogin {

	WebDriver driver;

	@Test(dataProvider = "userData", groups = { "smoke", "regression" })
	public void verifyValidLoginWithDifferentUser(String userName, String password) throws InterruptedException {

		driver = Utilities.launchApplication(Utilities.readProperty("loginurl"));

		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='submit']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h3[text()='Login Successfully']"))));

		WebElement loginMsg = driver.findElement(By.xpath("//h3[text()='Login Successfully']"));

		assertEquals(loginMsg.getText(), "Login Successfully", "Failed login");

	}

	@DataProvider(name = "userData")
	public String[][] data() {
		String users[][] = { { "admin1", "12345" }, { "admin2", "admin@124" }, { "admin", "admin@123" } };
		return users;
	}

	@AfterMethod
	public void terDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utilities.takeScreenshot(driver, result.getName());
		}
		driver.quit();
	}

}
