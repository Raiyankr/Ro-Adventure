package Frameworks.VisualLoad;

import java.util.Random;

/**
 * This class creates Leaf instances for pure visual purposes.
 */
public class LoadLeafEffect {
    private int x = randomCoord(), y = 0;

    public void positionChange(){
        x++;
        y++;

        if (x>= 1280 || y >= 720){
            x = randomCoord();
            y = 0;
        }
    }

    public int getX(){return this.x;}
    public int getY(){return this.y;}

    public int randomCoord(){
        Random r = new Random();
        return r.nextInt((1200 - (-1200)) + 1) -1200;
    }
}
