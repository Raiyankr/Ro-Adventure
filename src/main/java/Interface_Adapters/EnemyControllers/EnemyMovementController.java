package Interface_Adapters.EnemyControllers;

import Interface_Adapters.PlayerControllers.PlayerMovementController;
import Use_Cases.EnemyUseCases.EnemyMovementInputBoundary;

public class EnemyMovementController {
    PlayerMovementController playerMovementController;

    EnemyMovementInputBoundary enemyMovementInputBoundary;
    /**
     *  Connects the enemy controller to the interactor through an input boundaru.
     *  Also connects it to player movement controller and collision controller.
     */
    public EnemyMovementController(EnemyMovementInputBoundary enemyMovementInputBoundary, PlayerMovementController playerMovementController) {
        this.enemyMovementInputBoundary = enemyMovementInputBoundary;
        this.playerMovementController = playerMovementController;
    }
    /**
     * Updates the enemy location, so there are three cases.
     * First case: enemy is close to player then it will move towards the player
     * Second case: enemy is close to player however it is touching a wall, so then it will move back to original spot
     * Third case: enemy is not close to player and so it will stay still
     */
    public int updateX(int enemyHelperX, int enemyHelperY, int enemyVisualX, int enemyVisualY) {
        if (enemyMovementInputBoundary.getDistance(enemyHelperX, enemyHelperY, playerMovementController.getHelperX(),
                playerMovementController.getHelperY()) < 600 ) {
                return enemyMovementInputBoundary.getVelX(enemyHelperX, playerMovementController.getHelperX());
        } else {
            return 0;
        }
    }
    public int updateY(int enemyHelperX, int enemyHelperY, int enemyVisualX, int enemyVisualY) {
        if (enemyMovementInputBoundary.getDistance(enemyHelperX, enemyHelperY, playerMovementController.getHelperX(),
                playerMovementController.getHelperY()) < 600) {
                return enemyMovementInputBoundary.getVelY(enemyHelperY, playerMovementController.getHelperY());
        } else {
            return 0;
        }

    }
}