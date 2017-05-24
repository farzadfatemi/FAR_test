package com.Farzad.utils.ImageUtils;

import POJOs.ArrowSVG;
import POJOs.ConnectionSVG;
import POJOs.SVGSingleShape;
import com.Farzad.Enums.ArrowsTypeEnum;
import com.Farzad.Enums.ConnectionsEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VOLCANO on 5/1/2017.
 */
class ConnectionTools {
    private static int maxX = 0;
    private static final List<ConnectionSVG> connectionCoordinates = new ArrayList<>();

    static String getSVGline(SVGSingleShape source, SVGSingleShape target) {
        System.out.println(source !=null?"source.getConnectionsType() : "+source.getConnectionsType()+"  Source ID : "+ source.getId()+"  Source Name : "+ source.getName() +" target id : "+target.getId()+" target name : "+target.getName():"nuuul");

        if (source != null && source.getConnectionsType() != null) {
            System.out.println(source.getConnectionsType() + "--**--" + source.getName() + " target id : " + target.getId() + " target name : " + target.getName());
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
//            } else if (ConnectionsEnum.READ_AND_WRITE.equalsName(source.getConnectionsType().toLowerCase())) {
//                return lineSVGCode(source, target, ConnectionsEnum.READ_AND_WRITE);
            } else if (ConnectionsEnum.COMPOSITION.equalsName(source.getConnectionsType().toLowerCase())) {
                return lineSVGCode(source, target, ConnectionsEnum.COMPOSITION);
             } else if (ConnectionsEnum.SPECIALIZATION.equalsName(source.getConnectionsType().toLowerCase())) {
                return lineSVGCode(source, target, ConnectionsEnum.SPECIALIZATION);
            } else
                return lineSVGCode(source, target, ConnectionsEnum.ACCESSES);
//            return null;



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
//            return source != null ? source.getName() : null;
        return lineSVGCode(source, target, ConnectionsEnum.ACCESSES);

    }

