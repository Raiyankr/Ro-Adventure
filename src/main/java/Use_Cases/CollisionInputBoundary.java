package Use_Cases;

import java.util.ArrayList;

public interface CollisionInputBoundary {

    void updateWalls(int x, int y);
    boolean movable(int currX, int currY, int changeX, int changeY, int width, int height);


}
