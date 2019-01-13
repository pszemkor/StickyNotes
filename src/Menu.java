import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.Button;
import org.fxmisc.richtext.*;
import javafx.event.EventHandler;
import java.io.FileNotFoundException;

class Menu {

    HBox createTopMenu(BorderPane layout, InlineCssTextArea textArea, Style style, StickyNote note) throws FileNotFoundException {
        HBox topMenu = new HBox(20);
        Button exitButton = new Button("save as last");
        exitButton.setStyle("-fx-background-color: #494C52; -fx-text-fill:  white;");
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    note.stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


        Circle blueCircle = new Circle();
        blueCircle.setStrokeWidth(3);
        blueCircle.setStroke(Color.BLACK);
        blueCircle.setFill(Color.BLUE);
        blueCircle.setRadius(20);
        EventHandler blueHandler = new EventHandler() {

            public void handle(Event event) {
                style.setBackGround("-fx-background-color: cornflowerblue;");
                layout.setStyle(style.getBackGround());
                textArea.setStyle(style.getTextStyle());
            }
        };
        blueCircle.addEventFilter(MouseEvent.MOUSE_CLICKED, blueHandler);

        Circle redCircle = new Circle();
        redCircle.setStrokeWidth(3);
        redCircle.setStroke(Color.BLACK);
        redCircle.setFill(Color.RED);
        redCircle.setRadius(20);
        EventHandler redandler = new EventHandler() {
            @Override
            public void handle(Event event) {
                style.setBackGround("-fx-background-color: crimson;");
                layout.setStyle(style.getBackGround());
                textArea.setStyle(style.getTextStyle());
            }
        };
        redCircle.addEventFilter(MouseEvent.MOUSE_CLICKED, redandler);

        Circle greenCircle = new Circle();
        greenCircle.setStrokeWidth(3);
        greenCircle.setStroke(Color.BLACK);
        greenCircle.setFill(Color.GREEN);
        greenCircle.setRadius(20);
        EventHandler greenHandler = new EventHandler() {
            @Override
            public void handle(Event event) {
                style.setBackGround("-fx-background-color: darkolivegreen;");
                layout.setStyle(style.getBackGround());
                textArea.setStyle(style.getTextStyle());
            }
        };
        greenCircle.addEventFilter(MouseEvent.MOUSE_CLICKED, greenHandler);

        Circle greyCircle = new Circle();
        greyCircle.setStrokeWidth(3);
        greyCircle.setStroke(Color.BLACK);
        greyCircle.setFill(Color.GRAY);
        greyCircle.setRadius(20);
        EventHandler greyHandler = new EventHandler() {
            @Override
            public void handle(Event event) {
                style.setBackGround("-fx-background-color: darkgrey ;");
                layout.setStyle(style.getBackGround());
                textArea.setStyle(style.getTextStyle());
            }
        };
        greyCircle.addEventFilter(MouseEvent.MOUSE_CLICKED, greyHandler);

        Circle orangeCircle = new Circle();
        orangeCircle.setStrokeWidth(3);
        orangeCircle.setStroke(Color.BLACK);
        orangeCircle.setFill(Color.YELLOW);
        orangeCircle.setRadius(20);
        EventHandler orangeHandler = new EventHandler() {
            @Override
            public void handle(Event event) {
                style.setBackGround("-fx-background-color: goldenrod ;");
                layout.setStyle(style.getBackGround());
                textArea.setStyle(style.getTextStyle());
            }
        };
        orangeCircle.addEventFilter(MouseEvent.MOUSE_CLICKED, orangeHandler);

        topMenu.getChildren().addAll(  blueCircle, redCircle, greenCircle, greyCircle, orangeCircle, exitButton);
        HBox.setHgrow(blueCircle, Priority.ALWAYS);
        HBox.setHgrow(redCircle, Priority.ALWAYS);
        HBox.setHgrow(greenCircle, Priority.ALWAYS);
        HBox.setHgrow(greyCircle, Priority.ALWAYS);
        HBox.setHgrow(orangeCircle, Priority.ALWAYS);


        return topMenu;
    }

    HBox createBottomMenu(InlineCssTextArea textArea, Style textStyle) {
        HBox bottomMenu = new HBox(100);

        Button italicButton = new Button(" italic  ");
        italicButton.setStyle("-fx-background-color: #494C52; -fx-text-fill:  white;");
        italicButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (textStyle.getStyle().equals("-fx-font-style: normal;")) {
                    textStyle.setStyle("-fx-font-style: italic;");
                    textArea.setStyle( 0,textArea.getText().length(),textStyle.getTextStyle());
                } else if (textStyle.getStyle().equals("-fx-font-style: italic;")){
                    textStyle.setStyle("-fx-font-style: normal;");
                    textArea.setStyle( 0,textArea.getText().length(),textStyle.getTextStyle());
                }
            }
        });

        Button boldButton = new Button("  bold   ");
        boldButton.setStyle("-fx-background-color: #494C52; -fx-text-fill:  white;");
        boldButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (textStyle.getWeight().equals("-fx-font-weight: normal;")) {
                    textStyle.setWeight("-fx-font-weight: bold;");
                    textArea.setStyle( 0,textArea.getText().length(),textStyle.getTextStyle());
                } else if (textStyle.getWeight().equals("-fx-font-weight: bold;")) {
                    textStyle.setWeight("-fx-font-weight: normal;");
                    textArea.setStyle( 0,textArea.getText().length(),textStyle.getTextStyle());
                }
            }
        });

        Button underlineButton = new Button("underline");
        underlineButton.setStyle("-fx-background-color: #494C52; -fx-text-fill:  white;");
        underlineButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (textStyle.getDecoration().equals("-fx-underline: false;")) {
                    textStyle.setDecoration("-fx-underline: true;");
                  //  IndexRange selection = textArea.getSelection();
                    textArea.setStyle(0, textArea.getText().length(), textStyle.getTextStyle());
                   // textArea.setStyle(textStyle.getTextStyle());
                } else if  (textStyle.getDecoration().equals("-fx-underline: true;")){
                    textStyle.setDecoration("-fx-underline: false;");
                    textArea.setStyle( 0,textArea.getText().length(),textStyle.getTextStyle());
                }
            }
        });

        bottomMenu.getChildren().addAll(underlineButton, boldButton, italicButton);
        bottomMenu.setPadding(new Insets(10, 10, 10, 10));

        return bottomMenu;
    }


}
