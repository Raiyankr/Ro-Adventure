package Use_Cases;

import Entities.MeleeEnemy;
import Entities.RangedEnemy;

import java.util.HashMap;

public class RemoveEnemyInteractor {
    private HashMap<String, MeleeEnemy> meleeEnemies;
    private HashMap<String, RangedEnemy> rangedEnemies;

    RemoveEnemyInteractor(HashMap<String, MeleeEnemy> meleeEnemies, HashMap<String, RangedEnemy> rangedEnemies){
        this.meleeEnemies = meleeEnemies;
        this.rangedEnemies = rangedEnemies;
    }

    public boolean removeEnemy(String enemyName){
        if(enemyName.charAt(0) == 'M'){
            meleeEnemies.remove(enemyName);
            return true;
        }else if (enemyName.charAt(0) == 'R'){
            rangedEnemies.remove(enemyName);
            return true;
        }else{
            return false;
        }
    }
}
