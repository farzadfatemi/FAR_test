package com.Farzad.utils.IOUtil;

/**
 * Created by VOLCANO on 4/28/2017.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {
//    private static final String FILENAME = "D:\\FAR_Documents\\__Startamap\\archiModelToSVG.html";
    private static final String FILENAME = "D:\\FAR_Documents\\__Startamap\\archiModelToSVG.svg";

    public static void WriteToHTML(String body) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
            String content = outputAsASVG(body);


            bw.write(content);

            lunchBrowser();
        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    private static String outputAsAnHTML(String body) {
        String content = "<html style=\"width:100%;height:100%;\">\n" +
                "\n" +
                "  <head>\n" +
                "    <title>SVG ARCHI MODEL</title>\n" +
                "<link rel='stylesheet' type='text/css' href='style.css'/>" +
//                    "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n" +
//                    "<script>" +
//                    "$(function() {\n" +
//                    "    slided = function (level){\n" +
//                    "        var svg=$(\"svg\");\n" +
//                    "        svg.css(\"transform\", \"scale(\"+level+\")\");\n" +
//                    "    }\n" +
//                    "});" +
//                    "</script>" +
//                    "<link href=\"https://fonts.googleapis.com/css?family=Montserrat\" rel=\"stylesheet\">" +
//                    "<style>" +
//                    ".mainRect{\n" +
//                    "\tfill:#ffffff\n" +
//                    "}" +
//                    "</style>" +
                "  </head>\n" +
                "  <body style=\"width:100%;height:100%;margin:10;\"> " +
//                    "<input type=\"range\" min=\"1\" max=\"10\" value=\"1\" step=\"0.1\" oninput=\"slided(this.value);\">\n" +
                "<div id=\"container\">";
        content += body;
        content += " </div> </body>\n" +
                "</html>";
        return content;
    }

    private static String outputAsASVG(String body) {
        return "" +
                "<?xml version=\"1.0\" standalone=\"no\"?>\n" +
                "<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" " + "\"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n" +
                " <svg version=\"1.1\"\n" + " xmlns=\"http://www.w3.org/2000/svg\">" + "\n" + "<defs>\n" +
                " <link href=\"style.css\" type=\"text/css\" rel=\"stylesheet\" " + " xmlns=\"http://www.w3.org/1999/xhtml\"/>\n " + "</defs>\n" +
                body +
                " \n</svg>";
    }

    private static void lunchBrowser() {

        try {


//            if (Desktop.isDesktopSupported ()) {
//                Desktop.getDesktop ().browse (new URI ("file:///D:/FAR_Documents/__Startamap/archiModelToSVG.html"));
//            }
//            Runtime.getRuntime().exec(new String[]{"cmd", "/c", "start chrome file:///D:/FAR_Documents/__Startamap/archiModelToSVG.html"});
            Runtime.getRuntime().exec(new String[]{"cmd", "/c", "start chrome file:///D:/FAR_Documents/__Startamap/archiModelToSVG.svg"});
        } catch (Exception e) {

            e.printStackTrace();

        }

    }


}
