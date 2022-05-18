package com.hybridframework.module01.testcases;

import org.testng.annotations.Test;
import com.hybridframework.module01.pageobject.Home_Page;
import com.hybridframework.module01.pageobject.LoginPage;
import com.hybridframework.module01.testbase.TestBase;

public class Home_TC001 extends TestBase {
	Home_Page home_Page;
	
	@Test(priority=1)
	public void verifyLOginFunctionality() {
		LoginPage login = new LoginPage(driver);
		login.setUserName(configdataprovider.getUsername());
		login.setUserName(configdataprovider.getPassword());
		 home_Page = login.clickOnLogin();
	}
	@Test(priority=2)
	public void admin_Link() {
		try {
			home_Page.click_on_Admin_link();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
