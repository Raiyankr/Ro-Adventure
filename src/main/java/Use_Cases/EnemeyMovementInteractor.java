package Use_Cases;

public class EnemeyMovementInteractor implements EnemyMovementInputBoundary{
    EnemyMovement enemyMovement;
    public EnemeyMovementInteractor(EnemyMovement enemyMovement) {
        this.enemyMovement = enemyMovement;
    }
    @Override
    public int getHelperX() {
        return enemyMovement.getHelperX();
    }

    @Override
    public int getHelperY() {
        return enemyMovement.getHelperY();
    }

    @Override
    public int getVisualX() {
        return enemyMovement.getVisualX();
    }

    @Override
    public int getVisualY() {
        return enemyMovement.getVisualY();
    }

    @Override
    public void updateX() {
        enemyMovement.updateX();
    }

    @Override
    public void updateY() {
        enemyMovement.updateY();
    }
}
