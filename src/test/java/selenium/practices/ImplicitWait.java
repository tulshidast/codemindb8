package selenium.practices;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class ImplicitWait {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();

		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();
		
		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		WebElement createBlogLink = driver.findElement(By.xpath("//a[@id='b-getorpost']"));

		System.out.println(createBlogLink.getText());

	}

}
