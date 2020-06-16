package com.example.demo.domain;

import com.example.demo.domain.enums.Scope;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Task {

    private String url;
    private Scope scope;
    private int outputUnit;

    private String value;
    private String rest;

    @Builder
    public Task(String url, Scope scope, int outputUnit, String value, String rest) {
        this.url = url;
        this.scope = scope;
        this.outputUnit = outputUnit;
        this.value = value;
        this.rest = rest;
    }

}
