package com.java.stream.api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MovesZerosAtLast {

    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(7,0,5,0,1,8,0,0,9);

        List<Integer> result= Stream.concat(list.stream().filter(n->n!=0), list.stream().filter(n->n==0))
                .collect(Collectors.toList());

        System.out.println(result);
    }


}
