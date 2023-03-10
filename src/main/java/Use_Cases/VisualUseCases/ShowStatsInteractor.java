package Use_Cases.VisualUseCases;

import Use_Cases.GameLoopInteractorReference;

/**
 * Toggles the display of the player's stats
 */
public class ShowStatsInteractor implements ShowStatsInputBoundary{
    @Override
    public void showStats(GameLoopInteractorReference gameManager){
        gameManager.changeStatsVisible();
        gameManager.reDraw();
    }
}
