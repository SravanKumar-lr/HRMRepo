package com.hrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.GeneralInformationPage;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	GeneralInformationPage geninfopage;
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle=homepage.validateLoginPageTitle();
		Assert.assertEquals(homePageTitle, "OrangeHRM",
				"Title mismatch is the reason for failure.....");
		System.out.println("Page title of homepage test is verified");
	}
	@Test(priority=2)
	public void verifyLoggedInWelcomeUserLabelTest(){
		Assert.assertTrue(homepage.verifyUserLabel());
		System.out.println("Page title of homepage test is verified");
	}
	@Test(priority=3)
	public void clickOnGeneralInfoOptionTest(){
		geninfopage=homepage.clickOnGeneralInformationOption();
		System.out.println("Click action is performed on the general information menu option");
	}

}
