package com.study.java8.core.methodrefer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class A {
    public static class Car{
        public static Car create(final Supplier<Car> supplier) {
            return supplier.get();
        }

        public static void collide(final Car car) {
            System.out.println("Collided" + car.toString());
        }

        public void follow(final Car another) {
            System.out.println("Following the" + another.toString());
        }

        public void repair() {
            System.out.println("Repaired " + this.toString());
        }
    }

    public static void main(String[] args) {
        //泛型是Class<T>::new，构造方法是无参的
        final Car car = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car);

        //静态方法引用
        cars.forEach(Car::collide);

        //实例方法引用
        cars.forEach(Car::repair);

        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);

    }
}
