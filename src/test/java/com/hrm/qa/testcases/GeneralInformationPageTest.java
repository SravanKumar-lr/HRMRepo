package com.hrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.GeneralInformationPage;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;

public class GeneralInformationPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	GeneralInformationPage geninfopage;
	
	public GeneralInformationPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		geninfopage=homepage.clickOnGeneralInformationOption();	
	}
	
	@Test
	public void verifyGeneralInfoHeaderTest(){
		Assert.assertTrue(geninfopage.verifyGeneralInfoHeader());
		System.out.println("Header on the general information page test is verified");
	}
}
