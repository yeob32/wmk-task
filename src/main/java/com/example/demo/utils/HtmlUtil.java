package com.example.demo.utils;

import com.example.demo.domain.enums.Scope;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HtmlUtil {

    public static String loadHtml(String requestUrl) {
        StringBuilder result = new StringBuilder();

        BufferedReader bufferedReader = null;
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            bufferedReader = new BufferedReader(
                    new InputStreamReader(httpURLConnection.getInputStream(), StandardCharsets.UTF_8));

            String inputLine;
            while ((inputLine = bufferedReader.readLine()) != null) {
                result.append(inputLine);
            }

            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result.toString();
    }

    public static String getHtml(String requestUrl, Scope scope) {
        if (scope.equals(Scope.ALL)) {
            return loadHtml(requestUrl);
        }

        return removeTag(loadHtml(requestUrl));
    }

    public static String removeTag(String html) {
        return html.replaceAll("<[^>]*>", "").replaceAll(" ", "");
    }
}
