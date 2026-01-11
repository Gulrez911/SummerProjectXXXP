package com.gul.web2;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverTest {
//	private Robot robot;

	public static void main(String[] args) throws InterruptedException, AWTException, IOException {

		Path file = Paths.get("C:\\Users\\gulfa\\Desktop\\test\\demo.txt");
		String content = "";
		
		//////////////////////////////
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.google.com");

		try {
//			String url = "https://news.un.org/en/";
//			String url ="https://onepagelove.com/templates";
			String url ="https://www.pornpics.de/pornstars/";
//			String url ="https://www.pornpics.de/pornstars/sunny-leone/";
			driver.get(url);
//			System.out.println("Page title is: " + driver.getTitle());

			////////////////////////////

			JavascriptExecutor js = (JavascriptExecutor) driver;
			int count = 0;
			Long scrollHeight4 = (Long) js.executeScript("return document.body.scrollHeight");
			System.out.println("////////////  " + scrollHeight4);
			Long val1 = scrollHeight4;

			for (int i = 0; i < 20; i++) {
				js.executeScript("window.scrollBy(0, 800);");
				System.out.println("count: " + i);
				Long scrollHeight = (Long) js
						.executeScript("return document.body.scrollHeight");

				System.out.println("Total Page Scroll Height: " + scrollHeight + " pixels");

				if (count < 5) {
					if (val1.equals(scrollHeight)) {
//						System.out.println("same");
						count++;
					} else {
						val1 = scrollHeight;
						count = 0;
						count++;
					}

					count++;
				} else {
//					return;
				}
//				String currentUrl = driver.getCurrentUrl();
//				System.out.println("URL:    "+currentUrl);
				Thread.sleep(2000);
			}

//			11

			String html = driver.getPageSource();

			// 🔹 Parse with Jsoup
			Document doc = Jsoup.parse(html, url);

//			        extractData(doc);

//			Document doc = Jsoup.connect("https://www.pornpics.de/pornstars/sunny-leone/").get();
//			Document doc = Jsoup.connect("https://www.pornpics.de/galleries/milf-in-glasses-sunny-leone-reveals-her-fakes-and-poses-naked-in-the-kitchen-71552417/").get();
			Elements elements = doc.getAllElements();

			for (int i = 0; i < elements.size(); i++) {

				Element element = elements.get(i);
				Elements divChildren = element.children();

				for (Element element2 : divChildren) {
					if (element2.className().contains("wookmark-initialised")) {
						Elements abcf = element2.getAllElements();
						for (Element abcf3 : abcf) {
							if (abcf3.className().contains("thumbwook")) {

								Elements abcf344 = abcf3
										.getAllElements();
								for (Element abcf3445 : abcf344) {
									if (abcf3445.toString()
											.contains("rel-link")) {

										String src2 = abcf3445
												.attr("href");
										System.out.println(src2);
										content+= src2+"\n";
									}
								}

							}
						}
					}

				}
			}
//			22

			Files.write(file, content.getBytes(StandardCharsets.UTF_8));
			System.out.println("Scrolling completed.");

			System.out.println("done");
			///////////////////////////

		} finally {
			// It is important to close the browser session
			driver.quit();
		}
		
		

	}

}
 