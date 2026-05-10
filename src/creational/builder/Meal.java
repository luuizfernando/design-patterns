package creational.builder;

import java.util.Objects;

public class Meal {

    // required
    private Burger burger;

    // optional
    private Drink drink;
    private Fries fries;

    private Meal(Builder builder) {
        this.burger = builder.burger;
        this.drink = builder.drink;
        this.fries = builder.fries;
    }

    public static class Builder {
        // required
        private Burger burger;

        // optional
        private Drink drink;
        private Fries fries;

        public Builder (Burger burger) {
            this.burger = Objects.requireNonNull(burger, "Burger must not be null");
        }

        public Builder drink(Drink drink) {
            this.drink = drink;
            return this;
        }

        public Builder fries(Fries fries) {
            this.fries = fries;
            return this;
        }

        public Meal build() {
            return new Meal(this);
        }
    }

    @Override
    public String toString() {
        return "Builder {" +
                "burger = " + burger +
                ", drink = " + displayValue(drink) +
                ", fries = " + displayValue(fries) +
                '}';
    }

    private String displayValue(Object value) {
        return Objects.toString(value, "None");
    }

    public Burger getBurger() {
        return burger;
    }

    public Drink getDrink() {
        return drink;
    }

    public Fries getFries() {
        return fries;
    }

}