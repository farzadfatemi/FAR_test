package com.Farzad.utils;

import POJOs.ConnectionSVG;
import POJOs.Label;
import POJOs.SVGSingleShape;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;


/**
 * Created by VOLCANO on 4/17/2017.
 */
public class Utils {
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

    private static int getFontSize(String text, boolean getWidth) {

        Font defaultFont = new Font("Montserrat", Font.PLAIN, 13);

        AffineTransform affinetransform = new AffineTransform();
        FontRenderContext frc = new FontRenderContext(affinetransform, true, true);
        int textWidth = (int) (defaultFont.getStringBounds(text, frc).getWidth());
        int textHeight = (int) (defaultFont.getStringBounds(text, frc).getHeight());
//        System.out.println(textwidth);
        return getWidth ? textWidth : textHeight;
    }

    public static int getTextVerticallyPosition(SVGSingleShape svgShape, Label label) {
        int customY;
        System.out.println("label.getFontHeight() : "+label.getFontHeight()+" label.getLabelHeight() : "+label.getLabelHeight()+" label.getLabelWidth() : "+label.getLabelWidth());
        if (svgShape.hasAnyChild()) {
            customY = svgShape.getY() + 20;
        } else if (label.getFontHeight() == label.getLabelHeight()) {
            System.out.println("-- Single Row -- ");
            customY = svgShape.getY() + svgShape.getHeight() / 2;
        } else {
            System.out.println("-- Multi Row -- ");
            customY = (svgShape.getY() + svgShape.getHeight() / 2) - label.getLabelHeight() / 2;
        }
        return customY;
    }

    public static Label getFitLabel(SVGSingleShape svgShape) {
        if (svgShape == null) return null;
        Label label = new Label();
        label.setLabelText(svgShape.getName());
        label.setLabelWidth(getFontSize(svgShape.getName(), true));
        label.setFontHeight(getFontSize(svgShape.getName(), false));
//        System.out.println(textwidth);
        String result = "";
        int lineCount = 0;
        String tempSentence = "";
        if (svgShape.getWidth() < label.getLabelWidth()) {
            String[] words = svgShape.getName().split(" ");
            for (String word : words) {
                if (getFontSize(tempSentence, true) < svgShape.getWidth() - 30) {
                    if (getFontSize(tempSentence + word + " ", true) < svgShape.getWidth() - 30) {
                        System.out.println("tempSentence : " + tempSentence + " Word : " + word);
                        tempSentence += word + " ";
                    } else {
                        lineCount++;
                        result += "<tspan x=\"" + (svgShape.getX() + svgShape.getWidth() / 2) + "\" dy=\"1em\">" + tempSentence + "</tspan>\n";
                        tempSentence = word + " ";
                        System.out.println("next line : " + word);
                        System.out.println("new line : " + result);
                    }
                }
            }
            if (tempSentence.length() > 1) {
                lineCount++;
                result += "<tspan x=\"" + (svgShape.getX() + svgShape.getWidth() / 2) + "\" dy=\"1em\">" + tempSentence + "</tspan>\n";
            }
            System.out.println("lineCount : "+lineCount + " label.getFontHeight() : "+ label.getFontHeight()+ " Label Height : "+ label.getLabelHeight());
            label.setLabelHeight(lineCount * label.getFontHeight() + lineCount);
            label.setLabelText(result);

//            result = result.substring(0, result.length() - 1);

        } else {
            label.setLabelHeight(label.getFontHeight());
            return label;
        }
        System.out.println(result);

        return label;
    }

}
