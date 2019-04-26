package httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;



public class demo {
    private ResourceBundle bundle;
    private String url;


    @Test
    public void httpDemo() throws ClientProtocolException, IOException {
        String result;

        CookieStore cs = new BasicCookieStore();

        CloseableHttpClient hc = HttpClients.custom().setDefaultCookieStore(cs).build();
        HttpGet hg = new HttpGet("http://localhost:8890/get/response/cookies");

        CloseableHttpResponse hr= hc.execute(hg);
        result = EntityUtils.toString(hr.getEntity(),"utf-8");
        System.out.println(result);
//        System.out.println(hr.getAllHeaders());
        List<Cookie> cookies = cs.getCookies();
        System.out.println(cookies.size());
        for(Cookie c:cookies) {
            System.out.println("cookie name="+c.getName()+";cookie value="+c.getValue());
        }
        try {
            System.out.println(hr.getStatusLine());
            HttpEntity entity1 = hr.getEntity();
            // do something useful with the response body
            // and ensure it is fully consumed
            EntityUtils.consume(entity1);
        } finally {
            hr.close();
        }




    }/*
	@Test
	public void Demo1() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient=HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://www.baidu.com");
		CloseableHttpResponse response1= httpclient.execute(httpGet);
	}*/


}
