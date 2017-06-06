package com.Farzad.utils.ImageUtils;

import POJOs.Label;
import POJOs.SVGSingleShape;
import com.Farzad.Enums.ArchiEnum;

import static com.Farzad.utils.Utils.*;

/**
 * Created by FARzad - VOLCANO on 5/2/2017.
 */
class ShapeTools {
    private final static double opacity = 0.9;

    static String getSVGShape(SVGSingleShape svgShape) {
        if (ArchiEnum.APPLICATION_COLLABORATION.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.APPLICATION_COLLABORATION);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.APPLICATION_COMPONENT.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.APPLICATION_COMPONENT);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.APPLICATION_FUNCTION.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.APPLICATION_FUNCTION);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.APPLICATION_INTERACTION.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.APPLICATION_INTERACTION);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.APPLICATION_INTERFACE.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.APPLICATION_INTERFACE);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.APPLICATION_OBJECT.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.APPLICATION_OBJECT);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.APPLICATION_SERVICE.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.APPLICATION_SERVICE);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.BUSINESS_ACTOR.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.BUSINESS_ACTOR);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.BUSINESS_COLLABORATION.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.BUSINESS_COLLABORATION);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.BUSINESS_EVENT.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.BUSINESS_EVENT);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.BUSINESS_FUNCTION.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.BUSINESS_FUNCTION);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.BUSINESS_INTERACTION.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.BUSINESS_INTERACTION);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.BUSINESS_INTERFACE.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.BUSINESS_INTERFACE);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.BUSINESS_LOCATION.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.BUSINESS_LOCATION);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.BUSINESS_MEANING.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.BUSINESS_MEANING);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.BUSINESS_OBJECT.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.BUSINESS_OBJECT);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.BUSINESS_PROCESS.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.BUSINESS_PROCESS);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.BUSINESS_PRODUCT.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.BUSINESS_PRODUCT);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.BUSINESS_ROLE.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.BUSINESS_ROLE);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.BUSINESS_REPRESENTATION.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.BUSINESS_REPRESENTATION);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.BUSINESS_SERVICE.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.BUSINESS_SERVICE);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.BUSINESS_STAKEHOLDER.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.BUSINESS_STAKEHOLDER);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.BUSINESS_VALUE.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.BUSINESS_VALUE);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.GOALS_ASSESSMENT.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.GOALS_ASSESSMENT);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.GOALS_CONSTRAINT.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.GOALS_CONSTRAINT);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.GOALS_DRIVER.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.GOALS_DRIVER);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.GOALS_GAP.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.GOALS_GAP);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.GOALS_GOAL.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.GOALS_GOAL);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.GOALS_PLATEAU.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.GOALS_PLATEAU);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.GOALS_PRINCIPAL.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.GOALS_PRINCIPAL);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.GOALS_REPRESENTATION.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.GOALS_REPRESENTATION);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.GOALS_REQUIREMENT.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.GOALS_REQUIREMENT);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.GOALS_ROLE.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.GOALS_ROLE);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.GOALS_UNAMED.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.GOALS_UNAMED);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.MAPS.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.MAPS);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.MAP_BLUE_STRATAMAP.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.MAP_BLUE_STRATAMAP);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.MAP_GREEN_STRATAMAP.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.MAP_GREEN_STRATAMAP);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.MAP_OUTLINE_STRATAMAP.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.MAP_OUTLINE_STRATAMAP);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.STRATAMAP_BLUE_STRATAMAP.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.STRATAMAP_BLUE_STRATAMAP);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.STRATAMAP_GREEN_STRATAMAP.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.STRATAMAP_GREEN_STRATAMAP);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.STRATAMAP_OUTLINE_STRATAMAP.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.STRATAMAP_OUTLINE_STRATAMAP);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.TECHNOLOGY_ARTIFACT.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.TECHNOLOGY_ARTIFACT);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.TECHNOLOGY_COMMUNICATION_PATH.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.TECHNOLOGY_COMMUNICATION_PATH);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.TECHNOLOGY_DATABASE.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.TECHNOLOGY_DATABASE);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.TECHNOLOGY_DEVICE.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.TECHNOLOGY_DEVICE);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.TECHNOLOGY_FUNCTION.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.TECHNOLOGY_FUNCTION);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.TECHNOLOGY_INTERFACE.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.TECHNOLOGY_INTERFACE);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.TECHNOLOGY_NETWORK.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.TECHNOLOGY_NETWORK);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.TECHNOLOGY_NODE.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.TECHNOLOGY_NODE);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.TECHNOLOGY_SERVICE.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.TECHNOLOGY_SERVICE);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.TECHNOLOGY_SYSTEM_SOFTWARE.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.TECHNOLOGY_SYSTEM_SOFTWARE);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.CONTRACT.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.CONTRACT);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.LOCATION.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.LOCATION);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.DATA_OBJECT.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.DATA_OBJECT);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.ARTIFACT.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.ARTIFACT);
            System.out.println("--s-s--s-s-s-s-s--s-sd-" + svgShape.getShapeType());
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.NETWORK.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.NETWORK);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.DEVICE.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.DEVICE);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.INFRASTRUCTURE_INTERFACE.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.INFRASTRUCTURE_INTERFACE);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.INFRASTRUCTURE_SERVICE.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.INFRASTRUCTURE_SERVICE);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.NODE.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.NODE);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.SYSTEM_SOFTWARE.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.SYSTEM_SOFTWARE);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.GROUP.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.GROUP);
            return SVGShapeCode(svgShape);
        } else if (ArchiEnum.MEANING.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.MEANING);
            return SVGShapeCode(svgShape);
        }  else if (ArchiEnum.COMMUNICATION_PATH.equalsName(svgShape.getElementType())) {
            svgShape.setShapeType(ArchiEnum.COMMUNICATION_PATH);
            return SVGShapeCode(svgShape);
        } else {
            svgShape.setShapeType(ArchiEnum.DEFAULT);
            return SVGShapeCode(svgShape);
        }

    }


    private static String SVGShapeCode(SVGSingleShape svgShape) {
        Label label = getFitLabel(svgShape);
        StringBuilder result = null;
        int x = svgShape.getX();
        double y = getTextVerticallyPosition(svgShape, label);
        ArchiEnum archiEnum = svgShape.getShapeType();
        String color = null;
        int rx = 8;
        int ry = 8;
        int lineWidth = 4;
        String fillColor = svgShape.getFillColor();
        System.out.println("Shape TYpe : " + archiEnum.categoryToString());
        svgShape.setURL("http://www.stratamap.co.nz");
        System.out.println("==== >>>" + svgShape.getName() + " ------------- hasChild : " + svgShape.hasAnyChild());
        String mainRect =
                " <g>\n" +
                        " <a xlink:href=\"https://google.com\">\n" +
                        "      <rect fill-opacity=\"" + opacity + "\" class=\"main_style " + archiEnum.categoryToString() + "\"  x=\"" + svgShape.getX() + "\" y=\"" + svgShape.getY() + "\" width=\"" + svgShape.getWidth()
                        + "\" height=\"" + svgShape.getHeight() + "\" />\n" +
                        "      <text text-anchor=\"middle\" alignment-baseline=\"middle\" class=\"shapeLabel\" x=\"" + (svgShape.getX() + svgShape.getWidth() / 2) + "\" xml:space=\"preserve\" y=\"" + y + "\"  >" + label.getLabelText() + "</text>\n" +
                        "    </a>\n" + IconsTools.getIconSVGCode(archiEnum, svgShape) +
                        "</g>\n";

        String businessObjectShape = " <g>\n" +
                " <a xlink:href=\"https://google.com\">\n" +
                "      <rect fill=\"#e0b416\"  x=\"" + svgShape.getX() + "\" y=\"" + svgShape.getY() + "\" width=\"" + svgShape.getWidth()
                + "\" height=\"" + svgShape.getHeight() + "\" stroke=\"" + svgShape.getStrokeColor() + "\" stroke-width=\"" + lineWidth + "\" />\n" +
                "      <rect fill=\"" + svgShape.getFillColor() + "\"  x=\"" + svgShape.getX() + "\" y=\"" + (svgShape.getY() + 13) + "\" width=\"" + svgShape.getWidth()
                + "\" height=\"" + (svgShape.getHeight() - 13) + "\" stroke=\"" + svgShape.getStrokeColor() + "\" />\n" +
                "      <text text-anchor=\"middle\" alignment-baseline=\"middle\" class=\"shapeLabel\" x=\"" + (svgShape.getX() + svgShape.getWidth() / 2) + "\" xml:space=\"preserve\" y=\"" + y + "\"  clip-path=\"url(#clipPath20)\" stroke=\"none\"\n" +
                "       fill=\"#FFFFFF\"  >" + label.getLabelText() + "</text>\n" +
                "    </a>\n" + IconsTools.getIconSVGCode(archiEnum, svgShape) +
                "</g>\n";
        String businessFunctionShape = " <g>\n" +
                " <a xlink:href=\"https://google.com\">\n" +
                "      <rect fill=\"" + svgShape.getFillColor() + "\" rx=\"" + rx + "\" ry=\"" + ry + "\"   x=\"" + svgShape.getX() + "\" y=\"" + svgShape.getY() + "\" width=\"" + svgShape.getWidth()
                + "\" height=\"" + svgShape.getHeight() + "\" stroke=\"" + svgShape.getStrokeColor() + "\" stroke-width=\"" + lineWidth + "\" />\n" +
                "      <text text-anchor=\"middle\" alignment-baseline=\"middle\" class=\"shapeLabel\" x=\"" + (svgShape.getX() + svgShape.getWidth() / 2) + "\" xml:space=\"preserve\" y=\"" + y + "\" \n" +
                "       fill=\"#FFFFFF\"  >" + label.getLabelText() + "</text>\n" +
                "    </a>\n" + IconsTools.getIconSVGCode(archiEnum, svgShape) +
                "</g>\n";
        switch (archiEnum) {
            case APPLICATION_COLLABORATION:
                return mainRect;
            case APPLICATION_COMPONENT:
                result = new StringBuilder();
                result.append(getComponentShape(archiEnum, svgShape));
//                svgShape.setX(svgShape.getX()+10);
                result.append(putText(svgShape, 0, 0));
//                result.append(putIcon(archiEnum, svgShape));
                result.append(putIntoLink(result.toString(), svgShape.getURL()));
//                svgShape.setX(svgShape.getX()-10);
                return result.toString();
            case APPLICATION_FUNCTION:
                return mainRect;
            case APPLICATION_INTERACTION:
                return mainRect;
            case APPLICATION_INTERFACE:
                return mainRect;
            case APPLICATION_OBJECT:
                return mainRect;
            case APPLICATION_SERVICE:
                result = new StringBuilder();
                svgShape.setRx(25);
                svgShape.setRy(25);
                result.append(getSimpleRect(archiEnum, svgShape));
//                svgShape.setY(svgShape.getY() - 10);
                result.append(putText(svgShape, 0, 0));
                result.append(putIcon(archiEnum, svgShape));
                result.append(putIntoLink(result.toString(), svgShape.getURL()));
                result.append(putGroupAndSVGTag(result.toString()));
                return result.toString();
            case BUSINESS_ACTOR:
                return mainRect;
            case BUSINESS_COLLABORATION:
                return mainRect;
            case BUSINESS_EVENT:
                return mainRect;
            case BUSINESS_FUNCTION:
                result = new StringBuilder();
                svgShape.setRx(8);
                svgShape.setRy(8);
                result.append(getSimpleRect(archiEnum, svgShape));
                result.append(putText(svgShape, 0, 0));
                result.append(putIcon(archiEnum, svgShape));
                result.append(putIntoLink(result.toString(), svgShape.getURL()));
                result.append(putGroupAndSVGTag(result.toString()));
                return result.toString();
            case BUSINESS_INTERACTION:
                return mainRect;
            case BUSINESS_INTERFACE:
                return mainRect;
            case BUSINESS_LOCATION:
                return mainRect;
            case BUSINESS_MEANING:
                return mainRect;
            case BUSINESS_OBJECT:
                result = new StringBuilder();
                color = svgShape.getFillColor();
                svgShape.setFillColor("#e0b416");
                result.append(getSimpleRect(archiEnum, svgShape));
                svgShape.setFillColor(color);
                svgShape.setY(svgShape.getY() + 13);
                svgShape.setHeight(svgShape.getHeight() - 13);
                result.append(getSimpleRect(archiEnum, svgShape));
                result.append(putText(svgShape, 0, 0));
//                result.append(putIcon(archiEnum, svgShape));
                result.append(putIntoLink(result.toString(), svgShape.getURL()));
                result.append(putGroupAndSVGTag(result.toString()));
                svgShape.setY(svgShape.getY() - 13);
                svgShape.setHeight(svgShape.getHeight() + 13);
                return result.toString();
            case BUSINESS_PROCESS:
                return mainRect;
            case BUSINESS_PRODUCT:
                return mainRect;
            case BUSINESS_REPRESENTATION:
                return mainRect;
            case BUSINESS_ROLE:
                return mainRect;
            case BUSINESS_SERVICE:
                result = new StringBuilder();
                svgShape.setRx(35);
                svgShape.setRy(35);
                result.append(getSimpleRect(archiEnum, svgShape));
                result.append(putText(svgShape, 0, 0));
                result.append(putIcon(archiEnum, svgShape));
                result.append(putIntoLink(result.toString(), svgShape.getURL()));
                result.append(putGroupAndSVGTag(result.toString()));
                return result.toString();
            case BUSINESS_STAKEHOLDER:
                return mainRect;
            case BUSINESS_VALUE:
                return mainRect;
            case GOALS_ASSESSMENT:
                return mainRect;
            case GOALS_CONSTRAINT:
                return mainRect;
            case GOALS_DRIVER:
                return mainRect;
            case GOALS_GAP:
                return mainRect;
            case GOALS_GOAL:
                return mainRect;
            case GOALS_PLATEAU:
                return mainRect;
            case GOALS_PRINCIPAL:
                return mainRect;
            case GOALS_REPRESENTATION:
                return mainRect;
            case GOALS_REQUIREMENT:
                return mainRect;
            case GOALS_ROLE:
                return mainRect;
            case GOALS_UNAMED:
                return mainRect;
            case MAPS:
                return mainRect;
            case MAP_BLUE_STRATAMAP:
                return mainRect;
            case MAP_GREEN_STRATAMAP:
                return mainRect;
            case MAP_OUTLINE_STRATAMAP:
                return mainRect;
            case STRATAMAP_BLUE_STRATAMAP:
                return mainRect;
            case STRATAMAP_GREEN_STRATAMAP:
                return mainRect;
            case STRATAMAP_OUTLINE_STRATAMAP:
                return mainRect;
            case TECHNOLOGY_ARTIFACT:
                return mainRect;
            case TECHNOLOGY_COMMUNICATION_PATH:
                return mainRect;
            case TECHNOLOGY_DATABASE:
                return mainRect;
            case TECHNOLOGY_DEVICE:
                result = new StringBuilder();
                svgShape.setRx(35);
                svgShape.setRy(35);
                result.append(getSimpleRect(archiEnum, svgShape));
                result.append(putText(svgShape, 0, 0));
//                result.append(putIcon(archiEnum, svgShape));
                result.append(putIntoLink(result.toString(), svgShape.getURL()));
                svgShape.setPolyDem(new int[][]{
                        {svgShape.getX() + 10, svgShape.getY() + svgShape.getHeight() + 20},
                        {svgShape.getX() + 30, svgShape.getY() + svgShape.getHeight()},
                        {svgShape.getX() + svgShape.getWidth() - 30, svgShape.getY() + svgShape.getHeight()},
                        {svgShape.getX() + svgShape.getWidth() - 10, svgShape.getY() + svgShape.getHeight() + 20}

                });
                result.append(getSimpleTrapezium(svgShape));
                result.append(putGroupAndSVGTag(result.toString()));
                return result.toString();
            case TECHNOLOGY_FUNCTION:
                return mainRect;
            case TECHNOLOGY_INTERFACE:
                return mainRect;
            case TECHNOLOGY_NETWORK:
                return mainRect;
            case TECHNOLOGY_NODE:
                return mainRect;
            case TECHNOLOGY_SERVICE:
                return mainRect;
            case TECHNOLOGY_SYSTEM_SOFTWARE:
                return mainRect;
            case CONTRACT:
                result = new StringBuilder();
                color = svgShape.getFillColor();
                svgShape.setFillColor("#e0b416");
                result.append(getSimpleRect(archiEnum, svgShape));
                svgShape.setFillColor(color);
                svgShape.setY(svgShape.getY() + 13);
                svgShape.setHeight(svgShape.getHeight() - 13);
                result.append(getSimpleRect(archiEnum, svgShape));
                result.append(putText(svgShape, 0, 0));
//                result.append(putIcon(archiEnum, svgShape));
                result.append(putIntoLink(result.toString(), svgShape.getURL()));
                result.append(putGroupAndSVGTag(result.toString()));
                svgShape.setY(svgShape.getY() - 13);
                svgShape.setHeight(svgShape.getHeight() + 13);
                return result.toString();
            case LOCATION:
                return mainRect;
            case DATA_OBJECT:
                result = new StringBuilder();
                color = svgShape.getFillColor();
                svgShape.setFillColor("#0d63db");
                result.append(getSimpleRect(archiEnum, svgShape));
                svgShape.setFillColor(color);
                svgShape.setY(svgShape.getY() + 13);
                svgShape.setHeight(svgShape.getHeight() - 13);
                result.append(getSimpleRect(archiEnum, svgShape));
                result.append(putText(svgShape, 0, 0));
//                result.append(putIcon(archiEnum, svgShape));
                result.append(putIntoLink(result.toString(), svgShape.getURL()));
                result.append(putGroupAndSVGTag(result.toString()));
                svgShape.setY(svgShape.getY() - 13);
                svgShape.setHeight(svgShape.getHeight() + 13);
                return result.toString();
            case ARTIFACT:
                result = new StringBuilder();
                int diff = 13;
                svgShape.setPolyDem(new int[][]{
                        // main shape
                        {svgShape.getX(), svgShape.getY()},
                        {svgShape.getX() + svgShape.getWidth() - diff, svgShape.getY()},
                        {svgShape.getX() + svgShape.getWidth(), svgShape.getY() + diff},
                        {svgShape.getX() + svgShape.getWidth(), svgShape.getY() + svgShape.getHeight()},
                        {svgShape.getX(), svgShape.getY() + svgShape.getHeight()}
                        ,
                        // poly line
                        {svgShape.getX() + svgShape.getWidth() - diff, svgShape.getY()},
                        {svgShape.getX() + svgShape.getWidth() - diff, svgShape.getY() + diff},
                        {svgShape.getX() + svgShape.getWidth(), svgShape.getY() + diff}

                });
                result.append(getArtifactShape(svgShape));
                result.append(putText(svgShape, 0, 0));
//                result.append(putIcon(archiEnum, svgShape));
                result.append(putIntoLink(result.toString(), svgShape.getURL()));
                result.append(putGroupAndSVGTag(result.toString()));
                return result.toString();
            case NETWORK:
                result = new StringBuilder();
                result.append(getSimpleRect(archiEnum, svgShape));
//                svgShape.setY(svgShape.getY() - 13);
                result.append(putText(svgShape, 0, 0));
                result.append(putIcon(archiEnum, svgShape));
                result.append(putIntoLink(result.toString(), svgShape.getURL()));
                svgShape.setPolyDem(new int[][]{
                        {svgShape.getX() + 10, svgShape.getY() + svgShape.getHeight() + 20},
                        {svgShape.getX() + 30, svgShape.getY() + svgShape.getHeight()},
                        {svgShape.getX() + svgShape.getWidth() - 30, svgShape.getY() + svgShape.getHeight()},
                        {svgShape.getX() + svgShape.getWidth() - 10, svgShape.getY() + svgShape.getHeight() + 20}

                });
                result.append(putGroupAndSVGTag(result.toString()));
                return result.toString();
            case DEVICE:
                result = new StringBuilder();
                svgShape.setRx(15);
                svgShape.setRy(15);
                result.append(getSimpleRect(archiEnum, svgShape));
                result.append(putText(svgShape, 0, 0));
//                result.append(putIcon(archiEnum, svgShape));
                result.append(putIntoLink(result.toString(), svgShape.getURL()));
                svgShape.setPolyDem(new int[][]{
                        {svgShape.getX() + 10, svgShape.getY() + svgShape.getHeight() + 10},
                        {svgShape.getX() + 30, svgShape.getY() + svgShape.getHeight()},
                        {svgShape.getX() + svgShape.getWidth() - 30, svgShape.getY() + svgShape.getHeight()},
                        {svgShape.getX() + svgShape.getWidth() - 10, svgShape.getY() + svgShape.getHeight() + 10}

                });
                result.append(getSimpleTrapezium(svgShape));
                result.append(putGroupAndSVGTag(result.toString()));
                return result.toString();
            case INFRASTRUCTURE_INTERFACE:
                return mainRect;
            case INFRASTRUCTURE_SERVICE:
                result = new StringBuilder();
                svgShape.setRx(8);
                svgShape.setRy(8);
                result.append(getSimpleRect(archiEnum, svgShape));
                result.append(putText(svgShape, 0, 0));
                result.append(putIcon(archiEnum, svgShape));
                result.append(putIntoLink(result.toString(), svgShape.getURL()));
                result.append(putGroupAndSVGTag(result.toString()));
                return result.toString();
            case NODE:
                result = new StringBuilder();
                result.append(getSimpleRect(archiEnum, svgShape));
                result.append(putText(svgShape, 0, 0));
                result.append(putIcon(archiEnum, svgShape));
                result.append(putIntoLink(result.toString(), svgShape.getURL()));
                result.append(putGroupAndSVGTag(result.toString()));
                return result.toString();
            case SYSTEM_SOFTWARE:
                return mainRect;
            case GROUP:
                result = new StringBuilder();
                color = svgShape.getFillColor();
                int tempWidth = svgShape.getWidth();
                int tempHeight = svgShape.getHeight();
                svgShape.setFillColor("#cccccc");
//                svgShape.setWidth(svgShape.getName()!=null?svgShape.getName().length():svgShape.getWidth()/2);
                System.out.println("yesss    " + getFontSize(svgShape.getName(), true) + " Width    " + svgShape.getWidth() + " normal width : " + (svgShape.getName() != null ? svgShape.getName().length() : "nooooo"));
                svgShape.setWidth(getFontSize(svgShape.getName(), true) + 40);
                svgShape.setHeight(25);
                svgShape.setTextAlignment("start");
                svgShape.setType(ArchiEnum.GROUP.categoryToString());
                result.append(getSimpleRect(archiEnum, svgShape));
                svgShape.setFillColor(color);
                svgShape.setWidth(tempWidth);
                svgShape.setY(svgShape.getY() + 25);
                svgShape.setHeight(tempHeight - 25);
                result.append(getSimpleRect(archiEnum, svgShape));
//                result.append(putText(svgShape,svgShape.getX()+10,svgShape.getY()+10));


                result.append(putText(svgShape, svgShape.getX() + 10, svgShape.getY() - 10));
//                result.append(putIcon(archiEnum, svgShape));
                result.append(putIntoLink(result.toString(), svgShape.getURL()));
                svgShape.setY(svgShape.getY() - 15);
                result.append(putGroupAndSVGTag(result.toString()));
                svgShape.setHeight(svgShape.getHeight() + 25);
                return result.toString();
            case MEANING:
                result = new StringBuilder();
                System.out.println("cloouuuuud");
                result.append(getCloudShape(svgShape));
                result.append(putText(svgShape, 0, 0));
                result.append(putIntoLink(result.toString(), svgShape.getURL()));
                result.append(putGroupAndSVGTag(result.toString()));

                return result.toString();
            case COMMUNICATION_PATH:
                result = new StringBuilder();
                result.append(getSimpleRect(archiEnum, svgShape));
                result.append(putText(svgShape, 0, 0));
                result.append(putIcon(archiEnum, svgShape));
                result.append(putIntoLink(result.toString(), svgShape.getURL()));
                result.append(putGroupAndSVGTag(result.toString()));
                return result.toString();
            default:
                return mainRect;
        }
    }

    private static String getSimpleRect(ArchiEnum archiEnum, SVGSingleShape svgShape) {
        svgShape.setStrokeWidth(4);
        return
                "      <rect fill-opacity=\"" + opacity + "\" class=\"main_style " + archiEnum.categoryToString() + "\" x=\"" + svgShape.getX() + "\" y=\"" + svgShape.getY() + "\" width=\"" + svgShape.getWidth()
                        + "\" height=\"" + svgShape.getHeight() + "\" rx=\"" + svgShape.getRx() + "\" ry=\"" + svgShape.getRy() + "\" />\n"
                ;
    }
