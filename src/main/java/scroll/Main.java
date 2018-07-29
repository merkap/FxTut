package scroll;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();

        ScrollBar scrollX = new ScrollBar();
        scrollX.setMin(0);
        scrollX.setMax(260);
        scrollX.setValue(100);

        ScrollBar scrollY = new ScrollBar();
        scrollY.setMin(0);
        scrollY.setMax(260);
        scrollY.setValue(100);
        scrollY.setOrientation(Orientation.VERTICAL);
        scrollY.setTranslateY(20);

        ScrollBar scrollOpacity = new ScrollBar();
        scrollOpacity.setMin(0);
        scrollOpacity.setMax(10);
        scrollOpacity.setValue(10);
        scrollOpacity.setTranslateX(100);

        Rectangle rectangle = new Rectangle(100, 100, Color.BLUE);
        rectangle.setTranslateX(20);
        rectangle.setTranslateY(20);

        scrollX.valueProperty().addListener(event -> {
            rectangle.setTranslateX(20 + scrollX.getValue());
        });
        scrollY.valueProperty().addListener(event -> {
            rectangle.setTranslateY(20 + scrollY.getValue());
        });
        scrollOpacity.valueProperty().addListener(event -> {
            rectangle.setOpacity(scrollOpacity.getValue() / 10);
        });

        root.getChildren().addAll(scrollOpacity, scrollX, scrollY, rectangle);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
