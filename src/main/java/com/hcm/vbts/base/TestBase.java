package com.hcm.vbts.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.hcm.vbts.listeners.WebEventListner;
import com.hcm.vbts.utils.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver Event_driver;
	public static WebEventListner WebEvent_Listner;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fi = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\hcm\\vbts\\config\\config.properties");
			prop.load(fi);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void browser_init() throws InterruptedException {
		String br = prop.getProperty("browser");

		if (br.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Projects\\POM_Automation\\HCM\\src\\main\\java\\com\\hcm\\vbts\\browsers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (br.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"D:\\Projects\\POM_Automation\\HCM\\src\\main\\java\\com\\hcm\\vbts\\browsers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.out.println("No Browser Driver Available for Browser Instance");
		}

		Event_driver = new EventFiringWebDriver(driver);
		WebEvent_Listner = new WebEventListner();

		Event_driver.register(WebEvent_Listner);
		driver = Event_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

		Thread.sleep(3000);

	}
	
	public void Refresh() throws AWTException, InterruptedException{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_F5);
		
		Thread.sleep(2000);
	}
	
	public  boolean isAlertPresent()
	{
		 try {
			 driver.switchTo().alert();
		      return true;
		    } catch (NoAlertPresentException e) {
		      return false;
		    }
	}
	/*------------------Main Method-----------------------------------------------
	 *	
	 if(DriverInitializer.isAlertPresent())
		{
			Reporter.log("Alert Presented",true);
			String message = driver.switchTo().alert().getText();
			Reporter.log(message+" : is displayed at Pop up",true);
			driver.switchTo().alert().accept();
			Reporter.log("Clicked On OK button in Pop up",true);
		}
		else
		{
			Reporter.log("Alert not presented",true);
		}
		
	 */
	public  boolean isTextPresent(String ExpectedText)
	{
		
		boolean flag = driver.getPageSource().contains(ExpectedText);
		
		
		return flag;
		
	}
	
	/*------------------Main Method-----------------------------------------------
	 * if(isTextPresent("text"))
			{
				s.o.p("textpresented");
			}
	 */
	
	public  boolean isTitlePresent(String ExpectedTitle)
	{
		boolean flag = driver.getTitle().contains(ExpectedTitle);
		
		return flag;
	}
	
	/*------------------Main Method-----------------------------------------------
	 * if(isTitlePresent(ExpectedTitle))
			{
			
				s.o.p("titlepresented");
			}
	 * 
	 */
	
	public boolean isURLPresent(String ExpectedURL)
	{
		boolean flag = driver.getCurrentUrl().equals(ExpectedURL);
		
		return flag;
	}
	/*------------------Main Method-----------------------------------------------
	 *  if(DriverInitializer.isURLPresent(ExpectedURL))
		 {
			 String URL = driver.getCurrentUrl();
			 Reporter.log("As expected Staff Login Page Displayed Successfully" ,true);
			 Reporter.log("PageURL displayed as : "+URL+" at Staff Login Page",true);
		 }
		 else{
			 Reporter.log("Staff Login Page URL Not Matching with Expected URL",true);
			 Reporter.log("Not Displayed Staff Login Page",true);
		 }
	 */
	
	public static boolean isDisplayed(WebElement element)
	{
		boolean flag = element.isDisplayed();
		
		return flag;
		
	}
	/*------------------Main Method-----------------------------------------------
	 * if(DriverInitializer.isDisplayed(element))
		{
			Reporter.log("As expected element is displayed",true);
		}
		else
		{
			Reporter.log("element is not Displayed",true);
		}
	 * 
	 * 
	 */
	public boolean isEnabled(WebElement element)
	{
		boolean flag = element.isEnabled();
		
		return flag;
		
	}
	/*------------------Main Method-----------------------------------------------
	 * if(DriverInitializer.isEnabled(element))
		{
			Reporter.log("As expected element is enabled",true);
		}
		else
		{
			Reporter.log("element is not enabled",true);
		}
	 */
	public  boolean isSelected(WebElement element)
	{
		boolean flag = element.isSelected();
		
		return flag;
		
	}
	/*------------------Main Method-----------------------------------------------
	 * if(DriverInitializer.isSelected(element))
		{
			Reporter.log("As expected element is Selected",true);
		}
		else
		{
			Reporter.log("element is not Selected",true);
		}
	 */
	public static  boolean isEmpty(String field)
	{
		boolean flag = field.isEmpty();
		
		return flag;
		
	}
	/*------------------Main Method-----------------------------------------------
	 * if(DriverInitializer.isEmpty(field))
		{
			Reporter.log("As expected field is Empty",true);
		}
		else
		{
			Reporter.log("element is not empty",true);
		}
	 */
	public  boolean isMatching(String actual_text,String expected_text)
	{
		boolean flag = actual_text.matches(expected_text);
		
		return flag;
		
	}
	/*------------------Main Method-----------------------------------------------
	 * if(DriverInitializer.isMatching(actual_text,expected_text))
		{
			Reporter.log("As expected actual text and expected text matched",true);
		}
		else
		{
			Reporter.log("actual text and expected text not matched",true);
		}
	 */
	public boolean isEquals(String actual_text,String expected_text)
	{
		boolean flag = actual_text.equals(expected_text);
		
		return flag;
		
	}
	/*------------------Main Method-----------------------------------------------
	 * if(DriverInitializer.isEquals(actual_text,expected_text))
		{
			Reporter.log("As expected actual text and expected text exactly Same",true);
		}
		else
		{
			Reporter.log("actual text and expected text not exactly Same",true);
		}
	 */
	public  boolean isEqualsIgnoreCase(String actual_text,String expected_text)
	{
		boolean flag = actual_text.equalsIgnoreCase(expected_text);
		
		return flag;
		
	}
	/*------------------Main Method-----------------------------------------------
	 * if(DriverInitializer.isEqualIgnoreCase(actual_text,expected_text))
		{
			Reporter.log("As expected actual text and expected text Same,but Case sensitive",true);
		}
		else
		{
			Reporter.log("actual text and expected text not Same",true);
		}
	 */
	public static  boolean isContains(String actual_text,String expected_text)
	{
		boolean flag = actual_text.contains(expected_text);
		
		return flag;
		
	}
	/*------------------Main Method-----------------------------------------------
	 * if(DriverInitializer.isContains(text1,text2))
		{
			Reporter.log("As expected actual text contains expected text",true);
		}
		else
		{
			Reporter.log("actual text not contains expected text",true);
		}
	 */
	public  boolean isContentEquals(String actual_text,String expected_text)
	{
		boolean flag = actual_text.contentEquals(expected_text);
		
		return flag;
		
	}
	/*------------------Main Method-----------------------------------------------
	 * if(DriverInitializer.isContentEquals(text1,text2))
		{
			Reporter.log("As expected actual text content equals to expected text",true);
		}
		else
		{
			Reporter.log("actual text content not equals to expected text",true);
		}
	 */
	
	public static  String isDropdown(WebElement element)
	{
		String tagname = element.getTagName();
		
		return tagname;
	}	
	/*------------------Main Method-----------------------------------------------
	 * if(DriverInitializer.isDropdown(element).equalsIgnoreCase("select"))
		{
			Reporter.log("element is drop down",true);
		}
		else
		{
			Reporter.log("element is not drop down",true);
		}
	 */
	
		public  void Tab() throws AWTException
		{
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_TAB);
		}
	
		public String DateandTime()
		{
			Date d= new Date();
			DateFormat dformat= new SimpleDateFormat("dd-MM-yyyy-hh:mm");
			String date = dformat.format(d);
			return date;
		}

}
