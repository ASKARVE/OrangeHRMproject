package com.hybridframework.module01.testcases;

import org.testng.annotations.*;
import com.hybridframework.module01.pageobject.Admin_Link_Page;
import com.hybridframework.module01.pageobject.Home_Page;
import com.hybridframework.module01.pageobject.LoginPage;
import com.hybridframework.module01.testbase.TestBase;

public class Admin_TC001 extends TestBase {
	Home_Page home_Page;
	
	@Test(priority=1)
	public void AdminTC() throws Exception{
		
			LoginPage login = new LoginPage(driver);
			login.setUserName(configdataprovider.getUsername());
			login.setUserName(configdataprovider.getPassword());
			 home_Page = login.clickOnLogin();
			 Thread.sleep(5000);
		    Admin_Link_Page admin_Link_Page=new Admin_Link_Page(driver);
		    home_Page.click_on_user();
			admin_Link_Page.click_on_Add_btn();
			admin_Link_Page.click_on_UserRole();
			admin_Link_Page.click_on_EmpolyeeName(exceldata.getStringCellValue("Yash",1,0));
			admin_Link_Page.click_on_username(exceldata.getStringCellValue("Yash", 1, 1));
			admin_Link_Page.click_on_status();
			admin_Link_Page.cilck_on_password(exceldata.getStringCellValue("Yash", 1, 2));
			admin_Link_Page.cilck_on_ConfirmPassword(exceldata.getStringCellValue("Yash", 1, 3));
			admin_Link_Page.click_on_Save_btn();
		}
	}

