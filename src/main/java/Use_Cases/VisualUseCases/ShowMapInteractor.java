package Use_Cases.VisualUseCases;

import Use_Cases.GameLoopInteractorReference;

public class ShowMapInteractor implements ShowMapInputBoundary {
    @Override
    public void showMap(GameLoopInteractorReference gameManagerRef) {
        gameManagerRef.changeMinimapVisible();
        gameManagerRef.reDraw();
    }
}
