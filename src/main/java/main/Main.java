package main;

import Entities.Player;
import Frameworks.GamePanel;
import Frameworks.PlayerAnimationImport;
import Interface_Adapters.*;
import Use_Cases.*;

public class Main {
    public static void main(String[] args) {

//        Scanner myObj = new Scanner(System.in);
//        System.out.println("Enter username");
//
//        String userName = myObj.nextLine();  // Read user input
//        System.out.println("Welcome " + userName + "!");  // Output user input

        UpdateScreenBoundary screenModel = new GamePanel();
        GameScreenPresenter presenter = new GameScreenPresenter(screenModel);
        // GameWindow application = new GameWindow(presenter);

        //Creating player sprites in blue layer, maybe controller needed?
        PlayerAnimationImport playerAnimationImport = new PlayerAnimationImport();
        //Player movement and collisions
        PlayerMovement playerMovement = new PlayerMovement(playerAnimationImport.getPlayerAnimations());
        Collision collision = new Collision();
        CollisionInputBoundary collisionInteractor = new CollisionInteractor(collision);
        CollisionController collisionController = new CollisionController(collisionInteractor);
        PlayerMovementInputBoundary playerMovementInteractor = new PlayerMovementInteractor(playerMovement);
        PlayerMovementController playerMovementController = new PlayerMovementController(playerMovementInteractor, collisionController);

        GameLoopInteractorReference gameManager = new GameLoopManagerLoop(presenter, playerMovementController);

        // Stat Bars Use Case
        Player player = new Player();
        StatBarsInputBoundary statBarsInputBoundary = new StatBarsInteractor(player);
        StatBarsPresenterBoundary statBarsPresenterBoundary = new StatBarsPresenter(statBarsInputBoundary);

        // Display Stats Use Case
        ShowStatsInputBoundary showStatsInputBoundary = new ShowStatsInteractor();
        ShowStatsController showStatsController = new ShowStatsController(gameManager, showStatsInputBoundary);

        PauseGameInputBoundary pauseGameInteractor = new PauseGameInteractor();
        ShowMapInputBoundary showMapInteractor = new ShowMapInteractor();

        PauseGameController pauseGameController = new PauseGameController(pauseGameInteractor, gameManager);
        ShowMapController showMapController = new ShowMapController(showMapInteractor, gameManager);

        screenModel.setUp(pauseGameController, showMapController, statBarsPresenterBoundary, showStatsController, playerMovementController);
        gameManager.start();
    }
}
