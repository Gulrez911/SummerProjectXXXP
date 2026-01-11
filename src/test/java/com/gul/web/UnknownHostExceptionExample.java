package com.gul.web;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class UnknownHostExceptionExample {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		String host = "https://rollbar.co";
		URL url = null;

		try {
			url = new URL(host);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			System.out.println(con.getResponseCode());
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
