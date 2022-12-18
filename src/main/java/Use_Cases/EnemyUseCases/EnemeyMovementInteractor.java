package Use_Cases.EnemyUseCases;

public class EnemeyMovementInteractor implements EnemyMovementInputBoundary{
    EnemyMovement enemyMovement;
    public EnemeyMovementInteractor(EnemyMovement enemyMovement) {
        this.enemyMovement = enemyMovement;
    }

    @Override
    public int getVelX(int enemyHelperX, int playerX) {
        return enemyMovement.getVelX(enemyHelperX, playerX);
    }

    @Override
    public int getVelY(int enemyHelperY, int playerY) {
        return enemyMovement.getVelY(enemyHelperY, playerY);
    }
    @Override
    public double getDistance(int enemyHelperX, int enemyHelperY, int targetX, int targetY) {
        return enemyMovement.getDistance(enemyHelperX, enemyHelperY, targetX, targetY);
    }
}