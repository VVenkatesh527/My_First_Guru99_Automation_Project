package com.Project.Guru99.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DeleteAccountPage extends BasePage {

	/**
	 * 1. for variables & methods camel case eg: testApp
	 * 2. for class first character of each word should be upper case
	 * 3. for package name you can use the format eg: com.project.guru99.Pages
	 */
	public void navigateToDeleteAccount() {

		WebElement DeleteAccountButton = driver.findElement(By.xpath("//a[text()='Delete Account']"));
		DeleteAccountButton.isDisplayed();
		doClick(DeleteAccountButton);
		System.out.println("DeleteAccount button is clicked");

	}

	public void enterAccountNo(String AccNo) { // here AccNo is variable, so you can declare variable as accNum like this

		if (AccNo.isEmpty() || AccNo.isBlank() || AccNo == null) {

			driver.findElement(By.xpath("//input[@name='accountno']")).click();
			clickOnAccSubmitButton();

		} else {
			driver.findElement(By.xpath("//input[@name='accountno']")).sendKeys(AccNo);
		}

	}
	// if the method is same then try to use only one method and keep it in base page , then you can use same method for all the test cases if required

	public void clickOnAccSubmitButton() {

		driver.findElement(By.xpath("//input[@value='Submit'and @name='AccSubmit']")).click();
		sleep(3000);
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
	}

}
