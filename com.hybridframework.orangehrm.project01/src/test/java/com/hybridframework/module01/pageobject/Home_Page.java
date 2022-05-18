package com.hybridframework.module01.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Home_Page {
	public WebDriver driver;

	public Home_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//b[contains(text(),'Admin')]")
	WebElement Admin_link;

	@FindBy(css = "#menu_admin_UserManagement")
	WebElement click_usermanagement;

	@FindBy(css = "#menu_admin_viewSystemUsers")
	WebElement click_user;

	public void click_on_Admin_link() {
		try {
			Admin_link.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void click_on_usermanagement() {
		try {
			click_usermanagement.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Admin_Link_Page click_on_user() {
		try {
			click_user.click();
			return new Admin_Link_Page(driver); 

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
//	public Admin_Link_Page click_on_Admin_link() {
//		try {
//			Admin_link.click();
//			String exp_title = "OrangeHRM";
//			String act_title = driver.getTitle();
//			if (exp_title.equals(act_title)) {
//				Assert.assertTrue(true);
//				return new Admin_Link_Page(driver);
//			} else {
//				Assert.assertFalse(false);
//				return null;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
