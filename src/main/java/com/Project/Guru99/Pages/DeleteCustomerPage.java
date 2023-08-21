package com.Project.Guru99.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DeleteCustomerPage extends BasePage{
	
public void navigateToDeleteCustomer() {
		
		WebElement DeleteCustomerButton = driver.findElement(By.xpath("//a[text()='Delete Customer']"));
		DeleteCustomerButton.isDisplayed();
		doClick(DeleteCustomerButton);
		System.out.println("DeleteCustomer button is clicked");

	}
    public void enterCustomerId(String custId) {
	
	if(custId.isEmpty() || custId.isBlank() || custId==null) {
		
		driver.findElement(By.xpath("//input[@name='cusid']")).click();
		clickOnSubmitButton();
				
	    }
	else{
	     driver.findElement(By.xpath("//input[@name='name']")).sendKeys(custId);
	   }
	
    }
    
	public void clickOnSubmitButton() {
		
		driver.findElement(By.xpath("//input[@type='submit' and @value='Submit']")).click();
		sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	

}
	
		
	

