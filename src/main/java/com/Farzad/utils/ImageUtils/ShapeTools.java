package com.Farzad.utils.ImageUtils;

import POJOs.SVGSingleShape;
import com.Farzad.Enums.IconsEnum;

/**
 * Created by VOLCANO on 5/1/2017.
 */
public class ShapeTools {
    private static String getSVGIcons(SVGSingleShape svgShape) {
        System.out.println("___----____----------> svgShape.name() : "+svgShape.getName());
        System.out.println("___----____----------> IconsEnum.COLLABORATION_APPLICATION : "+IconsEnum.COLLABORATION_APPLICATION.nameStartWith(svgShape.getName()));
//        if (svgShape.getName() != null && svgShape.getName().equals("Actors1")) {
////            if(IconsEnum.COLLABORATION_APPLICATION.equalsName("collaboration_application")){
//            if (IconsEnum.COLLABORATION_APPLICATION.nameStartWith("collaboration")) {
//                return IconsEnum.COLLABORATION_APPLICATION.iconSVGCode(svgShape);
//            } else
//                return null;
//        }

        if (IconsEnum.COLLABORATION_APPLICATION.nameStartWith(svgShape.getName())) {
            return IconsEnum.COLLABORATION_APPLICATION.iconSVGCode(svgShape);
        } else if (IconsEnum.COMPONANT_APPLICATION.nameStartWith(svgShape.getName())) {
            return IconsEnum.COMPONANT_APPLICATION.iconSVGCode(svgShape);
        } else if (IconsEnum.FUNCTION_APPLICATION.nameStartWith(svgShape.getName())) {
            return IconsEnum.FUNCTION_APPLICATION.iconSVGCode(svgShape);
        } else if (IconsEnum.INTERACTION_APPLICATION.nameStartWith(svgShape.getName())) {
            return IconsEnum.INTERACTION_APPLICATION.iconSVGCode(svgShape);
        } else if (IconsEnum.INTERFACE_APPLICATION.nameStartWith(svgShape.getName())) {
            return IconsEnum.INTERFACE_APPLICATION.iconSVGCode(svgShape);
        } else if (IconsEnum.OBJECT_APPLICATION.nameStartWith(svgShape.getName())) {
            return IconsEnum.OBJECT_APPLICATION.iconSVGCode(svgShape);
        } else if (IconsEnum.SERVICE_APPLICATION.nameStartWith(svgShape.getName())) {
            return IconsEnum.SERVICE_APPLICATION.iconSVGCode(svgShape);
        } else if (IconsEnum.ACTOR_BUSINESS.nameStartWith(svgShape.getName())) {
            return IconsEnum.ACTOR_BUSINESS.iconSVGCode(svgShape);
        } else if (IconsEnum.COLLABORATION_BUSINESS.nameStartWith(svgShape.getName())) {
            return IconsEnum.COLLABORATION_BUSINESS.iconSVGCode(svgShape);
        } else if (IconsEnum.EVENT_BUSINESS.nameStartWith(svgShape.getName())) {
            return IconsEnum.EVENT_BUSINESS.iconSVGCode(svgShape);
        } else if (IconsEnum.FUNCTION_BUSINESS.nameStartWith(svgShape.getName())) {
            return IconsEnum.FUNCTION_BUSINESS.iconSVGCode(svgShape);
        } else if (IconsEnum.INTERACTION_BUSINESS.nameStartWith(svgShape.getName())) {
            return IconsEnum.INTERACTION_BUSINESS.iconSVGCode(svgShape);
        } else if (IconsEnum.INTERFACE_BUSINESS.nameStartWith(svgShape.getName())) {
            return IconsEnum.INTERFACE_BUSINESS.iconSVGCode(svgShape);
        } else if (IconsEnum.LOCATION_BUSINESS.nameStartWith(svgShape.getName())) {
            return IconsEnum.LOCATION_BUSINESS.iconSVGCode(svgShape);
        } else if (IconsEnum.MEANING_BUSINESS.nameStartWith(svgShape.getName())) {
            return IconsEnum.MEANING_BUSINESS.iconSVGCode(svgShape);
        } else if (IconsEnum.OBJECT_BUSINESS.nameStartWith(svgShape.getName())) {
            return IconsEnum.OBJECT_BUSINESS.iconSVGCode(svgShape);
        } else if (IconsEnum.PROCESS_BUSINESS.nameStartWith(svgShape.getName())) {
            return IconsEnum.PROCESS_BUSINESS.iconSVGCode(svgShape);
        } else if (IconsEnum.PRODUCT_BUSINESS.nameStartWith(svgShape.getName())) {
            return IconsEnum.PRODUCT_BUSINESS.iconSVGCode(svgShape);
        } else if (IconsEnum.REPRESENTATION_BUSINESS.nameStartWith(svgShape.getName())) {
            return IconsEnum.REPRESENTATION_BUSINESS.iconSVGCode(svgShape);
        } else if (IconsEnum.SERVICE_BUSINESS.nameStartWith(svgShape.getName())) {
            return IconsEnum.SERVICE_BUSINESS.iconSVGCode(svgShape);
        } else if (IconsEnum.STAKEHOLDER_BUSINESS.nameStartWith(svgShape.getName())) {
            return IconsEnum.STAKEHOLDER_BUSINESS.iconSVGCode(svgShape);
        } else if (IconsEnum.VALUE_BUSINESS.nameStartWith(svgShape.getName())) {
            return IconsEnum.VALUE_BUSINESS.iconSVGCode(svgShape);
        } else if (IconsEnum.ASSESSMENT_GOALS.nameStartWith(svgShape.getName())) {
            return IconsEnum.ASSESSMENT_GOALS.iconSVGCode(svgShape);
        } else if (IconsEnum.CONSTRAINT_GOALS.nameStartWith(svgShape.getName())) {
            return IconsEnum.CONSTRAINT_GOALS.iconSVGCode(svgShape);
        } else if (IconsEnum.DRIVER_GOALS.nameStartWith(svgShape.getName())) {
            return IconsEnum.DRIVER_GOALS.iconSVGCode(svgShape);
        } else if (IconsEnum.GAP_GOALS.nameStartWith(svgShape.getName())) {
            return IconsEnum.GAP_GOALS.iconSVGCode(svgShape);
        } else if (IconsEnum.GOAL_GOALS.nameStartWith(svgShape.getName())) {
            return IconsEnum.GOAL_GOALS.iconSVGCode(svgShape);
        } else if (IconsEnum.PLATEAU_GOALS.nameStartWith(svgShape.getName())) {
            return IconsEnum.PLATEAU_GOALS.iconSVGCode(svgShape);
        } else if (IconsEnum.PRINCIPAL_GOALS.nameStartWith(svgShape.getName())) {
            return IconsEnum.PRINCIPAL_GOALS.iconSVGCode(svgShape);
        } else if (IconsEnum.REPRESENTATION_GOALS.nameStartWith(svgShape.getName())) {
            return IconsEnum.REPRESENTATION_GOALS.iconSVGCode(svgShape);
        } else if (IconsEnum.REQUIREMENT_GOALS.nameStartWith(svgShape.getName())) {
            return IconsEnum.REQUIREMENT_GOALS.iconSVGCode(svgShape);
        }  else if (IconsEnum.ROLE_GOALS.nameStartWith(svgShape.getName())) {
            return IconsEnum.ROLE_GOALS.iconSVGCode(svgShape);
        }  else if (IconsEnum.UNAMED_GOALS.nameStartWith(svgShape.getName())) {
            return IconsEnum.UNAMED_GOALS.iconSVGCode(svgShape);
        }  else if (IconsEnum.MAPS.nameStartWith(svgShape.getName())) {
            return IconsEnum.MAPS.iconSVGCode(svgShape);
        }  else if (IconsEnum.MAP_BLUE_STRATAMAP.nameStartWith(svgShape.getName())) {
            return IconsEnum.MAP_BLUE_STRATAMAP.iconSVGCode(svgShape);
        }  else if (IconsEnum.MAP_GREEN_STRATAMAP.nameStartWith(svgShape.getName())) {
            return IconsEnum.MAP_GREEN_STRATAMAP.iconSVGCode(svgShape);
        }  else if (IconsEnum.MAP_OUTLINE_STRATAMAP.nameStartWith(svgShape.getName())) {
            return IconsEnum.MAP_OUTLINE_STRATAMAP.iconSVGCode(svgShape);
        }  else if (IconsEnum.STRATAMAP_BLUE_STRATAMAP.nameStartWith(svgShape.getName())) {
            return IconsEnum.STRATAMAP_BLUE_STRATAMAP.iconSVGCode(svgShape);
        }  else if (IconsEnum.STRATAMAP_GREEN_STRATAMAP.nameStartWith(svgShape.getName())) {
            return IconsEnum.STRATAMAP_GREEN_STRATAMAP.iconSVGCode(svgShape);
        }  else if (IconsEnum.STRATAMAP_OUTLINE_STRATAMAP.nameStartWith(svgShape.getName())) {
            return IconsEnum.STRATAMAP_OUTLINE_STRATAMAP.iconSVGCode(svgShape);
        }  else if (IconsEnum.ARTIFACT_TECHNOLOGY.nameStartWith(svgShape.getName())) {
            return IconsEnum.ARTIFACT_TECHNOLOGY.iconSVGCode(svgShape);
        }  else if (IconsEnum.COMMUNICATION_PATH_TECHNOLOGY.nameStartWith(svgShape.getName())) {
            return IconsEnum.COMMUNICATION_PATH_TECHNOLOGY.iconSVGCode(svgShape);
        }  else if (IconsEnum.DATABASE_TECHNOLOGY.nameStartWith(svgShape.getName())) {
            return IconsEnum.DATABASE_TECHNOLOGY.iconSVGCode(svgShape);
        }  else if (IconsEnum.DEVICE_TECHNOLOGY.nameStartWith(svgShape.getName())) {
            return IconsEnum.DEVICE_TECHNOLOGY.iconSVGCode(svgShape);
        }  else if (IconsEnum.FUNCTION_TECHNOLOGY.nameStartWith(svgShape.getName())) {
            return IconsEnum.FUNCTION_TECHNOLOGY.iconSVGCode(svgShape);
        }  else if (IconsEnum.INTERFACE_TECHNOLOGY.nameStartWith(svgShape.getName())) {
            return IconsEnum.INTERFACE_TECHNOLOGY.iconSVGCode(svgShape);
        }  else if (IconsEnum.NETWORK_TECHNOLOGY.nameStartWith(svgShape.getName())) {
            return IconsEnum.NETWORK_TECHNOLOGY.iconSVGCode(svgShape);
        }  else if (IconsEnum.NODE_TECHNOLOGY.nameStartWith(svgShape.getName())) {
            return IconsEnum.NODE_TECHNOLOGY.iconSVGCode(svgShape);
        } else if (IconsEnum.SERVICE_TECHNOLOGY.nameStartWith(svgShape.getName())) {
            return IconsEnum.SERVICE_TECHNOLOGY.iconSVGCode(svgShape);
        } else if (IconsEnum.SYSTEM_SOFTWARE_TECHNOLOGY.nameStartWith(svgShape.getName())) {
            return IconsEnum.SYSTEM_SOFTWARE_TECHNOLOGY.iconSVGCode(svgShape);
        } else
            return null;

    }

