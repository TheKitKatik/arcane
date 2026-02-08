package multithreading.parallelism.third_task;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Data
public class WeasleyFamily {
    private static List<Chore> chores = List.of(new Chore("помыть посуду"),
            new Chore("прес качат"),
            new Chore("бегит"),
            new Chore("отжуманя"),
            new Chore("приготовить ужин"),
            new Chore("подмести пол"));

    private static ExecutorService threadPool = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        chores.forEach(chore -> {
            threadPool.execute(chore);
        });
        threadPool.shutdown();

        try{
            if(threadPool.awaitTermination(3, TimeUnit.MINUTES)){
                threadPool.shutdownNow();
            }
        } catch (InterruptedException e){
            threadPool.shutdownNow();
            Thread.currentThread().interrupt();
            System.out.println("Прерывание потока");
        }
    }
}
