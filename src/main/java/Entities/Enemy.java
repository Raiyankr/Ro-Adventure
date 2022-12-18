package Entities;

import Frameworks.GamePanel;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

//import static Entities.MonsterConstants.*;

public class Enemy{
    protected GamePanel gamePanel;
    protected int xEnemy;
    protected int yEnemy;
    protected double distance;
    protected int velX = 0, velY = 0;
    protected int spawnX, spawnY;
//    protected Rectangle hitBox;

    protected int aniTick, aniSpeed = 10;
    protected int aniIndex;

    // for attack methods
    protected Ellipse2D.Float hitBox, attackHitBox;
    protected int currentHealth;
    protected int maxHealth;
    protected int enemyState;
    public int PLAYER_ATTACK_DAMAGE;  // TODO: make this an attribute of player class

    public Enemy(GamePanel gamePanel, int x, int y, int spawnX, int spawnY) {
        this.gamePanel = gamePanel;
        this.spawnY = spawnY;
        this.spawnX = spawnX;
        this.xEnemy = x + this.spawnX;
        this.yEnemy = y + this.spawnY;

        // added for attack methods
        maxHealth = 50;  // set enemy's max health
        initHitBoxAttack();
    }

    // change hitbox shape to an ellipse
    public Ellipse2D.Float getHitBox() {
//        hitBox = new Ellipse2D.Float(spawnX - 1280 + 4, spawnY - 720 + 4, 24, 24);// adjusted the monster hitbox sizes
        hitBox = new Ellipse2D.Float(spawnX - 1280 + 4, spawnY - 720 + 4, 48, 48);
        return hitBox;
    }

    protected int enemyMoveHelper(int c, int targetC) {
        if (c < targetC) {
            return -1;
        } else if (c == targetC) {
            return 0;
        } else {
            return 1;
        }
    }
    public int getXEnemy() {return this.xEnemy;}
    public int getYEnemy() {return this.yEnemy;}
    public void changeXEnemy(int x) {this.xEnemy += x;}
    public void changeYEnemy(int y) {this.yEnemy += y;}



    private void initHitBoxAttack() {
        attackHitBox = new Ellipse2D.Float(xEnemy, yEnemy, 29, 29);
    }

    protected void updateHitBoxAttack() {
        attackHitBox.x = xEnemy;
        attackHitBox.y = yEnemy;
    }

    public void drawMonsterHitBox(Graphics g) {
        g.setColor(Color.red);
        g.drawOval((int) attackHitBox.x, (int) attackHitBox.y, (int) attackHitBox.width, (int) attackHitBox.height);
    }

}

