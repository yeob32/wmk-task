package com.example.demo;

import com.example.demo.application.TaskService;
import com.example.demo.domain.Task;
import com.example.demo.domain.TaskDto;
import com.example.demo.utils.Extractor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ExtractTest {

    TaskDto.Request task;

    @BeforeEach
    public void setUp() {
        task = TaskDto.Request.builder()
                .url("https://www.naver.com")
                .outputUnit(100)
                .build();
    }

    @Test
    @DisplayName("정렬 테스트")
    public void print() {
        String result = Extractor.crossLinking(Extractor.getSortedMap("$#@!aaaAb0"));
        Assertions.assertEquals(result, "A0aaab");
    }
}
