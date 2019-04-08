import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Test04 {
    CloseableHttpClient httpClient = HttpClients.createDefault();


    @Test
    public void test01(){
        long count = 1;
        while (true){
            HttpGet httpGet = new HttpGet("https://randomuser.me/api/");
            try {
                CloseableHttpResponse response = httpClient.execute(httpGet);
                HttpEntity entity = response.getEntity();
                String str = EntityUtils.toString(entity, "UTF-8");
                JSONObject object = JSONObject.parseObject(str);
                int num = str.indexOf("\"first\":\"yue\",\"last\":\"zhongqi\"");
                if (num >0){
                    break;
                }
                count ++;
                System.out.println("第"+count+"次,连接,正在获取");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void test02(){
        List<String> list = new LinkedList<String>();
        for (int i = 0; i < 100; i++) {
            list.add(""+i);
        }
    }
}
