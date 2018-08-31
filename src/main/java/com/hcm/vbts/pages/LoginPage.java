package com.hcm.vbts.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hcm.vbts.base.TestBase;



public class LoginPage extends TestBase{
	
	@FindBy(id="employeecode")
	WebElement UserName;
	
	@FindBy(id="password")
	WebElement PassWord;
	
	@FindBy(xpath="//*[@id=\"loginid\"]")
	WebElement SignIn;
	
	@FindBy(xpath="/html/body/div[1]/div/div[2]/div/div[1]/img")
	WebElement PhoneLogo;
	
	@FindBy(xpath="/html/body/div[1]/div/div/div[3]/ul/li/a")
	WebElement ProfileSection;
	
	@FindBy(xpath="/html/body/div[1]/div/div/div[3]/ul/li/ul/li[3]/a")
	WebElement Logout;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String ValidateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public String ValidateLoginPageURL() {
		
		return driver.getCurrentUrl();
	}
	
	public boolean VerifyPhoneLogo()
	{
		return PhoneLogo.isDisplayed();
	}
	
	public HomePage PerformLogin(String un, String pw) throws InterruptedException
	{
		UserName.click();
		UserName.sendKeys(un);
		
		PassWord.click();
		PassWord.sendKeys(pw);
		
		SignIn.click();
		Thread.sleep(4000);
		return new HomePage();
	}
	
	public HomePage PerformLogout() throws InterruptedException
	{
		ProfileSection.click();
		Logout.click();
		Thread.sleep(2000);
		return new HomePage();
	}
	
	

}
