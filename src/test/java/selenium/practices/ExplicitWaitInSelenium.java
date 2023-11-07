package selenium.practices;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.Utilities;

public class ExplicitWaitInSelenium {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = Utilities.launchApplication(Utilities.readProperty("url"));

		driver.findElement(By.xpath("//button[text()='Check this']")).click();

		System.out.println(driver.findElement(By.xpath("//input[@id='dte']")).getAttribute("disabled"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
//		wait.until(
//				ExpectedConditions.attributeToBe(driver.findElement(By.xpath("//input[@id='dte']")), "disabled", ""));
		
		
		WebElement button = driver.findElement(By.xpath("//input[@id='dte']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(button));
		
		

		// wait.until(ExpectedConditions.elementToBeClickable(button));)

		WebElement mrButton = driver.findElement(By.xpath("//input[@id='dte']"));
		
		mrButton.click();

		//System.out.println(driver.findElement(By.xpath("//input[@id='dte']")).getAttribute("disabled"));

		System.out.println(mrButton.isEnabled());

	}

}
