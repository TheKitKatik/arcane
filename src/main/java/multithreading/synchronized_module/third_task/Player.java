package multithreading.synchronized_module.third_task;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class Player {
    private final Random random = new Random();
    private String name;

    public void doBattle(Boss boss) throws InterruptedException{
        boss.joinBattle(this);
        Thread.sleep(random.nextInt(5) * 1000);
        boss.leaveBattle(this);
    }
}
