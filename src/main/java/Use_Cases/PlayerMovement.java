package Use_Cases;

import java.awt.image.BufferedImage;

public class PlayerMovement extends Movement{

    private int velX = 0, velY = 0;
    private int aniTick, aniIndex, aniSpeed= 10;
    private int playerAction = 0;
    private boolean moving = false;

    private int idleDir = 0;

    private int currLocationX = -2546, currLocationY = -2132;
    private int helperX = 1882, helperY = 1738;
    private BufferedImage[][] animations;
    public PlayerMovement(BufferedImage[][] animations) {
        this.animations = animations;
    }

    @Override
    public void updateX() {
        this.currLocationX += velX;
        this.helperX -= velX;
    }
    @Override
    public void updateY() {
        this.currLocationY += velY;
        this.helperY -= velY;
    }
    public void setVelX(int x) {
        this.velX = x;
        this.setMoving();
    }
    public void setVelY(int y) {
        this.velY = y;
        this.setMoving();
    }
    public void setMoving () {
        if (velX != 0 || velY != 0) {
            moving = true;
        } else {moving = false;}
    }

    //Getting locations
    public int getVisualX() {
        return currLocationX;
    }
    public int getVisualY() {
        return currLocationY;
    }
    public int getHelperX() {
        return helperX;
    }
    public int getHelperY() {
        return helperY;
    }

    private void setAnimation() {
        if (moving) {
            if ((velX == -2 & velY == -2) || (velX == -2 & velY == 2) || (velX == -2)) { //Left movement
                playerAction = 3;
            } else if ((velX == 2 & velY == -2) || (velX == 2 & velY == 2)|| (velX == 2)) { //Right movement
                playerAction = 2;
            } //Needs testing for up and down
        } else {
            if (idleDir == 0) { //Left idle animation
                playerAction = 0;
            } else {
                playerAction = 1;
            }
        }
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
        setAnimation();
        return this.animations[playerAction][aniIndex];
    }
}
