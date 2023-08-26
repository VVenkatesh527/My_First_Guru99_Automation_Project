package com.Project.Guru99.TestCases;

import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Project.Guru99.Pages.BasePage;
import com.Project.Guru99.Pages.Constants;
import com.Project.Guru99.Pages.EditCustomerPage;
import com.Project.Guru99.Pages.LoginPage;

public class EditCustomerPageTest extends BasePage{
	
	BasePage  basePage = new BasePage();
	LoginPage loginPage = new LoginPage();
	EditCustomerPage editCustPage = new EditCustomerPage();
	
	@BeforeMethod
	public void setup() {
		driver  = basePage.launchBrowser(getInputProperty("browser"));
		loginPage.loginGuruBankApp();
		sleep(2000);
	}
	
	@Test(description = "Validate Customer Id Cannot Be Empty")
	public void validate_edit_customer_TC001() {

		editCustPage.navigateToEditCustomer();
		switchToGuruFrame(driver);
		editCustPage.enterCustomerId("");
		String edit_customer_error_message = driver.findElement(By.id("message14")).getAttribute("textContent");				
		AssertJUnit.assertEquals(Constants.edit_customer_blank_message, edit_customer_error_message, "Account Number must not be blank");
		
	} 
	
	@Test(description = "Validate Customer Id Cannot Be Alphanumeric")
	public void validate_edit_customer_TC002() {
	
		editCustPage.navigateToEditCustomer();
		switchToGuruFrame(driver);
		editCustPage.enterCustomerId("acdgu123");
	String edit_customer_error_message = driver.findElement(By.id("message14")).getAttribute("textContent");				
	AssertJUnit.assertEquals(Constants.edit_customer_alphanumeric_message, edit_customer_error_message, "Characters are not allowed");
	
	}
	@Test(description = "Validate Customer Id Cannot Be Special Characters")
	public void validate_edit_customer_TC003() {

		editCustPage.navigateToEditCustomer();
		switchToGuruFrame(driver);
		editCustPage.enterCustomerId("456123#$%");
		String edit_customer_error_message = driver.findElement(By.id("message14")).getAttribute("textContent");				
		AssertJUnit.assertEquals(Constants.edit_customer_special_character_message, edit_customer_error_message, "Special characters are not allowed");
		
	}
	@Test(description = "Validate Customer Id Cannot Be Blank Spaces")
	public void validate_edit_customer_TC004() {

		editCustPage.navigateToEditCustomer();
		switchToGuruFrame(driver);
		editCustPage.enterCustomerId(" 123456");
		String edit_customer_error_message = driver.findElement(By.id("message14")).getAttribute("textContent");				
		AssertJUnit.assertEquals(Constants.edit_customer_firstchar_blank_space_message, edit_customer_error_message, "Characters are not allowed");
		
	}
	
	@Test(description = "Validate Customer Id Cannot Be Blank Spaces Inbetween")
	public void validate_edit_customer_TC005() {

		
		editCustPage.navigateToEditCustomer();
		switchToGuruFrame(driver);
		editCustPage.enterCustomerId("123 45");
		String edit_customer_error_message = driver.findElement(By.id("message14")).getAttribute("textContent");				
		AssertJUnit.assertEquals(Constants.edit_customer_blank_space_inbetween_message, edit_customer_error_message, "Characters are not allowed");
		
	}
	
	@AfterMethod
	public void TearDown() {
		
		driver.quit();
	}
	

}
