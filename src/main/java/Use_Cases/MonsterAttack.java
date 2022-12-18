package Use_Cases;

import Entities.Enemy;
import Entities.Player;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class MonsterAttack extends Attack{

    private Player player;
    private Enemy enemy;

    private int aniTick, aniIndex, aniSpeed= 10;
    private boolean attacking = false, hit = false;
    private int enemyAction = 0; // TODO might have to change this to some other number so that it doesnt think its attacking
    private Ellipse2D.Float hitRadius;
    private Ellipse2D.Float attackRadius;

    public MonsterAttack(Player player) {
        this.player = player;
    }

    @Override
    public Ellipse2D.Float getHitRadius() {
        hitRadius = new Ellipse2D.Float(enemy.getHelperX(), enemy.getHelperY(), 48, 48);
        return hitRadius;
    }

    @Override
    public void updatePlayer() {
    }

    @Override
    public void updateMonsters() {
    }

    public void takeDamage(Enemy enemy) {
        player.setCurrentHealth(player.getCurrentHealth() - enemy.getDMG());
    }

    public void setAnimations(BufferedImage[][] animations) {
        enemy.setAnimations(animations);
    }

    public BufferedImage[][] getAnimations() {
        return enemy.getAnimations();
    }

    private void updateAnimation() {
        if (attacking) {
//            if (enemyMovement.getRight()) {
                enemyAction = 0;
//            } else { // playerMovement.getLeft() or up/down
//                enemyAction = 1;
//            } //Needs testing for up and down
        } else if (hit){
//            if (enemyMovement.getRight()) {
                enemyAction = 2;
//            } else { // playerMovement.getLeft() or up/down
//                enemyAction = 3;
            }
        } // TODO add animations for DEAD
//    }

    /**
     * Returns the sprite amount for specific player action:
     * - Attack left -> case 0
     * - Attack right -> case 1
     * - Hit left -> case 2
     * - Hit right -> case 3
     * - Dead left -> case 4
     * - Dead right -> case 5
     * @param monsterAction
     * @return int spriteAmount
     */
    private int getSpriteAmount(int monsterAction) {
        switch (MonsterAttack.this.enemyAction) {
            case 0:
            case 1:
                return 7;
            case 2:
            case 3:
            case 4:
            case 5:
                return 5;
            default:
                return 1;
        }
    }

    private void updateAnimationTick() {
        aniTick ++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= getSpriteAmount(enemyAction)) {
                aniIndex = 0;
            }
        }
    }

    public BufferedImage getCurrentImage() {
        updateAnimationTick();
        updateAnimation();
        return enemy.getAnimations()[enemyAction][aniIndex];
    }
}
