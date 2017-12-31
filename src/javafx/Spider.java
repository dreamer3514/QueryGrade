package javafx;

import java.util.ArrayList;

import javafx.application.Application;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Spider {
	//183010
	//2015141462119
	//http://zhjw.scu.edu.cn/gradeLnAllAction.do?type=ln&oper=fainfo&fajhh=290
	//http://zhjw.scu.edu.cn/xkAction.do?actionType=6
	private String log_num;
	private String password;
	
	public static int count=0;
	public Spider(String log_num,String password)
	{
		this.log_num = log_num;
		this.password = password;
	}
	public void set_log_num(String l)
	{
		log_num = l;
	}
	public void set_password(String p)
	{
		password = p;
	}
	
	
    @SuppressWarnings("null")
	public String[][] get_class() 
    {
    	 String[][] info = new String[28][8];int i=0,j=0;
	 try{
		 CloseableHttpClient request = HttpClients.createDefault();		   	    		 
		 HttpPost httpPost = new HttpPost("http://zhjw.scu.edu.cn/loginAction.do");	 
		 ArrayList<NameValuePair>params = new ArrayList<NameValuePair>();		 
		 params.add(new BasicNameValuePair("zjh", log_num));	 
		 params.add(new BasicNameValuePair("mm", password));		 
		 HttpEntity httpEntity = new UrlEncodedFormEntity(params,"gbk");		 
	     httpPost.setEntity(httpEntity);
	     request.execute(httpPost);
	     
	     HttpGet httpGet = new HttpGet("http://zhjw.scu.edu.cn/bxqcjcxAction.do");
		 CloseableHttpResponse response = request.execute(httpGet);
	
		 HttpEntity  entity = response.getEntity();
		 
		 String html = EntityUtils.toString(entity);  			
		 org.jsoup.nodes.Document doc = Jsoup.parse(html);
		 
		
		 Elements a = doc.select("tr[onMouseOut]");
			for(Element each:a)
			{
				Elements s = each.select("td");
			
				for(Element v :s)
				{
					if(j>=7)
					{
						break;
					}
					String string = v.text();
					//System.out.print(string);
					
					info[i][j] =(String) string;
					
					j++;					
				}
				j=0;
				//System.out.print("\n");
				i++;
				count++;
				
			}
						
	 }catch (Exception e) {
         e.printStackTrace();
	 }
	 return info;	 
  } 
    public int getCount()
    {
    	return count;
    }
   
   // public static void main(String[] args)
	//{
	//	Spider spider = new Spider("2015141462046", "080019");
	//	String[][] aStrings = new String[26][6];
	//	aStrings = spider.get_class();
	//	for(int i=0;i<27;i++)
	//	{
	//		for(int j=0;j<7;j++)
	//		{
	//			System.out.print(aStrings[i][j]);
	//			System.out.print("---");
	//			
	//		}
	//		System.out.print("\n");
	//	}
		
	//}
    
}


