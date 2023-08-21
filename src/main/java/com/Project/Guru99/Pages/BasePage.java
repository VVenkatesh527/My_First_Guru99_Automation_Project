package com.Project.Guru99.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BasePage {

	public static WebDriver driver = null;
	public static String bank_url = "https://demo.guru99.com/V4/index.php";
	public static String username_value = "mngr519485";
	public static String password_value = "Admin@123";

	public WebDriver launchBrowser(String browser) {

		if (browser == null) {
			return driver;
		}

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(bank_url);

		return driver;
	}

	public static void sleep(long seconds) {

		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void switchToGuruFrame(WebDriver driver) {
		WebElement frame1 = driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
		driver.switchTo().frame(frame1);
		WebElement frame2 = driver.findElement(By.id("ad_iframe"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//div[@id='dismiss-button']/div/span")).click();
		driver.switchTo().defaultContent();
		sleep(1000);
	}
	
	public void clearValueAndEnterText(WebElement element, String text) {
		
		element.clear();
		element.sendKeys(text);
	}
	
	public static void doClick(WebElement element) {
		
		element.click();
	}
	
	public String getvalueTagName(WebElement element) {
		
		return element.getAttribute("textContent");
	}
	
	public void getProperty(String input) {
		
		
	}
}
