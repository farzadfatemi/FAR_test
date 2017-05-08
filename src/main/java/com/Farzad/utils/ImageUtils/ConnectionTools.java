package com.Farzad.utils.ImageUtils;

import POJOs.ArrowSVG;
import POJOs.ConnectionSVG;
import POJOs.SVGSingleShape;
import com.Farzad.Enums.ArrowsTypeEnum;
import com.Farzad.Enums.ConnectionsEnum;

/**
 * Created by VOLCANO on 5/1/2017.
 */
class ConnectionTools {
    private static int maxX = 0;

    static String getSVGline(SVGSingleShape source, SVGSingleShape target) {
//        System.out.println(source !=null?source.getName() +" target id : "+target.getId()+" target name : "+target.getName():"nuuul");
        if (source != null && source.getConnectionsType() != null) {
//            System.out.println(source.getConnectionsType()+"--**--"+source.getName()+" target id : "+target.getId()+" target name : "+target.getName());
            if (ConnectionsEnum.ACCESSES.equalsName(source.getConnectionsType().toLowerCase())) {
                return lineSVGCode(source, target, ConnectionsEnum.ACCESSES);
            } else if (ConnectionsEnum.ASSIGNED.equalsName(source.getConnectionsType().toLowerCase())) {
                return lineSVGCode(source, target, ConnectionsEnum.ASSIGNED);
            } else if (ConnectionsEnum.AGGREGATION.equalsName(source.getConnectionsType().toLowerCase())) {
                return lineSVGCode(source, target, ConnectionsEnum.AGGREGATION);
            } else if (ConnectionsEnum.ASSOCIATION.equalsName(source.getConnectionsType().toLowerCase())) {
                return lineSVGCode(source, target, ConnectionsEnum.ASSOCIATION);
            } else if (ConnectionsEnum.USES.equalsName(source.getConnectionsType().toLowerCase())) {
                return lineSVGCode(source, target, ConnectionsEnum.USES);
            } else if (ConnectionsEnum.USED_BY.equalsName(source.getConnectionsType().toLowerCase())) {
                return lineSVGCode(source, target, ConnectionsEnum.USED_BY);
            } else if (ConnectionsEnum.REALISES.equalsName(source.getConnectionsType().toLowerCase())) {
                return lineSVGCode(source, target, ConnectionsEnum.REALISES);
            } else if (ConnectionsEnum.READ_AND_WRITE.equalsName(source.getConnectionsType().toLowerCase())) {
                return lineSVGCode(source, target, ConnectionsEnum.READ_AND_WRITE);
            } else if (ConnectionsEnum.COMPOSITION.equalsName(source.getConnectionsType().toLowerCase())) {
                return lineSVGCode(source, target, ConnectionsEnum.COMPOSITION);
            } else
                return null;
//            int x1 = source.getX() + source.getWidth();
//            int x2 = target.getX();
//            int y1 = source.getY();
//            int y2 = target.getY();
//            return ""
//                    +
//                    "<svg>" +
//                    " <circle cx=\"" + x1 + "\" cy=\"" + y1 + "\" r=\"3\" fill=\"#000000\" />" +
//                    "      <line fill=\"black\" x1=\"" + x1 + "\" x2=\"" + x2 + "\" y1=\"" + y1 + "\" y2=\"" + y2 + "\" " +
//                    "stroke=\"#000000\" stroke-width=\"" + source.getStrokeWidth() + "\"/>\n" +
//                    "<circle cx=\"" + x2 + "\" cy=\"" + y2 + "\" r=\"3\" fill=\"#000000\" />" +
//                    "</svg>"
//                    ;

        } else
            return source != null ? source.getName() : null;

    }

