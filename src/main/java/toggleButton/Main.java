package toggleButton;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        HBox buttons = new HBox();
        buttons.setAlignment(Pos.CENTER);

        ToggleGroup group = new ToggleGroup();

        String green = "Green";
        String blue = "Blue";
        String red = "Red";

        ToggleButton tb1 = new ToggleButton(green);
        ToggleButton tb2 = new ToggleButton(blue);
        ToggleButton tb3 = new ToggleButton(red);

        tb1.setToggleGroup(group);
        tb2.setToggleGroup(group);
        tb3.setToggleGroup(group);

        tb1.setUserData(Color.GREEN);
        tb2.setUserData(Color.BLUE);
        tb3.setUserData(Color.RED);

        Rectangle rectangle = new Rectangle(300, 300);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.DARKGOLDENROD);
        rectangle.setArcHeight(50);
        rectangle.setArcWidth(50);

        group.selectedToggleProperty().addListener(event -> {
            if (group.getSelectedToggle() != null) {
                rectangle.setFill((Color) group.getSelectedToggle().getUserData());
            } else {
                rectangle.setFill(Color.WHITE);
            }
        });

        tb1.setStyle("-fx-base: lightgreen");
        tb2.setStyle("-fx-base: lightblue");
        tb3.setStyle("-fx-base: salmon");



        buttons.getChildren().addAll(tb1, tb2, tb3);
        root.setTop(buttons);
        root.setCenter(rectangle);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
