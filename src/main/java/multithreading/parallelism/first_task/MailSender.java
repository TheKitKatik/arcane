package multithreading.parallelism.first_task;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static int countOfMessages = 1000;
    private static int countOfThread = 5;

    public static void main(String[] args) {
        int batchSize = countOfMessages / countOfThread;
        int startIndex = 0;
        List<Thread> threads = new ArrayList<>();

        System.out.println("==ЗАПУСКАЮ ОТПРАВКУ СООБЩЕНИЙ==");

        for(int i = 0; i < countOfThread; i++){
            Thread thread = new Thread(new SenderRunnable(startIndex + 1, startIndex + batchSize));
            threads.add(thread);
            startIndex += batchSize;
            thread.start();
        }

        threads.forEach(thread -> {
            try{
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Главный поток прерван");
            }
        });

        System.out.println("==ВСЕ СООБЩЕНИЯ ОТПРАВЛЕНЫ==");
    }
}
