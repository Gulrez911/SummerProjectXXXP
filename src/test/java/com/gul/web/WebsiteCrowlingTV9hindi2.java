package com.gul.web;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

public class WebsiteCrowlingTV9hindi2 {
	public static void main(String[] args) throws IOException {

		int ii = 0;
		String destinationFile = "E:/GulDoc/test.txt";

		FileWriter fileWriter = new FileWriter(destinationFile);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		String ss = "";
		String ss2 = "";
//		Document doc = Jsoup.connect("https://hindi.news18.com/news/entertainment/bollywood-tabu-sister-farah-naaz-threatened-to-beat-anil-kapoor-madhuri-dixit-on-film-rakhwaala-set-slapped-chunky-pandey-5505901.html").get();
		Document doc = Jsoup.connect(
				"https://www.tv9hindi.com/photo-gallery/entertainment-photos/this-bhojpuri-actress-competes-with-hollywood-actress-played-the-magic-of-beauty-au540-1773365.html")
				.get();

		Elements elements = doc.getAllElements();
		
//		System.out.println(elements.size());
		for (int i = 0; i < elements.size(); i++) {

			Element element = elements.get(i);
//			System.out.println("  ..........   "+element );
//			fileWriter.write(element+System.getProperty( "line.separator" )+System.getProperty( "line.separator" ));
//			if (element.className().equals("tbl-forkorts-article-active")) {

			Elements divChildren = element.children();

			for (Element element2 : divChildren) {

				if (element2.className().contains("detailBody")||element2.className().contains("VideoDetailwrap")||element2.className().contains("PhotoDetailwrap")) {

					Elements divChildren2 = element2.children();

					for (Element ee : divChildren2) {

						if (ee.className().contains("article-HD")) { // Headline
							System.out.println(ee.text());
						}
						if (ee.className().contains("articleImg")||ee.className().contains("ArticleBodywrap")) { // Main Image
							System.out.println(ee.getClass().getName());
							Elements img = ee.getElementsByTag("img");
							String src = img.attr("src");

							System.out.println(src);
						}

						if (ee.className().contains("author-box")) { // date
							ss += ee.text();
							System.out.println(ss);


						}

						if (ee.className().contains("summery") || ee.className().contains("ArticleBodyCont")) { // summary
							ss2 += ee.text();
							System.out.println(ss2);


						}

					}
				}
			}
			}
		}

 

	}

 


