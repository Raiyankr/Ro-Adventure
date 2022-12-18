package Use_Cases;

import java.awt.*;
import java.util.ArrayList;

public abstract class Movement {

    public abstract void updateX();
    public abstract void updateY();
    public abstract int getVisualX();
    public abstract int getVisualY();
    public abstract int getHelperX();
    public abstract int getHelperY();
}
