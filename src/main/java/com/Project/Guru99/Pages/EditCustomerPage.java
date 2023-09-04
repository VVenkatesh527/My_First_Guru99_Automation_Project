package com.Project.Guru99.Pages;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;

	public class EditCustomerPage extends BasePage {

		public void navigateToEditCustomer(){
			
			WebElement EditCustomerButton = driver.findElement(By.xpath("//a[@text='Edit Customer']"));
			doClick(EditCustomerButton);
		    System.out.println("Edit Customer Button Is Clicked");	
		}
		
		public void enterCustomerId(String customerId) {

			if (customerId.isEmpty() || customerId.isBlank() || customerId == null) {

				driver.findElement(By.xpath("//input[@name='cusid']")).click();
				clickOnSubmitButton();

			} else {
				driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys(customerId);
			}

		}
		// if the method is same then try to use only one method and keep it in base page , then you can use same method for all the test cases if required

		public void clickOnSubmitButton() {

			driver.findElement(By.xpath("//input[@value='Submit'and @name='AccSubmit']")).click();
			sleep(2000);
//			Alert alert = driver.switchTo().alert();
//			alert.accept();
		}
		
		
		
	}



