package com.study.java8.core.library.optionaldemo;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> fullName = Optional.ofNullable(null);

        //可以得知当前对象是否为空
        System.out.println("Full Name is set? " + fullName.isPresent());
        //如果当前对象为空，这里可以接受一个方法参数，用以处理这个空值
        System.out.println("Full Name: " + fullName.orElseGet(() -> "[none]"));
        //这个orElse接收一个类型参数。
        System.out.println(fullName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));

        Optional<String> firstName = Optional.of("Tom");
        System.out.println("First Name is set ? " + firstName.isPresent());
        System.out.println("First Name : " + firstName.orElseGet(() -> "[none]"));
        System.out.println(firstName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));
    }
}
