package com.qa.opencart.tests;

import org.testng.annotations.Test;

public class loginPageTest extends baseTest 
{
	@Test
	public void doLoginTest()
	{
		login.doLogin(prop.getProperty("un"), prop.getProperty("pw"));
	}

}
