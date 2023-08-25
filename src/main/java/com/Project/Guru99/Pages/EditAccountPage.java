package com.Project.Guru99.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EditAccountPage extends BasePage {

	public void navigateToEditAccount(){
		
		WebElement EditCustomerButton = driver.findElement(By.xpath("//a[contains(@text(),'Edit Account')]"));
		doClick(EditCustomerButton);
	    System.out.println("Edit Account Button Is Clicked");	
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
	}

}
