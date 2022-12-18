package Use_Cases.CollisionUseCases;

public interface CollisionInputBoundary {

    void updateWalls(int x, int y);
    boolean movable(int currX, int currY, int changeX, int changeY, int width, int height);

}
