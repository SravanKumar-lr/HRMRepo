package com.hrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.pages.PIMAddEmpPage;

public class PIMAddEmpPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	PIMAddEmpPage addemppage;
	
	public PIMAddEmpPageTest(){
		super();
	}
	@BeforeMethod
	public void setup(){
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		addemppage=new PIMAddEmpPage();
	}
	
	@Test(priority=1)
	public void gotoAddEmployeePageTest()throws Exception{
		Thread.sleep(3000);
		addemppage.gotoEmployeePage();Thread.sleep(3000);
		Assert.assertTrue(addemppage.verifyHeaderTextOnAddEmpScreen());
		System.out.println("Header on the add employeePage test is verified");
	}
	@Test(priority=2)
	public void addEmployee(){
		addemppage.gotoEmployeePage();
		try {
			addemppage.addEmployee(prop.getProperty("fname"), prop.getProperty("lname"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
