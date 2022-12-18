package Use_Cases.VisualUseCases;

/**
 * Data Structure that contains the player health, attack, and speed
 */
public class StatBarsResponseModel {
    int maxHealth;
    int currentHealth;
    int attack;
    int speed;

    public StatBarsResponseModel(int maxHealth, int currentHealth, int attack, int speed) {
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.attack = attack;
        this.speed = speed;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
    public int getCurrentHealth() {
        return currentHealth;
    }
    public int getAttack() {
        return attack;
    }
    public int getSpeed() { return speed; }
}
