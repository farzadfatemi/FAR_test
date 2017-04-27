package com.Farzad.utils.IOUtil;

/**
 * Created by VOLCANO on 4/28/2017.
 */

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;

public class FileUtils {
    private static final String FILENAME = "D:\\FAR_Documents\\__Startamap\\archiModelToSVG.html";

    public static void WriteToHTML(String body) {

        try (BufferedWriter bw = new BufferedWriter (new FileWriter (FILENAME))) {

            String content = "<html>\n" +
                    "  <head>\n" +
                    "    <title>SVG ARCHI MODEL</title>\n" +
                    "  </head>\n" +
                    "  <body> ";
            content += body;
            content += "  </body>\n" +
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
