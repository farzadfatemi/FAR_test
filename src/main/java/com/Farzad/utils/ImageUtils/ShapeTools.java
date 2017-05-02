package com.Farzad.utils.ImageUtils;

import POJOs.SVGSingleShape;
import com.Farzad.Enums.ShapeEnum;

/**
 * Created by VOLCANO on 5/1/2017.
 */
class ShapeTools {
    static String getSVGShape(SVGSingleShape svgShape) {
////        System.out.println("___----____----------> svgShape.name() : "+svgShape.getElementType());
////        System.out.println("___----____----------> IconsEnum.COLLABORATION : "+IconsEnum.COLLABORATION.equalsName(svgShape.getElementType()));
////        if (svgShape.getElementType() != null && svgShape.getElementType().equals("Actors1")) {
//////            if(IconsEnum.COLLABORATION.equalsName("collaboration_application")){
////            if (IconsEnum.COLLABORATION.equalsName("collaboration")) {
////                return IconsEnum.COLLABORATION.SVGShapeCode(svgShape);
////            } else
////                return null;
////        }
//
        if (ShapeEnum.APPLICATION_COLLABORATION.equalsName(svgShape.getElementType())) {
            return ShapeEnum.APPLICATION_COLLABORATION.SVGShapeCode(svgShape);
        } else if (ShapeEnum.APPLICATION_COMPONENT.equalsName(svgShape.getElementType())) {
            return ShapeEnum.APPLICATION_COMPONENT.SVGShapeCode(svgShape);
        } else if (ShapeEnum.APPLICATION_FUNCTION.equalsName(svgShape.getElementType())) {
            return ShapeEnum.APPLICATION_FUNCTION.SVGShapeCode(svgShape);
        } else if (ShapeEnum.APPLICATION_INTERACTION.equalsName(svgShape.getElementType())) {
            return ShapeEnum.APPLICATION_INTERACTION.SVGShapeCode(svgShape);
        } else if (ShapeEnum.APPLICATION_INTERFACE.equalsName(svgShape.getElementType())) {
            return ShapeEnum.APPLICATION_INTERFACE.SVGShapeCode(svgShape);
        } else if (ShapeEnum.APPLICATION_OBJECT.equalsName(svgShape.getElementType())) {
            return ShapeEnum.APPLICATION_OBJECT.SVGShapeCode(svgShape);
        } else if (ShapeEnum.APPLICATION_SERVICE.equalsName(svgShape.getElementType())) {
            return ShapeEnum.APPLICATION_SERVICE.SVGShapeCode(svgShape);
        } else if (ShapeEnum.BUSINESS_ACTOR.equalsName(svgShape.getElementType())) {
            return ShapeEnum.BUSINESS_ACTOR.SVGShapeCode(svgShape);
        } else if (ShapeEnum.BUSINESS_COLLABORATION.equalsName(svgShape.getElementType())) {
            return ShapeEnum.BUSINESS_COLLABORATION.SVGShapeCode(svgShape);
        } else if (ShapeEnum.BUSINESS_EVENT.equalsName(svgShape.getElementType())) {
            return ShapeEnum.BUSINESS_EVENT.SVGShapeCode(svgShape);
        } else if (ShapeEnum.BUSINESS_FUNCTION.equalsName(svgShape.getElementType())) {
            return ShapeEnum.BUSINESS_FUNCTION.SVGShapeCode(svgShape);
        } else if (ShapeEnum.BUSINESS_INTERACTION.equalsName(svgShape.getElementType())) {
            return ShapeEnum.BUSINESS_INTERACTION.SVGShapeCode(svgShape);
        } else if (ShapeEnum.BUSINESS_INTERFACE.equalsName(svgShape.getElementType())) {
            return ShapeEnum.BUSINESS_INTERFACE.SVGShapeCode(svgShape);
        } else if (ShapeEnum.BUSINESS_LOCATION.equalsName(svgShape.getElementType())) {
            return ShapeEnum.BUSINESS_LOCATION.SVGShapeCode(svgShape);
        } else if (ShapeEnum.BUSINESS_MEANING.equalsName(svgShape.getElementType())) {
            return ShapeEnum.BUSINESS_MEANING.SVGShapeCode(svgShape);
        } else if (ShapeEnum.BUSINESS_OBJECT.equalsName(svgShape.getElementType())) {
            return ShapeEnum.BUSINESS_OBJECT.SVGShapeCode(svgShape);
        } else if (ShapeEnum.BUSINESS_PROCESS.equalsName(svgShape.getElementType())) {
            return ShapeEnum.BUSINESS_PROCESS.SVGShapeCode(svgShape);
        } else if (ShapeEnum.BUSINESS_PRODUCT.equalsName(svgShape.getElementType())) {
            return ShapeEnum.BUSINESS_PRODUCT.SVGShapeCode(svgShape);
        } else if (ShapeEnum.BUSINESS_REPRESENTATION.equalsName(svgShape.getElementType())) {
            return ShapeEnum.BUSINESS_REPRESENTATION.SVGShapeCode(svgShape);
        } else if (ShapeEnum.BUSINESS_SERVICE.equalsName(svgShape.getElementType())) {
            return ShapeEnum.BUSINESS_SERVICE.SVGShapeCode(svgShape);
        } else if (ShapeEnum.BUSINESS_STAKEHOLDER.equalsName(svgShape.getElementType())) {
            return ShapeEnum.BUSINESS_STAKEHOLDER.SVGShapeCode(svgShape);
        } else if (ShapeEnum.BUSINESS_VALUE.equalsName(svgShape.getElementType())) {
            return ShapeEnum.BUSINESS_VALUE.SVGShapeCode(svgShape);
        } else if (ShapeEnum.GOALS_ASSESSMENT.equalsName(svgShape.getElementType())) {
            return ShapeEnum.GOALS_ASSESSMENT.SVGShapeCode(svgShape);
        } else if (ShapeEnum.GOALS_CONSTRAINT.equalsName(svgShape.getElementType())) {
            return ShapeEnum.GOALS_CONSTRAINT.SVGShapeCode(svgShape);
        } else if (ShapeEnum.GOALS_DRIVER.equalsName(svgShape.getElementType())) {
            return ShapeEnum.GOALS_DRIVER.SVGShapeCode(svgShape);
        } else if (ShapeEnum.GOALS_GAP.equalsName(svgShape.getElementType())) {
            return ShapeEnum.GOALS_GAP.SVGShapeCode(svgShape);
        } else if (ShapeEnum.GOALS_GOAL.equalsName(svgShape.getElementType())) {
            return ShapeEnum.GOALS_GOAL.SVGShapeCode(svgShape);
        } else if (ShapeEnum.GOALS_PLATEAU.equalsName(svgShape.getElementType())) {
            return ShapeEnum.GOALS_PLATEAU.SVGShapeCode(svgShape);
        } else if (ShapeEnum.GOALS_PRINCIPAL.equalsName(svgShape.getElementType())) {
            return ShapeEnum.GOALS_PRINCIPAL.SVGShapeCode(svgShape);
        } else if (ShapeEnum.GOALS_REPRESENTATION.equalsName(svgShape.getElementType())) {
            return ShapeEnum.GOALS_REPRESENTATION.SVGShapeCode(svgShape);
        } else if (ShapeEnum.GOALS_REQUIREMENT.equalsName(svgShape.getElementType())) {
            return ShapeEnum.GOALS_REQUIREMENT.SVGShapeCode(svgShape);
        }  else if (ShapeEnum.GOALS_ROLE.equalsName(svgShape.getElementType())) {
            return ShapeEnum.GOALS_ROLE.SVGShapeCode(svgShape);
        }  else if (ShapeEnum.GOALS_UNAMED.equalsName(svgShape.getElementType())) {
            return ShapeEnum.GOALS_UNAMED.SVGShapeCode(svgShape);
        }  else if (ShapeEnum.MAPS.equalsName(svgShape.getElementType())) {
            return ShapeEnum.MAPS.SVGShapeCode(svgShape);
        }  else if (ShapeEnum.MAP_BLUE_STRATAMAP.equalsName(svgShape.getElementType())) {
            return ShapeEnum.MAP_BLUE_STRATAMAP.SVGShapeCode(svgShape);
        }  else if (ShapeEnum.MAP_GREEN_STRATAMAP.equalsName(svgShape.getElementType())) {
            return ShapeEnum.MAP_GREEN_STRATAMAP.SVGShapeCode(svgShape);
        }  else if (ShapeEnum.MAP_OUTLINE_STRATAMAP.equalsName(svgShape.getElementType())) {
            return ShapeEnum.MAP_OUTLINE_STRATAMAP.SVGShapeCode(svgShape);
        }  else if (ShapeEnum.STRATAMAP_BLUE_STRATAMAP.equalsName(svgShape.getElementType())) {
            return ShapeEnum.STRATAMAP_BLUE_STRATAMAP.SVGShapeCode(svgShape);
        }  else if (ShapeEnum.STRATAMAP_GREEN_STRATAMAP.equalsName(svgShape.getElementType())) {
            return ShapeEnum.STRATAMAP_GREEN_STRATAMAP.SVGShapeCode(svgShape);
        }  else if (ShapeEnum.STRATAMAP_OUTLINE_STRATAMAP.equalsName(svgShape.getElementType())) {
            return ShapeEnum.STRATAMAP_OUTLINE_STRATAMAP.SVGShapeCode(svgShape);
        }  else if (ShapeEnum.TECHNOLOGY_ARTIFACT.equalsName(svgShape.getElementType())) {
            return ShapeEnum.TECHNOLOGY_ARTIFACT.SVGShapeCode(svgShape);
        }  else if (ShapeEnum.TECHNOLOGY_COMMUNICATION_PATH.equalsName(svgShape.getElementType())) {
            return ShapeEnum.TECHNOLOGY_COMMUNICATION_PATH.SVGShapeCode(svgShape);
        }  else if (ShapeEnum.TECHNOLOGY_DATABASE.equalsName(svgShape.getElementType())) {
            return ShapeEnum.TECHNOLOGY_DATABASE.SVGShapeCode(svgShape);
        }  else if (ShapeEnum.TECHNOLOGY_DEVICE.equalsName(svgShape.getElementType())) {
            return ShapeEnum.TECHNOLOGY_DEVICE.SVGShapeCode(svgShape);
        }  else if (ShapeEnum.TECHNOLOGY_FUNCTION.equalsName(svgShape.getElementType())) {
            return ShapeEnum.TECHNOLOGY_FUNCTION.SVGShapeCode(svgShape);
        }  else if (ShapeEnum.TECHNOLOGY_INTERFACE.equalsName(svgShape.getElementType())) {
            return ShapeEnum.TECHNOLOGY_INTERFACE.SVGShapeCode(svgShape);
        }  else if (ShapeEnum.TECHNOLOGY_NETWORK.equalsName(svgShape.getElementType())) {
            return ShapeEnum.TECHNOLOGY_NETWORK.SVGShapeCode(svgShape);
        }  else if (ShapeEnum.TECHNOLOGY_NODE.equalsName(svgShape.getElementType())) {
            return ShapeEnum.TECHNOLOGY_NODE.SVGShapeCode(svgShape);
        } else if (ShapeEnum.TECHNOLOGY_SERVICE.equalsName(svgShape.getElementType())) {
            return ShapeEnum.TECHNOLOGY_SERVICE.SVGShapeCode(svgShape);
        } else if (ShapeEnum.TECHNOLOGY_SYSTEM_SOFTWARE.equalsName(svgShape.getElementType())) {
            return ShapeEnum.TECHNOLOGY_SYSTEM_SOFTWARE.SVGShapeCode(svgShape);
        } else
            return ShapeEnum.DEFAULT.SVGShapeCode(svgShape);

    }

//    static String getSVGShape(SVGSingleShape svgShape) {
//        return ShapeEnum.SVGShapeCode(svgShape);
////        String result = ""
////                +
////                "<svg>" +
////                " <g>" +
////                " <a xlink:href=\"https://google.com\">\n" +
////                "      <rect fill=\"" + svgShape.getFillColor() + "\"  x=\"" + svgShape.getX() + "\" y=\"" + svgShape.getY() + "\" width=\"" + svgShape.getWidth()
////                + "\" height=\"" + svgShape.getHeight() + "\" stroke=\"" + svgShape.getStrokeColor() + "\" />\n" +
////                "      <text x=\"" + (svgShape.getX() + 10) + "\" xml:space=\"preserve\" y=\"" + (svgShape.getY() + 35) + "\" clip-path=\"url(#clipPath20)\" stroke=\"none\"\n" +
////                "      font-family=\"" + svgShape.getFont() + "\" fill=\"#FFFFFF\"  >" + svgShape.getName() + "</text>\n" +
////                "    </a>\n";
//////        if (svgShape.getElementType() != null && svgShape.getElementType().equals("Actors1")) {
//////            result +=
//////                    "<defs><style>.cls-1{fill:#faab19;}</style></defs><title>Colour</title><path class=\"cls-1\" " +
//////                    "d=\"M12.5,13.37a5.51,5.51,0,0,1,5.5,5.5v1H7v-1a5.51,5.51,0,0,1,5.5-5.5m0-2.5a8,8,0,0,0-8,8v3.52h16V18.87a8,8,0,0,0-8-8Zm-8,11.52v0Z\"/>" +
//////                    "<path class=\"cls-1\" d=\"M12.5,5a2.6,2.6,0,1,1-2.6,2.6A2.6,2.6,0,0,1,12.5,5m0-2.5a5.1,5.1,0,1,0,5.1,5.1,5.1,5.1,0,0,0-5.1-5.1Z\"/> ";
//////            result += "<image x=\"" + (svgShape.getX() + svgShape.getWidth() - 30) + "\" y=\"" + svgShape.getY() + 5 + "\" width=\"30\" height=\"30\" xlink:href=\"src/main/resources/images/Collaboration_Application.svg\"";
//////            result += "<image x=\"" + (svgShape.getX() + svgShape.getWidth() - 30) + "\" y=\"" + svgShape.getY() + 5 + "\" width=\"30\" height=\"30\" xlink:href=\"Actor_Business.svg\"";
//////            result += "<svg x=\"" + (svgShape.getX() + svgShape.getWidth() - 30) + "\" y=\"" + svgShape.getY() + 5 + "\" width=\"30\" height=\"30\" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs><style>.cls-1{fill:#faab19;}</style></defs><title>Colour</title><path class=\"cls-1\" d=\"M12.5,13.37a5.51,5.51,0,0,1,5.5,5.5v1H7v-1a5.51,5.51,0,0,1,5.5-5.5m0-2.5a8,8,0,0,0-8,8v3.52h16V18.87a8,8,0,0,0-8-8Zm-8,11.52v0Z\"/><path class=\"cls-1\" d=\"M12.5,5a2.6,2.6,0,1,1-2.6,2.6A2.6,2.6,0,0,1,12.5,5m0-2.5a5.1,5.1,0,1,0,5.1,5.1,5.1,5.1,0,0,0-5.1-5.1Z\"/></svg>";
////        result += getSVGIcons(svgShape);
//////        }
////        result += "</g>" +
////                "</svg>"
////        ;
////        return result;
//
//    }

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
//                svgSingleShape.setName(diaObj.getElementType());
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
