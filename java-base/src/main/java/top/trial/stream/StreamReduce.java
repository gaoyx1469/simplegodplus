package top.trial.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Stream归约功能演示
 *
 * @Author gaoyx1469
 * @Date 2020/8/12
 * @Version 1.0
 */
public class StreamReduce {
    static List<String> list = Arrays.asList("哈哈", "呵呵", "嘿嘿", "嘻嘻", "喵喵喵");

    public static void main(String[] args) {
        testReduce();
    }

    private static void testReduce() {
        System.out.println(list.stream().reduce((s1, s2) -> s1 + s2));
        System.out.println(list.stream().reduce("1", (s1, s2) -> s1 + s2));
    }
}
