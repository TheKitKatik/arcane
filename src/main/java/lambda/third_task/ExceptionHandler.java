package lambda.third_task;

import java.util.function.Function;

public class ExceptionHandler {
    public static <T, R> R withErrorHandling(T request, Function<T, R> action, Function<Exception, R> handler) {
        try {
            //validation
            R result = action.apply(request);
            //parse response

            System.out.println("Успешно сходили в сторонний сервис");
            return result;
        } catch (Exception e){
            R result = handler.apply(e);
            System.out.println("Как-то обработали ошибку интеграции");
            return result;
        }
    }
}
