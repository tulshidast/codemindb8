package selenium.practices;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Utilities;

public class ExcelDataReading {
	
	static WebDriver driver;

	public static void main(String[] args) {

		driver=Utilities.launchApplication(Utilities.readProperty("registerurl"));
		ArrayList<String> data = Utilities.readExcel();
		
	    driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(data.get(0));
	    driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(data.get(1));
	    driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(data.get(2));
	    driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(data.get(3));

	}

}