    private static String lineSVGCode(SVGSingleShape source, SVGSingleShape target, ConnectionsEnum connectionEnum) {
        ConnectionSVG conSVG = positionCondition(source, target);
//        ConnectionSVG conSVG = new ConnectionSVG();
//        conSVG.setX1(source.getX() + source.getWidth() / 2);
//        conSVG.setX2(target.getX() + target.getWidth() / 2);
//        conSVG.setY1(source.getY());
//        conSVG.setY2(target.getY());
//        conSVG.setWidth(source.getStrokeWidth());
        conSVG.setColor("#c1bdbd");
        conSVG.setType(connectionEnum.toString());
//        int lineWidth = source.getStrokeWidth();
        source.setFontSize(13);
        switch (connectionEnum) {
            case ACCESSES:
                conSVG.setDashArray(new int[]{2, 2});
                return (makeArrows(conSVG, ArrowsTypeEnum.DOUBLE_V_TYPE) + putText(conSVG, source));
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
//            case READ_AND_WRITE:
//                conSVG.setDashArray(new int[]{2, 2});
//                return (makeArrows(conSVG, ArrowsTypeEnum.DOUBLE_V_TYPE) + putText(conSVG, source));

            case COMPOSITION:
                return (makeArrows(conSVG, ArrowsTypeEnum.DIAMOND_BLACK) + putText(conSVG, source));
//                return  " <circle cx=\"" + x1 + "\" cy=\"" + y1 + "\" r=\"3\" fill=\"#000000\" />" +
//                        "      <line fill=\"black\" x1=\"" + x1 + "\" x2=\"" + x2 + "\" y1=\"" + y1 + "\" y2=\"" + y2 + "\" " +
//                        "stroke=\"#000000\" stroke-width=\"" + lineWidth + "\"/>\n" +
//                        "<circle cx=\"" + x2 + "\" cy=\"" + y2 + "\" r=\"3\" fill=\"#000000\" />";
            case SPECIALIZATION:
                return (makeArrows(conSVG, ArrowsTypeEnum.TRIANGLE_WHITE) + putText(conSVG, source));
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
        return "<line fill=\"black\" class=\"connection\" stroke-dasharray=\"" + dashWidth + "," + dashGap + "\" x1=\"" + conSvg.getX1() + "\" x2=\"" + conSvg.getX2() + "\" y1=\"" + conSvg.getY1() + "\" y2=\"" + conSvg.getY2() + "\" />\n";
//                "stroke=\"" + conSvg.getColor() + "\" stroke-width=\"" + conSvg.getWidth() + "\"/>\n";


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
        String textAnchor = "start";
        String result = null;
       int y = svg.getY1();
        if (svg.getY2() - svg.getY1() == 0) {
            textAnchor = "middle";
            y -= 8;
              result =  (source.getConnectionsType() != null ? "<text text-anchor=\"" + textAnchor + "\" class=\"connectionLabel\" x=\"" + ((svg.getX2() + svg.getX1()) / 2) + "\" y=\"" + ((svg.getY2() + y) / 2) + "\" >\n" +
                    source.getConnectionsName() +
                    " </text>\n" : "");
//    result =  (source.getConnectionsType() != null ? "<text text-anchor=\"" + textAnchor + "\" font-size=\"" + source.getFontSize() + "\" font-family=\" " + source.getFont() +
//                    "\" x=\"" + ((svg.getX2() + svg.getX1()) / 2) + "\" y=\"" + ((svg.getY2() + y) / 2) + "\" fill=\"#000000\" stroke=\"none\">\n" +
//                    source.getConnectionsType() +
//                    " </text>\n" : "");

        } else {
            svg.setX1(svg.getX1() + 8);
              result =  (source.getConnectionsType() != null ? "<text text-anchor=\"" + textAnchor + "\"  class=\"connectionLabel\"  x=\"" + ((svg.getX2() + svg.getX1()) / 2) + "\" y=\"" + ((svg.getY2() + y) / 2) + "\" fill=\"#000000\" stroke=\"none\">\n" +
                    source.getConnectionsName() +
                    " </text>\n" : "");
//                 result =  (source.getConnectionsType() != null ? "<text text-anchor=\"" + textAnchor + "\" font-size=\"" + source.getFontSize() + "\" font-family=\" " + source.getFont() +
//                    "\" x=\"" + ((svg.getX2() + svg.getX1()) / 2) + "\" y=\"" + ((svg.getY2() + y) / 2) + "\" fill=\"#000000\" stroke=\"none\">\n" +
//                    source.getConnectionsType() +
//                    " </text>\n" : "");
            svg.setX1(svg.getX1() - 8);
        }
        return result;

    }

    private static String putTextWithDirection(ConnectionSVG svg, SVGSingleShape source) {
        if (Math.abs(svg.getX2() - svg.getX1()) < 60 && Math.abs(svg.getY2() - svg.getY1()) < 60) {
            return (source.getConnectionsType() != null ? "<text font-size=\"" + source.getFontSize() + "\" font-family=\" " + source.getFont() +
                    "\" x=\"" + ((svg.getX2() + svg.getX1()) / 2) + "\" y=\"" + ((svg.getY2() + svg.getY1()) / 2) + "\" fill=\"#000000\" stroke=\"none\">\n" +
                    source.getConnectionsType() +
                    " </text>\n" : "");
        } else {
            int[] xy = getTextDirection(svg);
            String id = "Txt-" + svg.getId() + "-" + svg.getType();
            System.out.println("idddddddd" + id);
            String path = "<defs>\n" +
                    "    <path id=\"" + id + "\"" +
//                "          d=\"M " + (xy[0]-(source.getConnectionsType() !=null?source.getConnectionsType().length()/2:0)) + " " + (xy[1]-(source.getConnectionsType() !=null?source.getConnectionsType().length()/2:0)) + " \n" +
                    "          d=\"M " + xy[0] + " " + xy[1] + " \n" +
                    "             L " + xy[2] + " " + xy[3] + "\"/>\n" +
                    "  </defs>\n";
            return (source.getConnectionsType() != null ? path + "<text font-size=\"" + source.getFontSize() + "\" font-family=\" " + source.getFont() + "\" fill=\"#000000\" stroke=\"none\">\n" +
                    "<textPath x=\"" + (xy[0] + xy[2] / 2) + "\" y=\"" + (xy[1] + xy[3] / 2) + "\" xlink:href=\"#" + id + "\"> " +
                    source.getConnectionsType() +
                    "    </textPath>" +
                    " </text>\n" : "");
        }
    }

    private static int[] getTextDirection(ConnectionSVG svg) {
        System.out.println("xxxxxx x1 : " + svg.getX1() + " x2 : " + svg.getX2() + " y1 : " + svg.getY1() + " y2 :  " + svg.getY2());
        int x1 = ((svg.getX2() + svg.getX1() + 2) / 2);
//    int x1 = ((svg.getX2() + svg.getX1() ) / 2);
        int x2;
//    int y1 = ((svg.getY2() + svg.getY1() + 2) / 2);
        int y1 = ((svg.getY2() + svg.getY1()) / 2);
        int y2;

        if (svg.getX2() > svg.getX1()) {
            if (svg.getY2() > svg.getY1()) {
                x2 = svg.getX2();
                y2 = svg.getY1();
            } else {
                x2 = svg.getX2();
                y2 = svg.getY2();
            }
        } else {
            if (svg.getY2() > svg.getY1()) {
                x2 = svg.getX1();
                y2 = svg.getY1();
            } else {
                x2 = svg.getX1();
                y2 = svg.getY1();
            }
        }


        System.out.println("xxxxxx x1 : " + x1 + " x2 : " + x2 + " y1 : " + y1 + " y2 :  " + y2);

        return new int[]{x1, y1, x2, y2};
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
                arrowSVG.setRefX(7);
                arrowSVG.setRefY(7);
                arrowSVG.setColor("#000000");
                break;
            case TRIANGLE_WHITE:
                arrowSVG.setDim("M2,2 L2,13 L8,7 L2,2");
                arrowSVG.setMarkerWidth(13);
                arrowSVG.setMarkerHeight(13);
                arrowSVG.setRefX(7);
                arrowSVG.setRefY(7);
                arrowSVG.setColor("#ffffff");
                break;
            case V_TYPE:
                arrowSVG.setDim("M2,2 L8,7 L2,13 L8,7 L2,2");
                arrowSVG.setMarkerWidth(13);
                arrowSVG.setMarkerHeight(13);
                arrowSVG.setRefX(7);
                arrowSVG.setRefY(7);
                arrowSVG.setColor("#000000");
                break;
            case DOUBLE_V_TYPE:
                arrowSVG.setDim("M2,2 L8,7 L2,13 L8,7 L2,2");
                arrowSVG.setMarkerWidth(13);
                arrowSVG.setMarkerHeight(13);
                arrowSVG.setRefX(7);
                arrowSVG.setRefY(7);
                arrowSVG.setColor("#000000");
                arrowSVG2 = new ArrowSVG();
                arrowSVG2.setDim("M8,8 L2,13 L8,18 L2,13 L8,8");
                arrowSVG2.setMarkerWidth(16);
                arrowSVG2.setMarkerHeight(18);
                arrowSVG2.setRefX(4);
                arrowSVG2.setRefY(13);
                arrowSVG2.setColor("#000000");
                break;
            case DIAMOND_WHITE:
                arrowSVG.setDim("M8,8 L14,11 L8,14 L2,11 L8,8");
                arrowSVG.setMarkerWidth(16);
                arrowSVG.setMarkerHeight(16);
                arrowSVG.setRefX(1);
                arrowSVG.setRefY(11);
                arrowSVG.setColor("#ffffff");
                break;
            case DIAMOND_BLACK:
                arrowSVG.setDim("M8,8 L14,11 L8,14 L2,11 L8,8");
                arrowSVG.setMarkerWidth(16);
                arrowSVG.setMarkerHeight(16);
                arrowSVG.setRefX(1);
                arrowSVG.setRefY(11);
                arrowSVG.setColor("#000000");
                break;
        }
        String result = "<defs> " +
                "   <marker id=\"" + arrowSVG.getId() + "\" markerWidth=\"" + arrowSVG.getMarkerWidth() + "\" markerHeight=\"" + arrowSVG.getMarkerHeight() + "\" refX=\"" + arrowSVG.getRefX() + "\" refY=\"" + arrowSVG.getRefY() + "\" orient=\"auto\" >\n" +
                "        <path class=\"arrows\" d=\"" + arrowSVG.getDim() + "\"   style=\"fill:" + arrowSVG.getColor() + "\" />" +
//                "        <path class=\"arrows\" d=\"" + arrowSVG.getDim() + "\"  stroke=\"black\"  style=\"fill:" + arrowSVG.getColor() + "\" />" +
                "  </marker>";
        if (arrowsType.equals(ArrowsTypeEnum.DOUBLE_V_TYPE) && arrowSVG2 != null) {
            result += "   <marker id=\"" + (arrowSVG.getId() + "2") + "\" markerWidth=\"" + arrowSVG2.getMarkerWidth() + "\" markerHeight=\"" + arrowSVG2.getMarkerHeight() + "\" refX=\"" + arrowSVG2.getRefX() + "\" refY=\"" + arrowSVG2.getRefY() + "\" orient=\"auto\" >\n" +
                    "        <path class=\"arrows\" d=\"" + arrowSVG2.getDim() + "\" style=\"fill:" + arrowSVG2.getColor() + "\" />" +
                    "  </marker>";
        }
        result += "</defs>\n ";
        if(conSvg.isOwnConnection()){
            result += "<path class=\"connection\" d=\"M" + conSvg.getX1() + "," + conSvg.getY1() + " L" + (conSvg.getX1()) + "," + (conSvg.getY1()+20)+ " L" + (conSvg.getX1()+40) + "," + (conSvg.getY1()+20)+ " L" + (conSvg.getX1()+40) + "," + (conSvg.getY2())+ " L" + (conSvg.getX2()) + "," + (conSvg.getY2()) + "\" ";

        }else {
            result += "<path class=\"connection\" d=\"M" + conSvg.getX1() + "," + conSvg.getY1() + " L" + (conSvg.getX2()) + "," + (conSvg.getY2()) ;
        }
        result +=
//                "<path d=\"M" + conSvg.getX1() + "," + conSvg.getY1() + " L" + (conSvg.getX2()) + "," + (conSvg.getY2()) + "\" stroke-dasharray=\"" + dashWidth + "," + dashGap + " \" stroke=\"" + conSvg.getColor() + "\" stroke-width=\"" + conSvg.getWidth() + "\" \n" +
                " stroke-dasharray=\"" + dashWidth + "," + dashGap + "\" \n" +
                "style=\"" + (arrowsType.equals(ArrowsTypeEnum.DOUBLE_V_TYPE) ? " marker-start: url(#" + (arrowSVG.getId() + "2") + ");" : "")
                + (arrowsType.equals(ArrowsTypeEnum.DIAMOND_BLACK) || arrowsType.equals(ArrowsTypeEnum.DIAMOND_WHITE) ? " marker-start: url(#" + arrowSVG.getId() + ")\";" : " marker-end: url(#" + arrowSVG.getId() + ");\"") + "/>"
        ;
        System.out.println(result);
        return result;


    }

