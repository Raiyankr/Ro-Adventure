package Use_Cases;

public interface GameLoopInteractorReference {
    void changeIsPaused();
    void changeMinimapVisible();
    void changeStatsVisible();

    void start();
    void reDraw();
}
