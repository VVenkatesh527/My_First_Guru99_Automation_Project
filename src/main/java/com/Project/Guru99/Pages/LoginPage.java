package com.Project.Guru99.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

	public void loginGuruBankApp() {

		WebElement userName = driver.findElement(By.xpath("//input[@name='uid']"));
		WebElement passWord = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement loginBtn = driver.findElement(By.xpath("//input[@value='LOGIN' and @name='btnLogin']"));
		
		if (userName.isDisplayed()) {

			System.out.println("Entering UserName in GuruBank Application  ----> " + getInputProperty("username"));
			clearValueAndEnterText(userName, getInputProperty("username"));
		}
		if (passWord.isDisplayed()) {

			System.out.println("Entering PassWord in GuruBank Application  ----> " +getInputProperty("password"));
			clearValueAndEnterText(passWord, getInputProperty("password"));
		}

		if (loginBtn.isDisplayed()) {
			
			System.out.println("Clicking on Login Button ----> " + loginBtn.getAttribute("textContent"));
			doClick(loginBtn);
			sleep(2000);
		}
		

	}
}