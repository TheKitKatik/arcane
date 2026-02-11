package multithreading.parallelism.fifth_task;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {
        String[] slaves = {"Шелдон", "Леонард", "Говард", "Раджеш"};

        Arrays.stream(slaves).forEach(slave -> {
            threadPool.execute(new Task(slave, TaskType.getRandomTask().getTask()));
        });

        threadPool.shutdown();
        try {
            if(!threadPool.awaitTermination(3, TimeUnit.MINUTES)){
                threadPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            threadPool.shutdownNow();
            System.out.println("Прерывание :(");
        }
    }
}
