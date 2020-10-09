package top.trial.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Stream映射功能演示
 *
 * @Author gaoyx1469
 * @Date 2020/8/12
 * @Version 1.0
 */
public class StreamMap {
    static List<String> list = Arrays.asList("哈哈", "呵呵", "嘿嘿", "嘻嘻", "喵喵喵");

    public static void main(String[] args) {
        testMap();//映射
    }

    private static void testMap() {//对每个字符串进行从第二位开始截取的操作
        list.stream().map(s -> s.substring(1)).forEach(System.out::println);
    }
}
