package selenium.practices;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Scrolling {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new EdgeDriver();

		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// scroll into down direction
		js.executeScript("window.scrollBy(0,700)", "");

		Thread.sleep(5000);

		// scroll into up direction
		js.executeScript("window.scrollBy(0,-350)", "");

		Thread.sleep(5000);

		// scroll into right direction
		js.executeScript("window.scrollBy(150,0)", "");

		Thread.sleep(5000);
		// scroll into left direction
		js.executeScript("window.scrollBy(-150,0)", "");

		Thread.sleep(5000);

		// scroll at a time in left and down direction
		js.executeScript("window.scrollBy(-150,-250)", "");

		WebElement sameIdNameBtn = driver.findElement(By.xpath("//input[@id='sa']"));

		Thread.sleep(5000);

		// scroll till the element into view
		js.executeScript("arguments[0].scrollIntoView();", sameIdNameBtn);

		Thread.sleep(5000);
		// scroll till the end of page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

	}

}
