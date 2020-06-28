package com.example.demo.domain.task;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResTask {

    private String value;
    private String rest;

    @Builder
    public ResTask(String value, String rest) {
        this.value = value;
        this.rest = rest;
    }

}
