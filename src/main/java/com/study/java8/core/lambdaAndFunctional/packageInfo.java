package com.study.java8.core.lambdaAndFunctional;


public class packageInfo {
    /**
     *
     *  1.在最简单的形式中，一个lambda可以由用逗号分隔的参数列表、–>符号与函数体三部分表示。
     *      (a,e)->a+e;
     *  2.复杂一些的就可以使用｛｝来将方法体包裹住。
     *  int c = 9;
     *  (int a,int e)->{
     *      int b = a-c+e;
     *      return b;
     *  }
     *  3.我们可以在参数列表中指明参数类型，也可不指定，由编译器自行推断。
     *  4.当方法体只有一个表达式时，可以不使用return语句，如上个例子，就会直接返回。
     *  5.当lambda引用成员或全局变量时，会被隐式的转为final变量。
     *  6.要使用lambda表达式，其interface必须被@FunctionalInterface注解所标识。
     *    此接口只能有一个方法，但是java8所添加的新特性默认以及静态方法不受此影响
     *
     */

}
