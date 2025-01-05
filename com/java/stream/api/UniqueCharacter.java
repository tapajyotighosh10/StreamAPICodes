package com.java.stream.api;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UniqueCharacter {
    public static void main(String[] args) {
        String str= "javaprogramming";
        List<Map.Entry<String, Long>> collect = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() == 1)
                .collect(Collectors.toList());

        System.out.println(collect);
    }
}
