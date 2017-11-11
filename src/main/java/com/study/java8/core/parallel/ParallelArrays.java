package com.study.java8.core.parallel;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ParallelArrays {
    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        long[] arrayOfLong = new long[20000];

        Arrays.parallelSetAll(arrayOfLong,
                index -> ThreadLocalRandom.current().nextInt(1000000));

        Arrays.stream(arrayOfLong).limit(10).forEach(
                i -> System.out.println(i + " ")
        );
        System.out.println();

        Arrays.parallelSort(arrayOfLong);
        Arrays.stream(arrayOfLong).limit(10).forEach(
                i -> System.out.println(i + " ")
        );
        long end1 = System.currentTimeMillis();
        System.out.println("duration : " + (end1 - start1));
        System.out.println();

        long start = System.currentTimeMillis();
        long[] array = new long[20000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000000);
        }

        for (int i = 0; i < 9; i++) {
            System.out.println(array[i]);
        }
        System.out.println();

        Arrays.sort(array);

        for (int i = 0; i < 9; i++) {
            System.out.println(array[i]);
        }
        long end = System.currentTimeMillis();

        System.out.println("duration : " + (end - start));
    }
}
