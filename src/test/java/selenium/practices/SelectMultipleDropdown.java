package selenium.practices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectMultipleDropdown {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new EdgeDriver();

		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();

		WebElement multiSelectionDropdown = driver.findElement(By.xpath("//select[@id='multiselect1']"));

		Select sel = new Select(multiSelectionDropdown);

		List<WebElement> selectedOptions = sel.getAllSelectedOptions();

		System.out.println(
				"######################################getAllSelectedOptions#######################################");

		for (WebElement option : selectedOptions) {
			System.out.println(option.getText());
		}

		List<WebElement> allDropdownOptions = sel.getOptions();

		System.out.println("####################################getOptions#########################################");

		for (WebElement dropDownOption : allDropdownOptions) {
			System.out.println(dropDownOption.getText());
		}

		System.out.println("####################################isMultiple#########################################");

		System.out.println(sel.isMultiple());

		System.out.println("####################################isMultiple#########################################");

		sel.selectByIndex(2);

		System.out.println(
				"######################################getFirstSelectedOption#######################################");

		WebElement firstSelectedDropdownOption = sel.getFirstSelectedOption();

		System.out.println(firstSelectedDropdownOption.getText());

		Thread.sleep(2000);

		sel.selectByValue("volvox");

		Thread.sleep(2000);

		sel.selectByVisibleText("Audi");

		selectedOptions = sel.getAllSelectedOptions();

		System.out.println(
				"######################################getAllSelectedOptions#######################################");

		for (WebElement option : selectedOptions) {
			System.out.println(option.getText());
		}

		Thread.sleep(2000);
		sel.deselectByIndex(0);

		Thread.sleep(2000);
		sel.deselectByValue("Hyundaix");

		Thread.sleep(2000);
		sel.deselectByVisibleText("Audi");

		sel.selectByIndex(0);
		sel.selectByIndex(1);
		sel.selectByIndex(2);
		sel.selectByIndex(3);

		Thread.sleep(2000);

		sel.deselectAll();

	}

}
