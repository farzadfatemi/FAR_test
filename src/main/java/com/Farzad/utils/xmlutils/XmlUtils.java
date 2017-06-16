package com.Farzad.utils.xmlutils;

/**
 * Created by VOLCANO on 4/22/2017.
 */

import com.archimatetool.model.*;
import org.eclipse.emf.ecore.EObject;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Iterator;
import java.util.List;

import static com.Farzad.utils.ImageUtils.ModelTools.loadModel;

public class XmlUtils {

    public static void ReadXMLFile()

    {

        try {

            File fXmlFile = new File("D:\\FAR_Documents\\__Startamap\\Home.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("staff");

            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("Staff id : " + eElement.getAttribute("id"));
                    System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
                    System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ReadXMLFile2() {

        try {

            File file = new File("D:\\FAR_Documents\\__Startamap\\Home.xml");

            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();

            Document doc = dBuilder.parse(file);

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            if (doc.hasChildNodes()) {

                printNote(doc.getChildNodes());

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static void printNote(NodeList nodeList) {

        for (int count = 0; count < nodeList.getLength(); count++) {

            Node tempNode = nodeList.item(count);

            // make sure it's element node.
            if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

                // get node name and value
                System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
                System.out.println("Node Value =" + tempNode.getTextContent());

                if (tempNode.hasAttributes()) {

                    // get attributes names and values
                    NamedNodeMap nodeMap = tempNode.getAttributes();

                    for (int i = 0; i < nodeMap.getLength(); i++) {

                        Node node = nodeMap.item(i);
                        System.out.println("attr name : " + node.getNodeName());
                        System.out.println("attr value : " + node.getNodeValue());

                    }

                }

                if (tempNode.hasChildNodes()) {

                    // loop again if has child nodes
                    printNote(tempNode.getChildNodes());

                }

                System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]");

            }

        }

    }

    public static void ReadArchiModel() {

        try {

            File modelFile = new File("D:\\FAR_Documents\\__Startamap\\Original.archimate");


            IArchimateModel model = loadModel(modelFile);
            List<IDiagramModel> iDModels = model.getDiagramModels();
            List SourceConList = null;
            List childSourceConList = null;
            List childrenList = null;
            IDiagramModel diagramModel = iDModels.get(0);
//            for (IDiagramModel diagramModel : iDModels) {
            for (EObject obj : diagramModel.eContents()) {
                if (obj instanceof IDiagramModelArchimateObject) {
                    IDiagramModelArchimateObject dia = (IDiagramModelArchimateObject) obj;
                    System.out.println("------------------------- ");
                    System.out.println("Type : " + dia.getArchimateElement());
                    System.out.println("Bounds : " + dia.getBounds());
                    System.out.println("Fill Color : " + dia.getFillColor());
                    System.out.println("Font : " + dia.getFont());
                    System.out.println("FontColor : " + dia.getFontColor());
                    System.out.println("Id : " + dia.getId());
                    System.out.println("Name : " + dia.getName());
                    System.out.println("Element Type : " + dia.getArchimateElement().getClass().getSimpleName());
                    System.out.println("LineColor : " + dia.getLineColor());
                    System.out.println("LineWidth : " + dia.getLineWidth());
                    System.out.println("Type : " + dia.getType());
                    System.out.println("DefaultTextAlignment : " + dia.getDefaultTextAlignment());
                    System.out.println("TextAlignment : " + dia.getTextAlignment());
                    System.out.println("Source Connections : ");
                    SourceConList = dia.getSourceConnections();
                    childrenList = dia.getChildren();
                    for (Object iDiModelConnobj : SourceConList) {
//                            ((IDiagramModelConnection)iDiModelConnobj).getSource().getId()
//                            ((IDiagramModelConnection)iDiModelConnobj).getTarget().getId()
                        System.out.println(" -- Bendpoints : " + ((IDiagramModelConnection) iDiModelConnobj).getBendpoints());
                        System.out.println(" -- FontColor : " + ((IDiagramModelConnection) iDiModelConnobj).getFontColor());
                        System.out.println(" -- Type : " + ((IDiagramModelConnection) iDiModelConnobj).getType());
                        System.out.println(" -- LineWidth : " + ((IDiagramModelConnection) iDiModelConnobj).getLineWidth());
                        System.out.println(" -- LineColor : " + ((IDiagramModelConnection) iDiModelConnobj).getLineColor());
                        System.out.println(" -- Documentation : " + ((IDiagramModelConnection) iDiModelConnobj).getDocumentation());
                        System.out.println(" -- Name : " + ((IDiagramModelConnection) iDiModelConnobj).getName());
                        System.out.println(" -- Source().getLineWidth() : " + ((IDiagramModelConnection) iDiModelConnobj).getSource().getLineWidth());
                        System.out.println(" -- Source().getLineColor() : " + ((IDiagramModelConnection) iDiModelConnobj).getSource().getLineColor());
                        for (IDiagramModelConnection targetConns : ((IDiagramModelConnection) iDiModelConnobj).getSource().getTargetConnections()) {
                            System.out.println(" -- Source().getTargetConnections().getID : " + targetConns.getId());
                        }
                        System.out.println(" -- Source().getSource().getId() : " + ((IDiagramModelConnection) iDiModelConnobj).getSource().getId());
                        System.out.println(" -- Source().getTarget().getId() : " + ((IDiagramModelConnection) iDiModelConnobj).getTarget().getId());
                        System.out.println(" -- TextPosition : " + ((IDiagramModelConnection) iDiModelConnobj).getTextPosition());
                    }
                    for (Object child : childrenList) {
                        System.out.println(" --* Bendpoints : " + ((IDiagramModelArchimateObject) child).getSourceConnections());
                        System.out.println(" --* FontColor : " + ((IDiagramModelArchimateObject) child).getFontColor());
                        System.out.println(" --* Type : " + ((IDiagramModelArchimateObject) child).getType());
                        System.out.println(" --* LineWidth : " + ((IDiagramModelArchimateObject) child).getLineWidth());
                        System.out.println(" --* LineColor : " + ((IDiagramModelArchimateObject) child).getLineColor());
                        System.out.println(" --* getClass().getSimpleName() : " + ((IDiagramModelArchimateObject) child).getArchimateElement().getClass().getSimpleName());
                        System.out.println(" --* Name : " + ((IDiagramModelArchimateObject) child).getName());
                        childSourceConList = ((IDiagramModelArchimateObject) child).getSourceConnections();
                        for (Object iDiModelConnobj : childSourceConList) {
                            System.out.println(" CH -- Bendpoints : " + ((IDiagramModelConnection) iDiModelConnobj).getBendpoints());
                            System.out.println(" CH -- FontColor : " + ((IDiagramModelConnection) iDiModelConnobj).getFontColor());
                            System.out.println(" CH -- Type : " + ((IDiagramModelConnection) iDiModelConnobj).getType());
                            System.out.println(" CH -- LineWidth : " + ((IDiagramModelConnection) iDiModelConnobj).getLineWidth());
                            System.out.println(" CH -- LineColor : " + ((IDiagramModelConnection) iDiModelConnobj).getLineColor());
                            System.out.println(" CH -- Documentation : " + ((IDiagramModelConnection) iDiModelConnobj).getDocumentation());
                            System.out.println(" CH -- Name : " + ((IDiagramModelConnection) iDiModelConnobj).getName());
                            System.out.println(" CH -- Source().getLineWidth() : " + ((IDiagramModelConnection) iDiModelConnobj).getSource().getLineWidth());
                            System.out.println(" CH -- Source().getLineColor() : " + ((IDiagramModelConnection) iDiModelConnobj).getSource().getLineColor());
                            for (IDiagramModelConnection targetConns : ((IDiagramModelConnection) iDiModelConnobj).getSource().getTargetConnections()) {
                                System.out.println(" CH -- Source().getTargetConnections().getID : " + targetConns.getId());
                            }
                            System.out.println(" CH -- Source().getSource().getId() : " + ((IDiagramModelConnection) iDiModelConnobj).getSource().getId());
                            System.out.println(" CH -- Source().getTarget().getId() : " + ((IDiagramModelConnection) iDiModelConnobj).getTarget().getId());
                            System.out.println(" CH -- TextPosition : " + ((IDiagramModelConnection) iDiModelConnobj).getTextPosition());
                        }
//                        IDiagramModelObject diaChild =(IDiagramModelObject) childrenList;
//                        System.out.println("------------------------- ");
//                        System.out.println("CH -- Bounds : "+ diaChild.getBounds());
//                        System.out.println("CH -- Font : "+ diaChild.getFont());
//                        System.out.println("CH -- FontColor : "+ diaChild.getFontColor());
//                        System.out.println("CH -- Id : "+ diaChild.getId());
//                        System.out.println("CH -- Name : "+ diaChild.getName());
//                        System.out.println("CH -- LineColor : "+ diaChild.getLineColor());
//                        System.out.println("CH -- LineWidth : "+ diaChild.getLineWidth());
////                        System.out.println("CH -- Type : "+ diaChild.getType());
//                        System.out.println("CH -- DefaultTextAlignment : "+ diaChild.getDefaultTextAlignment());
//                        System.out.println("CH -- TextAlignment : "+ diaChild.getTextAlignment());
//                        System.out.println("CH -- Source Connections : ");
//                        childSourceConList = ((IDiagramModelArchimateObject )childrenList).getSourceConnections();
                        for (IDiagramModelConnection targetConns : ((IDiagramModelArchimateObject) child).getTargetConnections()) {
                            System.out.println(" --** Source().getTargetConnections().getID : " + targetConns.getId());
                        }
                    }
                    System.out.println("Bounds : " + dia.getBounds());
                    System.out.println("------------------------- ");
                } else if (obj instanceof IDiagramModelArchimateConnection) {

                }
            }

//            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void ReadArchiModel2() {

        try {

//            File modelFile = new File("D:\\FAR_Documents\\__Startamap\\Original.archimate");
            File modelFile = new File("D:\\FAR_Documents\\__Startamap\\eira_v1_1_0_archimate.archimate");


            IArchimateModel model = loadModel(modelFile);
            List<IDiagramModel> iDModels = model.getDiagramModels();
            List SourceConList = null;
            List childSourceConList = null;
            List childrenList = null;
            IDiagramModel diagramModel = iDModels.get(0);
//            for (IDiagramModel diagramModel : iDModels) {
            for (EObject obj : diagramModel.eContents()) {
                System.out.println(obj.getClass() + " ----------------1--------- ");
//                if (obj instanceof IDiagramModelGroup) {
//                    IDiagramModelGroup dia = (IDiagramModelGroup) obj;
//                    System.out.println("------------------------- ");
//                    System.out.println("Name : " + dia.getName());
//                    System.out.println("Bounds : " + dia.getBounds());
//                    System.out.println("Fill Color : " + dia.getFillColor());
//                    System.out.println("Font : " + dia.getFont());
//                    System.out.println("FontColor : " + dia.getFontColor());
//                    System.out.println("Id : " + dia.getId());
//                    System.out.println("Name : " + dia.getName());
//                    System.out.println("Element Type : " + dia.getChildren().getClass().getSimpleName());
//                    System.out.println("LineColor : " + dia.getLineColor());
//                    System.out.println("LineWidth : " + dia.getLineWidth());
////                    System.out.println("Type : " + dia.getType());
//                    System.out.println("DefaultTextAlignment : " + dia.getDefaultTextAlignment());
//                    System.out.println("TextAlignment : " + dia.getTextAlignment());
//                    System.out.println("Source Connections : ");
//                    SourceConList = dia.getSourceConnections();
//                    childrenList = dia.getChildren();
//                    for (Object iDiModelConnobj : SourceConList) {
////                            ((IDiagramModelConnection)iDiModelConnobj).getSource().getId()
////                            ((IDiagramModelConnection)iDiModelConnobj).getTarget().getId()
//                        System.out.println(" -- Bendpoints : " + ((IDiagramModelConnection) iDiModelConnobj).getBendpoints());
//                        System.out.println(" -- FontColor : " + ((IDiagramModelConnection) iDiModelConnobj).getFontColor());
//                        System.out.println(" -- Type : " + ((IDiagramModelConnection) iDiModelConnobj).getType());
//                        System.out.println(" -- LineWidth : " + ((IDiagramModelConnection) iDiModelConnobj).getLineWidth());
//                        System.out.println(" -- LineColor : " + ((IDiagramModelConnection) iDiModelConnobj).getLineColor());
//                        System.out.println(" -- Documentation : " + ((IDiagramModelConnection) iDiModelConnobj).getDocumentation());
//                        System.out.println(" -- Name : " + ((IDiagramModelConnection) iDiModelConnobj).getName());
//                        System.out.println(" -- Source().getLineWidth() : " + ((IDiagramModelConnection) iDiModelConnobj).getSource().getLineWidth());
//                        System.out.println(" -- Source().getLineColor() : " + ((IDiagramModelConnection) iDiModelConnobj).getSource().getLineColor());
//                        for (IDiagramModelConnection targetConns : ((IDiagramModelConnection) iDiModelConnobj).getSource().getTargetConnections()) {
//                            System.out.println(" -- Source().getTargetConnections().getID : " + targetConns.getId());
//                        }
//                        System.out.println(" -- Source().getSource().getId() : " + ((IDiagramModelConnection) iDiModelConnobj).getSource().getId());
//                        System.out.println(" -- Source().getTarget().getId() : " + ((IDiagramModelConnection) iDiModelConnobj).getTarget().getId());
//                        System.out.println(" -- TextPosition : " + ((IDiagramModelConnection) iDiModelConnobj).getTextPosition());
//                    }
//                    for (Object child : childrenList) {
//                        System.out.println(" --* Bendpoints : " + ((IDiagramModelArchimateObject) child).getSourceConnections());
//                        System.out.println(" --* FontColor : " + ((IDiagramModelArchimateObject) child).getFontColor());
//                        System.out.println(" --* Type : " + ((IDiagramModelArchimateObject) child).getType());
//                        System.out.println(" --* LineWidth : " + ((IDiagramModelArchimateObject) child).getLineWidth());
//                        System.out.println(" --* LineColor : " + ((IDiagramModelArchimateObject) child).getLineColor());
//                        System.out.println(" --* getClass().getSimpleName() : " + ((IDiagramModelArchimateObject) child).getArchimateElement().getClass().getSimpleName());
//                        System.out.println(" --* Name : " + ((IDiagramModelArchimateObject) child).getName());
//                        childSourceConList = ((IDiagramModelArchimateObject) child).getSourceConnections();
//                        for (Object iDiModelConnobj : childSourceConList) {
//                            System.out.println(" CH -- Bendpoints : " + ((IDiagramModelConnection) iDiModelConnobj).getBendpoints());
//                            System.out.println(" CH -- FontColor : " + ((IDiagramModelConnection) iDiModelConnobj).getFontColor());
//                            System.out.println(" CH -- Type : " + ((IDiagramModelConnection) iDiModelConnobj).getType());
//                            System.out.println(" CH -- LineWidth : " + ((IDiagramModelConnection) iDiModelConnobj).getLineWidth());
//                            System.out.println(" CH -- LineColor : " + ((IDiagramModelConnection) iDiModelConnobj).getLineColor());
//                            System.out.println(" CH -- Documentation : " + ((IDiagramModelConnection) iDiModelConnobj).getDocumentation());
//                            System.out.println(" CH -- Name : " + ((IDiagramModelConnection) iDiModelConnobj).getName());
//                            System.out.println(" CH -- Source().getLineWidth() : " + ((IDiagramModelConnection) iDiModelConnobj).getSource().getLineWidth());
//                            System.out.println(" CH -- Source().getLineColor() : " + ((IDiagramModelConnection) iDiModelConnobj).getSource().getLineColor());
//                            for (IDiagramModelConnection targetConns : ((IDiagramModelConnection) iDiModelConnobj).getSource().getTargetConnections()) {
//                                System.out.println(" CH -- Source().getTargetConnections().getID : " + targetConns.getId());
//                            }
//                            System.out.println(" CH -- Source().getSource().getId() : " + ((IDiagramModelConnection) iDiModelConnobj).getSource().getId());
//                            System.out.println(" CH -- Source().getTarget().getId() : " + ((IDiagramModelConnection) iDiModelConnobj).getTarget().getId());
//                            System.out.println(" CH -- TextPosition : " + ((IDiagramModelConnection) iDiModelConnobj).getTextPosition());
//                        }
////                        IDiagramModelObject diaChild =(IDiagramModelObject) childrenList;
////                        System.out.println("------------------------- ");
////                        System.out.println("CH -- Bounds : "+ diaChild.getBounds());
////                        System.out.println("CH -- Font : "+ diaChild.getFont());
////                        System.out.println("CH -- FontColor : "+ diaChild.getFontColor());
////                        System.out.println("CH -- Id : "+ diaChild.getId());
////                        System.out.println("CH -- Name : "+ diaChild.getName());
////                        System.out.println("CH -- LineColor : "+ diaChild.getLineColor());
////                        System.out.println("CH -- LineWidth : "+ diaChild.getLineWidth());
//////                        System.out.println("CH -- Type : "+ diaChild.getType());
////                        System.out.println("CH -- DefaultTextAlignment : "+ diaChild.getDefaultTextAlignment());
////                        System.out.println("CH -- TextAlignment : "+ diaChild.getTextAlignment());
////                        System.out.println("CH -- Source Connections : ");
////                        childSourceConList = ((IDiagramModelArchimateObject )childrenList).getSourceConnections();
//                        for (IDiagramModelConnection targetConns : ((IDiagramModelArchimateObject) child).getTargetConnections()) {
//                            System.out.println(" --** Source().getTargetConnections().getID : " + targetConns.getId());
//                        }
//                    }
//                    System.out.println("Bounds : " + dia.getBounds());
//                    System.out.println("------------------------- ");
//                } else
                if (obj instanceof IDiagramModelObject) {
                    IDiagramModelObject dia = (IDiagramModelObject) obj;
//                    for (IDiagramModelArchimateObject test :dia) {
//                        System.out.println(" --** Source().getTargetConnections().getID : " + targetConns.getId());
//                    }
//                    System.out.println( obj.getClass()+" ----------------2--------- ");

//                    System.out.println("Name : " + dia.getName());
//                    System.out.println("Value : " + dia.getValue());

                }
            }

//            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void ReadArchiModel3() {

        try {

            File modelFile = new File("D:\\FAR_Documents\\__Startamap\\Original2.archimate");
//            File modelFile = new File("D:\\FAR_Documents\\__Startamap\\eira_v1_1_0_archimate.archimate");


            IArchimateModel model = loadModel(modelFile);
            List<IDiagramModel> iDModels = model.getDiagramModels();
            List SourceConList = null;
            List childSourceConList = null;
            int grp =0,arch=0,conn=0;
            List childrenList = null;
            IDiagramModel diagramModel = iDModels.get(3);
//            for (IDiagramModel diagramModel : iDModels) {
            Iterator<EObject> contents = diagramModel.eAllContents();
            System.out.println("Diagram Name : "+diagramModel.getName());
            System.out.println("model Name : "+model.getName());
            while (contents.hasNext()) {
//                System.out.println(contents.next());
                EObject obj = contents.next();
                if (obj instanceof IDiagramModelGroup) {
                    grp++;
                    System.out.println(obj.getClass() + " ----------------"+grp+"--------- ");
                    IDiagramModelGroup dia = (IDiagramModelGroup) obj;
                    System.out.println("IDiagramModelGroup ## ------------------------- ");
                    System.out.println("Name : " + dia.getName());
                    System.out.println("Bounds : " + dia.getBounds());
                    System.out.println("Fill Color : " + dia.getFillColor());
                    System.out.println("Font : " + dia.getFont());
                    System.out.println("FontColor : " + dia.getFontColor());
                    System.out.println("Id : " + dia.getId());
                    System.out.println("Documentation : " + dia.getDocumentation());
                    System.out.println("eAllContents : " + dia.eAllContents());
                    System.out.println("Element Type : " + dia.getChildren().getClass().getSimpleName());
                    System.out.println("LineColor : " + dia.getLineColor());
                    System.out.println("LineWidth : " + dia.getLineWidth());
//                    System.out.println("Type : " + dia.getType());
                    System.out.println("DefaultTextAlignment : " + dia.getDefaultTextAlignment());
                    System.out.println("TextAlignment : " + dia.getTextAlignment());
                    System.out.println("Source Connections : ");
                    SourceConList = dia.getSourceConnections();
                    for (Object b : SourceConList) {

                        System.out.println("-- SourceConList : id : " + ((IDiagramModelConnection)b).getId() );
                        System.out.println("-- Source : x : " + ((IDiagramModelConnection)b).getSource().getBounds().getX());
                        System.out.println("-- Source : Y : " + ((IDiagramModelConnection)b).getSource().getBounds().getY());
                        System.out.println("-- Target : x : " + ((IDiagramModelConnection)b).getTarget().getBounds().getX());
                        System.out.println("-- Target : Y : " + ((IDiagramModelConnection)b).getTarget().getBounds().getY());
                    }
                    childrenList = dia.getChildren();
                    for (Object b : childrenList) {

                        System.out.println("--------- Children : id : " + ((IDiagramModelObject)b).getId() );
                        System.out.println("--------- Children : name : " + ((IDiagramModelObject)b).getName() );
                        System.out.println("--------- Children : bound : " + ((IDiagramModelObject)b).getBounds() );
                    }

//                    for (EObject b : dia.eContents()) {
//
//                        System.out.println("***************** eContents : getSimpleName " + b.getClass().get() );
//                        System.out.println("***************** eContents : getName " + b.getClass().getName() );
//                    }

                } else if (obj instanceof IDiagramModelArchimateObject) {
                    arch++;
                    System.out.println(obj.getClass() + " ---------------arch-"+arch+"--------- ");
                    IDiagramModelArchimateObject dia = (IDiagramModelArchimateObject) obj;
                    System.out.println("ArchimateDiagramModel ^^------------^^------------- ^^");
                    System.out.println("Name : " + dia.getName());
                    System.out.println("Bounds : " + dia.getBounds());
                    System.out.println("Fill Color : " + dia.getFillColor());
                    System.out.println("Font : " + dia.getFont());
                    System.out.println("FontColor : " + dia.getFontColor());
                    System.out.println("Id : " + dia.getId());
//                    System.out.println("Documentation : " + dia.getDocumentation());
                    System.out.println("eAllContents : " + dia.eAllContents());
                    System.out.println("Element Type : " + dia.getChildren().getClass().getSimpleName());
                    System.out.println("LineColor : " + dia.getLineColor());
                    System.out.println("LineWidth : " + dia.getLineWidth());
                    System.out.println("Type : " + dia.getType());
                    System.out.println("DefaultTextAlignment : " + dia.getDefaultTextAlignment());
                    System.out.println("TextAlignment : " + dia.getTextAlignment());
                    System.out.println("Source Connections : ");
                    SourceConList = dia.getSourceConnections();
                    for (Object b : SourceConList) {
                        System.out.println("-- SourceConList : id : " + ((IDiagramModelConnection)b).getId() );
                        System.out.println("-- Source : x : " + ((IDiagramModelConnection)b).getSource().getBounds().getX());
                        System.out.println("-- Source : Y : " + ((IDiagramModelConnection)b).getSource().getBounds().getY());
                        System.out.println("-- Target : x : " + ((IDiagramModelConnection)b).getTarget().getBounds().getX());
                        System.out.println("-- Target : Y : " + ((IDiagramModelConnection)b).getTarget().getBounds().getY());
                    }
                    childrenList = dia.getChildren();
                    for (Object b : childrenList) {

                        System.out.println("------------- Children : id : " + ((IDiagramModelObject)b).getId() );
                        System.out.println("---------^^   Children : name : " + ((IDiagramModelObject)b).getName() );
                    }
                    System.out.println("ArchimateDiagramModel vv------------vv------------- vv");

                }
                else if (obj instanceof IDiagramModelArchimateConnection) {
                    conn++;
                    System.out.println(obj.getClass() + " ---------------conn-"+conn+"--------- ");
                    IDiagramModelArchimateConnection dia = (IDiagramModelArchimateConnection)obj;
                    System.out.println("IDiagramModelArchimateConnection *------------------------- ");
                    System.out.println("Name : " + dia.getName());
                    System.out.println("Source : " + dia.getSource());
                    System.out.println("Target : " + dia.getTarget());
                    for(IDiagramModelBendpoint b : dia.getBendpoints()){
                        System.out.println("Bendpoints : SX : " + b.getStartX()+ " SY : " + b.getStartY()+ " EX : " + b.getEndX()+ " EY : " + b.getEndY());
                    }
                    System.out.println("TextPosition : " + dia.getTextPosition());
                    System.out.println("Font : " + dia.getFont());
                    System.out.println("FontColor : " + dia.getFontColor());
                    System.out.println("Id : " + dia.getId());
                    System.out.println("Documentation : " + dia.getDocumentation());
                    System.out.println("eAllContents : " + dia.eAllContents());
//                    System.out.println("Element Type : " + dia.getChildren().getClass().getSimpleName());
                    System.out.println("LineColor : " + dia.getLineColor());
                    System.out.println("LineWidth : " + dia.getLineWidth());
                    System.out.println("getDiagramModel : " + dia.getDiagramModel());
//                    System.out.println("DefaultTextAlignment : " + dia.getDefaultTextAlignment());
//                    System.out.println("TextAlignment : " + dia.getTextAlignment());
//                    System.out.println("Source Connections : ");
//                    SourceConList = dia.getSourceConnections();
//                    childrenList = dia.getChildren();

                }else if (obj instanceof IProperty) {
                    conn++;
                    System.out.println(obj.getClass() + " ---------------Property-"+conn+"--------- ");
                    IProperty dia = (IProperty)obj;
                    System.out.println("Property *------------------------- ");
                    System.out.println("Name : " + dia.getKey());
//                    System.out.println("getBean : " + dia.getBean());
                    System.out.println("getValue : " + dia.getValue());

                    System.out.println("dia.getClass().getSimpleName() : " + dia.getClass().getSimpleName());

                }else  {
                    System.out.println("Nooote Goes Here -----------------------------nnn ");
                    arch++;
                    System.out.println(obj.getClass() + " ---------------otherrrs-"+arch+"--------- ");

                }
            }

//            }
            System.out.println("Group Cnt : "+grp);
            System.out.println("Arch Cnt : "+arch);
            System.out.println("Conn Cnt : "+conn);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
