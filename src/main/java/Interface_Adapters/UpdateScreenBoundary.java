package Interface_Adapters;

import Interface_Adapters.EnemyControllers.CreateEnemyController;
import Interface_Adapters.PlayerControllers.PlayerMovementController;
import Interface_Adapters.VisualControllers.PauseGameController;
import Interface_Adapters.VisualControllers.ShowMapController;
import Interface_Adapters.VisualControllers.ShowStatsController;

public interface UpdateScreenBoundary {

    void update();

    void requestFocus();

    void setUp(PauseGameController pauseGameController, ShowMapController showMapController,
               ShowStatsController showStatsController,
               PlayerMovementController playerMovementController,
               CreateEnemyController createEnemyController);
}