    private static String lineSVGCode(SVGSingleShape source, SVGSingleShape target, ConnectionsEnum connectionEnum) {
        ConnectionSVG conSVG = positionCondition(source, target);
//        ConnectionSVG conSVG = new ConnectionSVG();
//        conSVG.setX1(source.getX() + source.getWidth() / 2);
//        conSVG.setX2(target.getX() + target.getWidth() / 2);
//        conSVG.setY1(source.getY());
//        conSVG.setY2(target.getY());
//        conSVG.setWidth(source.getStrokeWidth());
        conSVG.setColor("black");
//        int lineWidth = source.getStrokeWidth();
        source.setFontSize(11);
        switch (connectionEnum) {
            case ACCESSES:
                return (makeLine(conSVG) + putText(conSVG, source));
//              return  " <circle cx=\"" + x1 + "\" cy=\"" + y1 + "\" r=\"3\" fill=\"#000000\" />" +
//                        "      <line stroke-dasharray=\"2, 2\" fill=\"black\" x1=\"" + x1 + "\" x2=\"" + x2 + "\" y1=\"" + y1 + "\" y2=\"" + y2 + "\" " +
//                        "stroke=\"#000000\" stroke-width=\"" + lineWidth + "\"/>\n" +
//                        "<circle cx=\"" + x2 + "\" cy=\"" + y2 + "\" r=\"3\" fill=\"#000000\" />";
            case USED_BY:
                return (makeArrows(conSVG, ArrowsTypeEnum.V_TYPE) + putText(conSVG, source));
//              " <polygon points=\"" + x1 + "," + y1 + " " + (x1+20) + "," + (y1-10) + " " + (x1+40) + "," + y1 + " " + (x1+50) + "," + (y1+10) + "\"/>" +
//                        "      <line fill=\"black\" x1=\"" + x1 + "\" x2=\"" + x2 + "\" y1=\"" + y1 + "\" y2=\"" + y2 + "\" " +
//                                "stroke=\"#000000\" stroke-width=\"" + lineWidth + "\"/>\n" +
//                                "<circle cx=\"" + x2 + "\" cy=\"" + y2 + "\" r=\"3\" fill=\"#000000\" />"+
//                                "      <text x=\"" + (x1+x2)/2 + "\" xml:space=\"preserve\" y=\"" + (y1+y2)/2 + "\" clip-path=\"url(#clipPath20)\" stroke=\"none\"\n" +
//                                "      font-family=\"" + source.getFont() + "\" fill=\"#000000\"  >" + source.getConnectionsType() + "</text>\n"
//                        ;
            case ASSIGNED:
                return (makeLineWithDoubleOrb(makeLine(conSVG), conSVG) + putText(conSVG, source));
//                return  " <circle cx=\"" + x1 + "\" cy=\"" + y1 + "\" r=\"3\" fill=\"#000000\" />" +
//                        "      <line fill=\"black\" x1=\"" + x1 + "\" x2=\"" + x2 + "\" y1=\"" + y1 + "\" y2=\"" + y2 + "\" " +
//                        "stroke=\"#000000\" stroke-width=\"" + lineWidth + "\"/>\n" +
//                        "<circle cx=\"" + x2 + "\" cy=\"" + y2 + "\" r=\"3\" fill=\"#000000\" />";
            case REALISES:
                conSVG.setDashArray(new int[]{5, 5});
                return (makeArrows(conSVG, ArrowsTypeEnum.TRIANGLE_WHITE) + putText(conSVG, source));
//                return  " <circle cx=\"" + x1 + "\" cy=\"" + y1 + "\" r=\"3\" fill=\"#000000\" />" +
//                        "      <line stroke-dasharray=\"5, 5\" fill=\"black\" x1=\"" + x1 + "\" x2=\"" + x2 + "\" y1=\"" + y1 + "\" y2=\"" + y2 + "\" " +
//                        "stroke=\"#000000\" stroke-width=\"" + lineWidth + "\"/>\n" +
//                        "<circle cx=\"" + x2 + "\" cy=\"" + y2 + "\" r=\"3\" fill=\"#000000\" />";
            case USES:
                return (makeArrows(conSVG, ArrowsTypeEnum.V_TYPE) + putText(conSVG, source));
//                return  " <circle cx=\"" + x1 + "\" cy=\"" + y1 + "\" r=\"3\" fill=\"#000000\" />" +
//                        "      <line fill=\"black\" x1=\"" + x1 + "\" x2=\"" + x2 + "\" y1=\"" + y1 + "\" y2=\"" + y2 + "\" " +
//                        "stroke=\"#000000\" stroke-width=\"" + lineWidth + "\"/>\n" +
//                        "<circle cx=\"" + x2 + "\" cy=\"" + y2 + "\" r=\"3\" fill=\"#000000\" />";
            case AGGREGATION:
                return (makeArrows(conSVG, ArrowsTypeEnum.DIAMOND_WHITE) + putText(conSVG, source));
//                return  " <circle cx=\"" + x1 + "\" cy=\"" + y1 + "\" r=\"3\" fill=\"#000000\" />" +
//                        "      <line fill=\"black\" x1=\"" + x1 + "\" x2=\"" + x2 + "\" y1=\"" + y1 + "\" y2=\"" + y2 + "\" " +
//                        "stroke=\"#000000\" stroke-width=\"" + lineWidth + "\"/>\n" +
//                        "<circle cx=\"" + x2 + "\" cy=\"" + y2 + "\" r=\"3\" fill=\"#000000\" />";
            case ASSOCIATION:
                return (makeLine(conSVG) + putText(conSVG, source));
//                return  " <circle cx=\"" + x1 + "\" cy=\"" + y1 + "\" r=\"3\" fill=\"#000000\" />" +
//                        "      <line fill=\"black\" x1=\"" + x1 + "\" x2=\"" + x2 + "\" y1=\"" + y1 + "\" y2=\"" + y2 + "\" " +
//                        "stroke=\"#000000\" stroke-width=\"" + lineWidth + "\"/>\n" +
//                        "<circle cx=\"" + x2 + "\" cy=\"" + y2 + "\" r=\"3\" fill=\"#000000\" />";
            case READ_AND_WRITE:
                conSVG.setDashArray(new int[]{2, 2});
                return (makeArrows(conSVG, ArrowsTypeEnum.DOUBLE_V_TYPE) + putText(conSVG, source));

            case COMPOSITION:
                return (makeArrows(conSVG, ArrowsTypeEnum.DIAMOND_BLACK) + putText(conSVG, source));
//                return  " <circle cx=\"" + x1 + "\" cy=\"" + y1 + "\" r=\"3\" fill=\"#000000\" />" +
//                        "      <line fill=\"black\" x1=\"" + x1 + "\" x2=\"" + x2 + "\" y1=\"" + y1 + "\" y2=\"" + y2 + "\" " +
//                        "stroke=\"#000000\" stroke-width=\"" + lineWidth + "\"/>\n" +
//                        "<circle cx=\"" + x2 + "\" cy=\"" + y2 + "\" r=\"3\" fill=\"#000000\" />";
            default:
                return (makeLine(conSVG) + putText(conSVG, source));
//                return  " <circle cx=\"" + x1 + "\" cy=\"" + y1 + "\" r=\"3\" fill=\"#000000\" />" +
//                        "      <line fill=\"black\" x1=\"" + x1 + "\" x2=\"" + x2 + "\" y1=\"" + y1 + "\" y2=\"" + y2 + "\" " +
//                        "stroke=\"#000000\" stroke-width=\"" + lineWidth + "\"/>\n" +
//                        "<circle cx=\"" + x2 + "\" cy=\"" + y2 + "\" r=\"3\" fill=\"#000000\" />";
        }
    }

