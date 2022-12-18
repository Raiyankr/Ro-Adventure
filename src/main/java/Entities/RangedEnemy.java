package Entities;

import Frameworks.GamePanel;

import java.awt.*;
import java.util.ArrayList;

public class RangedEnemy extends Enemy{

    private double distance;

    private Rectangle hitBox;
    public RangedEnemy(GamePanel gamePanel, int x, int y, int spawnX, int spawnY) {
        super(gamePanel, x, y, spawnX, spawnY);

    }
/*    public void update() {
        if (!getHitBox().intersects(gamePanel.player.getHitBox())){
            enemyMovement();
        }
    }*/

/*
    private void enemyMovement() { //In order to update current enemy location must update absXenemy.
        distance = Math.sqrt((Math.pow((gamePanel.player.getAbsXPlayer() - xEnemy - spawnX + 1896),2) + Math.pow((gamePanel.player.getAbsYPlayer() - yEnemy -spawnY + 1046), 2)));
        if (distance < 600 & distance > 110) {
            System.out.println(yEnemy);
            velX = enemyMoveHelper(xEnemy - 616 - 1280,gamePanel.player.getAbsXPlayer() - spawnX);
            velY = enemyMoveHelper(yEnemy - 326 - 720,gamePanel.player.getAbsYPlayer() - spawnY);
            ArrayList wall = currMoveCollision(velX, velY);
            if ((Boolean) wall.get(0)) {
                xEnemy -= velX;
                spawnX -= velX;
                yEnemy -= velY;
                spawnY -= velY;
            } else {
                //TODO: make enemies move randomly while it is touching the border.
            }
        } else if (distance < 110) {
            //TODO: add a function that calls the attack for enemy.
        } else {
            //TODO: make enemies move randomly while player is not close
        }
    }
*/

}
