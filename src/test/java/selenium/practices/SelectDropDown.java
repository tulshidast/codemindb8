package selenium.practices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new EdgeDriver();

		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();

		WebElement singleSelectionDropdown = driver.findElement(By.xpath("//select[@id='drop1']"));

		Select sel = new Select(singleSelectionDropdown);

		List<WebElement> selectedOptions = sel.getAllSelectedOptions();

		System.out.println(
				"######################################getAllSelectedOptions#######################################");

		for (WebElement option : selectedOptions) {
			System.out.println(option.getText());
		}

		System.out.println(
				"######################################getFirstSelectedOption#######################################");

		WebElement firstSelectedDropdownOption = sel.getFirstSelectedOption();

		System.out.println(firstSelectedDropdownOption.getText());

		List<WebElement> allDropdownOptions = sel.getOptions();

		System.out.println("####################################getOptions#########################################");

		for (WebElement dropDownOption : allDropdownOptions) {
			System.out.println(dropDownOption.getText());
		}

		System.out.println("####################################isMultiple#########################################");

		System.out.println(sel.isMultiple());
		
		System.out.println("####################################isMultiple#########################################");
		
		sel.selectByIndex(2);
		
		Thread.sleep(2000);
		
		sel.selectByValue("abc");
		
		Thread.sleep(2000);
		
		sel.selectByVisibleText("doc 4");

	}

}
