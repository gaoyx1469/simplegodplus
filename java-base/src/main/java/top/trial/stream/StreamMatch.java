package top.trial.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Stream查找与匹配功能演示
 *
 * @Author gaoyx1469
 * @Date 2020/8/12
 * @Version 1.0
 */
public class StreamMatch {
    static List<String> list = Arrays.asList("哈哈", "呵呵", "嘿嘿", "嘻嘻", "喵喵喵");

    public static void main(String[] args) {
        //testMatch();
        //testFind();
        testCalc();

    }

    private static void testCalc() {
        Long count = list.stream().count();
        System.out.println(count);
        Optional optional = list.stream().max(Comparator.comparingInt(String::length));
        System.out.println(optional.orElse("noop"));
    }

    private static void testFind() {
        Optional optional = list.stream().filter(s -> s.length() > 3).findFirst();
        System.out.println(optional.orElse("noop"));
        Optional optional1 = list.stream().filter(s -> s.length() < 3).findFirst();
        System.out.println(optional1.orElse("noop"));
    }

    private static void testMatch() {
        System.out.println(list.stream().allMatch(s -> s.length() == 2));//全满足
        System.out.println(list.stream().anyMatch(s -> s.length() == 2));//存在满足的
        System.out.println(list.stream().noneMatch(s -> s.length() == 2));//全都不满足
    }

}
