package multithreading.parallelism.first_task;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        System.out.println("--начал обработку батча--");
        while(startIndex <= endIndex){
            System.out.println("Письмо -> " + startIndex + " отправлено");
            startIndex++;
        }
    }
}
