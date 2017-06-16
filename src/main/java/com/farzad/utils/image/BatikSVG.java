package com.farzad.utils.image; /**
 * Created by VOLCANO on 4/15/2017.
 */

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import java.awt.*;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

    public class BatikSVG {

        public void paint(Graphics2D g2d) {
            g2d.setPaint(Color.red);
            g2d.fill(new Rectangle(10, 10, 100, 100));
        }

        public static void mainc() throws IOException {

            // Get a DOMImplementation.
            DOMImplementation domImpl =
                    GenericDOMImplementation.getDOMImplementation();

            // Create an instance of org.w3c.dom.Document.
            String svgNS = "http://www.w3.org/2000/svg";
            Document document = domImpl.createDocument(svgNS, "svg", null);

            // Create an instance of the SVG Generator.
            SVGGraphics2D svgGenerator = new SVGGraphics2D(document);

            // Ask the test to render into the SVG Graphics2D implementation.
            BatikSVG test = new BatikSVG();
//            test.paint(svgGenerator);

            // Finally, stream out SVG to the standard output using
            // UTF-8 encoding.
            boolean useCSS = true; // we want to use CSS style attributes
            Writer out = new OutputStreamWriter(System.out, "UTF-8");
//            svgGenerator.stream(out, useCSS);
        }
}