    private static String makeLine(ConnectionSVG conSvg) {
        int dashWidth = 0, dashGap = 0;
        if (conSvg.getDashArray() != null && conSvg.getDashArray().length > 1) {
            dashWidth = conSvg.getDashArray()[0];
            dashGap = conSvg.getDashArray()[1];
        }
        return "<line fill=\"black\" stroke-dasharray=\"" + dashWidth + "," + dashGap + "\" x1=\"" + conSvg.getX1() + "\" x2=\"" + conSvg.getX2() + "\" y1=\"" + conSvg.getY1() + "\" y2=\"" + conSvg.getY2() + "\" " +
                "stroke=\"" + conSvg.getColor() + "\" stroke-width=\"" + conSvg.getWidth() + "\"/>\n";


    }

    private static String makeLineWithDoubleOrb(String line, ConnectionSVG svg) {

        return " <circle cx=\"" + svg.getX1() + "\" cy=\"" + svg.getY1() + "\" r=\"3\" fill=\"" + svg.getColor() + "\" />" +
                line +
                "<circle cx=\"" + svg.getX2() + "\" cy=\"" + svg.getY2() + "\" r=\"3\" fill=\"" + svg.getColor() + "\" />";
    }

    private static String makeSingleOrb(ConnectionSVG svg, int x, int y) {

        return " <circle cx=\"" + x + "\" cy=\"" + y + "\" r=\"3\" fill=\"" + svg.getColor() + "\" />";

    }

