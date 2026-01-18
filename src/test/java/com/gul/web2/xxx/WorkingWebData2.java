package com.gul.web2.xxx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.gul.web2.WebData;

public class WorkingWebData2 {

	public static void main(String[] args) throws IOException {

		List<WebData> data2 = new ArrayList<>();
//		String url = "https://www.pornpics.de/?q=lexie+fox";
//		String url ="https://www.pornpics.de/pornstars/sunny-leone/";
//		String url = "https://www.pornpics.de/pornstars/";
//		String url = "https://www.pornpics.de/?q=lexie+fox";
//		String url = "https://www.pornpics.de/galleries/pretty-arab-babe-mia-khalifa-fucks-a-black-stud-lets-him-cum-on-her-big-tits-26210531/";
		String url = "https://www.pornpics.de/galleries/dark-haired-beauty-sunny-leone-reveals-her-nice-tits-and-trimmed-muff-as-well-11647480/";
		
		
		Document doc = Jsoup.connect(url).get();
		Elements elements = doc.getAllElements();

		for (int i = 0; i < elements.size(); i++) {

			Element element = elements.get(i);
			Elements divChildren = element.children();

			for (Element element2 : divChildren) {
				if (element2.className().contains("wookmark-initialised")) {
					Elements abcf = element2.getAllElements();
					for (Element abcf3 : abcf) {
						if (abcf3.className().contains("thumbwook")) {

							Elements abcf344 = abcf3.getAllElements();
							for (Element abcf3445 : abcf344) {
								if (abcf3445.toString().contains(
										"rel-link")) {

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

//													ddddd

												newsDto.setUserImageScr(
														data_src);

//													loop category

//													newsDto.setUserImageLink(
//															"https://www.pornpics.de"
//																	+ src2);
//													loop category

												newsDto.setMainLink(url);
												newsDto.setWebsiteName(
														"PornPic");
												data2.add(newsDto);
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

//		transferToFile(data2);

	}

//	 static void transferToFile(List<WebData> data2) {
//		 
//		 String filePath = "C:\\Users\\gulfa\\Desktop\\test\\weblink.xlsx";
//
//			try (Workbook workbook = new XSSFWorkbook();
//					FileOutputStream fos = new FileOutputStream(filePath)) {
//
//				Sheet sheet = workbook.createSheet("Employees");
//
//				// Header row
//				Row headerRow = sheet.createRow(0);
//				headerRow.createCell(0).setCellValue("Website Name");
//				headerRow.createCell(1).setCellValue("Main Link");
//				headerRow.createCell(2).setCellValue("U ser Image Link");
//
//				// Data rows
//				Object[][] data = { { 1, "Alice", 50000 }, { 2, "Bob", 60000 }, { 3, "Charlie", 55000 } };
//
//				int rowNum = 1;
//				for (Object[] rowData : data) {
//					Row row = sheet.createRow(rowNum++);
//
//					int colNum = 0;
//					for (Object field : rowData) {
//						Cell cell = row.createCell(colNum++);
//						if (field instanceof Integer) {
//							cell.setCellValue((Integer) field);
//						} else if (field instanceof Double) {
//							cell.setCellValue((Double) field);
//						} else if (field instanceof String) {
//							cell.setCellValue((String) field);
//						}
//					}
//				}
//
//				// Auto-size columns
//				for (int i = 0; i < 3; i++) {
//					sheet.autoSizeColumn(i);
//				}
//
//				workbook.write(fos);
//				System.out.println("Excel file written successfully.");
//
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//	}
}
