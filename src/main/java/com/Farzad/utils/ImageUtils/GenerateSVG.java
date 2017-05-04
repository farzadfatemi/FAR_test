package com.Farzad.utils.ImageUtils;


import POJOs.SVGSingleShape;
import com.Farzad.Enums.ConnectionsEnum;
import com.archimatetool.editor.model.compatibility.ModelCompatibility;
import com.archimatetool.model.*;
import com.archimatetool.model.util.ArchimateResourceFactory;
import org.apache.commons.io.FileUtils;
import org.eclipse.draw2d.Shape;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static com.Farzad.utils.ImageUtils.ConnectionTools.*;
import static com.Farzad.utils.ImageUtils.ModelTools.*;
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
            for (Map.Entry<String, SVGSingleShape> obj : All_MAIN_SVG_SHAPES_AND_CONNECTORS.entrySet()) {
//                System.out.println(obj.getValue() != null && obj.getValue().getName() != null && obj.getValue().getName().equals("Locations1") ? "Loc" : "");
                if (obj.getValue() != null && obj.getValue().getConnections() != null) {
//                    System.out.println(obj.getValue() !=null && obj.getValue().getName()!=null&& obj.getValue().getName().equals("Locations1")?"lllLoc":"");
//                    System.out.println(obj.getValue() !=null && obj.getValue().getConnections()!=null? "--**"+obj.getValue().getConnections():"");
//                    System.out.println(obj.getValue() !=null && obj.getValue().getConnections()!=null? "--sss*** "+obj.getValue().getConnections().size():"");
                    for (Map.Entry<String, String> con : obj.getValue().getConnections().entrySet()) {
//                    for (String con : obj.getValue().getConnections()) {
                        System.out.println("conns : "+con.getKey()+" : "+con.getValue());
                        if (All_MAIN_SVG_SHAPES_AND_CONNECTORS.containsKey(con.getKey())) {
                            System.out.println("All_MAIN_SVG_SHAPES_AND_CONNECTORS.containsKey : " + con.getValue());
                            svgSingleShape = All_MAIN_SVG_SHAPES_AND_CONNECTORS.get(con.getKey());
                        }else if (All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.containsKey(con.getKey())) {
                            System.out.println("All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.containsKey : " + con.getValue());
                            svgSingleShape = All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.get(con.getKey());
                        } if (svgSingleShape !=null){
                            System.out.println("con.getValue()********************"+con.getValue());
                            obj.getValue().setConnectionsType(con.getValue());
//                            System.out.println("svgSingleShape : "+svgSingleShape.getId()+" : "+svgSingleShape.getName());
//                            System.out.println("obj.getValue() : "+obj.getValue().getId()+" : "+obj.getValue().getName());
                            sb.append(getSVGline(obj.getValue(), svgSingleShape));
                        }
                    }
                }
            }
            All_MAIN_SVG_SHAPES_AND_CONNECTORS.entrySet().stream().filter(obj -> obj.getValue() != null).forEachOrdered(obj -> {
                sb.append(getSVGShape(obj.getValue()));
                sb.append("\n");
            });
            for (Map.Entry<String, SVGSingleShape> obj : All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.entrySet()) {
                if (obj.getValue() != null && obj.getValue().getConnections() != null) {
                    for (Map.Entry<String, String> con : obj.getValue().getConnections().entrySet()) {
//                        for (String con : obj.getValue().getConnections()) {
                            if (All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.containsKey(con.getKey())) {
                                svgChildSingleShape = All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.get(con.getKey());
                                obj.getValue().setConnectionsType(con.getValue());
                                sb.append(getSVGline(obj.getValue(), svgChildSingleShape));
                            }
                        }
                    }
                for (Map.Entry<String, String> con : obj.getValue().getConnections().entrySet()) {
//                    for (String con : obj.getValue().getConnections()) {
                        if (All_MAIN_SVG_SHAPES_AND_CONNECTORS.containsKey(con.getKey())) {
                            svgChildSingleShape = All_MAIN_SVG_SHAPES_AND_CONNECTORS.get(con.getKey());
                            obj.getValue().setConnectionsType(con.getValue());
                            sb.append(getSVGline(obj.getValue(), svgChildSingleShape));
                        }
                     
                }
            }

            All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.entrySet().stream().filter(obj -> obj.getValue() != null).forEachOrdered(obj -> {
                sb.append(getSVGShape(obj.getValue()));
                sb.append("\n");
            });
            sb.append("</svg>");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
    private static void getAllModelSVGs() {
        Map<String, String> sourceAndTarget = null;
//        List<String> sourceAndTarget = null;
        Map<String, String> childSourceAndTargets = null;
//        List<String> childSourceAndTargets = null;
        try {
            File modelFile = new File("D:\\FAR_Documents\\__Startamap\\Original2.archimate");
            IArchimateModel model = loadModel(modelFile);
            List<IDiagramModel> iDModels = model.getDiagramModels();
            List SourceConList = null;
            List childSourceConList = null;
            List childrenList = null;
            SVGSingleShape svgSingleShape = null;
            SVGSingleShape svgChildSingleShape = null;
//            for (IDiagramModel diagramModel : iDModels) {
            IDiagramModel diagramModel = iDModels.get(0);
            for (EObject obj : diagramModel.eContents()) {
                sourceAndTarget = new TreeMap<String, String>();
//                sourceAndTarget = new ArrayList<String>();
                if (obj instanceof IDiagramModelArchimateObject) {
                    IDiagramModelArchimateObject dia = (IDiagramModelArchimateObject) obj;
                    SourceConList = dia.getSourceConnections();
                    for (Object iDiModelConnObj : SourceConList) {
                        if (((IDiagramModelConnection) iDiModelConnObj).getTarget() != null) {
                            sourceAndTarget.put(((IDiagramModelConnection) iDiModelConnObj).getTarget().getId(),((IDiagramModelConnection) iDiModelConnObj).getName());
//                            sourceAndTarget.add(((IDiagramModelConnection) iDiModelConnObj).getTarget().getId());
                            System.out.println(((IDiagramModelConnection) iDiModelConnObj).getTarget().getId()+"-- --4---4---"+((IDiagramModelConnection) iDiModelConnObj).getTarget().getName()+"-- --4---4---"+((IDiagramModelConnection) iDiModelConnObj).getName());
                        }
//                        ((IDiagramModelConnection) dia).getName();
                    }

                    try {
                        if (dia.getBounds() != null) {
                            svgSingleShape = new SVGSingleShape();
                            svgSingleShape.setId(dia.getId());
                            svgSingleShape.setX(dia.getBounds().getX());
                            svgSingleShape.setY(dia.getBounds().getY());
                            svgSingleShape.setWidth(dia.getBounds().getWidth());
                            svgSingleShape.setHeight(dia.getBounds().getHeight());
                            svgSingleShape.setName(dia.getName());
                            svgSingleShape.setStrokeColor(dia.getLineColor());
                            svgSingleShape.setStrokeWidth(dia.getLineWidth());
                            svgSingleShape.setFillColor(dia.getFillColor());
                            svgSingleShape.setFont(dia.getFont());
                            svgSingleShape.setFontColor(dia.getFontColor());
                            svgSingleShape.setConnections(sourceAndTarget);
                            svgSingleShape.setElementType(dia.getArchimateElement()!=null&& dia.getArchimateElement().getClass() !=null ?
                                    dia.getArchimateElement().getClass().getSimpleName():"");
//                                System.out.println(svgSingleShape.toString());

                            if (dia.getChildren() != null) {
                                childrenList = dia.getChildren();

                                for (Object childObj : childrenList) {

                                    if (childObj instanceof IDiagramModelObject) {
                                        childSourceAndTargets = new TreeMap<>();
//                                        childSourceAndTargets = new ArrayList<String>();
                                        IDiagramModelObject childDia = (IDiagramModelObject) childObj;
                                        childSourceConList = childDia.getSourceConnections();
                                        for (Object iDiModelConnObj : childSourceConList) {
                                            if (((IDiagramModelConnection) iDiModelConnObj).getTarget() != null) {
                                                childSourceAndTargets.put(((IDiagramModelConnection) iDiModelConnObj).getTarget().getId(),((IDiagramModelConnection) iDiModelConnObj).getName());

                                            }
                                        }


                                        svgChildSingleShape = new SVGSingleShape();
                                        svgChildSingleShape.setId(childDia.getId());
                                        svgChildSingleShape.setX(dia.getBounds().getX() + childDia.getBounds().getX());
                                        svgChildSingleShape.setY(dia.getBounds().getY() + childDia.getBounds().getY());
                                        svgChildSingleShape.setWidth(childDia.getBounds().getWidth());
                                        svgChildSingleShape.setHeight(childDia.getBounds().getHeight());
                                        svgChildSingleShape.setName(childDia.getName());
                                        svgChildSingleShape.setStrokeColor(childDia.getLineColor());
                                        svgChildSingleShape.setFillColor(childDia.getFillColor());
                                        svgChildSingleShape.setFont(childDia.getFont());
                                        svgChildSingleShape.setFontColor(childDia.getFillColor());
                                        svgChildSingleShape.setStrokeWidth(childDia.getLineWidth());
                                        svgChildSingleShape.setConnections(childSourceAndTargets);

//                                System.out.println(svgChildSingleShape.toString());
                                        All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.put(childDia.getId(), svgChildSingleShape);
                                    }
                                    if (childObj instanceof IDiagramModelArchimateObject) {
//                                        childSourceAndTargets = new ArrayList<String>();
                                        IDiagramModelArchimateObject childDia = (IDiagramModelArchimateObject) childObj;
                                        childSourceConList = childDia.getSourceConnections();
                                        for (Object iDiModelConnObj : childSourceConList) {
                                            if (((IDiagramModelConnection) iDiModelConnObj).getTarget() != null) {
                                                childSourceAndTargets.put(((IDiagramModelConnection) iDiModelConnObj).getTarget().getId(),((IDiagramModelConnection) iDiModelConnObj).getName());

                                            }
                                        }


                                        svgChildSingleShape = new SVGSingleShape();
                                        svgChildSingleShape.setId(childDia.getId());
                                        svgChildSingleShape.setX(dia.getBounds().getX() + childDia.getBounds().getX());
                                        svgChildSingleShape.setY(dia.getBounds().getY() + childDia.getBounds().getY());
                                        svgChildSingleShape.setWidth(childDia.getBounds().getWidth());
                                        svgChildSingleShape.setHeight(childDia.getBounds().getHeight());
                                        svgChildSingleShape.setName(childDia.getName());
                                        svgChildSingleShape.setStrokeColor(childDia.getLineColor());
                                        svgChildSingleShape.setFillColor(childDia.getFillColor());
                                        svgChildSingleShape.setFont(childDia.getFont());
                                        svgChildSingleShape.setFontColor(childDia.getFillColor());
                                        svgChildSingleShape.setStrokeWidth(childDia.getLineWidth());
                                        svgChildSingleShape.setElementType(childDia.getArchimateElement().getClass().getSimpleName());
                                        svgChildSingleShape.setConnections(childSourceAndTargets);

//                                System.out.println(svgChildSingleShape.toString());
                                        All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.put(childDia.getId(), svgChildSingleShape);
                                    }
                                }

                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    All_MAIN_SVG_SHAPES_AND_CONNECTORS.put(dia.getId(), svgSingleShape);

                }
            }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
