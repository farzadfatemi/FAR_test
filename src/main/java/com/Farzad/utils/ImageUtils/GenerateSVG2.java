package com.Farzad.utils.ImageUtils;

/**
 * Created by VOLCANO on 4/27/2017.
 */


import POJOs.SVGSingleShape;
import com.archimatetool.model.IArchimateModel;
import com.archimatetool.model.IDiagramModel;
import com.archimatetool.model.IDiagramModelArchimateObject;
import com.archimatetool.model.IDiagramModelConnection;
import org.eclipse.emf.ecore.EObject;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

    /**
     * Created by VOLCANO on 4/21/2017.
     */
    public class GenerateSVG2 {
        public static String getSVGShape(SVGSingleShape svgShape) {
            return "<svg>"+
                    " <a xlink:href=\"https://google.com\">\n" +
                    "      <text fill=\"rgb(0,87,163)\" x=\"" + (svgShape.getX()+1) + "\" xml:space=\"preserve\" y=\"" + (svgShape.getY()+1) + "\" clip-path=\"url(#clipPath20)\" stroke=\"none\"\n" +
                    "      >"+svgShape.getName()+"</text\n" +
                    "      ><rect fill=\"rgb(0,87,163)\"  x=\"" + svgShape.getX() + "\" y=\"" + svgShape.getY() + "\" width=\"" + svgShape.getWidth() + "\" height=\"" + svgShape.getHeight() + "\" />\n" +
                    "    </a>\n" +
                    "</svg>";

        }

        private static String getSVGShapes(IDiagramModelArchimateObject diaObj) {
            String result = "";
            SVGSingleShape svgSingleShape = null;
            try {
                if (diaObj!=null && diaObj.getBounds() != null) {
                    svgSingleShape = new SVGSingleShape();
                    svgSingleShape.setX(diaObj.getBounds().getX());
                    svgSingleShape.setY(diaObj.getBounds().getY());
                    svgSingleShape.setWidth(diaObj.getBounds().getWidth());
                    svgSingleShape.setY(diaObj.getBounds().getHeight());
                    svgSingleShape.setName(diaObj.getName());
                    result =getSVGShape(svgSingleShape);
                    result+="\n";
//                    result+=getSVGline(diaObj.getli().getX());
                    result+="\n";
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return  result;
        }

        public static String getModelSVGs() {
            StringBuilder sb =new StringBuilder();

            Map<String,String> sourceAndTarget = null;
            try {
                File modelFile = new File("D:\\FAR_Documents\\__Startamap\\Original.archimate");
                IArchimateModel model = GenerateSVG.loadModel(modelFile);
                List<IDiagramModel> iDModels = model.getDiagramModels();
//            IDiagramModel diagramModel = iDModels.get(0);
                List SourceConList = null;
//            List<Map<String,String>> SHAPESOURCEANDTARGETLIST = new ArrayList<Map<String, String>>();
                for (IDiagramModel diagramModel : iDModels) {
                    sb.append("<svg width=\"100%\" height=\"100%\" >");
                    for (EObject obj : diagramModel.eContents()) {
                        sourceAndTarget = new TreeMap<String, String>();
                        if (obj instanceof IDiagramModelArchimateObject) {
                            IDiagramModelArchimateObject dia = (IDiagramModelArchimateObject) obj;
                            SourceConList = dia.getSourceConnections();
                            for(Object  iDiModelConnobj : SourceConList){
                                if(((IDiagramModelConnection)iDiModelConnobj).getSource() !=null && ((IDiagramModelConnection)iDiModelConnobj).getTarget()!=null) {
                                    sourceAndTarget.put(((IDiagramModelConnection) iDiModelConnobj).getSource().getId(), ((IDiagramModelConnection) iDiModelConnobj).getSource().getId());

                                }
                            }
                            SVGSingleShape svgSingleShape = null;
                            try {
                                if (dia.getBounds() != null) {
                                    svgSingleShape = new SVGSingleShape();
                                    svgSingleShape.setX(dia.getBounds().getX());
                                    svgSingleShape.setY(dia.getBounds().getY());
                                    svgSingleShape.setWidth(dia.getBounds().getWidth());
                                    svgSingleShape.setY(dia.getBounds().getHeight());
                                    svgSingleShape.setName(dia.getName());
//                                    svgSingleShape.setConnections(sourceAndTarget);

                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            sb.append(getSVGShapes(dia));
                        }
                    }
                    sb.append("</svg>");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return sb.toString();
        }

//        public static IArchimateModel loadModel(File modelFile) throws IOException {
//            long startTime = System.currentTimeMillis();
//            IArchimateModel model;
//            // Create the Resource
//            ArchimateResourceFactory.createResourceSet();
//            IArchimatePackage pack = IArchimatePackage.eINSTANCE;
//            Resource resource = ArchimateResourceFactory.createNewResource(modelFile);
//            // Check model compatibility
//            ModelCompatibility modelCompatibility = new ModelCompatibility(resource);
//            // Load the model file
//            Map<Object, Object> mergedOptions = new HashMap<Object, Object>();
//            // mergedOptions.put(XMLResource.OPTION_DOM_USE_NAMESPACES_IN_SCOPE,
//            // Boolean.FALSE);
//            try {
//                resource.load(FileUtils.openInputStream(modelFile), mergedOptions);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            if (!resource.isLoaded() || resource.getContents().isEmpty()) {
//                throw new IOException("Couldn't load the resource for some reason");
//            }
//            model = (IArchimateModel) resource.getContents().get(0);
//            // Once loaded - check for later model version
//            boolean isLaterModelVersion = modelCompatibility.isLaterModelVersion(ModelVersion.VERSION);
//            if (isLaterModelVersion) {
//                // TODO whats this?
//            }
//            // Check for unknown model features which might be OK to load
//            else {
//                List<Diagnostic> exceptions = modelCompatibility.getAcceptableExceptions();
//                if (!exceptions.isEmpty()) {
//                    String message = ""; //$NON-NLS-1$
//                    for (int i = 0; i < exceptions.size(); i++) {
//                        if (i == 3) {
//                            message += (exceptions.size() - 3) + " "; //$NON-NLS-1$
//                            break;
//                        }
//                        message += exceptions.get(i).getMessage() + "\n"; //$NON-NLS-1$
//                    }
//                }
//            }
//            // And then fix any backward compatibility issues
//            // try {
//            // modelCompatibility.fixCompatibility ();
//            // } catch (CompatibilityHandlerException ex) {
//            // }
//            model.setFile(modelFile);
//            model.setDefaults();
//            long endTime = System.currentTimeMillis();
//            System.out.println("Models loaded " + (endTime - startTime) + "ms");
//            return model;
//        }

    }

