package Use_Cases;

import java.awt.image.BufferedImage;

public interface PlayerMovementInputBoundary {
    void rightActivator();
    void leftActivator();
    void upActivator();
    void downActivator();
    void rightDeactivator();
    void leftDeactivator();
    void upDeactivator();
    void downDeactivator();
    int getHelperX();
    int getHelperY();
    int getVelX();
    int getVelY();
    int getVisualX();
    int getVisualY();
    BufferedImage getCurrAnimation();
    void updateX();
    void updateY();
    void setIdleDirection(int dir);
    void setAnimations(BufferedImage[][] animations);
    BufferedImage[][] getAnimations();
    void updateHelper();
}