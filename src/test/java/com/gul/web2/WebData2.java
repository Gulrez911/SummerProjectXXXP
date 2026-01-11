package com.gul.web2;

import java.io.FileOutputStream;
import java.io.IOException;
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

public class WebData2 {

	public static void main(String[] args) throws IOException {

		List<WebData> data2 = new ArrayList<>();
//		Document doc = Jsoup.connect("https://www.pornpics.de/pornstars/sunny-leone/").get();
		Document doc = Jsoup.connect("https://www.pornpics.com/pornstars/").get();
		
//		Document doc = Jsoup.connect("https://www.pornpics.de/galleries/milf-in-glasses-sunny-leone-reveals-her-fakes-and-poses-naked-in-the-kitchen-71552417/").get();
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
							WebData newsDto = new WebData();
							for (Element abcf3445 : abcf344) {
								if (abcf3445.toString().contains(
										"rel-link")) {

									String src2 = abcf3445.attr(
											"href");
									System.out.println(src2);
									data2.add(newsDto);
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
