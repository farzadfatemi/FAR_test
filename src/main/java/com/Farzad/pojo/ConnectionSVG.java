package com.farzad.pojo;

import com.farzad.utils.image.BendPoints;

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
    private String sourceId;
    private String targetId;
    private String sourceName;
    private String targetName;
    private String color;
    private String type;
    private String name;
    private boolean ownConnection;
    private SVGSingleShape source;
    private SVGSingleShape target;

    private List<BendPoints> bendPointses;

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

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
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

    public boolean isOwnConnection() {
        return ownConnection;
    }

    public void setOwnConnection(boolean ownConnection) {
        this.ownConnection = ownConnection;
    }

    public SVGSingleShape getSource() {
        return source;
    }

    public void setSource(SVGSingleShape source) {
        this.source = source;
    }

    public SVGSingleShape getTarget() {
        return target;
    }

    public void setTarget(SVGSingleShape target) {
        this.target = target;
    }

    public List<BendPoints> getBendPointses() {
        return bendPointses;
    }

    public void setBendPointses(List<BendPoints> bendPointses) {
        this.bendPointses = bendPointses;
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
                ", sourceId='" + sourceId + '\'' +
                ", targetId='" + targetId + '\'' +
                ", sourceName='" + sourceName + '\'' +
                ", targetName='" + targetName + '\'' +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", ownConnection=" + ownConnection +
                ", source=" + source +
                ", target=" + target +
                ", bendPointses=" + bendPointses +
                '}';
    }


}