    static String getSVGShape(SVGSingleShape svgShape) {
        String result = ""
                +
                "<svg>" +
                " <g>" +
                " <a xlink:href=\"https://google.com\">\n" +
                "      <rect fill=\"" + svgShape.getFillColor() + "\"  x=\"" + svgShape.getX() + "\" y=\"" + svgShape.getY() + "\" width=\"" + svgShape.getWidth()
                + "\" height=\"" + svgShape.getHeight() + "\" stroke=\"" + svgShape.getStrokeColor() + "\" />\n" +
                "      <text x=\"" + (svgShape.getX() + 10) + "\" xml:space=\"preserve\" y=\"" + (svgShape.getY() + 35) + "\" clip-path=\"url(#clipPath20)\" stroke=\"none\"\n" +
                "      font-family=\"" + svgShape.getFont() + "\" fill=\"#FFFFFF\"  >" + svgShape.getName() + "</text>\n" +
                "    </a>\n";
//        if (svgShape.getName() != null && svgShape.getName().equals("Actors1")) {
//            result +=
//                    "<defs><style>.cls-1{fill:#faab19;}</style></defs><title>Colour</title><path class=\"cls-1\" " +
//                    "d=\"M12.5,13.37a5.51,5.51,0,0,1,5.5,5.5v1H7v-1a5.51,5.51,0,0,1,5.5-5.5m0-2.5a8,8,0,0,0-8,8v3.52h16V18.87a8,8,0,0,0-8-8Zm-8,11.52v0Z\"/>" +
//                    "<path class=\"cls-1\" d=\"M12.5,5a2.6,2.6,0,1,1-2.6,2.6A2.6,2.6,0,0,1,12.5,5m0-2.5a5.1,5.1,0,1,0,5.1,5.1,5.1,5.1,0,0,0-5.1-5.1Z\"/> ";
//            result += "<image x=\"" + (svgShape.getX() + svgShape.getWidth() - 30) + "\" y=\"" + svgShape.getY() + 5 + "\" width=\"30\" height=\"30\" xlink:href=\"src/main/resources/images/Collaboration_Application.svg\"";
//            result += "<image x=\"" + (svgShape.getX() + svgShape.getWidth() - 30) + "\" y=\"" + svgShape.getY() + 5 + "\" width=\"30\" height=\"30\" xlink:href=\"Actor_Business.svg\"";
//            result += "<svg x=\"" + (svgShape.getX() + svgShape.getWidth() - 30) + "\" y=\"" + svgShape.getY() + 5 + "\" width=\"30\" height=\"30\" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs><style>.cls-1{fill:#faab19;}</style></defs><title>Colour</title><path class=\"cls-1\" d=\"M12.5,13.37a5.51,5.51,0,0,1,5.5,5.5v1H7v-1a5.51,5.51,0,0,1,5.5-5.5m0-2.5a8,8,0,0,0-8,8v3.52h16V18.87a8,8,0,0,0-8-8Zm-8,11.52v0Z\"/><path class=\"cls-1\" d=\"M12.5,5a2.6,2.6,0,1,1-2.6,2.6A2.6,2.6,0,0,1,12.5,5m0-2.5a5.1,5.1,0,1,0,5.1,5.1,5.1,5.1,0,0,0-5.1-5.1Z\"/></svg>";
        result += getSVGIcons(svgShape);
//        }
        result += "</g>" +
                "</svg>"
        ;
        return result;

    }

//    public static String getSVGShapes(IDiagramModelArchimateObject diaObj) {
//        String result = "";
//        SVGSingleShape svgSingleShape = null;
//        try {
//            if (diaObj != null && diaObj.getBounds() != null) {
//                svgSingleShape = new SVGSingleShape();
//                svgSingleShape.setX(diaObj.getBounds().getX());
//                svgSingleShape.setY(diaObj.getBounds().getY());
//                svgSingleShape.setWidth(diaObj.getBounds().getWidth());
//                svgSingleShape.setY(diaObj.getBounds().getHeight());
//                svgSingleShape.setName(diaObj.getName());
//                result = getSVGShape(svgSingleShape);
//                result += "\n";
////                    result+=getSVGline(diaObj.getli().getX());
//                result += "\n";
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }

}
