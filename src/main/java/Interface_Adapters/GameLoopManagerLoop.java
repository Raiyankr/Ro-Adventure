package Interface_Adapters;

import Frameworks.GameWindow;
import Frameworks.PlayerAnimationImport;
import Use_Cases.GameLoopInteractorReference;

/**
 * Manager class that calls various use cases and uses presenter to update view
 */
public class GameLoopManagerLoop implements Runnable, GameLoopInteractorReference {

    private Thread gameThread;
    private final int FPS_SET = 120;
    private final int UPS_SET = 120;


    // Game Timer Variables
    private static long startTime = System.currentTimeMillis();
    private static long gameTimerSeconds = 0;
    private long pauseTime = 0;

    private static boolean isPaused = false;

    private static boolean showMinimap = false;
    private static boolean showStats = false;

    // Dependency Injection
    GameScreenPresenter gameScreenPresenter;
    UpdateScreenBoundary screenModel;
    PlayerMovementController playerMovementController;

    public GameLoopManagerLoop(GameScreenPresenter gameScreenPresenter, PlayerMovementController playerMovementController){
        this.gameScreenPresenter = gameScreenPresenter;
        this.playerMovementController = playerMovementController;
        screenModel = gameScreenPresenter.create();
        new GameWindow(screenModel);
        // TODO: Raiyan
        //  - DON'T DO THIS BROOO
        //gamePanel = new GamePanel();

        // Focuses on what is happening here
        screenModel.requestFocus();

    }

    public void start(){
        startGameLoop();
    }

    public void update(){
        //TODO: KUSHIL
        // Move these to EnemyManager

        //TODO: Raiyan
        // Clean this - Don't Directly call UpdateGame()
        // gamePanel.updateGame();

        playerMovementController.update();
    }

    public void reDraw(){
        gameScreenPresenter.update();
    }

    private void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public static int getGameTimerSeconds(){
        return (int) ((int)(gameTimerSeconds - startTime) / 1000F);
    }

    public static boolean getIsPaused(){
        return isPaused;
    }
    public void changeIsPaused(){
        isPaused = !isPaused;
    }

    public static boolean getMinimapVisible(){
        return showMinimap;
    }
    public void changeMinimapVisible(){
        showMinimap = !showMinimap;
    }
    public static boolean getStatsVisible(){
        return showStats;
    }
    public void changeStatsVisible() {
        showStats = !showStats;
    }

    // Main game loop
    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / FPS_SET;
        long lastCheck = System.currentTimeMillis();
        double deltaF = 0;
        int frames = 0;

        double timePerUpdate = 1000000000.0 / UPS_SET;
        long previousTime = System.nanoTime();
        double deltaU = 0;
        int update = 0;


        while(true){
            // This is for the UPS check and update
            long currentTime = System.nanoTime();
            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            //TODO: Raiyan
            // Create usecase for:
            //      PauseGame

            if (deltaU >= 1){
                // Only update if the game is not paused
                if (!getIsPaused()){
                    update();
                    gameTimerSeconds = System.currentTimeMillis() - pauseTime;
                }else{
                    pauseTime = System.currentTimeMillis() - gameTimerSeconds;
                }
                update++;
                deltaU--;
            }

            // This is for the FPS check and repaint
            if (deltaF >= 1){
                if (!getIsPaused()){
                    reDraw();
                }
                frames++;
                deltaF--;
            }

            // Display Stats
            if (System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                //System.out.println("FPS: " + frames + " | UPS: " + update);
                frames= 0;
                update = 0;
            }
        }
    }
}