    private static String putText(ConnectionSVG svg, SVGSingleShape source) {
        int[] xy = getTextDirection(svg);
        String path = "<defs>\n" +
                "    <path id=\"Txt-" + svg.getId() + "\"\n" +
//                "          d=\"M " + (xy[0]-(source.getConnectionsType() !=null?source.getConnectionsType().length()/2:0)) + " " + (xy[1]-(source.getConnectionsType() !=null?source.getConnectionsType().length()/2:0)) + " \n" +
                "          d=\"M " + xy[0] + " " + xy[1] + " \n" +
                "             L " + xy[2] + " " + xy[3] + "\"/>\n" +
                "  </defs>\n";
        return (source.getConnectionsType() != null ? path + "<text font-size=\"" + source.getFontSize() + "\" font-family=\" " + source.getFont() + "\" fill=\"#000000\" stroke=\"none\">\n" +
                "<textPath   x=\""+(xy[0]+xy[2]/2)+"\" y=\""+(xy[1]+xy[3]/2)+"\" xlink:href=\"#Txt-" + svg.getId() + "\"> " +
                source.getConnectionsType() +
                "    </textPath>" +
                " </text>\n" : "");
    }
private static int[] getTextDirection(ConnectionSVG svg) {
    System.out.println("xxxxxx x1 : "+svg.getX1()+" x2 : "+svg.getX2()+" y1 : "+svg.getY1()+" y2 :  "+svg.getY2());
//    int x1 = ((svg.getX2() + svg.getX1() + 2) / 2);
    int x1 = ((svg.getX2() + svg.getX1() + 2) / 2);
    int x2  ;
//    int y1 = ((svg.getY2() + svg.getY1() + 2) / 2);
    int y1 = ((svg.getY2() + svg.getY1() + 2) / 2);
    int y2 ;
        if(svg.getX2()>svg.getX1()){
            if(svg.getY2()>svg.getY1()){
                x2 = svg.getX2();
                y2 = svg.getY1();
            }else{
                x2 = svg.getX2();
                y2 = svg.getY2();
            }
        }else {
            if(svg.getY2()>svg.getY1()){
                x2 = svg.getX1();
                y2 = svg.getY1();
            }else{
                x2 = svg.getX1();
                y2 = svg.getY1();
            }
        }


    System.out.println("xxxxxx x1 : "+x1+" x2 : "+x2+" y1 : "+y1+" y2 :  "+y2);

    return new int[]{x1,y1,x2,y2};
    }

