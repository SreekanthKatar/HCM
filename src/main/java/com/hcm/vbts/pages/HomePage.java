package com.hcm.vbts.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hcm.vbts.base.TestBase;



public class HomePage extends TestBase{

	@FindBy(xpath="/html/body/div[1]/div/div/div[1]/a/img")
	WebElement HCMLogo;
	
	@FindBy(xpath="/html/body/div[4]/div/div/div/div/div/div[1]/div/div[1]/table/tbody/tr[4]/td[2]")
	WebElement MobileNumber;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean VerifyHCMLogo()
	{
		return HCMLogo.isDisplayed();
	}
	
	public String ValidateHomePageURL()
	{
		return driver.getCurrentUrl();
	}
	
	public String ValidateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public String ValidateMobileNumber()
	{
		return MobileNumber.getText();
	}
	
	
}
