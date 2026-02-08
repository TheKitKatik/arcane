package multithreading.parallelism.spacex_task;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Data
public class LaunchManager {
    private static ExecutorService threadPool = Executors.newSingleThreadExecutor();

    public void planRocketLaunches(List<RocketLaunch> rockets){
        try {
            rockets.forEach( rocket -> {
                try {
                    long delay = rocket.getLaunchTime() - System.currentTimeMillis();
                    Thread.sleep(delay);
                    threadPool.execute(rocket::launch);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();

                }
            });
            threadPool.shutdown();
            if(!threadPool.awaitTermination(5, TimeUnit.MINUTES)){
                threadPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            threadPool.shutdownNow();
            System.out.println("Прервался поток");
        }
    }

    public static void main(String[] args) {
        LaunchManager manager = new LaunchManager();

        List<RocketLaunch> launches = new ArrayList<>();
        launches.add(new RocketLaunch("Falcon 9", LocalDateTime.now().plusSeconds(10).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()));
        launches.add(new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusSeconds(20).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()));
        launches.add(new RocketLaunch("Dragon", LocalDateTime.now().plusSeconds(32).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()));

        manager.planRocketLaunches(launches);
    }
}
