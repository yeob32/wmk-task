package com.example.demo.domain.enums;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public enum ASCII {

    NUMBER(index -> (index >= 48 && index <= 57)),
    UPPER(index -> (index >= 65 && index <= 90)),
    LOWER(index -> (index >= 97 && index <= 122));

    private final Formal formal;

    public boolean check(Character index) {
        return this.formal.check(index);
    }

    public static boolean checkAll(Character index) {
        return asciis.stream().anyMatch(ascii -> ascii.check(index));
    }

    @FunctionalInterface
    interface Formal {
        boolean check(Character index);
    }

    private static final List<ASCII> asciis = Arrays.asList(ASCII.values());
}
