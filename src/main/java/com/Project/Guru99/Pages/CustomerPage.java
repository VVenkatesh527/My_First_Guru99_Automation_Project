package com.Project.Guru99.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CustomerPage extends BasePage {

	
	public void navigateToNewCustomer() {
		
		WebElement NewCustomerButton = driver.findElement(By.xpath("//a[contains(text(),'New Customer')]"));
		doClick(NewCustomerButton);
		System.out.println("New Customer button is clicked");

	}

	public void enterCustomerName(String custName) {
		
		if(custName.isEmpty() || custName.isBlank() || custName==null) {
			
			driver.findElement(By.xpath("//input[@name='name']")).click();
			selectFemaleRadioButton();
		}
		else{

		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(custName);
		}
	}
	
	
	public void selectFemaleRadioButton() {

		driver.findElement(By.xpath("//input[@value='f']")).click();
	}
	
	/**
	 * @author Venkatesh
	 * @description : To Enter Address
	 * @param address : it accepts address
	 */
	public void enterAddress(String address) {
		
		if(address.isEmpty() || address.isBlank() || address==null) {
			
			driver.findElement(By.xpath("//textarea[@name='addr']")).click();
			selectCity();
		}
		else{

		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(address);
		}
	}
	
	public void selectCity() {

		driver.findElement(By.xpath("//input[@name='city']")).click();
	}
	
	//city Method
	
	public void enterCity(String city) {
		
		if(city.isEmpty() || city.isBlank() || city==null) {
			
			driver.findElement(By.xpath("//textarea[@name='city']")).click();
			selectState();
		}
		else{

		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(city);
		}
	}
	
	public void selectState() {

		driver.findElement(By.xpath("//input[@name='state']")).click();
	}

	
	
}
