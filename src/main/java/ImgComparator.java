import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;

public class ImgComparator {


    public float compareImg (File report, File control) {

        float percent = 0;
        try {
            BufferedImage img1 = ImageIO.read(report);
            DataBuffer dataBuffer1 = img1.getData().getDataBuffer();
            int size1 = dataBuffer1.getSize();
            BufferedImage img2 = ImageIO.read(control);
            DataBuffer dataBuffer2 = img2.getData().getDataBuffer();
            int size2 = dataBuffer2.getSize();
            int count = 0;
            if (size1 == size2) {

                for (int i = 0; i < size1; i++) {

                    if (dataBuffer1.getElem(i) == dataBuffer2.getElem(i)) {
                        count = count + 1;
                    }

                }
                percent = (count * 100) / size1;
            } else {
                System.out.println("Изображения имеют разный размер");
            }

        } catch (Exception e) {
            System.out.println("Не удалось сравнить изображения ...");
        }
        return percent;
    }

}
