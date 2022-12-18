package Interface_Adapters;

import java.awt.image.BufferedImage;

public class AttackDamageAnimationsImportController {
    AttackController attackController;
    /**
     * This constructor passes on all the imported images from the
     * frameworks layer to the controllers
     *@param playerAnimations: contains all the sprites for player animations
     */
    public AttackDamageAnimationsImportController(BufferedImage[][] playerAnimations,
                                                  AttackController attackController) {
        this.attackController = attackController;
        playerAutoImport2(playerAnimations);
    }
    /**
     * Passes a list of all the sprites that are used for player animations
     * @param playerAnimations all the animations of player
     */
    public void playerAutoImport2(BufferedImage[][] playerAnimations) {
        attackController.setAnimations(playerAnimations);
    }
}
