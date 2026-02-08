package multithreading.parallelism.third_task;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        System.out.println("==="+Thread.currentThread().getName()+" -> начал выполнять задачу===");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("меня прервали");
        }
        System.out.println("==="+Thread.currentThread().getName()+" -> выполнинл задачу "+chore+"===");
    }
}
