package com.Farzad.utils.ImageUtils;

import POJOs.ConnectionSVG;
import POJOs.SVGSingleShape;
import com.Farzad.Enums.ConnectionsEnum;

/**
 * Created by VOLCANO on 5/1/2017.
 */
class ConnectionTools {
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
        ConnectionSVG conSVG = positionCondition(source,target);
//        ConnectionSVG conSVG = new ConnectionSVG();
//        conSVG.setX1(source.getX() + source.getWidth() / 2);
//        conSVG.setX2(target.getX() + target.getWidth() / 2);
//        conSVG.setY1(source.getY());
//        conSVG.setY2(target.getY());
        conSVG.setWidth(source.getStrokeWidth());
        conSVG.setColor("black");
//        int lineWidth = source.getStrokeWidth();
        switch (connectionEnum) {
            case ACCESSES:
                return (makeLine(conSVG) + putText(conSVG, target));
//              return  " <circle cx=\"" + x1 + "\" cy=\"" + y1 + "\" r=\"3\" fill=\"#000000\" />" +
//                        "      <line stroke-dasharray=\"2, 2\" fill=\"black\" x1=\"" + x1 + "\" x2=\"" + x2 + "\" y1=\"" + y1 + "\" y2=\"" + y2 + "\" " +
//                        "stroke=\"#000000\" stroke-width=\"" + lineWidth + "\"/>\n" +
//                        "<circle cx=\"" + x2 + "\" cy=\"" + y2 + "\" r=\"3\" fill=\"#000000\" />";
            case USED_BY:
                return (makeLine(conSVG) + putText(conSVG, target));
//              " <polygon points=\"" + x1 + "," + y1 + " " + (x1+20) + "," + (y1-10) + " " + (x1+40) + "," + y1 + " " + (x1+50) + "," + (y1+10) + "\"/>" +
//                        "      <line fill=\"black\" x1=\"" + x1 + "\" x2=\"" + x2 + "\" y1=\"" + y1 + "\" y2=\"" + y2 + "\" " +
//                                "stroke=\"#000000\" stroke-width=\"" + lineWidth + "\"/>\n" +
//                                "<circle cx=\"" + x2 + "\" cy=\"" + y2 + "\" r=\"3\" fill=\"#000000\" />"+
//                                "      <text x=\"" + (x1+x2)/2 + "\" xml:space=\"preserve\" y=\"" + (y1+y2)/2 + "\" clip-path=\"url(#clipPath20)\" stroke=\"none\"\n" +
//                                "      font-family=\"" + source.getFont() + "\" fill=\"#000000\"  >" + target.getConnectionsType() + "</text>\n"
//                        ;
            case ASSIGNED:
                return (makeLineWithDoubleOrb(makeLine(conSVG), conSVG) + putText(conSVG, target));
//                return  " <circle cx=\"" + x1 + "\" cy=\"" + y1 + "\" r=\"3\" fill=\"#000000\" />" +
//                        "      <line fill=\"black\" x1=\"" + x1 + "\" x2=\"" + x2 + "\" y1=\"" + y1 + "\" y2=\"" + y2 + "\" " +
//                        "stroke=\"#000000\" stroke-width=\"" + lineWidth + "\"/>\n" +
//                        "<circle cx=\"" + x2 + "\" cy=\"" + y2 + "\" r=\"3\" fill=\"#000000\" />";
            case REALISES:
                conSVG.setDashArray(new int[]{5, 5});
                return (makeLine(conSVG) + putText(conSVG, target));
//                return  " <circle cx=\"" + x1 + "\" cy=\"" + y1 + "\" r=\"3\" fill=\"#000000\" />" +
//                        "      <line stroke-dasharray=\"5, 5\" fill=\"black\" x1=\"" + x1 + "\" x2=\"" + x2 + "\" y1=\"" + y1 + "\" y2=\"" + y2 + "\" " +
//                        "stroke=\"#000000\" stroke-width=\"" + lineWidth + "\"/>\n" +
//                        "<circle cx=\"" + x2 + "\" cy=\"" + y2 + "\" r=\"3\" fill=\"#000000\" />";
            case USES:
                return (makeLine(conSVG) + putText(conSVG, target));
//                return  " <circle cx=\"" + x1 + "\" cy=\"" + y1 + "\" r=\"3\" fill=\"#000000\" />" +
//                        "      <line fill=\"black\" x1=\"" + x1 + "\" x2=\"" + x2 + "\" y1=\"" + y1 + "\" y2=\"" + y2 + "\" " +
//                        "stroke=\"#000000\" stroke-width=\"" + lineWidth + "\"/>\n" +
//                        "<circle cx=\"" + x2 + "\" cy=\"" + y2 + "\" r=\"3\" fill=\"#000000\" />";
            case AGGREGATION:
                return (makeLine(conSVG) + putText(conSVG, target));
//                return  " <circle cx=\"" + x1 + "\" cy=\"" + y1 + "\" r=\"3\" fill=\"#000000\" />" +
//                        "      <line fill=\"black\" x1=\"" + x1 + "\" x2=\"" + x2 + "\" y1=\"" + y1 + "\" y2=\"" + y2 + "\" " +
//                        "stroke=\"#000000\" stroke-width=\"" + lineWidth + "\"/>\n" +
//                        "<circle cx=\"" + x2 + "\" cy=\"" + y2 + "\" r=\"3\" fill=\"#000000\" />";
            case ASSOCIATION:
                return (makeLine(conSVG) + putText(conSVG, target));
//                return  " <circle cx=\"" + x1 + "\" cy=\"" + y1 + "\" r=\"3\" fill=\"#000000\" />" +
//                        "      <line fill=\"black\" x1=\"" + x1 + "\" x2=\"" + x2 + "\" y1=\"" + y1 + "\" y2=\"" + y2 + "\" " +
//                        "stroke=\"#000000\" stroke-width=\"" + lineWidth + "\"/>\n" +
//                        "<circle cx=\"" + x2 + "\" cy=\"" + y2 + "\" r=\"3\" fill=\"#000000\" />";
            case READ_AND_WRITE:
                return (makeLine(conSVG) + putText(conSVG, target));
//                return  " <circle cx=\"" + x1 + "\" cy=\"" + y1 + "\" r=\"3\" fill=\"#000000\" />" +
//                        "      <line fill=\"black\" x1=\"" + x1 + "\" x2=\"" + x2 + "\" y1=\"" + y1 + "\" y2=\"" + y2 + "\" " +
//                        "stroke=\"#000000\" stroke-width=\"" + lineWidth + "\"/>\n" +
//                        "<circle cx=\"" + x2 + "\" cy=\"" + y2 + "\" r=\"3\" fill=\"#000000\" />";
            default:
                return (makeLine(conSVG) + putText(conSVG, target));
//                return  " <circle cx=\"" + x1 + "\" cy=\"" + y1 + "\" r=\"3\" fill=\"#000000\" />" +
//                        "      <line fill=\"black\" x1=\"" + x1 + "\" x2=\"" + x2 + "\" y1=\"" + y1 + "\" y2=\"" + y2 + "\" " +
//                        "stroke=\"#000000\" stroke-width=\"" + lineWidth + "\"/>\n" +
//                        "<circle cx=\"" + x2 + "\" cy=\"" + y2 + "\" r=\"3\" fill=\"#000000\" />";
        }
    }

    private static String makeLine(ConnectionSVG svg) {
        int dashWidth = 0, dashGap = 0;
        if (svg.getDashArray() != null && svg.getDashArray().length > 1) {
            dashWidth = svg.getDashArray()[0];
            dashGap = svg.getDashArray()[1];
        }
        return "<line fill=\"black\" stroke-dasharray=\"" + dashWidth + "," + dashGap + "\" x1=\"" + svg.getX1() + "\" x2=\"" + svg.getX2() + "\" y1=\"" + svg.getY1() + "\" y2=\"" + svg.getY2() + "\" " +
                        "stroke=\"" + svg.getColor() + "\" stroke-width=\"" + svg.getWidth() + "\"/>\n";
    }

    private static String makeLineWithDoubleOrb(String line, ConnectionSVG svg) {

        return " <circle cx=\"" + svg.getX1() + "\" cy=\"" + svg.getY1() + "\" r=\"3\" fill=\"" + svg.getColor() + "\" />" +
                line +
                "<circle cx=\"" + svg.getX2() + "\" cy=\"" + svg.getY2() + "\" r=\"3\" fill=\"" + svg.getColor() + "\" />";
    }

    private static String makeSingleOrb(ConnectionSVG svg, int x, int y) {

        return " <circle cx=\"" + x + "\" cy=\"" + y + "\" r=\"3\" fill=\"" + svg.getColor() + "\" />";

    }

    private static String putText(ConnectionSVG svg, SVGSingleShape target) {

        return (target.getConnectionsType() != null ? "<text x=\"" + (svg.getX1() + svg.getX2()) / 2 + "\" xml:space=\"preserve\" y=\"" + (svg.getY1() + svg.getY2()) / 2 + "\" clip-path=\"url(#clipPath20)\" stroke=\"none\"\n" +
                "      font-family=\"" + target.getFont() + "\" fill=\"#000000\"  >" + target.getConnectionsType() + "</text>\n" : "");
//        return "      <text x=\"" + x + "\" xml:space=\"preserve\" y=\"" + y + "\" clip-path=\"url(#clipPath20)\" stroke=\"none\"\n" +
//                "      font-family=\"" + svgShape.getFont() + "\" fill=\"#FFFFFF\"  >" + svgShape.getName() + "</text>\n";
    }

    private static ConnectionSVG positionCondition(SVGSingleShape source, SVGSingleShape target) {
        int x1 = source.getX();
        int x11 = source.getWidth();
        int y1 = source.getY();
        int y11 = source.getHeight();
        int x2 = target.getX();
        int x22 = target.getWidth();
        int y2 = target.getY();
        int y22 = target.getHeight();
        ConnectionSVG conSVG = new ConnectionSVG();

        System.out.println("--00---------> Source name : "+source.getName()+" source.getX() = "+source.getX()+" - source.Width() = "+source.getWidth()+" - source.getX()+Width() = "+(source.getX()+ source.getWidth()) );
        System.out.println("--00---------> source.getY() = "+source.getY()+" source.getHeight() = "+source.getHeight()+" - source.getY()+Height = "+(source.getY()+ source.getHeight()) );
         System.out.println("--00---------> Target name : "+target.getName()+" target.getX() = "+target.getX()+" - target.Width() = "+target.getWidth()+" - target.getX()+Width() = "+(target.getX()+ target.getWidth()) );
        System.out.println("--00---------> target.getY() = "+target.getY()+" - target.getHeight() = "+target.getHeight()+" - target.getY()+Height = "+(target.getY()+ target.getHeight()) );
        if(x1>x2){
            System.out.println("---> x1>x2");
            if(x1>(x2+x22)){
                System.out.println("----> x1>(x2+x22)");
                if(y1>y2){
                    System.out.println("-----> y1>y2)");
                    if(y1>(y2+y22)){
                        System.out.println("------> y1>(y2+y22)");
                        conSVG.setX1(target.getX() + target.getWidth());
                        conSVG.setX2(source.getX());
                        conSVG.setY1(target.getY() + target.getHeight());
                        conSVG.setY2(source.getY());
                    }else{
                        System.out.println("------> y1<=(y2+y22)");
                        conSVG.setX1(target.getX() + target.getWidth());
                        conSVG.setX2(source.getX());
                        conSVG.setY1(target.getY() + target.getHeight()/2);
                        conSVG.setY2(source.getY()+ source.getHeight()/2);
                    }
                }else{
                    System.out.println("-----> y1<y2)");
                    if(y2>(y1+y11)){
                        System.out.println("----> y2>(y1+y11)");
                        conSVG.setX1(target.getX() + target.getWidth());
                        conSVG.setX2(source.getX());
                        conSVG.setY1(target.getY());
                        conSVG.setY2(source.getY()+ source.getHeight());
                    }else{
                        System.out.println("----> y2<=(y1+y11)");
                        conSVG.setX1(target.getX() + target.getWidth());
                        conSVG.setX2(source.getX());
                        conSVG.setY1(target.getY() + target.getHeight()/2);
                        conSVG.setY2(source.getY()+ source.getHeight()/2);
                    }
                }

            }else{
                System.out.println("----> x1<=(x2+x22)");
                if(y1>y2){
                    System.out.println("-----> y1>y2");
                    if(y1>(y2+y22)){
                        System.out.println("------> y1>(y2+y22)");
                        conSVG.setX1(target.getX() + target.getWidth()/2);
                        conSVG.setX2(source.getX() + source.getWidth()/2);
                        conSVG.setY1(target.getY() + target.getHeight());
                        conSVG.setY2(source.getY());
                    }else{
                        System.out.println("------> y1<=(y2+y22)");
                        conSVG.setX1(target.getX() + target.getWidth());
                        conSVG.setX2(source.getX());
                        conSVG.setY1(target.getY() + target.getHeight()/2);
                        conSVG.setY2(source.getY()+ source.getHeight()/2);
                    }
                }else{
                    if(y2>(y1+y11)){
                        System.out.println("----> y2>(y1+y11)");
                        conSVG.setX1(target.getX() + target.getWidth()/2);
                        conSVG.setX2(source.getX()+ source.getWidth()/2);
                        conSVG.setY1(target.getY());
                        conSVG.setY2(source.getY()+ source.getHeight());
                    }else{
                        System.out.println("----> y2<=(y1+y11)");
                        conSVG.setX1(target.getX() + target.getWidth()/2);
                        conSVG.setX2(source.getX());
                        conSVG.setY1(target.getY() + target.getHeight());
                        conSVG.setY2(source.getY()+ source.getHeight()/2);
                    }
                }
            }
        }else {
            System.out.println("---> x2>x1");
            if(x2>(x1+x11)){
                System.out.println("----> x2>(x1+x11)");
                if(y1>y2){
                    System.out.println("-----> y1>y2)");
                    if(y1>(y2+y22)){
                        System.out.println("------> y1>(y2+y22)");
                        conSVG.setX1(source.getX() + source.getWidth() );
                        conSVG.setX2(target.getX());
                        conSVG.setY1(source.getY());
                        conSVG.setY2(target.getY()+ target.getHeight());
                    }else{
                        System.out.println("------> y1<=(y2+y22)");
                        conSVG.setX1(source.getX() + source.getWidth());
                        conSVG.setX2(target.getX());
                        conSVG.setY1(source.getY() + source.getHeight()/2);
                        conSVG.setY2(target.getY()+ target.getHeight()/2);
                    }
                }else{
                    if(y2>(y1+y11)){
                        System.out.println("----> y2>(y1+y11)");
                        conSVG.setX1(source.getX() + source.getWidth());
                        conSVG.setX2(target.getX());
                        conSVG.setY1(source.getY()+ source.getHeight());
                        conSVG.setY2(target.getY());
                    }else{
                        System.out.println("------> y2<=(y1+y11)");
                        conSVG.setX1(source.getX() + source.getWidth());
                        conSVG.setX2(target.getX());
                        conSVG.setY1(source.getY() + source.getHeight()/2);
                        conSVG.setY2(target.getY()+ target.getHeight()/2);
                    }
                }
            }else{
                System.out.println("----> x2<=(x1+x11)");
                if(y1>y2){
                    System.out.println("-----> y1>y2)");
                    if(y1>(y2+y22)){
                        System.out.println("------> y1>(y2+y22)");
                        conSVG.setX1(source.getX() + source.getWidth()/2);
                        conSVG.setX2(target.getX() +target.getWidth()/2);
                        conSVG.setY1(source.getY() );
                        conSVG.setY2(target.getY() + target.getHeight());
                    }else{
                        System.out.println("------> y1<=(y2+y22)");
                        conSVG.setX1(source.getX() + source.getWidth()/2);
                        conSVG.setX2(target.getX() +target.getWidth()/2);
                        conSVG.setY1(source.getY() + source.getHeight());
                        conSVG.setY2(target.getY());
                    }
                }else{
                    if(y2>(y1+y11)){
                        System.out.println("----> y2>(y1+y11)");
                        conSVG.setX1(source.getX() + source.getWidth()/2);
                        conSVG.setX2(target.getX() +target.getWidth()/2);
                        conSVG.setY1(source.getY() + source.getHeight());
                        conSVG.setY2(target.getY());
                    }else{
                        System.out.println("------> y2<=(y1+y11)");
                        conSVG.setX1(source.getX() + source.getWidth()/2);
                        conSVG.setX2(target.getX() +target.getWidth()/2);
                        conSVG.setY1(source.getY() + source.getHeight());
                        conSVG.setY2(target.getY());
                    }
                }
            }
        }
        return conSVG;
    }
    private static String makeArrows(ConnectionSVG conSvg) {

        String arrow = " <defs>\n" +
//              "        <marker id=\"markerSquare\" markerWidth=\"7\" markerHeight=\"7\" refX=\"4\" refY=\"4\"\n" +
//              "        orient=\"auto\">\n" +
//              "        <rect x=\"1\" y=\"1\" width=\"5\" height=\"5\" style=\"stroke: none; fill:#000000;\"/>\n" +
//              "        </marker>\n" +
//              "\n" +
                "        <marker id=\"markerArrow\" markerWidth=\"13\" markerHeight=\"13\" refX=\"2\" refY=\"7\"\n" +
                "        orient=\"auto\">\n" +
                "        <path d=\"M2,2 L2,13 L8,7 L2,2\" style=\"fill: #000000;\" />\n" +
                "        </marker>\n" +
                "        </defs>\n" +
                "\n" +
                "        <path d=\"M"+conSvg.getX1()+","+conSvg.getY1()+" l50,0 l0,50 l50,0\"\n" +
                "        style=\"stroke: #0000cc; stroke-width: 1px; fill: none;\n" +
//              "        marker-start: url(#markerSquare);\n" +
//              "        marker-start: url(#markerSquare);\n" +
                "        marker-end: url(#markerArrow);\n" +
                "\n" +
                "        \"\n" +
                "                /> ";
        return arrow;
    }
}
