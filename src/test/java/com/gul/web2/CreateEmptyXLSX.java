package com.gul.web2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateEmptyXLSX {

	public static void main(String[] args) throws IOException { 
		
//		// Creating WorkBook
//		        XSSFWorkbook workbook = new XSSFWorkbook();
//
//		        // Creating Spreadsheet by creating an object of
//		        // XSSFSheet and also give name
//		        XSSFSheet spreadsheet
//		            = workbook.createSheet("Sheet1");
//
//		        String Location = "C:\\blankExcel.xlsx";
//		        // Place the output file in location
//		        FileOutputStream outputfile
//		            = new FileOutputStream(Location);
//
//		        // Write to workbook
//		        workbook.write(outputfile);
//
//		        // Close the output file
//		        outputfile.close();
//
//		        // Display message for console window when
//		        // program is successfully executed
//		        System.out.println(
//		            "blankExcel.xlsx is written successfully");
//		
//		
		        
		        CreateEmptyXLSX gfg = new CreateEmptyXLSX();
		        gfg.newFile();
	}
	
	 public void newFile()
	    {
	        String strPath = "C:\\Users\\gulfa\\Desktop\\test\\";
	        String strName ="gul";

	        try {

	            // Creating BufferedReadered object
	            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	            System.out.print("Enter the file name : ");

	            // Reading File name
//	            strName = br.readLine();
	            System.out.print("Enter the file path : ");

	            // Reading File Path
//	            strPath = br.readLine();

	            // Creating File Object
	            File file1 = new File(strPath + "\\" + strName + ".xlsx");

	            // Method createNewFile() method creates blank file.
	            file1.createNewFile();
	        }

	        catch (Exception ex1) {
	            System.out.print("Failed to create a file.");
	        }
	    }
}
