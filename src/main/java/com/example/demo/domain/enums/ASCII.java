package com.example.demo.domain.enums;

import java.util.Arrays;
import java.util.List;

public enum ASCII {
    NUMBER(index -> (index >= 48 && index <= 57)),
    UPPER(index -> (index >= 65 && index <= 90)),
    LOWER(index -> (index >= 97 && index <= 122));

    Formal formal;

    ASCII(Formal formal) {
        this.formal = formal;
    }

    public boolean check(Character index) {
        return this.formal.check(index);
    }

    public static boolean checkAll(Character index) {
        return asciis.stream().anyMatch(ascii -> ascii.check(index));
    }

    interface Formal {
        boolean check(Character index);
    }

    private static final List<ASCII> asciis = Arrays.asList(ASCII.values());
}
