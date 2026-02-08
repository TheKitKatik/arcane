package multithreading.synchronized_module.first_task;

import lombok.Data;

@Data
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play(){
        synchronized(lock){
            isPlaying = true;
        }
    }

    public void pause(){
        synchronized(lock){
            isPlaying = false;
        }
    }

    public void skip() {
        synchronized(lock){
            System.out.println("Переключил трек");
        }
    }

    public void previous() {
        synchronized(lock) {
            System.out.println("Включил предыдущий трек");
        }
    }
}
