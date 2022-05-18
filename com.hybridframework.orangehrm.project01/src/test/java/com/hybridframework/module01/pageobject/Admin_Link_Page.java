package com.hybridframework.module01.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Admin_Link_Page {
	public WebDriver driver;

	public Admin_Link_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "btnAdd")
	WebElement Add_Btn;

	@FindBy(id = "systemUser_userName")
	WebElement username;

	@FindBy(id = "systemUser_userType")
	WebElement user_role;

	@FindBy(id = "systemUser_employeeName_empName")
	WebElement employee_name;

	@FindBy(id = "systemUser_status")
	WebElement status;

	@FindBy(id = "systemUser_password")
	WebElement password;

	@FindBy(id = "systemUser_confirmPassword")
	WebElement confirm_password;

	@FindBy(id = "btnSave")
	WebElement Save_btn;

	public void click_on_Add_btn() {
		try {
			Add_Btn.click();
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void click_on_UserRole() {
		try {
			user_role.click();
			Select roles = new Select(user_role);
			roles.selectByIndex(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void click_on_EmpolyeeName(String Ename) {
		try {
			employee_name.clear();
			employee_name.sendKeys(Ename);
			String E_names = employee_name.getText();
			if (E_names.equalsIgnoreCase(Ename)) {
				employee_name.click();
			} else {
				System.out.println("Employee name does not exist");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void click_on_username(String Hodo_name) {
		try {
			username.click();
			username.clear();
			username.sendKeys(Hodo_name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void click_on_status() {
		try {
			Select roles = new Select(status);
			roles.selectByIndex(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cilck_on_password(String hodo_password) {
		try {
			password.click();
			password.sendKeys(hodo_password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cilck_on_ConfirmPassword(String hodo_C_password) {
		try {
			confirm_password.click();
			confirm_password.sendKeys(hodo_C_password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void click_on_Save_btn() {
		try {
			Save_btn.click();
			String exp_title = driver.getTitle();
			String actual_title = "getOrangeHRM";
			if (exp_title.equals(actual_title)) {
				Assert.assertTrue(true);
			} else {
				Assert.assertFalse(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
