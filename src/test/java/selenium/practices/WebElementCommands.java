package selenium.practices;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class WebElementCommands {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();

		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();

		WebElement textAreaField = driver.findElement(By.xpath("//textarea[@id='ta1']"));

		textAreaField.sendKeys("testing for websites");

		Thread.sleep(2000);

		textAreaField.clear();

		Thread.sleep(2000);

		textAreaField.sendKeys("This is last one");

		System.out.println("Accessible name= " + textAreaField.getAccessibleName());

		System.out.println("Aria Role = " + textAreaField.getAriaRole());

		System.out.println("Attribute value is= " + textAreaField.getAttribute("contenteditable"));

		WebElement postAtomLink = driver
				.findElement(By.xpath("//a[@href='https://omayo.blogspot.com/feeds/posts/default']"));

		System.out.println(postAtomLink.getCssValue("color"));

		System.out.println("Tag name= " + postAtomLink.getTagName());

		File screenshot = postAtomLink.getScreenshotAs(OutputType.FILE);
		driver.get(screenshot.getAbsoluteFile().toString());

		// driver.quit();

	}

}