    private static ConnectionSVG positionCondition(SVGSingleShape source, SVGSingleShape target) {
        // the border should avoid from startpoint/endpoint connection
        int shapeBorderWidth = 4;
        boolean ownConnection = false;
        ConnectionSVG conSVG = null;

        if (source == null || target == null) return null;
        if (source.getId() !=null && source.getId().equals(target.getId())) {
            conSVG = new ConnectionSVG();
            conSVG.setX1(source.getX() + source.getWidth() -20);
            conSVG.setX2(target.getX() + source.getWidth()+ shapeBorderWidth);
            conSVG.setY1(source.getY() + source.getHeight() + shapeBorderWidth);
            conSVG.setY2(target.getY() + source.getHeight() - 20 );
            conSVG.setOwnConnection(true);
            conSVG.setId(source.getId() + "-" + System.currentTimeMillis());
            conSVG.setWidth(1);
        }else {
            conSVG = new ConnectionSVG();
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
            conSVG.setId(source.getId() + "-" + System.currentTimeMillis());
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
                            conSVG.setX1(source.getX() - shapeBorderWidth);
                            conSVG.setX2(target.getX() + target.getWidth() + shapeBorderWidth);
                            conSVG.setY1(source.getY() - shapeBorderWidth);
                            conSVG.setY2(target.getY() + target.getHeight() + shapeBorderWidth);
                            while (checkDuplicateConnection(conSVG)) {
                                conSVG.setX2(conSVG.getX2() - 1);
                                conSVG.setY1(conSVG.getY1() + 1);
                            }
                        } else {
                            System.out.println("------> y1<=(y2+y22)");
                            conSVG.setX1(source.getX() - shapeBorderWidth);
                            conSVG.setX2(target.getX() + target.getWidth() + shapeBorderWidth);
                            conSVG.setY1(source.getY() + source.getHeight() / 2);
                            conSVG.setY2(source.getY() + source.getHeight() / 2 > target.getY() && source.getY() + source.getHeight() / 2 < target.getY() + target.getHeight() ? source.getY() + source.getHeight() / 2 : target.getY() + target.getHeight() / 2);
                            while (checkDuplicateConnection(conSVG)) {
                                conSVG.setY2(conSVG.getY2() - 1);
                                conSVG.setY1(conSVG.getY1() - 1);
                            }
//                        conSVG.setY1(source.getY() + 2);
//                        conSVG.setY2((source.getY() + 2) > target.getY() && (source.getY() + 2) < target.getY() + target.getHeight() ? (source.getY() + 2) : target.getY() + target.getHeight() - 2);
//                     conSVG.setX1(source.getX());
//                        conSVG.setX2(target.getX() + target.getWidth());
//                        conSVG.setY1(source.getY() + source.getHeight() / 2);
//                        conSVG.setY2(target.getY() + target.getHeight() / 2);
                        }
                    } else {
                        System.out.println("-----> y2>y1)");
                        if (y2 > (y1 + y11)) {
                            System.out.println("----> y2>(y1+y11)");
                            conSVG.setX1(source.getX() - shapeBorderWidth);
                            conSVG.setX2(target.getX() + target.getWidth() + shapeBorderWidth);
                            conSVG.setY1(source.getY() + source.getHeight() + shapeBorderWidth);
                            conSVG.setY2(target.getY() - shapeBorderWidth);
                        } else {
                            System.out.println("----> y2<=(y1+y11)");
                            conSVG.setX1(source.getX() - shapeBorderWidth);
                            conSVG.setX2(target.getX() + target.getWidth() + shapeBorderWidth);
                            conSVG.setY1(target.getY() + target.getHeight() / 2);
                            conSVG.setY2(target.getY() + target.getHeight() / 2);
//                        conSVG.setY1(source.getY()+ 2);
//                        conSVG.setY1(source.getY() + source.getHeight() / 2);
//                        conSVG.setY2((source.getY() +2)> target.getY()&& (source.getY() +2)< target.getY() + target.getHeight()? (source.getY() +2):target.getY() + target.getHeight() - 2);
//                        conSVG.setY2(target.getY() + target.getHeight() / 2);
                        }
                    }

                } else {
                    System.out.println("----> x1<=(x2+x22)");
                    if (y1 > y2) {
                        System.out.println("-----> y1>y2");
                        if (y1 > (y2 + y22)) {
                            System.out.println("------> y1>(y2+y22)");
                            conSVG.setX1(source.getX() + source.getWidth() / 2);
                            conSVG.setX2(source.getX() + source.getWidth() / 2);
//                        conSVG.setX2(target.getX() + target.getWidth() / 2);
                            conSVG.setY1(source.getY() - shapeBorderWidth);
                            conSVG.setY2(target.getY() + target.getHeight() + shapeBorderWidth);
                        } else {
                            System.out.println("------> y1<=(y2+y22)");
                            conSVG.setX1(source.getX() - shapeBorderWidth);
                            conSVG.setX2(target.getX() + target.getWidth() / 2 + shapeBorderWidth);
                            conSVG.setY1(source.getY() + source.getHeight() / 2 - shapeBorderWidth);
                            conSVG.setY2(target.getY() + target.getHeight() + shapeBorderWidth);
                        }
                    } else {
                        System.out.println("-----> y2>y1");
                        if (y2 > (y1 + y11)) {
                            System.out.println("----> y2>(y1+y11)");
                            conSVG.setX1(source.getX() + source.getWidth() / 2);
                            conSVG.setX2(source.getX() + source.getWidth() / 2 > x2 && source.getX() + source.getWidth() / 2 < x2 + x22 ? source.getX() + source.getWidth() / 2 : target.getX() + target.getWidth());
//                        conSVG.setX2(target.getX() + target.getWidth() / 2);
                            conSVG.setY1(source.getY() + source.getHeight() + shapeBorderWidth);
                            conSVG.setY2(target.getY() - shapeBorderWidth);
                        } else {
                            System.out.println("----> y2<=(y1+y11)");
                            conSVG.setX1(source.getX() - shapeBorderWidth);
                            conSVG.setX2(target.getX() + target.getWidth() / 2);
                            conSVG.setY1(source.getY() + source.getHeight() / 2);
                            conSVG.setY2(target.getY() + target.getHeight() + shapeBorderWidth);
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
                            conSVG.setX1(source.getX() + source.getWidth() + shapeBorderWidth);
                            conSVG.setX2(target.getX() - shapeBorderWidth);
                            conSVG.setY1(source.getY() - shapeBorderWidth);
                            conSVG.setY2(target.getY() + target.getHeight() + shapeBorderWidth);
                        } else {
                            System.out.println("------> y1<=(y2+y22)");
                            conSVG.setX1(source.getX() + source.getWidth() + shapeBorderWidth);
                            conSVG.setX2(target.getX() - shapeBorderWidth);
                            conSVG.setY1(source.getY() + source.getHeight() / 2);
                            conSVG.setY2((source.getY() + source.getHeight() / 2) < (target.getY() + target.getHeight()) ? (source.getY() + source.getHeight() / 2) : target.getY() + target.getHeight() / 2);
//                        conSVG.setY2(target.getY() + target.getHeight() / 2);
                            while (checkDuplicateConnection(conSVG)) {
                                System.out.println("heree1");
                                conSVG.setY2(conSVG.getY2() - 20);
                                conSVG.setY1(conSVG.getY1() - 20);
                            }
                        }
                    } else {
                        System.out.println("-----> y1<y2)");
                        if (y2 > (y1 + y11)) {
                            System.out.println("----> y2>(y1+y11)");
                            conSVG.setX1(source.getX() + source.getWidth() + shapeBorderWidth);
                            conSVG.setX2(target.getX() - shapeBorderWidth);
                            conSVG.setY1(source.getY() + source.getHeight() + shapeBorderWidth);
                            conSVG.setY2(target.getY() - shapeBorderWidth);
                        } else {
                            System.out.println("------> y2<=(y1+y11)");
                            conSVG.setX1(source.getX() + source.getWidth());
                            conSVG.setX2(target.getX() - shapeBorderWidth);
                            conSVG.setY1(target.getY() + target.getHeight() / 2);
                            conSVG.setY2((target.getY() + target.getHeight() / 2) < (source.getY() + source.getHeight()) ? (target.getY() + target.getHeight() / 2) : source.getY() + source.getHeight() / 2);
//                        System.out.println(source.getName()+"_+_+_+_+_"+target.getName()+"_+_+_+_+_"+source.getConnectionsType());
//                        System.out.println("conSVG.getX1()_ "+conSVG.getX1()+" conSVG.getY1()_"+conSVG.getY1()+" conSVG.getX2()_"+conSVG.getX2()+" conSVG.getY2()_"+conSVG.getY2());
                            while (checkDuplicateConnection(conSVG)) {
                                System.out.println("heree1");
                                conSVG.setY2(conSVG.getY2() - 20);
                                conSVG.setY1(conSVG.getY1() - 20);
                            }
//                        conSVG.setY2(target.getY() + target.getHeight() / 2);
//                        conSVG.setY1(source.getY() + source.getHeight() / 2);
//                        conSVG.setY2(target.getY() + target.getHeight() / 2);
//

                        }
                    }
                } else {
                    System.out.println("----> x2<=(x1+x11)");
                    if (y1 > y2) {
                        System.out.println("-----> y1>y2)");
                        if (y1 > (y2 + y22)) {
                            System.out.println("------> y1>(y2+y22)");
                            conSVG.setX1(source.getX() + source.getWidth() / 2);
                            conSVG.setX2(source.getX() + source.getWidth() / 2 < target.getX() + target.getWidth() && source.getX() + source.getWidth() / 2 > target.getX() ? source.getX() + source.getWidth() / 2 : target.getX() - shapeBorderWidth);
//                        conSVG.setX2(target.getX() + target.getWidth() / 2);
                            conSVG.setY1(source.getY() - shapeBorderWidth);
                            conSVG.setY2(target.getY() + target.getHeight() + shapeBorderWidth);
                        } else {
                            System.out.println("------> y1<=(y2+y22)");
                            conSVG.setX1(source.getX() + source.getWidth() / 2);
                            conSVG.setX2(target.getX() - shapeBorderWidth);
                            conSVG.setY1(source.getY() - shapeBorderWidth);
                            conSVG.setY2(target.getY());
                        }
                    } else {
                        if (y2 > (y1 + y11)) {
                            System.out.println("----> y2>(y1+y11)");
                            conSVG.setX1(source.getX() + source.getWidth() / 2);
                            conSVG.setX2(source.getX() + source.getWidth() / 2 < target.getX() + target.getWidth() && source.getX() + source.getWidth() / 2 > target.getX() ? source.getX() + source.getWidth() / 2 : target.getX() - shapeBorderWidth);
//                        conSVG.setX2(target.getX() + target.getWidth() / 2);
                            conSVG.setY1(source.getY() + source.getHeight() + shapeBorderWidth);
                            conSVG.setY2(target.getY() - shapeBorderWidth);
                        } else {
                            System.out.println("------> y2<=(y1+y11)");
                            conSVG.setX1(source.getX() + source.getWidth() / 2);
                            conSVG.setX2(target.getX() - shapeBorderWidth);
                            conSVG.setY1(source.getY() + source.getHeight() + shapeBorderWidth);
                            conSVG.setY2(target.getY());
                        }
                    }
                }
            }
            for (ConnectionSVG csvg : connectionCoordinates) {
                System.out.println("33   conSVG.getX1()----->> " + conSVG.getX1() + "  csvg.getX1___> " + csvg.getX1());
                System.out.println("33   conSVG.getX2()()----->> " + conSVG.getX2() + "  csvg.getX2___> " + csvg.getX2());
                System.out.println("33   conSVG.getY1()()----->> " + conSVG.getY1() + "  csvg.getY1___> " + csvg.getY1());
                System.out.println("33    conSVG.getY2()()----->> " + conSVG.getY2() + "  csvg.getY2___> " + csvg.getY2());
            }
            connectionCoordinates.add(conSVG);
        }
        return conSVG;
    }

    private static boolean checkDuplicateConnection(ConnectionSVG conSVG) {
        for (ConnectionSVG csvg : connectionCoordinates) {
            System.out.println("conSVG.getX1()----->> "+ conSVG.getX1()+"  csvg.getX1___> "+csvg.getX1());
            System.out.println("conSVG.getX2()()----->> "+ conSVG.getX2()+"  csvg.getX2___> "+csvg.getX2());
            System.out.println("conSVG.getY1()()----->> "+ conSVG.getY1()+"  csvg.getY1___> "+csvg.getY1());
            System.out.println("conSVG.getY2()()----->> "+ conSVG.getY2()+"  csvg.getY2___> "+csvg.getY2());
            if (conSVG.getX1() == csvg.getX1()) {
                if (conSVG.getX2() == csvg.getX2()
                        && conSVG.getY1() == csvg.getY1()
                        && conSVG.getY2() == csvg.getY2()) {
                    return true;

                }
            } else if (conSVG.getX2() == csvg.getX1()) {
                if (conSVG.getX1() == csvg.getX2()
                        && conSVG.getY2() == csvg.getY1()
                        && conSVG.getY1() == csvg.getY2()) {
                    return true;
                }

            }
        }
        return false;
    }

}
