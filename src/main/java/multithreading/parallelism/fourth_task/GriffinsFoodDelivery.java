package multithreading.parallelism.fourth_task;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    private static final Random random = new Random();
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        Arrays.stream(characterNames).forEach(character -> {
            threadPool.execute(new FoodDeliveryTask(character, random.nextInt(0, 30)));
        });

        threadPool.shutdown();

        try {
            if(!threadPool.awaitTermination(3, TimeUnit.MINUTES)){
                threadPool.shutdownNow();
            }
        } catch (InterruptedException e){
            System.out.println("прерывание :(");
            threadPool.shutdownNow();
        }
    }
}
