package com.FAM.newspage.FAM.Util;
import jdk.swing.interop.SwingInterOpUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {
    private static final String USER_AGENT = "Mozilla/5.0";

    public static String sendGetRequest(String url) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            InputStream is = con.getInputStream();
            byte[] buffer = new byte[1024];
            int length;
            StringBuilder response = new StringBuilder();
            while ((length = is.read(buffer)) != -1) {
                response.append(new String(buffer, 0, length));
            }
            is.close();
            return response.toString();
        } else {
            return "";
        }
    }
}
