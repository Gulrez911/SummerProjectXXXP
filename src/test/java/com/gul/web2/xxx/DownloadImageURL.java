package com.gul.web2.xxx;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.util.ResourceUtils;

import com.gul.web2.ExcelReader;
import com.gul.web2.WebData;

public class DownloadImageURL {

	public static void main(String[] args) throws Exception {

//		        

//		File file = ResourceUtils.getFile("classpath:webExcle.xlsx");
		File file = ResourceUtils.getFile("classpath:1768586215785.xlsx");

		InputStream stream = FileUtils.openInputStream(file);
		File f = ResourceUtils.getFile("classpath:xxxwebimage.xml");
		System.out.println("processing excel file " + f.getName());
		List<WebData> records = ExcelReader.parseExcelFileToBeans(stream, f);
		for (WebData excel : records) {

			// TODO Auto-generated method stub
//			long millis = Instant.now().toEpochMilli();
			long millis = System.currentTimeMillis();
			System.out.println(millis);
			String imageUrl = excel.getUserImageScr();
//			String imageUrl = "https://cdni.pornpics.de/1280/7/827/16936545/16936545_018_1042.jpg";
			HttpClient client = HttpClient.newHttpClient();

			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(imageUrl)).build();

			client.send(request, HttpResponse.BodyHandlers
					.ofFile(Path.of("E:/GulDoc/xxximg/" + millis + ".jpg")));
//			Thread.sleep(1000);
			System.out.println("Image downloaded!");
		}
		System.out.println("Done");
	}

}
