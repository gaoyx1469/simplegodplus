package top.trial.date;

import java.time.*;

/**
 * JAVA8提供了新的时间日期API，此处演示Duration和Period的使用
 *
 * @Author gaoyx1469
 * @Date 2020/8/12
 * @Version 1.0
 */
public class DateTimeCalcDemo {
    public static void main(String[] args) {
        Instant instant1 = Instant.now();
        LocalDateTime localDateTime1 = LocalDateTime.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant instant2 = Instant.now();
        LocalDateTime localDateTime2 = LocalDateTime.now();
        Duration duration1 = Duration.between(instant1, instant2);//计算两个时间之间的差值
        Duration duration2 = Duration.between(localDateTime1, localDateTime2);//计算两个时间之间的差值
        System.out.println(duration1.toMillis());
        System.out.println(duration2.toMillis());

        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(2020, 9, 15);
        Period period = Period.between(localDate1,localDate2);
        System.out.println(period.getDays());
    }
}
