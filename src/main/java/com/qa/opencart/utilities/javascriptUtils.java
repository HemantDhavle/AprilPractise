package com.qa.opencart.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class javascriptUtils 
{
	public WebDriver driver;
	public javascriptUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/**
	 * flash the field while validating
	 * @param element
	 */
	public void flash(WebElement element) {
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 10; i++) {
			changeColor("rgb(0,200,0)", element);// 1
			changeColor(bgcolor, element);// 2
		}
	}
	
	/**
	 * change the color of the webelement to highlight the element under test
	 * @param color
	 * @param element
	 */
	private void changeColor(String color, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
	}
	
	/*
	 * Refresh the page
	 */
	public void doJSRefresh()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("history.go(0)");	
	}

	// Get the title of the page
	public String doJSgetTitle()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		return js.executeScript("return document.title;").toString();
	}
	
	// Enter the value into text field
	public void doJSsendKey(String id, String value)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('"+id +"').value='"+value+"';");	
	}
	
	// Click on element
	public void doJSClick(String id)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('"+id +"').click();");	
	}
	
	//Scroll up
	public void JSScrollUp()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight,0);");	
	}
	
	//Scroll down
	public void JSScrollDown()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");	
	}
	
	//Wait until page is ready
	public void JSLoading()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String state = js.executeScript("return document.readystate;").toString();
		if(state.equals("complete"))
		{
			System.out.println("Page is fully loaded");
		}
		else
		{
			for(int i= 0;i<=20;i++)
			{
				try {
					Thread.sleep(1000);
					
					state = js.executeScript("return document.readystate;").toString();
					System.out.println("Current state of page is "+state);
					if(state.equals("complete"))
					{
						break;
					}	
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
