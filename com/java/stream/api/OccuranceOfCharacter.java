package com.java.stream.api;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OccuranceOfCharacter {
    public static void main(String[] args) {
        String str= "javaprogramming";

        Map<String, Long> characterCounting = Arrays.stream(str.split(""))
                .collect(
                        Collectors.groupingBy(
                                Function.identity(), // Group by the character itself
                                LinkedHashMap::new,  // Use LinkedHashMap to preserve order
                                Collectors.counting())  // Count occurrences
                );

        System.out.println(characterCounting);
    }
}
