package com.Farzad.utils.ImageUtils;

import POJOs.SVGSingleShape;
import com.Farzad.Enums.ArchiEnum;

import static com.Farzad.Enums.ArchiEnum.*;
import static com.Farzad.utils.ImageUtils.StyleTools.*;

/**
 * Created by VOLCANO on 4/30/2017.
 */
public class IconsTools {
    public static String getIconSVGCode(ArchiEnum archiEnum, SVGSingleShape svgShape) {
        int x = svgShape.getX() + svgShape.getWidth() - 30;
        int y = svgShape.getY() + 5;
        int width = 30;
        int height = 30;
        
        switch (archiEnum) {
            case APPLICATION_COLLABORATION:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.APPLICATION)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M12.5,13.37a5.51,5.51,0,0,1,5.5,5.5v1H7v-1a5.51,5.51,0,0,1,5.5-5.5m0-2.5a8,8,0,0,0-8,8v3.52h16V18.87a8,8,0,0,0-8-8Zm-8,11.52v0Z\"/><path class=\"cls-1\" d=\"M12.5,5a2.6,2.6,0,1,1-2.6,2.6A2.6,2.6,0,0,1,12.5,5m0-2.5a5.1,5.1,0,1,0,5.1,5.1,5.1,5.1,0,0,0-5.1-5.1Z\"/></svg>";
            case APPLICATION_COMPONENT:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.APPLICATION)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M4.76,0V5.33H0v6.08h4.8v2.17H0v6.08h4.8V25H25V0ZM1.82,9.5V7.25h8.52V9.5Zm0,8.25V15.5h8.52v2.24Zm20.57,4.54h-15V19.67h4.83V13.58H7.36V11.41h4.83V5.33H7.36V2.71h15Z\"/></svg>";
            case APPLICATION_FUNCTION:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.APPLICATION)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M12.5,3l10,6.67V20.33l-8.61-5.74-1.39-.92-1.39.92L2.5,20.33V9.67L12.5,3m0-3L0,8.33V25l12.5-8.33L25,25V8.33L12.5,0Z\"/></svg>";
            case APPLICATION_INTERACTION:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.APPLICATION)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M8.81,5.43V19.57a7.5,7.5,0,0,1,0-14.14m2.5-2.93a10,10,0,0,0,0,20V2.5Z\"/><path class=\"cls-1\" d=\"M16.19,5.43a7.5,7.5,0,0,1,0,14.14V5.43M13.69,2.5v20a10,10,0,0,0,0-20Z\"/></svg>";
            case APPLICATION_INTERFACE:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.APPLICATION)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M17.15,7.15A5.35,5.35,0,1,1,11.8,12.5a5.35,5.35,0,0,1,5.35-5.35m0-2.5A7.85,7.85,0,1,0,25,12.5a7.85,7.85,0,0,0-7.85-7.85Z\"/><rect class=\"cls-1\" y=\"11.25\" width=\"10.5\" height=\"2.5\"/></svg>";
            case APPLICATION_OBJECT:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.APPLICATION)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M22.5,2.5v20H2.5V2.5h20M25,0H0V25H25V0Z\"/><path class=\"cls-1\" d=\"M22.5,2.5V5.83H2.5V2.5h20M25,0H0V8.33H25V0Z\"/></svg>";
            case APPLICATION_SERVICE:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.APPLICATION)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M17.15,7.15a5.35,5.35,0,1,1,0,10.7H7.8a5.35,5.35,0,1,1,0-10.7h9.35m0-2.5H7.8a7.85,7.85,0,1,0,0,15.7h9.35a7.85,7.85,0,1,0,0-15.7Z\"/></svg>";
            case BUSINESS_ACTOR:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.BUSINESS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M12.5,13.37a5.51,5.51,0,0,1,5.5,5.5v1H7v-1a5.51,5.51,0,0,1,5.5-5.5m0-2.5a8,8,0,0,0-8,8v3.52h16V18.87a8,8,0,0,0-8-8Zm-8,11.52v0Z\"/><path class=\"cls-1\" d=\"M12.5,5a2.6,2.6,0,1,1-2.6,2.6A2.6,2.6,0,0,1,12.5,5m0-2.5a5.1,5.1,0,1,0,5.1,5.1,5.1,5.1,0,0,0-5.1-5.1Z\"/></svg>";
            case BUSINESS_COLLABORATION:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.BUSINESS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M16.58,6.71a5.79,5.79,0,1,1-5.79,5.79,5.8,5.8,0,0,1,5.79-5.79m0-2.5a8.29,8.29,0,1,0,8.29,8.29,8.29,8.29,0,0,0-8.29-8.29Z\"/><path class=\"cls-1\" d=\"M8.29,6.71A5.79,5.79,0,1,1,2.5,12.5,5.8,5.8,0,0,1,8.29,6.71m0-2.5a8.29,8.29,0,1,0,8.29,8.29A8.29,8.29,0,0,0,8.29,4.21Z\"/></svg>";
            case BUSINESS_EVENT:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.BUSINESS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M13.33,4.65H6.22A2.5,2.5,0,0,0,4.29,8.6h0a7.8,7.8,0,0,1,1,3.9,7.8,7.8,0,0,1-1,3.9h0a2.5,2.5,0,0,0,1.93,3.95h7.11a7.85,7.85,0,0,0,0-15.7Zm0,13.2h-7A10.29,10.29,0,0,0,7.83,12.5,10.29,10.29,0,0,0,6.33,7.15h7a5.35,5.35,0,0,1,0,10.7Z\"/></svg>";
            case BUSINESS_FUNCTION:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.BUSINESS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M12.5,3l10,6.67V20.33l-8.61-5.74-1.39-.92-1.39.92L2.5,20.33V9.67L12.5,3m0-3L0,8.33V25l12.5-8.33L25,25V8.33L12.5,0Z\"/></svg>";
            case BUSINESS_INTERACTION:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.BUSINESS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M8.81,5.43V19.57a7.5,7.5,0,0,1,0-14.14m2.5-2.93a10,10,0,1,0,0,20V2.5Z\"/><path class=\"cls-1\" d=\"M16.19,5.43a7.5,7.5,0,0,1,0,14.14V5.43M13.69,2.5v20a10,10,0,0,0,0-20Z\"/></svg>";
            case BUSINESS_INTERFACE:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.BUSINESS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M17.15,7.15A5.35,5.35,0,1,1,11.8,12.5a5.35,5.35,0,0,1,5.35-5.35m0-2.5A7.85,7.85,0,1,0,25,12.5a7.85,7.85,0,0,0-7.85-7.85Z\"/><rect class=\"cls-1\" y=\"11.25\" width=\"10.5\" height=\"2.5\"/></svg>";
            case BUSINESS_LOCATION:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.BUSINESS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M12.49,2.58a5.3,5.3,0,0,1,5.3,5.3c0,1.27-1.66,5.7-5.29,12.15C9.67,15,7.19,9.66,7.19,7.88a5.3,5.3,0,0,1,5.3-5.3m0-2.48A7.78,7.78,0,0,0,4.72,7.88c0,4.29,7.78,17.06,7.78,17.06s7.78-12.76,7.78-17.06A7.78,7.78,0,0,0,12.49.1Z\"/></svg>";
            case BUSINESS_MEANING:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.BUSINESS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M16.57,4.77a4.92,4.92,0,0,1,5.17,4.62,4.16,4.16,0,0,1-.21,1.32l-.38,1.13.67,1a4.47,4.47,0,0,1,.79,2.51,5.18,5.18,0,0,1-5.43,4.86H7.83A5.18,5.18,0,0,1,2.4,15.32,4.59,4.59,0,0,1,4,11.88l.71-.63.09-.94A3.43,3.43,0,0,1,9.54,7.47l1.68.7,1.13-1.43a5.38,5.38,0,0,1,4.22-2m0-2.4a7.75,7.75,0,0,0-6.1,2.89,5.83,5.83,0,0,0-8,4.83A7,7,0,0,0,0,15.32a7.57,7.57,0,0,0,7.83,7.27h9.33A7.57,7.57,0,0,0,25,15.32a6.84,6.84,0,0,0-1.2-3.86,6.55,6.55,0,0,0,.34-2.08,7.31,7.31,0,0,0-7.57-7Z\"/></svg>";
            case BUSINESS_OBJECT:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.BUSINESS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M22.5,2.5v20H2.5V2.5h20M25,0H0V25H25V0Z\"/><path class=\"cls-1\" d=\"M22.5,2.5V5.83H2.5V2.5h20M25,0H0V8.33H25V0Z\"/></svg>";
            case BUSINESS_PROCESS:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.BUSINESS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M15.05,6l6.44,6.44-6.44,6.44V15.35H2.5V9.65H15.05V6m-2.5-6V7.15H0v10.7H12.55v7.1L25,12.47,12.55,0Z\"/></svg>";
            case BUSINESS_PRODUCT:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.BUSINESS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M22.5,2.5v20H2.5V2.5h20M25,0H0V25H25V0Z\"/><path class=\"cls-1\" d=\"M9.58,2.5V5.83H2.5V2.5H9.58M12.08,0H0V8.33H12.08V0Z\"/></svg>";
            case BUSINESS_REPRESENTATION:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.BUSINESS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M22.5,2.5v20H2.5V2.5h20M25,0H0V25H25V0Z\"/><path class=\"cls-1\" d=\"M9.58,2.5V5.83H2.5V2.5H9.58M12.08,0H0V8.33H12.08V0Z\"/></svg>";
