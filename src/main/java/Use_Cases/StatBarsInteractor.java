package Use_Cases;

import Entities.Player;

/**
 * Gets and returns the player's health, attack, and speed
 */
public class StatBarsInteractor implements StatBarsInputBoundary{
    Player player;
    public StatBarsInteractor(Player player){
        this.player = player;
    }

    /**
     * Gets the player's statistics
     * @return return output data containing the player's max and current health, strength, and speed
     */
    public StatBarsResponseModel getStats() {
        return (new StatBarsResponseModel(player.getMaxHealth(), player.getCurrentHealth(),
                player.getAttack(), player.getSpeed())); // TODO: Take the actual speed from the PlayerMovementController
    }
}
