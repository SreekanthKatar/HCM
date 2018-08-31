package com.hcm.vbts.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hcm.vbts.base.TestBase;
import com.hcm.vbts.pages.HomePage;
import com.hcm.vbts.pages.LoginPage;
import com.hcm.vbts.utils.TestUtil;



public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	TestUtil util;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() throws InterruptedException, IOException {
		browser_init();
		loginpage = new LoginPage();
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		//loginpage.PerformLogout();
		driver.quit();
	}

	@Test(priority = 0)
	public void ValidateLoginPageTitle() {
		String pt = loginpage.ValidateLoginPageTitle();
		Reporter.log("Login Page Title is: " + pt, true);
		assertEquals(pt, "Login");

	}

	@Test(priority = 1)
	public void ValidateLoginPageURL() {
		String lp_url = loginpage.ValidateLoginPageURL();
		Reporter.log("LoginPageURL is " + lp_url, true);
		assertEquals(lp_url, "http://192.168.2.140:8282/thcm/");

	}

	@Test(priority = 2)
	public void ValidateLoginPagePhoneLogo() {
		boolean phone_logo = loginpage.VerifyPhoneLogo();
		if (phone_logo) {
			Reporter.log("Phone Logo is Displayed in Login Page", true);
		} else {
			Reporter.log("Phone Logo is Not Displayed in Login Page", true);
		}
		assertTrue(phone_logo);

	}

	@Test(priority = 3)
	public void Emp_Login() throws InterruptedException, IOException {
		homepage = loginpage.PerformLogin(prop.getProperty("username_emp"), prop.getProperty("password_emp"));
		TestUtil.takeScreenshotAtEndOfTest();
	}
	
	@Test(priority = 4)
	public void RM_Login() throws InterruptedException, IOException {
		homepage = loginpage.PerformLogin(prop.getProperty("username_rm"), prop.getProperty("password_rm"));
		TestUtil.takeScreenshotAtEndOfTest();
	}
	
	@Test(priority = 5)
	public void HR_Login() throws InterruptedException, IOException {
		homepage = loginpage.PerformLogin(prop.getProperty("username_hr"), prop.getProperty("password_hr"));
		TestUtil.takeScreenshotAtEndOfTest();
	}

}
