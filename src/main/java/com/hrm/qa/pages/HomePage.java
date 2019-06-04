package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.GeneralInformationPage;


	public class HomePage extends TestBase {
				
		@FindBy(xpath="//a[contains(text(),'Welcome Admin')]")
		WebElement userNameLabel;
		@FindBy(id="menu_admin_viewAdminModule")
		WebElement adminTab;
		@FindBy(id="menu_admin_Organization")
		WebElement organizationMenu;
		@FindBy(id="menu_admin_viewOrganizationGeneralInformation")
		WebElement orgGenInfoMenuOption;
		
		
		public HomePage(){
			PageFactory.initElements(driver, this);
			}
		public String validateLoginPageTitle() {
			String HomePageTitle=driver.getTitle();
			return HomePageTitle;
		}
		
		public boolean verifyUserLabel(){
			return userNameLabel.isDisplayed();
		}
		public GeneralInformationPage clickOnGeneralInformationOption(){
			action.moveToElement(adminTab)
				  .moveToElement(organizationMenu)
				  .moveToElement(orgGenInfoMenuOption)
				  .click()
				  .build()
				  .perform();
			return new GeneralInformationPage();
		}
		

}
