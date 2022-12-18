package Use_Cases;

import Entities.Enemy;
import Entities.MeleeEnemy;
import Entities.RangedEnemy;
import Frameworks.GamePanel;

import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.HashMap;

//import static Entities.MonsterConstants.*;
/**
 *
 * This class manages all enemies of the game. It contains array lists of all Ranged monsters and Melee monsters,
 * allowing for all monsters to be accessed updated at once.
 */
public class EnemyManagerInteractor {

    private GamePanel gamePanel;
    private int xDelta = -2546, yDelta = -2132;


    private int enemyCount;

    RemoveEnemyInteractor enemyRemoveInteractor;



    private HashMap<String, MeleeEnemy> meleeEnemies;
    private HashMap<String, RangedEnemy> rangedEnemies;

    public EnemyManagerInteractor(GamePanel gamePanel) {
        //TODO: Need to remove this later
        this.gamePanel = gamePanel;

        createEnemies();
        enemyCount = meleeEnemies.size() + rangedEnemies.size();
        enemyRemoveInteractor = new RemoveEnemyInteractor(meleeEnemies, rangedEnemies);
    }

    /**
     * Creates new enemies, spawns them on the map, and adds each one to their respective array list.
     */
    private void createEnemies() {  // TODO: update with monster spawn methods
        MeleeEnemy meleeOne = new MeleeEnemy(gamePanel, xDelta, yDelta, 3780, 3220);
        RangedEnemy rangedOne = new RangedEnemy(gamePanel, xDelta, yDelta, 4000, 4000);

        meleeEnemies = new HashMap<>();
        rangedEnemies = new HashMap<>();
        meleeEnemies.put("MeleeEnemy1", meleeOne);
        rangedEnemies.put("RangedEnemy1", rangedOne);
    }

    public void removeEnemy(String enemyName){
        boolean check = enemyRemoveInteractor.removeEnemy(enemyName);
        if (check){
            updateEnemyCount();
        }
    }

    private void updateEnemyCount(){
        enemyCount -= 1;
    }


    //TODO: Use this Khushil/Sergio for the end game
    public int getEnemyCount(){
        return this.enemyCount;
    }

    /**
     Returns a list of "spawned" enemies or null if no enemies were spawned.
     */
    public ArrayList<Enemy> getEnemies() {
        ArrayList<Enemy> enemyList = new ArrayList<>();

        enemyList.addAll(meleeEnemies.values());
        enemyList.addAll(rangedEnemies.values());

        return enemyList;
    }

    public ArrayList<String> getEnemyID(){
        ArrayList<String> enemyNameList = new ArrayList<>();

        enemyNameList.addAll(meleeEnemies.keySet());
        enemyNameList.addAll(rangedEnemies.keySet());

        return enemyNameList;
    }

    // check if monsters took damage from player's attacks

    /**
     * Checks if any monsters took damage from the Player's attack. This method is called when the Player's attacking
     * state is true. For each monster in the game, it checks for the intersection between the Player's attack radius
     * and the monster's hitbox. If there is an intersection, meaning that the monster was within the Player's attack
     * radius, the monster takes damage. It calls the method takeDamage to do so.
     * @param attackRadius
     */

     // TODO: take care of this in the attack methods
//    public void checkMonsterHit(Ellipse2D.Float attackRadius) {
//        for (RangedEnemy r : rangedEnemies.values()) {
//            Area playerAttackRadius = new Area(attackRadius);     // find area of Player's attack box
//            playerAttackRadius.intersect(new Area(r.getHitBox()));      // find intersection between Player attackbox and enemy hitbox
//            if (!playerAttackRadius.isEmpty()) {  // player attack box and monster hitbox do intersect
//                r.takeDamage();   // takes damage and updates animation (HIT or DEAD)
//                return;
//            }
//        }
//        for (MeleeEnemy m : meleeEnemies.values()) {
//            Area playerAttackRadius = new Area(attackRadius);     // find area of Player's attack box
//            playerAttackRadius.intersect(new Area(m.getHitBox()));      // find intersection between Player attackbox and enemy hitbox
//            if (!playerAttackRadius.isEmpty()) {  // player attack box and monster hitbox do intersect
//                m.takeDamage();   // takes damage and updates animation (HIT or DEAD)
//                return;
//            }
//        }
//    }

    /**
     * This method is called once in SOMETHING!!!!!!!!!!!!! and it updates all monsters in the game.
     */
     // TODO: take care of this in the different enemy classes
//    public void update() {
//        for (RangedEnemy r : rangedEnemies.values())
//            r.update();
//        for (MeleeEnemy m : meleeEnemies.values())
//            m.update();
//    }

}
