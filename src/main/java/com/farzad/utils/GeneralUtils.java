package com.farzad.utils;

import com.farzad.enums.ArchiEnum;
import com.farzad.pojo.ConnectionSVG;
import com.farzad.pojo.SVGLabel;
import com.farzad.pojo.SVGSingleShape;
import org.apache.commons.lang.StringEscapeUtils;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;


/**
 * Created by VOLCANO on 4/17/2017.
 */
public class GeneralUtils {
    public static byte[] str2byteArray(String str) {
        return str.getBytes();
    }

    public static ConnectionSVG getBestPoint(SVGSingleShape source, SVGSingleShape target) {

        int shapeBorderWidth = 4;
        ConnectionSVG conSVG = new ConnectionSVG();
        int x1 = source.getX();
        int w1 = source.getWidth();
        int y1 = source.getY();
        int h1 = source.getHeight();
        int x2 = target.getX();
        int w2 = target.getWidth();
        int y2 = target.getY();
        int h2 = target.getHeight();
        int n = 2;
        System.out.println(" >>>> -- x1 = " + x1 + " w1 = " + w1 + " y1 = " + y1 + " x2 = " + x2 + " w2 = " + w2 + " y2 = " + y2);
        System.out.println(" >>>> -- (x2 + w2 - x1) = " + (x2 + w2 - x1) + " | (x2 + w2 - x1) / n = " + (x2 + w2 - x1) / n + " | (x2 + w2 - x1) / n + x1 = " + (x2 + w2 - x1) / n + x1 + " | (x2 + w2 - x1) / n + x1 < (x1 + w1) = " + ((x2 + w2 - x1) / n + x1 < (x1 + w1)));
        while (true) {
            if ((x2 + w2 - x1) / n + x1 < (x1 + w1)) {
                conSVG.setX1((x2 + w2 - x1) / n + x1);
                conSVG.setX2((x2 + w2 - x1) / n + x1);
                conSVG.setY1(y1 + h1 + shapeBorderWidth);
                conSVG.setY2(y2 - shapeBorderWidth);
                System.out.println(" >>>> -- n = " + n + " conSVG.getX1 = " + conSVG.getX1() + " conSVG.getX2() = " + conSVG.getX2() + " conSVG.getY1() = " + conSVG.getY1() + " conSVG.getY2() = " + conSVG.getY2());
                return conSVG;

            } else {
                n++;
            }
        }
    }

    public static int getFontSize(String text, boolean getWidth) {
        if (text != null && text.length() > 0) {
            Font defaultFont = new Font("Montserrat", Font.PLAIN, 13);

            AffineTransform affinetransform = new AffineTransform();
            FontRenderContext frc = new FontRenderContext(affinetransform, true, true);
            int textWidth = (int) (defaultFont.getStringBounds(text, frc) != null ? defaultFont.getStringBounds(text, frc).getWidth() : 0) + 10;
            int textHeight = (int) (defaultFont.getStringBounds(text, frc) != null ? defaultFont.getStringBounds(text, frc).getHeight() : 0);
            return getWidth ? textWidth : textHeight;
        }
        return 0;
    }


    public static double getTextVerticallyPosition(SVGSingleShape svgShape, SVGLabel SVGLabel) {
        double customY;
        System.out.println("SVGLabel.getFontHeight() : " + SVGLabel.getFontHeight() + " SVGLabel.getLabelHeight() : " + SVGLabel.getLabelHeight() + " SVGLabel.getLabelWidth() : " + SVGLabel.getLabelWidth());
        if (svgShape.hasAnyChild()) {
            customY = svgShape.getY() + 12;
        } else if (SVGLabel.getFontHeight() == SVGLabel.getLabelHeight()) {
            System.out.println("-- Single Row -- ");
            customY = svgShape.getY() + svgShape.getHeight() / 2;
        } else {
            System.out.println("-- Multi Row -- ");
            customY = (svgShape.getY() + svgShape.getHeight() / 2) - SVGLabel.getLabelHeight() / 2;
        }
        return customY;
    }

    public static String getEscapeXmlChars(String text) {
        return StringEscapeUtils.escapeXml(text);
    }

