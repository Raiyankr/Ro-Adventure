package main;

import Entities.Player.Player;
import Frameworks.Display.GamePanel;
import Frameworks.VisualLoad.LoadPlayerAnimation;
import Interface_Adapters.*;
import Interface_Adapters.AnimationControllers.AnimationsImportController;
import Interface_Adapters.EnemyControllers.CreateEnemyController;
import Interface_Adapters.EnemyControllers.EnemyMovementController;
import Interface_Adapters.PlayerControllers.PlayerMovementController;
import Interface_Adapters.VisualControllers.GameScreenPresenter;
import Interface_Adapters.VisualControllers.PauseGameController;
import Interface_Adapters.VisualControllers.ShowMapController;
import Interface_Adapters.VisualControllers.ShowStatsController;
import Use_Cases.*;
import Use_Cases.EnemyUseCases.*;
import Use_Cases.PlayerUseCases.PlayerMovement;
import Use_Cases.PlayerUseCases.PlayerMovementInputBoundary;
import Use_Cases.PlayerUseCases.PlayerMovementInteractor;
import Use_Cases.VisualUseCases.*;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        //TODO: Use the username

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter username");
        String userName = myObj.nextLine();  // Read user input
        System.out.println("Welcome " + userName + "!");  // Output user input



        //Player animation and movement setup
        //TODO: Player takes parameters ABUUUU -> Don't forget to add player username
        Player player = new Player();


        LoadPlayerAnimation loadPlayerAnimation = new LoadPlayerAnimation();
        PlayerMovement playerMovement = new PlayerMovement(player);
        PlayerMovementInputBoundary playerMovementInteractor = new PlayerMovementInteractor(playerMovement);
        PlayerMovementController playerMovementController = new PlayerMovementController(
                playerMovementInteractor);
        new AnimationsImportController(loadPlayerAnimation.getPlayerAnimations(), playerMovementController);



        UpdateScreenBoundary screenModel = new GamePanel();
        GameScreenPresenter presenter = new GameScreenPresenter(screenModel);



        //Enemy stuff
        EnemyMovement enemyMovement = new EnemyMovement();
        EnemyMovementInputBoundary enemyMovementInteractor = new EnemeyMovementInteractor(enemyMovement);
        EnemyMovementController enemyMovementController = new EnemyMovementController(enemyMovementInteractor,
                playerMovementController);

        //Create Enemies use-case
        CreateEnemyInputBoundary enemyManagerInteractor = new EnemyManagerHandler();
        CreateEnemyController createEnemyController = new CreateEnemyController(enemyManagerInteractor,
                playerMovementController, enemyMovementController);
        createEnemyController.create();


        // GameManager (Takes in all the controller and presenters needed for use-cases)
        GameLoopInteractorReference gameManager = new GameLoopManagerLoop(presenter, playerMovementController,
                createEnemyController);


        // Display Stats Use Case
        ShowStatsInputBoundary showStatsInputBoundary = new ShowStatsInteractor();
        ShowStatsController showStatsController = new ShowStatsController(gameManager, showStatsInputBoundary);


        // Pause game Use Case
        PauseGameInputBoundary pauseGameInteractor = new PauseGameInteractor();
        ShowMapInputBoundary showMapInteractor = new ShowMapInteractor();
        PauseGameController pauseGameController = new PauseGameController(pauseGameInteractor, gameManager);
        ShowMapController showMapController = new ShowMapController(showMapInteractor, gameManager);



        screenModel.setUp(pauseGameController, showMapController,showStatsController,
                playerMovementController,  createEnemyController);

        gameManager.start();
    }
}