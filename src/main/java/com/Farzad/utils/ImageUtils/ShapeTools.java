package com.Farzad.utils.ImageUtils;

import POJOs.SVGSingleShape;
import com.Farzad.Enums.ArchiEnum;

/**
 * Created by VOLCANO on 5/2/2017.
 */
public class ShapeTools {

    public static String getSVGShape(SVGSingleShape svgShape) {
        if (ArchiEnum.APPLICATION_COLLABORATION.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.APPLICATION_COLLABORATION,svgShape);
        } else if (ArchiEnum.APPLICATION_COMPONENT.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.APPLICATION_COMPONENT,svgShape);
        } else if (ArchiEnum.APPLICATION_FUNCTION.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.APPLICATION_FUNCTION,svgShape);
        } else if (ArchiEnum.APPLICATION_INTERACTION.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.APPLICATION_INTERACTION,svgShape);
        } else if (ArchiEnum.APPLICATION_INTERFACE.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.APPLICATION_INTERFACE,svgShape);
        } else if (ArchiEnum.APPLICATION_OBJECT.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.APPLICATION_OBJECT,svgShape);
        } else if (ArchiEnum.APPLICATION_SERVICE.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.APPLICATION_SERVICE,svgShape);
        } else if (ArchiEnum.BUSINESS_ACTOR.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.BUSINESS_ACTOR,svgShape);
        } else if (ArchiEnum.BUSINESS_COLLABORATION.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.BUSINESS_COLLABORATION,svgShape);
        } else if (ArchiEnum.BUSINESS_EVENT.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.BUSINESS_EVENT,svgShape);
        } else if (ArchiEnum.BUSINESS_FUNCTION.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.BUSINESS_FUNCTION,svgShape);
        } else if (ArchiEnum.BUSINESS_INTERACTION.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.BUSINESS_INTERACTION,svgShape);
        } else if (ArchiEnum.BUSINESS_INTERFACE.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.BUSINESS_INTERFACE,svgShape);
        } else if (ArchiEnum.BUSINESS_LOCATION.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.BUSINESS_LOCATION,svgShape);
        } else if (ArchiEnum.BUSINESS_MEANING.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.BUSINESS_MEANING,svgShape);
        } else if (ArchiEnum.BUSINESS_OBJECT.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.BUSINESS_OBJECT,svgShape);
        } else if (ArchiEnum.BUSINESS_PROCESS.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.BUSINESS_PROCESS,svgShape);
        } else if (ArchiEnum.BUSINESS_PRODUCT.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.BUSINESS_PRODUCT,svgShape);
        } else if (ArchiEnum.BUSINESS_REPRESENTATION.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.BUSINESS_REPRESENTATION,svgShape);
        } else if (ArchiEnum.BUSINESS_SERVICE.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.BUSINESS_SERVICE,svgShape);
        } else if (ArchiEnum.BUSINESS_STAKEHOLDER.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.BUSINESS_STAKEHOLDER,svgShape);
        } else if (ArchiEnum.BUSINESS_VALUE.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.BUSINESS_VALUE,svgShape);
        } else if (ArchiEnum.GOALS_ASSESSMENT.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.GOALS_ASSESSMENT,svgShape);
        } else if (ArchiEnum.GOALS_CONSTRAINT.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.GOALS_CONSTRAINT,svgShape);
        } else if (ArchiEnum.GOALS_DRIVER.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.GOALS_DRIVER,svgShape);
        } else if (ArchiEnum.GOALS_GAP.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.GOALS_GAP,svgShape);
        } else if (ArchiEnum.GOALS_GOAL.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.GOALS_GOAL,svgShape);
        } else if (ArchiEnum.GOALS_PLATEAU.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.GOALS_PLATEAU,svgShape);
        } else if (ArchiEnum.GOALS_PRINCIPAL.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.GOALS_PRINCIPAL,svgShape);
        } else if (ArchiEnum.GOALS_REPRESENTATION.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.GOALS_REPRESENTATION,svgShape);
        } else if (ArchiEnum.GOALS_REQUIREMENT.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.GOALS_REQUIREMENT,svgShape);
        } else if (ArchiEnum.GOALS_ROLE.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.GOALS_ROLE,svgShape);
        } else if (ArchiEnum.GOALS_UNAMED.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.GOALS_UNAMED,svgShape);
        } else if (ArchiEnum.MAPS.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.MAPS,svgShape);
        } else if (ArchiEnum.MAP_BLUE_STRATAMAP.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.MAP_BLUE_STRATAMAP,svgShape);
        } else if (ArchiEnum.MAP_GREEN_STRATAMAP.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.MAP_GREEN_STRATAMAP,svgShape);
        } else if (ArchiEnum.MAP_OUTLINE_STRATAMAP.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.MAP_OUTLINE_STRATAMAP,svgShape);
        } else if (ArchiEnum.STRATAMAP_BLUE_STRATAMAP.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.STRATAMAP_BLUE_STRATAMAP,svgShape);
        } else if (ArchiEnum.STRATAMAP_GREEN_STRATAMAP.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.STRATAMAP_GREEN_STRATAMAP,svgShape);
        } else if (ArchiEnum.STRATAMAP_OUTLINE_STRATAMAP.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.STRATAMAP_OUTLINE_STRATAMAP,svgShape);
        } else if (ArchiEnum.TECHNOLOGY_ARTIFACT.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.TECHNOLOGY_ARTIFACT,svgShape);
        } else if (ArchiEnum.TECHNOLOGY_COMMUNICATION_PATH.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.TECHNOLOGY_COMMUNICATION_PATH,svgShape);
        } else if (ArchiEnum.TECHNOLOGY_DATABASE.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.TECHNOLOGY_DATABASE,svgShape);
        } else if (ArchiEnum.TECHNOLOGY_DEVICE.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.TECHNOLOGY_DEVICE,svgShape);
        } else if (ArchiEnum.TECHNOLOGY_FUNCTION.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.TECHNOLOGY_FUNCTION,svgShape);
        } else if (ArchiEnum.TECHNOLOGY_INTERFACE.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.TECHNOLOGY_INTERFACE,svgShape);
        } else if (ArchiEnum.TECHNOLOGY_NETWORK.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.TECHNOLOGY_NETWORK,svgShape);
        } else if (ArchiEnum.TECHNOLOGY_NODE.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.TECHNOLOGY_NODE,svgShape);
        } else if (ArchiEnum.TECHNOLOGY_SERVICE.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.TECHNOLOGY_SERVICE,svgShape);
        } else if (ArchiEnum.TECHNOLOGY_SYSTEM_SOFTWARE.equalsName(svgShape.getElementType())) {
            return SVGShapeCode(ArchiEnum.TECHNOLOGY_SYSTEM_SOFTWARE,svgShape);
        } else
            return SVGShapeCode(ArchiEnum.DEFAULT,svgShape);

    }

    private static String SVGShapeCode(ArchiEnum archiEnum, SVGSingleShape svgShape) {

        String singleRect = "<svg>" +
                " <g>" +
                " <a xlink:href=\"https://google.com\">\n" +
                "      <rect fill=\"" + svgShape.getFillColor() + "\"  x=\"" + svgShape.getX() + "\" y=\"" + svgShape.getY() + "\" width=\"" + svgShape.getWidth()
                + "\" height=\"" + svgShape.getHeight() + "\" stroke=\"" + svgShape.getStrokeColor() + "\" />\n" +
                "      <text x=\"" + (svgShape.getX() + 10) + "\" xml:space=\"preserve\" y=\"" + (svgShape.getY() + 35) + "\" clip-path=\"url(#clipPath20)\" stroke=\"none\"\n" +
                "      font-family=\"" + svgShape.getFont() + "\" fill=\"#FFFFFF\"  >" + svgShape.getName() + "</text>\n" +
                "    </a>\n" + IconsTools.getIconSVGCode(archiEnum,svgShape) +
                "</g>" +
                "</svg>";
         String businessObjectShape = "<svg>" +
                " <g>" +
                " <a xlink:href=\"https://google.com\">\n" +
                "      <rect fill=\"#e0b416\"  x=\"" + svgShape.getX() + "\" y=\"" + svgShape.getY() + "\" width=\"" + svgShape.getWidth()
                + "\" height=\"" + svgShape.getHeight() + "\" stroke=\"" + svgShape.getStrokeColor() + "\" />\n" +
                "      <rect fill=\"" + svgShape.getFillColor() + "\"  x=\"" + svgShape.getX() + "\" y=\"" + (svgShape.getY()+10) + "\" width=\"" + svgShape.getWidth()
                + "\" height=\"" + (svgShape.getHeight()-10) + "\" stroke=\"" + svgShape.getStrokeColor() + "\" />\n" +
                "      <text x=\"" + (svgShape.getX() + 10) + "\" xml:space=\"preserve\" y=\"" + (svgShape.getY() + 35) + "\" clip-path=\"url(#clipPath20)\" stroke=\"none\"\n" +
                "      font-family=\"" + svgShape.getFont() + "\" fill=\"#FFFFFF\"  >" + svgShape.getName() + "</text>\n" +
                "    </a>\n" + IconsTools.getIconSVGCode(archiEnum,svgShape) +
                "</g>" +
                "</svg>";
        switch (archiEnum) {
            case APPLICATION_COLLABORATION:
                return singleRect;
            case APPLICATION_COMPONENT:
                return singleRect;
            case APPLICATION_FUNCTION:
                return singleRect;
            case APPLICATION_INTERACTION:
                return singleRect;
            case APPLICATION_INTERFACE:
                return singleRect;
            case APPLICATION_OBJECT:
                return singleRect;
            case APPLICATION_SERVICE:
                return singleRect;
            case BUSINESS_ACTOR:
                return singleRect;
            case BUSINESS_COLLABORATION:
                return singleRect;
            case BUSINESS_EVENT:
                return singleRect;
            case BUSINESS_FUNCTION:
                return singleRect;
            case BUSINESS_INTERACTION:
                return singleRect;
            case BUSINESS_INTERFACE:
                return singleRect;
            case BUSINESS_LOCATION:
                return singleRect;
            case BUSINESS_MEANING:
                return singleRect;
            case BUSINESS_OBJECT:
                return businessObjectShape;
            case BUSINESS_PROCESS:
                return singleRect;
            case BUSINESS_PRODUCT:
                return singleRect;
            case BUSINESS_REPRESENTATION:
                return singleRect;
            case BUSINESS_ROLE:
                return singleRect;
            case BUSINESS_SERVICE:
                return singleRect;
            case BUSINESS_STAKEHOLDER:
                return singleRect;
            case BUSINESS_VALUE:
                return singleRect;
            case GOALS_ASSESSMENT:
                return singleRect;
            case GOALS_CONSTRAINT:
                return singleRect;
            case GOALS_DRIVER:
                return singleRect;
            case GOALS_GAP:
                return singleRect;
            case GOALS_GOAL:
                return singleRect;
            case GOALS_PLATEAU:
                return singleRect;
            case GOALS_PRINCIPAL:
                return singleRect;
            case GOALS_REPRESENTATION:
                return singleRect;
            case GOALS_REQUIREMENT:
                return singleRect;
            case GOALS_ROLE:
                return singleRect;
            case GOALS_UNAMED:
                return singleRect;
            case MAPS:
                return singleRect;
            case MAP_BLUE_STRATAMAP:
                return singleRect;
            case MAP_GREEN_STRATAMAP:
                return singleRect;
            case MAP_OUTLINE_STRATAMAP:
                return singleRect;
            case STRATAMAP_BLUE_STRATAMAP:
                return singleRect;
            case STRATAMAP_GREEN_STRATAMAP:
                return singleRect;
            case STRATAMAP_OUTLINE_STRATAMAP:
                return singleRect;
            case TECHNOLOGY_ARTIFACT:
                return singleRect;
            case TECHNOLOGY_COMMUNICATION_PATH:
                return singleRect;
            case TECHNOLOGY_DATABASE:
                return singleRect;
            case TECHNOLOGY_DEVICE:
                return singleRect;
            case TECHNOLOGY_FUNCTION:
                return singleRect;
            case TECHNOLOGY_INTERFACE:
                return singleRect;
            case TECHNOLOGY_NETWORK:
                return singleRect;
            case TECHNOLOGY_NODE:
                return singleRect;
            case TECHNOLOGY_SERVICE:
                return singleRect;
            case TECHNOLOGY_SYSTEM_SOFTWARE:
                return singleRect;
            default:
                return singleRect;
        }
    }

}
