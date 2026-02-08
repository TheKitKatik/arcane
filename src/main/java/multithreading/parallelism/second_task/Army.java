package multithreading.parallelism.second_task;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Army {
    private List<Squad> army;

    public int calculateTotalPower(){
        Result result = new Result();
        List<Thread> threads = new ArrayList<>();

        army.forEach(squad -> {
            Thread thread = new Thread(() -> {
                result.result += squad.calculateSquadPower();
            });
            threads.add(thread);
            thread.start();
        });

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        return result.result;
    }
    class Result{
        int result;
    }
}
