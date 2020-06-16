package com.example.demo;

import com.example.demo.utils.Extractor;
import com.example.demo.utils.HtmlUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HtmlTest {

    @Test
    @DisplayName("html 문자 추출 및 태그 제거")
    public void loadHtml() {
        String html = HtmlUtil.loadHtml("https://www.google.com");
        String result1 = Extractor.extractIntegerOrAlpha(HtmlUtil.removeTag(html));
        String result2 = Extractor.extractIntegerOrAlpha(html);

        Assertions.assertTrue(result2.length() > result1.length());
    }
}
