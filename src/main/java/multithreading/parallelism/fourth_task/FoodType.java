package multithreading.parallelism.fourth_task;

import java.util.Random;

public enum FoodType {
    STEAK("Стейк"),
    PIZZA("Пицца"),
    MILK("Молоко"),
    KFC("Кефас");

    private String name;

    FoodType(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public static FoodType getRandom() {
        Random random = new Random();
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }
}
