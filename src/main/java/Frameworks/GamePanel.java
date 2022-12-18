package Frameworks;

import Entities.Enemy;
import Inputs.KeyboardInputs;
import Inputs.MouseInputs;
import Interface_Adapters.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class GamePanel extends JPanel implements UpdateScreenBoundary {

    // Stats bar constants
    final int MAX_HEALTH = 0;
    final int CURRENT_HEALTH = 1;
    final int STRENGTH = 2;
    final int SPEED = 3;

    private JLabel timerGui;


    StatBarsPresenterBoundary statBarsPresenterBoundary;

    private WriteToBoardController writeToBoardController;
    private boolean showStatBar = true;
    private ArrayList<Leaf> leafList = new ArrayList<>();


    private BufferedImage map;
    private BufferedImage minimap;
    private BufferedImage minimapCursor;
    private BufferedImage pauseIcon;
    private BufferedImage leaf;
    private BufferedImage bushes;

    // Variables for shop system GUI
    private BufferedImage shopKeeper;
    private BufferedImage healthPotion;
    private BufferedImage statsBar;
    private BufferedImage healthBar;
    private BufferedImage timerPill;
    private BufferedImage buffbar;


    // GamePanel uses these controllers to call different use-cases
    ShowMapController showMapController;
    ShowStatsController showStatsController;
    PauseGameController pauseGameController;
    PlayerMovementController playerMovementController;

    CreateEnemyController createEnemyController;
    AttackController attackController;


    public GamePanel(){
        setTimerGui();
        importImage();
        // Adding leaves
        leafList.add(new Leaf());
        leafList.add(new Leaf());
        this.setBackground(new Color(0, 0, 0));
    }

    /**
     * This method is designated to initialize all the controllers and presenters that will be used to perform various
     * use-cases.
     */
    public void setUp(PauseGameController pauseGameController, ShowMapController showMapController,
                      StatBarsPresenterBoundary statBarsPresenterBoundary, ShowStatsController showStatsController, 
                      PlayerMovementController playerMovementController, AttackController attackController,
                      CreateEnemyController createEnemyController){

        this.pauseGameController = pauseGameController;
        this.showMapController = showMapController;
        this.showStatsController = showStatsController;
        this.statBarsPresenterBoundary = statBarsPresenterBoundary;
        this.playerMovementController = playerMovementController;

        this.writeToBoardController = writeToBoardController;
        this.createEnemyController = createEnemyController;
        this.attackController = attackController;

        addKeyListener(new KeyboardInputs(pauseGameController, showMapController,
                showStatsController, playerMovementController, attackController));

        addMouseListener(new MouseInputs(this));
    }

    /**
     * Initialize the timer GUI
     */
    private void setTimerGui(){
        timerGui = new JLabel(String.valueOf(120));
        timerGui.setBounds(605, -19, 100, 100);
        timerGui.setFont(new Font("Arial", Font.PLAIN, 35));
        timerGui.setForeground(new Color(150, 203, 187));
        add(timerGui);
    }

    /**
     * Changing the Timer Gui-text based on updated time
     */
    private void changeTimerGui(){
        timerGui.setBounds(605, -19, 100, 100);
        timerGui.setHorizontalAlignment(0);
        if (GameLoopManagerLoop.getGameTimerSeconds() % 2 == 0){
            timerGui.setForeground(new Color(150, 203, 187));
        }else{
            timerGui.setForeground(new Color(255, 81, 81, 194));
        }
        timerGui.setText(String.valueOf(120 - GameLoopManagerLoop.getGameTimerSeconds()));
    }

    /**
     * Initialling the level image by calling
     */
    private void importImage() {
        BufferedImage[] imageList = LoadLevelImage.importImage();
        map = imageList[0];
        minimapCursor = imageList[1];
        minimap = imageList[2];
        pauseIcon = imageList[3];
        leaf = imageList[4];
        bushes = imageList[5];
        shopKeeper = imageList[6];
        statsBar = imageList[7];
        healthBar = imageList[8];
        timerPill = imageList[9];
        buffbar = imageList[10];
    }

    // TODO: Abu
    //  - Move this to controller and add interface for GamePanel to check when these are updated
/*    public void setPointerLocation(int x, int y){
        this.xDelta = x;
        this.yDelta = y;
    }*/
    public void update(){
        repaint();
    }

    public void changeStatsBarVisible(){
        this.showStatBar = !this.showStatBar;

    }

    public void animateLeaf(Graphics g, ArrayList<Leaf> alist){
        for (Leaf curr : alist ){
            g.drawImage(leaf, curr.getX(), curr.getY(), null);
            curr.positionChange();
        }
    }

    // This is for drawing stuff
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        //Drawing the basic map
        g.drawImage(map, playerMovementController.getVisualX(), playerMovementController.getVisualY(), null);

        // player VISUAL goes here
        //TODO: Abu - Access player through an interface using CLEAN way
        g.drawImage(playerMovementController.getCurrAnimation(), 616, 326, 48,48, null);

        //Enemy visual goes here
        ArrayList<ArrayList> enemyInfo = this.createEnemyController.getEnemyInfo();
        for (ArrayList i : enemyInfo){
            g.drawImage(playerMovementController.getCurrAnimation(), (int)i.get(1), (int) i.get(2), 36,36, null);
        }


        //TODO: Kevin
        // Handle shop stuff using CLEAN way

        // SHOP VISUAL GOES HERE
/*

        if (gameShop.getItemList().contains("Health Potion")){
            g.drawImage(healthPotion, xDelta + 1857, yDelta + 1726, null);
        }
*/
        g.drawImage(shopKeeper, playerMovementController.getVisualX() + 1857, playerMovementController.getVisualY() + 1676, null);

        g.drawImage(bushes, playerMovementController.getVisualX(), playerMovementController.getVisualY(), null);

        // TODO: Add health bar and animation

        // Timer GUi Goes here
        g.drawImage(timerPill, 607, 5, null);
        changeTimerGui();

        //HealthBar and Stats stuff go here
        drawStats(g);

        animateLeaf(g, leafList);

        // Pause menu
        if (GameLoopManagerLoop.getIsPaused()){
            g.setColor(new Color(162, 155, 155, 139));
            g.fillRect(0, 0, 1280, 720);
            if (!GameLoopManagerLoop.getMinimapVisible()){
                g.drawImage(pauseIcon, 500, 295, null);
            }
        }
        //Showing Minimap
        if (GameLoopManagerLoop.getMinimapVisible()){
            g.drawImage(minimap, -52 + playerMovementController.getVisualX()/7, -130 + playerMovementController.getVisualY()/6, null);
            g.drawImage(minimapCursor, 598, 284, null);
        }

        // TODO: Kevin
        //  - Don't directly call a method from gameShop.
/*
        gameShop.checkLocation();

*/
        // for debugginh attack methods!!!
        attackController.drawPlayerAttackRadius(g);
        attackController.drawPlayerHitRadius(g);
        attackController.drawMonstersHitRadius(g);
        attackController.drawMonstersAttackRadius(g);
        ArrayList<Enemy> e = createEnemyController.createEnemyInputBoundary.getEnemies();
        Enemy e1 = e.get(0);
        Enemy e2 = e.get(1);

        g.drawOval(e1.getVisualX(), e1.getVisualY(), 36, 36);
        g.drawOval(e2.getVisualX(), e2.getVisualY(), 36, 36);

        g.drawOval(e1.getVisualX(), e1.getVisualY(), 36, 36);  // Melee enemy

    }

    /**
     * Draw the Health Bar and the Stats Menu on the screen
     * @param g Graphics object used to draw
     */
    private void drawStats(Graphics g) {
        if (!GameLoopManagerLoop.getMinimapVisible() && !GameLoopManagerLoop.getIsPaused()) {
            int[] playerStats = statBarsPresenterBoundary.getStats();
            // Drawing the outside of the health bar
            g.drawImage(healthBar, 17, 14, null);
            // Drawing the health bar
            g.setColor(new Color(225, 50, 50));
            g.fillRoundRect(95, 43, 275 * playerStats[CURRENT_HEALTH] / playerStats[MAX_HEALTH],
                    30, 27, 27);
            // Drawing the stats menu
            g.drawImage(buffbar, 495, 619, null);
            if (GameLoopManagerLoop.getStatsVisible()) {
                g.drawImage(statsBar, 9, 109, null);
                g.setColor( new Color(255, 165, 0));
                g.fillRect(72, 156, playerStats[STRENGTH] * 10, 6);
                g.setColor( new Color(0, 255, 255));
                // TODO: Once speed is implemented as a parameter, switch 2 for playerStats[SPEED]
                g.fillRect(72, 189, playerStats[SPEED] * 10, 6);
            }
        }
    }

}
