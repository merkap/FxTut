package panes;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        VBox vbox = new VBox();
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);

        Button button1 = addButton("1");
        Button button2 = addButton("2");
        Button button3 = addButton("3");
        Button button4 = addButton("4");
        Button button5 = addButton("5");
        Button button6 = addButton("6");
        Button button7 = addButton("7");
        Button button8 = addButton("8");

        vbox.getChildren().addAll(button1,button2,button3);
        hBox.getChildren().addAll(button4,button5,button6);

        root.setTop(hBox);
        root.setCenter(vbox);

        Scene scene = new Scene(root, 300,250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button addButton(String name) {
        Button button = new Button(name);
        button.setPrefSize(70, 20);
        return button;
    }


    public static void main(String[] args) {

        launch(args);
    }
}
