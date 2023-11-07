package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {

	public static String readProperty(String property) {

		File file = new File("src/test/resources/testdata.properties");
		FileInputStream fileInputStream = null;
		Properties prop = null;

		try {
			fileInputStream = new FileInputStream(file);
			prop = new Properties();
			prop.load(fileInputStream);
		} catch (IOException io) {
			io.printStackTrace();
		}

		return prop.getProperty(property);

	}

	public static WebDriver launchApplication(String url) {

		WebDriver driver = new EdgeDriver();

		driver.get(url);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;

	}

	public static ArrayList<String> readExcel() {

		ArrayList<String> userData = new ArrayList<String>();

		try {
			File file = new File("src/test/resources/testdata.xlsx");
			FileInputStream fis = new FileInputStream(file);

			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fis);

			XSSFSheet xssfSheet = xssfWorkbook.getSheet("data");

			int lastRowNum = xssfSheet.getLastRowNum();

			for (int i = 1; i <= lastRowNum; i++) {

				XSSFRow row = xssfSheet.getRow(i);

				int lastCellNum = row.getLastCellNum();

				for (int j = 0; j < lastCellNum; j++) {
					userData.add(row.getCell(j).getStringCellValue());
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return userData;
	}

	public static void takeScreenshot(WebDriver driver, String name) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(file, new File("src/test/resources/screenshots/" + name + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
