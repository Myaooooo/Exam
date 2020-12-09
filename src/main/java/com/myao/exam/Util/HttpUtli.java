package com.myao.exam.Util;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtli {
    HttpURLConnection connection = null;
    void httpTest() throws IOException {
        URL url = new URL("http://221.226.218.150:8766/api/data/queryData");
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("Token", "bearer 1613c88e-812e-4567-a65a-29d87d2d59d9");
        connection.setRequestProperty("Content-type", "application/json;charset=UTF-8");
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.connect();
    }


    /**
     * 调用第三方接口
     * @param token
     * @param openid
     * @return
     */
    public String getWeChatUserInfo(String token,String openid){
        String urlNameString = "https://api.weixin.qq.com/sns/userinfo?access_token=TOKEN&openid=OPENID";
        urlNameString=urlNameString.replace("TOKEN", token);
        urlNameString=urlNameString.replace("OPENID",openid);
        String result="";
        try {
            // 根据地址获取请求
            HttpGet request = new HttpGet(urlNameString);//这里发送get请求
            // 获取当前客户端对象
            org.apache.http.client.HttpClient httpClient = new DefaultHttpClient();
            // 通过请求对象获取响应对象
            org.apache.http.HttpResponse response = httpClient.execute(request);

            // 判断网络连接状态码是否正常(0--200都数正常)
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                result= EntityUtils.toString(response.getEntity(),"utf-8");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
        //....result是用户信息,站内业务以及具体的json转换这里也不写了...
    }

}
