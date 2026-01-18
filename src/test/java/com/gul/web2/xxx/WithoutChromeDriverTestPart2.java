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

public class WithoutChromeDriverTestPart2 {
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

//			System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
//
//			WebDriver driver = new ChromeDriver();

			try {
//				String url = "https://www.pornpics.de/?q=lexie+fox";

				String url = excel.getUserImageLink();

				Document doc = Jsoup.connect(url).get();
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
//									WebData newsDto = new WebData();
									for (Element abcf3445 : abcf344) {
										if (abcf3445.toString()
												.contains("rel-link")) {

											Elements ssss = abcf3445
													.children();
											for (Element ddeee : ssss) {
												String href = ddeee.attr(
														"href");
//												System.out.println(href);
//												WebData newsDto = new WebData();
//												newsDto.setUserImageLink(
//														href);
												if (ddeee.children().toString()
														.contains("img")) {
													System.out.println("img2:  "
															+ ddeee.children());

													Elements imgChildre = ddeee
															.children();
													for (Element ss : imgChildre) {

														System.out.println(href);
														WebData newsDto = new WebData();
														newsDto.setUserImageLink(
																href);
														String src = ss.attr(
																"src");
														System.out.println("src:  "
																+ src);

														String data_src = ss.attr(
																"data-src");
														System.out.println("found:  "
																+ data_src);

//															ddddd

														newsDto.setUserImageScr(
																data_src);

//															loop category

//															newsDto.setUserImageLink(
//																	"https://www.pornpics.de"
//																			+ src2);
//															loop category

														newsDto.setMainLink(url);
														newsDto.setWebsiteName(
																"PornPic");
														if (!newsDto.getUserImageScr()
																.equals("")) {
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
				System.out.println("Done WebData: " + data2.toString());
				transferToFile(data2);

				System.out.println("Done");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public static void transferToFile(List<WebData> data2) throws IOException {

//		String filePath = "C:\\Users\\gulfa\\Desktop\\test\\weblink.xlsx";
		String path = "C:/Users/gulfa/Desktop/test/" + "sunny-leone-second-" + System.currentTimeMillis()
				+ ".xlsx";

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
