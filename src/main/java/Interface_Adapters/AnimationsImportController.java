package Interface_Adapters;

import java.awt.image.BufferedImage;
/**
 * This class passes the imported images into the player controller and enemy controller
 */
public class AnimationsImportController {
    PlayerMovementController playerMovementController;
    /**
     * This constructor passes on all the imported images from the
     * frameworks layer to the controllers
     *@param playerAnimations: contains all the sprites for player animations
     */
    public AnimationsImportController(BufferedImage[][] playerAnimations, PlayerMovementController playerMovementController) {
        this.playerMovementController = playerMovementController;
        playerAutoImport(playerAnimations);
    }
    /**
     * Passes a list of all the sprites that are used for player animations
     * @param playerAnimations all the animations of player
     */
    public void playerAutoImport(BufferedImage[][] playerAnimations) {
        playerMovementController.setAnimations(playerAnimations);
    }
}
