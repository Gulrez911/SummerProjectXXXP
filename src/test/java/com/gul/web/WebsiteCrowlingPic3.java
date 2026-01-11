package com.gul.web;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebsiteCrowlingPic3 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\driver\\chromedriver.exe");
		
		WebDriver driver;
		
		 ChromeOptions chromeOptions = new ChromeOptions();
		        
		//      chromeOptions.addArguments("--headless"); 
		    //  chromeOptions.addArguments("no-sandbox");
		        driver= new ChromeDriver(chromeOptions);
		
		
		// Set the path to your ChromeDriver executable
		// System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
//		driver = new ChromeDriver();
		driver.get("https://www.pornpics.de/galleries/submissive-sluts-dani-daniels-and-lilith-luxe-get-ass-fucked-by-their-master-45013656/\r\n"
				+ ""); // Replace with target URL

		JavascriptExecutor js = (JavascriptExecutor) driver;
		long lastHeight = (Long) js.executeScript("return document.body.scrollHeight");

		while (true) {
			// Scroll down to the bottom of the page
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

			// Wait for the new content to load
			TimeUnit.SECONDS.sleep(3); // Adjust sleep time based on website speed

			// Calculate new scroll height and compare with last scroll height
			long newHeight = (Long) js.executeScript("return document.body.scrollHeight");
			if (newHeight == lastHeight) {
				// If heights are the same, we have reached the bottom
				break;
			}
			lastHeight = newHeight;
		}

		// Now all content is loaded, proceed with data scraping...
		System.out.println("Page fully loaded. Total height: " + "newHeight");

		driver.quit();
	}
}
