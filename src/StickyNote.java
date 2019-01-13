import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.fxmisc.richtext.*;
import java.io.*;

public class StickyNote extends Application {

    Properties manager = new Properties();
    public static int firstOpened = 1;


    @Override
    public void start(Stage primaryStage) throws IOException {
        Style style = new Style();
        BufferedReader reader;
        reader = new BufferedReader(new FileReader("C:\\Users\\Acer\\IdeaProjects\\StickyNotes\\lastwindow.txt"));


        if(firstOpened!=1){
            manager.getLayout().setStyle("-fx-background-color: darkgrey ;");
            manager.getTextArea().setStyle(style.getTextStyle());
        }
        if(firstOpened==1){
            StringBuilder textBuilder = new StringBuilder();
            String textAreaStyle = reader.readLine();
            String layoutStyle = reader.readLine();
            String line = reader.readLine();
            while(line!=null){
                textBuilder.append(line);
                line = reader.readLine();
            }
            String text = textBuilder.toString();
            InlineCssTextArea textArea = new InlineCssTextArea(text);
            BorderPane layout = new BorderPane();
            manager.setLayout(layout);
            manager.setTextArea(textArea);
            manager.getTextArea().setStyle(textAreaStyle);
            manager.getLayout().setStyle(layoutStyle);
            firstOpened++;
        }


        manager.getTextArea().computeAreaInScreen();
        manager.getTextArea().autosize();

        Menu menu = new Menu();

        Scene scene = new Scene(manager.getLayout(), 500, 400);
        HBox topMenu = null;
        try {
            topMenu = menu.createTopMenu(manager.getLayout(), manager.getTextArea(),style,this);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (topMenu != null) {
            topMenu.autosize();
        }
        HBox bottomMenu = menu.createBottomMenu(manager.getTextArea(), style);
        bottomMenu.autosize();
        manager.getLayout().setCenter(manager.getTextArea());
        manager.getLayout().getCenter().autosize();
        manager.getLayout().setTop(topMenu);
        manager.getLayout().setBottom(bottomMenu);
        manager.getLayout().autosize();

        primaryStage.setScene(scene);



        manager.getTextArea().setWrapText(true);
        primaryStage.setTitle("Sticky note");
        primaryStage.setMinWidth(500);
        primaryStage.setMaxWidth(500);
        primaryStage.setMinHeight(400);
        primaryStage.setMaxHeight(400);
        primaryStage.show();

    }

    @Override
    public void stop() throws Exception {

        File f = new File("C:\\Users\\Acer\\IdeaProjects\\StickyNotes\\lastwindow.txt");
        PrintWriter printWriter = new PrintWriter(f);
        printWriter.println(manager.getTextArea().getStyle());

        printWriter.println(manager.getLayout().getStyle());
        printWriter.println(manager.getTextArea().getText());
        printWriter.flush();
        printWriter.close();
        System.out.println("printed: "+ manager.getTextArea().getText());
        System.out.println(manager.getTextArea().getStyle());
    }


}
