package Use_Cases;

import Entities.Enemy;
import Entities.MeleeEnemy;
import Entities.RangedEnemy;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * This class manages all enemies of the game. It contains array lists of all Ranged monsters and Melee monsters,
 * allowing for all monsters to be accessed updated at once.
 */
public class EnemyManagerHandler implements CreateEnemyInputBoundary{

    private HashMap<String, MeleeEnemy> meleeEnemies;
    private HashMap<String, RangedEnemy> rangedEnemies;
    private int enemyCount = 0;

    /**
     * Creates new enemies, spawns them on the map, and adds each one to their respective array list.
     */
    public void createEnemies(int xDelta, int yDelta) {
        meleeEnemies = new HashMap<>();
        meleeEnemies.put("MeleeEnemy1", EnemySpawnInteractor.spawnMelee("meleeEnemy1", xDelta, yDelta));

        rangedEnemies = new HashMap<>();
        rangedEnemies.put("RangedEnemy1", EnemySpawnInteractor.spawnRanged("RangedEnemy1", xDelta, yDelta));
        enemyCount = meleeEnemies.size() + rangedEnemies.size();
    }

    public void removeEnemy(String enemyName){
        boolean check = RemoveEnemyInteractor.removeEnemy(enemyName, meleeEnemies, rangedEnemies);
        if (check){
            updateEnemyCount();
        }
    }

    private void updateEnemyCount(){
        enemyCount -= 1;
    }


    public int getEnemyCount(){
        return this.enemyCount;
    }

    /**
     * Returns a list of "spawned" enemies or null if no enemies were spawned.
     */
    public ArrayList<ArrayList> getEnemiesInfo() {

        ArrayList<ArrayList> enemyInfoList = new ArrayList<>();

        for (MeleeEnemy m : meleeEnemies.values()){
            ArrayList enemyInfo = new ArrayList<>();
            enemyInfo.add(m.getAnimations());
            enemyInfo.add(m.getVisualX());
            enemyInfo.add(m.getVisualY());
            enemyInfoList.add(enemyInfo);
        }

        for (RangedEnemy r : rangedEnemies.values()){
            ArrayList enemyInfo = new ArrayList<>();
            enemyInfo.add(r.getAnimations());
            enemyInfo.add(r.getVisualX());
            enemyInfo.add(r.getVisualY());

            enemyInfoList.add(enemyInfo);
        }

        return enemyInfoList;
    }

    public ArrayList<Enemy> getEnemies(){
        ArrayList<Enemy> enemyList = new ArrayList<>();
        enemyList.addAll(meleeEnemies.values());
        enemyList.addAll(rangedEnemies.values());
        return enemyList;
    }

    public ArrayList<Enemy> getMeleeEnemies(){
        ArrayList<Enemy> enemyList = new ArrayList<>();
        enemyList.addAll(meleeEnemies.values());
        return enemyList;
    }
    public ArrayList<Enemy> getRangedEnemies(){
        ArrayList<Enemy> enemyList = new ArrayList<>();
        enemyList.addAll(rangedEnemies.values());
        return enemyList;
    }

    public void updateEnemies(int xDelta, int yDelta) {
        for (MeleeEnemy m : meleeEnemies.values()){
            m.setVisualX(xDelta);
            m.setVisualY(yDelta);
            m.updateAttackHitRadius();
        }
        for (RangedEnemy r : rangedEnemies.values()){
            r.setVisualX(xDelta);
            r.setVisualY(yDelta);
            r.updateAttackHitRadius();
        }
    }
    public ArrayList<String> getEnemyID(){
        ArrayList<String> enemyNameList = new ArrayList<>();

        enemyNameList.addAll(meleeEnemies.keySet());
        enemyNameList.addAll(rangedEnemies.keySet());

        return enemyNameList;
    }

}