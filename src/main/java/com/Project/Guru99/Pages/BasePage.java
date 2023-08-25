package com.Project.Guru99.Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BasePage {
	
	private static FileInputStream inputStream = null;
	public static Properties prop = null;
	
	 private static  String readPropertyFile(String Browser) {
		
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
	 
	 public String getGuru99Property(String input) {
			
			return readPropertyFile(input);
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
		driver.get(getGuru99Property("SIT_V4"));

		return driver;
	}
	
	public void clearValueAndEnterText(WebElement element, String text) {
		
		element.clear();
		element.sendKeys(text);
	}
	
	public static void doClick(WebElement element) {
		
		element.click();
	}

	public static void sleep(long seconds) {

		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void switchToGuruFrame(WebDriver driver) {
		
		WebElement iframe_id = null;
		WebElement iframe_2 = null;
		System.out.println(" antest ");
		
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		if(frames.size()>=1) {
			
			iframe_id = driver.findElement(By.xpath("//iframe[@id='google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0']"));
			sleep(500);
			if(iframe_id.isDisplayed()) {
				driver.switchTo().frame(iframe_id);
				iframe_2 = driver.findElement(By.xpath("//div[@id='ad_position_box']//iframe[@id='ad_iframe' and @title='Advertisement' and @src='about:blank']"));
				if(iframe_2.isDisplayed()) {
					driver.switchTo().frame(iframe_2);
					System.out.println("switching to frame2");
					sleep(500);
					driver.switchTo().parentFrame();
					System.out.println(" test ");
				}
				WebElement dismissBtn = driver.findElement(By.xpath("//div[@id='ad_position_box']//div[@id='dismiss-button' or @class='btn skip' or aria-label='Close ad']"));
				if(dismissBtn.isDisplayed()) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", dismissBtn);
		         System.out.println("clicking on Dismiss button");
				}
				else
		         {
					System.out.println("unable to Click on Dismiss button");
		         }

			
			}
			}
		}
//		
//		if(frame.isDisplayed()) {
//		driver.switchTo().frame(frame);
//		WebElement frame1 = driver.findElement(By.id("ad_iframe"));
//		if(frame1.isDisplayed()) {
//		driver.switchTo().frame(frame1);
//		sleep(2000);
//							WebElement clickonclose = driver.findElement(By.xpath("//*[@id='dismiss-button']"));
//		doClick(clickonclose);
//		driver.switchTo().defaultContent();
//		}
		
//		}
//		driver.switchTo().defaultContent();
//		sleep(1000);
	}
	
	
			
