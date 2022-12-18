package Interface_Adapters;

import Use_Cases.StatBarsInputBoundary;
import Use_Cases.StatBarsResponseModel;

/**
 * Presenter that retrieves the Player's current health, attack, and speed
 */
public class StatBarsPresenter implements StatBarsPresenterBoundary {

    final StatBarsInputBoundary statBarsInteractor;

    public StatBarsPresenter(StatBarsInputBoundary statBarsInteractor){
        this.statBarsInteractor = statBarsInteractor;
    }

    /**
     * Gets the player's statistics
     * @return Returns an array of integers such that
     *      array[0] is the player's max health
     *      array[1] is the player's current health
     *      array[2] is the player's strength
     *      array[3] is the player's speed
     */
    public int[] getStats() {
        StatBarsResponseModel statData = statBarsInteractor.getStats();
        return new int[] {statData.getMaxHealth(), statData.getCurrentHealth(),
                statData.getAttack(), statData.getSpeed()};
    }

}
