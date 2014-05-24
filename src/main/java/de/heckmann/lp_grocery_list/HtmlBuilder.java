package de.heckmann.lp_grocery_list;

import java.io.UnsupportedEncodingException;

public class HtmlBuilder {

	public static String createHtml(String content) throws UnsupportedEncodingException {
		String html = "<!DOCTYPE html><html><head><meta charset=\"utf-8\"><title>Little Printer Einkaufliste</title>	<style type=\"text/css\">	body { width: 384px; margin: 0px; padding: 20px 0px; } h1 { word-wrap: break-word; font-family: Arial, sans-serif; } </style> </head> <body>";
		html += content;
		html += "</body></html>";
		
		return html;
	}
}
