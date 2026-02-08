package multithreading.synchronized_module.second_task;

public class CheckTask {

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        new Thread( () -> {
            try {
                uploader.startAutoUpload();
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println("Лог прерывания");
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(10000);
                uploader.onNewPhotoAdded("new_image");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Лог прерывания");
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(15000);
                uploader.onNewPhotoAdded("new_image_with_kitty");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Лог прерывания");
            }
        }).start();
    }
}
