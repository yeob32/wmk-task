package com.example.demo.domain.task;

import com.example.demo.domain.enums.Scope;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReqTask {

    private String url;
    private Scope scope;
    private int outputUnit;

    @Builder
    public ReqTask(String url, Scope scope, int outputUnit) {
        this.url = url;
        this.scope = scope;
        this.outputUnit = outputUnit;
    }

}
