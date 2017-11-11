package com.study.java8.core.library.stream;

public class PackageInfo {
    /**
     * 新增加的Stream API (java.util.stream)引入了在Java里可以工作的函数式编程。
     * 这是目前为止对java库最大的一次功能添加，
     * 希望程序员通过编写有效、整洁和简明的代码，
     * 能够大大提高生产率。
     * Stream操作被分为中间操作和终点操作。
     *
     * 中间操作返回一个新的Stream。
     * 这些中间操作是延迟的，
     * 执行一个中间操作比如filter实际上不会真的做过滤操作，
     * 而是创建一个新的Stream，
     * 当这个新的Stream被遍历的时候，
     * 它里头会包含有原来Stream里符合过滤条件的元素。
     *
     * 终点操作比如说forEach或者sum会遍历Stream从而产生最终结果或附带结果。
     * 终点操作执行完之后，Stream管道就被消费完了，不再可用。
     * 在几乎所有的情况下，终点操作都是即时完成对数据的遍历操作。
     *
     *
     *
     */
}
