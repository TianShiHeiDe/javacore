package com.study.java8.core.library.date;

import java.time.*;

public class DateDemo {

    public static void main(String[] args) {
        /*
        Clock使用时区来访问当前的instant, date和time。
        Clock类可以替换 System.currentTimeMillis() 和 TimeZone.getDefault().
         */

        //这里是获取一个标准的UTC时间，并非系统的当前UTC时间。
        final Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());

        /*
            LocalDate只保存有ISO-8601日期系统的日期部分，
            有时区信息，
            相应地，LocalTime只保存ISO-8601日期系统的时间部分，
            没有时区信息。
            LocalDate和LocalTime都可以从Clock对象创建。
         */

        //get the local date
        final LocalDate date = LocalDate.now();
        final LocalDate dateFromClock = LocalDate.now(clock);

        System.out.println(date);
        System.out.println(dateFromClock);

        //get the local time
        final LocalTime time = LocalTime.now();
        final LocalTime timeFromClock = LocalTime.now(clock);

        System.out.println(time);
        System.out.println(timeFromClock); //因为clock实例获取的是标准的UTC时间，所以这里是标准UTC时间

        //get the zoned data/time
        final ZonedDateTime zonedDateTime = ZonedDateTime.now();
        final ZonedDateTime zonedDateTimeFromClock = ZonedDateTime.now(clock);
        final ZonedDateTime zonedDateTimeFromZone = ZonedDateTime.now(ZoneId.of("Asia/Chongqing"));

        System.out.println(zonedDateTime);
        System.out.println(zonedDateTimeFromClock);
        System.out.println(zonedDateTimeFromZone);

        //get duration between two dates
        final LocalDateTime from = LocalDateTime.of(2017, Month.MAY, 11, 0, 0, 0);
        final LocalDateTime to = LocalDateTime.of(2018, Month.MAY, 11, 23, 59, 59);

        final Duration duration = Duration.between(from, to);
        System.out.println("Duration in days: " + duration.toDays());
        System.out.println("Duration in hours: " + duration.toHours());
    }
}
