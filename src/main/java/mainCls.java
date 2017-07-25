import com.archimatetool.model.IArchimateModel;
import com.archimatetool.model.IDiagramModel;
import com.archimatetool.model.IFolder;
import com.archimatetool.model.impl.AccessRelationship;
import com.farzad.utils.image.GenerateSVG;
import com.farzad.utils.io.FileUtils;
import org.eclipse.emf.ecore.EObject;

import java.io.File;
import java.util.*;

import static com.farzad.utils.image.ModelTools.loadModel;

/**
 * Created by VOLCANO on 4/7/2017.
 */
public class mainCls {
    private static Map<String,Integer> AllAccessRelationships = new HashMap<>();
    public static void main(String[] args) {
        try {
//            Set<String> test = new HashSet<>();
//            test.add("6ea3e5b7");
//            getAllModelSVGs(getArchiModelFromFile(),test);
            SVGGenerator();
//            System.out.println(Arrays.toString(ComUtils.findClosePointsForDrawingArc(20, 40, 30, 70)));

//            XmlUtils.ReadSingleTypeArchiModel();
//            XmlUtils.ReadArchiModel3();
//            XmlUtils.ReadArchiModel2();
//            XmlUtils.ReadArchiModel();
//            System.out.println(GenerateSVG2.getModelSVGs());
//            System.out.println(CryptoUtils.getSaltedPassword("FARmelody2".getBytes()));
//            XmlUtils.ReadXMLFile2();
//            ComUtils.getFitLabel("hi how are you!!",2);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void SVGGenerator() {
        try {
            int cnt = 0;
//            StringBuilder str = new StringBuilder();
//            for(IDiagramModel iDiagramModel: getWholeModelsFromFile()){
//                if(++cnt>90) {
//                    System.out.println("Model Nuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuber : " + cnt);
//                    str.append(GenerateSVG.getModelSVGs(iDiagramModel));
//                    if (++cnt >150) break;
//                }
//            }
            IDiagramModel model = getModelFromFile();
            String str = GenerateSVG.getModelSVGs(model,AllAccessRelationships);
            System.out.println(str);
            FileUtils.WriteToHTML(str);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static IArchimateModel getArchiModelFromFile() {
        IArchimateModel model = null;
        try {
//            File modelFile = new File("D:\\FAR_Documents\\__Startamap\\Archisurance-2.archimate");
//            File modelFile = new File("D:\\FAR_Documents\\__Startamap\\eira_v1_1_0_archimate.archimate");
//            File modelFile = new File("D:\\FAR_Documents\\__Startamap\\nzta-toar.archimate");
//            File modelFile = new File("D:\\FAR_Documents\\__Startamap\\model.archimate");
            File modelFile = new File("D:\\FAR_Documents\\__Startamap\\Original2.archimate");
//            File modelFile = new File("D:\\FAR_Documents\\__Startamap\\stratamap-test.archimate");
//            File modelFile = new File("C:\\Users\\VOLCANO\\Desktop\\old-stratamap-test.archimate");
//            File modelFile = new File("C:\\Users\\VOLCANO\\Desktop\\stratamap-test.archimate");
//            File modelFile = new File("C:\\Users\\VOLCANO\\stratamap\\test.stratamap.nz\\stratamap-test.archimate");
            model = loadModel(modelFile);
            if (model != null) {
                System.out.println(" ID ---------------------> " + model.getId());
                for (IFolder ifo : model.getFolders()) {
                    for (EObject e : ifo.getElements()){
                        if (e instanceof AccessRelationship){
                            System.out.println(" IFO ---------------------> getId" + ((AccessRelationship)e).getId());
                            System.out.println(" IFO --------------------->getName " + ((AccessRelationship)e).getName());
                            System.out.println(" IFO ---------------------> getSource " + ((AccessRelationship)e).getSource().getId());
                            System.out.println(" IFO ---------------------> getTarget " + ((AccessRelationship)e).getTarget().getId());
                            System.out.println(" IFO ---------------------> " + ((AccessRelationship)e).getAccessType());
                            AllAccessRelationships.put(((AccessRelationship)e).getId(),((AccessRelationship)e).getAccessType());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }

    private static IDiagramModel getModelFromFile() {
        IDiagramModel diagramModel = null;
        try {
            List<IDiagramModel> iDModels = getArchiModelFromFile() != null ? getArchiModelFromFile().getDiagramModels() : null;
            if (iDModels != null) {
                System.out.println(" Size of iDModels --------------------- " + iDModels.size());
                diagramModel = iDModels.get(7);
//                diagramModel = iDModels.get(18);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return diagramModel;
    }

    private static List<IDiagramModel> getWholeModelsFromFile() {
        List<IDiagramModel> iDModels = null;
        try {
            iDModels = getArchiModelFromFile() != null ? getArchiModelFromFile().getDiagramModels() : null;
            System.out.println(" Size of iDModels --------------------- " + (iDModels != null ? iDModels.size() : " 0 "));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return iDModels;
    }

    public static List<String> getAllModelSVGs(IArchimateModel model, Set<String> iDs) {
        List<String> SVGList = null;
        String str = "";
        try {
            if (model == null || iDs == null || iDs.size() == 0) return null;
            List<IDiagramModel> iDModels = model.getDiagramModels();
            SVGList = new ArrayList<>();
            System.out.println("------" + iDs);
            for (IDiagramModel idia : iDModels) {
                System.out.println("hhhhhhhhhhhhhhh" + idia.getId());
                if (iDs.contains(idia.getId())) {
                    //make svg
//                    SVGList.add(GenerateSVG.getModelSVGs(idia));
//                    str += GenerateSVG.getModelSVGs(idia);
                }
            }
            System.out.println("IDModels Size : " + iDModels.size());
            FileUtils.WriteToHTML(str);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return SVGList;
    }
}
