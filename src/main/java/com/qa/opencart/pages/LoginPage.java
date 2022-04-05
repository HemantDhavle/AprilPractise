package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utilities.elementUtils;

public class LoginPage 
{
	private WebDriver driver;
	private elementUtils eu;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		eu = new elementUtils(driver);
	}
	
	private By login_emailAddress = By.xpath("//input[@id='input-email']");
	private By login_password = By.xpath("//input[@id='input-password']");
	private By login_button = By.xpath("//input[@value='Login']");
	
	public void doLogin(String login_emailAddress, String login_password)
	{
		//driver.get("https://demo.opencart.com/index.php?route=account/login");
		eu.doSendKeys(this.login_emailAddress, login_emailAddress);
		eu.doSendKeys(this.login_password, login_password);
		eu.doClick(login_button);
	}
	
}
