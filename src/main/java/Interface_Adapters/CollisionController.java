package Interface_Adapters;

import Use_Cases.CollisionInputBoundary;

import java.util.ArrayList;

/**
 * Allows the entities to collide with each other and the wall
 */
public class CollisionController {
    CollisionInputBoundary collisionInputBoundary;
    /**
     * Creates the collision controller for us to check
     * whether any of the objects collide with each other
     * @param collisionInputBoundary: Allows us to access the interactor from controller
     */
    public CollisionController(CollisionInputBoundary collisionInputBoundary) {
        this.collisionInputBoundary = collisionInputBoundary;
    }

    /**
     * Checks if there is any wall collision
     * @param visualX: x location of the map
     * @param visualY: y location of the map
     * @param currX: current x of object that we want to move
     * @param currY: current y of object that we want to move
     * @param changeX: how much we want to change x by
     * @param changeY: how much we want to change y by
     * @param width: width of the object
     * @param height: height of the object
     * @return true iff the object can move to the new location
     */
    public boolean movable(int visualX, int visualY, int currX, int currY, int changeX, int changeY, int width, int height) {
        collisionInputBoundary.updateWalls(visualX, visualY);
        return collisionInputBoundary.movable(currX, currY, changeX, changeY, width, height);
    }
    /*    public boolean moveAbleEnemies() {}*/
}