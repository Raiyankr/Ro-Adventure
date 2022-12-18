package Use_Cases.CollisionUseCases;

/**
 * Passes on the information from controller to the collision class
 */
public class CollisionInteractor implements CollisionInputBoundary{
    Collision collision;
    public CollisionInteractor(Collision collision) {
        this.collision = collision;
    }

    /**
     * updates the current walls to match the map x and y
     * @param x: current map x
     * @param y: current map y
     */
    @Override
    public void updateWalls(int x, int y) {
        collision.createWallLayout(x, y);
    }
    @Override
    public boolean movable(int currX, int currY, int changeX, int changeY, int width, int height) {
        return collision.moveAbleWall(currX, currY, changeX, changeY, width, height);
    }
}
