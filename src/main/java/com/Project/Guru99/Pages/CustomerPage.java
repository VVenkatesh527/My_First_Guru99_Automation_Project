package com.Project.Guru99.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CustomerPage extends BasePage {
	
	public static Alert alert = null;

	
	public void navigateToNewCustomer() {
		
		WebElement NewCustomerButton = driver.findElement(By.xpath("//a[contains(text(),'New Customer')]"));
		doClick(NewCustomerButton);
		System.out.println("New Customer button is clicked");

	}
	
	/**
	 * @author Venkatesh
	 * @description : To Enter CustomerName
	 * @param address : it accepts alphabets
	 */

	public void enterCustomerName(String custName) {
		
		if(custName.isEmpty() || custName.isBlank() || custName==null) {
			
			driver.findElement(By.xpath("//input[@name='name']")).click();
			selectSubmit();
		}
		else{

		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(custName);
		}
	}
		
	/**
	 * @author Venkatesh
	 * @description : To Enter Address
	 * @param address : it accepts alphabets
	 */
	public void enterAddress(String address) {
		
		if(address.isEmpty() || address.isBlank() || address==null) {
			
			driver.findElement(By.xpath("//textarea[@name='addr']")).click();
			selectSubmit();
		}
		else{

		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(address);
		}
	}
	
	/**
	 * @author Venkatesh
	 * @description : To Enter City
	 * @param address : it accepts alphabets
	 */
	public void enterCity(String city) {
		
		if(city.isEmpty() || city.isBlank() || city==null) {
			
			driver.findElement(By.xpath("//input[@name='city']")).click();
			selectSubmit();
			}
		else{
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
		}
	}
	
		
	/**
	 * @author Venkatesh
	 * @description : To Enter State
	 * @param address : it accepts alphabets
	 */
     public void enterState(String state) {
		
		if(state.isEmpty() || state.isBlank() || state==null) {
			
			driver.findElement(By.xpath("//input[@name='state']")).click();
			selectPincode();
		}
		else{

		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(state);
		}
	}
     
	public void selectPincode() {

		driver.findElement(By.xpath("//input[@name='pinno']")).click();
	}	
	
	/**
	 * @author Venkatesh
	 * @description : To Enter PinNo
	 * @param address : it accepts 6Digits numeric
	 */
	public void enterPinCode(String pincode) {
		
		if(pincode.isEmpty() || pincode.isBlank() ||pincode==null) {
			
			driver.findElement(By.xpath("//input[@name='pinno']")).click();
			selectSubmit();
		}
		if( pincode.length()>6 || pincode.length()<6) {
			driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys(pincode);
		}
		else{

		driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys(pincode);
		}
	}
	
	
	/**
	 * @author Venkatesh
	 * @description : To Enter Telephone No
	 * @param address : it accepts 6Digits numeric
	 */
	public void enterTelephoneNo(String TelePhoneno) {
		
		if(TelePhoneno.isEmpty() || TelePhoneno.isBlank() ||TelePhoneno==null) {
			
			driver.findElement(By.xpath("//input[@name='telephoneno']")).click();
			selectSubmit();
		}
		if( TelePhoneno.length()>10 || TelePhoneno.length()<10) {
			driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys(TelePhoneno);
		}
		else{

		driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys(TelePhoneno);
		}
	}
	
	/**
	 * @author Venkatesh
	 * @description : To Enter Email
	 * @param address : it accepts 6Digits numeric
	 */
	public void enterEmail(String Email) {
		
		if(Email.isEmpty() || Email.isBlank() ||Email==null) {
			
			driver.findElement(By.xpath("//input[@name='telephoneno']")).click();
			selectSubmit();
		}
		else{

		driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys(Email);
		}
	}
	
	public void selectSubmit() {

		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		//alert = driver.switchTo().alert();
		
	}
	
	public String addNewCustomer(String password) {
		
		enterCustomerName("Admin");
		driver.findElement(By.xpath("//input[@value='f']")).click();
		driver.findElement(By.name("dob")).sendKeys("05-08-1991");
		enterAddress("Abits");
		enterCity("hyderabad");
		enterState("Tealangana");
		enterPinCode("500001");
		enterTelephoneNo("9494949494");
		enterEmail("guru99@gmail.com");
		driver.findElement(By.name("password")).sendKeys(password);
		selectSubmit();
		String popMessage = alert.getText();
		alert.accept();
		
		return popMessage;
	}
}
