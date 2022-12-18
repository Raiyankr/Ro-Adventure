package Use_Cases;

import Entities.Enemy;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerAttackInteractor implements PlayerAttackInputBoundary{

    private final PlayerAttack playerAttack;
    private final Ellipse2D.Float playerAttackRadius;
    private final ArrayList<Enemy> enemies;

    public PlayerAttackInteractor(PlayerAttack playerAttack, ArrayList<Enemy> enemies) {
        this.playerAttack = playerAttack;
        this.playerAttackRadius = playerAttack.getAttackRadius();
//        this.meleeEnemies = enemyManagerHandler.getMeleeEnemies();
//        this.rangedEnemies = enemyManagerHandler.getRangedEnemies();
        this.enemies = enemies;
    }

    @Override
    public void attack() {
        playerAttack.setAttacking(true);

        for (Enemy e : enemies) {
            if (playerAttackRadius.intersects(e.getVisualX(), e.getVisualX(), 36, 36)) {
                e.setHit(true);
                playerAttack.takeDamage(e);
            }
        }
    }

    @Override
    public void drawPlayerAttackRadius(Graphics g) {
        playerAttack.drawAttackRadius(g);
    }

    @Override
    public void drawPlayerHitRadius(Graphics g) {
        playerAttack.drawHitRadius(g);
    }

    @Override
    public void updatePlayer() {
        playerAttack.updatePlayer();
    }

    @Override
    public void updateMonsters() {
        playerAttack.updateMonsters();
    }

    @Override
    public BufferedImage getCurrAnimation() {
        return playerAttack.getCurrentImage();
    }

    @Override
    public void setAnimations(BufferedImage[][] animations) {
        playerAttack.setAnimations(animations);
    }

    @Override
    public BufferedImage[][] getAnimations() {
        return playerAttack.getAnimations();
    }

}
