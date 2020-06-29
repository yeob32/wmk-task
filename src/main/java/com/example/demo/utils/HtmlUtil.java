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
import java.util.regex.Pattern;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HtmlUtil {

    private static final String REMOVE_TAG = "<[^>]*>";
//    private static final Pattern pattern = Pattern.compile("<[^>]*>"); // 패턴 클래스를 이용해 미리 컴파일 해둘 수 있다.

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
        return html.replaceAll(REMOVE_TAG, "").replaceAll(" ", "");
    }
}
