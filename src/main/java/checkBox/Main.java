package checkBox;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        VBox buttons = new VBox(10);
        HBox rects = new HBox();

        CheckBox[] checkBoxes = new CheckBox[]{
                new CheckBox("Red"),
                new CheckBox("Green"),
                new CheckBox("Blue")

        };

        Rectangle[] rectangles = new Rectangle[]{
                new Rectangle(100, 100, Color.RED),
                new Rectangle(100, 100, Color.GREEN),
                new Rectangle(100, 100, Color.BLUE),
        };

        for (int i = 0; i < 3; i++) {
            CheckBox checkBox = checkBoxes[i];
            Rectangle rectangle = rectangles[i];
            buttons.getChildren().addAll(checkBox);
            checkBox.selectedProperty().addListener(observable -> {
                if (checkBox.isSelected()){
                    rects.getChildren().add(rectangle);
                }else{
                    rects.getChildren().remove(rectangle);
                }
            });
        }

        root.setCenter(rects);
        root.setLeft(buttons);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
