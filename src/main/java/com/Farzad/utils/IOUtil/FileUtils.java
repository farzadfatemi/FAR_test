package com.Farzad.utils.IOUtil;

/**
 * Created by VOLCANO on 4/28/2017.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {
    private static final String FILENAME = "D:\\FAR_Documents\\__Startamap\\archiModelToSVG.html";

    public static void WriteToHTML(String body) {

        try (BufferedWriter bw = new BufferedWriter (new FileWriter (FILENAME))) {

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
            bw.write (content);

            lunchBrowser ();
        } catch (IOException e) {

            e.printStackTrace ();

        }

    }

    private static void lunchBrowser() {

        try {


//            if (Desktop.isDesktopSupported ()) {
//                Desktop.getDesktop ().browse (new URI ("file:///D:/FAR_Documents/__Startamap/archiModelToSVG.html"));
//            }
            Runtime.getRuntime().exec(new String[]{"cmd", "/c","start chrome file:///D:/FAR_Documents/__Startamap/archiModelToSVG.html"});
        } catch (Exception e) {

            e.printStackTrace ();

        }

    }


}
