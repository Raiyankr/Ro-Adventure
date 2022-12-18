package Interface_Adapters;

import Entities.Enemy;
import Entities.MeleeEnemy;
import Use_Cases.CreateEnemyInputBoundary;

import java.util.ArrayList;

public class CreateEnemyController {

//    private CreateEnemyInputBoundary createEnemyInputBoundary;
    public CreateEnemyInputBoundary createEnemyInputBoundary;
    private PlayerMovementController playerMovementController;
    private EnemyMovementController enemyMovementController;

    public CreateEnemyController(CreateEnemyInputBoundary createEnemyInputBoundary,
                                 PlayerMovementController playerMovementController,
                                 EnemyMovementController enemyMovementController){
        this.createEnemyInputBoundary = createEnemyInputBoundary;
        this.playerMovementController = playerMovementController;
        this.enemyMovementController = enemyMovementController;
    }
    public void updateMapLocation(int xDelta, int yDelta) {
        createEnemyInputBoundary.updateEnemies(xDelta, yDelta);
        update();
    }
    public void create(){
        createEnemyInputBoundary.createEnemies(playerMovementController.getVisualX(),
                playerMovementController.getVisualY());
    }

    public ArrayList<ArrayList> getEnemyInfo(){
        return createEnemyInputBoundary.getEnemiesInfo();
    }
    public void update() {
        ArrayList<Enemy> enemies = createEnemyInputBoundary.getEnemies();
        for (Enemy enemy : enemies){
            enemy.changeHelperX(enemyMovementController.updateX(enemy.getHelperX(), enemy.getHelperY(), enemy.getVisualX(), enemy.getHelperY()));
            enemy.changeHelperY(enemyMovementController.updateY(enemy.getHelperX(), enemy.getHelperY(), enemy.getVisualX(), enemy.getHelperY()));
        }
    }
}