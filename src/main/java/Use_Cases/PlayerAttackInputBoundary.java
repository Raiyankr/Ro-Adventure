package Use_Cases;

import java.awt.*;
import java.awt.image.BufferedImage;

public interface PlayerAttackInputBoundary {
    void attack();
    void drawPlayerAttackRadius(Graphics g);
    void drawPlayerHitRadius(Graphics g);

    void updatePlayer();
    void updateMonsters();
    BufferedImage getCurrAnimation();

    void setAnimations(BufferedImage[][] animations);
    BufferedImage[][] getAnimations();
}
