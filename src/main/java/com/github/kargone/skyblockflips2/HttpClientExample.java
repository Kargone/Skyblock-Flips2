package com.github.kargone.skyblockflips2;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientExample {

    public String sendPOST(String url, String postMessage) throws IOException {

        String result = "";
        HttpPost post = new HttpPost(url);

        // send a JSON data
        post.setEntity(new StringEntity(postMessage));
        System.out.println(post);

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            result = EntityUtils.toString(response.getEntity());
        }

        return result;
    }

}
