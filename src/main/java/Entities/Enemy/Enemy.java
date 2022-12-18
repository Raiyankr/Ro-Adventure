package Entities.Enemy;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public abstract class Enemy {
    public abstract int getVisualX();
    public abstract int getVisualY();
    public abstract int getHelperX();
    public abstract int getHelperY();
    public abstract int getHealth();
    public abstract void setHealth(int health);
    public abstract int getDMG();
    public abstract void changeHelperX(int x);
    public abstract void changeHelperY(int y);
    public abstract Rectangle getHitBox();
    public abstract void setAnimations(BufferedImage[][] animations);
    public abstract BufferedImage[][] getAnimations();

    public boolean attacking = false, hit = false;

    public void setAttacking(boolean value) {
        this.attacking = value;
    }
    public boolean getAttacking() {
        return attacking;
    }
    public void setHit(boolean value) {
        this.hit = value;
    }
    public boolean getHit() {
        return hit;
    }

    public abstract Ellipse2D.Float getAttackHitRadius();
    public abstract Ellipse2D.Float getAttackRadius();
    public abstract void drawMonsterHitRadius(Graphics g);
    public abstract void updateAttackHitRadius();
    public abstract void drawMonsterAttackRadius(Graphics g);

}