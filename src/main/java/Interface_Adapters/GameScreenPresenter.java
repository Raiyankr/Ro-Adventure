package Interface_Adapters;

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