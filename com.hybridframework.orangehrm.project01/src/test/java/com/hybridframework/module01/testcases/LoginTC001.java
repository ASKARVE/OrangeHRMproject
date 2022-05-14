package com.hybridframework.module01.testcases;

import org.testng.annotations.Test;

import com.hybridframework.module01.pageobject.LoginPage;
import com.hybridframework.module01.testbase.TestBase;
public class LoginTC001 extends TestBase {

	@Test
	public void verifyLOginFunctionality()
	{
		LoginPage login = new LoginPage(driver);
		login.setUserName(configdataprovider.getUsername());
		login.setUserName(configdataprovider.getPassword());
		login.clickOnLogin();
		
		
		
//		LoginPage login = new LoginPage(driver);
//		login.setUserName("Admin");
//		login.setPassword("admin123");
//		login.clickOnLoginBtn();
	}
}