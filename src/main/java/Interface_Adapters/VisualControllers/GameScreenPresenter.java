package Interface_Adapters.VisualControllers;

import Interface_Adapters.UpdateScreenBoundary;

public class GameScreenPresenter {
    UpdateScreenBoundary screenModel;
    //TODO: This will call Repaint method

    public GameScreenPresenter(UpdateScreenBoundary screenModel){

        this.screenModel = screenModel;
    }
    public UpdateScreenBoundary create(){
        return this.screenModel;
    }
    public void update(){
        screenModel.update();
    }
}