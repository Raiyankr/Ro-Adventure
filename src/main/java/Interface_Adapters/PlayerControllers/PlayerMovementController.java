package Interface_Adapters.PlayerControllers;

import Interface_Adapters.CollisionControllers.CollisionController;
import Use_Cases.PlayerUseCases.PlayerMovementInputBoundary;

import java.awt.image.BufferedImage;
/**
 * This packs all the information for movement and passes it onto the interactor
 */
public class PlayerMovementController {
    PlayerMovementInputBoundary playerMovementInputBoundary;
    CollisionController collisionController;
    private boolean collide = false;
    /**
     * Connects the player movement controller to collision controller and all the enemy controller
     * Because we are working with those controllers
     */
    public PlayerMovementController(PlayerMovementInputBoundary playerMovementInputBoundary,
                                    CollisionController collisionController) {
        this.playerMovementInputBoundary = playerMovementInputBoundary;
        this.collisionController = collisionController;
    }
    /**
     * Update method will update the player movement every tick of game loop.
     * It checks for collision by calling the collision controller, and then sets a velocity
     */
    public void update() {

        playerMovementInputBoundary.updateHelper();
        if (getMoveableWall(getVisualX(), getVisualY(), -playerMovementInputBoundary.getVelX(), 0)) {
            playerMovementInputBoundary.updateX();
        }
        if (getMoveableWall(getVisualX(), getVisualY(), 0, -playerMovementInputBoundary.getVelY())) {
            playerMovementInputBoundary.updateY();
        }
    }

    /**
     * Calls the collision controller for player movement
     * @param visualX: current x location on the map relative
     * @param visualY: current y location on the map relative
     * @param changeX: how much we want to change x by
     * @param changeY: how much we want to change y by
     * @return: return true iff  player is not touching the wall
     */
    public boolean getMoveableWall(int visualX, int visualY, int changeX, int changeY) {

        return collisionController.movable(visualX, visualY, 628, 338, changeX, changeY, 24, 24);
    }
/*    public boolean getMoveableEnemies() {

    }*/

    /**
     * @return the x coordinate that we need to present the player
     */
    public int getVisualX() {
        return playerMovementInputBoundary.getVisualX();
    }

    /**
     * @return the y coordinate that we need to present the player
     */
    public int getVisualY() {
        return playerMovementInputBoundary.getVisualY();
    }

    /**
     * @return the absolute x coordinate of the player relative to the left corner of the map
     */
    public int getHelperX() {
        return playerMovementInputBoundary.getHelperX();
    }

    /**
     * @return the absolute y coordinate of the player relative to the left corner of the map
     */
    public int getHelperY() {
        return playerMovementInputBoundary.getHelperY();
    }
    public int getVelX() {
        return playerMovementInputBoundary.getVelX();
    }
    public int getVelY() {
        return playerMovementInputBoundary.getVelY();
    }
    /**
     * @return the current sprite image that is on display
     */
    public BufferedImage getCurrAnimation() {
        return playerMovementInputBoundary.getCurrAnimation();
    }

    /**
     *  passes in the animations to the interactor
     * @param animations: the sprite list for enemy movement
     */
    public void setAnimations(BufferedImage[][] animations) {
        playerMovementInputBoundary.setAnimations(animations);
    }

    /**
     * @return a list all the animations sprites
     */
    public BufferedImage[][] getAnimations() {
        return playerMovementInputBoundary.getAnimations();
    }
    /**
     * @param dir: the direction that the player looked at when it stopped moving
     */
    public void setIdleDirection(int dir) {
        playerMovementInputBoundary.setIdleDirection(dir);
    }

    /**
     * These are activators that activate whether or not player is moving
     * and which direction it is moving in.
     * We also need to deactivate it if it is moving or its opposite direction gets activated.
     */
    public void rightActivator() {
        playerMovementInputBoundary.rightActivator();
    }
    public void leftActivator() {
        playerMovementInputBoundary.leftActivator();
    }
    public void upActivator() {
        playerMovementInputBoundary.upActivator();
    }
    public void downActivator() {
        playerMovementInputBoundary.downActivator();
    }
    public void rightDeactivator() {
        playerMovementInputBoundary.rightDeactivator();
    }
    public void leftDeactivator() {
        playerMovementInputBoundary.leftDeactivator();
    }
    public void upDeactivator() {
        playerMovementInputBoundary.upDeactivator();
    }
    public void downDeactivator() {
        playerMovementInputBoundary.downDeactivator();
    }
}