package com.Project.Guru99.TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Project.Guru99.Pages.BasePage;
import com.Project.Guru99.Pages.Constants;
import com.Project.Guru99.Pages.DeleteCustomerPage;
import com.Project.Guru99.Pages.LoginPage;

public class DeleteCustomerPageTest extends BasePage {

	BasePage basePage = new BasePage();
	LoginPage loginPage = new LoginPage();
	DeleteCustomerPage deleteCustIdPage = new DeleteCustomerPage();

	@BeforeMethod
	public void setup() {

		driver = basePage.launchBrowser(getGuru99Property("browser"));
		loginPage.loginGuruBankApp();
		sleep(2000);
	}

	@Test(description = "Validate Delete Customer Cannot Be Empty")
	public void validate_delete_customer_TC001() {

		deleteCustIdPage.navigateToDeleteCustomer();
		switchToGuruFrame(driver);
		deleteCustIdPage.enterCustomerId("");
		String customer_id_error_message = driver.findElement(By.id("message14")).getAttribute("textContent");				
		Assert.assertEquals(Constants.delete_customer_blank_message, customer_id_error_message, "Customer ID is required");
		
	} 
	
	@Test(description = "Validate Delete Customer Cannot Be Alphanumeric")
	public void validate_delete_customer_TC002() {
	
	deleteCustIdPage.navigateToDeleteCustomer();
	switchToGuruFrame(driver);
	deleteCustIdPage.enterCustomerId("ABC1234");
	String customer_id_error_message = driver.findElement(By.id("message14")).getAttribute("textContent");				
	Assert.assertEquals(Constants.delete_customer_alphanumeric_message, customer_id_error_message, "No Error Message");
	
	}
	@Test(description = "Validate Delete Customer Cannot Be Special Characters")
	public void validate_delete_customer_TC003() {

		deleteCustIdPage.navigateToDeleteCustomer();
		switchToGuruFrame(driver);
		deleteCustIdPage.enterCustomerId("456123#$%");
		String customer_id_error_message = driver.findElement(By.id("message14")).getAttribute("textContent");				
		Assert.assertEquals(Constants.delete_customer_special_character_message, customer_id_error_message, "Special characters are not allowed");
		
	}
	@Test(description = "Validate Delete Customer Cannot Be Blank Spaces Inbetween")
	public void validate_delete_customer_TC004() {

		deleteCustIdPage.navigateToDeleteCustomer();
		switchToGuruFrame(driver);
		deleteCustIdPage.enterCustomerId("123 45");
		String customer_id_error_message = driver.findElement(By.id("message14")).getAttribute("textContent");				
		Assert.assertEquals(Constants.delete_customer_blank_space_inbetween_message, customer_id_error_message, "No Error Message");
		
	}
	
	@Test(description = "Validate Delete Customer Cannot Be Blank Spaces ")
	public void validate_delete_customer_TC005() {

		deleteCustIdPage.navigateToDeleteCustomer();
		switchToGuruFrame(driver);
		deleteCustIdPage.enterCustomerId(" ");
		String customer_id_error_message = driver.findElement(By.id("message14")).getAttribute("textContent");				
		Assert.assertEquals(Constants.delete_customer_firstchar_blank_space_message, customer_id_error_message, "No Error Message");
		
	}
	
	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
	
	
	

}
