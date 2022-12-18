package Entities;

public class Player {

    final private int STARTING_DMG = 10;
    final private int STARTING_HP = 100;
    private int attack = STARTING_DMG;
    
    // VARIABLES FOR SHOP SYSTEM
    private int maxHealth = STARTING_HP;
    private int currentHealth = maxHealth;
    private int gold = 0;

    public int getMaxHealth() { return this.maxHealth; }
    public int getCurrentHealth() {
        return this.currentHealth;

    }
    public int getAttack() { return attack; }

    /**
     * Returns the speed of the player
     */
//    public int getSpeed() { return velX + velY; }

    /**
     * Heals the player
     * @param amount How much health we regen
     */
    public void regenHealth(int amount){
        System.out.println("Health Before: " + getCurrentHealth());
        this.currentHealth += amount;
        if (getCurrentHealth() > 100){
            this.currentHealth = 100;
        }
        System.out.println("Health After: " + getCurrentHealth());
    }

    public int getGold(){
        return this.gold;
    }
    public void addGold(int gold){
        this.gold += gold;
    }
    public void removeGold(int amount){
        this.gold -= amount;
    }

}
