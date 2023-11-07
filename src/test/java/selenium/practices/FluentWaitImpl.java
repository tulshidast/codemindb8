package selenium.practices;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import util.Utilities;

public class FluentWaitImpl {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = Utilities.launchApplication(Utilities.readProperty("url"));
		driver.findElement(By.xpath("//button[text()='Check this']")).click();

		WebElement mrOption = driver.findElement(By.xpath("//input[@id='dte']"));

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(10));
		wait.pollingEvery(Duration.ofMillis(2));
		wait.ignoring(TimeoutException.class);
		wait.until(ExpectedConditions.elementToBeClickable(mrOption));

		mrOption.click();

	}

}
