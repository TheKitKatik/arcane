package second_task;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Notification {
    private NotificationType type;
    private String message;
}
