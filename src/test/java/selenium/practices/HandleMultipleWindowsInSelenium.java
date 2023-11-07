package selenium.practices;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HandleMultipleWindowsInSelenium {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();

		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();

		WebElement maleRadioButton = driver.findElement(By.xpath("//input[@id='radio1']"));

		maleRadioButton.click();

		driver.findElement(By.xpath("//a[@id='selenium143']")).click();

		driver.findElement(By.xpath("//input[@id='radio2']")).click();

		// this method will return the current window handle
		String currentWindowHandle = driver.getWindowHandle();
		System.out.println(currentWindowHandle);

		// this method returns all windows handles which opened by current web driver
		// session.
		Set<String> windowsHandles = driver.getWindowHandles();

		for (String handle : windowsHandles) {
			if (!(handle.equals(currentWindowHandle))) {
				driver.switchTo().window(handle);
			}
		}

		System.out.println(driver.findElement(By.xpath("//a[text()='What is Selenium?']")).getText());

		driver.close();

		driver.switchTo().window(currentWindowHandle);

		maleRadioButton.click();

		driver.quit();

	}

}
