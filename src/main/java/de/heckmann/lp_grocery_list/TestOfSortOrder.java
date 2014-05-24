package de.heckmann.lp_grocery_list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class TestOfSortOrder {

	public enum categories {
		ObstGemuese, Tee, Brot, TKWare, FleischKaese, Konserven, Milchprodukte, Suessigkeiten, Getraenke
	}

	public static StringBuilder content = new StringBuilder();

	public static void main(String[] args) {
		LinkedList<Enum> sortOrderList = new LinkedList<Enum>();

		sortOrderList.add(categories.ObstGemuese);
		sortOrderList.add(categories.Tee);
		sortOrderList.add(categories.Brot);
		sortOrderList.add(categories.TKWare);
		sortOrderList.add(categories.FleischKaese);
		sortOrderList.add(categories.Konserven);
		sortOrderList.add(categories.Milchprodukte);
		sortOrderList.add(categories.Suessigkeiten);
		sortOrderList.add(categories.Getraenke);

		// for (String s : sortOrderList) {
		// if (sortOrderList.size() > sortOrderList.indexOf(s) + 1) {
		// System.out.println(s + " => "
		// + sortOrderList.get(sortOrderList.indexOf(s) + 1));
		// }
		// }
		//
		// System.out.println("##############################################");
		// sortOrderList.add(sortOrderList.indexOf("C") + 1, "D");
		//
		// for (String s : sortOrderList) {
		// if (sortOrderList.size() > sortOrderList.indexOf(s) + 1) {
		// System.out.println(s + " => "
		// + sortOrderList.get(sortOrderList.indexOf(s) + 1));
		// }
		// }

		Map<String, Enum> groceryMap = new TreeMap<String, Enum>();

		groceryMap.put("Milch", categories.Milchprodukte);
		groceryMap.put("Joghurt", categories.Milchprodukte);
		groceryMap.put("Hackfleisch", categories.FleischKaese);
		groceryMap.put("Äpfel", categories.ObstGemuese);
		groceryMap.put("Gummibärchen", categories.Suessigkeiten);
		groceryMap.put("Cola", categories.Getraenke);
		groceryMap.put("Chips", categories.Suessigkeiten);
		groceryMap.put("Pizza", categories.TKWare);
		groceryMap.put("Mini-Berliner", categories.TKWare);
		groceryMap.put("schwarzer Tee", categories.Tee);

		content.append("<h1>Auf der unsortierten Einkaufsliste stehen:</h1>\n<ul>");

		Multimap<Enum, String> groceryMultimap = HashMultimap.create();

		for (Entry<String, Enum> entry : groceryMap.entrySet()) {
			groceryMultimap.put(entry.getValue(), entry.getKey());
			content.append("<li>").append(entry.getKey()).append(" (")
					.append(entry.getValue().toString()).append(") </li>");
		}

		content.append("</ul>").append(
				"\n<h1>Auf der sortierten Einkaufsliste stehen:</h1>\n<ul>");

		for (Enum e : sortOrderList) {
			if (groceryMultimap.containsKey(e)) {
				for (String s : groceryMultimap.get(e))
					content.append("<li>").append(
							s + " (" + e.toString() + ") </li>");
			}
		}
		content.append("</ul>");

		String htmlFile;
		try {
			htmlFile = HtmlBuilder.createHtml(content.toString());

		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost post = new HttpPost(
				"http://remote.bergcloud.com/playground/direct_print/TEL9WMAM9Z9P");
			System.out.println(htmlFile);
			List<NameValuePair> nvp = new ArrayList<NameValuePair>();
			nvp.add(new BasicNameValuePair("html", htmlFile));
			post.setEntity(new UrlEncodedFormEntity(nvp, "UTF-8"));
//			HttpResponse response = httpclient.execute(post);
//
//			BufferedReader rd = new BufferedReader(new InputStreamReader(
//					response.getEntity().getContent()));
//			String line = "";
//			while ((line = rd.readLine()) != null) {
//				System.out.println(line);
//			}

		} catch (UnsupportedEncodingException e2) {
			e2.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
