import com.Farzad.utils.IOUtil.FileUtils;
import com.Farzad.utils.ImageUtils.GenerateSVG;

/**
 * Created by VOLCANO on 4/7/2017.
 */
public class mainCls {
    public static void main(String[] args) {
        try {
            String str = GenerateSVG.getModelSVGs();            System.out.println (str);            FileUtils.WriteToHTML (str);
//            XmlUtils.ReadArchiModel3();
//            XmlUtils.ReadArchiModel2();
//            XmlUtils.ReadArchiModel();
//            System.out.println(GenerateSVG2.getModelSVGs());
//            System.out.println(CryptoUtils.getSaltedPassword("FARmelody2".getBytes()));
//            XmlUtils.ReadXMLFile2();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
