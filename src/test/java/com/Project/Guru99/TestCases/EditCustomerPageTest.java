package com.Project.Guru99.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Project.Guru99.Pages.BasePage;
import com.Project.Guru99.Pages.LoginPage;

public class EditCustomerPageTest extends BasePage{
	
	BasePage  basePage = new BasePage();
	LoginPage loginPage = new LoginPage();
	EditCustomerPage editCustPage = new EditCustomerPage();
	
	@BeforeMethod
	public void setup() {
		driver  = basePage.launchBrowser(getProperty("browser"));
		loginPage.loginGuruBankApp();
		sleep(2000);
	}
	
	@Test
	public void EditCustomer_TC001() {
		
	}
	
	@AfterMethod
	public void TearDown() {
		
		driver.quit();
	}
	

}
