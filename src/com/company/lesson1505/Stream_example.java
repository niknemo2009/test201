package com.company.lesson1505;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Stream_example {
    public static void main(String[] args) {
        String[] arr={"asasa","asasas","asasasas"};
        Stream<String> str= Arrays.stream(arr);
        List<String> list=new ArrayList<>();
        list.add("sdsds");
        list.add("sdsds");
        list.add("sdsds");
        list.add("sdsds");
        list.add("sdsds");
        list.stream();
        Stream.Builder<String> bd=Stream.builder();
        Stream<String> str33=bd.add("sdsdsd")
                .add("ddfd")
                .add("ddfd")
                .add("ddfd")
                .add("ddfd")
                .add("ddfd")
                .add("ddfd")
                .build();
        Random rand=new Random();
        Stream.generate(()-> rand.nextInt(200)).limit(10).forEach(System.out::println);
    }
}
