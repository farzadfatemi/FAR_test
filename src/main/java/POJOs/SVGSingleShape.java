package POJOs;


import java.util.Map;

/**
 * Created by VOLCANO on 4/26/2017.
 */
public class SVGSingleShape {
    private int x;
    private int y;
    private int width;
    private int height;
    private String id;
    private String name;
    private String fillColor;
    private String strokeColor;
    private int strokeWidth;
    private String type;
    private String connectionsType;
    private String documentation;
    private String targetId;
    private String font;
    private String fontColor;
    private Map<String,String> connections;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFillColor() {
        return fillColor;
    }

    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    public String getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(String strokeColor) {
        this.strokeColor = strokeColor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConnectionsType() {
        return connectionsType;
    }

    public void setConnectionsType(String connectionsType) {
        this.connectionsType = connectionsType;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public Map<String,String> getConnections() {
        return connections;
    }

    public void setConnections(Map<String,String> connections) {
        this.connections = connections;
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    @Override
    public String toString() {
        return "SVGSingleShape{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", fillColor='" + fillColor + '\'' +
                ", strokeColor='" + strokeColor + '\'' +
                ", strokeWidth=" + strokeWidth +
                ", type='" + type + '\'' +
                ", connectionsType=" + connectionsType +
                ", documentation='" + documentation + '\'' +
                ", targetId='" + targetId + '\'' +
                ", font='" + font + '\'' +
                ", fontColor='" + fontColor + '\'' +
                ", connections=" + connections +
                '}';
    }
}
