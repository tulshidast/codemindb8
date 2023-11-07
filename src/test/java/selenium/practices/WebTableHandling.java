package selenium.practices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class WebTableHandling {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();

		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();

		System.out.println("#########################headers##############################");

		List<WebElement> tableHeaders = driver.findElements(By.xpath("//table[@id='table1']/thead/tr//th"));

		for (WebElement header : tableHeaders) {
			System.out.println(header.getText());
		}

		System.out.println("#########################headers##############################");

		System.out.println("#########################column##############################");

		List<WebElement> tablefirstColumn = driver.findElements(By.xpath("//table[@id='table1']/tbody//tr//td[1]"));

		for (WebElement column : tablefirstColumn) {
			System.out.println(column.getText());
		}

		System.out.println("#########################column##############################");

		System.out.println("#########################row##############################");

		List<WebElement> tablefirstrow = driver.findElements(By.xpath("//table[@id='table1']/tbody//tr[1]//td"));

		for (WebElement row : tablefirstrow) {
			System.out.println(row.getText());
		}

		System.out.println("#########################row##############################");

		System.out.println("#########################complete table##############################");

		List<WebElement> table = driver.findElements(By.xpath("//table[@id='table1']/tbody//tr//td"));

		for (WebElement row : table) {
			System.out.println(row.getText() + "\t");
		}

		System.out.println("#########################complete table##############################");

	}

}
