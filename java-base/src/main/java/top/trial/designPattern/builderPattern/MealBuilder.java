package top.trial.designPattern.builderPattern;

/**
 * @Author gaoyx1469
 * @Date 2020/10/19
 * @Version 1.0
 */
public class MealBuilder {
    public Suit prepareSuit1() {
        Suit suit = new Suit();
        suit.addMeal(new BeefHamburg());
        suit.addMeal(new CocaCola());
        return suit;
    }

    public Suit prepareSuit2() {
        Suit suit = new Suit();
        suit.addMeal(new VegHamburg());
        suit.addMeal(new PepsiCola());
        return suit;
    }
}
