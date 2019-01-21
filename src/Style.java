public class Style {
    private String weight = "-fx-font-weight: normal;";
    private String style = "-fx-font-style: normal;";
    private String fontType = "-fx-font-family: Times New Roman;";
    private String backGround = "-fx-background-color: darkgrey;";
    private String decoration = "-fx-underline: false;";
    private String size = "-fx-font-size: 24pt ;";

     void setSize(String size) {
        this.size = size;
    }

     void setWeight(String weight) {
        this.weight = weight;
    }

     void setStyle(String style) {
        this.style = style;
    }

    public void setFontType(String fontType) {
        this.fontType = fontType;
    }

     void setBackGround(String backGround) {
        this.backGround = backGround;
    }

     void setDecoration(String decoration) {
        this.decoration = decoration;
    }

     String getSize() {
        return size;
    }

     String getWeight() {
        return weight;
    }

     String getStyle() {
        return style;
    }

     String getFontType() {
        return fontType;
    }

     String getBackGround() {
        return backGround;
    }

     String getDecoration() {
        return decoration;
    }

    String getTextStyle(){
        return getBackGround()+getFontType()+getWeight()+getDecoration()+getStyle()+getSize();
    }

}
