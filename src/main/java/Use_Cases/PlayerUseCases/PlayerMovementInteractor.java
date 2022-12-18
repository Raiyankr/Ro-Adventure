package Use_Cases.PlayerUseCases;

import java.awt.image.BufferedImage;

public class PlayerMovementInteractor implements PlayerMovementInputBoundary {
    private PlayerMovement playerMovement;
    public PlayerMovementInteractor(PlayerMovement playerMovement) {
        this.playerMovement = playerMovement;
    }


    @Override
    public void rightActivator() {
        playerMovement.rightActivator();
        playerMovement.leftDeactivator();
    }

    @Override
    public void leftActivator() {
        playerMovement.leftActivator();
        playerMovement.rightDeactivator();
    }

    @Override
    public void upActivator() {
        playerMovement.upActivator();
        playerMovement.downDeactivator();
    }

    @Override
    public void downActivator() {
        playerMovement.downActivator();
        playerMovement.upDeactivator();
    }

    @Override
    public void rightDeactivator() {
        playerMovement.rightDeactivator();
    }

    @Override
    public void leftDeactivator() {
        playerMovement.leftDeactivator();
    }

    @Override
    public void upDeactivator() {
        playerMovement.upDeactivator();
    }

    @Override
    public void downDeactivator() {
        playerMovement.downDeactivator();
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
    public int getVelX() {
        return playerMovement.getVelX();
    }
    @Override
    public int getVelY() {
        return playerMovement.getVelY();
    }
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

    @Override
    public void setAnimations(BufferedImage[][] animations) {
        playerMovement.setAnimations(animations);
    }

    @Override
    public BufferedImage[][] getAnimations() {
        return playerMovement.getAnimations();
    }

    @Override
    public void updateHelper() {
        playerMovement.updateHelper();
    }

}