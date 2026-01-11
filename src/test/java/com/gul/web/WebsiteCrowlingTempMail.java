package com.gul.web;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebsiteCrowlingTempMail {
	public static void main(String[] args) throws IOException {

		Document doc = Jsoup.connect("https://temp-mail.org/en/change").userAgent("Mozilla")
                .header("Accept", "text/html")
                .header("Accept-Encoding", "gzip,deflate")
                .header("Accept-Language", "it-IT,en;q=0.8,en-US;q=0.6,de;q=0.4,it;q=0.2,es;q=0.2")
                .header("Connection", "keep-alive")
                .ignoreContentType(true)
                .get();

		Elements elements = doc.getAllElements();

//		System.out.println(elements.size());
		for (int i = 0; i < elements.size(); i++) {
			Element element = elements.get(i);
			
			if (element.className().equals("temp-emailbox")) {
				System.out.println(i);
			}
		
 		}
	}

}
