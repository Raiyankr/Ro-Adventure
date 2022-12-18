package Use_Cases;

import Entities.Player;
import Entities.Enemy;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class PlayerAttack extends Attack{
    private Player player;  // TODO: should I access player through player movement?
    private PlayerMovement playerMovement;

    private int aniTick, aniIndex, aniSpeed= 10;
    private int playerAction = 0; // TODO might have to change this to some other number so that it doesnt think its attacking
    private boolean attacking = false;

    private static Ellipse2D.Float hitRadius;
    private static Ellipse2D.Float attackRadius;

    public PlayerAttack(Player player) {
        this.player = player;
        initHitRadius();
        initAttackRadius();
    }

    public void initHitRadius() {
        hitRadius = new Ellipse2D.Float(615, 325, 48, 48);
    }
    @Override
    public Ellipse2D.Float getHitRadius() {
        return hitRadius;
    }
    public void initAttackRadius() {
        attackRadius = new Ellipse2D.Float(590, 300, 100, 100);
    }
    public Ellipse2D.Float getAttackRadius() {
        return attackRadius;
    }

    public void setAttacking(boolean value) {
        player.setAttacking(value);
    }

    public void takeDamage(Enemy enemy){
        enemy.setHealth(enemy.getHealth() - player.getAttack());
    }

    public void drawAttackRadius(Graphics g) {
        g.setColor(Color.red);
        g.drawOval((int) attackRadius.x, (int) attackRadius.y, (int) attackRadius.width, (int) attackRadius.height);
    }

    public void drawHitRadius(Graphics g) {
        g.setColor(Color.red);
        g.drawOval((int) hitRadius.x, (int) hitRadius.y, (int) hitRadius.width, (int) hitRadius.height);
    }

    @Override
    public void updatePlayer() {

    }

    @Override
    public void updateMonsters() {

    }

    public void setAnimations(BufferedImage[][] animations2) {
        player.setAnimations(animations2);
    }

    public BufferedImage[][] getAnimations() {
        return player.getAnimations();
    }

    private void updateAnimation() {
        if (attacking) {
            if (playerMovement.getRight()) {
                playerAction = 0;
            } else { // playerMovement.getLeft() or up/down
                playerAction = 1;
            } //Needs testing for up and down
        } else if (player.getHit()){
            if (playerMovement.getRight()) {
                playerAction = 2;
            } else { // playerMovement.getLeft() or up/down
                playerAction = 3;
            }
        } // TODO add animations for DEAD
    }

    /**
     * Returns the sprite amount for specific player action:
     * - Attack left -> case 0
     * - Attack right -> case 1
     * - Hit left -> case 2
     * - Hit right -> case 3
     * - Dead left -> case 4
     * - Dead right -> case 5
     * @param playerAction
     * @return int spriteAmount
     */
    private int getSpriteAmount(int playerAction) {
        switch (playerAction) {
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
            if (aniIndex >= getSpriteAmount(playerAction)) {
                aniIndex = 0;
            }
        }
    }

    public BufferedImage getCurrentImage() {
        updateAnimationTick();
        updateAnimation();
        return player.getAnimations()[playerAction][aniIndex];
    }


}