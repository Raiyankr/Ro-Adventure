package Interface_Adapters.VisualControllers;

import Use_Cases.GameLoopInteractorReference;
import Use_Cases.VisualUseCases.ShowStatsInputBoundary;

/**
 * Controller that toggles the player's stats menu
 */
public class ShowStatsController {

    GameLoopInteractorReference gameManager;
    ShowStatsInputBoundary showStatsInteractor;

    public ShowStatsController(GameLoopInteractorReference gameManager, ShowStatsInputBoundary showStatsInputBoundary){
        this.gameManager = gameManager;
        this.showStatsInteractor = showStatsInputBoundary;
    }

    /**
     * Toggles the visibility of the stats menu
     */
    public void showStats(){
        showStatsInteractor.showStats(gameManager);
    }
}
