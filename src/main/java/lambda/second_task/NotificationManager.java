package lambda.second_task;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class NotificationManager {
    private final static Map<NotificationType, Consumer<String>> handlers = new HashMap<>();
    private final static Map<SignatureType, Function<String, String>> signatures = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<String> handler) {
        handlers.put(type, handler);
    }

    public void registerSignature(SignatureType type, Function<String, String> signature) {
        signatures.put(type, signature);
    }

    public void sendNotification(Notification notification, boolean needSign) {
        //логика которая будет понимать пользователь пк или с телефеона - сейчас просто заглушка
        SignatureType type = SignatureType.FOR_PHONE;

        String message = needSign ? addSignature(notification.getMessage(), type) : notification.getMessage();
        handlers.get(notification.getType()).accept(message);
    }

    private String addSignature(String message, SignatureType signatureType){
        return signatures.get(signatureType).apply(message);
    }

    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        manager.registerHandler(NotificationType.SMS, message -> System.out.println("это письмо по смс \n" + message));
        manager.registerHandler(NotificationType.EMAIL, message -> System.out.println("это письмо по email \n" + message));
        manager.registerHandler(NotificationType.PUSH, message -> System.out.println("это письмо отправлено как пуш уведомление \n" + message));

        manager.registerSignature(SignatureType.FOR_PC, message -> {
            StringBuilder builder = new StringBuilder();
            builder.append(message);
            builder.append("\n ---- \n ==отправлено с ПК==");
            return builder.toString();
        });

        manager.registerSignature(SignatureType.FOR_PHONE, message -> {
            StringBuilder builder = new StringBuilder();
            builder.append(message);
            builder.append("\n ---- \n ==отправлено с ТЕЛЕФОНА==");
            return builder.toString();
        });

        Notification first = Notification.builder()
                .message("Тима Тома - лучшие друзья")
                .type(NotificationType.EMAIL)
                .build();

        Notification second = Notification.builder()
                .message("Это наша тачка")
                .type(NotificationType.SMS)
                .build();

        Notification third = Notification.builder()
                .message("Шнеле пепе")
                .type(NotificationType.PUSH)
                .build();

        manager.sendNotification(first, true);
        System.out.println();
        manager.sendNotification(second, false);
        System.out.println();
        manager.sendNotification(third, true);
    }
}
