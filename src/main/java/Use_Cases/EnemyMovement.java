package Use_Cases;

import Entities.MeleeEnemy;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemyMovement{
    public int getVelX(int enemyHelperX, int playerX) {
        int velX;
        velX = enemyMoveHelper(enemyHelperX - 1280,playerX);
        return velX;
    }
    public int getVelY(int enemyHelperY, int playerY) {
        int velY;
        velY = enemyMoveHelper(enemyHelperY - 720,playerY);
        return velY;
    }
    private int enemyMoveHelper(int c, int targetC) {
        if (c < targetC) {
            return -1;
        } else if (c == targetC) {
            return 0;
        } else {
            return 1;
        }
    }
    public double getDistance(int enemyHelperX, int enemyHelperY, int targetX, int targetY) {
        return Math.sqrt((Math.pow((targetX  - enemyHelperX + 1287),2)
                + Math.pow((targetY - enemyHelperY + 720 ), 2)));
    }
}