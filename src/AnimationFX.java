import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class AnimationFX extends Application {
    public ArrayList<Image> image = new ArrayList();
    public ImageView imageView;
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane pane = new BorderPane();
        VBox textfeildLayout = new VBox();
        HBox buttonLayout = new HBox();

        image.add(new Image("/image/person.jpg"));
        imageView = new ImageView(image.get(0));


        final TextField txfSpeed = new TextField("200");
        TextField txfImg = new TextField("L");
        TextField txfImgCount = new TextField("24");
        TextField txfMusic = new TextField("http://www.cs.armstrong.edu/liang/common/audio/anthem/anthem2.mp3");
        textfeildLayout.getChildren().addAll(txfSpeed,txfImg,txfImgCount,txfMusic);

        char stopIcon = 9724;
        char pauseIcon = 10073;
        char playIcon = 9654;

        Button play = new Button(String.valueOf(playIcon));
        Button pause = new Button(String.valueOf(pauseIcon));
        Button stop = new Button(String.valueOf(stopIcon));

        buttonLayout.getChildren().addAll(play, pause, stop);

        pane.setTop(imageView);
        pane.setCenter(textfeildLayout);
        pane.setBottom(buttonLayout);

        play.setOnAction(e->{
            int size = Integer.parseInt(txfImgCount.getText());
            for(int i=0; i<Integer.parseInt(txfImgCount.getText());i++) {
                String path = "/image/" + txfImg.getText() + (i+1) + ".gif";
                System.out.println(path);
                image.add(new Image(path));
            }

            final int[] count = {0};

// then in your method

                long delay = Long.parseLong(txfSpeed.getText()); //update once per 2 seconds.
            new Timer().schedule(new TimerTask() {

                    @Override
                    public void run() {
                        imageView.setImage(image.get(count[0]++));
                        if (count[0] >= image.size()) {
                            count[0] = 0;
                        }
                    }
            }, 0, delay);
         /*   Task task = new Task<T>() {
                @Override
                public <T> call() throws Exception {
                    for (int i = 0; i < image.length; i++) {
                        int finalI = i;
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                imageView[0].setImage(image[finalI]);
                            }
                        });
                        Thread.sleep(1000);
                    }
                    return null;
                }
            };
            Thread th = new Thread(task);
            th.setDaemon(true);
            th.start();

        });*/
           /* for(int i=0; i<=Integer.parseInt(txfImgCount.getText());i++) {
                String path = "/image/" + txfImg.getText() + i + ".gif";
                image[i] = new Image(path);
            }
            Task task = null;
            try {
                task = new Task(image,imageView);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            Thread th = new Thread(task);
            th.setDaemon(true);
            th.start();*/
        });

        Scene scene = new Scene(pane);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
