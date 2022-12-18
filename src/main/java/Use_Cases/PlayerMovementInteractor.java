package Use_Cases;

import java.awt.image.BufferedImage;

public class PlayerMovementInteractor implements PlayerMovementInputBoundary {
    private PlayerMovement playerMovement;

    public PlayerMovementInteractor(PlayerMovement playerMovement) {
        this.playerMovement = playerMovement;
    }

    @Override
    public void setMovingX(int velX) {
        playerMovement.setVelX(velX);
    }
    @Override
    public void setMovingY(int velY) {
        playerMovement.setVelY(velY);
    }
    @Override
    public int getVisualX() {
        return this.playerMovement.getVisualX();
    }
    @Override
    public int getVisualY() {
        return this.playerMovement.getVisualY();
    }
    @Override
    public int getHelperX() {return this.playerMovement.getHelperX();}
    public int getHelperY() {return this.playerMovement.getHelperY();}
    @Override
    public BufferedImage getCurrAnimation() {

        return playerMovement.getCurrentImage();
    }
    @Override
    public void updateX() {
        playerMovement.updateX();
    }
    @Override
    public void updateY() {
        playerMovement.updateY();
    }

    @Override
    public void setIdleDirection(int dir) {
        playerMovement.setIdleDirection(dir);
    }


}
