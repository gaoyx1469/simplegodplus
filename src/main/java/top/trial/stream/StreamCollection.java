package top.trial.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Stream Collection功能演示，可以筛选、分区、分组等
 *
 * @Author gaoyx1469
 * @Date 2020/8/12
 * @Version 1.0
 */
public class StreamCollection {
    static List<String> list = Arrays.asList("哈哈", "呵呵", "嘿嘿", "嘻嘻", "喵喵喵");

    public static void main(String[] args) {
        testCollection();
    }

    private static void testCollection() {
        System.out.println(list.stream().collect(Collectors.maxBy(Comparator.comparingInt(String::length))));
    }
}
