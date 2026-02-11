package multithreading.synchronized_module.fourth_task;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Game {
    private int score;
    private int lives;
    private final Object lockForScore  = new Object();
    private final Object lockForLives = new Object();

    public void update(boolean isUpScore, boolean isDie) {
        if(isUpScore){
            synchronized (lockForScore) {
                if(lives <= 0) {
                    System.out.println("Игра окончена!!!");
                    return;
                }
                score++;
            }
        }
        if(isDie){
            synchronized (lockForLives) {
                if(lives <= 0) {
                    System.out.println("Игра окончена!!!");
                    return;
                }
                lives--;
            }
        }
    }

}
