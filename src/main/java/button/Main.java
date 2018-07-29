package button;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Window");
        primaryStage.setHeight(300);
        primaryStage.setWidth(300);

        Pane root = new Pane();
        Button button = new Button();
        button.setText("Click me");
        button.setTranslateX(140);
        button.setTranslateY(140);
        button.setPrefSize(70, 20);


        Rectangle rectangle = new Rectangle(50, 50);
        Random random = new Random();
        button.setOnAction(event -> {
            rectangle.setFill(Color.rgb(
                    random.nextInt(255),
                    random.nextInt(255),
                    random.nextInt(255)
            ));
            System.out.println("Hello");
        });

        Button button1 = new Button("b1");
        ImageView imageView = new ImageView("kek.jpg");
        imageView.setFitHeight(100);
        imageView.setFitWidth(200);
        button1.setGraphic(imageView);
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.AQUAMARINE);
        shadow.setRadius(60);
        button1.setOnAction(event -> button1.setEffect(shadow));

        button.setStyle("-fx-base:#b6e7c9");

        Scene scene = new Scene(root);

        root.getChildren().addAll(button, rectangle, button1);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
