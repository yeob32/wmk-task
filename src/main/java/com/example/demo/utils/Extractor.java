package com.example.demo.utils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Extractor {

    public enum ASCII {
        number(index -> (index >= 48 && index <= 57)),
        upper(index -> (index >= 65 && index <= 90)),
        lower(index -> (index >= 97 && index <= 122));

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

    public static String extractIntegerOrAlpha(String value) {
        return crossLinking(sortList(value));
    }

    public static String crossLinking(List<Character> sortedList) {
        StringBuilder stringBuilder = new StringBuilder();

        Function<Character, Boolean> grouping = ASCII.number::check;
        Map<Boolean, List<Character>> sortedMap = sortedList.stream()
                .collect(Collectors.groupingBy(grouping));

        List<Character> intChars = sortedMap.get(true);
        List<Character> alphaChars = sortedMap.get(false);

        boolean aboveAlpha = alphaChars.size() > intChars.size();
        int maxSize = maxSize(intChars, alphaChars);
        int minSize = minSize(intChars, alphaChars);
        for (int i = 0; i < minSize; i++) {
//            if (minSize < i) {
//                if (aboveAlpha) {
//                    stringBuilder.append(alphaChars.get(i));
//                    continue;
//                }
//
//                stringBuilder.append(intChars.get(i));
//                continue;
//            }

            stringBuilder.append(alphaChars.get(i));
            stringBuilder.append(intChars.get(i));
        }

        List<Character> temps;
        if (aboveAlpha) {
            temps = alphaChars;
        } else {
            temps = intChars;
        }

        for (int i = minSize; i < maxSize; i++) {
            stringBuilder.append(temps.get(i));
        }

        return stringBuilder.toString();
    }

    public static List<Character> sortList(String value) {
        return value.chars()
                .mapToObj(ch -> (char) ch)
                .filter(ASCII::checkAll)
                .sorted(Comparator.comparingInt(Extractor::trans))
                .collect(Collectors.toList());
    }

    public static int trans(Character ch) {
        if (ASCII.lower.check(ch)) {
            return ((ch - 97) * 2) * 2;
        } else if (ASCII.upper.check(ch)) {
            return ((ch - 65) * 2 - 1) * 2;
        } else {
            return ch * 10;
        }
    }

    private static int maxSize(List<Character> intChars, List<Character> alphaChars) {
        return Math.max(intChars.size(), alphaChars.size());
    }

    private static int minSize(List<Character> intChars, List<Character> alphaChars) {
        return Math.min(intChars.size(), alphaChars.size());
    }
}
