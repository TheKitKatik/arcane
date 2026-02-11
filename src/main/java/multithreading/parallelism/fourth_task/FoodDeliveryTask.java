package multithreading.parallelism.fourth_task;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable{
    private String character;
    private int foodAmount;

    @Override
    public void run() {
        String food = FoodType.getRandom().getName();
        System.out.println(character + " получает -> " + foodAmount + " " + food);
        try {
            Thread.sleep(3000);
            System.out.println(character + " скушал " + food);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("прерывание :(");
        }
    }
}
