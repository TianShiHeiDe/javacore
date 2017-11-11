package com.study.java8.core.javascript;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;

public class Demo {

    public static final String PREFIX = "file:/";

    public static void main(String[] args) throws ScriptException, FileNotFoundException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        System.out.println(engine.getClass().getName());
        System.out.println("Result: " + engine.eval("function f() {return 1;} f()+1;"));

        URL resource = Demo.class.getClassLoader().getResource("exec.js");

        String pathName = resource.getPath();
        FileReader reader = new FileReader(pathName);
        Object eval = engine.eval(reader);
        System.out.println("Result2: " + eval);
    }

}
