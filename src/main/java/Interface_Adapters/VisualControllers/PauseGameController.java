package Interface_Adapters.VisualControllers;

import Use_Cases.VisualUseCases.PauseGameInputBoundary;
import Use_Cases.GameLoopInteractorReference;

public class PauseGameController {
    PauseGameInputBoundary gameState;
    GameLoopInteractorReference gameManagerRef;
    public PauseGameController(PauseGameInputBoundary gameState, GameLoopInteractorReference gameManagerRef){
        this.gameState = gameState;
        this.gameManagerRef = gameManagerRef;
    }

    public void pause(){
        gameState.pause(gameManagerRef);
    }
}
