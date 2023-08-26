package com.Project.Guru99.TestCases;

import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Project.Guru99.Pages.BasePage;
import com.Project.Guru99.Pages.Constants;
import com.Project.Guru99.Pages.EditAccountPage;
import com.Project.Guru99.Pages.LoginPage;

public class EditAccountPageTest  extends BasePage{
	
	BasePage  basePage = new BasePage();
	LoginPage loginPage = new LoginPage();
	EditAccountPage editAccountPage = new EditAccountPage();
	
	@BeforeMethod
	public void setup() {
		driver  = basePage.launchBrowser(getInputProperty("browser"));
		loginPage.loginGuruBankApp();
		sleep(2000);
	}
	
	@Test(description = "Validate Edit Account Cannot Be Empty")
	public void validate_edit_account_TC001() {

		editAccountPage.navigateToEditAccount();
		switchToGuruFrame(driver);
		editAccountPage.enterAccountNo("");
		String edit_account_error_message = driver.findElement(By.id("message2")).getAttribute("textContent");				
		AssertJUnit.assertEquals(Constants.edit_account_blank_message, edit_account_error_message, "Account Number must not be blank");
		
	} 
	
	@Test(description = "Validate Edit Account Cannot Be Alphanumeric")
	public void validate_edit_account_TC002() {
	
		editAccountPage.navigateToEditAccount();
		switchToGuruFrame(driver);
		editAccountPage.enterAccountNo("acdgu123");
	String edit_account_error_message = driver.findElement(By.id("message2")).getAttribute("textContent");				
	AssertJUnit.assertEquals(Constants.edit_account_alphanumeric_message, edit_account_error_message, "Characters are not allowed");
	
	}
	@Test(description = "Validate Edit Account Cannot Be Special Characters")
	public void validate_edit_account_TC003() {

		editAccountPage.navigateToEditAccount();
		switchToGuruFrame(driver);
		editAccountPage.enterAccountNo("456123#$%");
		String edit_account_error_message = driver.findElement(By.id("message2")).getAttribute("textContent");				
		AssertJUnit.assertEquals(Constants.edit_account_special_character_message, edit_account_error_message, "Special characters are not allowed");
		
	}
	@Test(description = "Validate Customer Id Cannot Be Blank Spaces")
	public void validate_edit_account_TC004() {

		editAccountPage.navigateToEditAccount();
		switchToGuruFrame(driver);
		editAccountPage.enterAccountNo(" 123456");
		String edit_account_error_message = driver.findElement(By.id("message2")).getAttribute("textContent");				
		AssertJUnit.assertEquals(Constants.edit_account_firstchar_blank_space_message, edit_account_error_message, "Characters are not allowed");
		
	}
	
	@Test(description = "Validate Edit Account Cannot Be Blank Spaces Inbetween")
	public void validate_edit_account_TC005() {

		
		editAccountPage.navigateToEditAccount();
		switchToGuruFrame(driver);
		editAccountPage.enterAccountNo("123 45");
		String edit_account_error_message = driver.findElement(By.id("message2")).getAttribute("textContent");				
		AssertJUnit.assertEquals(Constants.edit_account_blank_space_inbetween_message, edit_account_error_message, "Characters are not allowed");
		
	}
	
	@AfterMethod
	public void TearDown() {
		
		driver.quit();
	}
	
}
