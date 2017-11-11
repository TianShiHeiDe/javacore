package com.study.java8.core.parameter.names;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ParameterNames {

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = ParameterNames.class.getMethod("main", String[].class);
        for (final Parameter parameter : method.getParameters()) {
            System.out.println("Parameter: "+parameter.getName());
            System.out.println(parameter.isNamePresent());
        }

    }
}
