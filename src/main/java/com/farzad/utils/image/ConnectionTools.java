package com.farzad.utils.image;


import com.farzad.enums.ArrowsTypeEnum;
import com.farzad.enums.ConnectionsEnum;
import com.farzad.pojo.ArrowSVG;
import com.farzad.pojo.BendPoints;
import com.farzad.pojo.ConnectionSVG;
import com.farzad.pojo.SVGSingleShape;
import com.farzad.utils.ComUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VOLCANO on 5/1/2017.
 */
class ConnectionTools {
    //    protected static int FIRST_X = 0;
//    protected static int FIRST_Y = 0;
//    protected static int LAST_X = 0;
//    protected static int LAST_Y = 0;
    private static final int shapeBorderWidth = 4;
    private static final List<ConnectionSVG> connectionCoordinates = new ArrayList<>();

    static String getSVGline(SVGSingleShape source, SVGSingleShape target) {
        System.out.println(source != null ? "source.getConnectionsType() : " + source.getConnectionsType() + "  Source ID|Name : " + source.getId() + "-" + source.getName() + " Target ID|Name" + target.getId() + "-" + target.getName() : "nuuul");

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
            } else if (ConnectionsEnum.FLOW.equalsName(source.getConnectionsType().toLowerCase())) {
                return lineSVGCode(source, target, ConnectionsEnum.FLOW);
            } else
                return lineSVGCode(source, target, ConnectionsEnum.ASSOCIATION);
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
            return lineSVGCode(source, target, ConnectionsEnum.ASSOCIATION);

    }

    private static String lineSVGCode(SVGSingleShape source, SVGSingleShape target, ConnectionsEnum connectionEnum) {
        ConnectionSVG conSVG = source.getConnectionBendPointsList() != null && source.getConnectionBendPointsList().size() > 0 ? positionWithBendPoints(source, target) : positionCondition(source, target);
//        ConnectionSVG conSVG = new ConnectionSVG();
//        conSVG.setX1(source.getX() + source.getWidth() / 2);
//        conSVG.setX2(target.getX() + target.getWidth() / 2);
//        conSVG.setY1(source.getY());
//        conSVG.setY2(target.getY());
//        conSVG.setWidth(source.getStrokeWidth());

        if (conSVG != null && !isInternalConnection(conSVG, source, target)) {
            conSVG.setColor("#c1bdbd");
            conSVG.setType(connectionEnum.toString());
            conSVG.setBendPointses(source.getConnectionBendPointsList());
            conSVG.setSourceId(source.getId());
            conSVG.setSourceName(source.getName());
            conSVG.setTargetId(target.getId());
            conSVG.setTargetName(target.getName());
            conSVG.setSource(source);
            conSVG.setTarget(target);
            conSVG.setAccessType(source.getAccessType());
//        int lineWidth = source.getStrokeWidth();
            source.setFontSize(13);
            switch (connectionEnum) {
                case ACCESSES:
                    System.out.println("conSVG.getAccessType() " + conSVG.getAccessType());
                    conSVG.setDashArray(new int[]{2, 2});
                    ArrowsTypeEnum arrowsTypeEnum = conSVG.getAccessType() == 3 ? ArrowsTypeEnum.DOUBLE_V_TYPE :
                            conSVG.getAccessType() == 1 ? ArrowsTypeEnum.V_TYPE_READ : ArrowsTypeEnum.V_TYPE_WRITE;
                    System.out.println(arrowsTypeEnum);
                    return (makeArrows(conSVG, (conSVG.getAccessType() == 3 ? ArrowsTypeEnum.DOUBLE_V_TYPE :
                            conSVG.getAccessType() == 1 ? ArrowsTypeEnum.V_TYPE_READ : ArrowsTypeEnum.V_TYPE_WRITE)) + putText(conSVG, source));
                case USED_BY:
                    return (makeArrows(conSVG, ArrowsTypeEnum.V_TYPE_WRITE) + putText(conSVG, source));
                case ASSIGNED:
                    return (makeArrows(conSVG, ArrowsTypeEnum.DOUBLE_ORBIT) + putText(conSVG, source));
                case REALISES:
                    conSVG.setDashArray(new int[]{5, 5});
                    return (makeArrows(conSVG, ArrowsTypeEnum.TRIANGLE_WHITE) + putText(conSVG, source));
                case USES:
                    return (makeArrows(conSVG, ArrowsTypeEnum.V_TYPE_WRITE) + putText(conSVG, source));
                case AGGREGATION:
                    return (makeArrows(conSVG, ArrowsTypeEnum.DIAMOND_WHITE) + putText(conSVG, source));
                case ASSOCIATION:
                    return (makeArrows(conSVG, null) + putText(conSVG, source));
                case COMPOSITION:
                    return (makeArrows(conSVG, ArrowsTypeEnum.DIAMOND_BLACK) + putText(conSVG, source));
                case SPECIALIZATION:
                    return (makeArrows(conSVG, ArrowsTypeEnum.TRIANGLE_WHITE) + putText(conSVG, source));
                case FLOW:
                    conSVG.setDashArray(new int[]{2, 2});
                    return (makeArrows(conSVG, ArrowsTypeEnum.TRIANGLE_BLACK) + putText(conSVG, source));
                default:
                    return (makeArrows(conSVG, null) + putText(conSVG, source));
            }
        } else {
            return null;
        }

    }
