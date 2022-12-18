package Interface_Adapters;

import Use_Cases.GameLoopInteractorReference;
import Use_Cases.ShowMapInputBoundary;

public class ShowMapController {
    GameLoopInteractorReference gameManagerRef;

    ShowMapInputBoundary showMapInputBoundary;

    public ShowMapController(ShowMapInputBoundary showMapInputBoundary, GameLoopInteractorReference gameManagerRef){
        this.gameManagerRef = gameManagerRef;
        this.showMapInputBoundary = showMapInputBoundary;
    }

    public void updateMap(){
        showMapInputBoundary.showMap(gameManagerRef);
    }

}
