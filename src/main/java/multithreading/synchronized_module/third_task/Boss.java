package multithreading.synchronized_module.third_task;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) throws InterruptedException{
        while(currentPlayers + 1 >  maxPlayers){
            System.out.println(player.getName() + " мест нет - ожидайте");
            this.wait();
        }
        currentPlayers++;
        System.out.println("==Игрок - " + player.getName() +" присоединился к сражению==");
    }

    public synchronized void leaveBattle(Player player) {
        System.out.println("==Игрок - " + player.getName() +" покинул сражение==");
        currentPlayers--;
        this.notify();
    }
}
