package com.gul.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.*;

public class WebCrawler {

	private static final int MAX_DEPTH = 2;
	private static final int DELAY_MS = 2000;

	private WebDriver driver;
	private Set<String> visitedUrls = new HashSet<>();

	public WebCrawler() {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--disable-gpu");
		options.addArguments("--window-size=1920,1080");

		driver = new ChromeDriver(options);
	}

	public void crawl(String url, int depth) {
		if (depth > MAX_DEPTH || visitedUrls.contains(url)) {
			return;
		}

		try {
			visitedUrls.add(url);
			driver.get(url);

			System.out.println("Crawling (Depth " + depth + "): " + url);

			Thread.sleep(DELAY_MS);

			List<WebElement> links = driver.findElements(By.tagName("a"));

			for (WebElement link : links) {
				String href = link.getAttribute("href");

				if (href != null && href.startsWith("http")) {
					crawl(href, depth + 1);
				}
			}

		} catch (Exception e) {
			System.out.println("Failed to crawl: " + url);
		}
	}

	public void close() {
		driver.quit();
	}

	public static void main(String[] args) {
		WebCrawler crawler = new WebCrawler();

		crawler.crawl("https://www.pornpics.de/pornstars/sunny-leone/", 0);

		crawler.close();
	}
}
