package Entities.Player;

import java.awt.image.BufferedImage;
import java.awt.geom.Ellipse2D;

public class Player {
    private BufferedImage[][] animations;

    private int currLocationX = -2546, currLocationY = -2132;
    private int helperX = 1882, helperY = 1738;

    private boolean moving = false;


    public Player() {

    }



    public boolean getMoving() {
        return moving;
    }
    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void setAnimations(BufferedImage[][] animations) {
        this.animations = animations;
    }
    public BufferedImage[][] getAnimations() {
        return this.animations;
    }
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

    public void changeHelperX(int x) {
        this.helperX -= x;
    }
    public void changeHelperY(int y) {
        this.helperY -= y;
    }
    public void changeVisualX(int x) {
        this.currLocationX += x;
    }
    public void changeVisualY(int y) {
        this.currLocationY += y;
    }

}