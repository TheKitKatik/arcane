package multithreading.concurrency_module.first_task;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Post {
    private long id;
    private String title;
    private String content;
    private String author;
    private List<Comment> comments;
}
