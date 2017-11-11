package com.study.java8.core.lambdaAndFunctional;

@FunctionalInterface
public interface Human {

    void eat();

    //默认方法，默认方法与函数式接口不冲突，
    default String say(String word){
        return word;
    }

    //静态方法
    static int age(int age){
        return age;
    }
}
