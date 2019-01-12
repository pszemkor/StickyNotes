import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.Button;

import java.awt.*;
import javafx.event.EventHandler;

class Menu {
     HBox createTopMenu(BorderPane layout, TextArea textArea){
         HBox topMenu = new HBox(15);
        Circle blueCircle = new Circle();
        blueCircle.setFill(Color.BLUE);
        blueCircle.setRadius(20);
         EventHandler blueHandler = new EventHandler() {
             @Override
             public void handle(Event event) {
                 layout.setStyle("-fx-background-color: cornflowerblue;");
                 textArea.setStyle("-fx-control-inner-background: cornflowerblue;");
             }
         };
         blueCircle.addEventFilter(MouseEvent.MOUSE_CLICKED,blueHandler);

        Circle redCircle = new Circle();
        redCircle.setFill(Color.RED);
        redCircle.setRadius(20);
         EventHandler redandler = new EventHandler() {
             @Override
             public void handle(Event event) {
                 layout.setStyle("-fx-background-color: crimson;");
                 textArea.setStyle("-fx-control-inner-background: crimson;");
             }
         };
         redCircle.addEventFilter(MouseEvent.MOUSE_CLICKED,redandler);

        Circle greenCircle = new Circle();
        greenCircle.setFill(Color.GREEN);
        greenCircle.setRadius(20);
         EventHandler greenHandler = new EventHandler() {
             @Override
             public void handle(Event event) {
                 layout.setStyle("-fx-background-color: darkolivegreen;");
                 textArea.setStyle("-fx-control-inner-background: darkolivegreen;");
             }
         };
         greenCircle.addEventFilter(MouseEvent.MOUSE_CLICKED,greenHandler);

        Circle greyCircle = new Circle();
        greyCircle.setFill(Color.GRAY);
        greyCircle.setRadius(20);
         EventHandler greyHandler = new EventHandler() {
             @Override
             public void handle(Event event) {
                 layout.setStyle("-fx-background-color: darkgrey ;");
                 textArea.setStyle("-fx-control-inner-background: darkgrey ;");
             }
         };
         greyCircle.addEventFilter(MouseEvent.MOUSE_CLICKED,greyHandler);

        Circle orangeCircle = new Circle();
        orangeCircle.setFill(Color.YELLOW);
        orangeCircle.setRadius(20);
         EventHandler orangeHandler = new EventHandler() {
             @Override
             public void handle(Event event) {
                 layout.setStyle("-fx-background-color: goldenrod ;");
                 textArea.setStyle("-fx-control-inner-background: goldenrod ;");
             }
         };
         orangeCircle.addEventFilter(MouseEvent.MOUSE_CLICKED,orangeHandler);


        topMenu.getChildren().addAll(blueCircle,redCircle,greenCircle,greyCircle,orangeCircle);


        return topMenu;
    }

    HBox createBottomMenu(Scene scene){
         HBox bottomMenu = new HBox(30);

        Button underlineButton = new Button("underline");
        Button boldButton = new Button("bold");
        Button italicButton = new Button("italic");

        bottomMenu.getChildren().addAll(underlineButton,boldButton,italicButton);

        return bottomMenu;
    }


}
