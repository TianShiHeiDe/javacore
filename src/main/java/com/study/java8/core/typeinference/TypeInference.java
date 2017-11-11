package com.study.java8.core.typeinference;

public class TypeInference {

    public static void main(String[] args) {
        final Value<String> value = new Value<>();
        value.getOrDefault("22", Value.defaultValue());
    }

}
