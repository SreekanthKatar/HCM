package com.hcm.vbts.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hcm.vbts.base.TestBase;
import com.hcm.vbts.pages.HomePage;
import com.hcm.vbts.pages.LoginPage;
import com.hcm.vbts.utils.TestUtil;



public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	TestUtil util;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() throws InterruptedException, IOException {
		browser_init();
		loginpage = new LoginPage();
		homepage = loginpage.PerformLogin(prop.getProperty("username_emp"), prop.getProperty("password_emp"));
//		homepage = loginpage.PerformLogin(prop.getProperty("username_rm"), prop.getProperty("password_rm"));
//		homepage = loginpage.PerformLogin(prop.getProperty("username_hr"), prop.getProperty("password_hr"));
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		//loginpage.PerformLogout();
		driver.quit();

	}

	@Test(priority = 0)
	public void ValidateHomePageTitle() {
		String pt = homepage.ValidateHomePageTitle();
		Reporter.log("Home Page Title is: " + pt, true);
		assertEquals(pt, "HCM");

	}

	@Test(priority = 1)
	public void ValidateHomePageURL() {
		String hp_url = homepage.ValidateHomePageURL();
		Reporter.log("HomePageURL is " + hp_url, true);
		assertEquals(hp_url, "http://192.168.2.140:8282/thcm/employeeSelfService");

	}

	@Test(priority = 2)
	public void ValidateHomePageHCMLogo() {
		boolean logo = homepage.VerifyHCMLogo();
		if (logo) {
			Reporter.log("HCM Logo is Displayed in Home Page", true);
		} else {
			Reporter.log("HCM Logo is Not Displayed in Home Page", true);
		}
		assertTrue(logo);

	}

}
