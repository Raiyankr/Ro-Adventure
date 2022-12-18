package Inputs;
import Interface_Adapters.PlayerControllers.PlayerMovementController;
import Interface_Adapters.VisualControllers.PauseGameController;
import Interface_Adapters.VisualControllers.ShowMapController;
import Interface_Adapters.VisualControllers.ShowStatsController;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {

//    private GamePanel gamePanel;
//    public KeyboardInputs(GamePanel gamePanel){
//
//        this.gamePanel = gamePanel;
//    }
    PauseGameController pauseGameController;
    ShowMapController showMapController;
    PlayerMovementController playerMovementController;
    ShowStatsController showStatsController;


    public KeyboardInputs(PauseGameController pauseGameController, ShowMapController showMapController,
                          ShowStatsController showStatsController, PlayerMovementController playerMovementController){
        this.pauseGameController = pauseGameController;
        this.showMapController = showMapController;
        this.showStatsController = showStatsController;
        this.playerMovementController = playerMovementController;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> {
                playerMovementController.upActivator();
            }
            case KeyEvent.VK_S -> {
                playerMovementController.downActivator();
            }
            case KeyEvent.VK_D -> {
                playerMovementController.rightActivator();
            }
            case KeyEvent.VK_A -> {
                playerMovementController.leftActivator();
            }
            case KeyEvent.VK_M -> {
                showMapController.updateMap();
            }
            case KeyEvent.VK_ESCAPE -> {
                pauseGameController.pause();
            }
            case KeyEvent.VK_O-> {
                showStatsController.showStats();
            }
            case KeyEvent.VK_SPACE -> {
                // ATTACK GOES HERE
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {

            case KeyEvent.VK_W -> {
                playerMovementController.upDeactivator();
            }
            case KeyEvent.VK_S -> {
                playerMovementController.downDeactivator();
            }
            case KeyEvent.VK_D -> {
                playerMovementController.rightDeactivator();
                playerMovementController.setIdleDirection(1);}
            case KeyEvent.VK_A -> {
                playerMovementController.leftDeactivator();
                playerMovementController.setIdleDirection(0); }
            }
        }
    }

