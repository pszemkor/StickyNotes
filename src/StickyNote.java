import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import org.fxmisc.richtext.*;

public class StickyNote extends Application {

    @Override
    public void start(Stage primaryStage) {

        Style style = new Style();
        InlineCssTextArea textArea = new InlineCssTextArea();
        textArea.computeAreaInScreen();
        textArea.autosize();

        StyledTextArea textArea1 = new StyleClassedTextArea();

        Menu menu = new Menu();
        //Group root = new Group();
        BorderPane layout = new BorderPane();
        Scene scene = new Scene(layout, 500, 400);
        HBox topMenu = menu.createTopMenu(layout, textArea);
        topMenu.autosize();
        HBox bottomMenu = menu.createBottomMenu(textArea, style);
        bottomMenu.autosize();
        layout.setCenter(textArea);
        layout.getCenter().autosize();
        layout.setTop(topMenu);
        layout.setBottom(bottomMenu);
        layout.autosize();
        //layout.setPrefSize(500,400);

        primaryStage.setScene(scene);
        layout.setStyle("-fx-background-color: darkgrey ;");
        textArea.setWrapText(true);
        textArea.setStyle(style.getTextStyle());


        primaryStage.setMinWidth(500);
        primaryStage.setMinHeight(400);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
