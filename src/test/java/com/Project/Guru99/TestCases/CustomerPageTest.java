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

		driver = basePage.launchBrowser(getGuru99Property("browser"));
		loginPage.loginGuruBankApp();
		sleep(2000);
	}

	@Test(description = "Validate Customer Name Cannot Be Empty")
	public void validate_customer_name_TC001() {

		customerPage.navigateToNewCustomer();
		switchToGuruFrame(driver);
//		customerPage.enterCustomerName(" ");
//		String customer_name_error_message = driver.findElement(By.id("message")).getAttribute("textContent");				
//		Assert.assertEquals(Constants.customer_name_blank_message, customer_name_error_message, "Customer Name Cannot Be Empty");
//		
	}
	
	@Test(description = "Validate Customer Name Cannot Be Numeric")
	public void validate_customer_name_TC002() {

		customerPage.navigateToNewCustomer();
		switchToGuruFrame(driver);
		customerPage.enterCustomerName("admin1234");
		String customer_name_error_message = driver.findElement(By.id("message")).getAttribute("textContent");		
		Assert.assertEquals(Constants.customer_name_alphanumeric_message, customer_name_error_message);

	}
	
	@Test(description = "Validate Customer Name Cannot Be Special Character")
	public void validate_customer_name_TC003() {

		customerPage.navigateToNewCustomer();
		switchToGuruFrame(driver);
		customerPage.enterCustomerName("admin@#$");
		String customer_name_error_message = driver.findElement(By.id("message")).getAttribute("textContent");
		Assert.assertEquals(Constants.customer_name_special_character_message, customer_name_error_message);

	}
	
	@Test(description = "Validate Customer Name Cannot Be First Character As Blank Space")
	public void validate_customer_name_TC004() {

		customerPage.navigateToNewCustomer();
		switchToGuruFrame(driver);
		customerPage.enterCustomerName(" admin");
		String customer_name_error_message = driver.findElement(By.id("message")).getAttribute("textContent");
		Assert.assertEquals(Constants.customer_name_firstchar_blank_space_message, customer_name_error_message);

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
		Assert.assertEquals(Constants.address_firstchar_blank_space_message, customer_name_error_message);

	}
	@Test(description = "Validate City Cannot Be Empty")
	public void validate_customer_name_TC007() {

		customerPage.navigateToNewCustomer();
		switchToGuruFrame(driver);
		customerPage.enterCity(" ");
		String city_error_message = driver.findElement(By.id("message4")).getAttribute("textContent");				
		Assert.assertEquals(Constants.city_blank_message, city_error_message, "City Cannot Be Empty");
		
	}
	
	@Test(description = "Validate City Cannot Be Numeric")
	public void validate_customer_name_TC008() {

		customerPage.navigateToNewCustomer();
		switchToGuruFrame(driver);
		customerPage.enterCity("hyderabad1234");
		String city_error_message = driver.findElement(By.id("message4")).getAttribute("textContent");		
		Assert.assertEquals(Constants.city_alphanumeric_message, city_error_message);

	}
	
	@Test(description = "Validate City Cannot Be Special Character")
	public void validate_customer_name_TC009() {

		customerPage.navigateToNewCustomer();
		switchToGuruFrame(driver);
		customerPage.enterCity("hyderabad@#$");
		String city_error_message = driver.findElement(By.id("message4")).getAttribute("textContent");
		Assert.assertEquals(Constants.city_special_character_message, city_error_message);

	}
	
	@Test(description = "Validate City Cannot Be First Character As Blank Space")
	public void validate_customer_name_TC010() {

		customerPage.navigateToNewCustomer();
		switchToGuruFrame(driver);
		customerPage.enterCity(" hyderabad");
		String city_error_message = driver.findElement(By.id("message4")).getAttribute("textContent");
		Assert.assertEquals(Constants.city_firstchar_blank_space_message, city_error_message);

	}
	
	@Test(description = "Validate State Cannot Be Empty")
	public void validate_customer_name_TC011() {

		customerPage.navigateToNewCustomer();
		switchToGuruFrame(driver);
		customerPage.enterState("");
		String state_error_message = driver.findElement(By.id("message5")).getAttribute("textContent");
		Assert.assertEquals(Constants.state_blank_message, state_error_message);

	}
	
	@Test(description = "Validate State Cannot Be Numeric")
	public void validate_customer_name_TC012() {

		customerPage.navigateToNewCustomer();
		switchToGuruFrame(driver);
		customerPage.enterState("State123");
		String state_error_message = driver.findElement(By.id("message5")).getAttribute("textContent");
		Assert.assertEquals(Constants.state_alphanumeric_message, state_error_message);

	}
	@Test(description = "Validate State Cannot Be Special Character")
	public void validate_customer_name_TC013() {

		customerPage.navigateToNewCustomer();
		switchToGuruFrame(driver);
		customerPage.enterState("State@#$");
		String city_error_message = driver.findElement(By.id("message5")).getAttribute("textContent");
		Assert.assertEquals(Constants.state_special_character_message, city_error_message);

	}
	
	@Test(description = "Validate State Cannot Be First Character As Blank Space")
	public void validate_customer_name_TC014() {

		customerPage.navigateToNewCustomer();
		switchToGuruFrame(driver);
		customerPage.enterState(" Delhi");
		String city_error_message = driver.findElement(By.id("message5")).getAttribute("textContent");
		Assert.assertEquals(Constants.state_firstchar_blank_space_message, city_error_message);

	}
	
	@Test(description = "Validate Pin Code Cannot Be A Character")
	public void validate_customer_name_TC015() {

		customerPage.navigateToNewCustomer();
		switchToGuruFrame(driver);
		customerPage.enterPinCode("1234fgj");
		String pinno_error_message = driver.findElement(By.id("message6")).getAttribute("textContent");
		Assert.assertEquals(Constants.pincode_character_message, pinno_error_message);

	}
	
	@Test(description = "Validate Pin Code Cannot Be Empty")
	public void validate_customer_name_TC016() {

		customerPage.navigateToNewCustomer();
		switchToGuruFrame(driver);
		customerPage.enterPinCode("");
		String pinno_error_message = driver.findElement(By.id("message6")).getAttribute("textContent");
		Assert.assertEquals(Constants.pincode_character_message, pinno_error_message);

	}
	
	@Test(description = "Validate PIN Code must have 6 Digits")
	public void validate_customer_name_TC017() {

		customerPage.navigateToNewCustomer();
		switchToGuruFrame(driver);
		customerPage.enterPinCode("4567891");
		String pinno_error_message = driver.findElement(By.id("message6")).getAttribute("textContent");
		Assert.assertEquals(Constants.pincode_mustbe_6Digits_message, pinno_error_message);

	}
	
	@Test(description = "Validate PIN Code Cannot Be Special Characters")
	public void validate_customer_name_TC018() {

		customerPage.navigateToNewCustomer();
		switchToGuruFrame(driver);
		customerPage.enterPinCode("456@#$");
		String pinno_error_message = driver.findElement(By.id("message6")).getAttribute("textContent");
		Assert.assertEquals(Constants.pincode_special_character_message, pinno_error_message);

	}
	
	@Test(description = "Validate PIN Code Cannot Be First Character Blank Sapce")
	public void validate_customer_name_TC019() {

		customerPage.navigateToNewCustomer();
		switchToGuruFrame(driver);
		customerPage.enterPinCode(" 456562");
		String pinno_error_message = driver.findElement(By.id("message6")).getAttribute("textContent");
		Assert.assertEquals(Constants.pincode_firstchar_blank_space_message, pinno_error_message);

	}
	
	@Test(description = "Validate PIN Code Cannot Have Blank Sapces InBetween")
	public void validate_customer_name_TC020() {

		customerPage.navigateToNewCustomer();
		switchToGuruFrame(driver);
		customerPage.enterPinCode("456 62");
		String pinno_error_message = driver.findElement(By.id("message6")).getAttribute("textContent");
		Assert.assertEquals(Constants.pincode_firstchar_blank_space_message, pinno_error_message);

	}
	
	@Test(description = "Validate Telephone Cannot Be Empty")
	public void validate_customer_name_TC021() {

		customerPage.navigateToNewCustomer();
		switchToGuruFrame(driver);
		customerPage.enterTelephoneNo("");
		String telephoneNo_error_message = driver.findElement(By.id("message7")).getAttribute("textContent");
		Assert.assertEquals(Constants.telephone_blank_message, telephoneNo_error_message);

	}
	
	@Test(description = "Validate Telephone Cannot Be Special Character")
	public void validate_customer_name_TC022() {

		customerPage.navigateToNewCustomer();
		switchToGuruFrame(driver);
		customerPage.enterTelephoneNo("8544464@#$%");
		String telephoneNo_error_message = driver.findElement(By.id("message7")).getAttribute("textContent");
		Assert.assertEquals(Constants.telephone_special_character_message, telephoneNo_error_message);

	}
	
	@Test(description = "Validate Telephone Cannot Be First Character As Blank Space")
	public void validate_customer_name_TC023() {

		customerPage.navigateToNewCustomer();
		switchToGuruFrame(driver);
		customerPage.enterTelephoneNo(" 8544464789");
		String telephoneNo_error_message = driver.findElement(By.id("message7")).getAttribute("textContent");
		Assert.assertEquals(Constants.telephone_firstchar_blank_space_message, telephoneNo_error_message);

	}
	
	@Test(description = "Validate Telephone Cannot Have Blank Space InBetween")
	public void validate_customer_name_TC024() {

		customerPage.navigateToNewCustomer();
		switchToGuruFrame(driver);
		customerPage.enterTelephoneNo(" 8544464789");
		String telephoneNo_error_message = driver.findElement(By.id("message7")).getAttribute("textContent");
		Assert.assertEquals(Constants.telephone_blank_space_message, telephoneNo_error_message);

	}

	@Test(description = "Validate Email Cannot Be Empty")
	public void validate_customer_name_TC025() {

		customerPage.navigateToNewCustomer();
		switchToGuruFrame(driver);
		customerPage.enterEmail("");
		String email_error_message = driver.findElement(By.id("message8")).getAttribute("textContent");
		Assert.assertEquals(Constants.email_blank_message, email_error_message);

	}
	
	@Test(description = "Validate Email must be in correct format")
	public void validate_customer_name_TC026() {

		customerPage.navigateToNewCustomer();
		switchToGuruFrame(driver);
		customerPage.enterEmail("guru99.gmail");
		String email_error_message = driver.findElement(By.id("message8")).getAttribute("textContent");
		Assert.assertEquals(Constants.email_Invalid_message, email_error_message);

	}
	
	@Test(description = "Validate Email cannot have space")
	public void validate_customer_name_TC027() {

		customerPage.navigateToNewCustomer();
		switchToGuruFrame(driver);
		customerPage.enterEmail("guru99@gmail com");
		String email_error_message = driver.findElement(By.id("message8")).getAttribute("textContent");
		Assert.assertEquals(Constants.email_Invalid_message, email_error_message);

	}
	
	@Test(description = "Validate All Fields Of Add New Customer Form")
	public void validate_customer_name_TC028() {

		customerPage.navigateToNewCustomer();
		switchToGuruFrame(driver);
		String get_pop_Message  =  customerPage.addNewCustomer(getGuru99Property("password"));
		
		Assert.assertEquals(Constants.all_fields_submit_pop_message , get_pop_Message, "Both Actual And Expected Message Are Same");

	}
	
		
	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
	

}
