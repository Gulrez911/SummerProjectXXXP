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

public class DownloadImageURLTest {

	public static void main(String[] args) throws Exception {

//		        

 

			// TODO Auto-generated method stub
//			long millis = Instant.now().toEpochMilli();
			long millis = System.currentTimeMillis();
			System.out.println(millis);
//			String imageUrl = excel.getUserImageScr();
			String imageUrl = "https://cdni.pornpics.com/1280/5/160/16363322/16363322_001_f739.jpg";
			HttpClient client = HttpClient.newHttpClient();

//			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(imageUrl)).build();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(imageUrl)).build();

			client.send(request, HttpResponse.BodyHandlers
					.ofFile(Path.of("E:/GulDoc/xxximg/"+ millis + ".jpg")));
//			Thread.sleep(1000);
			System.out.println("Image downloaded!");
		
		System.out.println("Done");
	}

}
