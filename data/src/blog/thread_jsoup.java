package blog;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class thread_jsoup extends Thread {
	public void run()
	{
		try 
		{
/////////////////////////////////////////////////////////////////////////////////// ���� ũ�Ѹ��� �ؽ�
			
			hash_title ha = new hash_title();
			String url = "https://news.naver.com/main/read.nhn?mode=LSD&mid=shm&sid1=105&oid=001&aid=0011556091";
			
			Document doc = Jsoup.connect(url).header("Accept", "text/html, application/xhtml+xml,*/*").header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko")
					.header("Accept-Encoding", "gzip,delate").header("Accept-Language", "ko").header("Connection", "Keep-Alive").get();
			
			//System.out.println(doc);
			Elements head = doc.select("h3#articleTitle");
			String str_head = head.text();
			System.out.println(str_head);
			System.out.println(ha.hash_start(str_head));
			
			Elements body = doc.select("div#articleBodyContents");
			String str_body = body.text();
			System.out.println(str_body);
			
			/////////////////////////////////////////////////////////////////////////////////// KBO ��ŷ ũ�Ѹ�
			
			String url2 = "https://www.koreabaseball.com/TeamRank/TeamRank.aspx";
			Document doc2 = Jsoup.connect(url2).get();
			
			Elements rowElements = doc2.select("div#cphContents_cphContents_cphContents_udpRecord > table.tData > tbody > tr");
			
			for(Element row : rowElements)
			{
				Elements tdElements = row.getElementsByTag("td");
				System.out.format("%d %s", Integer.valueOf(tdElements.get(0).text()), tdElements.get(1).text());
				System.out.println();
			}
			
			
			///////////////////////////////////////////////////////////////////////////////// ��α� ũ�Ѹ�
			
			String blog_url = "https://blog.naver.com/with_msip/221846679759";
			Document blog_doc = Jsoup.connect(blog_url).get();
			Element iframeElement = blog_doc.select("body").first().select("iframe[id=mainFrame]").first();
			System.out.println(iframeElement.attr("src"));
			String src = iframeElement.attr("src");
			
			blog_doc = Jsoup.connect("https://blog.naver.com"+src).get();
			
			String blognum[] = src.split("&");
			String num[] = blognum[1].split("=");
			Elements blog_body = blog_doc.select("div#post-view"+num[1]);
			
			System.out.println(blog_body.text());
						
			///////////////////////////////////////////////////////////////////////////////// ������ ��α� ũ�Ѹ�
			
			String naver_url = "https://search.naver.com/search.naver?date_from=&date_option=0&date_to=&dup_remove=1&nso=&post_blogurl=&post_blogurl_without=&query=%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%A7%88%EC%9D%B4%EB%8B%9D&sm=tab_pge&srchby=all&st=sim&where=post&start=";
			int naver_url_page = 1;
			while(naver_url_page < 21)
			{
			
				Document naver_blog_pagetotal = Jsoup.connect(naver_url+naver_url_page).get();
				
				Elements blog_link = naver_blog_pagetotal.select("a.sh_blog_title._sp_each_url._sp_each_title");
				
				for(Element element : blog_link)
				{
					String n = element.attr("href");
					if(n.contains("blog.naver.com"))
					{
						System.out.println(element.attr("href"));
						
						blog_doc = Jsoup.connect(n).get();
						iframeElement = blog_doc.select("body").first().select("iframe[id=mainFrame]").first();
						System.out.println(iframeElement.attr("src"));
						src = iframeElement.attr("src");
						
						blog_doc = Jsoup.connect("https://blog.naver.com"+src).get();
						
						String blognum2[] = src.split("&");
						String num2[] = blognum2[1].split("=");
						blog_body = blog_doc.select("div#post-view"+num2[1]);
						
						System.out.println(blog_body.text());
					}
				}
				naver_url_page = naver_url_page + 10;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
