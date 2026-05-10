package creational.builder;

public class MainApp {
    public static void main(String[] args) {
        Meal meal1 = new Meal.Builder(Burger.CHEESE_BURGER)
                .drink(Drink.WATER)
                .build();
        System.out.println(meal1);

        Meal meal2 = new Meal.Builder(Burger.VEG)
                .drink(Drink.WATER)
                .fries(Fries.FRENCH_FRIES)
                .build();
        System.out.println(meal2);
    }

}