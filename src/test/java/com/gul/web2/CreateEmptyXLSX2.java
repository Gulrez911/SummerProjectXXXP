package com.gul.web2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateEmptyXLSX2 {

	public static void main(String[] args) throws IOException {

		String path = "C:/Users/gulfa/Desktop/test/createBlankWorkBook22.xlsx";
		try (// Create Blank workbook
				XSSFWorkbook workbook = new XSSFWorkbook()) {
			// Create file system using specific name
			FileOutputStream out = new FileOutputStream(new File(path));

			// write operation workbook using file out object
			workbook.write(out);

			try (Workbook workbook1 = new XSSFWorkbook();
					FileOutputStream fos = new FileOutputStream(path)) {

				Sheet sheet = workbook1.createSheet("Employees");

				// Header row
				Row headerRow = sheet.createRow(0);
				headerRow.createCell(0).setCellValue("ID");
				headerRow.createCell(1).setCellValue("Name");
				headerRow.createCell(2).setCellValue("Salary");

				// Data rows
				Object[][] data = { { 1, "Alice", 50000 }, { 2, "Bob", 60000 },
						{ 3, "Charlie", 55000 } };

				int rowNum = 1;
				for (Object[] rowData : data) {
					Row row = sheet.createRow(rowNum++);

					int colNum = 0;
					for (Object field : rowData) {
						Cell cell = row.createCell(colNum++);
						if (field instanceof Integer) {
							cell.setCellValue((Integer) field);
						} else if (field instanceof Double) {
							cell.setCellValue((Double) field);
						} else if (field instanceof String) {
							cell.setCellValue((String) field);
						}
					}
				}

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
