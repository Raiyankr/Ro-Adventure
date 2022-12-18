package Use_Cases;

public class PauseGameInteractor implements PauseGameInputBoundary{

    @Override
    public void pause(GameLoopInteractorReference gameManagerRef) {
        gameManagerRef.changeIsPaused();
        gameManagerRef.reDraw();
    }
}
