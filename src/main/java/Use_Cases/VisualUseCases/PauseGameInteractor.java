package Use_Cases.VisualUseCases;

import Use_Cases.GameLoopInteractorReference;

public class PauseGameInteractor implements PauseGameInputBoundary{

    @Override
    public void pause(GameLoopInteractorReference gameManagerRef) {
        gameManagerRef.changeIsPaused();
        gameManagerRef.reDraw();
    }
}
