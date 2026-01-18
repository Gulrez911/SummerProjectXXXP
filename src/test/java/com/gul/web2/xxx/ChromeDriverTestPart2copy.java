package com.gul.web2.xxx;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
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
import org.springframework.util.ResourceUtils;

import com.gul.web2.ExcelReader;
import com.gul.web2.WebData;

public class ChromeDriverTestPart2copy {
//	private Robot robot;

	public static void main(String[] args) throws Exception {

//		File file = ResourceUtils.getFile("classpath:first1768590149328.xlsx");
		String pathExcle = "C:\\Users\\gulfa\\Desktop\\test\\sunny-leone-first-first-1768645875325.xlsx";
		File file = new File(pathExcle);
//		File file = ResourceUtils.getFile("classpath:first1768594845826.xlsx");
//		String file = "C:/Users/gulfa/Desktop/test/baseFolder";
		InputStream stream = FileUtils.openInputStream(file);
		File f = ResourceUtils.getFile("classpath:xxxwebimage.xml");
//		System.out.println("processing excel file " + f.getName());
		List<WebData> records = ExcelReader.parseExcelFileToBeans(stream, f);
		for (WebData excel : records) {

			List<WebData> data2 = new ArrayList<>();

			System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");

			WebDriver driver = new ChromeDriver();

			try {
//				String url = "https://www.pornpics.de/?q=lexie+fox";

				String url = excel.getUserImageLink();

				driver.get(url);

				JavascriptExecutor js = (JavascriptExecutor) driver;
				int count = 0;
				Long scrollHeight4 = (Long) js
						.executeScript("return document.body.scrollHeight");
				System.out.println("////////////  " + scrollHeight4);
				Long val1 = scrollHeight4;

//					for (int i = 0; i < 20; i++) {

				//////////////////////////////// robot code
//				for (int i = 0; i < 15; i++) {
//					js.executeScript("window.scrollBy(0, 800);");
//					System.out.println("count: " + i);
//					Long scrollHeight = (Long) js.executeScript(
//							"return document.body.scrollHeight");
//
//					System.out.println("Total Page Scroll Height: " + scrollHeight
//							+ " pixels");
//
//					if (count < 4) {
//						if (val1.equals(scrollHeight)) {
//							count++;
//						} else {
//							val1 = scrollHeight;
//							count = 0;
//							count++;
//						}
//
//						count++;
//					} else {
//					}
//					Thread.sleep(1500);
//				}
				///////////////////////////////////////////////////////
//				11

				String html = driver.getPageSource();

				// 🔹 Parse with Jsoup
				Document doc = Jsoup.parse(html, url);

//				        extractData(doc);

//				Document doc = Jsoup.connect("https://www.pornpics.de/pornstars/sunny-leone/").get();
//				Document doc = Jsoup.connect("https://www.pornpics.de/galleries/milf-in-glasses-sunny-leone-reveals-her-fakes-and-poses-naked-in-the-kitchen-71552417/").get();
				Elements elements = doc.getAllElements();

				for (int i = 0; i < elements.size(); i++) {

					Element element = elements.get(i);
					Elements divChildren = element.children();

					for (Element element2 : divChildren) {
						if (element2.className().contains("wookmark-initialised")) {
							Elements abcf = element2.getAllElements();
							for (Element abcf3 : abcf) {
								if (abcf3.className().contains(
										"thumbwook")) {

									Elements abcf344 = abcf3
											.getAllElements();
									for (Element abcf3445 : abcf344) {
										if (abcf3445.toString()
												.contains("rel-link")) {

											String src2 = abcf3445
													.attr("href");

											if (!src2.isEmpty() || !src2
													.equals("")) {

												if (src2.contains(".jpg")
														|| src2.contains(".png")
														|| src2.contains("webp")
														|| src2.contains(".jpeg")) {
													WebData newsDto = new WebData();
													System.out.println(src2);
													newsDto.setUserImageLink(
															src2);
//														newsDto.setUserImageLink(
//																"https://www.pornpics.de"
//																		+ src2);
													newsDto.setMainLink(url);
													newsDto.setUserImageScr(
															pathExcle);
													newsDto.setWebsiteName(
															"PornPic");
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

			} finally {
				// It is important to close the browser session
				driver.quit();
			}

			System.out.println("Done WebData: " + data2.toString());
			transferToFile(data2);

		}
		System.out.println("Done");

	}

	public static void transferToFile(List<WebData> data2) throws IOException {

//		String filePath = "C:\\Users\\gulfa\\Desktop\\test\\weblink.xlsx";
		String path = "C:/Users/gulfa/Desktop/test/" + "sunny-leone-second" + System.currentTimeMillis() + ".xlsx";

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
