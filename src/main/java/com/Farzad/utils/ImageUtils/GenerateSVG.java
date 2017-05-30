package com.Farzad.utils.ImageUtils;


import POJOs.SVGSingleShape;
import com.archimatetool.model.*;
import org.eclipse.emf.ecore.EObject;

import java.io.File;
import java.util.*;

import static com.Farzad.utils.ImageUtils.ConnectionTools.getSVGline;
import static com.Farzad.utils.ImageUtils.ModelTools.loadModel;
import static com.Farzad.utils.ImageUtils.ShapeTools.getSVGShape;

/**
 * Created by VOLCANO on 4/21/2017.
 */
public class GenerateSVG {
    private static Map<String, SVGSingleShape> All_MAIN_SVG_SHAPES_AND_CONNECTORS = new TreeMap<>();
    private static Map<String, SVGSingleShape> All_GROUP_SVG_SHAPES_AND_CONNECTORS = new HashMap<>();
    private static Map<SVGSingleShape, SVGSingleShape> All_CONNECTIONS = new HashMap<>();
    private static int FIRST_X = 0;
    private static int FIRST_Y = 0;
    private static int LAST_X = 0;
    private static int LAST_Y = 0;


    public static String getModelSVGs() {
        SVGSingleShape svgSingleShape = null;
        SVGSingleShape svgChildSingleShape = null;
        getAllModelSVGs();
        StringBuilder sb = new StringBuilder();
        try {
            System.out.println("======---00000000----   " + FIRST_X + " " + FIRST_Y + " " + LAST_X + " " + LAST_Y);
//            sb.append("<svg width=\"100%\" height=\"auto\"  viewBox=\"" + (FIRST_X - 10) + " " + (FIRST_Y - 10) + " " + (Math.abs(FIRST_X) + LAST_X + 30) + " " + (Math.abs(FIRST_Y) + LAST_Y + 30) + " \">");
            sb.append("<svg width=\"100%\" height=\"100%\">");
            sb.append("<g transform=\"translate("+Math.abs(FIRST_X)+","+Math.abs(FIRST_Y)+") \"> ");
            All_GROUP_SVG_SHAPES_AND_CONNECTORS.entrySet().stream().filter(obj -> obj.getValue() != null).forEachOrdered(obj -> {
                sb.append(getSVGShape(obj.getValue()));
                sb.append("\n");
            });
            All_MAIN_SVG_SHAPES_AND_CONNECTORS.entrySet().stream().filter(obj -> obj.getValue() != null).forEachOrdered(obj -> {
                sb.append(getSVGShape(obj.getValue()));
                sb.append("\n");
            });
//            for (Map.Entry<String, SVGSingleShape> obj : All_MAIN_SVG_SHAPES_AND_CONNECTORS.entrySet()) {
////                System.out.println(obj.getValue() != null && obj.getValue().getName() != null && obj.getValue().getName().equals("Locations1") ? "Loc" : "");
//                if (obj.getValue() != null && obj.getValue().getConnections() != null) {
////                    System.out.println(obj.getValue() !=null && obj.getValue().getName()!=null&& obj.getValue().getName().equals("Locations1")?"lllLoc":"");
////                    System.out.println(obj.getValue() !=null && obj.getValue().getConnections()!=null? "--**"+obj.getValue().getConnections():"");
////                    System.out.println(obj.getValue() !=null && obj.getValue().getConnections()!=null? "--sss*** "+obj.getValue().getConnections().size():"");
//                    for (Map.Entry<String, String> con : obj.getValue().getConnections().entrySet()) {
////                    for (String con : obj.getValue().getConnections()) {
////                        System.out.println("conns : "+con.getKey()+" : "+con.getValue());
//                        String key = con.getKey().split("-").length > 1 ? con.getKey().split("-")[1] : null;
//                        if (All_MAIN_SVG_SHAPES_AND_CONNECTORS.containsKey(key)) {
////                            System.out.println("All_MAIN_SVG_SHAPES_AND_CONNECTORS.containsKey : " + con.getValue());
//                            svgSingleShape = All_MAIN_SVG_SHAPES_AND_CONNECTORS.get(key);
//                            System.out.println("## con.getKey() -- " + svgSingleShape.getName() + " -- " + obj.getValue().getName());
//                        }
//
//                        else if (All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.containsKey(key)) {
////                            System.out.println("All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.containsKey : " + con.getValue());
//                            svgSingleShape = All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.get(key);
//                            System.out.println("** con.getKey() -- " + svgSingleShape.getName() + " -- " + obj.getValue().getName());
//                        }
//                        System.out.println("con.getValue()********************" + con.getValue());
//                        if (svgSingleShape != null) {
//                            obj.getValue().setConnectionsType(con.getValue());
////                            System.out.println("svgSingleShape : "+svgSingleShape.getId()+" : "+svgSingleShape.getName());
////                            System.out.println("obj.getValue() : "+obj.getValue().getId()+" : "+obj.getValue().getName());
//                            sb.append(getSVGline(obj.getValue(), svgSingleShape));
//                        }
//                    }
//                }
//            }

//            All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.entrySet().stream().filter(obj -> obj.getValue() != null).forEachOrdered(obj -> {
//                sb.append(getSVGShape(obj.getValue()));
//                sb.append("\n");
//            });
//            for (Map.Entry<String, SVGSingleShape> obj : All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.entrySet()) {
//                if (obj.getValue() != null && obj.getValue().getConnections() != null) {
//                    for (Map.Entry<String, String> con : obj.getValue().getConnections().entrySet()) {
////                        for (String con : obj.getValue().getConnections()) {
////                        System.out.println("con.getKey()" + con.getKey());
//                        String key = con.getKey().split("-").length > 1 ? con.getKey().split("-")[1] : null;
//                        if (All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.containsKey(key)) {
//                            svgChildSingleShape = All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.get(key);
////                            System.out.println("-- con.getKey() -- " + con.getKey() + " -- " + All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.get(key).getId());
//                        } else if (All_MAIN_SVG_SHAPES_AND_CONNECTORS.containsKey(key)) {
//                            svgChildSingleShape = All_MAIN_SVG_SHAPES_AND_CONNECTORS.get(key);
////                            System.out.println("++ con.getKey() -- " + svgChildSingleShape.getName() + " -- " + obj.getValue().getName());
//                        }
//                        if (svgChildSingleShape != null) {
//                            obj.getValue().setConnectionsType(con.getValue());
//                            sb.append(getSVGline(obj.getValue(), svgChildSingleShape));
//                        }
//                    }
//                }
//            }

            for (Map.Entry<SVGSingleShape, SVGSingleShape> obj : All_CONNECTIONS.entrySet()) {
//                System.out.println("---------< Srouce ID : "+ obj.getKey().getId());
//                System.out.println("---------< Target ID : "+ obj.getValue().getId());
                sb.append(getSVGline(obj.getKey(), obj.getValue()));
            }

            sb.append(" </g>");
            sb.append("</svg>");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

//    public static int[] firstAndLastXY() {
//        int[] firstLastXY = new int[]{0, 0, 0, 0};
//        int firstX = 100000;
//        int lastX = 0;
//        int firstY = 100000;
//        int lastY = 0;
//        SVGSingleShape svgSingleShape = null;
//        SVGSingleShape svgChildSingleShape = null;
////        getAllModelSVGs();
//        try {
//            for (Map.Entry<String, SVGSingleShape> obj : All_MAIN_SVG_SHAPES_AND_CONNECTORS.entrySet()) {
//                if (obj.getValue() != null && obj.getValue().getConnections() != null) {
//                    for (Map.Entry<String, String> con : obj.getValue().getConnections().entrySet()) {
//                        if (All_MAIN_SVG_SHAPES_AND_CONNECTORS.containsKey(con.getKey())) {
//                            svgSingleShape = All_MAIN_SVG_SHAPES_AND_CONNECTORS.get(con.getKey());
//                        } else if (All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.containsKey(con.getKey())) {
//                            svgSingleShape = All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.get(con.getKey());
//                        }
//                        if (svgSingleShape != null) {
//                            System.out.println("con.getValue()********************" + con.getValue());
//                            obj.getValue().setConnectionsType(con.getValue());
//                            if (obj.getValue() != null) {
//                                if (obj.getValue().getX() < firstX) {
//                                    firstX = obj.getValue().getX();
//                                }
//                                if (obj.getValue().getX() + obj.getValue().getWidth() > lastX) {
//                                    lastX = obj.getValue().getX();
//                                }
//                                if (obj.getValue().getY() < firstY) {
//                                    firstY = obj.getValue().getY();
//                                }
//                                if (obj.getValue().getY() + obj.getValue().getHeight() > lastY) {
//                                    lastY = obj.getValue().getY();
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//
////            for (Map.Entry<String, SVGSingleShape> obj : All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.entrySet()) {
////                if (obj.getValue() != null && obj.getValue().getConnections() != null) {
////                    for (Map.Entry<String, String> con : obj.getValue().getConnections().entrySet()) {
////                            if (All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.containsKey(con.getKey())) {
////                                svgChildSingleShape = All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.get(con.getKey());
////                            }else if (All_MAIN_SVG_SHAPES_AND_CONNECTORS.containsKey(con.getKey())) {
////                                svgChildSingleShape = All_MAIN_SVG_SHAPES_AND_CONNECTORS.get(con.getKey());
////                            } if (svgChildSingleShape !=null){
////                                obj.getValue().setConnectionsType(con.getValue());
////                                sb.append(getSVGline(obj.getValue(), svgChildSingleShape));
////                            }
////                        }
////                    }
////            }
////
////            All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.entrySet().stream().filter(obj -> obj.getValue() != null).forEachOrdered(obj -> {
////                sb.append(getSVGShape(obj.getValue()));
////                sb.append("\n");
////            });
////            sb.append("</svg>");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return firstLastXY;
//    }

//    private void mapDiagramObjects(IDiagramModelObject diagramCpt, StringBuffer pageContent, int xoffset, int yoffset) {
//        boolean addObj = false;
//        String objName = "-";
//
//        if (diagramCpt instanceof IDiagramModelArchimateObject) {
//            addObj = true;
//            IDiagramModelArchimateObject modelObj = (IDiagramModelArchimateObject) diagramCpt;
//            objName = modelObj.getArchimateElement().getName();
//            // Add any child elements to this root
//            for (IDiagramModelObject childObj : modelObj.getChildren()) {
//                this.mapDiagramObjects(
//                        childObj,
//                        pageContent,
//                        xoffset + childObj.getBounds().getX(),
//                        yoffset + childObj.getBounds().getY());
//            }
//        } else if (diagramCpt instanceof IDiagramModelGroup) {
//            // Add any child elements to this root
//            IDiagramModelGroup modelGrp = (IDiagramModelGroup) diagramCpt;
//            for (IDiagramModelObject childObj : modelGrp.getChildren()) {
//                this.mapDiagramObjects(
//                        childObj,
//                        pageContent,
//                        xoffset + childObj.getBounds().getX(),
//                        yoffset + childObj.getBounds().getY());
//            }
//        } else if (diagramCpt instanceof IDiagramModelReference) {
//            addObj = true;
//            IDiagramModelReference modelRef = (IDiagramModelReference) diagramCpt;
//            objName = modelRef.getName();
//        }
//
//        if (addObj) {
//            pageContent.append(
//                    getAreaString(
//                            objName, xoffset, yoffset,
//                            xoffset + diagramCpt.getBounds().getWidth(),
//                            yoffset + diagramCpt.getBounds().getHeight()));
//        }
//    }
//    private void addModelSVGsInMAP(List SourceConList) {
//        int makeUniqueID = 0;
//        Map<String, String> sourceAndTarget = new TreeMap<String, String>();
//if(true) {
//    IDiagramModelArchimateObject modelObj = (IDiagramModelArchimateObject) diagramCpt;
//
//}
//        SVGSingleShape svgSingleShape = null;
//        for (Object iDiModelConnObj : SourceConList) {
//            makeUniqueID++;
//            if (((IDiagramModelConnection) iDiModelConnObj).getTarget() != null) {
//                sourceAndTarget.put(makeUniqueID + "-" + ((IDiagramModelConnection) iDiModelConnObj).getTarget().getId(), ((IDiagramModelConnection) iDiModelConnObj).getName());
////                            sourceAndTarget.add(((IDiagramModelConnection) iDiModelConnObj).getTarget().getId());
//
//                System.out.println("-- " + modelObj.getName() + " --4---4---" + ((IDiagramModelConnection) iDiModelConnObj).getTarget().getName() + "--  ---" + ((IDiagramModelConnection) iDiModelConnObj).getTarget().getId() + "--  ---" + ((IDiagramModelConnection) iDiModelConnObj).getName());
//            }
//
//
////                        for (Map.Entry<String, String> a : sourceAndTarget.entrySet()) {
////                            System.out.println(" ---------*>>  relations: " + a.getValue());
////                        }
//        }
//
//        try {
//            if (modelObj.getBounds() != null) {
//                svgSingleShape = new SVGSingleShape();
//                svgSingleShape.setId(modelObj.getId());
//                svgSingleShape.setX(modelObj.getBounds().getX());
//                svgSingleShape.setY(modelObj.getBounds().getY());
//                svgSingleShape.setWidth(modelObj.getBounds().getWidth());
//                svgSingleShape.setHeight(modelObj.getBounds().getHeight());
//                svgSingleShape.setName(modelObj.getName());
//                svgSingleShape.setStrokeColor(modelObj.getLineColor());
//                svgSingleShape.setStrokeWidth(modelObj.getLineWidth());
//                svgSingleShape.setFillColor(modelObj.getFillColor());
//                svgSingleShape.setFont(modelObj.getFont());
//                svgSingleShape.setFontColor(modelObj.getFontColor());
//                svgSingleShape.setConnections(sourceAndTarget);
//                svgSingleShape.setHasChild(false);
//                svgSingleShape.setElementType(modelObj.getArchimateElement() != null && modelObj.getArchimateElement().getClass() != null ?
//                        modelObj.getArchimateElement().getClass().getSimpleName() : "");
////                                System.out.println(svgSingleShape.toString());
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        All_MAIN_SVG_SHAPES_AND_CONNECTORS.put(modelObj.getId(), svgSingleShape);
//    }

//    private static void getSingleModelSVGs(IDiagramModelObject diagramCpt, int x, int y,boolean child) {
//        boolean addObj = false;
//        String objName = "-";
//        Map<String, String> sourceAndTarget = new TreeMap<String, String>();
//        List SourceConList = null;
//        SVGSingleShape svgSingleShape = null;
//        SVGSingleShape svgChildSingleShape = null;
//        int makeUniqueID = 0;
//        int makeUniqueIDChild = 0;
//        if (diagramCpt instanceof IDiagramModelArchimateObject) {
//            IDiagramModelArchimateObject modelObj = (IDiagramModelArchimateObject) diagramCpt;
//            SourceConList = modelObj.getSourceConnections();
//            if(child){
//                modelObj.getBounds().setX(x);
//                modelObj.getBounds().setY(y);
//            }
//            for (Object iDiModelConnObj : SourceConList) {
//                makeUniqueID++;
//                if (((IDiagramModelConnection) iDiModelConnObj).getTarget() != null) {
//                    sourceAndTarget.put(makeUniqueID + "-" + ((IDiagramModelConnection) iDiModelConnObj).getTarget().getId(), ((IDiagramModelConnection) iDiModelConnObj).getName());
////                            sourceAndTarget.add(((IDiagramModelConnection) iDiModelConnObj).getTarget().getId());
//
//                    System.out.println("-- " + modelObj.getName() + " --4---4---" + ((IDiagramModelConnection) iDiModelConnObj).getTarget().getName() + "--  ---" + ((IDiagramModelConnection) iDiModelConnObj).getTarget().getId() + "--  ---" + ((IDiagramModelConnection) iDiModelConnObj).getName());
//                }
//
//
////                        for (Map.Entry<String, String> a : sourceAndTarget.entrySet()) {
////                            System.out.println(" ---------*>>  relations: " + a.getValue());
////                        }
//            }
//
//            try {
//                if (modelObj.getBounds() != null) {
//                    svgSingleShape = new SVGSingleShape();
//                    svgSingleShape.setId(modelObj.getId());
//                    svgSingleShape.setX(modelObj.getBounds().getX());
//                    svgSingleShape.setY(modelObj.getBounds().getY());
//                    svgSingleShape.setWidth(modelObj.getBounds().getWidth());
//                    svgSingleShape.setHeight(modelObj.getBounds().getHeight());
//                    svgSingleShape.setName(modelObj.getName());
//                    svgSingleShape.setStrokeColor(modelObj.getLineColor());
//                    svgSingleShape.setStrokeWidth(modelObj.getLineWidth());
//                    svgSingleShape.setFillColor(modelObj.getFillColor());
//                    svgSingleShape.setFont(modelObj.getFont());
//                    svgSingleShape.setFontColor(modelObj.getFontColor());
//                    svgSingleShape.setConnections(sourceAndTarget);
//                    svgSingleShape.setHasChild(false);
//                    svgSingleShape.setElementType(modelObj.getArchimateElement() != null && modelObj.getArchimateElement().getClass() != null ?
//                            modelObj.getArchimateElement().getClass().getSimpleName() : "");
////                                System.out.println(svgSingleShape.toString());
//
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            All_MAIN_SVG_SHAPES_AND_CONNECTORS.put(modelObj.getId(), svgSingleShape);
//            for (IDiagramModelObject childObj : modelObj.getChildren()) {
//                 getSingleModelSVGs(childObj, modelObj.getBounds().getX() + childObj.getBounds().getX(), modelObj.getBounds().getY() + childObj.getBounds().getY(),true);
//            }
//        } else if (diagramCpt instanceof IDiagramModelGroup) {
//            // Add any child elements to this root
//            IDiagramModelGroup modelGrp = (IDiagramModelGroup) diagramCpt;
//
//            SourceConList = modelGrp.getSourceConnections();
//            for (Object iDiModelConnObj : SourceConList) {
//                makeUniqueID++;
//                if (((IDiagramModelConnection) iDiModelConnObj).getTarget() != null) {
//                    sourceAndTarget.put(makeUniqueID + "-" + ((IDiagramModelConnection) iDiModelConnObj).getTarget().getId(), ((IDiagramModelConnection) iDiModelConnObj).getName());
////                            sourceAndTarget.add(((IDiagramModelConnection) iDiModelConnObj).getTarget().getId());
//
//                    System.out.println("-- " + modelGrp.getName() + " --4---4---" + ((IDiagramModelConnection) iDiModelConnObj).getTarget().getName() + "--  ---" + ((IDiagramModelConnection) iDiModelConnObj).getTarget().getId() + "--  ---" + ((IDiagramModelConnection) iDiModelConnObj).getName());
//                }
//
//
////                        for (Map.Entry<String, String> a : sourceAndTarget.entrySet()) {
////                            System.out.println(" ---------*>>  relations: " + a.getValue());
////                        }
//            }
//
//            try {
//                if (modelGrp.getBounds() != null) {
//                    svgSingleShape = new SVGSingleShape();
//                    svgSingleShape.setId(modelGrp.getId());
//                    svgSingleShape.setX(modelGrp.getBounds().getX());
//                    svgSingleShape.setY(modelGrp.getBounds().getY());
//                    svgSingleShape.setWidth(modelGrp.getBounds().getWidth());
//                    svgSingleShape.setHeight(modelGrp.getBounds().getHeight());
//                    svgSingleShape.setName(modelGrp.getName());
//                    svgSingleShape.setStrokeColor(modelGrp.getLineColor());
//                    svgSingleShape.setStrokeWidth(modelGrp.getLineWidth());
//                    svgSingleShape.setFillColor(modelGrp.getFillColor());
//                    svgSingleShape.setFont(modelGrp.getFont());
//                    svgSingleShape.setFontColor(modelGrp.getFontColor());
//                    svgSingleShape.setConnections(sourceAndTarget);
//                    svgSingleShape.setHasChild(false);
////                    svgSingleShape.setElementType(modelGrp.getArchimateElement() != null && modelGrp.getArchimateElement().getClass() != null ?
////                            modelGrp.getArchimateElement().getClass().getSimpleName() : "");
//////                                System.out.println(svgSingleShape.toString());
//
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            All_MAIN_SVG_SHAPES_AND_CONNECTORS.put(modelGrp.getId(), svgSingleShape);
//            for (IDiagramModelObject childObj : modelGrp.getChildren()) {
//                getSingleModelSVGs(childObj, modelGrp.getBounds().getX() + childObj.getBounds().getX(), modelGrp.getBounds().getY() + childObj.getBounds().getY(),true);
//            }
//
//
//        }
//
//    }

    private static void getSingleModels(EObject diagramCpt) {
        boolean addObj = false;
        String objName = "-";
        Map<String, String> sourceAndTarget = new TreeMap<String, String>();
        List SourceConList = null;
        SVGSingleShape svgSingleShape = null;
        SVGSingleShape svgChildSingleShape = null;
        int makeUniqueID = 0;
        int makeUniqueIDChild = 0;
        if (diagramCpt instanceof IDiagramModelGroup) {
            // Add any child elements to this root
            IDiagramModelGroup modelGrp = (IDiagramModelGroup) diagramCpt;
            System.out.println("-4---4- " + modelGrp.getName());
            if (modelGrp.getBounds() !=null ) {
                System.out.println(" X : " +  modelGrp.getBounds().getX()  + " | Y " +  modelGrp.getBounds().getY() + " Width : " +  modelGrp.getBounds().getWidth()  + " | Height " +  modelGrp.getBounds().getHeight() + "--  ---");
            }
//            SourceConList = modelGrp.getSourceConnections();
//            for (Object iDiModelConnObj : SourceConList) {
//                makeUniqueID++;
//                if (((IDiagramModelConnection) iDiModelConnObj).getTarget() != null) {
//                    sourceAndTarget.put(makeUniqueID + "-" + ((IDiagramModelConnection) iDiModelConnObj).getTarget().getId(), ((IDiagramModelConnection) iDiModelConnObj).getName());
////                            sourceAndTarget.add(((IDiagramModelConnection) iDiModelConnObj).getTarget().getId());
//
//                    System.out.println("-- " + modelGrp.getName() + " --4---4---" + ((IDiagramModelConnection) iDiModelConnObj).getTarget().getName() + "--  ---" + ((IDiagramModelConnection) iDiModelConnObj).getTarget().getId() + "--  ---" + ((IDiagramModelConnection) iDiModelConnObj).getName());
//                }
//
//
////                        for (Map.Entry<String, String> a : sourceAndTarget.entrySet()) {
////                            System.out.println(" ---------*>>  relations: " + a.getValue());
////                        }
//            }
            System.out.println("======---00000000----   " + FIRST_X + " " + FIRST_Y + " " + LAST_X + " " + LAST_Y);
            System.out.println("======---33333333----   " + modelGrp.getBounds().getX() + " " + modelGrp.getBounds().getY() + " " + (modelGrp.getBounds().getX() + modelGrp.getBounds().getWidth()) + " " + (modelGrp.getBounds().getY() + modelGrp.getBounds().getHeight()));
            if (FIRST_X > modelGrp.getBounds().getX())
                FIRST_X = modelGrp.getBounds().getX();
            if (FIRST_Y > modelGrp.getBounds().getY())
                FIRST_Y = modelGrp.getBounds().getY();
            if (LAST_X < modelGrp.getBounds().getX() + modelGrp.getBounds().getWidth())
                LAST_X = modelGrp.getBounds().getX() + modelGrp.getBounds().getWidth();
            if (LAST_Y < modelGrp.getBounds().getY() + modelGrp.getBounds().getHeight())
                LAST_Y = modelGrp.getBounds().getY() + modelGrp.getBounds().getHeight();
            System.out.println("======---444444444----   " + FIRST_X + " " + FIRST_Y + " " + LAST_X + " " + LAST_Y);
            EObject parentObject = modelGrp.eContainer();
            int finalX = modelGrp.getBounds().getX(), finalY = modelGrp.getBounds().getY();
            if (parentObject instanceof IDiagramModelArchimateObject) {
                if (((IDiagramModelArchimateObject) parentObject).getBounds() != null) {
                    finalX = ((IDiagramModelArchimateObject) parentObject).getBounds().getX() + modelGrp.getBounds().getX();
                    finalY = ((IDiagramModelArchimateObject) parentObject).getBounds().getY() + modelGrp.getBounds().getY();
                }
            } else if (parentObject instanceof IDiagramModelGroup) {
                if (((IDiagramModelGroup) parentObject).getBounds() != null) {
                    finalX = ((IDiagramModelGroup) parentObject).getBounds().getX() + modelGrp.getBounds().getX();
                    finalY = ((IDiagramModelGroup) parentObject).getBounds().getY() + modelGrp.getBounds().getY();
                }
            }

//           System.out.println("@@@@@@@@@@@@@@@@@@@ class name    : " + modelGrp.getClass().getSimpleName());
            try {
                if (modelGrp.getBounds() != null) {
                    svgSingleShape = new SVGSingleShape();
                    svgSingleShape.setId(modelGrp.getId());
                    svgSingleShape.setX(finalX);
                    svgSingleShape.setY(finalY);
                    svgSingleShape.setWidth(modelGrp.getBounds().getWidth());
                    svgSingleShape.setHeight(modelGrp.getBounds().getHeight());
                    svgSingleShape.setName(modelGrp.getName());
                    svgSingleShape.setStrokeColor(modelGrp.getLineColor());
                    svgSingleShape.setStrokeWidth(modelGrp.getLineWidth());
                    svgSingleShape.setFillColor(modelGrp.getFillColor());
                    svgSingleShape.setFont(modelGrp.getFont());
                    svgSingleShape.setFontColor(modelGrp.getFontColor());
                    svgSingleShape.setElementType(modelGrp.getClass().getSimpleName());
//                    svgSingleShape.setConnections(sourceAndTarget);
                    if (modelGrp.getChildren() != null && modelGrp.getChildren().size() > 0) {
                        svgSingleShape.setHasChild(true);
                    } else {
                        svgSingleShape.setHasChild(false);
                    }
//                    svgSingleShape.setElementType(modelGrp.getArchimateElement() != null && modelGrp.getArchimateElement().getClass() != null ?
//                            modelGrp.getArchimateElement().getClass().getSimpleName() : "");
////                                System.out.println(svgSingleShape.toString());

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            All_GROUP_SVG_SHAPES_AND_CONNECTORS.put(modelGrp.getId(), svgSingleShape);


        } else if (diagramCpt instanceof IDiagramModelArchimateObject) {
            IDiagramModelArchimateObject modelObj = (IDiagramModelArchimateObject) diagramCpt;
            System.out.println("-1---1- " + modelObj.getName());
            if (modelObj.getBounds() !=null ) {
                System.out.println(" X : " +  modelObj.getBounds().getX()  + " | Y " +  modelObj.getBounds().getY() + " Width : " +  modelObj.getBounds().getWidth()  + " | Height " +  modelObj.getBounds().getHeight() + "--  ---");
            }
//            SourceConList = modelObj.getSourceConnections();
//            for (Object iDiModelConnObj : SourceConList) {
//                makeUniqueID++;
//                if (((IDiagramModelConnection) iDiModelConnObj).getTarget() != null) {
//                    sourceAndTarget.put(makeUniqueID + "-" + ((IDiagramModelConnection) iDiModelConnObj).getTarget().getId(), ((IDiagramModelConnection) iDiModelConnObj).getName());
////                            sourceAndTarget.add(((IDiagramModelConnection) iDiModelConnObj).getTarget().getId());
//
//                    System.out.println("-- " + modelObj.getName() + " --4---4---" + ((IDiagramModelConnection) iDiModelConnObj).getTarget().getName() + "--  ---" + ((IDiagramModelConnection) iDiModelConnObj).getTarget().getId() + "--  ---" + ((IDiagramModelConnection) iDiModelConnObj).getName());
//                }
//
//
////                        for (Map.Entry<String, String> a : sourceAndTarget.entrySet()) {
////                            System.out.println(" ---------*>>  relations: " + a.getValue());
////                        }
//            }

            System.out.println("======---00000000----   " + FIRST_X + " " + FIRST_Y + " " + LAST_X + " " + LAST_Y);
            System.out.println("======---11111111----   " + modelObj.getBounds().getX() + " " + modelObj.getBounds().getY() + " " + (modelObj.getBounds().getX() + modelObj.getBounds().getWidth()) + " " + (modelObj.getBounds().getY() + modelObj.getBounds().getHeight()));

            if (FIRST_X > modelObj.getBounds().getX())
                FIRST_X = modelObj.getBounds().getX();
            if (FIRST_Y > modelObj.getBounds().getY())
                FIRST_Y = modelObj.getBounds().getY();
            if (LAST_X < modelObj.getBounds().getX() + modelObj.getBounds().getWidth())
                LAST_X = modelObj.getBounds().getX() + modelObj.getBounds().getWidth();
            if (LAST_Y < modelObj.getBounds().getY() + modelObj.getBounds().getHeight())
                LAST_Y = modelObj.getBounds().getY() + modelObj.getBounds().getHeight();
            System.out.println("======---222222222----   " + FIRST_X + " " + FIRST_Y + " " + LAST_X + " " + LAST_Y);
            try {
                EObject parentObject = modelObj.eContainer();
                System.out.println("===================== class name    : " + parentObject.getClass().getSimpleName());
                int finalX = modelObj.getBounds().getX(), finalY = modelObj.getBounds().getY();
                if (parentObject instanceof IDiagramModelArchimateObject) {
                    if (((IDiagramModelArchimateObject) parentObject).getBounds() != null) {
                        finalX = ((IDiagramModelArchimateObject) parentObject).getBounds().getX() + modelObj.getBounds().getX();
                        finalY = ((IDiagramModelArchimateObject) parentObject).getBounds().getY() + modelObj.getBounds().getY();
                        System.out.println("===================== Parent X : " + ((IDiagramModelArchimateObject) parentObject).getBounds().getX());
                        System.out.println("===================== Parent Y : " + ((IDiagramModelArchimateObject) parentObject).getBounds().getY());
                    }
                    System.out.println("===================== Name : " + ((IDiagramModelArchimateObject) parentObject).getName());
                } else if (parentObject instanceof IDiagramModelGroup) {
                    if (((IDiagramModelGroup) parentObject).getBounds() != null) {
                        finalX = ((IDiagramModelGroup) parentObject).getBounds().getX() + modelObj.getBounds().getX();
                        finalY = ((IDiagramModelGroup) parentObject).getBounds().getY() + modelObj.getBounds().getY();
                    }
                    System.out.println("===================== Name : " + ((IDiagramModelGroup) parentObject).getName());
                }
                System.out.println("===================== Total X  : " + finalX + " Child X " + modelObj.getBounds().getX());
                System.out.println("===================== Total Y  : " + finalY + " Child Y " + modelObj.getBounds().getY());

                if (modelObj.getBounds() != null) {
                    svgSingleShape = new SVGSingleShape();
                    svgSingleShape.setId(modelObj.getId());
                    svgSingleShape.setX(finalX);
                    svgSingleShape.setY(finalY);
                    svgSingleShape.setWidth(modelObj.getBounds().getWidth());
                    svgSingleShape.setHeight(modelObj.getBounds().getHeight());
                    svgSingleShape.setName(modelObj.getName());
                    svgSingleShape.setStrokeColor(modelObj.getLineColor());
                    svgSingleShape.setStrokeWidth(modelObj.getLineWidth());
                    svgSingleShape.setFillColor(modelObj.getFillColor());
                    svgSingleShape.setFont(modelObj.getFont());
                    svgSingleShape.setFontColor(modelObj.getFontColor());
//                    svgSingleShape.setConnections(sourceAndTarget);
                    if (modelObj.getChildren() != null && modelObj.getChildren().size() > 0) {
                        svgSingleShape.setHasChild(true);
                    } else {
                        svgSingleShape.setHasChild(false);
                    }
                    svgSingleShape.setElementType(modelObj.getArchimateElement() != null && modelObj.getArchimateElement().getClass() != null ?
                            modelObj.getArchimateElement().getClass().getSimpleName() : "");
//                                System.out.println(svgSingleShape.toString());

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            All_MAIN_SVG_SHAPES_AND_CONNECTORS.put(modelObj.getId(), svgSingleShape);

        } else if (diagramCpt instanceof IDiagramModelArchimateConnection) {
            List<BendPoints> bindPointsList = null;
            // Add any child elements to this root
            IDiagramModelArchimateConnection modelConn = (IDiagramModelArchimateConnection) diagramCpt;
            int finalSourceX = modelConn.getSource().getBounds().getX();
            int finalSourceY = modelConn.getSource().getBounds().getY();
            int finalTargetX = modelConn.getTarget().getBounds().getX();
            int finalTargetY = modelConn.getTarget().getBounds().getY();
            EObject parentObject = modelConn.getSource().eContainer();
            if (parentObject instanceof IDiagramModelArchimateObject) {
                if (((IDiagramModelArchimateObject) parentObject).getBounds() != null) {
                    finalSourceX = ((IDiagramModelArchimateObject) parentObject).getBounds().getX() + modelConn.getSource().getBounds().getX();
                    finalSourceY = ((IDiagramModelArchimateObject) parentObject).getBounds().getY() + modelConn.getSource().getBounds().getY();
                }
            } else if (parentObject instanceof IDiagramModelGroup) {
                if (((IDiagramModelGroup) parentObject).getBounds() != null) {
                    finalSourceX = ((IDiagramModelGroup) parentObject).getBounds().getX() + modelConn.getSource().getBounds().getX();
                    finalSourceY = ((IDiagramModelGroup) parentObject).getBounds().getY() + modelConn.getSource().getBounds().getY();
                }
            }
            parentObject = modelConn.getTarget().eContainer();
            if (parentObject instanceof IDiagramModelArchimateObject) {
                if (((IDiagramModelArchimateObject) parentObject).getBounds() != null) {
                    finalTargetX = ((IDiagramModelArchimateObject) parentObject).getBounds().getX() + modelConn.getTarget().getBounds().getX();
                    finalTargetY = ((IDiagramModelArchimateObject) parentObject).getBounds().getY() + modelConn.getTarget().getBounds().getY();
                } else if (parentObject instanceof IDiagramModelGroup) {
                    finalTargetX = ((IDiagramModelGroup) parentObject).getBounds().getX() + modelConn.getTarget().getBounds().getX();
                    finalTargetY = ((IDiagramModelGroup) parentObject).getBounds().getY() + modelConn.getTarget().getBounds().getY();
                }
            }
            try {
                if (modelConn.getSource() != null && modelConn.getTarget() != null) {

                    System.out.println("Model Conn - Source Name & ID : ----------- > " + modelConn.getSource().getName()+" | " + modelConn.getSource().getId());
                    System.out.println("Model Conn - Target Name & ID : ----------- > " + modelConn.getTarget().getName()+" | " + modelConn.getTarget().getId());

                    SVGSingleShape svgSourceShape = new SVGSingleShape();
                    SVGSingleShape svgTargetShape = new SVGSingleShape();
                    svgSourceShape.setId(modelConn.getSource().getId());
                    svgSourceShape.setX(finalSourceX);
                    svgSourceShape.setY(finalSourceY);
                    svgSourceShape.setWidth(modelConn.getSource().getBounds().getWidth());
                    svgSourceShape.setHeight(modelConn.getSource().getBounds().getHeight());
                    svgSourceShape.setName(modelConn.getSource().getName());
                    svgSourceShape.setStrokeColor(modelConn.getSource().getLineColor());
                    svgSourceShape.setStrokeWidth(modelConn.getSource().getLineWidth());
                    svgSourceShape.setFillColor(modelConn.getSource().getFillColor());
                    svgSourceShape.setFont(modelConn.getSource().getFont());
                    svgSourceShape.setFontColor(modelConn.getSource().getFontColor());
                    svgSourceShape.setConnectionsName(modelConn.getRelationship() != null ? modelConn.getRelationship().getName() : "");
                    svgSourceShape.setConnectionsType(modelConn.getRelationship() != null ? modelConn.getRelationship().getClass().getSimpleName() : "");
                    svgSourceShape.setConnections(sourceAndTarget);


                    bindPointsList = new ArrayList<>();
                    System.out.println("Model Conn - Connection Coord : ----------- > Source X " + modelConn.getSource().getBounds().getX()
                            +" | Source Y " + modelConn.getSource().getBounds().getY()
                    );
                    for (IDiagramModelBendpoint e : modelConn.getBendpoints()) {
                        System.out.println(" | Bend Points e.getStartX() " + e.getStartX() + " | StartY() "+e.getStartY()+ " | getEndX() "+e.getEndX()+ " | getEndY() "+e.getEndY());
                        BendPoints bendPoints = new BendPoints();
                        bendPoints.setStartX(e.getStartX());
                        bendPoints.setStartY(e.getStartY());
//                        bendPoints.setStartX(e.getStartX()+ modelConn.getSource().getBounds().getX());
//                        bendPoints.setStartY(e.getStartY()+ modelConn.getSource().getBounds().getY());
                        bendPoints.setEndX(e.getEndX());
                        bendPoints.setEndY(e.getEndY());
                        bindPointsList.add(bendPoints);
                    }
                    svgSourceShape.setConnectionBendPointsList(bindPointsList);
                    System.out.println("Model Conn - Connection Coord : ----------- > Target X " + modelConn.getTarget().getBounds().getX()
                            +" | Target Y " + modelConn.getTarget().getBounds().getY()
                    );

                    System.out.println("Model Conn - ConnectionsType : ----------- > " + svgSourceShape.getConnectionsType());
                    System.out.println("Model Conn -   Name : ----------- > " + modelConn.getName());
                    System.out.println("Model Conn -   Name : ----------- > " + modelConn.getName());
                    System.out.println("Model Conn - getClass getSimpleName : ----------- > " + modelConn.getClass().getSimpleName());
                    System.out.println("Model Conn - getRelationship getName : ----------- > " + modelConn.getRelationship().getName());
                    System.out.println("Model Conn - getRelationship getClass getName : ----------- > " + modelConn.getRelationship().getClass().getName());
                    System.out.println("Model Conn - getRelationship getClass getSimle Name : ----------- > " + modelConn.getRelationship().getClass().getSimpleName());
                    System.out.println("Model Conn - Target getName : ----------- > " + modelConn.getTarget().getName());
//                    System.out.println("Model Conn - Target getName : ----------- > " + modelConn.getTarget().getName());
//                    System.out.println("Model Conn - Source getName : ----------- > " + modelConn.getSource().getName());


                    svgTargetShape.setId(modelConn.getTarget().getId());
                    svgTargetShape.setX(finalTargetX);
                    svgTargetShape.setY(finalTargetY);
                    svgTargetShape.setWidth(modelConn.getTarget().getBounds().getWidth());
                    svgTargetShape.setHeight(modelConn.getTarget().getBounds().getHeight());
                    svgTargetShape.setName(modelConn.getTarget().getName());
                    svgTargetShape.setStrokeColor(modelConn.getTarget().getLineColor());
                    svgTargetShape.setStrokeWidth(modelConn.getTarget().getLineWidth());
                    svgTargetShape.setFillColor(modelConn.getTarget().getFillColor());
                    svgTargetShape.setFont(modelConn.getTarget().getFont());
                    svgTargetShape.setFontColor(modelConn.getTarget().getFontColor());
                    svgTargetShape.setConnections(sourceAndTarget);

                    All_CONNECTIONS.put(svgSourceShape, svgTargetShape);
//                    svgSingleShape.setHasChild(false);
//                    svgSingleShape.setElementType(modelConn.getArchimateElement() != null && modelConn.getArchimateElement().getClass() != null ?
//                            modelConn.getArchimateElement().getClass().getSimpleName() : "");
////                                System.out.println(svgSingleShape.toString());

                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }


    private static void getAllModelSVGs() {
        try {
//            File modelFile = new File("D:\\FAR_Documents\\__Startamap\\Archisurance.archimate");
            File modelFile = new File("D:\\FAR_Documents\\__Startamap\\eira_v1_1_0_archimate.archimate");
//            File modelFile = new File("D:\\FAR_Documents\\__Startamap\\Original2.archimate");
            IArchimateModel model = loadModel(modelFile);
            List<IDiagramModel> iDModels = model.getDiagramModels();
            IDiagramModel diagramModel = iDModels.get(0);
//            for (EObject obj : diagramModel.eContents()) {
//
//                getSingleModelSVGs((IDiagramModelObject) obj,0,0,false);
//            }

            Iterator<EObject> contents = diagramModel.eAllContents();
            while (contents.hasNext()) {
                EObject obj = contents.next();
                getSingleModels(obj);
                System.out.println(obj);
            }


//                sourceAndTarget = new TreeMap<String, String>();
////                sourceAndTarget = new ArrayList<String>();
//
//
//                if (obj instanceof IDiagramModelArchimateObject) {
//                    IDiagramModelArchimateObject dia = (IDiagramModelArchimateObject) obj;
//                    SourceConList = dia.getSourceConnections();
//
//
//                    for (Object iDiModelConnObj : SourceConList) {
//                        makeUniqueID++;
//                        if (((IDiagramModelConnection) iDiModelConnObj).getTarget() != null) {
//                            sourceAndTarget.put(makeUniqueID + "-" + ((IDiagramModelConnection) iDiModelConnObj).getTarget().getId(), ((IDiagramModelConnection) iDiModelConnObj).getName());
////                            sourceAndTarget.add(((IDiagramModelConnection) iDiModelConnObj).getTarget().getId());
//
//                            System.out.println("-- " + dia.getName() + " --4---4---" + ((IDiagramModelConnection) iDiModelConnObj).getTarget().getName() + "--  ---" + ((IDiagramModelConnection) iDiModelConnObj).getTarget().getId() + "--  ---" + ((IDiagramModelConnection) iDiModelConnObj).getName());
//                        }
//
//
////                        for (Map.Entry<String, String> a : sourceAndTarget.entrySet()) {
////                            System.out.println(" ---------*>>  relations: " + a.getValue());
////                        }
//                    }
//
//                    try {
//                        if (dia.getBounds() != null) {
//                            svgSingleShape = new SVGSingleShape();
//                            svgSingleShape.setId(dia.getId());
//                            svgSingleShape.setX(dia.getBounds().getX());
//                            svgSingleShape.setY(dia.getBounds().getY());
//                            svgSingleShape.setWidth(dia.getBounds().getWidth());
//                            svgSingleShape.setHeight(dia.getBounds().getHeight());
//                            svgSingleShape.setName(dia.getName());
//                            svgSingleShape.setStrokeColor(dia.getLineColor());
//                            svgSingleShape.setStrokeWidth(dia.getLineWidth());
//                            svgSingleShape.setFillColor(dia.getFillColor());
//                            svgSingleShape.setFont(dia.getFont());
//                            svgSingleShape.setFontColor(dia.getFontColor());
//                            svgSingleShape.setConnections(sourceAndTarget);
//                            svgSingleShape.setHasChild(false);
//                            svgSingleShape.setElementType(dia.getArchimateElement() != null && dia.getArchimateElement().getClass() != null ?
//                                    dia.getArchimateElement().getClass().getSimpleName() : "");
////                                System.out.println(svgSingleShape.toString());
//
//                            if (dia.getChildren() != null) {
//                                childrenList = dia.getChildren();
//                                for (Object childObj : childrenList) {
//                                    if (childObj instanceof IDiagramModelObject) {
//                                        svgSingleShape.setHasChild(true);
////                                        System.out.println(dia.getName()+ "   ------------ has child -----------------------------------");
//                                        childSourceAndTargets = new TreeMap<>();
////                                        childSourceAndTargets = new ArrayList<String>();
//                                        IDiagramModelObject childDia = (IDiagramModelObject) childObj;
//                                        childSourceConList = childDia.getSourceConnections();
//                                        for (Object iDiModelConnObj : childSourceConList) {
//                                            makeUniqueIDChild++;
//                                            if (((IDiagramModelConnection) iDiModelConnObj).getTarget() != null) {
//                                                childSourceAndTargets.put(makeUniqueIDChild + "-" + ((IDiagramModelConnection) iDiModelConnObj).getTarget().getId(), ((IDiagramModelConnection) iDiModelConnObj).getName());
//
//                                            }
//                                        }
//
//
//                                        svgChildSingleShape = new SVGSingleShape();
//                                        svgChildSingleShape.setId(childDia.getId());
//                                        svgChildSingleShape.setX(dia.getBounds().getX() + childDia.getBounds().getX());
//                                        svgChildSingleShape.setY(dia.getBounds().getY() + childDia.getBounds().getY());
//                                        svgChildSingleShape.setWidth(childDia.getBounds().getWidth());
//                                        svgChildSingleShape.setHeight(childDia.getBounds().getHeight());
//                                        svgChildSingleShape.setName(childDia.getName());
//                                        svgChildSingleShape.setStrokeColor(childDia.getLineColor());
//                                        svgChildSingleShape.setFillColor(childDia.getFillColor());
//                                        svgChildSingleShape.setFont(childDia.getFont());
//                                        svgChildSingleShape.setFontColor(childDia.getFillColor());
//                                        svgChildSingleShape.setStrokeWidth(childDia.getLineWidth());
//                                        svgChildSingleShape.setConnections(childSourceAndTargets);
//
////                                System.out.println(svgChildSingleShape.toString());
//                                        All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.put(childDia.getId(), svgChildSingleShape);
//                                    }
//                                    System.out.println("Connections ---===========> ");
//                                    if (childObj instanceof IDiagramModelArchimateObject) {
////                                        childSourceAndTargets = new ArrayList<String>();
//                                        IDiagramModelArchimateObject childDia = (IDiagramModelArchimateObject) childObj;
//                                        childSourceConList = childDia.getSourceConnections();
//                                        for (Object iDiModelConnObj : childSourceConList) {
//                                            if (((IDiagramModelConnection) iDiModelConnObj).getTarget() != null) {
//                                                System.out.println("Connections ---===========> " + ((IDiagramModelConnection) iDiModelConnObj).getTarget().getName());
//                                                childSourceAndTargets.put(((IDiagramModelConnection) iDiModelConnObj).getTarget().getId(), ((IDiagramModelConnection) iDiModelConnObj).getName());
//
//                                            }
//                                        }
//
//
//                                        svgChildSingleShape = new SVGSingleShape();
//                                        svgChildSingleShape.setId(childDia.getId());
//                                        svgChildSingleShape.setX(dia.getBounds().getX() + childDia.getBounds().getX());
//                                        svgChildSingleShape.setY(dia.getBounds().getY() + childDia.getBounds().getY());
//                                        svgChildSingleShape.setWidth(childDia.getBounds().getWidth());
//                                        svgChildSingleShape.setHeight(childDia.getBounds().getHeight());
//                                        svgChildSingleShape.setName(childDia.getName());
//                                        svgChildSingleShape.setStrokeColor(childDia.getLineColor());
//                                        svgChildSingleShape.setFillColor(childDia.getFillColor());
//                                        svgChildSingleShape.setFont(childDia.getFont());
//                                        svgChildSingleShape.setFontColor(childDia.getFillColor());
//                                        svgChildSingleShape.setStrokeWidth(childDia.getLineWidth());
//                                        svgChildSingleShape.setElementType(childDia.getArchimateElement().getClass().getSimpleName());
//                                        svgChildSingleShape.setConnections(childSourceAndTargets);
//
//                                        System.out.println(childDia.toString());
//                                        System.out.println(svgChildSingleShape.toString());
//                                        All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.put(childDia.getId(), svgChildSingleShape);
//                                    }
//                                }
//
//                            }
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("dia.getId " + dia.getId() + "dia.getName " + dia.getName());
//                    if (svgSingleShape != null)
//                        for (Map.Entry<String, String> a : svgSingleShape.getConnections().entrySet()) {
//                            System.out.println("^^^^^^^^^^^^^^ svgSingleShape.getCon.getname " + a.getValue());
//                        }
//                    All_MAIN_SVG_SHAPES_AND_CONNECTORS.put(dia.getId(), svgSingleShape);
//
//                } else if (obj instanceof IDiagramModelGroup) {
//                    IDiagramModelGroup dia = (IDiagramModelGroup) obj;
//                    SourceConList = dia.getSourceConnections();
//
//
//                    for (Object iDiModelConnObj : SourceConList) {
//                        makeUniqueID++;
//                        if (((IDiagramModelConnection) iDiModelConnObj).getTarget() != null) {
//                            sourceAndTarget.put(makeUniqueID + "-" + ((IDiagramModelConnection) iDiModelConnObj).getTarget().getId(), ((IDiagramModelConnection) iDiModelConnObj).getName());
////                            sourceAndTarget.add(((IDiagramModelConnection) iDiModelConnObj).getTarget().getId());
//
//                            System.out.println("-- " + dia.getName() + " --4---4---" + ((IDiagramModelConnection) iDiModelConnObj).getTarget().getName() + "--  ---" + ((IDiagramModelConnection) iDiModelConnObj).getTarget().getId() + "--  ---" + ((IDiagramModelConnection) iDiModelConnObj).getName());
//                        }
//
//
////                        for (Map.Entry<String, String> a : sourceAndTarget.entrySet()) {
////                            System.out.println(" ---------*>>  relations: " + a.getValue());
////                        }
//                    }
//
//                    try {
//                        if (dia.getBounds() != null) {
//                            svgSingleShape = new SVGSingleShape();
//                            svgSingleShape.setId(dia.getId());
//                            svgSingleShape.setX(dia.getBounds().getX());
//                            svgSingleShape.setY(dia.getBounds().getY());
//                            svgSingleShape.setWidth(dia.getBounds().getWidth());
//                            svgSingleShape.setHeight(dia.getBounds().getHeight());
//                            svgSingleShape.setName(dia.getName());
//                            svgSingleShape.setStrokeColor(dia.getLineColor());
//                            svgSingleShape.setStrokeWidth(dia.getLineWidth());
//                            svgSingleShape.setFillColor(dia.getFillColor());
//                            svgSingleShape.setFont(dia.getFont());
//                            svgSingleShape.setFontColor(dia.getFontColor());
//                            svgSingleShape.setConnections(sourceAndTarget);
//                            svgSingleShape.setHasChild(false);
////                            svgSingleShape.setElementType(dia.getArchimateElement() != null && dia.getArchimateElement().getClass() != null ?
////                                    dia.getArchimateElement().getClass().getSimpleName() : "");
////                                System.out.println(svgSingleShape.toString());
//
//                            if (dia.getChildren() != null) {
//                                childrenList = dia.getChildren();
//                                for (Object childObj : childrenList) {
//                                    if (childObj instanceof IDiagramModelObject) {
//                                        svgSingleShape.setHasChild(true);
////                                        System.out.println(dia.getName()+ "   ------------ has child -----------------------------------");
//                                        childSourceAndTargets = new TreeMap<>();
////                                        childSourceAndTargets = new ArrayList<String>();
//                                        IDiagramModelObject childDia = (IDiagramModelObject) childObj;
//                                        childSourceConList = childDia.getSourceConnections();
//                                        for (Object iDiModelConnObj : childSourceConList) {
//                                            makeUniqueIDChild++;
//                                            if (((IDiagramModelConnection) iDiModelConnObj).getTarget() != null) {
//                                                childSourceAndTargets.put(makeUniqueIDChild + "-" + ((IDiagramModelConnection) iDiModelConnObj).getTarget().getId(), ((IDiagramModelConnection) iDiModelConnObj).getName());
//
//                                            }
//                                        }
//
//
//                                        svgChildSingleShape = new SVGSingleShape();
//                                        svgChildSingleShape.setId(childDia.getId());
//                                        svgChildSingleShape.setX(dia.getBounds().getX() + childDia.getBounds().getX());
//                                        svgChildSingleShape.setY(dia.getBounds().getY() + childDia.getBounds().getY());
//                                        svgChildSingleShape.setWidth(childDia.getBounds().getWidth());
//                                        svgChildSingleShape.setHeight(childDia.getBounds().getHeight());
//                                        svgChildSingleShape.setName(childDia.getName());
//                                        svgChildSingleShape.setStrokeColor(childDia.getLineColor());
//                                        svgChildSingleShape.setFillColor(childDia.getFillColor());
//                                        svgChildSingleShape.setFont(childDia.getFont());
//                                        svgChildSingleShape.setFontColor(childDia.getFillColor());
//                                        svgChildSingleShape.setStrokeWidth(childDia.getLineWidth());
//                                        svgChildSingleShape.setConnections(childSourceAndTargets);
//
////                                System.out.println(svgChildSingleShape.toString());
//                                        All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.put(childDia.getId(), svgChildSingleShape);
//                                    }
//                                    System.out.println("Connections ---===========> ");
//                                    if (childObj instanceof IDiagramModelArchimateObject) {
////                                        childSourceAndTargets = new ArrayList<String>();
//                                        IDiagramModelArchimateObject childDia = (IDiagramModelArchimateObject) childObj;
//                                        childSourceConList = childDia.getSourceConnections();
//                                        for (Object iDiModelConnObj : childSourceConList) {
//                                            if (((IDiagramModelConnection) iDiModelConnObj).getTarget() != null) {
//                                                System.out.println("Connections ---===========> " + ((IDiagramModelConnection) iDiModelConnObj).getTarget().getName());
//                                                childSourceAndTargets.put(((IDiagramModelConnection) iDiModelConnObj).getTarget().getId(), ((IDiagramModelConnection) iDiModelConnObj).getName());
//
//                                            }
//                                        }
//
//
//                                        svgChildSingleShape = new SVGSingleShape();
//                                        svgChildSingleShape.setId(childDia.getId());
//                                        svgChildSingleShape.setX(dia.getBounds().getX() + childDia.getBounds().getX());
//                                        svgChildSingleShape.setY(dia.getBounds().getY() + childDia.getBounds().getY());
//                                        svgChildSingleShape.setWidth(childDia.getBounds().getWidth());
//                                        svgChildSingleShape.setHeight(childDia.getBounds().getHeight());
//                                        svgChildSingleShape.setName(childDia.getName());
//                                        svgChildSingleShape.setStrokeColor(childDia.getLineColor());
//                                        svgChildSingleShape.setFillColor(childDia.getFillColor());
//                                        svgChildSingleShape.setFont(childDia.getFont());
//                                        svgChildSingleShape.setFontColor(childDia.getFillColor());
//                                        svgChildSingleShape.setStrokeWidth(childDia.getLineWidth());
//                                        svgChildSingleShape.setElementType(childDia.getArchimateElement().getClass().getSimpleName());
//                                        svgChildSingleShape.setConnections(childSourceAndTargets);
//
//                                        System.out.println(childDia.toString());
//                                        System.out.println(svgChildSingleShape.toString());
//                                        All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.put(childDia.getId(), svgChildSingleShape);
//                                    }
//                                }
//
//                            }
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("dia.getId " + dia.getId() + "dia.getName " + dia.getName());
//                    if (svgSingleShape != null)
//                        for (Map.Entry<String, String> a : svgSingleShape.getConnections().entrySet()) {
//                            System.out.println("^^^^^^^^^^^^^^ svgSingleShape.getCon.getname " + a.getValue());
//                        }
//                    All_MAIN_SVG_SHAPES_AND_CONNECTORS.put(dia.getId(), svgSingleShape);
//
//                }
//            }
////            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
