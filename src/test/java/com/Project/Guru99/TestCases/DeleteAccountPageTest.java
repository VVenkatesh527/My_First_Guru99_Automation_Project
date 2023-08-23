package com.Project.Guru99.TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Project.Guru99.Pages.BasePage;
import com.Project.Guru99.Pages.Constants;
import com.Project.Guru99.Pages.DeleteAccountPage;
import com.Project.Guru99.Pages.LoginPage;

public class DeleteAccountPageTest extends BasePage {
	
	BasePage basePage = new BasePage();
	LoginPage loginPage = new LoginPage();
	DeleteAccountPage deleteAccountPage = new DeleteAccountPage();

	@BeforeMethod
	public void setup() {

		driver = basePage.launchBrowser("chrome");
		loginPage.loginGuruBankApp();
		sleep(2000);
	}

	@Test(description = "Validate Delete Account Cannot Be Empty")
	public void validate_delete_account_TC001() {

		deleteAccountPage.navigateToDeleteAccount();
		switchToGuruFrame(driver);
		deleteAccountPage.enterAccountNo("");
		String delete_acc_error_message = driver.findElement(By.id("message2")).getAttribute("textContent");				
		Assert.assertEquals(Constants.delete_account_blank_message, delete_acc_error_message, "Account Number must not be blank");
		
	} 
	
	@Test(description = "Validate Delete Account Cannot Be Alphanumeric")
	public void validate_delete_account_TC002() {
	
		deleteAccountPage.navigateToDeleteAccount();
		switchToGuruFrame(driver);
		deleteAccountPage.enterAccountNo("acdgu123");
	String delete_acc_error_message = driver.findElement(By.id("message2")).getAttribute("textContent");				
	Assert.assertEquals(Constants.delete_account_alphanumeric_message, delete_acc_error_message, "Characters are not allowed");
	
	}
	@Test(description = "Validate Delete Account Cannot Be Special Characters")
	public void validate_delete_account_TC003() {

		deleteAccountPage.navigateToDeleteAccount();
		switchToGuruFrame(driver);
		deleteAccountPage.enterAccountNo("456123#$%");
		String delete_acc_error_message = driver.findElement(By.id("message2")).getAttribute("textContent");				
		Assert.assertEquals(Constants.delete_account_special_character_message, delete_acc_error_message, "Special characters are not allowed");
		
	}
	@Test(description = "Validate Delete Account Cannot Be Blank Spaces Inbetween")
	public void validate_delete_account_TC004() {

		deleteAccountPage.navigateToDeleteAccount();
		switchToGuruFrame(driver);
		deleteAccountPage.enterAccountNo("123 45");
		String delete_acc_error_message = driver.findElement(By.id("message2")).getAttribute("textContent");				
		Assert.assertEquals(Constants.delete_account_blank_space_inbetween_message, delete_acc_error_message, "Characters are not allowed");
		
	}
	
	@Test(description = "Validate Delete Account Cannot Be Blank Spaces ")
	public void validate_delete_account_TC005() {

		deleteAccountPage.navigateToDeleteAccount();
		switchToGuruFrame(driver);
		deleteAccountPage.enterAccountNo(" ");
		String delete_acc_error_message = driver.findElement(By.id("message2")).getAttribute("textContent");				
		Assert.assertEquals(Constants.delete_account_firstchar_blank_space_message, delete_acc_error_message, "Characters are not allowed");
		
	}
	
	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
	
	
}
