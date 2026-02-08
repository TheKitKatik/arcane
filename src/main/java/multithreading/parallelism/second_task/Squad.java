package multithreading.parallelism.second_task;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Squad<T extends Heroes> {
    private List<T> heroes;

    public int calculateSquadPower(){
        return heroes.stream().mapToInt(Heroes::getPower).sum();
    }
}
