package com.qa.opencart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.LoginPage;

public class baseTest 
{
	public DriverFactory df;
	public WebDriver driver;
	public Properties prop;
	public LoginPage login;
	@BeforeClass
	public void setUp()
	{
		df = new DriverFactory();
		prop = df.init_property();
		driver = df.init_driver(prop);
		login = new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
