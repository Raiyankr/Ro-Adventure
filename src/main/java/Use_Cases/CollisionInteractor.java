package Use_Cases;
import java.util.ArrayList;

public class CollisionInteractor implements CollisionInputBoundary{
    Collision collision;
    public CollisionInteractor(Collision collision) {
        this.collision = collision;
    }

    @Override
    public void updateWalls(int x, int y) {
        collision.createWallLayout(x, y);
    }
    @Override
    public boolean movable(int currX, int currY, int changeX, int changeY, int width, int height) {
        return collision.moveAbleWall(currX, currY, changeX, changeY, width, height);
    }
}
