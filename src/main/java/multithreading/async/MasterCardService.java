package multithreading.async;

import java.util.concurrent.Future;

public class MasterCardService {

    public String collectPayment() {
        System.out.println("==Начал процес оплаты==");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "оплата - УСПЕХ";
    }

    public String sendAnalytics() {
        System.out.println("```Подготовка данных для аналитики...```");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "аналитика - УСПЕХ";
    }
}