    private static String makeArrows(ConnectionSVG conSvg, ArrowsTypeEnum arrowsType) {
        ArrowSVG arrowSVG = new ArrowSVG();
        ArrowSVG arrowSVG2 = null;
        int dashWidth = 0, dashGap = 0;
        if (conSvg.getDashArray() != null && conSvg.getDashArray().length > 1) {
            dashWidth = conSvg.getDashArray()[0];
            dashGap = conSvg.getDashArray()[1];
        }
        arrowSVG.setId(conSvg.getId());
        switch (arrowsType) {
            case TRIANGLE_BLACK:
                arrowSVG.setDim("M2,2 L2,13 L8,7 L2,2");
                arrowSVG.setMarkerWidth(13);
                arrowSVG.setMarkerHeight(13);
                arrowSVG.setRefX(8);
                arrowSVG.setRefY(7);
                arrowSVG.setColor("#000000");
                break;
            case TRIANGLE_WHITE:
                arrowSVG.setDim("M2,2 L2,13 L8,7 L2,2");
                arrowSVG.setMarkerWidth(13);
                arrowSVG.setMarkerHeight(13);
                arrowSVG.setRefX(8);
                arrowSVG.setRefY(7);
                arrowSVG.setColor("#ffffff");
                break;
            case V_TYPE:
                arrowSVG.setDim("M2,2 L8,7 L2,13 L8,7 L2,2");
                arrowSVG.setMarkerWidth(13);
                arrowSVG.setMarkerHeight(13);
                arrowSVG.setRefX(8);
                arrowSVG.setRefY(7);
                arrowSVG.setColor("#000000");
                break;
            case DOUBLE_V_TYPE:
                arrowSVG.setDim("M2,2 L8,7 L2,13 L8,7 L2,2");
                arrowSVG.setMarkerWidth(13);
                arrowSVG.setMarkerHeight(13);
                arrowSVG.setRefX(8);
                arrowSVG.setRefY(7);
                arrowSVG.setColor("#000000");
                arrowSVG2 = new ArrowSVG();
                arrowSVG2.setDim("M8,8 L2,13 L8,18 L2,13 L8,8");
                arrowSVG2.setMarkerWidth(16);
                arrowSVG2.setMarkerHeight(18);
                arrowSVG2.setRefX(5);
                arrowSVG2.setRefY(13);
                arrowSVG2.setColor("#000000");
                break;
            case DIAMOND_WHITE:
                arrowSVG.setDim("M8,8 L14,11 L8,14 L2,11 L8,8");
                arrowSVG.setMarkerWidth(16);
                arrowSVG.setMarkerHeight(16);
                arrowSVG.setRefX(8);
                arrowSVG.setRefY(11);
                arrowSVG.setColor("#ffffff");
                break;
            case DIAMOND_BLACK:
                arrowSVG.setDim("M8,8 L14,11 L8,14 L2,11 L8,8");
                arrowSVG.setMarkerWidth(16);
                arrowSVG.setMarkerHeight(16);
                arrowSVG.setRefX(8);
                arrowSVG.setRefY(11);
                arrowSVG.setColor("#000000");
                break;
        }
        String result = "<defs> " +
                "   <marker id=\"" + arrowSVG.getId() + "\" markerWidth=\"" + arrowSVG.getMarkerWidth() + "\" markerHeight=\"" + arrowSVG.getMarkerHeight() + "\" refX=\"" + arrowSVG.getRefX() + "\" refY=\"" + arrowSVG.getRefY() + "\" orient=\"auto\" >\n" +
                "        <path d=\"" + arrowSVG.getDim() + "\"  stroke=\"black\"  style=\"fill:" + arrowSVG.getColor() + "\";\" />" +
                "  </marker>";
        if (arrowsType.equals(ArrowsTypeEnum.DOUBLE_V_TYPE) && arrowSVG2 != null) {
            result += "   <marker id=\"" + (arrowSVG.getId() + "2") + "\" markerWidth=\"" + arrowSVG2.getMarkerWidth() + "\" markerHeight=\"" + arrowSVG2.getMarkerHeight() + "\" refX=\"" + arrowSVG2.getRefX() + "\" refY=\"" + arrowSVG2.getRefY() + "\" orient=\"auto\" >\n" +
                    "        <path d=\"" + arrowSVG2.getDim() + "\"  stroke=\"black\"  style=\"fill:" + arrowSVG2.getColor() + "\";\" />" +
                    "  </marker>";
        }
        result += "</defs>;\n <path d=\"M" + conSvg.getX1() + "," + conSvg.getY1() + " L" + (conSvg.getX2() - 5) + "," + (conSvg.getY2() - 5) + "\" stroke-dasharray=\"" + dashWidth + "," + dashGap + " \" stroke=\"" + conSvg.getColor() + "\" stroke-width=\"" + conSvg.getWidth() + "\" \n" +
                "style=\"" + (arrowsType.equals(ArrowsTypeEnum.DOUBLE_V_TYPE) ? " marker-start: url(#" + (arrowSVG.getId() + "2") + ");" : "") + " marker-end: url(#" + conSvg.getId() + ");\"/>"
        ;

        return result;


    }

