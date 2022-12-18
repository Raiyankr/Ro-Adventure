package Interface_Adapters.EnemyControllers;

import Interface_Adapters.CollisionControllers.CollisionController;
import Interface_Adapters.PlayerControllers.PlayerMovementController;
import Use_Cases.EnemyUseCases.EnemyMovementInputBoundary;

public class EnemyMovementController {
    PlayerMovementController playerMovementController;
    CollisionController collisionController;
    EnemyMovementInputBoundary enemyMovementInputBoundary;
    /**
     *  Connects the enemy controller to the interactor through an input boundaru.
     *  Also connects it to player movement controller and collision controller.
     */
    public EnemyMovementController(EnemyMovementInputBoundary enemyMovementInputBoundary, PlayerMovementController playerMovementController,
                                   CollisionController collisionController) {
        this.enemyMovementInputBoundary = enemyMovementInputBoundary;
        this.collisionController = collisionController;
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
            if (collisionController.movable(playerMovementController.getVisualX(), playerMovementController.getVisualY(),  enemyHelperX + 4,
                    enemyHelperY + 4, enemyMovementInputBoundary.getVelX(enemyHelperX, playerMovementController.getHelperX()), 0, 24, 24)){
                return enemyMovementInputBoundary.getVelX(enemyHelperX, playerMovementController.getHelperX());
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
    public int updateY(int enemyHelperX, int enemyHelperY, int enemyVisualX, int enemyVisualY) {
        if (enemyMovementInputBoundary.getDistance(enemyHelperX, enemyHelperY, playerMovementController.getHelperX(),
                playerMovementController.getHelperY()) < 600) {
            if (collisionController.movable(playerMovementController.getVisualX(), playerMovementController.getVisualY(), enemyHelperX + 4,
                    enemyHelperY + 4, 0, enemyMovementInputBoundary.getVelY(enemyHelperY,playerMovementController.getHelperY()), 24, 24)) {
                return enemyMovementInputBoundary.getVelY(enemyHelperY, playerMovementController.getHelperY());
            } else {
                return 0;
            }
        } else {
            return 0;
        }

    }
}