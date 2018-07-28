package Label;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();

        Label label = new Label();
        label.setText("This is a label");

        ImageView img = new ImageView("kek.jpg");
        img.setFitHeight(200);
        img.setFitWidth(200);
        Label imLabel = new Label();
        imLabel.setGraphic(img);
        imLabel.setTranslateX(75);
        imLabel.setTranslateY(100);

        imLabel.setText("kek@");
        imLabel.setGraphicTextGap(20);
        imLabel.setContentDisplay(ContentDisplay.TOP);

        Label magic = new Label();
        magic.setText("MaGiC LaBeL");
        magic.setTranslateX(140);
        magic.setTranslateY(350);

        magic.setOnMouseEntered(event -> {
            magic.setScaleX(3);
            magic.setScaleY(3);
            magic.setTextFill(Color.RED);
        });
        magic.setOnMouseExited(event -> {
            magic.setScaleX(1);
            magic.setScaleY(1);
            magic.setTextFill(Color.BLACK);
        });

        root.getChildren().addAll(label, imLabel,magic);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
