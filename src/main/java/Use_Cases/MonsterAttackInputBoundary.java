package Use_Cases;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public interface MonsterAttackInputBoundary {
    void attack();

    BufferedImage getCurrAttackHitAnimation();

    void drawMonstersHitRadius(Graphics g);
    void drawMonstersAttackRadius(Graphics g);

    BufferedImage getCurrAnimation();

    void setAnimations(BufferedImage[][] animations);
    BufferedImage[][] getAnimations();
}
