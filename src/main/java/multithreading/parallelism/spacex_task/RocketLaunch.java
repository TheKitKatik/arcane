package multithreading.parallelism.spacex_task;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RocketLaunch {
    private String name;
    private long launchTime;

    public void launch() {
        try {
            System.out.println("РАКЕТА -> " + name + " начала запуск");
            Thread.sleep(1000);
            System.out.println("РАКЕТА -> " + name + " успешно улетела - УРА");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Поток был прерван бла бла бла");
        }
    }
}
