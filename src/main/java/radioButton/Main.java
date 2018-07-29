package radioButton;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        HBox buttons = new HBox(10);
        buttons.setAlignment(Pos.CENTER);
        HBox pic = new HBox();
        pic.setAlignment(Pos.CENTER);

        ToggleGroup group = new ToggleGroup();

        String home = "home";
        String calendar = "calendar";
        String contact = "contact";

        RadioButton rb1 = new RadioButton(home);
        RadioButton rb2 = new RadioButton(calendar);
        RadioButton rb3 = new RadioButton(contact);

        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);
        rb3.setToggleGroup(group);

        rb1.setSelected(true);

        rb1.setUserData(home);
        rb2.setUserData(calendar);
        rb3.setUserData(contact);

        ImageView img = new ImageView("home.png");
        img.setFitWidth(300);
        img.setFitHeight(300);

        group.selectedToggleProperty().addListener(event -> {
            Image image = new Image(group.getSelectedToggle().getUserData() + ".png");
            img.setImage(image);
        });

        buttons.getChildren().addAll(rb1, rb2, rb3);
        pic.getChildren().addAll(img);
        root.setTop(buttons);
        root.setCenter(pic);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
