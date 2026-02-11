package multithreading.parallelism.fifth_task;

import java.util.Random;

public enum TaskType {
    CLEAN("Отпидорить комнату"),
    WASH("В темпе вальса разобраться с посудой"),
    BEER("По пивку"),
    SHOP("Гонец золотые пяточки");

    private String task;

    TaskType(String task){
        this.task = task;
    }

    public String getTask(){
        return task;
    }

    public static TaskType getRandomTask() {
        Random random = new Random();

        TaskType[] taskTypes = TaskType.values();
        return taskTypes[random.nextInt(taskTypes.length)];
    }
}
