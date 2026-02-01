package lambda.third_task;

public class RemoteService {
    public static String call(String param){
        //return "УСПЕХ - ответ от сервиса интеграции";
        throw new RuntimeException("Сеть моргнула");
    }
}