    public static SVGLabel getFitLabel(SVGSingleShape svgShape, int customX, int customY) {
        if (svgShape == null) return null;
        int x = svgShape.getX() + svgShape.getWidth() / 2;
        String y = "1.2em";
        if (customX > 0 || customY > 0) {
            x = customX;
//            y = customY;
        }
        SVGLabel SVGLabel = new SVGLabel();
        boolean hasIcon = hasIcon(svgShape.getShapeType());
        System.out.println("---> getFitLabel | Text name :  " + svgShape.getName());
        SVGLabel.setLabelText(getEscapeXmlChars(svgShape.getName()));
        SVGLabel.setLabelWidth(getFontSize(svgShape.getName(), true));
        SVGLabel.setFontHeight(getFontSize(svgShape.getName(), false));
        System.out.println("svgShape.getWidth() : " + svgShape.getWidth() + " SVGLabel.getLabelWidth() : " + SVGLabel.getLabelWidth() + " svgShape.getName() length : " + (svgShape.getName() != null ? svgShape.getName().length() : "No Name"));
        StringBuilder result = new StringBuilder();
        String tmpStr = "";
        int lineCount = 0;
        String tempSentence = "";
        int difference = hasIcon ? 70 : 30;
        if ((svgShape.getWidth() - difference) < SVGLabel.getLabelWidth()) {
            tmpStr = getEscapeXmlChars(svgShape.getName());
            System.out.println("svgShape.getName() ========== " + svgShape.getName());
            System.out.println("tmpStr ========== " + tmpStr);
            String[] words = svgShape.getName().split(" ");
            for (String word : words) {
                System.out.println("getFontSize(tempSentence, true)" + getFontSize(tempSentence, true) + " (svgShape.getWidth() - difference)" + (svgShape.getWidth() - difference));
                System.out.println("getFontSize(tempSentence + word + \" \", true)" + getFontSize(tempSentence + word + " ", true) + " svgShape.getWidth() - difference" + (svgShape.getWidth() - difference));

                if (tempSentence.length() > 0 && getFontSize(tempSentence + getEscapeXmlChars(word) + " ", true) > svgShape.getWidth() - difference) {
                    lineCount++;

//                    System.out.println("Add new line tempSentence + new word width : " + (getFontSize(tempSentence + word + " ", true)) + " svgShape.getWidth() : " + svgShape.getWidth());
                    System.out.println("tempSentence : " + tempSentence + " Word : " + word);

                    result.append("<tspan x=\"").append(x).append("\" dy=\"1.2em\">").append(tempSentence).append("</tspan>\n");
                    tempSentence = getEscapeXmlChars(word) + " ";

                    System.out.println("next line : " + word);
                    System.out.println("new line : " + result);

                } else {
                    tempSentence += getEscapeXmlChars(word) + " ";
                    System.out.println("tempSentence : " + tempSentence + " Word : " + word);
//                        System.out.println("tempSentence + new word width : " + (getFontSize(tempSentence + word + " ", true)) + " svgShape.getWidth() : " + svgShape.getWidth());

//                        tempSentence += getEscapeXmlChars(word) + " ";

                }
//                    else {
//                        lineCount++;
//
//                        System.out.println("Add new line tempSentence + new word width : " + (getFontSize(tempSentence + word + " ", true)) + " svgShape.getWidth() : " + svgShape.getWidth());
//                        System.out.println("tempSentence : " + tempSentence + " Word : " + word);
//
//                        result.append("<tspan x=\"").append(svgShape.getX() + svgShape.getWidth() / 2).append("\" dy=\"1.2em\">").append(tempSentence).append("</tspan>\n");
//                        tempSentence = "";
//
//                        System.out.println("next line : " + word);
//                        System.out.println("new line : " + result);
//                    }
//                }
            }
            if (tempSentence.length() > 1) {
                lineCount++;
                result.append("<tspan x=\"").append(x).append("\" dy=\"1.2em\">").append(tempSentence).append("</tspan>\n");
            }
            System.out.println("lineCount : " + lineCount + " SVGLabel.getFontHeight() : " + SVGLabel.getFontHeight() + " SVGLabel Height : " + SVGLabel.getLabelHeight());
            SVGLabel.setLabelHeight(lineCount * SVGLabel.getFontHeight() + (lineCount * 1.2));
            SVGLabel.setLabelText(result.toString());


        } else {
            SVGLabel.setLabelHeight(SVGLabel.getFontHeight());
            return SVGLabel;
        }
        System.out.println("resultttttttttttttt is " + SVGLabel.getLabelText());

        return SVGLabel;
    }

