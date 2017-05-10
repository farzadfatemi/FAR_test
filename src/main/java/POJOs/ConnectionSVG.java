package POJOs;

import java.util.Arrays;
import java.util.List;

/**
 * Created by FARzad - VOLCANO on 5/3/2017.
 */
public class ConnectionSVG {
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private int width;
    private int[] dashArray;
    private String id;
    private String color;
    private String type;
    private String name;
    private List<BendPoints> bindPoints;

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int[] getDashArray() {
        return dashArray;
    }

    public void setDashArray(int[] dashArray) {
        this.dashArray = dashArray;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BendPoints> getBindPoints() {
        return bindPoints;
    }

    public void setBindPoints(List<BendPoints> bindPoints) {
        this.bindPoints = bindPoints;
    }

    @Override
    public String toString() {
        return "ConnectionSVG{" +
                "x1=" + x1 +
                ", x2=" + x2 +
                ", y1=" + y1 +
                ", y2=" + y2 +
                ", width=" + width +
                ", dashArray=" + Arrays.toString(dashArray) +
                ", id='" + id + '\'' +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
    private class BendPoints{
        private String startX;
        private String startY;
        private String endX;
        private String endY;

        public String getStartX() {
            return startX;
        }

        public void setStartX(String startX) {
            this.startX = startX;
        }

        public String getStartY() {
            return startY;
        }

        public void setStartY(String startY) {
            this.startY = startY;
        }

        public String getEndX() {
            return endX;
        }

        public void setEndX(String endX) {
            this.endX = endX;
        }

        public String getEndY() {
            return endY;
        }

        public void setEndY(String endY) {
            this.endY = endY;
        }
    }
}
