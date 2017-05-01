package com.Farzad.utils.ImageUtils;

import POJOs.SVGSingleShape;
import com.Farzad.Enums.ConnectionsEnum;

/**
 * Created by VOLCANO on 5/1/2017.
 */
public class ConnectionTools {
    static String getSVGline(SVGSingleShape source, SVGSingleShape target) {
//        System.out.println(source !=null?source.getName() +" target id : "+target.getId()+" target name : "+target.getName():"nuuul");
        if (source != null && source.getConnectionsType() != null) {
//            System.out.println(source.getConnectionsType()+"--**--"+source.getName()+" target id : "+target.getId()+" target name : "+target.getName());
            if(ConnectionsEnum.ACCESSES.equalsName(source.getConnectionsType().toLowerCase())) {
                return ConnectionsEnum.ACCESSES.lineSVGCode(source, target);
            }else if(ConnectionsEnum.ASSIGNED.equalsName(source.getConnectionsType().toLowerCase())){
                return ConnectionsEnum.ASSIGNED.lineSVGCode(source, target);
            }else if(ConnectionsEnum.AGGREGATION.equalsName(source.getConnectionsType().toLowerCase())){
                return ConnectionsEnum.AGGREGATION.lineSVGCode(source, target);
            }else if(ConnectionsEnum.ASSOCIATION.equalsName(source.getConnectionsType().toLowerCase())){
                return ConnectionsEnum.ASSOCIATION.lineSVGCode(source, target);
            }else if(ConnectionsEnum.USES.equalsName(source.getConnectionsType().toLowerCase())){
                return ConnectionsEnum.USES.lineSVGCode(source, target);
            }else if(ConnectionsEnum.USED_BY.equalsName(source.getConnectionsType().toLowerCase())){
                return ConnectionsEnum.USED_BY.lineSVGCode(source, target);
            }else if(ConnectionsEnum.REALISES.equalsName(source.getConnectionsType().toLowerCase())){
                return ConnectionsEnum.REALISES.lineSVGCode(source, target);
            }else if(ConnectionsEnum.READ_AND_WRITE.equalsName(source.getConnectionsType().toLowerCase())){
                return ConnectionsEnum.READ_AND_WRITE.lineSVGCode(source, target);
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
}
