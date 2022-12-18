package Use_Cases;

import java.awt.*;

public interface EnemyMovementInputBoundary {
    int getVelX(int enemyHelperX, int playerX);
    int getVelY(int enemyHelperY, int playerY);
    double getDistance(int enemyHelperX, int enemyHelperY, int targetX, int targetY);

}