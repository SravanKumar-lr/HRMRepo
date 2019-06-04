package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;

public class GeneralInformationPage extends TestBase{
	
	@FindBy(id="genInfoHeading")
	WebElement header;
	
	public GeneralInformationPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyGeneralInfoHeader(){
		return header.isDisplayed();
	}
	
}
