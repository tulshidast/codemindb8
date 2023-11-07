package selenium.practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HandlingIframe {

	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriver();

		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();

		WebElement frame = driver.findElement(By.xpath("//iframe[@id='navbar-iframe']"));

		driver.switchTo().frame(frame);
			
		WebElement createBlogLink = driver.findElement(By.xpath("//a[@id='b-getorpost']"));

		System.out.println(createBlogLink.getText());

		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("//input[@id='radio1']")).click();

	}

}
