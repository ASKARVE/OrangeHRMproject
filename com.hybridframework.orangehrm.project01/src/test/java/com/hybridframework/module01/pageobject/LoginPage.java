package com.hybridframework.module01.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#txtUsername")
	WebElement txtUsername;

	@FindBy(css = "#txtPassword")
	WebElement txtPassword;

	@FindBy(name = "Submit")
	WebElement loginBtn;

	public void setUserName(String username) {
		try {
			txtUsername.click();
			txtUsername.clear();
			txtUsername.sendKeys(username);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void setPassword(String pass) {
		try {
			txtPassword.click();
			txtPassword.clear();
			txtPassword.sendKeys(pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Home_Page clickOnLogin() {
		try {
			loginBtn.click();
			String exp_title = "OrangeHRM";
			String act_title = driver.getTitle();
			if (exp_title.equals(act_title)) {
				Assert.assertTrue(true);
				return new Home_Page(driver);
			} else {
				Assert.assertFalse(false);
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}

}
