import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class StickyNote extends Application {
    @Override



    public void start(Stage primaryStage) {
        TextArea textArea = new TextArea();
        textArea.autosize();
        Menu menu = new Menu();
        //Group root = new Group();
        BorderPane layout = new BorderPane();
        Scene scene = new Scene(layout, 500,400);
        HBox topMenu = menu.createTopMenu(layout,textArea);
        topMenu.autosize();
        HBox bottomMenu = menu.createBottomMenu(scene);
        layout.setCenter(textArea);
        layout.setTop(topMenu);
        layout.setBottom(bottomMenu);
        layout.autosize();
        //layout.setPrefSize(500,400);

        primaryStage.setScene(scene);
        layout.setStyle("-fx-background-color: darkgrey ;");
        textArea.setStyle("-fx-control-inner-background: darkgrey ;");

        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
