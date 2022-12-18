package Interface_Adapters;

import Use_Cases.MonsterAttackInputBoundary;
import Use_Cases.PlayerAttackInputBoundary;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AttackController {
    PlayerAttackInputBoundary playerAttackInputBoundary;
    MonsterAttackInputBoundary monsterAttackInputBoundary;

    public AttackController(PlayerAttackInputBoundary playerAttackInputBoundary,
                            MonsterAttackInputBoundary monsterAttackInputBoundary) {
        this.playerAttackInputBoundary = playerAttackInputBoundary;
        this.monsterAttackInputBoundary = monsterAttackInputBoundary;
    }

    public void playerAttack() {
        playerAttackInputBoundary.attack();
    }

    public void monsterAttack() {  // called on game loop (every loop)
        monsterAttackInputBoundary.attack();
    }

    public void update() {
        monsterAttack();
    }

    public void setAnimations(BufferedImage[][] animations) {
        playerAttackInputBoundary.setAnimations(animations);
    }

    // for debugging
    public void drawPlayerAttackRadius(Graphics g) {
        playerAttackInputBoundary.drawPlayerAttackRadius(g);
    }
    public void drawPlayerHitRadius(Graphics g) {
        playerAttackInputBoundary.drawPlayerHitRadius(g);
    }

    public void drawMonstersAttackRadius(Graphics g) {
        monsterAttackInputBoundary.drawMonstersAttackRadius(g);
    }

    public void drawMonstersHitRadius(Graphics g) {
        monsterAttackInputBoundary.drawMonstersHitRadius(g);
    }

}
