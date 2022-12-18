package Interface_Adapters;

import Use_Cases.PauseGameInputBoundary;
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
