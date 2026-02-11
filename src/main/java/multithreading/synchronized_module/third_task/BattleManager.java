package multithreading.synchronized_module.third_task;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BattleManager {
    private static ExecutorService threadPool = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        Boss boss = new Boss(3);
        List<String> players = List.of("Халк", "Человек Паук", "Тонни", "Стрендж", "Трипи-тропа");

        players.forEach(hero ->
            threadPool.execute(() -> {
                try {
                    Player player = new Player(hero);
                    player.doBattle(boss);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Прерывание");
                }
            })
        );

        threadPool.shutdown();

        try{
            if(!threadPool.awaitTermination(3, TimeUnit.MINUTES)){
                threadPool.shutdownNow();
            }
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("Прерывание");
        }
    }
}
