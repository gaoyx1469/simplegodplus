package top.trial.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @Author gaoyx1469
 * @Date 2020/8/11
 * @Version 1.0
 */
public class HowToUseLambda {

    public static void main(String[] args) {
        useLambda();
    }

    public static void useLambda() {

        List<String> list = Arrays.asList("sffrsf", "safdfa", "sd", "vav", "ascda");
        List<String> newList = getStringLongerThanThree(list, (s) -> s.length() > 3);
        System.out.println(newList.toString());
        List<String> anotherList = getStringFrontThree(newList, (s) -> s.substring(0, 3));
        System.out.println(anotherList.toString());

    }

    /**
     * 使用内置函数式接口Predicate
     *
     * @param list      List<String>
     * @param predicate Predicate<String>
     * @return List<String>
     */
    private static List<String> getStringLongerThanThree(List<String> list, Predicate<String> predicate) {
        List<String> retList = new ArrayList<>();

        for (String str : list) {
            if (predicate.test(str))
                retList.add(str);
        }
        return retList;
    }

    /**
     * 使用内置函数式接口Function
     *
     * @param list List<String>
     * @param func Function<String, String>
     * @return List<String>
     */
    private static List<String> getStringFrontThree(List<String> list, Function<String, String> func) {
        List<String> retList = new ArrayList<>();

        for (String str : list) {
            retList.add(func.apply(str));
        }
        return retList;
    }

}
