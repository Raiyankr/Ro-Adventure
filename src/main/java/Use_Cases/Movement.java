package Use_Cases;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Movement {
    public abstract int getVisualX();
    public abstract int getVisualY();
    public abstract int getHelperX();
    public abstract int getHelperY();
    public abstract void setAnimations(BufferedImage[][] animations);
    public abstract BufferedImage[][] getAnimations();
}
