package selenium.practices;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.Utilities;

public class ExplicitWait_2 {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = Utilities.launchApplication(Utilities.readProperty("url"));
		driver.findElement(By.xpath("//button[text()='Check this']")).click();

		WebElement mrOption = driver.findElement(By.xpath("//input[@id='dte']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(mrOption));

		mrOption.click();

	}

}
