package com.Farzad.utils.ImageUtils;


import POJOs.SVGSingleShape;
import com.Farzad.Enums.ConnectionsEnum;
import com.Farzad.Enums.IconsEnum;
import com.archimatetool.editor.model.compatibility.ModelCompatibility;
import com.archimatetool.model.*;
import com.archimatetool.model.util.ArchimateResourceFactory;
import org.apache.commons.io.FileUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by VOLCANO on 4/21/2017.
 */
public class GenerateSVG {
    private static Map<String, SVGSingleShape> All_MAIN_SVG_SHAPES_AND_CONNECTORS = new TreeMap<>();
    private static Map<String, SVGSingleShape> All_CHILDREN_SVG_SHAPES_AND_CONNECTORS = new TreeMap<>();

    private static String getSVGShape(SVGSingleShape svgShape) {
        String result = ""
                +
                "<svg>" +
                " <g>" +
                " <a xlink:href=\"https://google.com\">\n" +
                "      <rect fill=\"" + svgShape.getFillColor() + "\"  x=\"" + svgShape.getX() + "\" y=\"" + svgShape.getY() + "\" width=\"" + svgShape.getWidth()
                + "\" height=\"" + svgShape.getHeight() + "\" stroke=\"" + svgShape.getStrokeColor() + "\" />\n" +
                "      <text x=\"" + (svgShape.getX() + 10) + "\" xml:space=\"preserve\" y=\"" + (svgShape.getY() + 35) + "\" clip-path=\"url(#clipPath20)\" stroke=\"none\"\n" +
                "      font-family=\"" + svgShape.getFont() + "\" fill=\"#FFFFFF\"  >" + svgShape.getName() + "</text>\n" +
                "    </a>\n";
        if (svgShape.getName() != null && svgShape.getName().equals("Actors1")) {
//            result +=
//                    "<defs><style>.cls-1{fill:#faab19;}</style></defs><title>Colour</title><path class=\"cls-1\" " +
//                    "d=\"M12.5,13.37a5.51,5.51,0,0,1,5.5,5.5v1H7v-1a5.51,5.51,0,0,1,5.5-5.5m0-2.5a8,8,0,0,0-8,8v3.52h16V18.87a8,8,0,0,0-8-8Zm-8,11.52v0Z\"/>" +
//                    "<path class=\"cls-1\" d=\"M12.5,5a2.6,2.6,0,1,1-2.6,2.6A2.6,2.6,0,0,1,12.5,5m0-2.5a5.1,5.1,0,1,0,5.1,5.1,5.1,5.1,0,0,0-5.1-5.1Z\"/> ";
//            result += "<image x=\"" + (svgShape.getX() + svgShape.getWidth() - 30) + "\" y=\"" + svgShape.getY() + 5 + "\" width=\"30\" height=\"30\" xlink:href=\"src/main/resources/images/Collaboration_Application.svg\"";
//            result += "<image x=\"" + (svgShape.getX() + svgShape.getWidth() - 30) + "\" y=\"" + svgShape.getY() + 5 + "\" width=\"30\" height=\"30\" xlink:href=\"Actor_Business.svg\"";
//            result += "<svg x=\"" + (svgShape.getX() + svgShape.getWidth() - 30) + "\" y=\"" + svgShape.getY() + 5 + "\" width=\"30\" height=\"30\" id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 25 25\"><defs><style>.cls-1{fill:#faab19;}</style></defs><title>Colour</title><path class=\"cls-1\" d=\"M12.5,13.37a5.51,5.51,0,0,1,5.5,5.5v1H7v-1a5.51,5.51,0,0,1,5.5-5.5m0-2.5a8,8,0,0,0-8,8v3.52h16V18.87a8,8,0,0,0-8-8Zm-8,11.52v0Z\"/><path class=\"cls-1\" d=\"M12.5,5a2.6,2.6,0,1,1-2.6,2.6A2.6,2.6,0,0,1,12.5,5m0-2.5a5.1,5.1,0,1,0,5.1,5.1,5.1,5.1,0,0,0-5.1-5.1Z\"/></svg>";
            result += getSVGIcons(svgShape);
        }
        result += "</g>" +
                "</svg>"
        ;
        return result;

    }
 private static String getSVGIcons(SVGSingleShape svgShape) {
     if (svgShape.getName() != null && svgShape.getName().equals("Actors1")) {
//            System.out.println(source.getConnectionsType()+"--**--"+source.getName()+" target id : "+target.getId()+" target name : "+target.getName());
         if(IconsEnum.COLLABORATION_APPLICATION.equalsName("collaboration_application")){
             return IconsEnum.COLLABORATION_APPLICATION.iconSVGCode(svgShape);
         }else
             return null;

     } else
         return null;

    }

