package Use_Cases;

import Entities.Player;

import java.awt.image.BufferedImage;

/**
 * Use case for player movement
 */
public class PlayerMovement{
    public Player player;
    private boolean right, left, up, down;
    private int idleDir = 0;
    private int aniTick, aniIndex, aniSpeed= 10;
    private int playerAction = 0;
    private boolean moving = false;
    private int speed;
    public PlayerMovement(Player player) {
        this.player = player;
    }
    public int getVelX() {
        if (left) {
            return speed;
        } else if (right) {
            return -speed;
        } else {
            return 0;
        }
    }
    public int getVelY() {
        if (down) {
            return -speed;
        } else if (up) {
            return speed;
        } else {
            return 0;
        }
    }
    public void updateHelper() {
        this.speed = player.getSpeed();
        this.moving = player.getMoving();
    }
    public void updateX() {
        if (left) {
            player.changeVisualX(speed);
            player.changeHelperX(speed);
        } else if (right) {
            player.changeVisualX(-speed);
            player.changeHelperX(-speed);
        }
    }
    public void updateY() {
        if (up) {
            player.changeHelperY(speed);
            player.changeVisualY(speed);
        } else if (down) {
            player.changeHelperY(-speed);
            player.changeVisualY(-speed);
        }
    }
    public void rightActivator() {
        this.right = true;
        this.setMoving();
    }
    public void leftActivator() {
        this.left = true;
        this.setMoving();
    }
    public void upActivator() {
        this.up = true;
        this.setMoving();
    }
    public void downActivator() {
        this.down = true;
        this.setMoving();
    }
    public void rightDeactivator() {
        this.right = false;
        this.setMoving();
    }
    public void leftDeactivator() {
        this.left = false;
        this.setMoving();
    }
    public void upDeactivator() {
        this.up = false;
        this.setMoving();
    }
    public void downDeactivator() {
        this.down = false;
        this.setMoving();
    }
    public void setMoving () {
        if (right || left || up || down) {
            player.setMoving(true);
        } else {player.setMoving(false);}
    }
    //Getting locations
    public int getVisualX() {
        return player.getVisualX();
    }
    public int getVisualY() {
        return player.getVisualY();
    }
    public int getHelperX() {
        return player.getHelperX();
    }
    public int getHelperY() {
        return player.getHelperY();
    }
    public void setAnimations(BufferedImage[][] animations) {
        player.setAnimations(animations);
    }
    public BufferedImage[][] getAnimations() {
        return player.getAnimations();
    }
    private void updateAnimation() {
        if (moving) {
            if ((right & up) || (right & down) || (right)) {
                playerAction = 3;
            } else if ((left & up) || (left & down)|| (left)) {
                playerAction = 2;
            } //Needs testing for up and down
        } else {
            if (idleDir == 0) { //Left idle animation
                playerAction = 0;
            } else {
                playerAction = 1;
            }
        }

//        if (player.getAttacking()) {
//            playerAction = 4;
//        }
//        if (player.getHit()) {
//            playerAction = 6;
//        }
    }
    public void setIdleDirection(int dir) {
        this.idleDir = dir;
    }
    private int getSpriteAmount(int playerAction) {
        switch (playerAction) {
            case -1:
            case 0:
            case 1:
                return 6;
            case 2:
            case 3:
                return 5;
            default:
                return 1;
        }
    }
    private void updateAnimationTick() {
        aniTick ++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= getSpriteAmount(playerAction)) {
                aniIndex = 0;
            }
        }
    }
    public BufferedImage getCurrentImage () {
        updateAnimationTick();
        updateAnimation();
        return player.getAnimations()[playerAction][aniIndex];
    }

    public boolean getRight() {
        return right;
    }

}