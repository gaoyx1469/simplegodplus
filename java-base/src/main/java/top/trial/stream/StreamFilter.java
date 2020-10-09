package top.trial.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Stream筛选和切片功能演示
 *
 * @Author gaoyx1469
 * @Date 2020/8/12
 * @Version 1.0
 */
public class StreamFilter {
    static List<String> list = Arrays.asList("哈哈", "呵呵", "嘿嘿", "嘻嘻", "喵喵喵");

    public static void main(String[] args) {
        //testFilter();//筛选过滤，对于断言接口返回true的保留
        //testLimit();//返回不超过十个元素
        //testSkip();
        testDistinct();//去重，根据元素自身的hashcode和equals判断是否是重复元素
    }

    private static void testDistinct() {
        list.stream().distinct().forEach(System.out::println);
    }

    private static void testSkip() {
        list.stream().skip(2).forEach(System.out::println);
    }

    private static void testLimit() {
        list.stream().limit(10).forEach(System.out::println);
    }

    private static void testFilter() {
        list.stream().filter((s) -> s.length() == 2).forEach(System.out::println);
    }
}
