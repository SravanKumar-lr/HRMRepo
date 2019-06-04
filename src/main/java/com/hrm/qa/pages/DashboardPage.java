package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;

public class DashboardPage extends TestBase{
	
	
	@FindBy(id="menu_dashboard_index")
	WebElement dashboardtab;
	@FindBy(css="#content > div > div.head")
	WebElement dashboardhdrtxt;
	@FindBy(id="div_graph_display_emp_distribution")
	WebElement subunit;
	
	public DashboardPage(){
		PageFactory.initElements(driver, this);
	}
	
	public DashboardPage clickOnDashboardPage(){
		dashboardtab.click();
		return new DashboardPage();
	}
	public boolean verifyDashboardHeader(){
		return dashboardhdrtxt.isDisplayed();
	}
	public void movetoSubUnit(){
		
	}
	
}
