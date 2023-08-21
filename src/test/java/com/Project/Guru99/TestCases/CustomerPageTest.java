package com.Project.Guru99.TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Project.Guru99.Pages.BasePage;
import com.Project.Guru99.Pages.Constants;
import com.Project.Guru99.Pages.CustomerPage;
import com.Project.Guru99.Pages.LoginPage;

public class CustomerPageTest extends BasePage {

	BasePage basePage = new BasePage();
	LoginPage loginPage = new LoginPage();
	CustomerPage customerPage = new CustomerPage();

	@BeforeMethod
	public void setup() {

		driver = basePage.launchBrowser("chrome");
		loginPage.loginGuruBankApp();
		sleep(2000);
	}

	@Test(description = "Validate Name Cannot Be Empty")
	public void validate_customer_name_TC001() {

		customerPage.navigateToNewCustomer();
		switchToGuruFrame(driver);
		customerPage.enterCustomerName(" ");
		String customer_name_error_message = driver.findElement(By.id("message")).getAttribute("textContent");				
		Assert.assertEquals(Constants.customer_name_blank_message, customer_name_error_message, "Customer Name Cannot Be Empty");
		
	}
	
	@Test(description = "Validate Name Cannot Be Numeric")
	public void validate_customer_name_TC002() {

		customerPage.navigateToNewCustomer();
		switchToGuruFrame(driver);
		customerPage.enterCustomerName("admin1234");
		String customer_name_error_message = driver.findElement(By.id("message")).getAttribute("textContent");		
		Assert.assertEquals(Constants.customer_name_alphanumeric_message, customer_name_error_message);

	}
	
	@Test(description = "Validate Name Cannot Be Special Character")
	public void validate_customer_name_TC003() {

		customerPage.navigateToNewCustomer();
		switchToGuruFrame(driver);
		customerPage.enterCustomerName("admin@#$");
		String customer_name_error_message = driver.findElement(By.id("message")).getAttribute("textContent");
		Assert.assertEquals(Constants.customer_name_special_character_message, customer_name_error_message);

	}
	
	@Test(description = "Validate Name Cannot Be First Character As Blank Space")
	public void validate_customer_name_TC004() {

		customerPage.navigateToNewCustomer();
		switchToGuruFrame(driver);
		customerPage.enterCustomerName(" admin");
		String customer_name_error_message = driver.findElement(By.id("message")).getAttribute("textContent");
		Assert.assertEquals(Constants.customer_name_firstChar_blank_space_message, customer_name_error_message);

	}
	@Test(description = "Validate address Cannot Be Empty")			
	public void validate_address_TC005() {

		customerPage.navigateToNewCustomer();
		switchToGuruFrame(driver);
		customerPage.enterAddress("");
		String customer_name_error_message = "";
		Assert.assertEquals(Constants.address_blank_message, customer_name_error_message);

	}
	
	@Test(description = "Validate Address It Doesnot Have First Character Blank Sapce")	
	public void validate_address_TC006() {

		customerPage.navigateToNewCustomer();
		switchToGuruFrame(driver);
		customerPage.enterAddress(" admin");
		String customer_name_error_message = "";
		Assert.assertEquals(Constants.address_firstChar_blank_space_message, customer_name_error_message);

	}
	
	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
	//driver.findElement(By.id("message")).getAttribute("textContent")

}