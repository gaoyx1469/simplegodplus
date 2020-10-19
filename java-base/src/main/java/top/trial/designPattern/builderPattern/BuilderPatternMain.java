package top.trial.designPattern.builderPattern;

/**
 * 建造者模式主测试类
 *
 * @Author gaoyx1469
 * @Date 2020/10/19
 * @Version 1.0
 */
public class BuilderPatternMain {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        mealBuilder.prepareSuit1().showMeals();
        System.out.println("=================");
        mealBuilder.prepareSuit2().showMeals();
    }
}