    private static ConnectionSVG positionCondition(SVGSingleShape source, SVGSingleShape target) {


        if (source == null || target == null) return null;
        int x1 = source.getX();
        int x11 = source.getWidth();
        int y1 = source.getY();
        int y11 = source.getHeight();
        int x2 = target.getX();
        int x22 = target.getWidth();
        int y2 = target.getY();
        int y22 = target.getHeight();
        if (x1 + x11 > maxX) maxX = x1 + x11;
        if (x2 + x22 > maxX) maxX = x2 + x22;
        ConnectionSVG conSVG = new ConnectionSVG();
        conSVG.setId(source.getId() + "-" + target.getId());
        conSVG.setWidth(1);
//        System.out.println("--00---------> Source name : " + source.getName() + " source.getX() = " + source.getX() + " - source.Width() = " + source.getWidth() + " - source.getX()+Width() = " + (source.getX() + source.getWidth()));
//        System.out.println("--00---------> source.getY() = " + source.getY() + " source.getHeight() = " + source.getHeight() + " - source.getY()+Height = " + (source.getY() + source.getHeight()));
//        System.out.println("--00---------> Target name : " + target.getName() + " target.getX() = " + target.getX() + " - target.Width() = " + target.getWidth() + " - target.getX()+Width() = " + (target.getX() + target.getWidth()));
//        System.out.println("--00---------> target.getY() = " + target.getY() + " - target.getHeight() = " + target.getHeight() + " - target.getY()+Height = " + (target.getY() + target.getHeight()));
        if (x1 > x2) {
            System.out.println("---> x1>x2");
            if (x1 > (x2 + x22)) {
                System.out.println("----> x1>(x2+x22)");
                if (y1 > y2) {
                    System.out.println("-----> y1>y2)");
                    if (y1 > (y2 + y22)) {
                        System.out.println("------> y1>(y2+y22)");
                        conSVG.setX1(source.getX());
                        conSVG.setX2(target.getX() + target.getWidth());
                        conSVG.setY1(source.getY());
                        conSVG.setY2(target.getY() + target.getHeight());
                    } else {
                        System.out.println("------> y1<=(y2+y22)");
                        conSVG.setX1(source.getX());
                        conSVG.setX2(target.getX() + target.getWidth());
                        conSVG.setY1(source.getY() + source.getHeight() / 2);
                        conSVG.setY2(target.getY() + target.getHeight() / 2);
                    }
                } else {
                    System.out.println("-----> y1<y2)");
                    if (y2 > (y1 + y11)) {
                        System.out.println("----> y2>(y1+y11)");
                        conSVG.setX1(source.getX());
                        conSVG.setX2(target.getX() + target.getWidth());
                        conSVG.setY1(source.getY() + source.getHeight());
                        conSVG.setY2(target.getY());
                    } else {
                        System.out.println("----> y2<=(y1+y11)");
                        conSVG.setX1(source.getX());
                        conSVG.setX2(target.getX() + target.getWidth());
                        conSVG.setY1(source.getY() + source.getHeight() / 2);
                        conSVG.setY2(target.getY() + target.getHeight() / 2);
                    }
                }

            } else {
                System.out.println("----> x1<=(x2+x22)");
                if (y1 > y2) {
                    System.out.println("-----> y1>y2");
                    if (y1 > (y2 + y22)) {
                        System.out.println("------> y1>(y2+y22)");
                        conSVG.setX1(source.getX() + source.getWidth() / 2);
                        conSVG.setX2(target.getX() + target.getWidth() / 2);
                        conSVG.setY1(source.getY());
                        conSVG.setY2(target.getY() + target.getHeight());
                    } else {
                        System.out.println("------> y1<=(y2+y22)");
                        conSVG.setX1(source.getX());
                        conSVG.setX2(target.getX() + target.getWidth());
                        conSVG.setY1(source.getY() + source.getHeight() / 2);
                        conSVG.setY2(target.getY() + target.getHeight() / 2);
                    }
                } else {
                    if (y2 > (y1 + y11)) {
                        System.out.println("----> y2>(y1+y11)");
                        conSVG.setX1(source.getX() + source.getWidth() / 2);
                        conSVG.setX2(target.getX() + target.getWidth() / 2);
                        conSVG.setY1(source.getY() + source.getHeight());
                        conSVG.setY2(target.getY());
                    } else {
                        System.out.println("----> y2<=(y1+y11)");
                        conSVG.setX1(source.getX());
                        conSVG.setX2(target.getX() + target.getWidth() / 2);
                        conSVG.setY1(source.getY() + source.getHeight() / 2);
                        conSVG.setY2(target.getY() + target.getHeight());
                    }
                }
            }
        } else {
            System.out.println("---> x2>x1");
            if (x2 > (x1 + x11)) {
                System.out.println("----> x2>(x1+x11)");
                if (y1 > y2) {
                    System.out.println("-----> y1>y2)");
                    if (y1 > (y2 + y22)) {
                        System.out.println("------> y1>(y2+y22)");
                        conSVG.setX1(source.getX() + source.getWidth());
                        conSVG.setX2(target.getX());
                        conSVG.setY1(source.getY());
                        conSVG.setY2(target.getY() + target.getHeight());
                    } else {
                        System.out.println("------> y1<=(y2+y22)");
                        conSVG.setX1(source.getX() + source.getWidth());
                        conSVG.setX2(target.getX());
                        conSVG.setY1(source.getY() + source.getHeight() / 2);
                        conSVG.setY2(target.getY() + target.getHeight() / 2);
                    }
                } else {
                    if (y2 > (y1 + y11)) {
                        System.out.println("----> y2>(y1+y11)");
                        conSVG.setX1(source.getX() + source.getWidth());
                        conSVG.setX2(target.getX());
                        conSVG.setY1(source.getY() + source.getHeight());
                        conSVG.setY2(target.getY());
                    } else {
                        System.out.println("------> y2<=(y1+y11)");
                        conSVG.setX1(source.getX() + source.getWidth());
                        conSVG.setX2(target.getX());
                        conSVG.setY1(source.getY() + source.getHeight() / 2);
                        conSVG.setY2(target.getY() + target.getHeight() / 2);
                    }
                }
            } else {
                System.out.println("----> x2<=(x1+x11)");
                if (y1 > y2) {
                    System.out.println("-----> y1>y2)");
                    if (y1 > (y2 + y22)) {
                        System.out.println("------> y1>(y2+y22)");
                        conSVG.setX1(source.getX() + source.getWidth() / 2);
                        conSVG.setX2(target.getX() + target.getWidth() / 2);
                        conSVG.setY1(source.getY());
                        conSVG.setY2(target.getY() + target.getHeight());
                    } else {
                        System.out.println("------> y1<=(y2+y22)");
                        conSVG.setX1(source.getX() + source.getWidth() / 2);
                        conSVG.setX2(target.getX() + target.getWidth() / 2);
                        conSVG.setY1(source.getY() + source.getHeight());
                        conSVG.setY2(target.getY());
                    }
                } else {
                    if (y2 > (y1 + y11)) {
                        System.out.println("----> y2>(y1+y11)");
                        conSVG.setX1(source.getX() + source.getWidth() / 2);
                        conSVG.setX2(target.getX() + target.getWidth() / 2);
                        conSVG.setY1(source.getY() + source.getHeight());
                        conSVG.setY2(target.getY());
                    } else {
                        System.out.println("------> y2<=(y1+y11)");
                        conSVG.setX1(source.getX() + source.getWidth() / 2);
                        conSVG.setX2(target.getX() + target.getWidth() / 2);
                        conSVG.setY1(source.getY() + source.getHeight());
                        conSVG.setY2(target.getY());
                    }
                }
            }
        }
        return conSVG;
    }


}