//
//    private static String makeLine(ConnectionSVG conSvg) {
//        int dashWidth = 1, dashGap = 0;
//        boolean solidLine = true;
//        if (conSvg.getDashArray() != null && conSvg.getDashArray().length > 1) {
//            dashWidth = conSvg.getDashArray()[0];
//            dashGap = conSvg.getDashArray()[1];
//            solidLine = false;
//        }
//
//        if (conSvg.getBendPointses() != null && conSvg.getBendPointses().size() > 0) {
//            return "<path class=\"connection\" "+(solidLine?"":dashLine)+" d=\"" + makeDimWithBendPoints(conSvg) + "\"/>";
//
//        } else {
////            return "<path class=\"connection\" stroke-dasharray=\"" + dashWidth + "," + dashGap + "\" d=\"" + makeDimWithBendPoints(conSvg) + "\"/>";
//            return "<path class=\"connection\" "+(solidLine?"":dashLine)+
//                    "d=\"M" + conSvg.getX1()+" "+conSvg.getY1() + " L " + conSvg.getX2() + " " + conSvg.getY2() + "\" />\n";
//
//
////            return "<line fill=\"black\" class=\"connection\" stroke-dasharray=\"" + dashWidth + "," + dashGap
////                    + "\" x1=\"" + conSvg.getX1() + "\" x2=\"" + conSvg.getX2() + "\" y1=\"" + conSvg.getY1() + "\" y2=\"" + conSvg.getY2() + "\" />\n";
//        }
//
//    }

    private static String makeDimWithBendPoints(ConnectionSVG conSvg) {
        int sMX = conSvg.getSource().getX() + conSvg.getSource().getWidth() / 2;
        int sMY = conSvg.getSource().getY() + conSvg.getSource().getHeight() / 2;
        int tMX = conSvg.getTarget().getX() + conSvg.getTarget().getWidth() / 2;
        int tMY = conSvg.getTarget().getY() + conSvg.getTarget().getHeight() / 2;

        StringBuilder dim = new StringBuilder("M" + conSvg.getX1() + "," + conSvg.getY1());
        System.out.println("First Step ----    M" + conSvg.getX1() + "," + conSvg.getY1());
        GenerateSVG.setFirstLastXY(conSvg.getX1(), conSvg.getY1(), conSvg.getX2(), conSvg.getY2());
        System.out.println("before Bend points conSvg.getX1() : StartX : " + conSvg.getX1() + " | StartY :" + conSvg.getY1() + " | EndX :" + conSvg.getX2() + " | EndY :" + conSvg.getY2());
        double[] xy = null;
//<path class="connection" d=" M10,80 L50 ,60 Q55 55 ,50 50  L20, 30"/>
        double x1 = conSvg.getX1();
        double y1 = conSvg.getY1();
        if (conSvg.getBendPointses() != null) {
            BendPoints b = null;
            BendPoints b2 = null;
            System.out.println("The list of Bend points   : ");
            for (BendPoints bb : conSvg.getBendPointses()) {
                System.out.println(" StartX : " + (bb.getStartX()  ) + " | StartY :" + (bb.getStartY() ) + " | EndX :" + (bb.getEndX()  ) + " | EndY :" + (bb.getEndY()) +
                        " X : " + (bb.getStartX() + sMX) + " |  Y :" + (bb.getStartY() + sMY) );
            }


            for (int i = 0; i < conSvg.getBendPointses().size(); i++) {
                //           dim.append(" L").append(b.getStartX() + sMX).append(",").append(b.getStartY() + sMY);
                b = conSvg.getBendPointses().get(i);
                System.out.println("intoooo BBBBBBBBBBBeeeeeeeeeeend points  X : " + (b.getStartX() + sMX) + " |  Y :" + (b.getStartY() + sMY));
                xy = ComUtils.findPointOnConnectionLineByRatio((int) x1, b.getStartX() + sMX, (int) y1, b.getStartY() + sMY);
                dim.append(" L").append(xy[0]).append(",").append(xy[1]);
                System.out.println("Second Step ---- L " + xy[0] + " " + xy[1]);
                dim.append(" Q").append(b.getStartX() + sMX).append("  ").append(b.getStartY() + sMY);
                System.out.println("Third Step ---- Q " + (b.getStartX() + sMX) + " " + (b.getStartY() + sMY));

                if (i < conSvg.getBendPointses().size() - 1) {
                    b2 = conSvg.getBendPointses().get(i + 1);
                    xy = ComUtils.findPointOnConnectionLineByRatio((b2.getStartX() + sMX), (b.getStartX() + sMX), (b2.getStartY() + sMY), (b.getStartY() + sMY));
                    dim.append(" ,").append(xy[0]).append(" ").append(xy[1]);
                    System.out.println("Forth Step for current bend point ----  , " + xy[0] + " " + xy[1]);
                } else {
                    xy = ComUtils.findPointOnConnectionLineByRatio(conSvg.getX2(), (b.getStartX() + sMX), conSvg.getY2(), (b.getStartY() + sMY));
                    dim.append(" ,").append(xy[0]).append(" ").append(xy[1]);
                    System.out.println("Forth Step when just have one bend point or for last one ----  , " + xy[0] + " " + xy[1]);
                }
                x1 = xy[0];
                y1 = xy[1];
                GenerateSVG.setFirstLastXY(b.getStartX() + sMX, b.getStartY() + sMY, b.getEndX() + tMX, b.getEndY() + tMY);

            }
        }

//            if (conSvg.getBendPointses().size() < 2) {
//                b = conSvg.getBendPointses().get(0);
//                System.out.println("intoooo BBBBBBBBBBBeeeeeeeeeeend points StartX : " + (b.getStartX() + sMX) + " | StartY :" + (b.getStartY() + sMY) + " | EndX :" + (b.getEndX() + tMX) + " | EndY :" + (b.getEndY() + tMY));
////           dim.append(" L").append(b.getStartX() + sMX).append(",").append(b.getStartY() + sMY);
//
//                xy = ComUtils.findClosePointsForDrawingArc((int) x1, b.getStartX() + sMX, (int) y1, b.getStartY() + sMY);
//                System.out.println("---" + Arrays.toString(xy));
//                dim.append(" L").append(xy[0]).append(",").append(xy[1]);
//                System.out.println("Second Step ---- L " + xy[0] + "," + xy[1]);
//                dim.append(" Q").append(b.getStartX() + sMX).append(" ").append(b.getStartY() + sMY);
//                System.out.println("Third Step ---- Q " + (b.getStartX() + sMX) + " " + (b.getStartY() + sMY));
//                x1 = xy[0];
//                y1 = xy[1];
//                xy = ComUtils.findClosePointsForDrawingArc(conSvg.getX2(), (b.getStartX() + sMX), conSvg.getY2(), (b.getStartY() + sMY));
//                dim.append(" ,").append(xy[0]).append(" ").append(xy[1]);
//                System.out.println("Forth Step ----  , " + xy[0] + "," + xy[1]);
//                GenerateSVG.setFirstLastXY(b.getStartX() + sMX, b.getStartY() + sMY, b.getEndX() + tMX, b.getEndY() + tMY);
//
//            } else {
//                b = conSvg.getBendPointses().get(0);
//                xy = ComUtils.findClosePointsForDrawingArc((int) x1, b.getStartX() + sMX, (int) y1, b.getStartY() + sMY);
//                dim.append(" L").append(xy[0]).append(",").append(xy[1]);
//                System.out.println("Second Step ---- L " + xy[0] + "," + xy[1]);
//                dim.append(" Q").append(b.getStartX() + sMX).append(" ").append(b.getStartY() + sMY);
//                System.out.println("Third Step ---- Q " + (b.getStartX() + sMX) + " " + (b.getStartY() + sMY));
//                x1 = xy[0];
//                y1 = xy[1];
//                for (int i = 1; i < conSvg.getBendPointses().size(); i++) {
//                    b = conSvg.getBendPointses().get(i);
////            System.out.println("intoooo BBBBBBBBBBBeeeeeeeeeeend points StartX : " + b.getStartX() + " | StartY :" + b.getStartY() + " | EndX :" + b.getEndX() + " | EndY :" + b.getEndY());
//                    System.out.println("intoooo BBBBBBBBBBBeeeeeeeeeeend points StartX : " + (b.getStartX() + sMX) + " | StartY :" + (b.getStartY() + sMY) + " | EndX :" + (b.getEndX() + tMX) + " | EndY :" + (b.getEndY() + tMY));
////           dim.append(" L").append(b.getStartX() + sMX).append(",").append(b.getStartY() + sMY);
//
//                    xy = ComUtils.findClosePointsForDrawingArc((int) x1, b.getStartX() + sMX, (int) y1, b.getStartY() + sMY);
//                    System.out.println("---" + Arrays.toString(xy));
//                    dim.append("  ").append(xy[0]).append(",").append(xy[1]);
//                    System.out.println("Second Step ---- L " + xy[0] + "," + xy[1]);
//                    dim.append(" Q").append(b.getStartX() + sMX).append(" ").append(b.getStartY() + sMY);
//                    System.out.println("Third Step ---- Q " + (b.getStartX() + sMX) + " " + (b.getStartY() + sMY));
//                    x1 = xy[0];
//                    y1 = xy[1];
//                    if (i == conSvg.getBendPointses().size() - 1) {
//                        xy = ComUtils.findClosePointsForDrawingArc(conSvg.getX2(), (b.getStartX() + sMX), conSvg.getY2(), (b.getStartY() + sMY));
//                        dim.append(" ,").append(xy[0]).append(" ").append(xy[1]);
//                        System.out.println("Forth Step ----  , " + xy[0] + "," + xy[1]);
//                    } else {
//                        b2 = conSvg.getBendPointses().get(++i);
//                        xy = ComUtils.findClosePointsForDrawingArc((b2.getStartX() + sMX), (b.getStartX() + sMX), (b2.getStartY() + sMY), (b.getStartY() + sMY));
//                        dim.append(" ,").append(xy[0]).append(" ").append(xy[1]);
//                        x1 = xy[0];
//                        y1 = xy[1];
//                    }
//                    GenerateSVG.setFirstLastXY(b.getStartX() + sMX, b.getStartY() + sMY, b.getEndX() + tMX, b.getEndY() + tMY);
//
//                }
//            }
            dim.append(" L").append(conSvg.getX2()).append(",").append(conSvg.getY2()).append("");
//        dim += " L" + tMX + "," + tMY;
            System.out.println("Final svg connection code " + dim.toString());
            return dim.toString();


        }

    private static String makeLineWithDoubleOrb(String line, ConnectionSVG svg) {

        return " <circle class=\"arrows\" cx=\"" + svg.getX1() + "\" cy=\"" + svg.getY1() + "\" r=\"3\"  />" +
                line +
                "<circle class=\"arrows\" cx=\"" + svg.getX2() + "\" cy=\"" + svg.getY2() + "\" r=\"3\" />";
    }

    private static String makeSingleOrb(ConnectionSVG svg, int x, int y) {

        return " <circle class=\"arrows\" cx=\"" + x + "\" cy=\"" + y + "\" r=\"3\" />";

    }

    private static String putText(ConnectionSVG conSVG, SVGSingleShape source) {
        int sMX = conSVG.getSource().getX() + conSVG.getSource().getWidth() / 2;
        int sMY = conSVG.getSource().getY() + conSVG.getSource().getHeight() / 2;

        String textAnchor = "middle";
        String result = null;
        int x = conSVG.getX1();
        int y = conSVG.getY1();
        StringBuilder text = null;
        if (source.getConnectionsType() != null) {
            text = new StringBuilder();
            if (conSVG.getY2() - conSVG.getY1() == 0) {
//                textAnchor = "middle";
                y -= 8;
            } else {
                x = conSVG.getX1() + 8;
            }
            text.append("<text text-anchor=\"");
            text.append(textAnchor);
            text.append("\"");
            text.append(" class=\"connectionLabel\"");
            if (conSVG.getBendPointses() != null && conSVG.getBendPointses().size() > 0) {
                text.append(" x=\"");
                text.append(sMX + conSVG.getBendPointses().get(0).getStartX() + 5);
                text.append("\" y=\"");
                text.append(sMY + conSVG.getBendPointses().get(0).getStartY() + 10);
                text.append("\" >\n");
            } else {
                text.append(" x=\"");
                text.append(((conSVG.getX2() + x) / 2));
                text.append("\" y=\"");
                text.append(((conSVG.getY2() + y) / 2));
                text.append("\" >\n");
            }
            text.append(ComUtils.getEscapeXmlChars(source.getConnectionsName()));
            text.append("</text>\n");
            result = text.toString();

        }

        return result;

    }

    private static String putTextWithDirection(ConnectionSVG svg, SVGSingleShape source) {
        if (Math.abs(svg.getX2() - svg.getX1()) < 60 && Math.abs(svg.getY2() - svg.getY1()) < 60) {
            return (source.getConnectionsType() != null ? "<text font-size=\"" + source.getFontSize() + "\" font-family=\" " + source.getFont() +
                    "\" x=\"" + ((svg.getX2() + svg.getX1()) / 2) + "\" y=\"" + ((svg.getY2() + svg.getY1()) / 2) + "\" fill=\"#000000\" stroke=\"none\">" +
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
        String result = "";
        int dashWidth = 0, dashGap = 0;
        boolean solidLine = true;
        if (conSvg.getDashArray() != null && conSvg.getDashArray().length > 1) {
            dashWidth = conSvg.getDashArray()[0];
            dashGap = conSvg.getDashArray()[1];
            solidLine = false;
        }
        arrowSVG.setId(conSvg.getId());
        String dashLine = " stroke-dasharray=\"" + dashWidth + "," + dashGap + "\"";
        if (arrowsType == null) {
            if (conSvg.getBendPointses() != null && conSvg.getBendPointses().size() > 0) {
                return "<path class=\"connection\" " + (solidLine ? "" : dashLine) + " d=\"" + makeDimWithBendPoints(conSvg) + "\"/>";

            } else {
                return "<path class=\"connection\" " + (solidLine ? "" : dashLine) +
                        " d=\"M" + conSvg.getX1() + " " + conSvg.getY1() + " L " + conSvg.getX2() + " " + conSvg.getY2() + "\" />\n";

            }
        }
        switch (arrowsType) {
            case TRIANGLE_BLACK:
                arrowSVG.setDim("M0,0 L0,6 L4,3 z");
//                arrowSVG.setDim("M2,2 L2,13 L8,7 L2,2");
                arrowSVG.setMarkerWidth(10);
                arrowSVG.setMarkerHeight(10);
                arrowSVG.setRefX(5);
                arrowSVG.setRefY(3);
                arrowSVG.setColor("#000000");
                break;
            case TRIANGLE_WHITE:
                arrowSVG.setDim("M0,0 L0,9 L6,4.5 z");
                arrowSVG.setMarkerWidth(10);
                arrowSVG.setMarkerHeight(10);
                arrowSVG.setRefX(5);
                arrowSVG.setRefY(4);
                arrowSVG.setColor("#ffffff");
                break;
            case V_TYPE_READ:
                arrowSVG.setDim("M5,1 L1,5 L5,9 L1,5");
                arrowSVG.setMarkerWidth(5);
                arrowSVG.setMarkerHeight(9);
                arrowSVG.setRefX(0);
                arrowSVG.setRefY(5);
                break;
            case V_TYPE_WRITE:
                arrowSVG.setDim("M0,0 L4,4 L0,8 L4,4");
                arrowSVG.setMarkerWidth(5);
                arrowSVG.setMarkerHeight(8);
                arrowSVG.setRefX(4);
                arrowSVG.setRefY(4);
//                arrowSVG.setColor("#000000");
                break;
            case DOUBLE_V_TYPE:
                arrowSVG.setDim("M0,0 L4,4 L0,8 L4,4");
                arrowSVG.setMarkerWidth(5);
                arrowSVG.setMarkerHeight(8);
                arrowSVG.setRefX(4);
                arrowSVG.setRefY(4);
                arrowSVG.setColor("#000000");
                arrowSVG2 = new ArrowSVG();
                arrowSVG2.setDim("M5,1 L1,5 L5,9 L1,5");
                arrowSVG2.setMarkerWidth(5);
                arrowSVG2.setMarkerHeight(9);
                arrowSVG2.setRefX(0);
                arrowSVG2.setRefY(5);
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
            default:
                break;
        }
        if (!arrowsType.equals(ArrowsTypeEnum.DOUBLE_ORBIT) && !arrowsType.equals(ArrowsTypeEnum.NORMAL)) {
            result = "<defs>\n " +
                    "   <marker id=\"" + arrowSVG.getId() + "\" markerWidth=\"" + arrowSVG.getMarkerWidth() + "\" markerHeight=\"" + arrowSVG.getMarkerHeight() + "\" refX=\"" + arrowSVG.getRefX() + "\" refY=\"" + arrowSVG.getRefY() + "\" orient=\"auto\" >\n" +
                    "        <path class=\"arrows " + arrowsType.toString() + "\" d=\"" + arrowSVG.getDim() + "\" />\n" +
                    "  </marker>\n";
            if (arrowsType.equals(ArrowsTypeEnum.DOUBLE_V_TYPE) && arrowSVG2 != null) {
                result += "   <marker id=\"" + (arrowSVG.getId() + "2") + "\" markerWidth=\"" + arrowSVG2.getMarkerWidth() + "\" markerHeight=\"" + arrowSVG2.getMarkerHeight() + "\" " +
                        "refX=\"" + arrowSVG2.getRefX() + "\" refY=\"" + arrowSVG2.getRefY() + "\" orient=\"auto\" >\n" +
                        "        <path class=\"arrows " + arrowsType.toString() + "\" d=\"" + arrowSVG2.getDim() + "\" />\n" +
                        "  </marker>\n";
            }
            result += "</defs>\n ";

        }
        if (arrowsType.equals(ArrowsTypeEnum.DOUBLE_ORBIT)) {
            result += "<circle class=\"arrows " + arrowsType.toString() + "\" cx=\"" + conSvg.getX1() + "\" cy=\"" + conSvg.getY1() + "\" r=\"3\"/>\n";
        }

        if (conSvg.isOwnConnection()) {

            result += "<path class=\"connection\"  d=\"M" + conSvg.getX1() + "," + conSvg.getY1() + " L" + (conSvg.getX1()) + "," + (conSvg.getY1() + 10) + "\" ";
            result += (solidLine ? "" : dashLine);
            if (!arrowsType.equals(ArrowsTypeEnum.DOUBLE_ORBIT) && !arrowsType.equals(ArrowsTypeEnum.NORMAL)) {
                result += (arrowsType.equals(ArrowsTypeEnum.DOUBLE_V_TYPE) ? " style=\" marker-start: url(#" + (arrowSVG.getId() + "2") + ");" :
                        (arrowsType.equals(ArrowsTypeEnum.DIAMOND_BLACK) || arrowsType.equals(ArrowsTypeEnum.DIAMOND_WHITE) || arrowsType.equals(ArrowsTypeEnum.V_TYPE_READ) ? " style=\" marker-start: url(#" + arrowSVG.getId() + ");\"" : ""))
                ;
            }
            result += "/>\n";

            result += "<path class=\"connection\"  " + (solidLine ? "" : dashLine) + " d=\"M" + (conSvg.getX1()) + "," + (conSvg.getY1() + 10) + " C" + (conSvg.getX1()) + "," + (conSvg.getY1() + 15) +
                    "  " + (conSvg.getX1()) + "," + (conSvg.getY1() + 20) +
                    "  " + (conSvg.getX1() + 10) + "," + (conSvg.getY1() + 20) + "\"/>\n";

            result += "<path class=\"connection\"  " + (solidLine ? "" : dashLine) + " d=\"M" + (conSvg.getX1() + 10) + "," + (conSvg.getY1() + 20) + " L" + (conSvg.getX1() + 20) + "," + (conSvg.getY1() + 20) + " \"/>\n";
            result += "<path class=\"connection\"  " + (solidLine ? "" : dashLine) + " d=\"M" + (conSvg.getX1() + 20) + "," + (conSvg.getY1() + 20) + " C" + (conSvg.getX1() + 30) + "," + (conSvg.getY1() + 20) +
                    "  " + (conSvg.getX1() + 30) + "," + (conSvg.getY1() + 15) +
                    "  " + (conSvg.getX1() + 30) + "," + (conSvg.getY1() + 10) + "\"/>\n";


            result += "<path class=\"connection\" " + (solidLine ? "" : dashLine) + " d=\"M" + (conSvg.getX1() + 30) + "," + (conSvg.getY1() + 10) + " L" + (conSvg.getX1() + 30) + "," + (conSvg.getY2() + 5) + " \"/>\n";
            result += "<path class=\"connection\"" + (solidLine ? "" : dashLine) + " d=\"M" + (conSvg.getX1() + 30) + "," + (conSvg.getY2() + 5) + " C" + (conSvg.getX1() + 30) + "," + (conSvg.getY2()) +
                    "  " + (conSvg.getX1() + 25) + "," + (conSvg.getY2()) +
                    "  " + (conSvg.getX1() + 20) + "," + (conSvg.getY2()) + "\"/>\n";

            result += "<path class=\"connection\"  d=\"M" + (conSvg.getX2()) + "," + (conSvg.getY2()) + " L" + (conSvg.getX1() + 20) + "," + (conSvg.getY2()) + "\"";
            result += (solidLine ? "" : dashLine);
            if (!arrowsType.equals(ArrowsTypeEnum.DOUBLE_ORBIT) && !arrowsType.equals(ArrowsTypeEnum.NORMAL)) {
                result += (arrowsType.equals(ArrowsTypeEnum.DIAMOND_BLACK) || arrowsType.equals(ArrowsTypeEnum.DIAMOND_WHITE) || arrowsType.equals(ArrowsTypeEnum.V_TYPE_READ) ? "" : " style=\"marker-end: url(#" + arrowSVG.getId() + ");\"")
                ;
            }
            result += "/>\n";
            System.out.println("wwwww result -- " + result);


        } else {
            if (conSvg.getBendPointses() != null && conSvg.getBendPointses().size() > 0) {
                result += "<path class=\"connection\" d=\"" + makeDimWithBendPoints(conSvg) + "\"";
            } else {
                result += "<path class=\"connection\" d=\"M" + conSvg.getX1() + "," + conSvg.getY1() + " L" + (conSvg.getX2()) + "," + (conSvg.getY2() + "\"");
            }
            result += (solidLine ? "" : dashLine);

            if (!arrowsType.equals(ArrowsTypeEnum.DOUBLE_ORBIT) && !arrowsType.equals(ArrowsTypeEnum.NORMAL)) {
                result += " style=\"" + (arrowsType.equals(ArrowsTypeEnum.DOUBLE_V_TYPE) ? " marker-start: url(#" + (arrowSVG.getId() + "2") + ");" : "")
                        + (arrowsType.equals(ArrowsTypeEnum.DIAMOND_BLACK) || arrowsType.equals(ArrowsTypeEnum.DIAMOND_WHITE) || arrowsType.equals(ArrowsTypeEnum.V_TYPE_READ) ?
                        " marker-start: url(#" + arrowSVG.getId() + ");\"" : " marker-end: url(#" + arrowSVG.getId() + ");\"")
                ;
            }
            result += "/>\n";
        }
        if (arrowsType.equals(ArrowsTypeEnum.DOUBLE_ORBIT)) {
            result += "<circle class=\"arrows " + arrowsType.toString() + "\" cx=\"" + conSvg.getX2() + "\" cy=\"" + conSvg.getY2() + "\" r=\"3\" />\n";
        }
        System.out.println("---- cccc ---> Connection : Source : " + conSvg.getSourceName() + " to : Target : " + conSvg.getTargetName() + " SVG Code : \n" + result);
        return result;


    }

    private static ConnectionSVG positionCondition(SVGSingleShape source, SVGSingleShape target) {
        // the border should avoid from startpoint/endpoint connection
        int n = 2;
        boolean ownConnection = false;
        ConnectionSVG conSVG = null;
        if (source == null || target == null) return null;
        boolean hasBendPoint = (source.getConnectionBendPointsList() != null && source.getConnectionBendPointsList().size() > 0);
        if (source.getId() != null && source.getId().equals(target.getId())) {
            return selfPointing(source, target);
        } else {
            conSVG = new ConnectionSVG();
            int x1 = source.getX();
            int w1 = source.getWidth();
            int y1 = source.getY();
            int h1 = source.getHeight();
            int x2 = target.getX();
            int w2 = target.getWidth();
            int y2 = target.getY();
            int h2 = target.getHeight();
            conSVG.setId(source.getId() + "-" + System.currentTimeMillis());
            conSVG.setWidth(1);
//        System.out.println("--00---------> Source name : " + source.getName() + " x1 = " + x1 + " - source.Width() = " + w1 + " - x1+Width() = " + (x1 + w1));
//        System.out.println("--00---------> y1 = " + y1 + " h1 = " + h1 + " - y1+Height = " + (y1 + h1));
//        System.out.println("--00---------> Target name : " + target.getName() + " x2 = " + x2 + " - target.Width() = " + w2 + " - x2+Width() = " + (x2 + w2));
//        System.out.println("--00---------> y2 = " + y2 + " - target.getHeight() = " + target.getHeight() + " - y2+Height = " + (y2 + target.getHeight()));
            if (x1 > x2) {
                System.out.println("---> x1>x2");
                if (x1 > (x2 + w2)) {
                    System.out.println("----> x1>(x2+w2)");
                    if (y1 > y2) {
                        System.out.println("-----> y1>y2)");
                        if (y1 > (y2 + h2)) {
                            if (hasBendPoint) {
                                System.out.println("------> y1>(y2+h2) + bendpoints");
                                conSVG.setX1(x1 + w1 / 2);
                                conSVG.setX2(x2 + w2 + shapeBorderWidth);
                                conSVG.setY1(y1 - shapeBorderWidth);
                                conSVG.setY2(y2 + h2 / 2);
                                while (checkDuplicateConnection(conSVG)) {
                                    conSVG.setX2(conSVG.getX2() - 1);
                                    conSVG.setY1(conSVG.getY1() + 1);
                                }
                            } else {
                                System.out.println("------> y1>(y2+h2)");
                                conSVG.setX1(x1 - shapeBorderWidth);
                                conSVG.setX2(x2 + w2 + shapeBorderWidth);
                                conSVG.setY1(y1 - shapeBorderWidth);
                                conSVG.setY2(y2 + h2 + shapeBorderWidth);
                                while (checkDuplicateConnection(conSVG)) {
                                    conSVG.setX2(conSVG.getX2() - 1);
                                    conSVG.setY1(conSVG.getY1() + 1);
                                }
                            }
                        } else {
                            if (hasBendPoint) {
                                if (y1 > y2 + h2 / 2) {
                                    System.out.println("------> y1<=(y2+h2) && y1>y2+h2/2 +bindPoint");
                                    conSVG.setX1(x1 + w1 / 2);
                                    conSVG.setX2(x2 + w2 + shapeBorderWidth);
                                    conSVG.setY1(y1);
                                    conSVG.setY2(y2 + h2 / 2);
                                    while (checkDuplicateConnection(conSVG)) {
                                        conSVG.setY2(conSVG.getY2() - 1);
                                        conSVG.setY1(conSVG.getY1() - 1);
                                    }
                                } else {
                                    System.out.println("------> y1<=(y2+h2)&& y1<y2+h2/2 +bindPoint");
                                    conSVG.setX1(x1 - shapeBorderWidth);
                                    conSVG.setX2(x2 + w2 + shapeBorderWidth);
                                    conSVG.setY1(y1 + h1 / 2);
                                    conSVG.setY2(y1 + h1 / 2);
                                    while (checkDuplicateConnection(conSVG)) {
                                        conSVG.setY2(conSVG.getY2() - 1);
                                        conSVG.setY1(conSVG.getY1() - 1);
                                    }
                                }
                            } else {
                                System.out.println("------> y1<=(y2+h2)");
                                conSVG.setX1(x1 - shapeBorderWidth);
                                conSVG.setX2(x2 + w2 + shapeBorderWidth);
                                conSVG.setY1(y1 + h1 / 2);
                                conSVG.setY2(y1 + h1 / 2 > y2 && y1 + h1 / 2 < y2 + h2 ? y1 + h1 / 2 : y2 + h2 / 2);
                                while (checkDuplicateConnection(conSVG)) {
                                    conSVG.setY2(conSVG.getY2() - 1);
                                    conSVG.setY1(conSVG.getY1() - 1);
                                }
                            }
//                        conSVG.setY1(y1 + 2);
//                        conSVG.setY2((y1 + 2) > y2 && (y1 + 2) < y2 + h2 ? (y1 + 2) : y2 + h2 - 2);
//                     conSVG.setX1(x1);
//                        conSVG.setX2(x2 + w2);
//                        conSVG.setY1(y1 + h1 / 2);
//                        conSVG.setY2(y2 + h2 / 2);
                        }
                    } else {
                        System.out.println("-----> y2>y1)");
                        if (y2 > (y1 + h1)) {
                            if (hasBendPoint) {
                                System.out.println("----> y2>(y1+h1)+bind points");
                                conSVG.setX1(x1 - shapeBorderWidth);
                                conSVG.setX2(x2 + w2 / 2);
                                conSVG.setY1(y1 + h1 / 2);
                                conSVG.setY2(y2 - shapeBorderWidth);
                            } else {
                                System.out.println("----> y2>(y1+h1)");
                                conSVG.setX1(x1 - shapeBorderWidth);
                                conSVG.setX2(x2 + w2 + shapeBorderWidth);
                                conSVG.setY1(y1 + h1 + shapeBorderWidth);
                                conSVG.setY2(y2 - shapeBorderWidth);
                            }
                        } else {
                            if (hasBendPoint) {
                                System.out.println("----> y2<(y1+h1)+bind points");
                                if (y1 + h1 / 2 > y2) {
                                    conSVG.setX1(x1 - shapeBorderWidth);
                                    conSVG.setX2(x2 + w2 + shapeBorderWidth);
                                    conSVG.setY1(y1 + h1 / 2);
                                    conSVG.setY2(y1 + h1 / 2);
                                } else {
                                    conSVG.setX1(x1 - shapeBorderWidth);
                                    conSVG.setX2(x2 + w2 / 2);
                                    conSVG.setY1(y1 + h1 / 2);
                                    conSVG.setY2(y2);
                                }
                            } else {

                                System.out.println("----> y2< (y1+h1)");

//
                                if (y2 == (y1 + h1)) {
                                    conSVG.setX1(x1 - shapeBorderWidth);
                                    conSVG.setX2(x2 + w2 + shapeBorderWidth);
                                    conSVG.setY1(y2);
                                    conSVG.setY2(y2);
                                } else {
//                                    int n = 2;
                                    while (true) {
                                        if (y2 + h2 / n < y1 + h1) {
                                            // System.out.println("------> y2 + h2 /" + n + " < y1 + h1");
                                            conSVG.setX1(x1 - shapeBorderWidth);
                                            conSVG.setX2(x2 + w2 + shapeBorderWidth);
                                            conSVG.setY1(y2 + h2 / n);
                                            conSVG.setY2(y2 + h2 / n);

                                            //        System.out.println("----------2----------------------------------------    y2 + h2 / " + n + " = " + (y2 + h2 / n) + " | y1 + h1 = " + ( y1 + h1) + "   |    n = " + n  );

                                            break;

                                        } else {
                                            n++;
                                        }
                                    }
                                }
//                                conSVG.setX1(x1 - shapeBorderWidth);
//                                conSVG.setX2(x2 + w2 + shapeBorderWidth);
//                                if (y2 + h2 / 2 < y1 + w1) {
//                                    conSVG.setY1(y2 + h2 / 2);
//                                    conSVG.setY2(y2 + h2 / 2);
//                                } else {
//                                    conSVG.setY1(y2 + 1);
//                                    conSVG.setY2(y2 + 1);
//                                }
                            }
//                        conSVG.setY1(y1+ 2);
//                        conSVG.setY1(y1 + h1 / 2);
//                        conSVG.setY2((y1 +2)> y2&& (y1 +2)< y2 + h2? (y1 +2):y2 + h2 - 2);
//                        conSVG.setY2(y2 + h2 / 2);
                        }
                    }

                } else {
                    // x1>x2
                    System.out.println("----> x1<=(x2+w2)");
                    if (y1 > y2) {
                        System.out.println("-----> y1>y2");
                        if (y1 > (y2 + h2)) {
                            // System.out.println("------> y1>(y2+h2)");
                            long time = System.currentTimeMillis();
                            //        System.out.println("before While **********_----------------------------- +"+time);
//                            int n = 2;
                            //        System.out.println("           3           ----------------------------------    x1  " + x1 + " w1 " + w1  + "   x1 + w1 / " + n + " = " + (x1 + w1 / n) + " |  x2 + w2 = " + ( x2 + w2) + "   |    n = " + n + "   |    source.getName = " + source.getName() );
                            if (x1 == (x2 + w2)) {
                                conSVG.setX1(x1);
                                conSVG.setX2(x1);
                                conSVG.setY1(y1 - shapeBorderWidth);
                                conSVG.setY2(y2 + h2 + shapeBorderWidth);
                            } else {
                                while (true) {
                                    if (x1 + w1 / n < x2 + w2) {
                                        // System.out.println("------> x1 + w1 / " + n + " < x2 + w2");
                                        conSVG.setX1(x1 + w1 / n);
                                        conSVG.setX2(x1 + w1 / n);
                                        conSVG.setY1(y1 - shapeBorderWidth);
                                        conSVG.setY2(y2 + h2 + shapeBorderWidth);
                                        //        System.out.println("----------3------------------------------------------    x1 + w1 / " + n + " = " + (x1 + w1 / n) + " |  x2 + w2 = " + (x2 + w2) + "   |    n = " + n + "   |    source.getName = " + source.getName());

                                        break;

                                    } else {
                                        n++;
//                                 //        System.out.println("----------n  3------------------------------------------    " + n   );
                                    }
                                }
                            }

                            //        System.out.println("after While **********_----------------------------- +"+(System.currentTimeMillis()-time));

//                            if (x1 + w1 / 2 > x2 + w2) {
//                                conSVG.setX1(x1 + w1 / 2);
//                                conSVG.setX2(x1 + w1 / 2);
//                            } else {
//                                conSVG.setX1(x1 + 1);
//                                conSVG.setX2(x1 + 1);
//                            }
//                            conSVG.setY1(y1 - shapeBorderWidth);
//                            conSVG.setY2(y2 + h2 + shapeBorderWidth);

                        } else {
                            System.out.println("------> y1<=(y2+h2)");
                            conSVG.setX1(x1 - shapeBorderWidth);
                            conSVG.setX2(x2 + w2 / 2 + shapeBorderWidth);
                            conSVG.setY1(y1 + h1 / 2 - shapeBorderWidth);
                            conSVG.setY2(y2 + h2 + shapeBorderWidth);
                        }
                    } else {
                        System.out.println("-----> y2>y1");
                        if (y2 > (y1 + h1)) {
                            System.out.println("----> y2>(y1+h1)");
                            conSVG = ComUtils.getBestPoint(source, target);
//                            if (x1 + w1 / 2 > x2 + w2) {
//                                conSVG.setX1(x1 - shapeBorderWidth);
//                                conSVG.setX2(x2 + w2 / 2);
//                                conSVG.setY1(y1 + h1 / 2);
//                                conSVG.setY2(y2 - shapeBorderWidth);
//                            } else {
//                                conSVG.setX1(x1 + w1 / 2);
//                                conSVG.setX2(x1 + w1 / 2);
////                                conSVG.setX2(x1 + w1 / 2 > x2 && x1 + w1 / 2 < x2 + w2 ? x1 + w1 / 2 : x2 + w2);
////                        conSVG.setX2(x2 + w2 / 2);
//                                conSVG.setY1(y1 + h1 + shapeBorderWidth);
//                                conSVG.setY2(y2 - shapeBorderWidth);
//                            }

                        } else {
                            System.out.println("----> y2<=(y1+h1)");
                            conSVG.setX1(x1 - shapeBorderWidth);
                            conSVG.setX2(x2 + w2 / 2);
                            conSVG.setY1(y1 + h1 / 2);
                            conSVG.setY2(y2 + h2 + shapeBorderWidth);
                        }
                    }
                }
            } else {
                System.out.println("---> x2>x1");
                if (x2 > (x1 + w1)) {
                    System.out.println("----> x2>(x1+w1)");
                    if (y1 > y2) {
                        System.out.println("-----> y1>y2)");
                        if (y1 > (y2 + h2)) {
                            System.out.println("------> y1>(y2+h2)");
                            conSVG.setX1(x1 + w1 + shapeBorderWidth);
                            conSVG.setX2(x2 - shapeBorderWidth);
                            conSVG.setY1(y1 - shapeBorderWidth);
                            conSVG.setY2(y2 + h2 + shapeBorderWidth);
                        } else {
                            // System.out.println("------> y1<=(y2+h2)");
                            if (y1 == (y2 + h2)) {
                                conSVG.setX1(x1 + w1 + shapeBorderWidth);
                                conSVG.setX2(x2 - shapeBorderWidth);
                                conSVG.setY1(y1);
                                conSVG.setY2(y1);
                            } else {
                                while (true) {
                                    if (y1 + h1 / n < y2 + h2) {
                                        System.out.println("------> y1 + h1 /" + n + " < y2 + h2");
                                        conSVG.setX1(x1 + w1 + shapeBorderWidth);
                                        conSVG.setX2(x2 - shapeBorderWidth);
                                        conSVG.setY1(y1 + h1 / n);
                                        conSVG.setY2(y1 + h1 / n);
                                        break;

                                    } else {
                                        n++;
                                    }
                                }
                            }
//                            conSVG.setX1(x1 + w1 + shapeBorderWidth);
//                            conSVG.setX2(x2 - shapeBorderWidth);
//                            conSVG.setY1(y1 + h1 / 2);
//                            conSVG.setY2((y1 + h1 / 2) < (y2 + h2) ? (y1 + h1 / 2) : y2 + h2 / 2);
//                        conSVG.setY2(y2 + h2 / 2);
                            while (checkDuplicateConnection(conSVG)) {
                                System.out.println("heree1");
                                conSVG.setY2(conSVG.getY2() - 20);
                                conSVG.setY1(conSVG.getY1() - 20);
                            }
                        }
                    } else {
                        // x2>x1
                        // x2>(x1+w1)
                        System.out.println("-----> y1<y2)");
                        if (y2 > (y1 + h1)) {
                            System.out.println("----> y2>(y1+h1)");
                            conSVG.setX1(x1 + w1 + shapeBorderWidth);
                            conSVG.setX2(x2 - shapeBorderWidth);
                            conSVG.setY1(y1 + h1 + shapeBorderWidth);
                            conSVG.setY2(y2 - shapeBorderWidth);
                        } else {
                            // System.out.println("------> y2<=(y1+h1)");
                            if (y2 == (y1 + h1)) {
                                conSVG.setX1(x1 + w1 + shapeBorderWidth);
                                conSVG.setX2(x2 - shapeBorderWidth);
                                conSVG.setY1(y1);
                                conSVG.setY2(y1);
                            } else {
//                                int n = 2;
                                while (true) {
                                    if (y2 + h2 / n < y1 + h1) {
                                        // System.out.println("------> y2 + h2 /" + n + " < y1 + h1");
                                        conSVG.setX1(x1 + w1 + shapeBorderWidth);
                                        conSVG.setX2(x2 - shapeBorderWidth);
                                        conSVG.setY1(y2 + h2 / n);
                                        conSVG.setY2(y2 + h2 / n);
                                        //        System.out.println("----------5--------------------------------------------------     y2 + h2 / " + n + " = " + (y2 + h2 / n) + " | y1 + h1 = " + (y1 + h1) + "   |    n = " + n);

                                        break;

                                    } else {
                                        n++;
                                    }
                                }
                            }

                            conSVG.setX1(x1 + w1 + shapeBorderWidth);
//                            conSVG.setX2(x2 - shapeBorderWidth);
//                            if (y2 + h2 / 2 < y1 + h1) {
//                                conSVG.setY1(y2 + h2 / 2);
//                                conSVG.setY2(y2 + h2 / 2);
//                            } else {
//                                conSVG.setX1(y2 + 1);
//                                conSVG.setX2(y2 + 1);
//                            }
//                        // System.out.println(source.getName()+"_+_+_+_+_"+target.getName()+"_+_+_+_+_"+source.getConnectionsType());
//                        // System.out.println("conSVG.getX1()_ "+conSVG.getX1()+" conSVG.getY1()_"+conSVG.getY1()+" conSVG.getX2()_"+conSVG.getX2()+" conSVG.getY2()_"+conSVG.getY2());
                            while (checkDuplicateConnection(conSVG)) {
                                System.out.println("heree1");
                                conSVG.setY2(conSVG.getY2() - 20);
                                conSVG.setY1(conSVG.getY1() - 20);
                            }
//                        conSVG.setY2(y2 + h2 / 2);
//                        conSVG.setY1(y1 + h1 / 2);
//                        conSVG.setY2(y2 + h2 / 2);
//

                        }
                    }
                } else {
                    // x2>x1
                    System.out.println("----> x2<=(x1+w1)");
                    if (y1 > y2) {
                        System.out.println("-----> y1>y2)");
                        if (y1 > (y2 + h2)) {
                            System.out.println("------> y1>(y2+h2)");

                            if (x2 == (x1 + w1)) {
                                conSVG.setX1(x2);
                                conSVG.setX2(x2);
                                conSVG.setY1(y1 - shapeBorderWidth);
                                conSVG.setY2(y2 + h2 + shapeBorderWidth);
                            } else {
//                                int n = 2;
                                while (true) {
                                    if (x2 + w2 / n < x1 + w1) {
                                        // System.out.println("------> x2 + w2 / " + n + " < x1 + w1");
                                        conSVG.setX1(x2 + w2 / n);
                                        conSVG.setX2(x2 + w2 / n);
                                        conSVG.setY1(y1 - shapeBorderWidth);
                                        conSVG.setY2(y2 + h2 + shapeBorderWidth);
                                        //        System.out.println("----------6----------------------------------------------- x2+w2/" + n + " = " + (x2 + w2 / n) + " |  x1+w1 = " + (x1 + w1) + " |   n = " + n);

                                        break;

                                    } else {
                                        n++;
                                    }
                                }
                            }


//                            if (x2 + w2 / 2 > x1 + w1) {
//                                conSVG.setX1(x1 + w2 / 2);
//                                conSVG.setX2(x1 + w2 / 2);
//                            } else {
//                                conSVG.setX1(x2 + 1);
//                                conSVG.setX2(x2 + 1);
//                            }
//                            conSVG.setY1(y1 - shapeBorderWidth);
//                            conSVG.setY2(y2 + h2 + shapeBorderWidth);

                        } else {
                            System.out.println("------> y1<=(y2+h2)");
                            conSVG.setX1(x1 + w1 / 2);
                            conSVG.setX2(x2 - shapeBorderWidth);
                            conSVG.setY1(y1 - shapeBorderWidth);
                            conSVG.setY2(y2);
                        }
                    } else {
                        // x2<=(x1+w1)
                        if (y2 > (y1 + h1)) {

                            // System.out.println("----> y2>(y1+h1)");
                            if (x2 == (x1 + w1)) {
                                conSVG.setX1(x2);
                                conSVG.setX2(x2);
                                conSVG.setY1(y1 + h1 + shapeBorderWidth);
                                conSVG.setY2(y2 - shapeBorderWidth);
                            } else {
//                                int n = 2;
                                while (true) {
                                    if (x2 + w2 / n < x1 + w1) {
                                        // System.out.println("------> x2 + w2 / " + n + " < x1 + w1");
                                        conSVG.setX1(x2 + w2 / n);
                                        conSVG.setX2(x2 + w2 / n);
                                        conSVG.setY1(y1 + h1 + shapeBorderWidth);
                                        conSVG.setY2(y2 - shapeBorderWidth);
                                        //        System.out.println("----------1------------------------------------------------       x2+w2/" + n + " = " + (x2 + w2 / n) + " |  x1+w1 = " + (x1 + w1) + "   |    n = " + n);
                                        break;

                                    } else {
                                        n++;
                                    }
                                }
                            }

//                            if (x2 + w2 / 2 > x1 + w1) {
//                                conSVG.setX1(x1 + w2 / 2);
//                                conSVG.setX2(x1 + w2 / 2);
//                            } else {
//                                conSVG.setX1(x2 + 1);
//                                conSVG.setX2(x2 + 1);
//                            }
//                            conSVG.setY1(y1 + h1 + shapeBorderWidth);
//                            conSVG.setY2(y2 - shapeBorderWidth);
                        } else {
                            System.out.println("------> y2<=(y1+h1)");
                            conSVG.setX1(x1 + w1 / 2);
                            conSVG.setX2(x2 - shapeBorderWidth);
                            conSVG.setY1(y1 + h1 + shapeBorderWidth);
                            conSVG.setY2(y2);
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

    private static ConnectionSVG selfPointing(SVGSingleShape source, SVGSingleShape target) {
        // the border should avoid from startpoint/endpoint connection

        ConnectionSVG conSVG = null;
        if (source == null || target == null) return null;
        // boolean hasBendPoint = (source.getConnectionBendPointsList() != null && source.getConnectionBendPointsList().size() > 0);
        conSVG = new ConnectionSVG();
        conSVG.setX1(source.getX() + source.getWidth() - 20);
        conSVG.setX2(target.getX() + source.getWidth() + shapeBorderWidth);
        conSVG.setY1(source.getY() + source.getHeight() + shapeBorderWidth);
        conSVG.setY2(target.getY() + source.getHeight() - 20);
        conSVG.setOwnConnection(true);
        conSVG.setId(source.getId() + "-" + System.currentTimeMillis());
        conSVG.setWidth(1);


        return conSVG;
    }

    private static ConnectionSVG positionWithBendPoints(SVGSingleShape source, SVGSingleShape target) {
        // the border should avoid from startpoint/endpoint connection
       // boolean ownConnection = false;
        ConnectionSVG conSVG = null;
        if (source == null || target == null) return null;
        conSVG = new ConnectionSVG();
        int x1 = source.getX();
        int w1 = source.getWidth();
        int y1 = source.getY();
        int h1 = source.getHeight();
        int x2 = target.getX();
        int w2 = target.getWidth();
        int y2 = target.getY();
        int h2 = target.getHeight();
        BendPoints firstBendpoint = null;
        BendPoints lastBendPoint = null;
        if (source.getId() != null && source.getId().equals(target.getId())) {
            return selfPointing(source, target);
        }
        if (source.getConnectionBendPointsList() != null && source.getConnectionBendPointsList().size() > 0) {
            firstBendpoint = source.getConnectionBendPointsList().get(0);
            lastBendPoint = source.getConnectionBendPointsList().get(source.getConnectionBendPointsList().size() - 1);

            conSVG.setId(source.getId() + "-" + System.currentTimeMillis());
            conSVG.setWidth(1);
            System.out.println("--B  00---------> Source name : " + source.getName() + " x1 = " + x1 + " - w1 = " + w1 + " - x1+w1 = " + (x1 + w1));
            System.out.println("--B  00---------> y1 = " + y1 + " h1 = " + h1 + " - y1+h1 = " + (y1 + h1));
            System.out.println("--B  00---------> firstBendpoint.getStartX = " + firstBendpoint.getStartX() + " firstBendpoint.getStartY = " + firstBendpoint.getStartY());
            System.out.println("--B  00---------> Target name : " + target.getName() + " | x2 = " + x2 + " - w2 = " + w2 + " - x2+w2 = " + (x2 + w2));
            System.out.println("--B  00---------> y2 = " + y2 + " - h2 = " + target.getHeight() + " - y2+h2 = " + (y2 + target.getHeight()));
            System.out.println("--B  00---------> lastBendpoint.getEndX = " + lastBendPoint.getEndX() + " lastBendpoint.getEndY = " + lastBendPoint.getEndY());

            // Start Position
            if (x1 < x1 + w1 / 2 + firstBendpoint.getStartX()) {
                System.out.println("x1 < x1+w1/2+firstBendpoint.getStartX()");
                if (x1 + w1 < x1 + w1 / 2 + firstBendpoint.getStartX()) {
                    System.out.println("x1 + w1 < x1 + w1 / 2 + firstBendpoint.getStartX()");
                    if ((h1 / 2) >= Math.abs(firstBendpoint.getStartY())) {
                        System.out.println("------> (h1/2) >= Math.abs(firstBendpoint.getStartY()");
                        conSVG.setX1(x1 + w1 + shapeBorderWidth);
                        conSVG.setY1(y1 + h1 / 2 + firstBendpoint.getStartY());
                        System.out.println("X1 = " + conSVG.getX1() + " | Y1 : " + conSVG.getY1());
                    } else if (0 < firstBendpoint.getStartY()) {
                        System.out.println("0 < firstBendpoint.getStartY()");
                        conSVG.setX1(x1 + w1 + shapeBorderWidth);
                        conSVG.setY1(y1 + h1 + shapeBorderWidth);
                        System.out.println("X1 = " + conSVG.getX1() + " | Y1 : " + conSVG.getY1());
                    } else {
                        System.out.println("0 > firstBendpoint.getStartY()");
                        conSVG.setX1(x1 + w1 + shapeBorderWidth);
                        conSVG.setY1(y1 + shapeBorderWidth);
                        System.out.println("X1 = " + conSVG.getX1() + " | Y1 : " + conSVG.getY1());
                    }

                } else {
                    System.out.println("x1 + w1 > x1 + w1 / 2 + firstBendpoint.getStartX()");
                    if (0 > firstBendpoint.getStartY()) {
                        System.out.println("0 > firstBendpoint.getStartY()");
                        conSVG.setX1(x1 + w1 / 2 + firstBendpoint.getStartX());
                        conSVG.setY1(y1 - shapeBorderWidth);
                        System.out.println("X1 = " + conSVG.getX1() + " | Y1 : " + conSVG.getY1());
                    } else {
                        System.out.println("0 < firstBendpoint.getStartY()");
                        conSVG.setX1(x1 + w1 / 2 + firstBendpoint.getStartX());
                        conSVG.setY1(y1 + h1 + shapeBorderWidth);
                        System.out.println("X1 = " + conSVG.getX1() + " | Y1 : " + conSVG.getY1());
                    }

                }
            } else {
                System.out.println("x1 >=  x1+w1/2+firstBendpoint.getStartX()");
                if ((h1 / 2) >= Math.abs(firstBendpoint.getStartY())) {
                    System.out.println("left side ------> (h1/2) >= Math.abs(firstBendpoint.getStartY()");
                    conSVG.setX1(x1 - shapeBorderWidth);
                    conSVG.setY1(y1 + h1 / 2 + firstBendpoint.getStartY());
                    System.out.println("X1 = " + conSVG.getX1() + " | Y1 : " + conSVG.getY1());
                } else if (0 < firstBendpoint.getStartY()) {
                    System.out.println("0 < firstBendpoint.getStartY()");
                    conSVG.setX1(x1 - shapeBorderWidth);
                    conSVG.setY1(y1 + h1 + shapeBorderWidth);
                    System.out.println("X1 = " + conSVG.getX1() + " | Y1 : " + conSVG.getY1());
                } else {
                    System.out.println("0 > firstBendpoint.getStartY()");
                    conSVG.setX1(x1 - shapeBorderWidth);
                    conSVG.setY1(y1 + shapeBorderWidth);
                    System.out.println("X1 = " + conSVG.getX1() + " | Y1 : " + conSVG.getY1());
                }
            }

            // End point position
            if (x2 < x2 + w2 / 2 + lastBendPoint.getEndX()) {
                System.out.println("x2 <  x2 + w2 / 2 + lastBendPoint.getEndX()");
                if (x2 + w2 < x2 + w2 / 2 + lastBendPoint.getEndX()) {
                    System.out.println("x2 + w2 <  x2 + w2 / 2 + lastBendPoint.getEndX()");
                    if ((h2 / 2) >= Math.abs(lastBendPoint.getEndY())) {
                        System.out.println("------> (h2/2) >= Math.abs(lastBendPoint.getEndY()");
                        conSVG.setX2(x2 + w2 + shapeBorderWidth);
                        conSVG.setY2(y2 + h2 / 2 + lastBendPoint.getEndY());
                        System.out.println("X2 = " + conSVG.getX2() + " | Y2 : " + conSVG.getY2());
                    } else if (0 < lastBendPoint.getEndY()) {
                        System.out.println("0 < lastBendPoint.getEndY()");
                        conSVG.setX2(x2 + w2 + shapeBorderWidth);
                        conSVG.setY2(y2 + h2 + shapeBorderWidth);
                        System.out.println("X2 = " + conSVG.getX2() + " | Y2 : " + conSVG.getY2());
                    } else {
                        System.out.println("0 > lastBendPoint.getEndY()");
                        conSVG.setX2(x2 + w2 + shapeBorderWidth);
                        conSVG.setY2(y2 + shapeBorderWidth);
                        System.out.println("X2 = " + conSVG.getX2() + " | Y2 : " + conSVG.getY2());
                    }

                } else {
                    System.out.println("x2 + w2 >  x2 + w2 / 2 + lastBendPoint.getEndX()");
                    if (0 > lastBendPoint.getEndY()) {
                        System.out.println("0 > lastBendPoint.getEndY()");
                        conSVG.setX2(x2 + w2 / 2 + lastBendPoint.getEndX());
                        conSVG.setY2(y2 - shapeBorderWidth);
                        System.out.println("X2 = " + conSVG.getX2() + " | Y2 : " + conSVG.getY2());
                    } else {
                        System.out.println("0 < lastBendPoint.getEndY()");
                        conSVG.setX2(x2 + w2 / 2 + lastBendPoint.getEndX());
                        conSVG.setY2(y2 + h2 + shapeBorderWidth);
                        System.out.println("X2 = " + conSVG.getX2() + " | Y2 : " + conSVG.getY2());
                    }

                }
            } else {
                System.out.println("x2 >=  x2 + w2 / 2 + lastBendPoint.getEndX()");
                if ((h2 / 2) >= Math.abs(lastBendPoint.getEndY())) {
                    System.out.println("left side ------> (h2/2) >= Math.abs(lastBendPoint.getEndY()");
                    conSVG.setX2(x2 - shapeBorderWidth);
                    conSVG.setY2(y2 + h2 / 2 + lastBendPoint.getEndY());
                    System.out.println("X2 = " + conSVG.getX2() + " | Y2 : " + conSVG.getY2());
                } else if (0 < lastBendPoint.getEndY()) {
                    System.out.println("0 < lastBendPoint.getEndY()");
                    conSVG.setX2(x2 - shapeBorderWidth);
                    conSVG.setY2(y2 + h2 + shapeBorderWidth);
                    System.out.println("X2 = " + conSVG.getX2() + " | Y2 : " + conSVG.getY2());
                } else {
                    System.out.println("0 > lastBendPoint.getEndY()");
                    conSVG.setX2(x2 - shapeBorderWidth);
                    conSVG.setY2(y2 + shapeBorderWidth);
                    System.out.println("X2 = " + conSVG.getX2() + " | Y2 : " + conSVG.getY2());
                }
            }
        }

        System.out.println("bb   conSVG.getX1()----->> " + conSVG.getX1() + "  csvg.getX1___> " + conSVG.getX1());
        System.out.println("bb   conSVG.getX2()----->> " + conSVG.getX2() + "  csvg.getX2___> " + conSVG.getX2());
        System.out.println("bb   conSVG.getY1()----->> " + conSVG.getY1() + "  csvg.getY1___> " + conSVG.getY1());
        System.out.println("bb   conSVG.getY2()----->> " + conSVG.getY2() + "  csvg.getY2___> " + conSVG.getY2());

        return conSVG;
    }

    private static boolean checkDuplicateConnection(ConnectionSVG conSVG) {
        for (ConnectionSVG csvg : connectionCoordinates) {
            System.out.println("conSVG.getX1()----->> " + conSVG.getX1() + "  csvg.getX1___> " + csvg.getX1());
            System.out.println("conSVG.getX2()()----->> " + conSVG.getX2() + "  csvg.getX2___> " + csvg.getX2());
            System.out.println("conSVG.getY1()()----->> " + conSVG.getY1() + "  csvg.getY1___> " + csvg.getY1());
            System.out.println("conSVG.getY2()()----->> " + conSVG.getY2() + "  csvg.getY2___> " + csvg.getY2());
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

    private static boolean isInternalConnection(ConnectionSVG conSVG, SVGSingleShape source, SVGSingleShape target) {
        if (conSVG != null && source != null && target != null) {
            int cX1 = Math.abs(conSVG.getX1());
            int cX2 = Math.abs(conSVG.getX2());
            int cY1 = Math.abs(conSVG.getY1());
            int cY2 = Math.abs(conSVG.getY2());
            int sX = Math.abs(source.getX());
            int sY = Math.abs(source.getY());
            int sX2 = Math.abs(source.getX() + Math.abs(source.getWidth()));
            int sY2 = Math.abs(source.getY() + Math.abs(source.getHeight()));
            int tX = Math.abs(target.getX());
            int tY = Math.abs(target.getY());
            int tX2 = Math.abs(target.getX() + Math.abs(target.getWidth()));
            int tY2 = Math.abs(target.getY() + Math.abs(target.getHeight()));

            if ((cX1 >= sX && cX1 <= sX2 && cY1 >= sY && cY1 <= sY2) || (cX2 >= sX && cX2 <= sX2 && cY2 >= sY && cY2 <= sY2)) {
                System.out.println(
                        "if(cX1>=sX && cX1<=sX2 && cY1>=sY && cY1<=sY2)" +
                                "\nSource Name : " + source.getName() +
                                " | Target Name : " + target.getName() +
                                "\n conSVG.getX1() : " + conSVG.getX1() +
                                " | conSVG.getY1 () : " + conSVG.getY1() +
                                " | conSVG.getX2() : " + conSVG.getX2() +
                                " | conSVG.getY2() : " + conSVG.getY2() +
                                "\n  source.getX() : " + source.getX() +
                                " | source.getY() : " + source.getY() +
                                " | source.getWidth() : " + source.getWidth() +
                                " | source.getHeight() : " + source.getHeight() +
                                "\n  target.getX() : " + target.getX() +
                                " | target.getY() : " + target.getY() +
                                " | target.getWidth() : " + target.getWidth() +
                                " | target.getHeight() : " + target.getHeight());
                return true;
            } else if ((cX1 >= tX && cX1 <= tX2 && cY1 >= tY && cY1 <= tY2) || (cX2 >= tX && cX2 <= tX2 && cY2 >= tY && cY2 <= tY2)) {
                System.out.println(
                        "cX1>=tX && cX1<=tX2 && cY1>=tY  && cY1<=tY2" +
                                "\nSource Name : " + source.getName() +
                                " | Target Name : " + target.getName() +
                                "\n conSVG.getX1() : " + conSVG.getX1() +
                                " | conSVG.getY1 () : " + conSVG.getY1() +
                                " | conSVG.getX2() : " + conSVG.getX2() +
                                " | conSVG.getY2() : " + conSVG.getY2() +
                                "\n  source.getX() : " + source.getX() +
                                " | source.getY() : " + source.getY() +
                                " | source.getWidth() : " + source.getWidth() +
                                " | source.getHeight() : " + source.getHeight() +
                                "\n  target.getX() : " + target.getX() +
                                " | target.getY() : " + target.getY() +
                                " | target.getWidth() : " + target.getWidth() +
                                " | target.getHeight() : " + target.getHeight());
                return true;
            }
        }

        return false;
    }

//    protected static int[] getFirstLastDim() {
//        return new int[]{FIRST_X, FIRST_Y, LAST_X, LAST_Y};
//    }

    private static String calculateJoints(int x1, int y1, int bendPointX, int bendPointY, int x2, int y2, int dashWidth, int dashGap) {

        String result = "";
        result += "<path class=\"connection\" stroke-dasharray=\"" + dashWidth + "," + dashGap + "\" ";
        if (y1 == bendPointY) {
            if (x1 > bendPointX) {
                if (bendPointY < y2) {
                    result += "d=\"M" + (bendPointX + 10) + "," + bendPointY + " C" + bendPointX + "," + bendPointY + "  " + bendPointX + "," + (bendPointY + 5) + "  " + bendPointX + "," + (bendPointY + 10) + "\"/>\n";
                } else {
                    result += "d=\"M" + (bendPointX + 10) + "," + bendPointY + " C" + bendPointX + "," + bendPointY + "  " + bendPointX + "," + (bendPointY - 5) + "  " + bendPointX + "," + (bendPointY - 10) + "\"/>\n";
                }

            } else {
                if (bendPointY < y2) {
                    result += "d=\"M" + (bendPointX - 10) + "," + bendPointY + " C" + bendPointX + "," + bendPointY + "  " + bendPointX + "," + (bendPointY + 5) + "  " + bendPointX + "," + (bendPointY + 10) + "\"/>\n";
                } else {
                    result += "d=\"M" + (bendPointX - 10) + "," + bendPointY + " C" + bendPointX + "," + bendPointY + "  " + bendPointX + "," + (bendPointY - 5) + "  " + bendPointX + "," + (bendPointY - 10) + "\"/>\n";
                }
            }
        }
        if (x1 == bendPointX) {
            if (y1 > bendPointY) {
                if (bendPointX < x2) {
                    result += "d=\"M" + x1 + "," + y1 + " C" + bendPointX + "," + bendPointY + "  " + bendPointX + "," + (bendPointY + 5) + "  " + bendPointX + "," + (bendPointY + 10) + "\"/>\n";
                } else {
                    result += "d=\"M" + (bendPointX + 10) + "," + bendPointY + " C" + bendPointX + "," + bendPointY + "  " + bendPointX + "," + (bendPointY - 5) + "  " + bendPointX + "," + (bendPointY - 10) + "\"/>\n";
                }

            } else if (y1 < bendPointY) {
                if (bendPointX < x2) {
                    result += "d=\"M" + (bendPointX - 10) + "," + bendPointY + " C" + bendPointX + "," + bendPointY + "  " + bendPointX + "," + (bendPointY + 5) + "  " + bendPointX + "," + (bendPointY + 10) + "\"/>\n";
                } else {
                    result += "d=\"M" + (bendPointX - 10) + "," + bendPointY + " C" + bendPointX + "," + bendPointY + "  " + bendPointX + "," + (bendPointY - 5) + "  " + bendPointX + "," + (bendPointY - 10) + "\"/>\n";
                }
            }
        }
//        result += "<path class=\"connection\"   stroke-dasharray=\"" + dashWidth + "," + dashGap + "\" d=\"M" + (conSvg.getX1()) + "," + (conSvg.getY1() + 10) + " C" + (conSvg.getX1()) + "," + (conSvg.getY1() + 15) +
//                        "  " + (conSvg.getX1()) + "," + (conSvg.getY1() + 20) +
//                        "  " + (conSvg.getX1() + 10) + "," + (conSvg.getY1() + 20) + "\"/>\n";
//
//        result += "<path class=\"connection\"    stroke-dasharray=\"" + dashWidth + "," + dashGap + "\" d=\"M" + (conSvg.getX1() + 10) + "," + (conSvg.getY1() + 20) + " L" + (conSvg.getX1() + 20) + "," + (conSvg.getY1() + 20) + " \"/>\n";
//        result += "<path class=\"connection\"   stroke-dasharray=\"" + dashWidth + "," + dashGap + "\" d=\"M" + (conSvg.getX1() + 20) + "," + (conSvg.getY1() + 20) + " C" + (conSvg.getX1() + 30) + "," + (conSvg.getY1() + 20) +
//                "  " + (conSvg.getX1() + 30) + "," + (conSvg.getY1() + 15) +
//                "  " + (conSvg.getX1() + 30) + "," + (conSvg.getY1() + 10) + "\"/>\n";
//
//
//        result += "<path class=\"connection\"   stroke-dasharray=\"" + dashWidth + "," + dashGap + "\" d=\"M" + (conSvg.getX1() + 30) + "," + (conSvg.getY1() + 10) + " L" + (conSvg.getX1() + 30) + "," + (conSvg.getY2() + 5) + " \"/>\n";
//        result += "<path class=\"connection\"  stroke-dasharray=\"" + dashWidth + "," + dashGap + "\" d=\"M" + (conSvg.getX1() + 30) + "," + (conSvg.getY2() + 5) + " C" + (conSvg.getX1() + 30) + "," + (conSvg.getY2()) +
//                "  " + (conSvg.getX1() + 25) + "," + (conSvg.getY2()) +
//                "  " + (conSvg.getX1() + 20) + "," + (conSvg.getY2()) + "\"/>\n";
//
//        result += "<path class=\"connection\"  d=\"M" + (conSvg.getX2()) + "," + (conSvg.getY2()) + " L" + (conSvg.getX1() + 20) + "," + (conSvg.getY2()) + "\"";
//
//        if (!arrowsType.equals(ArrowsTypeEnum.DOUBLE_ORBIT) && !arrowsType.equals(ArrowsTypeEnum.NORMAL)) {
//            result +=
//                    " stroke-dasharray=\"" + dashWidth + "," + dashGap + "\"  " +
//                            "" + (arrowsType.equals(ArrowsTypeEnum.DIAMOND_BLACK) || arrowsType.equals(ArrowsTypeEnum.DIAMOND_WHITE) ? "" : "style=\"marker-end: url(#" + arrowSVG.getId() + ");\"") + "/>\n"
//            ;
//        } else {
//            result += " stroke-dasharray=\"" + dashWidth + "," + dashGap + "\"/>\n";
//        }
//        ;

        System.out.println("wwwww result -- " + result);
        return result;

    }

}
