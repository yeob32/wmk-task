package com.example.demo;

import com.example.demo.utils.Extractor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Collectors;

@SpringBootTest
public class ExtractTest {

    @ParameterizedTest
    @ValueSource(strings = "$!aa3a2Ab0YZ4z#@y")
    @DisplayName("정렬 테스트")
    public void print2(String value) {
        String result = Extractor.sortList(value)
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining());
        Assertions.assertEquals(result, "AaaabYyZz0234");
    }

    @ParameterizedTest
    @ValueSource(strings = "$#@!aZaz1a44Ab0")
    @DisplayName("정렬 테스트")
    public void print(String value) {
        String result = Extractor.crossLinking(Extractor.sortList(value));
        Assertions.assertEquals(result, "A0a1a4a4bZz");
    }
}
