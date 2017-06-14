import com.Farzad.utils.IOUtil.FileUtils;
import com.Farzad.utils.ImageUtils.GenerateSVG;
import com.archimatetool.model.IArchimateModel;
import com.archimatetool.model.IDiagramModel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.Farzad.utils.ImageUtils.ModelTools.loadModel;

/**
 * Created by VOLCANO on 4/7/2017.
 */
public class mainCls {
    public static void main(String[] args) {
        try {
//            Set<String> test = new HashSet<>();
//            test.add("6ea3e5b7");
//            getAllModelSVGs(getArchiModelFromFile(),test);
            SVGGenerator();

//            XmlUtils.ReadArchiModel3();
//            XmlUtils.ReadArchiModel2();
//            XmlUtils.ReadArchiModel();
//            System.out.println(GenerateSVG2.getModelSVGs());
//            System.out.println(CryptoUtils.getSaltedPassword("FARmelody2".getBytes()));
//            XmlUtils.ReadXMLFile2();
//            Utils.getFitLabel("hi how are you!!",2);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    private static void SVGGenerator() {
        try {

            String str = GenerateSVG.getModelSVGs(getModelFromFile());            System.out.println (str);            FileUtils.WriteToHTML (str);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    private static IArchimateModel getArchiModelFromFile() {
        IArchimateModel model = null;
        try {
//            File modelFile = new File("D:\\FAR_Documents\\__Startamap\\Archisurance.archimate");
            File modelFile = new File("D:\\FAR_Documents\\__Startamap\\eira_v1_1_0_archimate.archimate");
//            File modelFile = new File("D:\\FAR_Documents\\__Startamap\\nzta-toar.archimate");
//            File modelFile = new File("D:\\FAR_Documents\\__Startamap\\Original2.archimate");
            model = loadModel(modelFile);
            if(model !=null)
                System.out.printf("ID ---------------------> "+ model.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  model;
    }
    private static IDiagramModel getModelFromFile() {
        IDiagramModel diagramModel = null;
        try {
            List<IDiagramModel> iDModels = getArchiModelFromFile()!=null?getArchiModelFromFile().getDiagramModels():null;
            if(iDModels!=null) {
                diagramModel = iDModels.get(2);
                System.out.println(iDModels.size());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return  diagramModel;
    }
    public static List<String> getAllModelSVGs(IArchimateModel model, Set<String> iDs ) {
        List<String> SVGList = null;
        String str="";
        try {
            if(model==null || iDs ==null || iDs.size()==0) return null;
            List<IDiagramModel> iDModels = model.getDiagramModels();
            SVGList = new ArrayList<>();
            System.out.println("------"+iDs);
            for (IDiagramModel idia : iDModels) {
                System.out.println("hhhhhhhhhhhhhhh"+idia.getId());
                if (iDs.contains(idia.getId())){
                    //make svg
                    SVGList.add(GenerateSVG.getModelSVGs(idia));
                    str+=GenerateSVG.getModelSVGs(idia);
                }
            }
            System.out.println("IDModels Size : "+iDModels.size());
            FileUtils.WriteToHTML (str);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  SVGList;
    }
}
