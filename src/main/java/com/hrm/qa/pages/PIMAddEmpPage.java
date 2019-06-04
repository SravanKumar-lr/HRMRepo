package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;

public class PIMAddEmpPage extends TestBase{
	
	@FindBy(id="menu_pim_viewPimModule")
	WebElement pimtab;
	@FindBy(id="menu_pim_addEmployee")
	WebElement addemployee;
	@FindBy(xpath="//*[@class='head']")
	WebElement emphdrtxt;
	@FindBy(id="btnSave")
	WebElement savebtn;
	@FindBy(name="firstName")
	WebElement firstname;
	@FindBy(name="lastName")
	WebElement lastname;
	@FindBy(name="photofile")
	WebElement choosefilebtn;
	@FindBy(xpath="//a[contains(text(),'Immigration')]")
	WebElement immigrationlink;	
	@FindBy(id="btnSave")
	WebElement edtbtn;
	@FindBy(xpath="//*[@value='Save']")
	WebElement savebtn1;
	
	public PIMAddEmpPage(){
		PageFactory.initElements(driver, this);
	}
	public void gotoEmployeePage(){
		action.moveToElement(pimtab)
			  .moveToElement(addemployee)
			  .click()
			  .build()
			  .perform();
	}
	public boolean verifyHeaderTextOnAddEmpScreen(){
		return emphdrtxt.isDisplayed();
	}
	public void addEmployee(String fName,String lName)throws Exception{
		firstname.sendKeys(fName);
		lastname.sendKeys(lName);
		choosefilebtn.sendKeys("F:\\int\\HRMLiveProjTestAutomation"
				+ "\\src\\main\\java\\com\\hrm\\qa\\testdata\\IMG-20190123-WA0000.jpg");
		savebtn.click();
		Thread.sleep(3000);
		immigrationlink.isDisplayed();
		edtbtn.click();
		savebtn1.click();
	}
}