    private static String getSVGline(SVGSingleShape source, SVGSingleShape target) {
//        System.out.println(source !=null?source.getName() +" target id : "+target.getId()+" target name : "+target.getName():"nuuul");
        if (source != null && source.getConnectionsType() != null) {
//            System.out.println(source.getConnectionsType()+"--**--"+source.getName()+" target id : "+target.getId()+" target name : "+target.getName());
            if(ConnectionsEnum.ACCESSES.equalsName(source.getConnectionsType().toLowerCase())) {
                return ConnectionsEnum.ACCESSES.lineSVGCode(source, target);
            }else if(ConnectionsEnum.ASSIGNED.equalsName(source.getConnectionsType().toLowerCase())){
                    return ConnectionsEnum.ASSIGNED.lineSVGCode(source, target);
            }else if(ConnectionsEnum.AGGREGATION.equalsName(source.getConnectionsType().toLowerCase())){
                return ConnectionsEnum.AGGREGATION.lineSVGCode(source, target);
            }else if(ConnectionsEnum.ASSOCIATION.equalsName(source.getConnectionsType().toLowerCase())){
                    return ConnectionsEnum.ASSOCIATION.lineSVGCode(source, target);
            }else if(ConnectionsEnum.USES.equalsName(source.getConnectionsType().toLowerCase())){
                    return ConnectionsEnum.USES.lineSVGCode(source, target);
            }else if(ConnectionsEnum.USED_BY.equalsName(source.getConnectionsType().toLowerCase())){
                    return ConnectionsEnum.USED_BY.lineSVGCode(source, target);
            }else if(ConnectionsEnum.REALISES.equalsName(source.getConnectionsType().toLowerCase())){
                    return ConnectionsEnum.REALISES.lineSVGCode(source, target);
            }else if(ConnectionsEnum.READ_AND_WRITE.equalsName(source.getConnectionsType().toLowerCase())){
                    return ConnectionsEnum.READ_AND_WRITE.lineSVGCode(source, target);
            }else
                return null;
//            int x1 = source.getX() + source.getWidth();
//            int x2 = target.getX();
//            int y1 = source.getY();
//            int y2 = target.getY();
//            return ""
//                    +
//                    "<svg>" +
//                    " <circle cx=\"" + x1 + "\" cy=\"" + y1 + "\" r=\"3\" fill=\"#000000\" />" +
//                    "      <line fill=\"black\" x1=\"" + x1 + "\" x2=\"" + x2 + "\" y1=\"" + y1 + "\" y2=\"" + y2 + "\" " +
//                    "stroke=\"#000000\" stroke-width=\"" + source.getStrokeWidth() + "\"/>\n" +
//                    "<circle cx=\"" + x2 + "\" cy=\"" + y2 + "\" r=\"3\" fill=\"#000000\" />" +
//                    "</svg>"
//                    ;

        } else
            return source !=null?source.getName():null;

    }

//    private static String getSVGShapes(IDiagramModelArchimateObject diaObj) {
//        String result = "";
//        SVGSingleShape svgSingleShape = null;
//        try {
//            if (diaObj != null && diaObj.getBounds() != null) {
//                svgSingleShape = new SVGSingleShape();
//                svgSingleShape.setX(diaObj.getBounds().getX());
//                svgSingleShape.setY(diaObj.getBounds().getY());
//                svgSingleShape.setWidth(diaObj.getBounds().getWidth());
//                svgSingleShape.setY(diaObj.getBounds().getHeight());
//                svgSingleShape.setName(diaObj.getName());
//                result = getSVGShape(svgSingleShape);
//                result += "\n";
////                    result+=getSVGline(diaObj.getli().getX());
//                result += "\n";
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }

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
//                        System.out.println("conns : "+conns.getKey()+" : "+conns.getValue());
                        if (All_MAIN_SVG_SHAPES_AND_CONNECTORS.containsKey(con.getKey())) {
                            svgSingleShape = All_MAIN_SVG_SHAPES_AND_CONNECTORS.get(con.getKey());

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

    public static void getAllModelSVGs() {
        Map<String, String> sourceAndTarget = null;
//        List<String> sourceAndTarget = null;
        Map<String, String> childSourceAndTargets = null;
//        List<String> childSourceAndTargets = null;
        try {
            File modelFile = new File("D:\\FAR_Documents\\__Startamap\\Original.archimate");
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

    public static IArchimateModel loadModel(File modelFile) throws IOException {
        long startTime = System.currentTimeMillis();
        IArchimateModel model;
        // Create the Resource
        ArchimateResourceFactory.createResourceSet();
        IArchimatePackage pack = IArchimatePackage.eINSTANCE;
        Resource resource = ArchimateResourceFactory.createNewResource(modelFile);
        // Check model compatibility
        ModelCompatibility modelCompatibility = new ModelCompatibility(resource);
        // Load the model file
        Map<Object, Object> mergedOptions = new HashMap<Object, Object>();
        // mergedOptions.put(XMLResource.OPTION_DOM_USE_NAMESPACES_IN_SCOPE,
        // Boolean.FALSE);
        try {
            resource.load(FileUtils.openInputStream(modelFile), mergedOptions);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!resource.isLoaded() || resource.getContents().isEmpty()) {
            throw new IOException("Couldn't load the resource for some reason");
        }
        model = (IArchimateModel) resource.getContents().get(0);
        // Once loaded - check for later model version
        boolean isLaterModelVersion = modelCompatibility.isLaterModelVersion(ModelVersion.VERSION);
        if (isLaterModelVersion) {
            // TODO whats this?
        }
        // Check for unknown model features which might be OK to load
        else {
            List<Diagnostic> exceptions = modelCompatibility.getAcceptableExceptions();
            if (!exceptions.isEmpty()) {
                String message = ""; //$NON-NLS-1$
                for (int i = 0; i < exceptions.size(); i++) {
                    if (i == 3) {
                        message += (exceptions.size() - 3) + " "; //$NON-NLS-1$
                        break;
                    }
                    message += exceptions.get(i).getMessage() + "\n"; //$NON-NLS-1$
                }
            }
        }
        // And then fix any backward compatibility issues
        // try {
        // modelCompatibility.fixCompatibility ();
        // } catch (CompatibilityHandlerException ex) {
        // }
        model.setFile(modelFile);
        model.setDefaults();
        long endTime = System.currentTimeMillis();
        System.out.println("Models loaded " + (endTime - startTime) + "ms");
        return model;
    }

}
