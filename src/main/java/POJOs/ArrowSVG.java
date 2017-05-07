package POJOs;

/**
 * Created by FARzad - VOLCANO on 5/5/2017.
 */
public class ArrowSVG {
    private String id;
    private int markerWidth;
    private int markerHeight;
    private int refX;
    private int refY;
    private String dim;
    private String color;
    private String storkColor;
    private String storkWidth;
    private String style;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMarkerWidth() {
        return markerWidth;
    }

    public void setMarkerWidth(int markerWidth) {
        this.markerWidth = markerWidth;
    }

    public int getMarkerHeight() {
        return markerHeight;
    }

    public void setMarkerHeight(int markerHeight) {
        this.markerHeight = markerHeight;
    }

    public int getRefX() {
        return refX;
    }

    public void setRefX(int refX) {
        this.refX = refX;
    }

    public int getRefY() {
        return refY;
    }

    public void setRefY(int refY) {
        this.refY = refY;
    }

    public String getDim() {
        return dim;
    }

    public void setDim(String dim) {
        this.dim = dim;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStorkColor() {
        return storkColor;
    }

    public void setStorkColor(String storkColor) {
        this.storkColor = storkColor;
    }

    public String getStorkWidth() {
        return storkWidth;
    }

    public void setStorkWidth(String storkWidth) {
        this.storkWidth = storkWidth;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "ArrowSVG{" +
                "id='" + id + '\'' +
                ", markerWidth=" + markerWidth +
                ", markerHeight=" + markerHeight +
                ", refX=" + refX +
                ", refY=" + refY +
                ", dim='" + dim + '\'' +
                ", color='" + color + '\'' +
                ", storkColor='" + storkColor + '\'' +
                ", storkWidth='" + storkWidth + '\'' +
                ", style='" + style + '\'' +
                '}';
    }
}
