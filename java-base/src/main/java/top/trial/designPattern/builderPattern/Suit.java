package top.trial.designPattern.builderPattern;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 套餐类，聚合不同产品
 *
 * @Author gaoyx1469
 * @Date 2020/10/19
 * @Version 1.0
 */
public class Suit {
    List<Meal> meals = new ArrayList<>();

    public void addMeal(Meal meal) {
        meals.add(meal);
    }

    //获取套餐价格
    public BigDecimal getPrice() {
        BigDecimal price = new BigDecimal(0);
        for (Meal meal : meals) {
            price = price.add(meal.getPrice());
        }
        return price;
    }

    //获取套餐内容
    public void showMeals() {
        for (Meal meal : meals) {
            System.out.println(meal.getMealName());
            System.out.println(meal.getPacking().packing());
            System.out.println(meal.getPrice());
        }
        System.out.println("----总计----");
        System.out.println(getPrice());
    }
}
