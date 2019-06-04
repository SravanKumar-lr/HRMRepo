package com.hrm.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

import com.hrm.qa.util.TestUtil;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	public static Actions action;
	
	// TestBase constructor is used to load the properties file
	public TestBase(){
		try {
			prop=new Properties();		
			FileInputStream fis = new FileInputStream("F:\\int\\HRMLiveProjTestAutomation"
					+ "\\src\\main\\java\\com\\hrm\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// initialization method is used to initialize browsers (chrome,FF,IE, ........)
	public static <eventListener> void initialization(){
		String browserName=prop.getProperty("browser");

		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "F:\\Softwares\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver", "F:\\Softwares\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}else{
			System.setProperty("webdriver.ie.driver", "F:\\Softwares\\Drivers\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}					
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.navigate().to(prop.getProperty("url"));
		action=new Actions(driver);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
}
