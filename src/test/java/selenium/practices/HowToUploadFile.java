package selenium.practices;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HowToUploadFile {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new EdgeDriver();

		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();

		WebElement fileUploader = driver.findElement(By.xpath("//input[@id='uploadfile']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", fileUploader);

		Thread.sleep(2000);

		fileUploader.sendKeys("C:\\Users\\Admin\\Desktop\\JAAN HAI MERI.mp4");
	}

}
