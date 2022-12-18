package Use_Cases;

public class ShowMapInteractor implements ShowMapInputBoundary {
    @Override
    public void showMap(GameLoopInteractorReference gameManagerRef) {
        gameManagerRef.changeMinimapVisible();
        gameManagerRef.reDraw();
    }
}
