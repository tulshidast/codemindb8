package selenium.practices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LocatorStrateriesInSelenium {

	public static void main(String[] args) {

		// System.setProperty("webdriver.chrome.driver",
		// "src/test/resources/chromedriver.exe");
		// WebDriverManager.chromedriver().setup();

		WebDriver driver = new EdgeDriver();

		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();

		WebElement radioButton = driver.findElement(By.id("radio1"));

		radioButton.click();

		WebElement colorCheckbox = driver.findElement(By.name("color"));

		colorCheckbox.click();
		colorCheckbox.click();

		WebElement selectTagNameElement = driver.findElement(By.tagName("select"));

		System.out.println(selectTagNameElement.getAttribute("id"));

		List<WebElement> h2TagElements = driver.findElements(By.tagName("h2"));

		System.out.println("Number of webelements = " + h2TagElements.size());

		System.out.println("There is no matching webelement with given locator = " + h2TagElements.isEmpty());

		for (WebElement element : h2TagElements) {
			System.out.println(element.getAttribute("innerHTML"));
		}
		
		WebElement elm=driver.findElement(By.linkText("SeleniumTutorial"));
		
		System.out.println(elm.getAttribute("href"));	
		
		WebElement partialLinkText=driver.findElement(By.partialLinkText("SeleniumTu"));
		
		//partialLinkText.click();
		
		WebElement searchTextBox=driver.findElement(By.xpath("//input[@size='10']"));
		searchTextBox.sendKeys("Testing");

	}

}
