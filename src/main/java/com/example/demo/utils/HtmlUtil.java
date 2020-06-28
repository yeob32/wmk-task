package com.example.demo.utils;

import com.example.demo.domain.enums.Scope;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HtmlUtil {

    public static String loadHtml(String requestUrl) {
        StringBuilder result = new StringBuilder();

        try {
            URL url = new URL(requestUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            try (InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream(), StandardCharsets.UTF_8);
                 BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            ) {
                String inputLine;
                while ((inputLine = bufferedReader.readLine()) != null) {
                    result.append(inputLine);
                }
            }
        } catch (Exception e) {
            log.error("loadHtml Error", e);
            e.printStackTrace();
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
