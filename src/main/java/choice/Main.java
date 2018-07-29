package choice;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();

        ChoiceBox choiceBox = new ChoiceBox();
        choiceBox.setItems(FXCollections.observableArrayList(
                "Red", "Green", "Yellow", "Blue", "Black"
        ));

        Color[] colors = new Color[]{Color.RED, Color.GREEN, Color.YELLOW, Color.BLUE, Color.BLACK};

        Rectangle rectangle = new Rectangle(200, 200, Color.WHITE);
        rectangle.setTranslateX(100);
        rectangle.setTranslateY(100);

        choiceBox.getSelectionModel().selectedIndexProperty().addListener(
                (ObservableValue<? extends Number> obVal, Number oldVal, Number newVal) -> {
                    rectangle.setFill(colors[newVal.intValue()]);
                }
        );

        root.getChildren().addAll(rectangle,choiceBox);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
