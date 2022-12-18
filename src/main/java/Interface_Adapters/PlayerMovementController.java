package Interface_Adapters;

import Use_Cases.PlayerMovementInputBoundary;


import java.awt.image.BufferedImage;

public class PlayerMovementController {
    PlayerMovementInputBoundary playerMovementInputBoundary;
    CollisionController collisionController;
    private int saveVelX, saveVelY;

    public PlayerMovementController(PlayerMovementInputBoundary playerMovementInputBoundary, CollisionController collisionController) {
        this.playerMovementInputBoundary = playerMovementInputBoundary;
        this.collisionController = collisionController;
    }

    public void update() {
        if (collisionController.movable(getVisualX(),getVisualY(), 628, 338, -saveVelX, 0, 24, 24)) {
            playerMovementInputBoundary.updateX();
        }
        if (collisionController.movable(getVisualX(),getVisualY(), 628, 338, 0, -saveVelY, 24, 24)) {
            playerMovementInputBoundary.updateY();
        }
    }

    public int getVisualX() {
        return playerMovementInputBoundary.getVisualX();
    }
    public int getVisualY() {
        return playerMovementInputBoundary.getVisualY();
    }
    public int getHelperX() {
        return playerMovementInputBoundary.getHelperX();
    }
    public int getHelperY() {
        return playerMovementInputBoundary.getHelperY();
    }
    public BufferedImage getCurrAnimation() {
        return playerMovementInputBoundary.getCurrAnimation();
    }
    public void setIdleDirection(int dir) {
        playerMovementInputBoundary.setIdleDirection(dir);
    }
    //Must check if it is possible to move before moving
    public void playerMoveX(int velX) {
        this.saveVelX = velX;
        playerMovementInputBoundary.setMovingX(velX);
    }
    public void playerMoveY(int velY) {
        this.saveVelY = velY;
        playerMovementInputBoundary.setMovingY(velY);

    }

}
