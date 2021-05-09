import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;


import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Iterator;
import java.util.List;

public class ImgFinder {


    public void findImg (XWPFDocument document) {
        List lst = document.getAllPictures();
        for (Iterator i = lst.iterator(); i.hasNext(); ) {
            XWPFPictureData picture = (XWPFPictureData) i.next();
            String sug = picture.suggestFileExtension();
            byte[] pictureGet = picture.getData();
            if (sug.equals("jpeg")) {
                FileOutputStream stream = null;
                try {
                    stream = new FileOutputStream("pict.jpg");
                    stream.write(pictureGet);
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
