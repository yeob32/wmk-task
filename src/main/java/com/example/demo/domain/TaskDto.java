package com.example.demo.domain;

import com.example.demo.domain.enums.Scope;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class TaskDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Request {
        private String url;
        private Scope scope;
        private int outputUnit;

        @Builder
        public Request(String url, Scope scope, int outputUnit) {
            this.url = url;
            this.scope = scope;
            this.outputUnit = outputUnit;
        }

        public Task toEntity() {
            return Task.builder()
                    .url(url)
                    .scope(scope)
                    .outputUnit(outputUnit)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response {
        private String value;
        private String rest;

        public Response(Task task) {
            this.value = task.getValue();
            this.rest = task.getRest();
        }
    }
}
