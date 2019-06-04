package com.hrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.LoginPage;



public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		loginpage=new LoginPage();
	}
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest(){
		String titleLogin=loginpage.validateLoginPageTitle();
		Assert.assertEquals(titleLogin, "OrangeHRM",
				"Title mismatch is the reason for failure.....");
		System.out.println("loginPageTitleTest is completed successfully");
	}
	@Test(priority=2)
	public void verifyCRMLogoTest(){
		boolean flag=loginpage.validateCRMLogo();
		Assert.assertTrue(flag);
		System.out.println("crmLogoTest is completed successfully");
	}
	@Test(priority=3)
	public void doLoginTest(){
		try {
			loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Logging is done successfully");
	}
}