package com.Farzad.utils.ImageUtils;


import POJOs.SVGSingleShape;
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
    private static Map<String, SVGSingleShape> All_MAIN_SVG_SHAPES_AND_CONNECTORS = new TreeMap<String, SVGSingleShape>();
    private static Map<String, SVGSingleShape> All_CHILDREN_SVG_SHAPES_AND_CONNECTORS = new TreeMap<String, SVGSingleShape>();

    public static String getSVGShape(SVGSingleShape svgShape) {
        return ""
                +
                "<svg>" +
                " <a xlink:href=\"https://google.com\">\n" +
                "      <text fill=\"" + svgShape.getStrokeColor() + "\" x=\"" + (svgShape.getX() + 1) + "\" xml:space=\"preserve\" y=\"" + (svgShape.getY() + 1) + "\" clip-path=\"url(#clipPath20)\" stroke=\"none\"\n" +
                "      >" + svgShape.getName() + "</text\n" +
                "      ><rect fill=\"" + svgShape.getFillColor() + "\"  x=\"" + svgShape.getX() + "\" y=\"" + svgShape.getY() + "\" width=\"" + svgShape.getWidth() + "\" height=\"" + svgShape.getHeight() + "\" />\n" +
                "    </a>\n" +
                "</svg>"
                ;

    }

    private static String getSVGline(SVGSingleShape source, SVGSingleShape target) {
        int x1 = source != null ? source.getX() + source.getWidth() : 0;
        int x2 = source != null ? target.getX() : 0;
        int y1 = source != null ? source.getY() : 0;
        int y2 = source != null ? target.getY() : 0;
        return ""
                +
                "<svg>" +
                "      <line fill=\"black\" x1=\"" + x1 + "\" x2=\"" + x2 + "\" y1=\"" + y1 + "\" y2=\"" + y2 + "\" stroke=\"rgb(193,232,255)\"/>\n" +
                "</svg>"
                ;

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
        getAllModelSVGs();
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("<svg width=\"100%\" height=\"1700\" >");
            for (Map.Entry<String, SVGSingleShape> obj : All_MAIN_SVG_SHAPES_AND_CONNECTORS.entrySet()) {
                System.out.println(obj.getValue() != null && obj.getValue().getName() != null && obj.getValue().getName().equals("Locations1") ? "Loc" : "");
                if (obj.getValue() != null && obj.getValue().getConnections() != null) {
//                    System.out.println(obj.getValue() !=null && obj.getValue().getName()!=null&& obj.getValue().getName().equals("Locations1")?"lllLoc":"");
//                    System.out.println(obj.getValue() !=null && obj.getValue().getConnections()!=null? "--**"+obj.getValue().getConnections():"");
//                    System.out.println(obj.getValue() !=null && obj.getValue().getConnections()!=null? "--sss*** "+obj.getValue().getConnections().size():"");
//                    for (Map.Entry<String, String> conns : obj.getValue().getConnections().entrySet()) {
                    for (String con : obj.getValue().getConnections()) {
//                        System.out.println("conns : "+conns.getKey()+" : "+conns.getValue());
                        if (All_MAIN_SVG_SHAPES_AND_CONNECTORS.containsKey(con)) {
                            svgSingleShape = All_MAIN_SVG_SHAPES_AND_CONNECTORS.get(con);
//                            System.out.println("svgSingleShape : "+svgSingleShape.getId()+" : "+svgSingleShape.getName());
//                            System.out.println("obj.getValue() : "+obj.getValue().getId()+" : "+obj.getValue().getName());
                            sb.append(getSVGline(obj.getValue(), svgSingleShape));
                        }
                    }
                }
            }
            for (Map.Entry<String, SVGSingleShape> obj : All_MAIN_SVG_SHAPES_AND_CONNECTORS.entrySet()) {
                if (obj.getValue() != null) {
                    sb.append(getSVGShape(obj.getValue()));
                    sb.append("\n");
                }
            }
            sb.append("</svg>");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public static void getAllModelSVGs() {
//        Map<String, String> sourceAndTarget = null;
        List<String> sourceAndTarget = null;
        List<String> childSourceAndTargets = null;
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
//                    sourceAndTarget = new TreeMap<String, String>();
                sourceAndTarget = new ArrayList<String>();
                if (obj instanceof IDiagramModelArchimateObject) {
                    IDiagramModelArchimateObject dia = (IDiagramModelArchimateObject) obj;
                    SourceConList = dia.getSourceConnections();
                    for (Object iDiModelConnObj : SourceConList) {
                        if (((IDiagramModelConnection) iDiModelConnObj).getTarget() != null) {
                            sourceAndTarget.add(((IDiagramModelConnection) iDiModelConnObj).getTarget().getId());

                        }
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
                            svgSingleShape.setFillColor(dia.getFillColor());
                            svgSingleShape.setConnections(sourceAndTarget);
//                                System.out.println(svgSingleShape.toString());
                        }
                        if (dia.getChildren() != null) {
                            childrenList = dia.getChildren();

                            for (Object childObj : childrenList) {
                                if (childObj instanceof IDiagramModelObject) {
                                    childSourceAndTargets = new ArrayList<String>();
                                    IDiagramModelObject childDia = (IDiagramModelObject) childObj;
                                    childSourceConList = childDia.getSourceConnections();
                                    for (Object iDiModelConnObj : childSourceConList) {
                                        if (((IDiagramModelConnection) iDiModelConnObj).getTarget() != null) {
                                            childSourceAndTargets.add(((IDiagramModelConnection) iDiModelConnObj).getTarget().getId());

                                        }
                                    }


                                    svgChildSingleShape = new SVGSingleShape();
                                    svgChildSingleShape.setId(childDia.getId());
                                    svgChildSingleShape.setX(childDia.getBounds().getX());
                                    svgChildSingleShape.setY(childDia.getBounds().getY());
                                    svgChildSingleShape.setWidth(childDia.getBounds().getWidth());
                                    svgChildSingleShape.setHeight(childDia.getBounds().getHeight());
                                    svgChildSingleShape.setName(childDia.getName());
                                    svgChildSingleShape.setStrokeColor(childDia.getLineColor());
                                    svgChildSingleShape.setFillColor(childDia.getFillColor());
                                    svgChildSingleShape.setConnections(childSourceAndTargets);
//                                System.out.println(svgChildSingleShape.toString());
                                    All_CHILDREN_SVG_SHAPES_AND_CONNECTORS.put(childDia.getId(), svgChildSingleShape);
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
