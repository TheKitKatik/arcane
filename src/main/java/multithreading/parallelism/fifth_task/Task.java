package multithreading.parallelism.fifth_task;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task implements Runnable{
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + " начал выполнять задачу -> " + task);
        try {
            Thread.sleep(2000);
            System.out.println(name + " героически справился со своей задачей");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("прерывание :(");
        }
    }
}
