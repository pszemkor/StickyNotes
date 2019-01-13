import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import org.fxmisc.richtext.InlineCssTextArea;

public class Properties {

    InlineCssTextArea textArea = new InlineCssTextArea();
    BorderPane layout = new BorderPane();
    String defaultTextStyle =  "-fx-background-color: darkgrey;-fx-font-family: Times New Roman;-fx-font-weight: normal;-fx-underline: false;-fx-font-style: normal;-fx-font-size: 25pt ;";
    String defaultLayoutStyle = "-fx-background-color: darkgrey;";

    public void setTextArea(InlineCssTextArea textArea) {
        this.textArea = textArea;
    }

    public void setLayout(BorderPane layout) {
        this.layout = layout;
    }

    void init(){
        this.textArea.setStyle(defaultLayoutStyle);
        this.layout.setStyle(defaultLayoutStyle);
    }

    public InlineCssTextArea getTextArea() {
        return textArea;
    }

    public BorderPane getLayout() {
        return layout;
    }
}