//            case BUSINESS_ROLE:
//                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.BUSINESS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M22.5,2.5v20H2.5V2.5h20M25,0H0V25H25V0Z\"/><path class=\"cls-1\" d=\"M9.58,2.5V5.83H2.5V2.5H9.58M12.08,0H0V8.33H12.08V0Z\"/></svg>";
            case BUSINESS_SERVICE:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.BUSINESS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M17.15,7.15a5.35,5.35,0,1,1,0,10.7H7.8a5.35,5.35,0,1,1,0-10.7h9.35m0-2.5H7.8a7.85,7.85,0,1,0,0,15.7h9.35a7.85,7.85,0,1,0,0-15.7Z\"/></svg>";
            case BUSINESS_STAKEHOLDER:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.BUSINESS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M17.15,4.65H7.8a7.85,7.85,0,1,0,0,15.7h9.35a7.85,7.85,0,0,0,0-15.7Zm-.82,0-.2,0Zm-.8.13-.18,0ZM14.74,5l-.14.05ZM14,5.32l-.09,0Zm-.72.36,0,0Zm-.67.43h0ZM7.8,17.85a5.35,5.35,0,0,1,0-10.7h3.62a7.82,7.82,0,0,0,0,10.7H7.8Zm8.33,2.43.2,0ZM12.6,18.88h0Zm.64.41,0,0Zm.67.34.09,0Zm.7.28.14,0Zm.73.21.18,0Zm1.81-2.28A5.35,5.35,0,1,1,22.5,12.5,5.35,5.35,0,0,1,17.15,17.85Z\"/></svg>";
            case BUSINESS_VALUE:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.BUSINESS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M12.5,7.1c5.88,0,10,2.85,10,5.4s-4.1,5.4-10,5.4-10-2.85-10-5.4,4.1-5.4,10-5.4m0-2.54C5.61,4.56,0,8.11,0,12.5s5.59,7.94,12.48,7.94S25,16.89,25,12.5,19.39,4.56,12.5,4.56Z\"/></svg>";
            case GOALS_ASSESSMENT:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.GOALS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M14.64,5a5.35,5.35,0,1,1-3.78,1.57A5.31,5.31,0,0,1,14.64,5m0-2.5a7.85,7.85,0,1,0,5.55,2.3,7.82,7.82,0,0,0-5.55-2.3Z\"/><rect class=\"cls-1\" x=\"0.97\" y=\"17.53\" width=\"10.5\" height=\"2.5\" transform=\"translate(-11.45 9.9) rotate(-45)\"/></svg>";
            case GOALS_CONSTRAINT:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.GOALS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M22,2.5l-4,20H3l4-20H22M25,0H5L0,25H20L25,0Z\"/><path class=\"cls-1\" d=\"M10.4,2.5l-4,20H3l4-20H10.4m3-2.5H5L0,25H8.45l5-25Z\"/></svg>";
            case GOALS_DRIVER:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.GOALS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M12.5,5A7.5,7.5,0,1,1,5,12.5,7.51,7.51,0,0,1,12.5,5m0-2.5a10,10,0,1,0,10,10,10,10,0,0,0-10-10Z\"/><rect class=\"cls-1\" x=\"11.25\" width=\"2.5\" height=\"25\"/><rect class=\"cls-1\" y=\"11.25\" width=\"25\" height=\"2.5\"/><rect class=\"cls-1\" y=\"11.25\" width=\"25\" height=\"2.5\" transform=\"translate(-5.18 12.5) rotate(-45)\"/><rect class=\"cls-1\" x=\"11.25\" width=\"2.5\" height=\"25\" transform=\"translate(-5.18 12.5) rotate(-45)\"/></svg>";
            case GOALS_GAP:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.GOALS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M12.5,5A7.5,7.5,0,1,1,7.2,7.2,7.45,7.45,0,0,1,12.5,5m0-2.5a10,10,0,1,0,7.07,2.93A10,10,0,0,0,12.5,2.5Z\"/><rect class=\"cls-1\" y=\"8.75\" width=\"25\" height=\"2.5\"/><rect class=\"cls-1\" y=\"13.75\" width=\"25\" height=\"2.5\"/></svg>";
            case GOALS_GOAL:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.GOALS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M12.5,2.5a10,10,0,1,1-10,10,10,10,0,0,1,10-10m0-2.5A12.5,12.5,0,1,0,25,12.5,12.5,12.5,0,0,0,12.5,0Z\"/><path class=\"cls-1\" d=\"M12.5,15.95a3.45,3.45,0,1,1,3.45-3.45A3.45,3.45,0,0,1,12.5,15.95Zm0-4.4a.95.95,0,1,0,.95.95A1,1,0,0,0,12.5,11.55Z\"/><path class=\"cls-1\" d=\"M12.5,20.51a8,8,0,1,1,8-8A8,8,0,0,1,12.5,20.51ZM12.5,7A5.51,5.51,0,1,0,18,12.5,5.52,5.52,0,0,0,12.5,7Z\"/></svg>";
            case GOALS_PLATEAU:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.GOALS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><rect class=\"cls-1\" x=\"3.68\" y=\"11.25\" width=\"17.65\" height=\"2.5\"/><rect class=\"cls-1\" x=\"7.35\" y=\"6.33\" width=\"17.65\" height=\"2.5\"/><rect class=\"cls-1\" y=\"16.17\" width=\"17.65\" height=\"2.5\"/></svg>";
            case GOALS_PRINCIPAL:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.GOALS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M19.65,2.45V22.55H5.35V2.45h14.3m2.5-2.5H2.85V25.05h19.3V-.05Z\"/><rect class=\"cls-1\" x=\"11.25\" y=\"5.98\" width=\"2.5\" height=\"7.9\"/><rect class=\"cls-1\" x=\"11.25\" y=\"16.18\" width=\"2.5\" height=\"2.84\"/></svg>";
            case GOALS_REPRESENTATION:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.GOALS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M22.5,2.5V19.4a13.62,13.62,0,0,0-3.76-.53,13.88,13.88,0,0,0-7.59,2.33A7.63,7.63,0,0,1,7,22.5,8.51,8.51,0,0,1,2.5,21.08V2.5h20M25,0H0V22.33A11.27,11.27,0,0,0,7,25a10,10,0,0,0,5.51-1.71,11.38,11.38,0,0,1,6.24-1.93A11.26,11.26,0,0,1,25,23.29V0Z\"/></svg>";
            case GOALS_REQUIREMENT:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.GOALS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M22,2.5l-4,20H3l4-20H22M25,0H5L0,25H20L25,0Z\"/></svg>";
            case GOALS_ROLE:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.GOALS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M17.15,4.65H7.8a7.85,7.85,0,1,0,0,15.7h9.35a7.85,7.85,0,0,0,0-15.7Zm-.82,0-.2,0Zm-.8.13-.18,0ZM14.74,5l-.14.05ZM14,5.32l-.09,0Zm-.72.36,0,0Zm-.67.43h0ZM7.8,17.85a5.35,5.35,0,0,1,0-10.7h3.62a7.82,7.82,0,0,0,0,10.7H7.8Zm8.33,2.43.2,0ZM12.6,18.88h0Zm.64.41,0,0Zm.67.34.09,0Zm.7.28.14,0Zm.73.21.18,0Zm1.81-2.28A5.35,5.35,0,1,1,22.5,12.5,5.35,5.35,0,0,1,17.15,17.85Z\"/></svg>";
            case GOALS_UNAMED:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.GOALS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M17.81,2.5A7.65,7.65,0,0,0,22.5,7.19V17.81a7.65,7.65,0,0,0-4.69,4.69H7.19A7.65,7.65,0,0,0,2.5,17.81V7.19A7.65,7.65,0,0,0,7.19,2.5H17.81M19.89,0H5.11A5.11,5.11,0,0,1,0,5.11V19.89A5.11,5.11,0,0,1,5.11,25H19.89A5.11,5.11,0,0,1,25,19.89V5.11A5.11,5.11,0,0,1,19.89,0Z\"/></svg>";
            case MAPS:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.MAPS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M7.54,2.5v5h-5v-5h5M10,0H0V10H10V0Z\"/><path class=\"cls-1\" d=\"M22.5,2.5v5h-5v-5h5M25,0H15V10H25V0Z\"/><path class=\"cls-1\" d=\"M22.5,17.46v5h-5v-5h5M25,15H15V25H25V15Z\"/><rect class=\"cls-1\" x=\"8.26\" y=\"3.77\" width=\"7.38\" height=\"2.5\"/><polygon class=\"cls-1\" points=\"16.33 21.23 3.77 21.23 3.77 8.68 6.27 8.68 6.27 18.73 16.33 18.73 16.33 21.23\"/></svg>";
            case MAP_BLUE_STRATAMAP:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.STRATAMAP_MAPS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 113.39 141.73\"><defs><style>.cls-1{fill:#23254e;}.cls-2{fill:#4f5171;}.cls-3{fill:#00d849;}</style></defs><title>Application Icon</title><polyline class=\"cls-1\" points=\"79.83 0 0 0 0 141.73 113.39 141.73 113.39 33.56\"/><polygon class=\"cls-2\" points=\"113.39 33.56 79.83 33.56 79.83 0 113.39 33.56\"/><path class=\"cls-3\" d=\"M47.23,59.47v9.4h-9.4v-9.4h9.4m4.67-4.67H33.16V73.54H51.89V54.8Z\"/><path class=\"cls-3\" d=\"M75.16,59.47v9.4h-9.4v-9.4h9.4m4.67-4.67H61.09V73.54H79.83V54.8Z\"/><path class=\"cls-3\" d=\"M75.16,87.4v9.4h-9.4V87.4h9.4m4.67-4.67H61.09v18.73H79.83V82.73Z\"/><rect class=\"cls-3\" x=\"48.57\" y=\"61.84\" width=\"13.77\" height=\"4.67\"/><polygon class=\"cls-3\" points=\"63.65 94.43 40.19 94.43 40.19 71 44.86 71 44.86 89.77 63.65 89.77 63.65 94.43\"/></svg>";
            case MAP_GREEN_STRATAMAP:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.STRATAMAP_MAPS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 113.39 141.73\"><defs><style>.cls-1{fill:#00d849;}.cls-2{fill:#66e892;}.cls-3{fill:#fff;}</style></defs><title>Application Icon</title><polyline class=\"cls-1\" points=\"79.83 0 0 0 0 141.73 113.39 141.73 113.39 33.56\"/><polygon class=\"cls-2\" points=\"113.39 33.56 79.83 33.56 79.83 0 113.39 33.56\"/><path class=\"cls-3\" d=\"M47.23,59.47v9.4h-9.4v-9.4h9.4m4.67-4.67H33.16V73.54H51.89V54.8Z\"/><path class=\"cls-3\" d=\"M75.16,59.47v9.4h-9.4v-9.4h9.4m4.67-4.67H61.09V73.54H79.83V54.8Z\"/><path class=\"cls-3\" d=\"M75.16,87.4v9.4h-9.4V87.4h9.4m4.67-4.67H61.09v18.73H79.83V82.73Z\"/><rect class=\"cls-3\" x=\"48.57\" y=\"61.84\" width=\"13.77\" height=\"4.67\"/><polygon class=\"cls-3\" points=\"63.65 94.43 40.19 94.43 40.19 71 44.86 71 44.86 89.77 63.65 89.77 63.65 94.43\"/></svg>";
            case MAP_OUTLINE_STRATAMAP:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.STRATAMAP_MAPS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 113.39 141.73\"><defs><style>.cls-1{fill:#00d849;}.cls-2{fill:none;stroke:#00d849;stroke-linecap:square;stroke-miterlimit:10;stroke-width:6px;}</style></defs><title>Application Icon</title><path class=\"cls-1\" d=\"M77.34,6l30,30v99.69H6V6H77.34m2.49-6H0V141.73H113.39V33.56L79.83,0Z\"/><path class=\"cls-1\" d=\"M47.23,59.47v9.4h-9.4v-9.4h9.4m4.67-4.67H33.16V73.54H51.89V54.8Z\"/><path class=\"cls-1\" d=\"M75.16,59.47v9.4h-9.4v-9.4h9.4m4.67-4.67H61.09V73.54H79.83V54.8Z\"/><path class=\"cls-1\" d=\"M75.16,87.4v9.4h-9.4V87.4h9.4m4.67-4.67H61.09v18.73H79.83V82.73Z\"/><rect class=\"cls-1\" x=\"48.57\" y=\"61.84\" width=\"13.77\" height=\"4.67\"/><polygon class=\"cls-1\" points=\"63.65 94.43 40.19 94.43 40.19 71 44.86 71 44.86 89.77 63.65 89.77 63.65 94.43\"/><line class=\"cls-2\" x1=\"79.83\" y1=\"35.1\" x2=\"108.75\" y2=\"35.1\"/><line class=\"cls-2\" x1=\"77.13\" y1=\"3.73\" x2=\"77.13\" y2=\"35.1\"/></svg>";
            case STRATAMAP_BLUE_STRATAMAP:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.STRATAMAP_MAPS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 123.28 151.07\"><defs><style>.cls-1{fill:#23254e;}.cls-2{fill:#4f5171;}.cls-3{fill:#00d849;}.cls-4{fill:#fff;}</style></defs><title>Application Icon</title><polyline class=\"cls-1\" points=\"80.76 0 9.9 0 9.9 141.73 123.28 141.73 123.28 42.52\"/><polygon class=\"cls-2\" points=\"123.28 42.52 80.76 42.52 80.76 0 123.28 42.52\"/><rect class=\"cls-3\" y=\"99.55\" width=\"51.52\" height=\"51.52\"/><polygon class=\"cls-4\" points=\"41.98 141.52 38.47 141.52 38.47 127.06 9.54 127.06 9.54 109.09 13.05 109.09 13.05 123.55 41.98 123.55 41.98 141.52\"/><polygon class=\"cls-4\" points=\"41.98 119.83 16.77 119.83 16.77 109.09 20.28 109.09 20.28 116.32 41.98 116.32 41.98 119.83\"/><rect class=\"cls-4\" x=\"24.01\" y=\"109.09\" width=\"17.97\" height=\"3.51\"/><polygon class=\"cls-4\" points=\"34.74 141.52 31.23 141.52 31.23 134.29 9.54 134.29 9.54 130.78 34.74 130.78 34.74 141.52\"/><rect class=\"cls-4\" x=\"9.54\" y=\"138.02\" width=\"17.97\" height=\"3.51\"/></svg>";
            case STRATAMAP_GREEN_STRATAMAP:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.STRATAMAP_MAPS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 123.28 151.07\"><defs><style>.cls-1{fill:#00d849;}.cls-2{fill:#66e892;}.cls-3{fill:#23254e;}</style></defs><title>Application Icon</title><polyline class=\"cls-1\" points=\"80.76 0 9.9 0 9.9 141.73 123.28 141.73 123.28 42.52\"/><polygon class=\"cls-2\" points=\"123.28 42.52 80.76 42.52 80.76 0 123.28 42.52\"/><rect class=\"cls-3\" y=\"99.55\" width=\"51.52\" height=\"51.52\"/><polygon class=\"cls-1\" points=\"41.98 141.52 38.47 141.52 38.47 127.06 9.54 127.06 9.54 109.09 13.05 109.09 13.05 123.55 41.98 123.55 41.98 141.52\"/><polygon class=\"cls-1\" points=\"41.98 119.83 16.77 119.83 16.77 109.09 20.28 109.09 20.28 116.32 41.98 116.32 41.98 119.83\"/><rect class=\"cls-1\" x=\"24.01\" y=\"109.09\" width=\"17.97\" height=\"3.51\"/><polygon class=\"cls-1\" points=\"34.74 141.52 31.23 141.52 31.23 134.29 9.54 134.29 9.54 130.78 34.74 130.78 34.74 141.52\"/><rect class=\"cls-1\" x=\"9.54\" y=\"138.02\" width=\"17.97\" height=\"3.51\"/></svg>";
            case STRATAMAP_OUTLINE_STRATAMAP:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.STRATAMAP_MAPS)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 123.28 151.07\"><defs><style>.cls-1{fill:#00d849;}.cls-2{fill:#23254e;}.cls-3{fill:none;stroke:#00d849;stroke-linecap:square;stroke-linejoin:bevel;stroke-width:6px;}</style></defs><title>Application Icon</title><path class=\"cls-1\" d=\"M78.28,6l39,39v90.73H15.9V6H78.28m2.49-6H9.9V141.73H123.28V42.52L80.76,0Z\"/><rect class=\"cls-2\" y=\"99.55\" width=\"51.52\" height=\"51.52\"/><polygon class=\"cls-1\" points=\"41.98 141.52 38.47 141.52 38.47 127.06 9.54 127.06 9.54 109.09 13.05 109.09 13.05 123.55 41.98 123.55 41.98 141.52\"/><polygon class=\"cls-1\" points=\"41.98 119.83 16.77 119.83 16.77 109.09 20.28 109.09 20.28 116.32 41.98 116.32 41.98 119.83\"/><rect class=\"cls-1\" x=\"24.01\" y=\"109.09\" width=\"17.97\" height=\"3.51\"/><polygon class=\"cls-1\" points=\"34.74 141.52 31.23 141.52 31.23 134.29 9.54 134.29 9.54 130.78 34.74 130.78 34.74 141.52\"/><rect class=\"cls-1\" x=\"9.54\" y=\"138.02\" width=\"17.97\" height=\"3.51\"/><line class=\"cls-3\" x1=\"76.76\" y1=\"4.06\" x2=\"76.76\" y2=\"46.39\"/><line class=\"cls-3\" x1=\"118.76\" y1=\"46.39\" x2=\"76.76\" y2=\"46.39\"/></svg>";
            case TECHNOLOGY_ARTIFACT:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.TECHNOLOGY)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M13.23,2.45l6.43,6.43V22.55H5.35V2.45h7.88m1-2.5H2.85V25.05h19.3V7.84L14.26-.05Z\"/><polygon class=\"cls-1\" points=\"22.15 10.66 11.51 10.66 11.51 -0.05 14.01 -0.05 14.01 8.16 22.15 8.16 22.15 10.66\"/></svg>";
            case TECHNOLOGY_COMMUNICATION_PATH:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.TECHNOLOGY)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M19,13.75h-2.6v-2.5H19Zm-5.19,0h-2.6v-2.5h2.6Zm-5.19,0H6v-2.5h2.6Z\"/><polygon class=\"cls-1\" points=\"6.84 20.74 0.03 12.5 6.84 4.26 8.76 5.86 3.27 12.5 8.76 19.14 6.84 20.74\"/><polygon class=\"cls-1\" points=\"18.17 20.74 16.24 19.14 21.73 12.5 16.24 5.86 18.17 4.26 24.97 12.5 18.17 20.74\"/></svg>";
            case TECHNOLOGY_DATABASE:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.TECHNOLOGY)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M25,7.94C25,3.56,19.39,0,12.5,0S0,3.56,0,7.94m0,0V17C0,21.42,5.61,25,12.5,25S25,21.42,25,17V7.94M12.5,2.54c5.88,0,10,2.85,10,5.4s-4.1,5.4-10,5.4-10-2.85-10-5.4S6.62,2.54,12.5,2.54Zm0,19.89c-5.88,0-10-2.85-10-5.4V12.7a15.65,15.65,0,0,0,10,3.19,15.65,15.65,0,0,0,10-3.19V17C22.48,19.59,18.38,22.44,12.5,22.44Z\"/><path class=\"cls-1\" d=\"M12.5,2.54c5.88,0,10,2.85,10,5.4s-4.1,5.4-10,5.4-10-2.85-10-5.4,4.1-5.4,10-5.4M12.5,0C5.61,0,0,3.56,0,7.94s5.59,7.94,12.48,7.94S25,12.33,25,7.94,19.39,0,12.5,0Z\"/></svg>";
            case TECHNOLOGY_DEVICE:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.TECHNOLOGY)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M22.5,2.42V14h-20V2.42h20M25-.08H0V16.53H25V-.08Z\"/><path class=\"cls-1\" d=\"M19.4,20.44l1.14,2H4.27l1.14-2h14m1.47-2.5H3.94L0,25H24.8l-3.93-7Z\"/></svg>";
            case TECHNOLOGY_FUNCTION:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.TECHNOLOGY)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M12.5,3l10,6.67V20.33l-8.61-5.74-1.39-.92-1.39.92L2.5,20.33V9.67L12.5,3m0-3L0,8.33V25l12.5-8.33L25,25V8.33L12.5,0Z\"/></svg>";
            case TECHNOLOGY_INTERFACE:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.TECHNOLOGY)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M17.15,7.15A5.35,5.35,0,1,1,11.8,12.5a5.35,5.35,0,0,1,5.35-5.35m0-2.5A7.85,7.85,0,1,0,25,12.5a7.85,7.85,0,0,0-7.85-7.85Z\"/><rect class=\"cls-1\" y=\"11.25\" width=\"10.5\" height=\"2.5\"/></svg>";
            case TECHNOLOGY_NETWORK:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.TECHNOLOGY)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M17.79,16.34a2.6,2.6,0,1,1-2.6,2.6,2.6,2.6,0,0,1,2.6-2.6m0-2.5a5.1,5.1,0,1,0,5.1,5.1,5.1,5.1,0,0,0-5.1-5.1Z\"/><path class=\"cls-1\" d=\"M5.1,16.34a2.6,2.6,0,1,1-2.6,2.6,2.6,2.6,0,0,1,2.6-2.6m0-2.5a5.1,5.1,0,1,0,5.1,5.1,5.1,5.1,0,0,0-5.1-5.1Z\"/><rect class=\"cls-1\" x=\"8.95\" y=\"17.69\" width=\"5.94\" height=\"2.5\"/><path class=\"cls-1\" d=\"M19.9,3.46a2.6,2.6,0,1,1-2.6,2.6,2.6,2.6,0,0,1,2.6-2.6m0-2.5A5.1,5.1,0,1,0,25,6.06,5.1,5.1,0,0,0,19.9,1Z\"/><path class=\"cls-1\" d=\"M7.21,3.46a2.6,2.6,0,1,1-2.6,2.6,2.6,2.6,0,0,1,2.6-2.6m0-2.5a5.1,5.1,0,1,0,5.1,5.1A5.1,5.1,0,0,0,7.21,1Z\"/><rect class=\"cls-1\" x=\"11.06\" y=\"4.81\" width=\"5.94\" height=\"2.5\"/><rect class=\"cls-1\" x=\"3.2\" y=\"11.16\" width=\"5.83\" height=\"2.5\" transform=\"translate(-7.15 16.33) rotate(-80.24)\"/><rect class=\"cls-1\" x=\"15.8\" y=\"11.27\" width=\"6\" height=\"2.5\" transform=\"translate(3.27 28.92) rotate(-80.24)\"/></svg>";
            case TECHNOLOGY_NODE:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.TECHNOLOGY)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M7.58,0,0,6.47V25H18.36L25,17.78V0Zm.92,2.5H20.73l-4,4H3.85Zm7.35,20H2.5V9H15.86Zm2.5-1.19V8.41L22.5,4.27V16.81Z\"/></svg>";
            case TECHNOLOGY_SERVICE:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.TECHNOLOGY)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M17.15,7.15a5.35,5.35,0,1,1,0,10.7H7.8a5.35,5.35,0,1,1,0-10.7h9.35m0-2.5H7.8a7.85,7.85,0,1,0,0,15.7h9.35a7.85,7.85,0,1,0,0-15.7Z\"/></svg>";
            case TECHNOLOGY_SYSTEM_SOFTWARE:
                return "<svg x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\" "+ getIconStyles(Category.TECHNOLOGY)+" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs></defs><title>Colour</title><path class=\"cls-1\" d=\"M22.05,2.95a10,10,0,0,0-14.14,0l-5,5c.23-.23.48-.45.73-.66-.25.21-.49.42-.73.66A10,10,0,1,0,18.65,20h0a42.14,42.14,0,0,0,3.39-2.93A10,10,0,0,0,22.05,2.95ZM4.44,6.68,4,7ZM7.71,5.26l-.14,0Zm-.84.24-.21.07ZM6,5.81l-.29.13Zm-.81.39-.36.21ZM15.32,20.28a7.5,7.5,0,1,1,0-10.61A7.45,7.45,0,0,1,15.32,20.28Zm5-5L20,15.6A10,10,0,0,0,10,5c-.21,0-.43,0-.64,0h0l.29-.29A7.5,7.5,0,1,1,20.28,15.32ZM8.48,5.11h0Z\"/></svg>";
            default:
                return "";
        }
    }
