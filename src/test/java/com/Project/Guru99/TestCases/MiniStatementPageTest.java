package com.Project.Guru99.TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Project.Guru99.Pages.BasePage;
import com.Project.Guru99.Pages.Constants;
import com.Project.Guru99.Pages.LoginPage;
import com.Project.Guru99.Pages.MiniStatementPage;

public class MiniStatementPageTest extends BasePage {
	

	BasePage basePage = new BasePage();
	LoginPage loginPage = new LoginPage();
	MiniStatementPage miniStatementPage = new MiniStatementPage();

	@BeforeMethod
	public void setup() {

		driver = basePage.launchBrowser(getProperty("browser"));
		loginPage.loginGuruBankApp();
		sleep(2000);
	}

	@Test(description = "Validate Mini Statement Cannot Be Empty")
	public void validate_Mini_Statement_TC001() {

		miniStatementPage.navigateToMiniStatement();
		switchToGuruFrame(driver);
		miniStatementPage.enterAccountNo("");
		String mini_statement_error_message = driver.findElement(By.id("message2")).getAttribute("textContent");				
		Assert.assertEquals(Constants.delete_account_blank_message, mini_statement_error_message, "Account Number must not be blank");
		
	} 
	
	@Test(description = "Validate Mini Statement Cannot Be Alphanumeric")
	public void validate_Mini_Statement_TC002() {
	
		miniStatementPage.navigateToMiniStatement();
		switchToGuruFrame(driver);
		miniStatementPage.enterAccountNo("acdgu123");
	String mini_statement_error_message = driver.findElement(By.id("message2")).getAttribute("textContent");				
	Assert.assertEquals(Constants.delete_account_alphanumeric_message, mini_statement_error_message, "Characters are not allowed");
	
	}
	@Test(description = "Validate Mini Statement Cannot Be Special Characters")
	public void validate_Mini_Statement_TC003() {

		miniStatementPage.navigateToMiniStatement();
		switchToGuruFrame(driver);
		miniStatementPage.enterAccountNo("456123#$%");
		String mini_statement_error_message = driver.findElement(By.id("message2")).getAttribute("textContent");				
		Assert.assertEquals(Constants.delete_account_special_character_message, mini_statement_error_message, "Special characters are not allowed");
		
	}
	@Test(description = "Validate Mini Statement Cannot Be Blank Spaces Inbetween")
	public void validate_Mini_Statement_TC004() {

		miniStatementPage.navigateToMiniStatement();
		switchToGuruFrame(driver);
		miniStatementPage.enterAccountNo("123 45");
		String mini_statement_error_message = driver.findElement(By.id("message2")).getAttribute("textContent");				
		Assert.assertEquals(Constants.delete_account_blank_space_inbetween_message, mini_statement_error_message, "Characters are not allowed");
		
	}
	
	@Test(description = "Validate Mini Statement Cannot Be Blank Spaces ")
	public void validate_Mini_Statement_TC005() {

		miniStatementPage.navigateToMiniStatement();
		switchToGuruFrame(driver);
		miniStatementPage.enterAccountNo(" ");
		String mini_statement_error_message = driver.findElement(By.id("message2")).getAttribute("textContent");				
		Assert.assertEquals(Constants.delete_account_firstchar_blank_space_message, mini_statement_error_message, "Characters are not allowed");
		
	}
	
	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
	
}
