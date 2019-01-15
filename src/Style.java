public class Style {
    private String weight = "-fx-font-weight: normal;";
    private String style = "-fx-font-style: normal;";
    private String fontType = "-fx-font-family: Times New Roman;";
    private String backGround = "-fx-background-color: darkgrey;";
    private String decoration = "-fx-underline: false;";
    private String size = "-fx-font-size: 24pt ;";

    public void setSize(String size) {
        this.size = size;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setFontType(String fontType) {
        this.fontType = fontType;
    }

    public void setBackGround(String backGround) {
        this.backGround = backGround;
    }

    public void setDecoration(String decoration) {
        this.decoration = decoration;
    }

    public String getSize() {
        return size;
    }

    public String getWeight() {
        return weight;
    }

    public String getStyle() {
        return style;
    }

    public String getFontType() {
        return fontType;
    }

    public String getBackGround() {
        return backGround;
    }

    public String getDecoration() {
        return decoration;
    }

    public String getTextStyle(){
        return getBackGround()+getFontType()+getWeight()+getDecoration()+getStyle()+getSize();
    }

}
