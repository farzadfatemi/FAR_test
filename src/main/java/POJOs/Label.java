package POJOs;

/**
 * Created by FARzad - VOLCANO on 5/30/2017.
 */
public class Label {
    private String labelText;
    private int FontLength ;
    private int FontHeight ;
    private int labelWidth ;
    private int labelHeight ;

    public String getLabelText() {
        return labelText;
    }

    public void setLabelText(String labelText) {
        this.labelText = labelText;
    }

    public int getFontLength() {
        return FontLength;
    }

    public void setFontLength(int fontLength) {
        FontLength = fontLength;
    }

    public int getFontHeight() {
        return FontHeight;
    }

    public void setFontHeight(int fontHeight) {
        FontHeight = fontHeight;
    }

    public int getLabelWidth() {
        return labelWidth;
    }

    public void setLabelWidth(int labelWidth) {
        this.labelWidth = labelWidth;
    }

    public int getLabelHeight() {
        return labelHeight;
    }

    public void setLabelHeight(int labelHeight) {
        this.labelHeight = labelHeight;
    }

    @Override
    public String toString() {
        return "Label{" +
                "labelText='" + labelText + '\'' +
                ", FontLength=" + FontLength +
                ", FontHeight=" + FontHeight +
                ", labelWidth=" + labelWidth +
                ", labelHeight=" + labelHeight +
                '}';
    }
}
