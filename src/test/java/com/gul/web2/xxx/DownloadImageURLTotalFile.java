package com.gul.web2.xxx;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.util.ResourceUtils;

import com.gul.web2.ExcelReader;
import com.gul.web2.WebData;

public class DownloadImageURLTotalFile {

	public static void main(String[] args) throws Exception {
		Path demo = Paths.get("C:\\Users\\gulfa\\Desktop\\test\\demo.txt");
		String content = "";
//		        
		String pathFolder = "C:/Users/gulfa/Desktop/test/baseFolderSunny";
		File directory = new File(pathFolder); // Replace with your folder's path

		if (directory.exists() && directory.isDirectory()) {
			File[] files = directory.listFiles();
			if (files != null) {
				int count = 0;
				for (File file : files) {
					if (file.isFile()) {
						System.out.println("file: " + file);
						content+=file.toString()+"\n";
						count++;
						System.out.println(count);
						content+=count+"\n";
//		                         scan
//		                        download file

//						File file = ResourceUtils
//								.getFile("classpath:webExcle.xlsx");
//						File file2 = ResourceUtils.getFile(
//								"classpath:1768586215785.xlsx");

						InputStream stream = FileUtils.openInputStream(file);
						File f = ResourceUtils.getFile("classpath:xxxwebimage.xml");
						System.out.println("processing excel file " + f.getName());
						content+=f.getName()+"\n";
						List<WebData> records = ExcelReader
								.parseExcelFileToBeans(stream, f);
						for (WebData excel : records) {

							long millis = System.currentTimeMillis();
							System.out.println(millis);
							content+=millis+"\n";
							String imageUrl = excel.getUserImageLink();
 							HttpClient client = HttpClient.newHttpClient();

 							HttpRequest request = HttpRequest.newBuilder().uri(URI.create(imageUrl)).build();

							client.send(request, HttpResponse.BodyHandlers
									.ofFile(Path.of("E:/GulDoc/xxximg/"
											+ millis
											+ ".jpg")));
//		    			Thread.sleep(1000);
							System.out.println("Image downloaded!");
							content+="Image downloaded!"+"\n";
						}
						System.out.println("Done");
						content+="Done"+"\n";

//		                        close
					}
				}
				System.out.println("Total files: " + count);
				content+="Total files: "+count+"\n";
			}
		} else {
			System.out.println("Directory not found or is not a directory.");
			content+="Directory not found or is not a directory."+"\n";
		}
		
//		write in demo.text
		Files.write(demo, content.getBytes(StandardCharsets.UTF_8));
		System.out.println("Scrolling completed.");

		System.out.println("done");
		

	}

}
