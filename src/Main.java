import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane mainMenu = new BorderPane();
        Text textFlow = new Text("     Welcome to Sticky Notes app! ");
        Text seconf = new Text("Press button START to create new sticky notes");
        textFlow.setStyle("-fx-font-size: 18pt ;");
        seconf.setStyle("-fx-font-size: 14pt ;");
        textFlow.setFill(Color.BLACK);
        seconf.setFill(Color.BLACK);
        mainMenu.setTop(textFlow);
        mainMenu.setBottom(seconf);

        javafx.scene.control.Button startButton = new Button("START");
        startButton.setStyle("-fx-background-color: #494C52; -fx-text-fill:  white;");
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StickyNote note = new StickyNote();
                Stage stage = new Stage();
                try {
                    note.start(stage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        startButton.setPrefSize(100,100);
        mainMenu.setCenter(startButton);
        mainMenu.getCenter().autosize();

        Scene scene = new Scene(mainMenu,400,400);
        mainMenu.setStyle("-fx-background-color: darkgrey;");

        primaryStage.setScene(scene);
        primaryStage.setMaxHeight(400);
        primaryStage.setMaxWidth(400);
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(400);
        primaryStage.setTitle("STICKY NOTES");
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
