package com.Farzad.utils.ImageUtils;


import POJOs.SVGSingleShape;
import com.archimatetool.model.*;
import org.eclipse.emf.ecore.EObject;

import java.io.File;
import java.util.*;

import static com.Farzad.utils.ImageUtils.ConnectionTools.getFirstLastDim;
import static com.Farzad.utils.ImageUtils.ConnectionTools.getSVGline;
import static com.Farzad.utils.ImageUtils.ModelTools.loadModel;
import static com.Farzad.utils.ImageUtils.ShapeTools.getSVGShape;

/**
 * Created by VOLCANO on 4/21/2017.
 */
public class GenerateSVG {
//    private static Map<String, SVGSingleShape> All_MAIN_SVG_SHAPES_AND_CONNECTORS = new HashMap<>();
    private static List<SVGSingleShape> All_MAIN_SVG_SHAPES_AND_CONNECTORS = new ArrayList<>();
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
        StringBuilder sb2 = new StringBuilder();
        try {
            for( SVGSingleShape svgSingle  : All_MAIN_SVG_SHAPES_AND_CONNECTORS ){
                sb.append(getSVGShape(svgSingle));
                sb.append("\n");
            };


            for (Map.Entry<SVGSingleShape, SVGSingleShape> obj : All_CONNECTIONS.entrySet()) {
//                System.out.println("---------< Srouce ID : "+ obj.getKey().getId());
//                System.out.println("---------< Target ID : "+ obj.getValue().getId());
                sb.append(getSVGline(obj.getKey(), obj.getValue()));
            }
            int[] FirstLastXY = getFirstLastDim();
            System.out.println("======---00000000----   FIRST_X : " + FirstLastXY[0]  + " | FIRST_Y" + FirstLastXY[1]  + " | LAST_X" + FirstLastXY[2] + "  | LAST_Y" + FirstLastXY[3]);
//            sb.append("<svg width=\"100%\" height=\"auto\"  viewBox=\"" + (FIRST_X - 10) + " " + (FIRST_Y - 10) + " " + (Math.abs(FIRST_X) + LAST_X + 30) + " " + (Math.abs(FIRST_Y) + LAST_Y + 30) + " \">");
            sb2.append("<svg width=\"100%\" height=\"100%\">\n");
            sb2.append("<g transform=\"translate(").append(Math.abs(FirstLastXY[0]) ).append(",").append(Math.abs(FirstLastXY[1]) ).append(") \">\n");
            sb2.append(sb.toString());
//            int cnt=0;
//            for(Map.Entry<String, SVGSingleShape> s : All_MAIN_SVG_SHAPES_AND_CONNECTORS.entrySet()){
//                cnt++;
//                System.out.println(cnt+" ------ tam "+s.getValue().getName());
//            };



//            All_GROUP_SVG_SHAPES_AND_CONNECTORS.entrySet().stream().filter(obj -> obj.getValue() != null).forEachOrdered(obj -> {
//                sb.append(getSVGShape(obj.getValue()));
//                sb.append("\n");
//            });
//            All_MAIN_SVG_SHAPES_AND_CONNECTORS.entrySet().stream().filter(obj -> obj.getValue() != null).forEachOrdered(obj -> {
//                sb.append(getSVGShape(obj.getValue()));
//                sb.append("\n");
//            });



            sb2.append(" </g>");
            sb2.append("</svg>");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb2.toString();
    }



   


    private static void getAllModelSVGs() {
        try {
//            File modelFile = new File("D:\\FAR_Documents\\__Startamap\\Archisurance.archimate");
            File modelFile = new File("D:\\FAR_Documents\\__Startamap\\eira_v1_1_0_archimate.archimate");
//            File modelFile = new File("D:\\FAR_Documents\\__Startamap\\nzta-toar.archimate");
//            File modelFile = new File("D:\\FAR_Documents\\__Startamap\\Original2.archimate");
            IArchimateModel model = loadModel(modelFile);
            List<IDiagramModel> iDModels = model.getDiagramModels();
            IDiagramModel diagramModel = iDModels.get(4);
            System.out.println(iDModels.size());
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



        } catch (Exception e) {
            e.printStackTrace();
        }

    } 
    
