package selenium.practices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HandleDropdownNotCommingUnderSelect {

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new EdgeDriver();

		driver.get("https://www.airvistara.com/in/en");

		driver.manage().window().maximize();

		HandleDropdownNotCommingUnderSelect h = new HandleDropdownNotCommingUnderSelect();
		h.selectCountry("Thailand");

	}

	public void selectCountry(String countryName) {
		driver.findElement(By.xpath("//img[contains(@src,'purple.png')]")).click();

		List<WebElement> countries = driver.findElements(
				By.xpath("//div[@class='country-selection dropdown-list']/ul//li//span[@class='country-name']"));

		for (WebElement country : countries) {
			if (country.getText().equals(countryName)) {
				country.click();
				break;
			}

		}
	}

}
