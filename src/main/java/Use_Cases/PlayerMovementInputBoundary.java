package Use_Cases;

import java.awt.image.BufferedImage;

public interface PlayerMovementInputBoundary {
    void setMovingX(int velX);
    void setMovingY(int velY);
    int getHelperX();
    int getHelperY();
    int getVisualX();
    int getVisualY();
    BufferedImage getCurrAnimation();
    void updateX();
    void updateY();
    void setIdleDirection(int dir);
}
