package com.hcm.vbts.utils;





import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hcm.vbts.base.TestBase;



public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	
	public static String TESTDATA_SHEET_PATH = "D:\\Projects\\POM_Automation\\HCM\\src\\main\\java\\com\\vbts\\hcm\\testdata\\data.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName)
	{
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			{
				for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
					data[i][j] = sheet.getRow(i+1).getCell(j).toString();
					
				}
			}
			
		}
		return data;
		
	}
	public static void takeScreenshotAtEndOfTest() throws IOException
	{
		File sct = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentdir = System.getProperty("user.dir");
		
		FileUtils.copyFile(sct, new File(currentdir+"/Screenshots/"+ System.currentTimeMillis()+".png"));
		
	}
	
	public String DateandTime() {
		Date d = new Date();
		DateFormat dformat = new SimpleDateFormat("dd-MM-yyyy-hh:mm:ss ");
		String date = dformat.format(d);
		return date;
	}
	 
		
		// To perform Implicitlywait
		public static void implicitwait(WebDriver driver, long time, TimeUnit unit)
		{
			driver.manage().timeouts().implicitlyWait(time, unit);
		}
		
		
		
		
		// To wait some time
		public static void Sleep(int millis) throws InterruptedException {
			Thread.sleep(millis);
		}

}