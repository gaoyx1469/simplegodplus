package top.trial.date;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * JAVA8提供了新的时间日期API，此处演示Instant时间戳的使用
 *
 * @Author gaoyx1469
 * @Date 2020/8/12
 * @Version 1.0
 */
public class InstantDemo {
    public static void main(String[] args) {
        Instant inst = Instant.now();//以UTC时区为准
        System.out.println(inst);//后面以Z结尾
        System.out.println(inst.toEpochMilli());//时间戳
        OffsetDateTime odt = inst.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt);//后面以偏移量结尾


    }
}