    private static boolean hasIcon(ArchiEnum archiEnum) {
        switch (archiEnum) {
            case APPLICATION_COLLABORATION:
                return false;
            case APPLICATION_COMPONENT:
                return false;
            case APPLICATION_FUNCTION:
                return false;
            case APPLICATION_INTERACTION:
                return false;
            case APPLICATION_INTERFACE:
                return false;
            case APPLICATION_OBJECT:
                return false;
            case APPLICATION_SERVICE:
                return true;
            case BUSINESS_ACTOR:
                return false;
            case BUSINESS_COLLABORATION:
                return false;
            case BUSINESS_EVENT:
                return false;
            case BUSINESS_FUNCTION:
                return true;
            case BUSINESS_INTERACTION:
                return false;
            case BUSINESS_INTERFACE:
                return false;
            case BUSINESS_LOCATION:
                return false;
            case BUSINESS_MEANING:
                return false;
            case BUSINESS_OBJECT:
                return false;
            case BUSINESS_PROCESS:
                return false;
            case BUSINESS_PRODUCT:
                return false;
            case BUSINESS_REPRESENTATION:
                return false;
            case BUSINESS_ROLE:
                return false;
            case BUSINESS_SERVICE:
                return true;
            case BUSINESS_STAKEHOLDER:
                return false;
            case BUSINESS_VALUE:
                return false;
            case ASSESSMENT:
                return true;
            case CONSTRAINT:
                return true;
            case DRIVER:
                return true;
            case GAP:
                return true;
            case GOAL:
                return true;
            case PLATEAU:
                return true;
            case PRINCIPLE:
                return true;
            case REPRESENTATION:
                return true;
            case REQUIREMENT:
                return true;
            case ROLE:
                return true;
            case STAKEHOLDER:
                return true;
            case UNAMED:
                return true;
            case MAPS:
                return false;
            case MAP_BLUE_STRATAMAP:
                return false;
            case MAP_GREEN_STRATAMAP:
                return false;
            case MAP_OUTLINE_STRATAMAP:
                return false;
            case STRATAMAP_BLUE_STRATAMAP:
                return false;
            case STRATAMAP_GREEN_STRATAMAP:
                return false;
            case STRATAMAP_OUTLINE_STRATAMAP:
                return false;
            case TECHNOLOGY_ARTIFACT:
                return false;
            case TECHNOLOGY_COMMUNICATION_PATH:
                return false;
            case TECHNOLOGY_DATABASE:
                return false;
            case TECHNOLOGY_DEVICE:
                return false;
            case TECHNOLOGY_FUNCTION:
                return false;
            case TECHNOLOGY_INTERFACE:
                return false;
            case TECHNOLOGY_NETWORK:
                return false;
            case TECHNOLOGY_NODE:
                return false;
            case TECHNOLOGY_SERVICE:
                return false;
            case TECHNOLOGY_SYSTEM_SOFTWARE:
                return false;
            case CONTRACT:
                return false;
            case LOCATION:
                return false;
            case DATA_OBJECT:
                return false;
            case ARTIFACT:
                return false;
            case NETWORK:
                return true;
            case DEVICE:
                return false;
            case INFRASTRUCTURE_INTERFACE:
                return false;
            case INFRASTRUCTURE_SERVICE:
                return true;
            case NODE:
                return true;
            case SYSTEM_SOFTWARE:
                return false;
            case GROUP:
                return false;
            case DELIVERABLE:
                return false;
            default:
                return false;
        }
    }

