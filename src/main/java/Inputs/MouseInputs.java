package Inputs;

import Frameworks.GamePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

// TODO: Anyone
//  - This can totally be deleted, since we are not using it
public class MouseInputs implements MouseListener, MouseMotionListener {
    private GamePanel gamePanel;
    // Remove the Motionlistener later :)

    public MouseInputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("CLICK!");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
/*        this.gamePanel.setPointerLocation(e.getX(), e.getY());*/
    }
}
