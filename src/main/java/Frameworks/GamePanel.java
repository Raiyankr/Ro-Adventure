package Frameworks;

import Entities.MeleeEnemy;
import Entities.Player;
import Inputs.KeyboardInputs;
import Inputs.MouseInputs;
import Interface_Adapters.*;

//TODO: Kevin
//  - This can't be here
import Entities.ShopSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class GamePanel extends JPanel implements UpdateScreenBoundary {

    final int MAX_HEALTH = 0;
    final int CURRENT_HEALTH = 1;
    final int STRENGTH = 2;
    final int SPEED = 3;
    //TODO: Abu
    //  - Can't directly have access to Player
    public Player player;


    // TODO: Kevin
    //  - Implement shop system CLEAN way
    //  - Can't have access to shop directly
    private ShopSystem gameShop;
    private JLabel timerGui;

    StatBarsPresenterBoundary statBarsPresenterBoundary;

    private boolean showStatBar = true;

    private ArrayList<Leaf> leafList = new ArrayList<>();

    //TODO: Raiyan
    //  - Import these images separately
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

    //TODO: Kevin
    //  - import the potion images

    //TODO: Abu, Khushil
    //  -Move enemyList to Enemy Manager
    private MeleeEnemy[] enemyList;
    public MeleeEnemy enemyOne;
    public MeleeEnemy enemyTwo;

    // THIS IS GOOD STUFF
    PauseGameController pauseGameController;
    ShowMapController showMapController;
    PlayerMovementController playerMovementController;
    ShowStatsController showStatsController;

    public GamePanel(){
        // Adding leaves
        leafList.add(new Leaf());
        leafList.add(new Leaf());
        setTimerGui();
        importImage();
        this.setBackground(new Color(0, 0, 0));

        // Initializing methods
        // Creates shop instance
        //TODO: Kevin
        //  - Create the shop using CLEAN arch
        //  - Can't do this in GamePanel
/*
        gameShop = new ShopSystem(player);
*/

    }


    public void setUp(PauseGameController pauseGameController, ShowMapController showMapController,
                      StatBarsPresenterBoundary statBarsPresenterBoundary, ShowStatsController showStatsController, 
                      PlayerMovementController playerMovementController){
        this.pauseGameController = pauseGameController;
        this.showMapController = showMapController;
        this.showStatsController = showStatsController;
        this.statBarsPresenterBoundary = statBarsPresenterBoundary;
        this.playerMovementController = playerMovementController;

        // TODO: Pass in KeyboardInputController instead of GamePanel
        addKeyListener(new KeyboardInputs(pauseGameController, showMapController,
                showStatsController, playerMovementController));
        addMouseListener(new MouseInputs(this));
    }

    private void setTimerGui(){
        timerGui = new JLabel(String.valueOf(120));
        timerGui.setBounds(605, -19, 100, 100);
        timerGui.setFont(new Font("Arial", Font.PLAIN, 35));
        timerGui.setForeground(new Color(150, 203, 187));
        add(timerGui);
    }
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

    //TODO: Khushil
    //  - Move this to Enemy Manager Class
    public MeleeEnemy[] getEnemyList() {
        return this.enemyList;
    }

    // TODO: Raiyan
    //  - Move this entire class to a separate class to import images
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
        //TODO: Abu - Access player and enemy through an interface using CLEAN way
/*
        g.drawImage(player.getCurrentImage(), enemyOne.getXEnemy(), enemyOne.getYEnemy(), null);
        g.drawImage(player.getCurrentImage(), enemyTwo.getXEnemy(), enemyTwo.getYEnemy(), null);
*/


        //TODO: Kevin
        // Handle shop stuff using CLEAN way

        // SHOP VISUAL GOES HERE
/*
        g.drawImage(shopKeeper, xDelta + 1857, yDelta + 1676, null);
        if (gameShop.getItemList().contains("Health Potion")){
            g.drawImage(healthPotion, xDelta + 1857, yDelta + 1726, null);
        }
*/

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