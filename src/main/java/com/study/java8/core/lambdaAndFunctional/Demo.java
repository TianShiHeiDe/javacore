package com.study.java8.core.lambdaAndFunctional;

public class Demo {

    private Human human;

    public Demo(Human human) {
        this.human = human;
    }

    public void say(){
        System.out.println(human.say("Hello word"));
    }
    public void eat(){
        human.eat();
    }

    public static void main(String[] args) {

        System.out.println("I am "+Human.age(3)+" years old.");
        Demo demo = new Demo(() -> System.out.println("I am eating chicken."));
        demo.say();
        demo.eat();
    }
}
