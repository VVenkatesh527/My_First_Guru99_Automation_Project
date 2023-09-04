package com.Project.Guru99.Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;

public class BasePage {

	private static FileInputStream inputStream = null;
	public static Properties prop = null;

	private static Properties readPropertyFile() {

		// here input as a parameter is not required ,
		// because we are reading property file and return Properties object references

		String filePath = System.getProperty("user.dir") + "//guru99.properties";
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
		return prop;
	}

	/**
	 * 
	 * @param input
	 * @return
	 */
	public String getInputProperty(String input) {
		// Changing method to read any input from property file
		Properties prop = readPropertyFile();
		String property = prop.getProperty(input);
		return property;
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
		driver.get(getInputProperty("SIT_V4"));

		return driver;
	}

	public void clearValueAndEnterText(WebElement element, String text) {

		element.clear();
		element.sendKeys(text);
		// add SOP statements for entering data in text box
	}

	public static void doClick(WebElement element) {

		element.click();
		// add SOP statements for clicking webelemnts
	}

	public static void sleep(long seconds) {

		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean switchToGuruFrame(WebDriver driver) {

		boolean flag = false;
		WebElement parent_frame = null, child_frame = null;
		int counter = 1;
		List<WebElement> number_of_iframes = driver.findElements(By.tagName("iframe"));
		while (number_of_iframes.size() >= 1) {
			try {
				parent_frame = driver
						.findElement(By.xpath("//iframe[@id='google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0']"));
				sleep(500);
				if (parent_frame.isDisplayed()) {
					flag = true;
					driver.switchTo().frame(parent_frame);
					sleep(100);
				} else {
					flag = false;
					System.out.println("Frame Is Not Displayed");
					break;
				}
				child_frame = driver.findElement(By.xpath("//div[@id='ad_position_box']"
						+ "//iframe[@id='ad_iframe' and @title='Advertisement' and @src='about:blank']"));
				if (child_frame.isDisplayed()) {
					driver.switchTo().frame(child_frame);
				} else {
					flag = false;
					System.out.println("Child Frame Is Not Displayed");
					break;
				}
				
				// if close button is displayed then no need to switch to parent frame.
				// if cross mark is displayed then switch to parent frame.
				
				WebElement dismiss_or_close_button = driver
						.findElement(By.xpath("//div[@id='dismiss-button' or aria-label='Close ad']"));
				if (dismiss_or_close_button.isDisplayed()) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", dismiss_or_close_button);
					System.out.println("clicking on Close button");
				}
				if (flag == true) {
					break;
				}
			} catch (NoSuchElementException e) {
				e.printStackTrace();
			}

			counter++;
		}

		if (counter >= 1) {
			sleep(200);
			driver.switchTo().defaultContent();
		}

		return flag;
	}
	
	public  void takeSnapShot(){
		
		String filePath = System.getProperty("user.dir")+"//Screenshots//test.png";
		TakesScreenshot scrShot =((TakesScreenshot)driver); // webdriver object converted to takesscreenshot
		File sourceFile=scrShot.getScreenshotAs(OutputType.FILE); // image file generate
		File destinationFile=new File(filePath); // string to file
		try {
			FileHandler.copy(sourceFile, destinationFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // source file data moves to dest file
		}
}
