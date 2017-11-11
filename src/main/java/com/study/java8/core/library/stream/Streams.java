package com.study.java8.core.library.stream;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    private enum Status {
        OPEN, CLOSED
    }

    private static final class Task {

        private final Status status;
        private final Integer points;

        Task(final Status status, final Integer points) {
            this.status = status;
            this.points = points;
        }

        public Status getStatus() {
            return status;
        }

        public Integer getPoints() {
            return points;
        }

        @Override
        public String toString() {
            return String.format("[%s, %d]", status, points);

        }
    }

    public static void main(String[] args) {
        final Collection<Task> tasks = Arrays.asList(
                new Task(Status.OPEN, 5),
                new Task(Status.OPEN, 13),
                new Task(Status.CLOSED, 8)
        );

        final long totalPointsOfOpenTasks = tasks
                .stream()
                .filter(task -> task.getStatus() == Status.OPEN)
                .mapToInt(Task::getPoints)
                .sum();
        System.out.println("Total points: " + totalPointsOfOpenTasks);
        /*
            上面代码执行的流程是这样的，
            首先Task集合会被转化为Stream表示，
            然后filter操作会过滤掉所有关闭的Task，
            接下来使用Task::getPoints 方法取得每个Task实例的点数，
            mapToInt方法会把Task Stream转换成Integer Stream，
            最后使用Sum方法将所有的点数加起来得到最终的结果。
         */


        // Calculate total points of all tasks
        final double totalPoints = tasks
                .stream()
                .parallel()
                .map(task -> task.getPoints()) //or map( Task::getPoints)
                .reduce(0, Integer::sum);
        System.out.println("Total points (all tasks): " + totalPoints);


        //Group tasks by their status
        final Map<Status, List<Task>> map = tasks
                .stream()
                .collect(Collectors.groupingBy(Task::getStatus));
        System.out.println(map);

        //Calculate the weight of each tasks (as percent of total points)
        final Collection<String> result = tasks
                .stream()                                       //Stream<String>
                .mapToInt(Task::getPoints)                      //IntStream
                .asLongStream()                                 //LongStream
                .mapToDouble(points -> points / totalPoints)    //DoubleStream
                .boxed()                                        //Stream<Double>
                .mapToLong(weight -> (long) (weight * 100))     //LongStream
                .mapToObj(percentage -> percentage + "%")       //Stream<String>
                .collect(Collectors.toList());                  //List<String>
        System.out.println(result);

        URL resource = Streams.class.getClassLoader().getResource("stream.txt");
        String pathName = resource.toString();
        String prefix = "file:/";
        if (pathName.startsWith(prefix)) {
            pathName = pathName.substring(prefix.length());
        }
        final Path path = new File(pathName).toPath();
        try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
            lines.onClose(() -> System.out.println("Done!")).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        Stream的方法onClose 返回一个等价的有额外句柄的Stream，
        当Stream的close（）方法被调用的时候这个句柄会被执行。
         */
    }

}
