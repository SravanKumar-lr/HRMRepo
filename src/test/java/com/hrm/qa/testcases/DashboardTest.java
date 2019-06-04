package com.hrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.DashboardPage;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;

public class DashboardTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	DashboardPage dashboardPage;
	public DashboardTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));	
		dashboardPage=new DashboardPage();
	}
	
	@Test
	public void verifyDashboardPageTest() throws Exception{
		dashboardPage.clickOnDashboardPage();
		Assert.assertTrue(dashboardPage.verifyDashboardHeader());
		dashboardPage.movetoSubUnit();
		System.out.println("Mouse moved over the employee distribution by subunit chart");
	}

}
