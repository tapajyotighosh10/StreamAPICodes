package com.java.stream.api;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String str= "javaprogramming";
        Map.Entry<String, Long> result = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) // Group by character and count occurrences
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1) // Filter characters with a count of 1
                .findFirst() // Get the first such character
                .orElse(null);// Return null if no such character exists

        System.out.println(result);


        String str1= "javaprogramming";

        String nonRepeatingChars = Arrays.stream(str1.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) // Group by character and count occurrences
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1) // Filter characters with a count of 1
                .map(Map.Entry::getKey) // Extract the key (character)
                .findFirst() // Get the first such character
                .orElse(null);  // Return null if no such character exists

        System.out.println("First non repeating character: "+ nonRepeatingChars);

    }
}

