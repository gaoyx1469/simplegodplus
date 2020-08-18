package top.trial.features;

/**
 * 测试JAVA12终switch表达式
 *
 * @Author gaoyx1469
 * @Date 2020/8/18
 * @Version 1.0
 */
public class SwitchTest {
    public static void main(String[] args) {
        Fruit fruit = Fruit.Cherry;
        //switch表达式可以有返回值，且可使用箭头操作符，不穿透
        int num = switch (fruit) {
            case Apple -> 5;
            case Banana, Orange, Cherry -> 6;
            case Strawberry -> 10;
            default -> throw new RuntimeException("no such fruit");
        };
        System.out.println(num);
    }
}

enum Fruit {
    Apple,
    Orange,
    Banana,
    Strawberry,
    Cherry
}
