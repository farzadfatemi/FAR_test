package POJOs;

/**
 * Created by FARzad - VOLCANO on 5/30/2017.
 */
public class Label {
    private String labelText;
    private int FontLength ;
    private int FontHeight ;
    private double labelWidth ;
    private double labelHeight ;

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

    public double getLabelWidth() {
        return labelWidth;
    }

    public void setLabelWidth(double labelWidth) {
        this.labelWidth = labelWidth;
    }

    public double getLabelHeight() {
        return labelHeight;
    }

    public void setLabelHeight(double labelHeight) {
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