//  private static String getSimpleRect(ArchiEnum archiEnum, SVGSingleShape svgShape) {
//        svgShape.setStrokeWidth(4);
//        return
//                "      <rect fill-opacity=\""+opacity+"\" fill=\"" + svgShape.getFillColor() + "\"  x=\"" + svgShape.getX() + "\" y=\"" + svgShape.getY() + "\" width=\"" + svgShape.getWidth()
//                        + "\" height=\"" + svgShape.getHeight() + "\" rx=\"" + svgShape.getRx() + "\" ry=\"" + svgShape.getRy() + "\" stroke=\"" + svgShape.getStrokeColor() + "\" stroke-width=\"" + svgShape.getStrokeWidth() + "\" />\n"
//                ;
//    }

    private static String getComponentShape(ArchiEnum archiEnum, SVGSingleShape svgShape) {
        svgShape.setStrokeWidth(4);
        int smallBoxWidth = 20;
        int smallBoxHeight = 10;
        return
                "      \n<rect fill-opacity=\"" + opacity + "\" class=\"main_style " + archiEnum.categoryToString() + "\" " +
//                        "fill=\"" + svgShape.getFillColor() + "\"  " +
                        "x=\"" + svgShape.getX() + "\" y=\"" + svgShape.getY() + "\" width=\"" + svgShape.getWidth()
                        + "\" height=\"" + svgShape.getHeight() + "\" rx=\"" + svgShape.getRx() + "\" ry=\"" + svgShape.getRy() + "\" " +
//                        "stroke=\"" + svgShape.getStrokeColor() + "\" stroke-width=\"" + svgShape.getStrokeWidth() + "\" " +
                        "/>\n" +
                        "      <rect class=\"main_style " + archiEnum.categoryToString() + "\" " +
//                        "fill=\"" + svgShape.getFillColor() + "\"  " +
                        "x=\"" + (svgShape.getX() - 10) + "\" y=\"" + (svgShape.getY() + 10) + "\" width=\"" + smallBoxWidth
                        + "\" height=\"" + smallBoxHeight + "\" rx=\"" + svgShape.getRx() + "\" ry=\"" + svgShape.getRy() + "\" " +
//                        "stroke=\"" + svgShape.getStrokeColor() + "\" stroke-width=\"" + svgShape.getStrokeWidth() + "\"" +
                        " />\n" +
                        "      <rect class=\"main_style " + archiEnum.categoryToString() + "\" " +
//                        "fill=\"" + svgShape.getFillColor() + "\"  " +
                        "x=\"" + (svgShape.getX() - 10) + "\" y=\"" + (svgShape.getY() + 25) + "\" width=\"" + smallBoxWidth
                        + "\" height=\"" + smallBoxHeight + "\" rx=\"" + svgShape.getRx() + "\" ry=\"" + svgShape.getRy() + "\" " +
//                        "stroke=\"" + svgShape.getStrokeColor() + "\" stroke-width=\"" + svgShape.getStrokeWidth() + "\"" +
                        " />\n"
                ;
    }

    private static String getArtifactShape(SVGSingleShape svgShape) {
        int[][] polyDem = svgShape.getPolyDem();
        svgShape.setStrokeWidth(4);
        String shape = " <polygon fill-opacity=\"" + opacity + "\" fill=\"" + svgShape.getFillColor() + "\" points=\"" + polyDem[0][0] + " " + polyDem[0][1] + ","
                + polyDem[1][0] + " " + polyDem[1][1] + "," + polyDem[2][0] + " " + polyDem[2][1] + "," + polyDem[3][0] + " " + polyDem[3][1] + "," + polyDem[4][0]
                + " " + polyDem[4][1] + "\" stroke=\"" + svgShape.getStrokeColor() + "\" stroke-width=\"" + svgShape.getStrokeWidth() + "\"/>\n";
//         shape +=  "<polygon fill=\"" + svgShape.getFillColor() + "\" points=\"" + polyDem[5][0] + " " + polyDem[5][1] + "," + polyDem[6][0] + " " + polyDem[6][1] + "," + polyDem[8][0] + " " + polyDem[8][1] +"\" stroke=\"" + svgShape.getStrokeColor() + "\" stroke-width=\"" + svgShape.getStrokeWidth() + "\"/>";
//        shape += "<line stroke-linejoin:round; fill=\""+svgShape.getStrokeColor()+"\" x1=\"" + polyDem[5][0] + "\" x2=\"" + polyDem[6][0] + "\" y1=\"" + polyDem[5][1] + "\" y2=\"" + polyDem[6][1] + "\" " +
//                        "stroke=\""+svgShape.getStrokeColor()+"\" stroke-width=\"" + svgShape.getStrokeWidth() + "\"/>\n";
//        shape += "<line stroke-linejoin:round; fill=\""+svgShape.getStrokeColor()+"\" x1=\"" + polyDem[7][0] + "\" x2=\"" + polyDem[8][0] + "\" y1=\"" + polyDem[7][1] + "\" y2=\"" + polyDem[8][1] + "\" " +
//                        "stroke=\""+svgShape.getStrokeColor()+"\" stroke-width=\"" + svgShape.getStrokeWidth() + "\"/>\n";

        shape += "  <polyline stroke-linejoin=\"miter\"\n" +
                "              points=\"" + polyDem[5][0] + " " + polyDem[5][1] + "," + polyDem[6][0] + " " + polyDem[6][1] + "," + polyDem[7][0] + " " + polyDem[7][1] + "\"\n" +
                "              stroke=\"" + svgShape.getStrokeColor() + "\" stroke-width=\"" + svgShape.getStrokeWidth() + "\"\n" +
                "              fill=\"none\" />\n";

        return shape;
    }

    private static String getSimpleTrapezium(SVGSingleShape svgShape) {
        int[][] polyDem = svgShape.getPolyDem();

        return
                "<polygon fill-opacity=\"" + opacity + "\" class=\"trapezium \" points=\"" + polyDem[0][0] + " " + polyDem[0][1] + "," + polyDem[1][0] + " " + polyDem[1][1] + ","
                        + polyDem[2][0] + " " + polyDem[2][1] + "," + polyDem[3][0] + " " + polyDem[3][1] + "\" />\n";
    }

    private static String getCloudShape(SVGSingleShape svgShape) {
        int x = svgShape.getX();
        int w = svgShape.getWidth();
        int y = svgShape.getY();
        int h = svgShape.getHeight();

        return
                " <ellipse  fill-opacity=\"" + opacity + "\" class=\"cloud\"  cx=\"" + (x + w / 3) + "\" cy=\"" + (y + h / 3.75) + "\" rx=\"" + (w / 3) + "\" ry=\"" + (h / 3.75) + "\"   />\n" +
                " <ellipse  fill-opacity=\"" + opacity + "\" class=\"cloud\"  cx=\"" + (x + w / 1.8) + "\" cy=\"" + (y + h / 3) + "\" rx=\"" + (w / 2.25) + "\" ry=\"" + (h / 3) + "\"   />\n" +
                " <ellipse  fill-opacity=\"" + opacity + "\" class=\"cloud\"  cx=\"" + (x + w * 2 / 3) + "\" cy=\"" + (y + h / 1.4) + "\" rx=\"" + (w / 3) + "\" ry=\"" + (h / 3.5) + "\"   />\n" +
                " <ellipse  fill-opacity=\"" + opacity + "\" class=\"cloud\"  cx=\"" + (x + w / 3) + "\" cy=\"" + (y + h * 2 / 3) + "\" rx=\"" + (w / 3) + "\" ry=\"" + (h / 3.75) + "\"   />\n";

    }


    private static String putIntoLink(String shape, String link) {
        return
                " <a xlink:href=\"" + link + "\">\n" +
                        shape +
                        "</a>\n"
                ;
    }

    private static String putGroupAndSVGTag(String shape) {
        return
                "<svg>\n" +
                        " <g>\n" +
                        shape +
                        "</g>\n" +
                        "</svg>\n";
    }

    private static String putIcon(ArchiEnum archiEnum, SVGSingleShape svgShape) {
        return IconsTools.getIconSVGCode(archiEnum, svgShape);
    }

    private static String putText(SVGSingleShape svgShape, int customX, double customY) {
        Label label = getFitLabel(svgShape);
        System.out.println("==== >>>" + svgShape.getName() + " ------------- hasChild : " + svgShape.hasAnyChild());
        String textAnchor = null != svgShape.getTextAlignment() && svgShape.getTextAlignment().length() > 0 ? svgShape.getTextAlignment() : "middle";
        if (customX == 0) customX = svgShape.getX() + svgShape.getWidth() / 2;
        if (customY == 0) {
            customY = getTextVerticallyPosition(svgShape, label);
        }
        return "      \n<text text-anchor=\"" + textAnchor + "\" alignment-baseline=\"middle\" " + (svgShape.getType() != null && svgShape.getType().equals(ArchiEnum.GROUP.categoryToString()) ? "class=\"group_text\"" : "") + " x=\"" + customX + "\" xml:space=\"preserve\" y=\"" + customY + "\" \n" +
                "       fill=\"#FFFFFF\"  >" + label.getLabelText() + "</text>\n";
    }


}
