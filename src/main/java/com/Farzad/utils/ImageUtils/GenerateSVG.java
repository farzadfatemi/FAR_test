package com.Farzad.utils.ImageUtils;


import POJOs.SVGSingleShape;
import com.archimatetool.model.*;
import org.eclipse.emf.ecore.EObject;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static com.Farzad.utils.ImageUtils.ConnectionTools.getSVGline;
import static com.Farzad.utils.ImageUtils.ModelTools.loadModel;
import static com.Farzad.utils.ImageUtils.ShapeTools.getSVGShape;

/**
 * Created by VOLCANO on 4/21/2017.
 */
public class GenerateSVG {
    private static Map<String, SVGSingleShape> All_MAIN_SVG_SHAPES_AND_CONNECTORS = new TreeMap<>();
    private static Map<String, SVGSingleShape> All_CHILDREN_SVG_SHAPES_AND_CONNECTORS = new TreeMap<>();


    public static String getModelSVGs() {
        SVGSingleShape svgSingleShape = null;
        SVGSingleShape svgChildSingleShape = null;
        getAllModelSVGs();
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("<svg width=\"100%\" height=\"1700\" >");
            All_MAIN_SVG_SHAPES_AND_CONNECTORS.entrySet().stream().filter(obj -> obj.getValue() != null).forEachOrdered(obj -> {
                sb.append(getSVGShape(obj.getValue()));
                sb.append("\n");
            });
            for (Map.Entry<String, SVGSingleShape> obj : All_MAIN_SVG_SHAPES_AND_CONNECTORS.entrySet()) {
//                System.out.println(obj.getValue() != null && obj.getValue().getName() != null && obj.getValue().getName().equals("Locations1") ? "Loc" : "");
                if (obj.getValue() != null && obj.getValue().getConnections() != null) {
//                    System.out.println(obj.getValue() !=null && obj.getValue().getName()!=null&& obj.getValue().getName().equals("Locations1")?"lllLoc":"");
//                    System.out.println(obj.getValue() !=null && obj.getValue().getConnections()!=null? "--**"+obj.getValue().getConnections():"");
//                    System.out.println(obj.getValue() !=null && obj.getValue().getConnections()!=null? "--sss*** "+obj.getValue().getConnections().size():"");
                    for (Map.Entry<String, String> con : obj.getValue().getConnections().entrySet()) {
//                    for (String con : obj.getValue().getConnections()) {
//                        System.out.println("conns : "+con.getKey()+" : "+con.getValue());
                        String key = con.getKey().split("-").length > 1 ? con.getKey().split("-")[1] : null;
                        if (All_MAIN_SVG_SHAPES_AND_CONNECTORS.containsKey(key)) {
//                            System.out.println("All_MAIN_SVG_SHAPES_AND_CONNECTORS.containsKey : " + con.getValue());
                            svgSingleShape = All_MAIN_SVG_SHAPES_AND_CONNECTORS.get(key);
                            System.out.println("## con.getKey() -- " + svgSingleShape.getName() + " -- " + obj.getValue().getName());
                        }

                        else if (All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.containsKey(key)) {
//                            System.out.println("All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.containsKey : " + con.getValue());
                            svgSingleShape = All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.get(key);
                            System.out.println("** con.getKey() -- " + svgSingleShape.getName() + " -- " + obj.getValue().getName());
                        }
                        System.out.println("con.getValue()********************" + con.getValue());
                        if (svgSingleShape != null) {
                            obj.getValue().setConnectionsType(con.getValue());
//                            System.out.println("svgSingleShape : "+svgSingleShape.getId()+" : "+svgSingleShape.getName());
//                            System.out.println("obj.getValue() : "+obj.getValue().getId()+" : "+obj.getValue().getName());
                            sb.append(getSVGline(obj.getValue(), svgSingleShape));
                        }
                    }
                }
            }

            All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.entrySet().stream().filter(obj -> obj.getValue() != null).forEachOrdered(obj -> {
                sb.append(getSVGShape(obj.getValue()));
                sb.append("\n");
            });
            for (Map.Entry<String, SVGSingleShape> obj : All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.entrySet()) {
                if (obj.getValue() != null && obj.getValue().getConnections() != null) {
                    for (Map.Entry<String, String> con : obj.getValue().getConnections().entrySet()) {
//                        for (String con : obj.getValue().getConnections()) {
//                        System.out.println("con.getKey()" + con.getKey());
                        String key = con.getKey().split("-").length > 1 ? con.getKey().split("-")[1] : null;
                        if (All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.containsKey(key)) {
                            svgChildSingleShape = All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.get(key);
//                            System.out.println("-- con.getKey() -- " + con.getKey() + " -- " + All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.get(key).getId());
                        } else if (All_MAIN_SVG_SHAPES_AND_CONNECTORS.containsKey(key)) {
                            svgChildSingleShape = All_MAIN_SVG_SHAPES_AND_CONNECTORS.get(key);
//                            System.out.println("++ con.getKey() -- " + svgChildSingleShape.getName() + " -- " + obj.getValue().getName());
                        }
                        if (svgChildSingleShape != null) {
                            obj.getValue().setConnectionsType(con.getValue());
                            sb.append(getSVGline(obj.getValue(), svgChildSingleShape));
                        }
                    }
                }
            }


            sb.append("</svg>");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public static int[] firstAndLastXY() {
        int[] firstLastXY = new int[]{0, 0, 0, 0};
        int firstX = 100000;
        int lastX = 0;
        int firstY = 100000;
        int lastY = 0;
        SVGSingleShape svgSingleShape = null;
        SVGSingleShape svgChildSingleShape = null;
//        getAllModelSVGs();
        try {
            for (Map.Entry<String, SVGSingleShape> obj : All_MAIN_SVG_SHAPES_AND_CONNECTORS.entrySet()) {
                if (obj.getValue() != null && obj.getValue().getConnections() != null) {
                    for (Map.Entry<String, String> con : obj.getValue().getConnections().entrySet()) {
                        if (All_MAIN_SVG_SHAPES_AND_CONNECTORS.containsKey(con.getKey())) {
                            svgSingleShape = All_MAIN_SVG_SHAPES_AND_CONNECTORS.get(con.getKey());
                        } else if (All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.containsKey(con.getKey())) {
                            svgSingleShape = All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.get(con.getKey());
                        }
                        if (svgSingleShape != null) {
                            System.out.println("con.getValue()********************" + con.getValue());
                            obj.getValue().setConnectionsType(con.getValue());
                            if (obj.getValue() != null) {
                                if (obj.getValue().getX() < firstX) {
                                    firstX = obj.getValue().getX();
                                }
                                if (obj.getValue().getX() + obj.getValue().getWidth() > lastX) {
                                    lastX = obj.getValue().getX();
                                }
                                if (obj.getValue().getY() < firstY) {
                                    firstY = obj.getValue().getY();
                                }
                                if (obj.getValue().getY() + obj.getValue().getHeight() > lastY) {
                                    lastY = obj.getValue().getY();
                                }
                            }
                        }
                    }
                }
            }

//            for (Map.Entry<String, SVGSingleShape> obj : All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.entrySet()) {
//                if (obj.getValue() != null && obj.getValue().getConnections() != null) {
//                    for (Map.Entry<String, String> con : obj.getValue().getConnections().entrySet()) {
//                            if (All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.containsKey(con.getKey())) {
//                                svgChildSingleShape = All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.get(con.getKey());
//                            }else if (All_MAIN_SVG_SHAPES_AND_CONNECTORS.containsKey(con.getKey())) {
//                                svgChildSingleShape = All_MAIN_SVG_SHAPES_AND_CONNECTORS.get(con.getKey());
//                            } if (svgChildSingleShape !=null){
//                                obj.getValue().setConnectionsType(con.getValue());
//                                sb.append(getSVGline(obj.getValue(), svgChildSingleShape));
//                            }
//                        }
//                    }
//            }
//
//            All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.entrySet().stream().filter(obj -> obj.getValue() != null).forEachOrdered(obj -> {
//                sb.append(getSVGShape(obj.getValue()));
//                sb.append("\n");
//            });
//            sb.append("</svg>");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return firstLastXY;
    }

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

    private static void getSingleModelSVGs(IDiagramModelObject diagramCpt, int x, int y,boolean child) {
        boolean addObj = false;
        String objName = "-";
        Map<String, String> sourceAndTarget = new TreeMap<String, String>();
        List SourceConList = null;
        SVGSingleShape svgSingleShape = null;
        SVGSingleShape svgChildSingleShape = null;
        int makeUniqueID = 0;
        int makeUniqueIDChild = 0;
        if (diagramCpt instanceof IDiagramModelArchimateObject) {
            IDiagramModelArchimateObject modelObj = (IDiagramModelArchimateObject) diagramCpt;
            SourceConList = modelObj.getSourceConnections();
            if(child){
                modelObj.getBounds().setX(x);
                modelObj.getBounds().setY(y);
            }
            for (Object iDiModelConnObj : SourceConList) {
                makeUniqueID++;
                if (((IDiagramModelConnection) iDiModelConnObj).getTarget() != null) {
                    sourceAndTarget.put(makeUniqueID + "-" + ((IDiagramModelConnection) iDiModelConnObj).getTarget().getId(), ((IDiagramModelConnection) iDiModelConnObj).getName());
//                            sourceAndTarget.add(((IDiagramModelConnection) iDiModelConnObj).getTarget().getId());

                    System.out.println("-- " + modelObj.getName() + " --4---4---" + ((IDiagramModelConnection) iDiModelConnObj).getTarget().getName() + "--  ---" + ((IDiagramModelConnection) iDiModelConnObj).getTarget().getId() + "--  ---" + ((IDiagramModelConnection) iDiModelConnObj).getName());
                }


//                        for (Map.Entry<String, String> a : sourceAndTarget.entrySet()) {
//                            System.out.println(" ---------*>>  relations: " + a.getValue());
//                        }
            }

            try {
                if (modelObj.getBounds() != null) {
                    svgSingleShape = new SVGSingleShape();
                    svgSingleShape.setId(modelObj.getId());
                    svgSingleShape.setX(modelObj.getBounds().getX());
                    svgSingleShape.setY(modelObj.getBounds().getY());
                    svgSingleShape.setWidth(modelObj.getBounds().getWidth());
                    svgSingleShape.setHeight(modelObj.getBounds().getHeight());
                    svgSingleShape.setName(modelObj.getName());
                    svgSingleShape.setStrokeColor(modelObj.getLineColor());
                    svgSingleShape.setStrokeWidth(modelObj.getLineWidth());
                    svgSingleShape.setFillColor(modelObj.getFillColor());
                    svgSingleShape.setFont(modelObj.getFont());
                    svgSingleShape.setFontColor(modelObj.getFontColor());
                    svgSingleShape.setConnections(sourceAndTarget);
                    svgSingleShape.setHasChild(false);
                    svgSingleShape.setElementType(modelObj.getArchimateElement() != null && modelObj.getArchimateElement().getClass() != null ?
                            modelObj.getArchimateElement().getClass().getSimpleName() : "");
//                                System.out.println(svgSingleShape.toString());

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            All_MAIN_SVG_SHAPES_AND_CONNECTORS.put(modelObj.getId(), svgSingleShape);
            for (IDiagramModelObject childObj : modelObj.getChildren()) {
                 getSingleModelSVGs(childObj, modelObj.getBounds().getX() + childObj.getBounds().getX(), modelObj.getBounds().getY() + childObj.getBounds().getY(),true);
            }
        } else if (diagramCpt instanceof IDiagramModelGroup) {
            // Add any child elements to this root
            IDiagramModelGroup modelGrp = (IDiagramModelGroup) diagramCpt;

            SourceConList = modelGrp.getSourceConnections();
            for (Object iDiModelConnObj : SourceConList) {
                makeUniqueID++;
                if (((IDiagramModelConnection) iDiModelConnObj).getTarget() != null) {
                    sourceAndTarget.put(makeUniqueID + "-" + ((IDiagramModelConnection) iDiModelConnObj).getTarget().getId(), ((IDiagramModelConnection) iDiModelConnObj).getName());
//                            sourceAndTarget.add(((IDiagramModelConnection) iDiModelConnObj).getTarget().getId());

                    System.out.println("-- " + modelGrp.getName() + " --4---4---" + ((IDiagramModelConnection) iDiModelConnObj).getTarget().getName() + "--  ---" + ((IDiagramModelConnection) iDiModelConnObj).getTarget().getId() + "--  ---" + ((IDiagramModelConnection) iDiModelConnObj).getName());
                }


//                        for (Map.Entry<String, String> a : sourceAndTarget.entrySet()) {
//                            System.out.println(" ---------*>>  relations: " + a.getValue());
//                        }
            }

            try {
                if (modelGrp.getBounds() != null) {
                    svgSingleShape = new SVGSingleShape();
                    svgSingleShape.setId(modelGrp.getId());
                    svgSingleShape.setX(modelGrp.getBounds().getX());
                    svgSingleShape.setY(modelGrp.getBounds().getY());
                    svgSingleShape.setWidth(modelGrp.getBounds().getWidth());
                    svgSingleShape.setHeight(modelGrp.getBounds().getHeight());
                    svgSingleShape.setName(modelGrp.getName());
                    svgSingleShape.setStrokeColor(modelGrp.getLineColor());
                    svgSingleShape.setStrokeWidth(modelGrp.getLineWidth());
                    svgSingleShape.setFillColor(modelGrp.getFillColor());
                    svgSingleShape.setFont(modelGrp.getFont());
                    svgSingleShape.setFontColor(modelGrp.getFontColor());
                    svgSingleShape.setConnections(sourceAndTarget);
                    svgSingleShape.setHasChild(false);
//                    svgSingleShape.setElementType(modelGrp.getArchimateElement() != null && modelGrp.getArchimateElement().getClass() != null ?
//                            modelGrp.getArchimateElement().getClass().getSimpleName() : "");
////                                System.out.println(svgSingleShape.toString());

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            All_MAIN_SVG_SHAPES_AND_CONNECTORS.put(modelGrp.getId(), svgSingleShape);
            for (IDiagramModelObject childObj : modelGrp.getChildren()) {
                getSingleModelSVGs(childObj, modelGrp.getBounds().getX() + childObj.getBounds().getX(), modelGrp.getBounds().getY() + childObj.getBounds().getY(),true);
            }


        }

    }


    private static void getAllModelSVGs() {
        Map<String, String> sourceAndTarget = null;
//        List<String> sourceAndTarget = null;
        Map<String, String> childSourceAndTargets = null;
//        List<String> childSourceAndTargets = null;
        try {
//            File modelFile = new File("D:\\FAR_Documents\\__Startamap\\Archisurance.archimate");
            File modelFile = new File("D:\\FAR_Documents\\__Startamap\\eira_v1_1_0_archimate.archimate");
//            File modelFile = new File("D:\\FAR_Documents\\__Startamap\\Original2.archimate");
            IArchimateModel model = loadModel(modelFile);
            List<IDiagramModel> iDModels = model.getDiagramModels();
            List SourceConList = null;
            List childSourceConList = null;
            List childrenList = null;
            SVGSingleShape svgSingleShape = null;
            SVGSingleShape svgChildSingleShape = null;
//            for (IDiagramModel diagramModel : iDModels) {
            IDiagramModel diagramModel = iDModels.get(1);
            int makeUniqueID = 0;
            int makeUniqueIDChild = 0;
            for (EObject obj : diagramModel.eContents()) {

                getSingleModelSVGs((IDiagramModelObject) obj,0,0,false);
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
