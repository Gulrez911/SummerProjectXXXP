package com.gul.web;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebsiteCrowlingPic2 {
	public static void main(String[] args) throws IOException {

		
//		String url = "https://www.pornpics.de/teens/";
		String url = "https://www.pornpics.de/indian/";

		        Document doc = Jsoup.connect(url)
		                .userAgent("Mozilla/5.0")
		                .get();

		        System.out.println(doc.title());
		
		
//		Document doc = Jsoup.connect("https://www.pornpics.com/pornstars/coco-lovelock/").get();
//		Document doc = Jsoup.connect("https://www.pornpics.com/galleries/cute-babe-coco-lovelock-teases-with-her-body-and-takes-a-boner-from-behind-65729911/").get();
//		Elements elements = doc.getAllElements();

//		for (int i = 0; i < elements.size(); i++) {
//
//			Element element = elements.get(i);
//			Elements divChildren = element.children();
//
//			for (Element element2 : divChildren) {
//				if (element2.className().contains("wookmark-initialised")) {
//					Elements abcf = element2.getAllElements();
//					for (Element abcf3 : abcf) {
//						if (abcf3.className().contains("thumbwook")) {
//
//							Elements abcf344 = abcf3.getAllElements();
//							for (Element abcf3445 : abcf344) {
//								if (abcf3445.toString().contains(
//										"rel-link")) {
//
//									String src2 = abcf3445.attr(
//											"href");
//									System.out.println(src2);
//								}
//							}
//
//						}
//					}
//				}
//
//			}
//		}
	}

}
