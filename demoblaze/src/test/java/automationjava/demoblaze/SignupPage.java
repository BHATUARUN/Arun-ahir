package automationjava.demoblaze;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignupPage 
{

	@DataProvider(name = "signup")
	public static Object[][] readExcel() throws InvalidFormatException, IOException {
		Object[][] data = null;

		String filepath = "D:\\Demoblaze.xlsx"; // only string form path

		File file = new File(filepath); // to make an file

		XSSFWorkbook workbook = new XSSFWorkbook(file);// to open the excel file

		Sheet sheet = workbook.getSheet("signup");// to open the perticular sheet

		int nrows = sheet.getPhysicalNumberOfRows();
		System.out.println("no of rows are... " + nrows);

		data = new Object[nrows][];
		for (int i = 0; i < nrows; i++)// row
		{
			Row row = sheet.getRow(i);// ith row is selection
			int ncols = row.getPhysicalNumberOfCells();
			System.out.println("no of cols are.. " + ncols);
			data[i] = new Object[ncols];
			for (int j = 0; j < ncols; j++)// cols
			{
				Cell cell = row.getCell(j);
				cell.setCellType(CellType.STRING);
				data[i][j] = cell.getStringCellValue();
			}
		}
		return data;
	}

	WebDriver driver = null;
	
	@Test(dataProvider = "signup")
	public void getdata(String keyword, String data) throws InterruptedException, InvalidFormatException, IOException 
	{

		 if(keyword.equals("Username"))
		{
			driver.findElement(By.id("sign-username")).sendKeys(data);
			Thread.sleep(2000);
		}
		else if(keyword.equals("Password"))
		{
			driver.findElement(By.id("sign-password")).sendKeys(data);
			Thread.sleep(2000);
		} 
		  
		
	}
}