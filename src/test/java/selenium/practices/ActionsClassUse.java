package selenium.practices;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import util.Utilities;

public class ActionsClassUse {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();

		driver.get(Utilities.readProperty("url"));

		driver.manage().window().maximize();

		Actions actions = new Actions(driver);

		WebElement pageOneLink = driver.findElement(By.xpath("//a[text()='Page One']"));

		actions.click(pageOneLink).build().perform();

		WebElement textArea = driver.findElement(By.xpath("//textarea[@id='ta1']"));

		actions.keyDown(textArea, Keys.SHIFT).keyDown("a").keyUp(Keys.SHIFT).keyUp("a").build().perform();

		// actions.contextClick().build().perform();

		WebElement blogLink = driver.findElement(By.xpath("//span[@id='blogsmenu']"));

		actions.moveToElement(blogLink).build().perform();

		driver.navigate().to(Utilities.readProperty("dragdropurl"));

		actions.dragAndDrop(driver.findElement(By.xpath("//li[@id='fourth']/a")),
				driver.findElement(By.xpath("//ol[@id='amt7']/li"))).build().perform();

	}

}
