package selenium.practices;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HandleAlert {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();

		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='confirm']")).click();

		Alert a = driver.switchTo().alert();

		System.out.println(a.getText());

		// a.accept();

		a.dismiss();

	}

}
