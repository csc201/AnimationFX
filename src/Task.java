import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Task implements Runnable{

    Image[] images;

    public Task(Image[] images, ImageView[] imageView) throws InterruptedException {
        this.images = images;
        for (int i = 0; i < images.length; i++) {
            int finalI = i;
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                }
            });
        }
    }

    @Override
    public void run() {

    }
}