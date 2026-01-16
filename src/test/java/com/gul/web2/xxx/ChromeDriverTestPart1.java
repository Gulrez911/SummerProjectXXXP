package com.gul.web2.xxx;

import java.awt.AWTException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gul.web2.WebData;

public class ChromeDriverTestPart1 {
//	private Robot robot;

	public static void main(String[] args) throws InterruptedException, AWTException, IOException {

		List<WebData> data2 = new ArrayList<>();

		Path file = Paths.get("C:\\Users\\gulfa\\Desktop\\test\\demo.txt");
		String content = "";

		//////////////////////////////
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.google.com");

		try {
//			String url = "https://news.un.org/en/";
//			String url ="https://onepagelove.com/templates";
//			String url ="https://www.pornpics.de/pornstars/";

//			for (int j = 1; j < 503; j++) {
//			for (int j = 1; j < 2; j++) {
//				String url = "https://www.pornpics.de/pornstars/" + j;
//				String url = "https://www.pornpics.de/galleries/pretty-arab-babe-mia-khalifa-fucks-a-black-stud-lets-him-cum-on-her-big-tits-26210531/";
//			String url = "https://www.pornpics.de/?q=lexie+fox";

				String url = "https://www.pornpics.com/pornstars/mia-khalifa/";
				
				
			driver.get(url);
//			System.out.println("Page title is: " + driver.getTitle());

			////////////////////////////

			JavascriptExecutor js = (JavascriptExecutor) driver;
			int count = 0;
			Long scrollHeight4 = (Long) js.executeScript("return document.body.scrollHeight");
			System.out.println("////////////  " + scrollHeight4);
			Long val1 = scrollHeight4;

//				for (int i = 0; i < 20; i++) {

			//////////////////////////////// robot code
			for (int i = 0; i < 15; i++) {
				js.executeScript("window.scrollBy(0, 800);");
				System.out.println("count: " + i);
				Long scrollHeight = (Long) js
						.executeScript("return document.body.scrollHeight");

				System.out.println("Total Page Scroll Height: " + scrollHeight + " pixels");

				if (count < 4) {
					if (val1.equals(scrollHeight)) {
						count++;
					} else {
						val1 = scrollHeight;
						count = 0;
						count++;
					}

					count++;
				} else {
				}
				Thread.sleep(1500);
			}
///////////////////////////////////////////////////////
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
//								WebData newsDto = new WebData();
								for (Element abcf3445 : abcf344) {
									if (abcf3445.toString()
											.contains("rel-link")) {

										Elements ssss = abcf3445
												.children();
										for (Element ddeee : ssss) {
											String href = ddeee.attr(
													"href");
											System.out.println(href);
											WebData newsDto = new WebData();
											newsDto.setUserImageLink(
													href);
											if (ddeee.children().toString()
													.contains("img")) {
												System.out.println("img2:  "
														+ ddeee.children());

												Elements imgChildre = ddeee
														.children();
												for (Element ss : imgChildre) {
													String src = ss.attr(
															"src");
													System.out.println("src:  "
															+ src);

													String data_src = ss.attr(
															"data-src");
													System.out.println("found:  "
															+ data_src);

//														ddddd

													newsDto.setUserImageScr(
															data_src);

//														loop category

//														newsDto.setUserImageLink(
//																"https://www.pornpics.de"
//																		+ src2);
//														loop category

													newsDto.setMainLink(url);
													newsDto.setWebsiteName(
															"PornPic");
													if (newsDto.getUserImageLink()
															.contains("https://www.pornpics")) {
														data2.add(newsDto);
													}
												}

											}

										}

									}
								}

							}
						}
					}

				}
			}
		} finally {
			// It is important to close the browser session
			driver.quit();
		}

		System.out.println("Done WebData: " + data2.toString());
		transferToFile(data2);

	}

	public static void transferToFile(List<WebData> data2) throws IOException {

//		String filePath = "C:\\Users\\gulfa\\Desktop\\test\\weblink.xlsx";
		String path = "C:/Users/gulfa/Desktop/test/"+"first" + System.currentTimeMillis() + ".xlsx";

		try (// Create Blank workbook
				XSSFWorkbook workbook = new XSSFWorkbook()) {
			// Create file system using specific name
			FileOutputStream out = new FileOutputStream(new File(path));

			// write operation workbook using file out object
			workbook.write(out);

			try (Workbook workbook1 = new XSSFWorkbook();
					FileOutputStream fos = new FileOutputStream(path)) {

//				Sheet sheet = workbook1.createSheet("Employees");
				Sheet sheet = workbook1.createSheet("pornpic");
				
				// Header row
				Row headerRow = sheet.createRow(0);
				headerRow.createCell(0).setCellValue("Website Name");
				headerRow.createCell(1).setCellValue("Website Main Link");
				headerRow.createCell(2).setCellValue("User Image Link");
				headerRow.createCell(3).setCellValue("User Image Src");

				int rowNum = 1;

				for (WebData web : data2) {
					Row row = sheet.createRow(rowNum++);

					int colNum = 0;

					Cell cell = row.createCell(colNum++);
					cell.setCellValue((String) web.getWebsiteName());

					Cell cell2 = row.createCell(colNum++);
					cell2.setCellValue((String) web.getMainLink());

					Cell cell3 = row.createCell(colNum++);
					cell3.setCellValue((String) web.getUserImageLink());

					Cell cell4 = row.createCell(colNum++);
					cell4.setCellValue((String) web.getUserImageScr());

				}

				Row rowEnd = sheet.createRow(rowNum++);
				Cell cell = rowEnd.createCell(0);
				cell.setCellValue("End Rows:");
				// Auto-size columns
				for (int i = 0; i < 3; i++) {
					sheet.autoSizeColumn(i);
				}

				workbook1.write(fos);
				System.out.println("Excel file written successfully.");

			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("createworkbook.xlsx written successfully");
			out.close();
		}
	}
}
