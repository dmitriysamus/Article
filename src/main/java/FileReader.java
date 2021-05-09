import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPicture;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public List<String> readFile (String path) {
        List<String> lines = new ArrayList<>();
        File docxFile = new File(path);
        FileInputStream fileInputStream = null;
        XWPFDocument xwpfDocument = null;
        try {
            fileInputStream = new FileInputStream(docxFile.getAbsolutePath());
            xwpfDocument = new XWPFDocument(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<XWPFParagraph> paragraphs = xwpfDocument.getParagraphs();

        for (XWPFParagraph p : paragraphs) {
            lines.add(p.getText());
        }
        return lines;

    }

    public XWPFDocument getDocument (String path) {
        File docxFile = new File(path);
        FileInputStream fileInputStream = null;
        XWPFDocument xwpfDocument = null;
        try {
            fileInputStream = new FileInputStream(docxFile.getAbsolutePath());
            xwpfDocument = new XWPFDocument(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xwpfDocument;
    }

    public List<XWPFPictureData> readPictureFromFile (String path, int positionStart, int positionEnd) {
        List<XWPFPictureData> lines = new ArrayList<>();
        FileReader fileReader = new FileReader();
        XWPFDocument xwpfDocument = fileReader.getDocument(path);

        List<XWPFParagraph> paragraphs = xwpfDocument.getParagraphs();

        XWPFDocument sum = null;

        for (int x = positionStart; x <= positionEnd; x = x + 1) {
            List <XWPFPictureData> par = paragraphs.get(x).getDocument().getAllPictures();
            try {
                CTPicture ctPicture = CTPicture.Factory.parse(paragraphs.get(x).getCTP().toString());
                System.out.println(ctPicture);
            } catch (XmlException e) {
                e.printStackTrace();
            }

            lines.addAll(par);


        }

        return lines;

    }


}
