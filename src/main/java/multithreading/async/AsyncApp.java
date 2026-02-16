package multithreading.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class AsyncApp {
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MasterCardService service = new MasterCardService();


        Future<String> paymentResult = threadPool.submit(service::collectPayment);
        CompletableFuture<String> analyticsResult = CompletableFuture.supplyAsync(service::sendAnalytics);

        System.out.println(analyticsResult.join());
        System.out.println(paymentResult.get());

        threadPool.shutdown();

        try{
            if(threadPool.awaitTermination(2, TimeUnit.MINUTES)){
                threadPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            threadPool.shutdownNow();
        }
    }
}