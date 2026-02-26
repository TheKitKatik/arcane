package multithreading.concurrency_module.first_task;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Comment {
    private String text;
    private String author;
    private LocalDateTime timestamp;
}
