package Frameworks.VisualLoad;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadLevelImage {
    /**
     * This class is designated to import all the level images and returning an array of BufferedImage.
     * This is a helper class to help clean our GamePanel.
     */
    public static BufferedImage[] importImage() {
        BufferedImage[] imageList = new BufferedImage[10];

        InputStream is = LoadLevelImage.class.getResourceAsStream("/Floor1.png");
        InputStream mc = LoadLevelImage.class.getResourceAsStream("/MapCursor.png");
        InputStream mm = LoadLevelImage.class.getResourceAsStream("/Minimap.png");
        InputStream pi = LoadLevelImage.class.getResourceAsStream("/Paused.png");
        InputStream lf = LoadLevelImage.class.getResourceAsStream("/Leaf.png");
        InputStream bt = LoadLevelImage.class.getResourceAsStream("/Bushes.png");
        InputStream sb = LoadLevelImage.class.getResourceAsStream("/StatsBar.png");
        InputStream hb = LoadLevelImage.class.getResourceAsStream("/HealthBar.png");
        InputStream tp = LoadLevelImage.class.getResourceAsStream("/TimerPill.png");
        InputStream bb = LoadLevelImage.class.getResourceAsStream("/Buffbar.png");

        assert  is != null && mc != null  && mm != null  && pi != null  && lf != null  && bt != null
                &&  sb != null  && hb != null  && tp != null  && bb != null ;
        try {
            imageList[0] = ImageIO.read(is);
            imageList[1] = ImageIO.read(mc);
            imageList[2] = ImageIO.read(mm);
            imageList[3] = ImageIO.read(pi);
            imageList[4] = ImageIO.read(lf);
            imageList[5] = ImageIO.read(bt);
            imageList[6] = ImageIO.read(sb);
            imageList[7] = ImageIO.read(hb);
            imageList[8] = ImageIO.read(tp);
            imageList[9] = ImageIO.read(bb);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                mc.close();
                mm.close();
                pi.close();
                lf.close();
                bt.close();
                sb.close();
                hb.close();
                tp.close();
                bb.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return imageList;
    }
}
