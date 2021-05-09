import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;

import java.io.File;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        String path = "C:\\Users\\Dmitriy\\Desktop\\For article.docx";
        String pathImgRep = "C:\\Users\\Dmitriy\\Spring\\Article\\pict.jpg";
        String pathImgCont = "C:\\Users\\Dmitriy\\Spring\\Article\\control.jpg";
        File fileImgRep = new File(pathImgRep);
        File fileImgCont = new File(pathImgCont);


        FileReader fileReader = new FileReader();
        List<String> lines = fileReader.readFile(path);
        XWPFDocument document = fileReader.getDocument(path);

        StringFinder stringFinder = new StringFinder();
        System.out.println(stringFinder.findString(TestNumber.М11.toString(), lines));

        FileReader fileReader1 = new FileReader();
        List<XWPFPictureData> lines1 = fileReader1.readPictureFromFile(path, 3, 5);
        System.out.println(lines1);

        ImgFinder imgFinder = new ImgFinder();
        imgFinder.findImg(document);

        ImgComparator imgComparator = new ImgComparator();
        System.out.println(imgComparator.compareImg(fileImgRep, fileImgCont));



    }
}
