package lambda.third_task;

import java.util.Arrays;

public class CheckScenario {
    public static void main(String[] args) {
        String result = ExceptionHandler.withErrorHandling("-REQUEST-",
                param -> {
            System.out.println("Начинаю поход в сторонний сервис");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String response = RemoteService.call(param);
            System.out.println("закончил поход");
            return response;
        },
                ex -> {
                    System.out.println("поймали ошибку");
                    //на проде заворачиваем ошибку в какой-нибудь Response объект
                    String stackTrace = Arrays.toString(ex.getStackTrace());
                    return stackTrace;
                });

        System.out.println();
        System.out.println(result);
    }
}