//    public static String getSVGIcons(ArchiEnum archiEnum,SVGSingleShape svgShape) {
//        if (archiEnum.APPLICATION_COLLABORATION.equalsName(svgShape.getElementType())) {
//            return archiEnum.APPLICATION_COLLABORATION.iconSVGCode(svgShape);
//        } else if (archiEnum.APPLICATION_COMPONENT.equalsName(svgShape.getElementType())) {
//            return archiEnum.APPLICATION_COMPONENT.iconSVGCode(svgShape);
//        } else if (archiEnum.APPLICATION_FUNCTION.equalsName(svgShape.getElementType())) {
//            return archiEnum.APPLICATION_FUNCTION.iconSVGCode(svgShape);
//        } else if (archiEnum.APPLICATION_INTERACTION.equalsName(svgShape.getElementType())) {
//            return archiEnum.APPLICATION_INTERACTION.iconSVGCode(svgShape);
//        } else if (archiEnum.APPLICATION_INTERFACE.equalsName(svgShape.getElementType())) {
//            return archiEnum.APPLICATION_INTERFACE.iconSVGCode(svgShape);
//        } else if (archiEnum.APPLICATION_OBJECT.equalsName(svgShape.getElementType())) {
//            return archiEnum.APPLICATION_OBJECT.iconSVGCode(svgShape);
//        } else if (archiEnum.APPLICATION_SERVICE.equalsName(svgShape.getElementType())) {
//            return archiEnum.APPLICATION_SERVICE.iconSVGCode(svgShape);
//        } else if (archiEnum.BUSINESS_ACTOR.equalsName(svgShape.getElementType())) {
//            return archiEnum.BUSINESS_ACTOR.iconSVGCode(svgShape);
//        } else if (archiEnum.BUSINESS_COLLABORATION.equalsName(svgShape.getElementType())) {
//            return archiEnum.BUSINESS_COLLABORATION.iconSVGCode(svgShape);
//        } else if (archiEnum.BUSINESS_EVENT.equalsName(svgShape.getElementType())) {
//            return archiEnum.BUSINESS_EVENT.iconSVGCode(svgShape);
//        } else if (archiEnum.BUSINESS_FUNCTION.equalsName(svgShape.getElementType())) {
//            return archiEnum.BUSINESS_FUNCTION.iconSVGCode(svgShape);
//        } else if (archiEnum.BUSINESS_INTERACTION.equalsName(svgShape.getElementType())) {
//            return archiEnum.BUSINESS_INTERACTION.iconSVGCode(svgShape);
//        } else if (archiEnum.BUSINESS_INTERFACE.equalsName(svgShape.getElementType())) {
//            return archiEnum.BUSINESS_INTERFACE.iconSVGCode(svgShape);
//        } else if (archiEnum.BUSINESS_LOCATION.equalsName(svgShape.getElementType())) {
//            return archiEnum.BUSINESS_LOCATION.iconSVGCode(svgShape);
//        } else if (archiEnum.BUSINESS_MEANING.equalsName(svgShape.getElementType())) {
//            return archiEnum.BUSINESS_MEANING.iconSVGCode(svgShape);
//        } else if (archiEnum.BUSINESS_OBJECT.equalsName(svgShape.getElementType())) {
//            return archiEnum.BUSINESS_OBJECT.iconSVGCode(svgShape);
//        } else if (archiEnum.BUSINESS_PROCESS.equalsName(svgShape.getElementType())) {
//            return archiEnum.BUSINESS_PROCESS.iconSVGCode(svgShape);
//        } else if (archiEnum.BUSINESS_PRODUCT.equalsName(svgShape.getElementType())) {
//            return archiEnum.BUSINESS_PRODUCT.iconSVGCode(svgShape);
//        } else if (archiEnum.BUSINESS_REPRESENTATION.equalsName(svgShape.getElementType())) {
//            return archiEnum.BUSINESS_REPRESENTATION.iconSVGCode(svgShape);
//        } else if (archiEnum.BUSINESS_SERVICE.equalsName(svgShape.getElementType())) {
//            return archiEnum.BUSINESS_SERVICE.iconSVGCode(svgShape);
//        } else if (archiEnum.BUSINESS_STAKEHOLDER.equalsName(svgShape.getElementType())) {
//            return archiEnum.BUSINESS_STAKEHOLDER.iconSVGCode(svgShape);
//        } else if (archiEnum.BUSINESS_VALUE.equalsName(svgShape.getElementType())) {
//            return archiEnum.BUSINESS_VALUE.iconSVGCode(svgShape);
//        } else if (archiEnum.GOALS_ASSESSMENT.equalsName(svgShape.getElementType())) {
//            return archiEnum.GOALS_ASSESSMENT.iconSVGCode(svgShape);
//        } else if (archiEnum.GOALS_CONSTRAINT.equalsName(svgShape.getElementType())) {
//            return archiEnum.GOALS_CONSTRAINT.iconSVGCode(svgShape);
//        } else if (archiEnum.GOALS_DRIVER.equalsName(svgShape.getElementType())) {
//            return archiEnum.GOALS_DRIVER.iconSVGCode(svgShape);
//        } else if (archiEnum.GOALS_GAP.equalsName(svgShape.getElementType())) {
//            return archiEnum.GOALS_GAP.iconSVGCode(svgShape);
//        } else if (archiEnum.GOALS_GOAL.equalsName(svgShape.getElementType())) {
//            return archiEnum.GOALS_GOAL.iconSVGCode(svgShape);
//        } else if (archiEnum.GOALS_PLATEAU.equalsName(svgShape.getElementType())) {
//            return archiEnum.GOALS_PLATEAU.iconSVGCode(svgShape);
//        } else if (archiEnum.GOALS_PRINCIPAL.equalsName(svgShape.getElementType())) {
//            return archiEnum.GOALS_PRINCIPAL.iconSVGCode(svgShape);
//        } else if (archiEnum.GOALS_REPRESENTATION.equalsName(svgShape.getElementType())) {
//            return archiEnum.GOALS_REPRESENTATION.iconSVGCode(svgShape);
//        } else if (archiEnum.GOALS_REQUIREMENT.equalsName(svgShape.getElementType())) {
//            return archiEnum.GOALS_REQUIREMENT.iconSVGCode(svgShape);
//        } else if (archiEnum.GOALS_ROLE.equalsName(svgShape.getElementType())) {
//            return archiEnum.GOALS_ROLE.iconSVGCode(svgShape);
//        } else if (archiEnum.GOALS_UNAMED.equalsName(svgShape.getElementType())) {
//            return archiEnum.GOALS_UNAMED.iconSVGCode(svgShape);
//        } else if (archiEnum.MAPS.equalsName(svgShape.getElementType())) {
//            return archiEnum.MAPS.iconSVGCode(svgShape);
//        } else if (archiEnum.MAP_BLUE_STRATAMAP.equalsName(svgShape.getElementType())) {
//            return archiEnum.MAP_BLUE_STRATAMAP.iconSVGCode(svgShape);
//        } else if (archiEnum.MAP_GREEN_STRATAMAP.equalsName(svgShape.getElementType())) {
//            return archiEnum.MAP_GREEN_STRATAMAP.iconSVGCode(svgShape);
//        } else if (archiEnum.MAP_OUTLINE_STRATAMAP.equalsName(svgShape.getElementType())) {
//            return archiEnum.MAP_OUTLINE_STRATAMAP.iconSVGCode(svgShape);
//        } else if (archiEnum.STRATAMAP_BLUE_STRATAMAP.equalsName(svgShape.getElementType())) {
//            return archiEnum.STRATAMAP_BLUE_STRATAMAP.iconSVGCode(svgShape);
//        } else if (archiEnum.STRATAMAP_GREEN_STRATAMAP.equalsName(svgShape.getElementType())) {
//            return archiEnum.STRATAMAP_GREEN_STRATAMAP.iconSVGCode(svgShape);
//        } else if (archiEnum.STRATAMAP_OUTLINE_STRATAMAP.equalsName(svgShape.getElementType())) {
//            return archiEnum.STRATAMAP_OUTLINE_STRATAMAP.iconSVGCode(svgShape);
//        } else if (archiEnum.TECHNOLOGY_ARTIFACT.equalsName(svgShape.getElementType())) {
//            return archiEnum.TECHNOLOGY_ARTIFACT.iconSVGCode(svgShape);
//        } else if (archiEnum.TECHNOLOGY_COMMUNICATION_PATH.equalsName(svgShape.getElementType())) {
//            return archiEnum.TECHNOLOGY_COMMUNICATION_PATH.iconSVGCode(svgShape);
//        } else if (archiEnum.TECHNOLOGY_DATABASE.equalsName(svgShape.getElementType())) {
//            return archiEnum.TECHNOLOGY_DATABASE.iconSVGCode(svgShape);
//        } else if (archiEnum.TECHNOLOGY_DEVICE.equalsName(svgShape.getElementType())) {
//            return archiEnum.TECHNOLOGY_DEVICE.iconSVGCode(svgShape);
//        } else if (archiEnum.TECHNOLOGY_FUNCTION.equalsName(svgShape.getElementType())) {
//            return archiEnum.TECHNOLOGY_FUNCTION.iconSVGCode(svgShape);
//        } else if (archiEnum.TECHNOLOGY_INTERFACE.equalsName(svgShape.getElementType())) {
//            return archiEnum.TECHNOLOGY_INTERFACE.iconSVGCode(svgShape);
//        } else if (archiEnum.TECHNOLOGY_NETWORK.equalsName(svgShape.getElementType())) {
//            return archiEnum.TECHNOLOGY_NETWORK.iconSVGCode(svgShape);
//        } else if (archiEnum.TECHNOLOGY_NODE.equalsName(svgShape.getElementType())) {
//            return archiEnum.TECHNOLOGY_NODE.iconSVGCode(svgShape);
//        } else if (archiEnum.TECHNOLOGY_SERVICE.equalsName(svgShape.getElementType())) {
//            return archiEnum.TECHNOLOGY_SERVICE.iconSVGCode(svgShape);
//        } else if (archiEnum.TECHNOLOGY_SYSTEM_SOFTWARE.equalsName(svgShape.getElementType())) {
//            return archiEnum.TECHNOLOGY_SYSTEM_SOFTWARE.iconSVGCode(svgShape);
//        } else
//            return " ";
//
//    }
}
