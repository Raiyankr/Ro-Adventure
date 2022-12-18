package Use_Cases.EnemyUseCases;

import Entities.Enemy.MeleeEnemy;
import Entities.Enemy.RangedEnemy;

import java.util.HashMap;

public class RemoveEnemyInteractor {
    public static boolean removeEnemy(String enemyName, HashMap<String, MeleeEnemy> meleeEnemies, HashMap<String, RangedEnemy> rangedEnemies){
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