package selenium.practices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverMethods {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new EdgeDriver();

		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();

		driver.switchTo().newWindow(WindowType.TAB).get("https://www.google.com");

		Thread.sleep(7000);

		System.out.println(driver.getCurrentUrl());

		System.out.println(driver.getTitle());

		System.out.println(driver.getPageSource());

		// it will close all instances of browser opened by webdriver session.
		driver.quit();

		// driver.close will close current instance of window or tab
		// driver.close();

	}

}
