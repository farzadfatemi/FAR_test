package com.farzad.utils.image;

import com.farzad.enums.ArchiEnum;
import com.farzad.enums.PropertyValues;
import com.farzad.pojo.ArchiEntityProperty;
import com.farzad.pojo.SVGLabel;
import com.farzad.pojo.SVGSingleShape;

import static com.farzad.utils.GeneralUtils.*;

/**
 * Created by FARzad - VOLCANO on 5/2/2017.
 */
class ShapeTools {
    private final static double opacity = 0.9;
    private final static int BORDER_WIDTH = 3;

    static String getSVGShape(SVGSingleShape svgShape) {

        if (getPropertyValue(svgShape, PropertyValues.ICON) != null) {
            svgShape.setShapeType(getPropertyValue(svgShape, PropertyValues.ICON));
            return SVGShapeCode(svgShape);
        } else {
            svgShape.setShapeType(ArchiEnum.getArchiEnum(svgShape.getElementType()));
            return SVGShapeCode(svgShape);
        }

    }


    private static String SVGShapeCode(SVGSingleShape svgShape) {
        StringBuilder result = null;
        StringBuilder mainRect = new StringBuilder();
        int diff = 13;
        String tmpStr = "";
        ArchiEnum archiEnum = svgShape.getShapeType();
        String color = null;
        System.out.println("Shape TYpe : " + archiEnum.categoryToString());
        svgShape.setURL(getEscapeXmlChars("../page/" + svgShape.getName()));
        System.out.println("==== >>>" + svgShape.getName() + " ------------- hasChild : " + svgShape.hasAnyChild());

        mainRect.append(" <g>\n");
        mainRect.append(" <a href=\"../page/").append(getEscapeXmlChars(svgShape.getName())).append("\">\n");
        mainRect.append("<rect fill-opacity=\"");
        mainRect.append(opacity);
        mainRect.append("\" class=\"main_style ");
        mainRect.append(archiEnum.categoryToString());
        mainRect.append("\" x=\"");
        mainRect.append(svgShape.getX());
        mainRect.append("\" y=\"");
        mainRect.append(svgShape.getY());
        mainRect.append("\" width=\"");
        mainRect.append(svgShape.getWidth());
        mainRect.append("\" height=\"");
        mainRect.append(svgShape.getHeight());
        mainRect.append("\" />\n");
        mainRect.append(putText(svgShape, 0, 0));
        mainRect.append("</a>\n");
        mainRect.append(IconsTools.getIconSVGCode(archiEnum, svgShape));
        mainRect.append("</g>\n");


//        String businessObjectShape = " <g>\n" +
//                " <a href=\"https://google.com\">\n" +
//                "      <rect fill=\"#e0b416\"  x=\"" + svgShape.getX() + "\" y=\"" + svgShape.getY() + "\" width=\"" + svgShape.getWidth()
//                + "\" height=\"" + svgShape.getHeight() + "\" stroke=\"" + svgShape.getStrokeColor() + "\" stroke-width=\"" + lineWidth + "\" />\n" +
//                "      <rect fill=\"" + svgShape.getFillColor() + "\"  x=\"" + svgShape.getX() + "\" y=\"" + (svgShape.getY() + 13) + "\" width=\"" + svgShape.getWidth()
//                + "\" height=\"" + (svgShape.getHeight() - 13) + "\" stroke=\"" + svgShape.getStrokeColor() + "\" />\n" +
//                "      <text text-anchor=\"middle\" alignment-baseline=\"middle\" class=\"shapeLabel\" x=\"" + (svgShape.getX() + svgShape.getWidth() / 2) + "\" xml:space=\"preserve\" y=\"" + y + "\"  clip-path=\"url(#clipPath20)\" stroke=\"none\"\n" +
//                "       fill=\"#FFFFFF\"  >" + label.getLabelText() + "</text>\n" +
//                "    </a>\n" + IconsTools.getIconSVGCode(archiEnum, svgShape) +
//                "</g>\n";
//        String businessFunctionShape = " <g>\n" +
//                " <a href=\"https://google.com\">\n" +
//                "      <rect fill=\"" + svgShape.getFillColor() + "\" rx=\"" + rx + "\" ry=\"" + ry + "\"   x=\"" + svgShape.getX() + "\" y=\"" + svgShape.getY() + "\" width=\"" + svgShape.getWidth()
//                + "\" height=\"" + svgShape.getHeight() + "\" stroke=\"" + svgShape.getStrokeColor() + "\" stroke-width=\"" + lineWidth + "\" />\n" +
//                "      <text text-anchor=\"middle\" alignment-baseline=\"middle\" class=\"shapeLabel\" x=\"" + (svgShape.getX() + svgShape.getWidth() / 2) + "\" xml:space=\"preserve\" y=\"" + y + "\" \n" +
//                "       fill=\"#FFFFFF\"  >" + label.getLabelText() + "</text>\n" +
//                "    </a>\n" + IconsTools.getIconSVGCode(archiEnum, svgShape) +
//                "</g>\n";
        switch (archiEnum) {
            case APPLICATION_COLLABORATION:
                return mainRect.toString();
            case APPLICATION_COMPONENT:
                result = new StringBuilder();

                result.append(getComponentShape(archiEnum, svgShape));
//                svgShape.setX(svgShape.getX()+10);
                result.append(putText(svgShape, 0, 0));
//                result.append(putIcon(archiEnum, svgShape));
                tmpStr = putIntoLink(result.toString(), svgShape.getURL());
//                svgShape.setX(svgShape.getX()-10);
                return putGroupAndSVGTag(tmpStr);
            case APPLICATION_FUNCTION:
                return mainRect.toString();
            case APPLICATION_INTERACTION:
                return mainRect.toString();
            case APPLICATION_INTERFACE:
                return mainRect.toString();
            case APPLICATION_OBJECT:
                return mainRect.toString();
            case APPLICATION_SERVICE:
                result = new StringBuilder();
                svgShape.setRx(25);
                svgShape.setRy(25);
                result.append(getSimpleRect(archiEnum, svgShape));
//                svgShape.setY(svgShape.getY() - 10);
                result.append(putText(svgShape, 0, 0));
                result.append(putIcon(archiEnum, svgShape));
                tmpStr = putIntoLink(result.toString(), svgShape.getURL());
                return putGroupAndSVGTag(tmpStr);
            case BUSINESS_ACTOR:
                return mainRect.toString();
            case BUSINESS_COLLABORATION:
                return mainRect.toString();
            case BUSINESS_EVENT:
                result = new StringBuilder();
                result.append(getBusinessEventShape(svgShape));
                result.append(putText(svgShape, 0, 0));
                result.append(putIcon(archiEnum, svgShape));
                tmpStr = putIntoLink(result.toString(), svgShape.getURL());
                return putGroupAndSVGTag(tmpStr);
            case BUSINESS_FUNCTION:
                result = new StringBuilder();
                svgShape.setRx(8);
                svgShape.setRy(8);
                result.append(getSimpleRect(archiEnum, svgShape));
                result.append(putText(svgShape, 0, 0));
                result.append(putIcon(archiEnum, svgShape));
                tmpStr = putIntoLink(result.toString(), svgShape.getURL());
                return putGroupAndSVGTag(tmpStr);
            case BUSINESS_INTERACTION:
                return mainRect.toString();
            case BUSINESS_INTERFACE:
                return mainRect.toString();
            case BUSINESS_LOCATION:
                return mainRect.toString();
            case BUSINESS_MEANING:
                return mainRect.toString();
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
                tmpStr = putIntoLink(result.toString(), svgShape.getURL());
                svgShape.setY(svgShape.getY() - 13);
                svgShape.setHeight(svgShape.getHeight() + 13);
                return putGroupAndSVGTag(tmpStr);

            case BUSINESS_PROCESS:
                return mainRect.toString();
            case BUSINESS_PRODUCT:
                return mainRect.toString();
            case BUSINESS_REPRESENTATION:
                return mainRect.toString();
            case BUSINESS_ROLE:
                return mainRect.toString();
            case BUSINESS_SERVICE:
                result = new StringBuilder();
                svgShape.setRx(35);
                svgShape.setRy(35);
                result.append(getSimpleRect(archiEnum, svgShape));
                result.append(putText(svgShape, 0, 0));
                result.append(putIcon(archiEnum, svgShape));
                tmpStr = putIntoLink(result.toString(), svgShape.getURL());
                return putGroupAndSVGTag(tmpStr);

            case BUSINESS_STAKEHOLDER:
                return mainRect.toString();
            case BUSINESS_VALUE:
                return mainRect.toString();
            case GOALS_ASSESSMENT:
                return mainRect.toString();
            case GOALS_CONSTRAINT:
                return mainRect.toString();
            case GOALS_DRIVER:
                return mainRect.toString();
            case GOALS_GAP:
                return mainRect.toString();
            case GOALS_GOAL:
                return mainRect.toString();
            case GOALS_PLATEAU:
                return mainRect.toString();
            case GOALS_PRINCIPAL:
                return mainRect.toString();
            case GOALS_REPRESENTATION:
                return mainRect.toString();
            case GOALS_REQUIREMENT:
                return mainRect.toString();
            case GOALS_ROLE:
                return mainRect.toString();
            case GOALS_UNAMED:
                return mainRect.toString();
            case MAPS:
                return mainRect.toString();
            case MAP_BLUE_STRATAMAP:
                return mainRect.toString();
            case MAP_GREEN_STRATAMAP:
                return mainRect.toString();
            case MAP_OUTLINE_STRATAMAP:
                return mainRect.toString();
            case STRATAMAP_BLUE_STRATAMAP:
                return mainRect.toString();
            case STRATAMAP_GREEN_STRATAMAP:
                return mainRect.toString();
            case STRATAMAP_OUTLINE_STRATAMAP:
                return mainRect.toString();
            case TECHNOLOGY_ARTIFACT:
                return mainRect.toString();
            case TECHNOLOGY_COMMUNICATION_PATH:
                return mainRect.toString();
            case TECHNOLOGY_DATABASE:
                return mainRect.toString();
            case TECHNOLOGY_DEVICE:
                result = new StringBuilder();
                svgShape.setRx(35);
                svgShape.setRy(35);
                result.append(getSimpleRect(archiEnum, svgShape));
                result.append(putText(svgShape, 0, 0));
//                result.append(putIcon(archiEnum, svgShape));
                svgShape.setPolyDem(new int[][]{
                        {svgShape.getX() + 10, svgShape.getY() + svgShape.getHeight() + 20},
                        {svgShape.getX() + 30, svgShape.getY() + svgShape.getHeight()},
                        {svgShape.getX() + svgShape.getWidth() - 30, svgShape.getY() + svgShape.getHeight()},
                        {svgShape.getX() + svgShape.getWidth() - 10, svgShape.getY() + svgShape.getHeight() + 20}

                });
                result.append(getSimpleTrapezium(svgShape));
                tmpStr = putIntoLink(result.toString(), svgShape.getURL());
                return putGroupAndSVGTag(tmpStr);

            case TECHNOLOGY_FUNCTION:
                return mainRect.toString();
            case TECHNOLOGY_INTERFACE:
                return mainRect.toString();
            case TECHNOLOGY_NETWORK:
                return mainRect.toString();
            case TECHNOLOGY_NODE:
                return mainRect.toString();
            case TECHNOLOGY_SERVICE:
                return mainRect.toString();
            case TECHNOLOGY_SYSTEM_SOFTWARE:
                return mainRect.toString();
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
                tmpStr = putIntoLink(result.toString(), svgShape.getURL());
                svgShape.setY(svgShape.getY() - 13);
                svgShape.setHeight(svgShape.getHeight() + 13);
                return putGroupAndSVGTag(tmpStr);

            case LOCATION:
                return mainRect.toString();
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
                tmpStr = putIntoLink(result.toString(), svgShape.getURL());
                svgShape.setY(svgShape.getY() - 13);
                svgShape.setHeight(svgShape.getHeight() + 13);
                return putGroupAndSVGTag(tmpStr);

            case ARTIFACT:
                result = new StringBuilder();
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
                tmpStr = putIntoLink(result.toString(), svgShape.getURL());
                return putGroupAndSVGTag(tmpStr);

            case NETWORK:
                result = new StringBuilder();
                result.append(getSimpleRect(archiEnum, svgShape));
//                svgShape.setY(svgShape.getY() - 13);
                result.append(putText(svgShape, 0, 0));
                result.append(putIcon(archiEnum, svgShape));
//                svgShape.setPolyDem(new int[][]{
//                        {svgShape.getX() + 10, svgShape.getY() + svgShape.getHeight() + 20},
//                        {svgShape.getX() + 30, svgShape.getY() + svgShape.getHeight()},
//                        {svgShape.getX() + svgShape.getWidth() - 30, svgShape.getY() + svgShape.getHeight()},
//                        {svgShape.getX() + svgShape.getWidth() - 10, svgShape.getY() + svgShape.getHeight() + 20}
//
//                });
                tmpStr = putIntoLink(result.toString(), svgShape.getURL());
                return putGroupAndSVGTag(tmpStr);

            case DEVICE:
                result = new StringBuilder();
                svgShape.setRx(15);
                svgShape.setRy(15);
                result.append(getSimpleRect(archiEnum, svgShape));
                result.append(putText(svgShape, 0, 0));
//                result.append(putIcon(archiEnum, svgShape));
                svgShape.setPolyDem(new int[][]{
                        {svgShape.getX() + 10, svgShape.getY() + svgShape.getHeight() + 10},
                        {svgShape.getX() + 30, svgShape.getY() + svgShape.getHeight()},
                        {svgShape.getX() + svgShape.getWidth() - 30, svgShape.getY() + svgShape.getHeight()},
                        {svgShape.getX() + svgShape.getWidth() - 10, svgShape.getY() + svgShape.getHeight() + 10}

                });
                result.append(getSimpleTrapezium(svgShape));
                tmpStr = putIntoLink(result.toString(), svgShape.getURL());
                return putGroupAndSVGTag(tmpStr);

            case INFRASTRUCTURE_INTERFACE:
                return mainRect.toString();
            case INFRASTRUCTURE_SERVICE:
                result = new StringBuilder();
                svgShape.setRx(8);
                svgShape.setRy(8);
                result.append(getSimpleRect(archiEnum, svgShape));
                result.append(putText(svgShape, 0, 0));
                result.append(putIcon(archiEnum, svgShape));
                tmpStr = putIntoLink(result.toString(), svgShape.getURL());
                return putGroupAndSVGTag(tmpStr);

            case NODE:
                result = new StringBuilder();
                result.append(getSimpleRect(archiEnum, svgShape));
                result.append(putText(svgShape, 0, 0));
                result.append(putIcon(archiEnum, svgShape));
                tmpStr = putIntoLink(result.toString(), svgShape.getURL());
                return putGroupAndSVGTag(tmpStr);

            case SYSTEM_SOFTWARE:
                return mainRect.toString();
            case GROUP:
                result = new StringBuilder();
                color = svgShape.getFillColor();
                int tempWidth = svgShape.getWidth();
                int tempHeight = svgShape.getHeight();
                svgShape.setFillColor("#cccccc");
//                svgShape.setWidth(svgShape.getName()!=null?svgShape.getName().length():svgShape.getWidth()/2);
                System.out.println("yesss    " + getFontSize(svgShape.getName(), true) + " Width    " + svgShape.getWidth() + " normal width : " + (svgShape.getName() != null ? svgShape.getName().length() : "nooooo"));
                svgShape.setWidth(getFontSize(svgShape.getName(), true) + 35);
                System.out.println("svgShape.setWidth    " + svgShape.getWidth());
                svgShape.setHeight(25);
                svgShape.setTextAlignment("start");
                svgShape.setType(ArchiEnum.GROUP.categoryToString());
                result.append(getSimpleRect(archiEnum, svgShape));
                svgShape.setFillColor(color);
                svgShape.setY(svgShape.getY() + 25);
                svgShape.setHeight(tempHeight - 25);
                result.append(putText(svgShape, svgShape.getX() + 5, svgShape.getY() - 10));
                svgShape.setWidth(tempWidth);
                result.append(getSimpleRect(archiEnum, svgShape));
//                result.append(putText(svgShape,svgShape.getX()+10,svgShape.getY()+10));


//                result.append(putIcon(archiEnum, svgShape));
//                tmpStr = putIntoLink(result.toString(), svgShape.getURL());
                svgShape.setY(svgShape.getY() - 15);
                svgShape.setHeight(svgShape.getHeight() + 25);
                return putGroupAndSVGTag(result.toString());
            case MEANING:
                result = new StringBuilder();
                System.out.println("cloouuuuud");
                result.append(getCloudShape(svgShape));
                result.append(putText(svgShape, 0, 0));
                tmpStr = putIntoLink(result.toString(), svgShape.getURL());
                return putGroupAndSVGTag(tmpStr);


            case COMMUNICATION_PATH:
                result = new StringBuilder();
                result.append(getSimpleRect(archiEnum, svgShape));
                result.append(putText(svgShape, 0, 0));
                result.append(putIcon(archiEnum, svgShape));
                tmpStr = putIntoLink(result.toString(), svgShape.getURL());
                return putGroupAndSVGTag(tmpStr);

            case DATABASE:
                result = new StringBuilder();
                result.append(getDataBaseShape(svgShape));
                result.append(putText(svgShape, 0, 0));
//                result.append(putIcon(archiEnum, svgShape));
                tmpStr = putIntoLink(result.toString(), svgShape.getURL());
                return putGroupAndSVGTag(tmpStr);

            case NOTE:
                result = new StringBuilder();
                svgShape.setPolyDem(new int[][]{
                        // main shape
                        {svgShape.getX(), svgShape.getY()},
                        {svgShape.getX() + svgShape.getWidth(), svgShape.getY()},
                        {svgShape.getX() + svgShape.getWidth(), (svgShape.getY() + svgShape.getHeight() - diff)},
                        {svgShape.getX() + svgShape.getWidth() - diff, svgShape.getY() + svgShape.getHeight()},
                        {svgShape.getX(), svgShape.getY() + svgShape.getHeight()},
                        {svgShape.getX(), svgShape.getY()}
                });
                result.append(getNoteShape(svgShape));
                result.append(putText(svgShape, 0, 0));
                tmpStr = putIntoLink(result.toString(), svgShape.getURL());
                return putGroupAndSVGTag(tmpStr);

            case PRINCIPLE:
                result = new StringBuilder();
                svgShape.setPolyDem(new int[][]{
                        // main shape
                        {svgShape.getX() + diff, svgShape.getY()},
                        {svgShape.getX() + svgShape.getWidth() - diff, svgShape.getY()},
                        {svgShape.getX() + svgShape.getWidth(), svgShape.getY() + diff},
                        {svgShape.getX() + svgShape.getWidth(), (svgShape.getY() + svgShape.getHeight() - diff)},
                        {svgShape.getX() + svgShape.getWidth() - diff, svgShape.getY() + svgShape.getHeight()},
                        {svgShape.getX() + diff, svgShape.getY() + svgShape.getHeight()},
                        {svgShape.getX(), svgShape.getY() + svgShape.getHeight() - diff},
                        {svgShape.getX(), svgShape.getY() + diff}
                });
                result.append(getPrincipleShape(svgShape));
                result.append(putText(svgShape, 0, 0));
                tmpStr = putIntoLink(result.toString(), svgShape.getURL());
                return putGroupAndSVGTag(tmpStr);
            case VALUE:
                result = new StringBuilder();
                result.append(getValueShape(svgShape));
                result.append(putText(svgShape, 0, 0));
                result.append(putIcon(archiEnum, svgShape));
                tmpStr = putIntoLink(result.toString(), svgShape.getURL());
                return putGroupAndSVGTag(tmpStr);
            case REPRESENTATION:
                result = new StringBuilder();
                result.append(getRepresentationShape(svgShape));
                result.append(putText(svgShape, 0, 0));
                result.append(putIcon(archiEnum, svgShape));
                tmpStr = putIntoLink(result.toString(), svgShape.getURL());
                return putGroupAndSVGTag(tmpStr);
            default:
                return mainRect.toString();
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

    private static String getDataBaseShape(SVGSingleShape svgShape) {
        int x = svgShape.getX() + BORDER_WIDTH;
        int w = svgShape.getWidth();
        int y = svgShape.getY();
        int h = svgShape.getHeight();
        return
                " <path class=\"database\" d=\"M" + x + " " + y +
                        "           L " + x + " " + (y + h) +
                        "           A 15 1.5 0 0 0 " + (x + w) + " " + (y + h) +
                        "           L " + (x + w) + " " + (y + h) + " ," + (x + w) + " " + y +
                        "           A 15 1 0 0 0 " + x + " " + y +
                        "           A 15 1 0 0 0 " + (x + w) + " " + y +
                        "          \"   /> \n"
                ;

//                +

//                " <path class=\"database\" d=\"M4 20\n" +
//                "           L 4 60\n" +
//                "           A 5 1.5 0 0 0 100 60 \n" +
//                "           L 100 60 , 100 20\n" +
//                "           A 5 1 0 0 0 4 20  \n" +
//                "           A 5 1 0 0 0 100 20 \n" +
//                "          \"   /> \n" +
//                "    "+
//                "<line class=\"database\" x1=\" " + x + "\" y1=\"" + y + "\" x2=\"" + x + "\" y2=\"" + (y + h) + "\" /> \n" +
//                        "<path class=\"database\" d=\"M" + x + " " + (y + h) + " C " + (x + w / 3) + " " + (y + h + h / 10) + ", " + (x + w * 2 / 3) + " " + (y + h + h / 10) + ", " + (x + w) + " " + (y + h) + "\"/>\n" +
//                        "<line class=\"database\" x1=\" " + (x + w) + "\" y1=\"" + y + "\" x2=\"" + (x + w) + "\" y2=\"" + (y + h) + "\" /> \n" +
//                        "<ellipse class=\"database\" cx=\"" + (x + w / 2) + " \" cy=\"" + y + "\" rx=\"" + (w / 2) + "\" ry=\"" + (h / 10) + "\"  />";

    }

    private static String getNoteShape(SVGSingleShape svgShape) {
        int[][] polyDem = svgShape.getPolyDem();
        svgShape.setStrokeWidth(4);
        return " <polygon class=\"note\" fill-opacity=\"" + opacity + "\"  points=\"" + polyDem[0][0] + " " + polyDem[0][1] + ","
                + polyDem[1][0] + " " + polyDem[1][1] + "," + polyDem[2][0] + " " + polyDem[2][1] + "," + polyDem[3][0] + " " + polyDem[3][1] + "," + polyDem[4][0] + " " + polyDem[4][1] + "\"/>\n";

    }

    private static String getPrincipleShape(SVGSingleShape svgShape) {
        int[][] polyDem = svgShape.getPolyDem();
        svgShape.setStrokeWidth(4);
        return " <polygon class=\"principle\" fill-opacity=\"" + opacity + "\"  points=\"" + polyDem[0][0] + " " + polyDem[0][1] + ","
                + polyDem[1][0] + " " + polyDem[1][1] + "," + polyDem[2][0] + " " + polyDem[2][1] + "," + polyDem[3][0] + " " + polyDem[3][1]
                + "," + polyDem[4][0] + " " + polyDem[4][1]
                + "," + polyDem[5][0] + " " + polyDem[5][1]
                + "," + polyDem[6][0] + " " + polyDem[6][1]
                + "," + polyDem[7][0] + " " + polyDem[7][1]
                + "\"/>\n";
    }

    private static String getValueShape(SVGSingleShape svgShape) {
        int x = svgShape.getX();
        int y = svgShape.getY();
        int w = svgShape.getWidth();
        int h = svgShape.getHeight();
        return "<ellipse class=\"value_shape\" fill-opacity=\"" + opacity + "\" cx=\"" + (x + w / 2) + "\" cy=\"" + (y + h / 2) + "\" rx=\"" + (w / 2) + "\" ry=\"" + (h / 2) + "\"/>\n";
    }

    private static String getRepresentationShape(SVGSingleShape svgShape) {
        int x = svgShape.getX();
        int y = svgShape.getY();
        int w = svgShape.getWidth();
        int h = svgShape.getHeight();
        int difY=10;
        return  " <path class=\"representation\" fill-opacity=\"" + opacity + "\" d=\"M" + (x) + " " + (y+h) +
                " C " + (x+w/6) + " " + (y+h+difY) +" , " +
                " " + (x+w/3) + " " + (y+h+difY) +" , " +
                " " + (x+w/2) + " " + (y+h) +" , " +
                " S " + (x+w-w/6) + " " + (y+h-difY) +" , " +
                " " + (x+w) + " " + (y+h) +
                " L " + (x+w) + " " + (y+h) +" , " +
                " " + (x+w) + " " + (y) +" , " +
                " " + (x) + " " + (y) +" , " +
                " " + (x) + " " + (y+h) +"" +
                "\"/>";
    }
    private static String getBusinessEventShape(SVGSingleShape svgShape) {
        int x = svgShape.getX();
        int y = svgShape.getY();
        int w = svgShape.getWidth();
        int h = svgShape.getHeight();
        int difY=10;
        return  "  <path class=\"main_style business\" fill-opacity=\"" + opacity + "\" " +
                "d =\"M" + (x) + " " + (y) +
                " L " + (x+w-w/4) + " " + (y) +" , " +
                " A  1 1 0 0 1 " + (x+w-w/4) + " " + (y+h) +" , " +
                " L " + (x) + " " + (y+h) +" , " +
                " " + (x+w/6) + " " + (y+h/2) +" , " +
                " " + (x) + " " + (y) +" , " +
                " " + (x+w-w/4) + " " + (y) +" "+
                "\"/>   ";
    }


    private static String putIntoLink(String shape, String link) {
        return
                " <a href=\"" + getEscapeXmlChars(link) + "\">\n" +
                        shape +
                        "</a>\n"
                ;
    }

    private static String putGroupAndSVGTag(String shape) {
        return
//                "<svg>\n" +
                " <g>\n" +
                        shape +
                        "</g>\n";
//                                +
//                        "</svg>\n";
    }

    private static String putIcon(ArchiEnum archiEnum, SVGSingleShape svgShape) {
        return IconsTools.getIconSVGCode(archiEnum, svgShape);
    }

    private static String putText(SVGSingleShape svgShape, int customX, double customY) {
        SVGLabel SVGLabel = getFitLabel(svgShape);
        System.out.println("==== >>>" + svgShape.getName() + " ------------- hasChild : " + svgShape.hasAnyChild());
        StringBuilder text = new StringBuilder();
        String textAnchor = null != svgShape.getTextAlignment() && svgShape.getTextAlignment().length() > 0 ? svgShape.getTextAlignment() : "middle";
        if (customX == 0) customX = svgShape.getX() + svgShape.getWidth() / 2;
        if (customY == 0) {
            customY = getTextVerticallyPosition(svgShape, SVGLabel);
        }
        text.append("<text text-anchor=\"");
        text.append(textAnchor);
        text.append("\" ");
        text.append("alignment-baseline=\"middle\"");
        text.append(" class=\"default_text ").append(svgShape.getShapeType().categoryToString()).append("_text\"");
        text.append(" x=\"");
        text.append(customX);
        text.append("\" xml:space=\"preserve\"");
        text.append(" y=\"");
        text.append(customY);
        text.append("\" \n");
        text.append(">");
        text.append(SVGLabel.getLabelText());
        text.append("</text>\n");

//        return "      \n<text text-anchor=\"" + textAnchor + "\" alignment-baseline=\"middle\" " + (svgShape.getType() != null && svgShape.getType().equals(ArchiEnum.GROUP.categoryToString()) ? "class=\"group_text\"" : "") + " x=\"" + customX + "\" xml:space=\"preserve\" y=\"" + customY + "\" \n" +
//                "       fill=\"#FFFFFF\"  >" +getEscapeXmlChars(SVGLabel.getLabelText()) + "</text>\n";

        return text.toString();
    }

    private static ArchiEnum getPropertyValue(SVGSingleShape svgShape, PropertyValues key) {
        ArchiEnum archiEnum = null;
        if (svgShape.getProperties() != null && svgShape.getProperties().size() > 0) {
            for (ArchiEntityProperty p : svgShape.getProperties()) {
                if (p.getKey() != null && p.getKey().equals(key.toString())) {
                    archiEnum = ArchiEnum.getArchiEnum(p.getValue());
                }
            }
        }
        return archiEnum;
    }


}
