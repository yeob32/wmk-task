package com.example.demo.utils;

import com.example.demo.domain.enums.ASCII;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Extractor {

    public static String extractIntegerOrAlpha(String value) {
        return crossLinking(sortList(value));
    }

    public static String crossLinking(List<Character> sortedList) {
        StringBuilder stringBuilder = new StringBuilder();

        Function<Character, Boolean> grouping = ASCII.NUMBER::check;
        Map<Boolean, List<Character>> sortedMap = sortedList.stream()
                .collect(Collectors.groupingBy(grouping));

        List<Character> intChars = sortedMap.get(true);
        List<Character> alphaChars = sortedMap.get(false);

        boolean aboveAlpha = alphaChars.size() > intChars.size();
        int maxSize = maxSize(intChars, alphaChars);
        int minSize = minSize(intChars, alphaChars);
        for (int i = 0; i < minSize; i++) {
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
        if (ASCII.LOWER.check(ch)) {
            return ((ch - 97) * 2) * 2;
        } else if (ASCII.UPPER.check(ch)) {
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
