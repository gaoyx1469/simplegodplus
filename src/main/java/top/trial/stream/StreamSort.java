package top.trial.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Stream排序功能演示
 *
 * @Author gaoyx1469
 * @Date 2020/8/12
 * @Version 1.0
 */
public class StreamSort {
    static List<String> list = Arrays.asList("哈哈", "呵呵", "嘿嘿", "嘻嘻", "喵喵喵");

    public static void main(String[] args) {
        testSort();
        System.out.println("============");
        testSortNew();
    }

    private static void testSortNew() {//自定义排序(逆序一下)
        list.stream().sorted((s1, s2) -> -s1.compareTo(s2)).forEach(System.out::println);
    }

    private static void testSort() {//自然排序
        list.stream().sorted().forEach(System.out::println);
    }

}
