package selenium.practices;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

public class WebElementCommands2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();

		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();

		WebElement textAreaField = driver.findElement(By.xpath("//div[@id='HTML2']/h2[@class='title']"));

		System.out.println(textAreaField.getText());

		System.out.println(textAreaField.getAttribute("innerHTML"));

		System.out.println(textAreaField.isDisplayed());

		System.out.println(driver.findElement(By.xpath("//div[@class='clear']")).isDisplayed());

		System.out.println("Button 2 is enabled = " + driver.findElement(By.xpath("//button[@id='but2']")).isEnabled());

		System.out.println("Button 1 is enabled = " + driver.findElement(By.xpath("//button[@id='but1']")).isEnabled());

		driver.findElement(By.xpath("//input[@id='radio1']")).click();

		System.out.println("Male radio button is selected = "
				+ driver.findElement(By.xpath("//input[@id='radio1']")).isSelected());

		System.out.println("female radio button is selected = "
				+ driver.findElement(By.xpath("//input[@id='radio2']")).isSelected());

		driver.findElement(By.xpath("//input[@id='checkbox2']")).click();

		driver.findElement(By.xpath("//input[@id='checkbox1']")).click();
		System.out.println("Orange checkbox is selected = "
				+ driver.findElement(By.xpath("//input[@id='checkbox1']")).isSelected());
		System.out.println(
				"Blue checkbox is selected = " + driver.findElement(By.xpath("//input[@id='checkbox2']")).isSelected());

		Point p = textAreaField.getLocation();

		System.out.println(p.getX());
		System.out.println(p.getY());

		Dimension d = textAreaField.getSize();
		System.out.println(d.height);
		System.out.println(d.getWidth());

		driver.switchTo().newWindow(WindowType.WINDOW).navigate()
				.to("https://demo.guru99.com/test/newtours/register.php");
		
		Thread.sleep(4000);

		driver.findElement(By.xpath("//input[@name='submit']")).click();

	}

}
