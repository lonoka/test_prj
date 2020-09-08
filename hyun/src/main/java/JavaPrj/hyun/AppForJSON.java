package JavaPrj.hyun;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import JavaPrj.hyun.util.UrlUtil;

public class AppForJSON {
	public static void main(String[] args) throws Exception {
		UrlUtil uu = new UrlUtil();

		String url = "http://127.0.0.1:8000";
		String api = "/myTextAPIForJSON";
		String pName = "?pText=";
		String pText = "이협건은 한국폴리텍대학 서울강서캠퍼스 교수이다.";

		String res = uu.urlReadforString(url + api + pName + URLEncoder.encode(pText, "UTF-8"));

		System.out.println("res : " + res);

		uu = null;

		JSONParser parser = new JSONParser();

		JSONObject json = (JSONObject) parser.parse(res);

		List<String> rList = (List<String>) json.get("word");

		if (rList == null) {
			rList = new ArrayList<String>();
		}

		Iterator<String> it = rList.iterator();

		while (it.hasNext()) {
			String word = (String) it.next();
			System.out.println("word : " + word);
		}
	}
}
