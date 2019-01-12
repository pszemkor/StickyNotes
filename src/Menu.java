import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.control.IndexRange;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.fxmisc.richtext.*;
import javafx.event.EventHandler;

class Menu {

    HBox createTopMenu(BorderPane layout, InlineCssTextArea textArea) {
        HBox topMenu = new HBox(25);

        Rectangle addNewWindow = new Rectangle(40, 40);
        addNewWindow.setFill(Color.BLACK);
        EventHandler newWindow = new EventHandler() {
            @Override
            public void handle(Event event) {
                Stage stage = new Stage();
                StickyNote newNote = new StickyNote();
                newNote.start(stage);
            }
        };
        addNewWindow.addEventFilter(MouseEvent.MOUSE_CLICKED, newWindow);


        Circle blueCircle = new Circle();
        blueCircle.setStrokeWidth(3);
        blueCircle.setStroke(Color.BLACK);
        blueCircle.setFill(Color.BLUE);
        blueCircle.setRadius(20);
        EventHandler blueHandler = new EventHandler() {
            @Override
            public void handle(Event event) {
                layout.setStyle("-fx-background-color: cornflowerblue;");
                textArea.setStyle("-fx-background-color: cornflowerblue;");
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
                layout.setStyle("-fx-background-color: crimson;");
                textArea.setStyle("-fx-background-color: crimson;");
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
                layout.setStyle("-fx-background-color: darkolivegreen;");
                textArea.setStyle("-fx-background-color: darkolivegreen;");
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
                layout.setStyle("-fx-background-color: darkgrey ;");
                textArea.setStyle("-fx-background-color: darkgrey ;");
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
                layout.setStyle("-fx-background-color: goldenrod ;");
                textArea.setStyle("-fx-background-color: goldenrod ;");
            }
        };
        orangeCircle.addEventFilter(MouseEvent.MOUSE_CLICKED, orangeHandler);

        topMenu.getChildren().addAll(blueCircle, redCircle, greenCircle, greyCircle, orangeCircle, addNewWindow);
        topMenu.setHgrow(blueCircle, Priority.ALWAYS);
        topMenu.setHgrow(redCircle, Priority.ALWAYS);
        topMenu.setHgrow(greenCircle, Priority.ALWAYS);
        topMenu.setHgrow(greyCircle, Priority.ALWAYS);
        topMenu.setHgrow(orangeCircle, Priority.ALWAYS);
        topMenu.setHgrow(addNewWindow, Priority.ALWAYS);


        return topMenu;
    }

    HBox createBottomMenu(InlineCssTextArea textArea, Style textStyle) {
        HBox bottomMenu = new HBox(40);

        Button italicButton = new Button(" italic  ");
        italicButton.setStyle("-fx-background-color: #494C52; -fx-text-fill:  white;");
        italicButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!textStyle.getStyle().contains("italic")) {
                    textStyle.setStyle("-fx-font-style: italic;");
                    IndexRange selection = textArea.getSelection();
                    textArea.setStyle(selection.getStart(), selection.getEnd(),textStyle.getTextStyle());
                } else {
                    textStyle.setStyle("-fx-font-style: normal;");
                    IndexRange selection = textArea.getSelection();
                    textArea.setStyle(selection.getStart(), selection.getEnd(), textStyle.getTextStyle());
                }
            }
        });

        Button boldButton = new Button("  bold   ");
        boldButton.setStyle("-fx-background-color: #494C52; -fx-text-fill:  white;");
        boldButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!textStyle.getWeight().contains("bold")) {
                    textStyle.setWeight("-fx-font-weight: bold;");
                    IndexRange selection = textArea.getSelection();
                    textArea.setStyle(selection.getStart(), selection.getEnd(),textStyle.getTextStyle());
                } else {
                    textStyle.setWeight("-fx-font-weight: normal;");
                    IndexRange selection = textArea.getSelection();
                    textArea.setStyle(selection.getStart(), selection.getEnd(), textStyle.getTextStyle());
                }
            }
        });

        Button underlineButton = new Button("underline");
        underlineButton.setStyle("-fx-background-color: #494C52; -fx-text-fill:  white;");
        underlineButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!textStyle.getDecoration().contains("true")) {
                    textStyle.setDecoration("-fx-underline: true;");
                    IndexRange selection = textArea.getSelection();
                    textArea.setStyle(selection.getStart(), selection.getEnd(),textStyle.getTextStyle());
                } else {
                    textStyle.setDecoration("-fx-underline: false;");
                    IndexRange selection = textArea.getSelection();
                    textArea.setStyle(selection.getStart(), selection.getEnd(), textStyle.getTextStyle());
                }
            }
        });

        bottomMenu.getChildren().addAll(underlineButton, boldButton, italicButton);
        bottomMenu.setPadding(new Insets(10, 10, 10, 10));

        return bottomMenu;
    }


}
