package POJOs;


import com.Farzad.utils.ImageUtils.BendPoints;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by VOLCANO on 4/26/2017.
 */
public class SVGSingleShape {
    private int x;
    private int y;
    private int width;
    private int height;
    private int rx;
    private int ry;
    private int[][] polyDem;
    private String id;
    private String name;
    private String fillColor;
    private String strokeColor;
    private int strokeWidth;
    private String type;
    private String elementType;
    private String connectionsName;
    private String connectionsType;
    private List<BendPoints> connectionBendPointsList;
    private String documentation;
    private String targetId;
    private String font;
    private int fontSize;
    private String fontColor;
    private String textAlignment;
    private String URL;
    private Map<String, String> connections;
    private boolean hasChild;

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

    public int getRx() {
        return rx;
    }

    public void setRx(int rx) {
        this.rx = rx;
    }

    public int getRy() {
        return ry;
    }

    public void setRy(int ry) {
        this.ry = ry;
    }

    public int[][] getPolyDem() {
        return polyDem;
    }

    public void setPolyDem(int[][] polyDem) {
        this.polyDem = polyDem;
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

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public String getConnectionsType() {
        return connectionsType;
    }

    public void setConnectionsType(String connectionsType) {
        this.connectionsType = connectionsType;
    }

    public String getConnectionsName() {
        return connectionsName;
    }

    public void setConnectionsName(String connectionsName) {
        this.connectionsName = connectionsName;
    }

    public List<BendPoints> getConnectionBendPointsList() {
        return connectionBendPointsList;
    }

    public void setConnectionBendPointsList(List<BendPoints> connectionBendPointsList) {
        this.connectionBendPointsList = connectionBendPointsList;
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

    public Map<String, String> getConnections() {
        return connections;
    }

    public void setConnections(Map<String, String> connections) {
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

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    public String getTextAlignment() {
        return textAlignment;
    }

    public void setTextAlignment(String textAlignment) {
        this.textAlignment = textAlignment;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public boolean hasAnyChild() {
        return hasChild;
    }

    public void setHasChild(boolean hasChild) {
        this.hasChild = hasChild;
    }

    @Override
    public String toString() {
        return "SVGSingleShape{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                ", rx=" + rx +
                ", ry=" + ry +
                ", polyDem=" + Arrays.toString(polyDem) +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", fillColor='" + fillColor + '\'' +
                ", strokeColor='" + strokeColor + '\'' +
                ", strokeWidth=" + strokeWidth +
                ", type='" + type + '\'' +
                ", elementType='" + elementType + '\'' +
                ", connectionsName='" + connectionsName + '\'' +
                ", connectionsType='" + connectionsType + '\'' +
                ", connectionBendPointsList=" + connectionBendPointsList +
                ", documentation='" + documentation + '\'' +
                ", targetId='" + targetId + '\'' +
                ", font='" + font + '\'' +
                ", fontSize=" + fontSize +
                ", fontColor='" + fontColor + '\'' +
                ", textAlignment='" + textAlignment + '\'' +
                ", URL='" + URL + '\'' +
                ", connections=" + connections +
                ", hasChild=" + hasChild +
                '}';
    }

}
