import com.Farzad.utils.ImageUtils.GenerateSVG;

/**
 * Created by VOLCANO on 4/7/2017.
 */
public class mainCls {
    public static void main(String[] args) {
        try {
            System.out.println(GenerateSVG.getModelSVGs());
//            System.out.println(GenerateSVG2.getModelSVGs());
//            System.out.println(CryptoUtils.getSaltedPassword("FARmelody2".getBytes()));
//            XmlUtils.ReadXMLFile2();
//            XmlUtils.ReadArchiModel();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
