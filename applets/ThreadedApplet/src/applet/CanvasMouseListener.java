/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applet;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

/**
 *
 * @author Guilherme Victal
 */
public class CanvasMouseListener implements MouseListener{
    private ActiveCanvas owner;

    public ActiveCanvas getOwner() {
        return owner;
    }

    public void setOwner(ActiveCanvas owner) {
        this.owner = owner;
    }
    public CanvasMouseListener(ActiveCanvas owner){
        this.owner=owner;
    }
    public boolean mouseIn(int xinit,int yinit, BufferedImage i, MouseEvent me){
                boolean xs = xinit<=me.getX();
                boolean xg = (xinit+i.getWidth())>=me.getX();
                boolean ys = yinit<=me.getY();
                boolean yg = (yinit+i.getHeight())>=me.getY();
                return xs&&xg&&ys&&yg;
    }
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    
}
