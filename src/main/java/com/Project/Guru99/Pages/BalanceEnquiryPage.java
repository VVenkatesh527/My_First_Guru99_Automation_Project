package com.Project.Guru99.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BalanceEnquiryPage extends BasePage {

	public void navigateToBalanceEnquiry(){
		
		WebElement EditCustomerButton = driver.findElement(By.xpath("//a[@text='Balance Enquiry']"));
		doClick(EditCustomerButton);
	    System.out.println("Balance Enquiry Button Is Clicked");	
	}
	
	public void enterAccountNo(String accountno) {

		if (accountno.isEmpty() || accountno.isBlank() || accountno == null) {

			driver.findElement(By.xpath("//input[@name='accountno']")).click();
			clickOnSubmitButton();

		} else {
			driver.findElement(By.xpath("//input[@name='accountno']")).sendKeys(accountno);
		}

	}

	public void clickOnSubmitButton() {

		driver.findElement(By.xpath("//input[@value='Submit'and @name='AccSubmit']")).click();
		sleep(2000);
		// try to use more SOP statements after clicking any button or webelements
	}

}