    private static void getSingleModels(EObject diagramCpt) {
        boolean addObj = false;
        String objName = "-";
        Map<String, String> sourceAndTarget = new HashMap<String, String>();
        List SourceConList = null;
        SVGSingleShape svgSingleShape = null;
        SVGSingleShape svgChildSingleShape = null;
        int makeUniqueID = 0;
        int makeUniqueIDChild = 0;
        if (diagramCpt instanceof IDiagramModelGroup) {
            // Add any child elements to this root
            IDiagramModelGroup modelGrp = (IDiagramModelGroup) diagramCpt;
            System.out.println("-4---4- " + modelGrp.getName());
            if (modelGrp.getBounds() != null) {
                System.out.println(" X : " + modelGrp.getBounds().getX() + " | Y " + modelGrp.getBounds().getY() + " Width : " + modelGrp.getBounds().getWidth() + " | Height " + modelGrp.getBounds().getHeight() + "--  ---");
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
//            System.out.println("======---00000000----   " + FIRST_X + " " + FIRST_Y + " " + LAST_X + " " + LAST_Y);
//            System.out.println("======---33333333----   " + modelGrp.getBounds().getX() + " " + modelGrp.getBounds().getY() + " " + (modelGrp.getBounds().getX() + modelGrp.getBounds().getWidth()) + " " + (modelGrp.getBounds().getY() + modelGrp.getBounds().getHeight()));
//            if (FIRST_X > modelGrp.getBounds().getX())
//                FIRST_X = modelGrp.getBounds().getX();
//            if (FIRST_Y > modelGrp.getBounds().getY())
//                FIRST_Y = modelGrp.getBounds().getY();
//            if (LAST_X < modelGrp.getBounds().getX() + modelGrp.getBounds().getWidth())
//                LAST_X = modelGrp.getBounds().getX() + modelGrp.getBounds().getWidth();
//            if (LAST_Y < modelGrp.getBounds().getY() + modelGrp.getBounds().getHeight())
//                LAST_Y = modelGrp.getBounds().getY() + modelGrp.getBounds().getHeight();
//            System.out.println("======---444444444----   " + FIRST_X + " " + FIRST_Y + " " + LAST_X + " " + LAST_Y);
            EObject parentObject = modelGrp.eContainer();
            int finalX = modelGrp.getBounds().getX(), finalY = modelGrp.getBounds().getY();
//            if (parentObject instanceof IDiagramModelArchimateObject) {

            while (true) {
                if (parentObject != null) {
                    if (parentObject instanceof IDiagramModelArchimateObject) {
                        if (((IDiagramModelArchimateObject) parentObject).getBounds() != null) {
                            finalX += ((IDiagramModelArchimateObject) parentObject).getBounds().getX();
                            finalY += ((IDiagramModelArchimateObject) parentObject).getBounds().getY() ;
                        }
                    } else if (parentObject instanceof IDiagramModelGroup) {
                        if (((IDiagramModelGroup) parentObject).getBounds() != null) {
                            finalX += ((IDiagramModelGroup) parentObject).getBounds().getX();
                            finalY += ((IDiagramModelGroup) parentObject).getBounds().getY() ;
                        }
                    }
                } else {
                    break;
                }
                parentObject = parentObject.eContainer();
            }
//            } else if (parentObject instanceof IDiagramModelGroup) {
//                if (((IDiagramModelGroup) parentObject).getBounds() != null) {
//                    finalX = ((IDiagramModelGroup) parentObject).getBounds().getX() + modelGrp.getBounds().getX();
//                    finalY = ((IDiagramModelGroup) parentObject).getBounds().getY() + modelGrp.getBounds().getY();
//                }
//            }

            System.out.println("**##--> " + finalX + " Final Y " + finalY + " child X : " + modelGrp.getBounds().getX() + " child Y : " + modelGrp.getBounds().getY());

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
            All_MAIN_SVG_SHAPES_AND_CONNECTORS.add(svgSingleShape);
//            All_MAIN_SVG_SHAPES_AND_CONNECTORS.put(modelGrp.getId(), svgSingleShape);


        } else if (diagramCpt instanceof IDiagramModelArchimateObject) {
            IDiagramModelArchimateObject modelObj = (IDiagramModelArchimateObject) diagramCpt;
            System.out.println("-4---4--4 " + modelObj.getName());
            if (modelObj.getBounds() != null) {
                System.out.println(" X : " + modelObj.getBounds().getX() + " | Y " + modelObj.getBounds().getY() + " Width : " + modelObj.getBounds().getWidth() + " | Height " + modelObj.getBounds().getHeight() + "--  ---");
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

//                finalX = deepSearchForXY(parentObject,finalX,finalY)[0];
//                finalY = deepSearchForXY(parentObject,finalX,finalY)[1];
                
                while (true) {
                    if (parentObject != null) {
                        if (parentObject instanceof IDiagramModelGroup) {
                            if (((IDiagramModelGroup) parentObject).getBounds() != null) {
                                finalX += ((IDiagramModelGroup) parentObject).getBounds().getX();
                                finalY += ((IDiagramModelGroup) parentObject).getBounds().getY() ;
                            }
                        } else if (parentObject instanceof IDiagramModelArchimateObject) {
                            if (((IDiagramModelArchimateObject) parentObject).getBounds() != null) {
                                finalX += ((IDiagramModelArchimateObject) parentObject).getBounds().getX();
                                finalY += ((IDiagramModelArchimateObject) parentObject).getBounds().getY() ;
                            }
                        }
                    } else {
                        break;
                    }
                    parentObject = parentObject.eContainer();
                }






//                if (parentObject instanceof IDiagramModelArchimateObject) {
//                    if (((IDiagramModelArchimateObject) parentObject).getBounds() != null) {
//                        finalX = ((IDiagramModelArchimateObject) parentObject).getBounds().getX() + modelObj.getBounds().getX();
//                        finalY = ((IDiagramModelArchimateObject) parentObject).getBounds().getY() + modelObj.getBounds().getY();
//                        System.out.println("===================== Parent X : " + ((IDiagramModelArchimateObject) parentObject).getBounds().getX());
//                        System.out.println("===================== Parent Y : " + ((IDiagramModelArchimateObject) parentObject).getBounds().getY());
//                    }
//                    System.out.println("===================== Parent Name : " + ((IDiagramModelArchimateObject) parentObject).getName());
//                    System.out.println("===================== Child Name : " + modelObj.getName());
//                    System.out.println("===================== Total X  : " + finalX + " Parent X  : " + ((IDiagramModelArchimateObject) parentObject).getBounds().getX() + " Child X " + modelObj.getBounds().getX());
//                    System.out.println("===================== Total Y  : " + finalY + " Parent Y  : " + ((IDiagramModelArchimateObject) parentObject).getBounds().getY() + " Child Y " + modelObj.getBounds().getY());
//                } else if (parentObject instanceof IDiagramModelGroup) {
//                    if (((IDiagramModelGroup) parentObject).getBounds() != null) {
//                        finalX = ((IDiagramModelGroup) parentObject).getBounds().getX() + modelObj.getBounds().getX();
//                        finalY = ((IDiagramModelGroup) parentObject).getBounds().getY() + modelObj.getBounds().getY();
//                    }
//                    System.out.println("===================== Name : " + ((IDiagramModelGroup) parentObject).getName());
//                    System.out.println("===================== Child Name : " + modelObj.getName());
//                    System.out.println("===================== Total X  : " + finalX + " Parent X  : " + ((IDiagramModelGroup) parentObject).getBounds().getX() + " Child X " + modelObj.getBounds().getX());
//                    System.out.println("===================== Total Y  : " + finalY + " Parent Y  : " + ((IDiagramModelGroup) parentObject).getBounds().getY() + " Child Y " + modelObj.getBounds().getY());
//                }

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

            System.out.println( " ------ pam "+modelObj.getName());
//            All_MAIN_SVG_SHAPES_AND_CONNECTORS.put(modelObj.getId(), svgSingleShape);
            All_MAIN_SVG_SHAPES_AND_CONNECTORS.add( svgSingleShape);

        } else if (diagramCpt instanceof IDiagramModelArchimateConnection) {
            List<BendPoints> bindPointsList = null;
            // Add any child elements to this root
            IDiagramModelArchimateConnection modelConn = (IDiagramModelArchimateConnection) diagramCpt;
            int finalSourceX = modelConn.getSource().getBounds().getX();
            int finalSourceY = modelConn.getSource().getBounds().getY();
            int finalTargetX = modelConn.getTarget().getBounds().getX();
            int finalTargetY = modelConn.getTarget().getBounds().getY();
            EObject parentObject = modelConn.getSource().eContainer();


//            finalSourceX = deepSearchForXY(parentObject,finalSourceX,finalSourceY)[0];
//            finalSourceY = deepSearchForXY(parentObject,finalSourceX,finalSourceY)[1];

            while (true) {
                if (parentObject != null) {
                    if (parentObject instanceof IDiagramModelGroup) {
                        if (((IDiagramModelGroup) parentObject).getBounds() != null) {
                            finalSourceX += ((IDiagramModelGroup) parentObject).getBounds().getX();
                            finalSourceY += ((IDiagramModelGroup) parentObject).getBounds().getY();
                        }
                    } else if (parentObject instanceof IDiagramModelArchimateObject) {
                        if (((IDiagramModelArchimateObject) parentObject).getBounds() != null) {
                            finalSourceX += ((IDiagramModelArchimateObject) parentObject).getBounds().getX();
                            finalSourceY += ((IDiagramModelArchimateObject) parentObject).getBounds().getY() ;
                        }
                    }
                } else {
                    break;
                }
                parentObject = parentObject.eContainer();
            }





//            if (parentObject instanceof IDiagramModelArchimateObject) {
//                if (((IDiagramModelArchimateObject) parentObject).getBounds() != null) {
//                    finalSourceX = ((IDiagramModelArchimateObject) parentObject).getBounds().getX() + modelConn.getSource().getBounds().getX();
//                    finalSourceY = ((IDiagramModelArchimateObject) parentObject).getBounds().getY() + modelConn.getSource().getBounds().getY();
//                }
//            } else if (parentObject instanceof IDiagramModelGroup) {
//                if (((IDiagramModelGroup) parentObject).getBounds() != null) {
//                    finalSourceX = ((IDiagramModelGroup) parentObject).getBounds().getX() + modelConn.getSource().getBounds().getX();
//                    finalSourceY = ((IDiagramModelGroup) parentObject).getBounds().getY() + modelConn.getSource().getBounds().getY();
//                }
//            }


            System.out.println("=Connection=========== finalSourceX    : " + finalSourceX + " Child X " + modelConn.getSource().getBounds().getX());
            System.out.println("=Connection========== finalSourceY   : " + finalSourceY + " Child Y " + modelConn.getSource().getBounds().getY());


            parentObject = modelConn.getTarget().eContainer();
            System.out.println("aaaaaaaaaaaaayyyyyyyyy" + parentObject.getClass().getSimpleName());

//            finalTargetX = deepSearchForXY(parentObject,finalTargetX,finalTargetY)[0];
//            finalTargetY = deepSearchForXY(parentObject,finalTargetX,finalTargetY)[1];
            while (true) {
                if (parentObject != null) {
                    if (parentObject instanceof IDiagramModelGroup) {
                        if (((IDiagramModelGroup) parentObject).getBounds() != null) {
                            finalTargetX += ((IDiagramModelGroup) parentObject).getBounds().getX();
                            finalTargetY += ((IDiagramModelGroup) parentObject).getBounds().getY();
                        }
                    } else if (parentObject instanceof IDiagramModelArchimateObject) {
                        if (((IDiagramModelArchimateObject) parentObject).getBounds() != null) {
                            finalTargetX += ((IDiagramModelArchimateObject) parentObject).getBounds().getX();
                            finalTargetY += ((IDiagramModelArchimateObject) parentObject).getBounds().getY() ;
                        }
                    }
                } else {
                    break;
                }
                parentObject = parentObject.eContainer();
            }



            if (FIRST_X >finalSourceX)
                FIRST_X = finalSourceX;
            if (FIRST_Y >finalSourceY)
                FIRST_Y = finalSourceY;
            if (LAST_X < finalTargetX)
                LAST_X = finalTargetX;
            if (LAST_Y <finalTargetY)
                LAST_Y = finalTargetY;
            System.out.println("======---222222222----   " + FIRST_X + " " + FIRST_Y + " " + LAST_X + " " + LAST_Y);

            System.out.println("=Connection=========== finalTargetX    : " + finalTargetX + " Child X " + modelConn.getTarget().getBounds().getX());
            System.out.println("=Connection========== finalTargetY   : " + finalTargetY + " Child Y " + modelConn.getTarget().getBounds().getY());

            try {
                if (modelConn.getSource() != null && modelConn.getTarget() != null) {

                    System.out.println("Model Conn - Source Name & ID : ----------- > " + modelConn.getSource().getName() + " | " + modelConn.getSource().getId());
                    System.out.println("Model Conn - Target Name & ID : ----------- > " + modelConn.getTarget().getName() + " | " + modelConn.getTarget().getId());

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
                            + " | Source Y " + modelConn.getSource().getBounds().getY()
                    );
                    for (IDiagramModelBendpoint e : modelConn.getBendpoints()) {
                        System.out.println(" | Bend Points e.getStartX() " + e.getStartX() + " | StartY() " + e.getStartY() + " | getEndX() " + e.getEndX() + " | getEndY() " + e.getEndY());
                        BendPoints bendPoints = new BendPoints();
                        bendPoints.setStartX(e.getStartX());
                        bendPoints.setStartY(e.getStartY());
//                        bendPoints.setStartX(e.getStartX()+ modelConn.getSource().getBounds().getX());
//                        bendPoints.setStartY(e.getStartY()+ modelConn.getSource().getBounds().getY());
                        bendPoints.setEndX(e.getEndX());
                        bendPoints.setEndY(e.getEndY());
                        bindPointsList.add(bendPoints);

//                        if (FIRST_X > e.getStartX())
//                            FIRST_X = e.getStartX();
//                        if (FIRST_Y > e.getStartY())
//                            FIRST_Y =  e.getStartY();
//                        if (LAST_X < e.getEndX())
//                            LAST_X = e.getEndX();
//                        if (LAST_Y < e.getEndY())
//                            LAST_Y =  e.getEndY();
//                        System.out.println("======---222222222----   " + FIRST_X + " " + FIRST_Y + " " + LAST_X + " " + LAST_Y);

                    }
                    svgSourceShape.setConnectionBendPointsList(bindPointsList);
                    System.out.println("Model Conn - Connection Coord : ----------- > Target X " + modelConn.getTarget().getBounds().getX()
                            + " | Target Y " + modelConn.getTarget().getBounds().getY()
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
    
    private static int[] deepSearchForXY(EObject parentObject, int finalX, int finalY){
        int[] i = new int[2];
        while (true) {
            if (parentObject != null) {
                if (parentObject instanceof IDiagramModelGroup) {
                    if (((IDiagramModelGroup) parentObject).getBounds() != null) {
                        finalX += ((IDiagramModelGroup) parentObject).getBounds().getX();
                        finalY += ((IDiagramModelGroup) parentObject).getBounds().getY();
                    }
                } else if (parentObject instanceof IDiagramModelArchimateObject) {
                    if (((IDiagramModelArchimateObject) parentObject).getBounds() != null) {
                        finalX += ((IDiagramModelArchimateObject) parentObject).getBounds().getX();
                        finalY += ((IDiagramModelArchimateObject) parentObject).getBounds().getY() ;
                    }
                }
            } else {
                break;
            }
            parentObject = parentObject.eContainer();
        }
        i[0]= finalX;
        i[1]=finalY;
        return i;
    }
}
