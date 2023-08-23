package com.Project.Guru99.Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BasePage {
	
	private static FileInputStream inputStream = null;
	public static Properties prop = null;
	
	 private static  String ReadPropertyFile(String Browser) {
		
		 String filePath = System.getProperty("user.dir") + "\\guru99.properties";
		 File file = new File(filePath);
		 try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
						e.printStackTrace();
		}
		 Properties prop = new Properties();
		 try {
			prop.load(inputStream);
		} catch (IOException e) {
				e.printStackTrace();
		}
		  return prop.getProperty(Browser); 
		} 

	public static WebDriver driver = null;

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
		driver.get(getProperty("SIT_V4"));

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
	
	public String getProperty(String input) {
		
		return ReadPropertyFile(input);
	}
	
}