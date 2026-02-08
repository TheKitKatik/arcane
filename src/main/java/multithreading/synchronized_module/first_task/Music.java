package multithreading.synchronized_module.first_task;

import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread player1 = new Thread(() -> {
            player.pause();
            player.skip();
            player.skip();
            player.play();
        });
        Thread player2 = new Thread(() -> {
            player.pause();
            player.previous();
            player.previous();
        });
        Thread player3 = new Thread(() -> {
            player.previous();
            player.play();
        });
        Thread player4 = new Thread( () -> {
            player.skip();
            player.skip();
            player.play();
        });
        Thread player5 = new Thread(() -> {
            player.pause();
            player.skip();
        });
        Thread player6 = new Thread(player::pause);

        List.of(player4, player1, player2, player3, player5, player6).forEach(Thread::start);
    }
}
