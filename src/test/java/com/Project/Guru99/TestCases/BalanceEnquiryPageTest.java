package com.Project.Guru99.TestCases;

import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Project.Guru99.Pages.BalanceEnquiryPage;
import com.Project.Guru99.Pages.BasePage;
import com.Project.Guru99.Pages.Constants;
import com.Project.Guru99.Pages.LoginPage;

public class BalanceEnquiryPageTest  extends BasePage{
	
	BasePage  basePage = new BasePage();
	LoginPage loginPage = new LoginPage();
	BalanceEnquiryPage balanceEnquiryPage = new BalanceEnquiryPage();
	
	@BeforeMethod
	public void setup() {
		driver  = basePage.launchBrowser(getInputProperty("browser"));
		loginPage.loginGuruBankApp();
		sleep(2000);
	}
	
	@Test(description = "Validate Account No Cannot Be Empty")
	public void validate_balance_enquiry_TC001() {

		balanceEnquiryPage.navigateToBalanceEnquiry();
		switchToGuruFrame(driver);
		balanceEnquiryPage.enterAccountNo("");
		String account_no_error_message = driver.findElement(By.id("message2")).getAttribute("textContent");				
		AssertJUnit.assertEquals(Constants.balance_enquiry_blank_message, account_no_error_message, "Account Number must not be blank");
		
	} 
	
	@Test(description = "Validate Edit Account Cannot Be Alphanumeric")
	public void validate_balance_enquiry_TC002() {
	
		balanceEnquiryPage.navigateToBalanceEnquiry();
		switchToGuruFrame(driver);
		balanceEnquiryPage.enterAccountNo("acdgu123");
	String account_no_error_message = driver.findElement(By.id("message2")).getAttribute("textContent");				
	AssertJUnit.assertEquals(Constants.balance_enquiry_alphanumeric_message, account_no_error_message, "Characters are not allowed");
	
	}
	@Test(description = "Validate Edit Account Cannot Be Special Characters")
	public void validate_balance_enquiry_TC003() {

		balanceEnquiryPage.navigateToBalanceEnquiry();
		switchToGuruFrame(driver);
		balanceEnquiryPage.enterAccountNo("456123#$%");
		String account_no_error_message = driver.findElement(By.id("message2")).getAttribute("textContent");				
		AssertJUnit.assertEquals(Constants.balance_enquiry_special_character_message, account_no_error_message, "Special characters are not allowed");
		
	}
	@Test(description = "Validate Customer Id Cannot Be Blank Spaces")
	public void validate_balance_enquiry_TC004() {

		balanceEnquiryPage.navigateToBalanceEnquiry();
		switchToGuruFrame(driver);
		balanceEnquiryPage.enterAccountNo(" 123456");
		String account_no_error_message = driver.findElement(By.id("message2")).getAttribute("textContent");				
		AssertJUnit.assertEquals(Constants.balance_enquiry_firstchar_blank_space_message, account_no_error_message, "Characters are not allowed");
		
	}
	
	@Test(description = "Validate Edit Account Cannot Be Blank Spaces Inbetween")
	public void validate_balance_enquiry_TC005() {

		
		balanceEnquiryPage.navigateToBalanceEnquiry();
		switchToGuruFrame(driver);
		balanceEnquiryPage.enterAccountNo("123 45");
		String account_no_error_message = driver.findElement(By.id("message2")).getAttribute("textContent");				
		AssertJUnit.assertEquals(Constants.balance_enquiry_blank_space_inbetween_message, account_no_error_message, "Characters are not allowed");
		
	}
	
	@AfterMethod
	public void TearDown() {
		
		driver.quit();
	}

}
