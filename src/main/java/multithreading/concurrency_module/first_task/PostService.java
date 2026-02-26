package multithreading.concurrency_module.first_task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PostService {
    private final List<Post> posts = new ArrayList<>();
    private final Lock lock = new ReentrantLock();

    public void addPost(Post post){
        lock.lock();
        try {
            posts.add(post);
        } finally {
            lock.unlock();
        }
    }

    public void addComment(long postId, Comment comment){
        lock.lock();
        Optional<Post> post;
        try {
            post = posts.stream().filter(p -> p.getId() == postId).findFirst();
        } finally {
            lock.unlock();
        }

        post.ifPresent(p -> {
            synchronized (p) {
                p.getComments().add(comment);
            }
        });
    }
}
