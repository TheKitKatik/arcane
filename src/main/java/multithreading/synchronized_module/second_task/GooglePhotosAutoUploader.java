package multithreading.synchronized_module.second_task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photos;
    private final ExecutorService threadPool = Executors.newFixedThreadPool(3);

    public GooglePhotosAutoUploader() {
        photos = new ArrayList<>(List.of("icon_1", "icon_2", "icon_3", "icon_4", "icon_5", "icon_6", "icon_7"));
    }

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                while (photos.isEmpty()){
                    lock.wait();
                }

                List<String> temp = this.photos;
                this.photos = new ArrayList<>();

                temp.forEach(photo -> threadPool.execute(() -> uploadPhoto(photo)));
            }
        }
    }

    public void uploadPhoto(String photo) {
        try {
            System.out.println("Начинаю загрузку фотки -> " + photo);
            System.out.println("===гоняю битики по интренетику===");
            Thread.sleep(1500);
            System.out.println("Успешно загрузил фотку -> " + photo);
            System.out.println();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("лог прерывания");
        }
    }

    public void onNewPhotoAdded(String photo) {
        synchronized(lock) {
            photos.add(photo);
            lock.notify();
        }
    }
}
