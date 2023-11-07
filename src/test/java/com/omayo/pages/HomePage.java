package com.omayo.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	WebDriver driver;
	WebElement button_1;
	List<WebElement> tableOptions;
	WebElement laptopCheckBox;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getButton_1() {
		button_1 = driver.findElement(By.xpath("//button[@id='but1']"));
		return button_1;
	}

	public List<WebElement> getTableOptions() {
		tableOptions = driver.findElements(By.xpath("//table[@id='table1']/tbody//tr//td"));
		return tableOptions;
	}

	public WebElement getLaptopCheckBox() {
		laptopCheckBox = driver.findElement(By.xpath("//input[@value='Laptop']"));
		return laptopCheckBox;
	}

	public boolean verifyButton1IsDisabled() {
		return getButton_1().isEnabled();
	}

	public List<String> getTableOptionsAsStrings() {
		List<String> tOptions = new ArrayList<String>();
		List<WebElement> l = getTableOptions();
		for (WebElement elm : l) {
			tOptions.add(elm.getText());
		}
		return tOptions;
	}

	public boolean isLaptopCheckBoxChecked() {
		return getLaptopCheckBox().isSelected();
	}

}
