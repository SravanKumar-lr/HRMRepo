package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;


public class LoginPage extends TestBase {
	
	//Page Factory or OR.. Here we will have all the webElements of the login page.
	@FindBy(id="txtUsername")
	WebElement username;
	@FindBy(name="txtPassword")
	WebElement password;
	@FindBy(xpath="//input[@type='submit']")
	WebElement signInbtn;
	@FindBy(css="#divLogo > img")
	WebElement crmLogo;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
		}

	public String validateLoginPageTitle() {
		String loginPageTitle=driver.getTitle();
		return loginPageTitle;
	}

	public boolean validateCRMLogo() {
		return crmLogo.isDisplayed();
	}

	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		signInbtn.click();
		return new HomePage();
		
	}

}
