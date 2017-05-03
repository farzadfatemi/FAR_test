package com.Farzad.Enums;

import POJOs.SVGSingleShape;

/**
 * Created by VOLCANO on 4/28/2017.
 */
public enum ConnectionsEnum {
    ACCESSES ("accesses"),
    USED_BY("used by"),
    ASSIGNED("assigned"),
    USES("uses"),
    AGGREGATION("aggregation"),
    ASSOCIATION("association"),
    REALISES("realises"),
    READ_AND_WRITE("read/write");
    private final java.lang.String name;

    public boolean equalsName(java.lang.String otherName) {
        // (otherName == null) check is not needed because name.equals(null) returns false
        return name.equals(otherName);
    }

    public java.lang.String toString() {
        return this.name;
    }

    private ConnectionsEnum(java.lang.String s) {
        name = s;
    }

    public java.lang.String








    lineSVGCode(SVGSingleShape source, SVGSingleShape target) {
        int x1 = source.getX() + source.getWidth();
        int x2 = target.getX();
        int y1 = source.getY();
        int y2 = target.getY();
        int lineWidth = source.getStrokeWidth();
        switch (this) {
            case ACCESSES:
                return  " <circle cx=\"" + x1 + "\" cy=\"" + y1 + "\" r=\"3\" fill=\"#000000\" />" +
                        "      <line stroke-dasharray=\"2, 2\" fill=\"black\" x1=\"" + x1 + "\" x2=\"" + x2 + "\" y1=\"" + y1 + "\" y2=\"" + y2 + "\" " +
                        "stroke=\"#000000\" stroke-width=\"" + lineWidth + "\"/>\n" +
                        "<circle cx=\"" + x2 + "\" cy=\"" + y2 + "\" r=\"3\" fill=\"#000000\" />";
            case USED_BY:
                return
// " <polygon points=\"" + x1 + "," + y1 + " " + (x1+20) + "," + (y1-10) + " " + (x1+40) + "," + y1 + " " + (x1+50) + "," + (y1+10) + "\"/>" +
                        "      <line fill=\"black\" x1=\"" + x1 + "\" x2=\"" + x2 + "\" y1=\"" + y1 + "\" y2=\"" + y2 + "\" " +
                        "stroke=\"#000000\" stroke-width=\"" + lineWidth + "\"/>\n" +
                        "<circle cx=\"" + x2 + "\" cy=\"" + y2 + "\" r=\"3\" fill=\"#000000\" />";
            case ASSIGNED:
                return  " <circle cx=\"" + x1 + "\" cy=\"" + y1 + "\" r=\"3\" fill=\"#000000\" />" +
                        "      <line fill=\"black\" x1=\"" + x1 + "\" x2=\"" + x2 + "\" y1=\"" + y1 + "\" y2=\"" + y2 + "\" " +
                        "stroke=\"#000000\" stroke-width=\"" + lineWidth + "\"/>\n" +
                        "<circle cx=\"" + x2 + "\" cy=\"" + y2 + "\" r=\"3\" fill=\"#000000\" />";
            case REALISES:
                return  " <circle cx=\"" + x1 + "\" cy=\"" + y1 + "\" r=\"3\" fill=\"#000000\" />" +
                        "      <line stroke-dasharray=\"5, 5\" fill=\"black\" x1=\"" + x1 + "\" x2=\"" + x2 + "\" y1=\"" + y1 + "\" y2=\"" + y2 + "\" " +
                        "stroke=\"#000000\" stroke-width=\"" + lineWidth + "\"/>\n" +
                        "<circle cx=\"" + x2 + "\" cy=\"" + y2 + "\" r=\"3\" fill=\"#000000\" />";
             case USES:
                return  " <circle cx=\"" + x1 + "\" cy=\"" + y1 + "\" r=\"3\" fill=\"#000000\" />" +
                        "      <line fill=\"black\" x1=\"" + x1 + "\" x2=\"" + x2 + "\" y1=\"" + y1 + "\" y2=\"" + y2 + "\" " +
                        "stroke=\"#000000\" stroke-width=\"" + lineWidth + "\"/>\n" +
                        "<circle cx=\"" + x2 + "\" cy=\"" + y2 + "\" r=\"3\" fill=\"#000000\" />";
             case AGGREGATION:
                return  " <circle cx=\"" + x1 + "\" cy=\"" + y1 + "\" r=\"3\" fill=\"#000000\" />" +
                        "      <line fill=\"black\" x1=\"" + x1 + "\" x2=\"" + x2 + "\" y1=\"" + y1 + "\" y2=\"" + y2 + "\" " +
                        "stroke=\"#000000\" stroke-width=\"" + lineWidth + "\"/>\n" +
                        "<circle cx=\"" + x2 + "\" cy=\"" + y2 + "\" r=\"3\" fill=\"#000000\" />";
             case ASSOCIATION:
                return  " <circle cx=\"" + x1 + "\" cy=\"" + y1 + "\" r=\"3\" fill=\"#000000\" />" +
                        "      <line fill=\"black\" x1=\"" + x1 + "\" x2=\"" + x2 + "\" y1=\"" + y1 + "\" y2=\"" + y2 + "\" " +
                        "stroke=\"#000000\" stroke-width=\"" + lineWidth + "\"/>\n" +
                        "<circle cx=\"" + x2 + "\" cy=\"" + y2 + "\" r=\"3\" fill=\"#000000\" />";
            case READ_AND_WRITE:
                return  " <circle cx=\"" + x1 + "\" cy=\"" + y1 + "\" r=\"3\" fill=\"#000000\" />" +
                        "      <line fill=\"black\" x1=\"" + x1 + "\" x2=\"" + x2 + "\" y1=\"" + y1 + "\" y2=\"" + y2 + "\" " +
                        "stroke=\"#000000\" stroke-width=\"" + lineWidth + "\"/>\n" +
                        "<circle cx=\"" + x2 + "\" cy=\"" + y2 + "\" r=\"3\" fill=\"#000000\" />";
            default:
                return  " <circle cx=\"" + x1 + "\" cy=\"" + y1 + "\" r=\"3\" fill=\"#000000\" />" +
                        "      <line fill=\"black\" x1=\"" + x1 + "\" x2=\"" + x2 + "\" y1=\"" + y1 + "\" y2=\"" + y2 + "\" " +
                        "stroke=\"#000000\" stroke-width=\"" + lineWidth + "\"/>\n" +
                        "<circle cx=\"" + x2 + "\" cy=\"" + y2 + "\" r=\"3\" fill=\"#000000\" />";
        }
    }
}
