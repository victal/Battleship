/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applet;

import java.applet.Applet;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author guilherme
 */
public class ThreadedApplet extends Applet implements Runnable{

   ArrayList<Component> panels;
   StringBuffer buffer;
   BufferedImage barco;
   CardLayout cl;
   Thread t;
   int x,y;
   Panel thisPanel;
   Panel p1;
   boolean suspended;
    @Override
    public void init() {
        this.setSize(800, 600);
        thisPanel = new Panel();
        cl = new CardLayout();
        thisPanel.setLayout(cl);
        thisPanel.setSize(this.getSize());
        Component c = new TitleScreen(800,600);
        panels = new ArrayList<Component>();
        panels.add(c);
        p1 = new Panel();
        p1.setBackground(Color.yellow);
        this.setLayout(new FlowLayout());
        this.add(thisPanel);
        thisPanel.add("First", c);
        thisPanel.add("Second",p1);
        cl.first(thisPanel);
        
    }

    @Override
    public void start() {
        
        if(t==null){
            t=new Thread(this);
            t.start();
        }
        else if(suspended){
            suspended = false;
            synchronized(this){
                notify();
            }
        }
    }

    @Override
    public void stop() {
        suspended=true;
    }

    @Override
    public void destroy() {
    }

    private void addItem(String newWord) {
        repaint();
    }
    

    @Override
    public void run() {
            try {
                t.sleep(1000);
            } catch (InterruptedException ex) {
            }
    }
}
