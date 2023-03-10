package Use_Cases.EnemyUseCases;

import Entities.Enemy.MeleeEnemy;

import Entities.Enemy.RangedEnemy;

public class EnemySpawnInteractor {

    public static MeleeEnemy spawnMelee(String name, int xDelta, int yDelta){
        return new MeleeEnemy(name, xDelta, yDelta, 3780, 3220);
    }

    public static RangedEnemy spawnRanged(String name, int xDelta, int yDelta){
        return new RangedEnemy(name, xDelta, yDelta, 4000, 4000);
    }

}