    public static float[] findPointOnConnectionLineByRatio(int x1, int x2, int y1, int y2) {
        float m = 0;
        float[] xy = new float[2];
        int diff = Math.abs(x2 - x1) / 15;
        if ((x1 - x2) != 0) {
            m = (float) (y1 - y2) / (x1 - x2);
            // y = m*(x-x2) + y2
            // y = m*(x-30)+70;
            System.out.println("(y1 - y2) = " + (y1 - y2) + " | (x1 - x2) = " + (x1 - x2) + " | (y1 - y2) / (x1 - x2) = " + ((float) (y1 - y2) / (x1 - x2)));

            if (x1 > x2) {
                System.out.println("X1 = " + x1 + " | X2 = " + x2 + " | Y1 = " + y1 + " | Y2 = " + y2 + " | M = " + m + " | X target = " + (x2 + diff) + " | Y target = " + (((x2 + diff) - x1) * m + y1));
                xy[0] = (x2 + diff);
                xy[1] = ((x2 + diff) - x2) * m + y2;
            } else {
                System.out.println("X1 = " + x1 + " | X2 = " + x2 + " | Y1 = " + y1 + " | Y2 = " + y2 + " | M = " + m + " | X target = " + (x2 - diff) + " | Y target = " + (((x1 + diff) - x1) * m + y1));
                xy[0] = (x2 - diff);
                xy[1] = ((x2 - diff) - x2) * m + y2;
            }

        } else {
            if (y2 > y1) {
                System.out.println("(x1 - x2) == 0 | X1 = " + x1 + " | X2 = " + x2 + " | Y1 = " + y1 + " | Y2 = " + y2 + " | M = " + m + " | X target = " + x1 + " | Y target = " + (y2 + ((y2 - y1) / 12)));
                xy[0] = (x2);
                xy[1] = y2 + ((y2 - y1) / 12);
            } else {
                System.out.println("(x1 - x2) == 0 | X1 = " + x1 + " | X2 = " + x2 + " | Y1 = " + y1 + " | Y2 = " + y2 + " | M = " + m + " | X target = " + x1 + " | Y target = " + (y2 - ((y2 - y1) / 12)));
                xy[0] = (x2);
                xy[1] = y2 - ((y2 - y1) / 12);
            }
        }
        return xy;
    }

    public static double[] findClosePointsForDrawingArc(int x1, int x2, int y1, int y2) {
        double[] xy = new double[2];
        double diff = 15;
        double angle = 0;
//        if ((x1 - x2) != 0) {
        // tan a = y2-y1/x2-x1
        System.out.println(" x1  = " + x1 + " y1  = " + y1 + " |  x2  = " + x2 + " |  y2  = " + y2);
//        angle = Math.toDegrees(Math.atan2(Math.abs(y1 - y2), Math.abs(x1 - x2)));
//        xy[0] = (Math.cos(angle) * diff) + x2;
//        xy[1] = (Math.sin(angle) * diff) + y2;
//        System.out.println("xt " + xy[0] + "  yt " + xy[1] + " angel would be : " + angle + " and Different number : " + diff);

        angle = Math.toDegrees(Math.atan2(Math.abs(y1 - y2), Math.abs(x1 - x2)));
        System.out.println("Math.abs(x1-x2)" + Math.abs(x1 - x2) +"  |  Math.abs(y1-y2) " + Math.abs(y1 - y2) +  "  |   angel would be : " + angle + " |   Different number : " + diff);
        if (x1 > x2) {
            if (y1 > y2) {
                xy[0] = x2 + (Math.cos(angle) * diff);
                xy[1] = y2 + (Math.sin(angle) * diff);
            } else {
                xy[0] = x2 + (Math.cos(angle) * diff);
                xy[1] = y2 - (Math.sin(angle) * diff);
            }

        } else if (x1 < x2) {
            if (y1 > y2) {
                xy[0] = x2 - (Math.cos(angle) * diff);
                xy[1] = y2 + (Math.sin(angle) * diff);
            } else {
                xy[0] = x2 - (Math.cos(angle) * diff);
                xy[1] = y2 - (Math.sin(angle) * diff);
            }
        } else  {
            if (y1 > y2) {
                xy[0] = x2 ;
                xy[1] = y2 + (Math.sin(angle) * diff);
            } else {
                xy[0] = x2 ;
                xy[1] = y2 - (Math.sin(angle) * diff);
            }
        }
        System.out.println(" X1 = " + x1 + " | X2 = " + x2 + " | Y1 = " + y1 + " | Y2 = " + y2 +   " | X target = " + xy[0] + " | Y target = " + xy[1]);
//        } else {
//            if (y2 > y1) {
//                System.out.println("(x1 - x2) == 0 | X1 = " + x1 + " | X2 = " + x2 + " | Y1 = " + y1 + " | Y2 = " + y2 +   " | X target = " + x1 + " | Y target = " + (y2 + ((y2 - y1) / 12)));
//                xy[0] = (x2);
//                xy[1] = y2 + ((y2 - y1) / 12);
//            } else {
//                System.out.println("(x1 - x2) == 0 | X1 = " + x1 + " | X2 = " + x2 + " | Y1 = " + y1 + " | Y2 = " + y2  + " | X target = " + x1 + " | Y target = " + (y2 - ((y2 - y1) / 12)));
//                xy[0] = (x2);
//                xy[1] = y2 - ((y2 - y1 )/ 12);
//            }
//        }
        return xy;
    }


}
