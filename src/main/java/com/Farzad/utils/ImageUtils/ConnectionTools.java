package com.Farzad.utils.ImageUtils;

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
            if(ConnectionsEnum.ACCESSES.equalsName(source.getConnectionsType().toLowerCase())) {
                return lineSVGCode(source, target,ConnectionsEnum.ACCESSES);
            }else if(ConnectionsEnum.ASSIGNED.equalsName(source.getConnectionsType().toLowerCase())){
                return lineSVGCode(source, target,ConnectionsEnum.ASSIGNED);
            }else if(ConnectionsEnum.AGGREGATION.equalsName(source.getConnectionsType().toLowerCase())){
                return lineSVGCode(source, target,ConnectionsEnum.AGGREGATION);
            }else if(ConnectionsEnum.ASSOCIATION.equalsName(source.getConnectionsType().toLowerCase())){
                return lineSVGCode(source, target,ConnectionsEnum.ASSOCIATION);
            }else if(ConnectionsEnum.USES.equalsName(source.getConnectionsType().toLowerCase())){
                return lineSVGCode(source, target,ConnectionsEnum.USES);
            }else if(ConnectionsEnum.USED_BY.equalsName(source.getConnectionsType().toLowerCase())){
                return lineSVGCode(source, target,ConnectionsEnum.USED_BY);
            }else if(ConnectionsEnum.REALISES.equalsName(source.getConnectionsType().toLowerCase())){
                return lineSVGCode(source, target,ConnectionsEnum.REALISES);
            }else if(ConnectionsEnum.READ_AND_WRITE.equalsName(source.getConnectionsType().toLowerCase())){
                return lineSVGCode(source, target,ConnectionsEnum.READ_AND_WRITE);
            }else
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
            return source !=null?source.getName():null;

    }
     private static String lineSVGCode(SVGSingleShape source, SVGSingleShape target, ConnectionsEnum connectionEnum) {
        int x1 = source.getX() + source.getWidth();
        int x2 = target.getX();
        int y1 = source.getY();
        int y2 = target.getY();
        int lineWidth = source.getStrokeWidth();
        switch (connectionEnum) {
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
                                "<circle cx=\"" + x2 + "\" cy=\"" + y2 + "\" r=\"3\" fill=\"#000000\" />"+
                                "      <text x=\"" + (x1+x2)/2 + "\" xml:space=\"preserve\" y=\"" + (y1+y2)/2 + "\" clip-path=\"url(#clipPath20)\" stroke=\"none\"\n" +
                                "      font-family=\"" + source.getFont() + "\" fill=\"#000000\"  >" + target.getConnectionsType() + "</text>\n"
                        ;
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
    private static String makeLine(SVGSingleShape source, SVGSingleShape target) {
        int x1 = source.getX() + source.getWidth();
        int x2 = target.getX();
        int y1 = source.getY();
        int y2 = target.getY();
        int lineWidth = source.getStrokeWidth();
        return  " <circle cx=\"" + x1 + "\" cy=\"" + y1 + "\" r=\"3\" fill=\"#000000\" />" +
                "      <line fill=\"black\" x1=\"" + x1 + "\" x2=\"" + x2 + "\" y1=\"" + y1 + "\" y2=\"" + y2 + "\" " +
                "stroke=\"#000000\" stroke-width=\"" + lineWidth + "\"/>\n" +
                "<circle cx=\"" + x2 + "\" cy=\"" + y2 + "\" r=\"3\" fill=\"#000000\" />";
    }
    private static String putText(SVGSingleShape svgShape) {
        int x = svgShape.getX() + 10;
        int y = svgShape.getY() + 35;
        return "      <text x=\"" + x + "\" xml:space=\"preserve\" y=\"" + y + "\" clip-path=\"url(#clipPath20)\" stroke=\"none\"\n" +
                "      font-family=\"" + svgShape.getFont() + "\" fill=\"#FFFFFF\"  >" + svgShape.getName() + "</text>\n";
    }
}
