package Use_Cases;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public abstract class Attack {
    /**
     * Returns the hit radius of the creature.
     * @return Ellipse2D.Float hitRadius
     */
    public abstract Ellipse2D.Float getHitRadius();

//    /**
//     * Updates the hit radius position based on the creature's current position.
//     */
//    public abstract void updateHitRadius();

//    /**
//     * Initializes the creature's attack radius centered at the creature.
//     */
//    public abstract void initAttackRadius();

//    /**
//     * Returns the creature's attack radius.
//     * @return Ellipse2D.Float attackRadius
//     */
//    public abstract Ellipse2D.Float getAttackRadius();

//    /**
//     * Updates the attack radius position based on the creature's hit radius position.
//     */
//    public abstract void updateAttackRadius();

//    public abstract void setAttackHitAnimation();

//    /**
//     * Returns the sprite amount for specific action:
//     * - Attack left -> case 0
//     * - Attack right -> case 1
//     * - Hit left -> case 2
//     * - Hit right -> case 3
//     * @param creatureAction int
//     * @return int spriteAmount
//     */
//    public abstract int getSpriteAmount(int creatureAction);
//
//    /**
//     * Updates animation tick for the animations.
//     */
//    public abstract void updateAnimationTick();
//
//    /**
//     * Gets the current image depending on the creature's current action and animation index.
//     * @return BufferedImage currentImage
//     */
//    public abstract BufferedImage getCurrentImage();

//    /**
//     * Draws creature's attack radius on the gameplay screen. This method is only used for debugging the attack methods.
//     * For actual gameplay, this method is not used.
//     * @param g
//     */
//    public abstract void drawAttackRadius(Graphics g);

    /**
     * Updates Player
     */
    public abstract void updatePlayer();

    /**
     * Updates monsters
     */
    public abstract void updateMonsters();

}
