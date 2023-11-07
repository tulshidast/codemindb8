package selenium.practices;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.Utilities;

public class TestNGAnnotations {
	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		driver = Utilities.launchApplication(Utilities.readProperty("url"));
	}

	@Test
	public void testExplicitWait() {

		driver.findElement(By.xpath("//button[text()='Check this']")).click();

		WebElement mrOption = driver.findElement(By.xpath("//input[@id='dte']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(mrOption));

		mrOption.click();

		Assert.assertEquals(mrOption.isSelected(), true);
	}

	@Test
	public void verifyPageTitle() {
		Assert.assertTrue(driver.getTitle().equals("omayo (QAFox.com)"));
	}

	@AfterMethod
	public void shutdown() {
		driver.quit();
	}

}
