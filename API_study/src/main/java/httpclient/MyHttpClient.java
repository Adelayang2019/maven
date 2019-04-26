package httpclient;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class MyHttpClient {
    private CookieStore store;
    //private CookieStore store;
    //	返回状态行并打印返回信息,GET
    @Test
    public void ReturnStutsLine() throws ClientProtocolException, IOException {
        CloseableHttpClient hc = HttpClients.createDefault();
        HttpGet hg = new HttpGet("http://localhost:8890/get/response/cookies");
        CloseableHttpResponse response = hc.execute(hg);
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(response.getStatusLine());
        System.out.println(result);

    }
    //	获取返回的cookie信息,GET
    @Test
    public void CookiesInfo() {
        CloseableHttpClient hc = HttpClients.createDefault();
        HttpGet hg = new HttpGet("http://www.baidu.com");
        HttpClientContext context = HttpClientContext.create();
        try {
            CloseableHttpResponse response = hc.execute(hg, context);
            this.store = context.getCookieStore();
            List<Cookie> cookie = store.getCookies();
            for(Cookie coo:cookie) {
                String name = coo.getName();
                String value = coo.getValue();
                System.out.println("cookie name="+name+";cookie value="+value);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //	带cookie的get请求
    @Test(dependsOnMethods= {"CookiesInfo"})
    public void GetWithCookies() {
        CloseableHttpClient hc = HttpClients.createDefault();
        HttpGet hg = new HttpGet("http://localhost:8890/get/cookies");
        HttpClientContext context = HttpClientContext.create();
        context.setCookieStore(this.store);
        try {
            CloseableHttpResponse response = hc.execute(hg, context);
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println("statusCode="+statusCode);
            if(statusCode==200) {
                String result = EntityUtils.toString(response.getEntity());
                System.out.println(result);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
