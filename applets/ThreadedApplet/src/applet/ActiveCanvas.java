/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applet;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.ActionListener;

/**
 *
 * @author guilherme
 */
public abstract class ActiveCanvas extends Canvas implements ActionListener {
    public ActionListener canvasManager=null;
    public abstract void init();
    //public abstract void start();
    //public abstract void stop();
    //public abstract void destroy();
    @Override
    public void paint(Graphics g){
        super.paint(g);
    }
    
}
