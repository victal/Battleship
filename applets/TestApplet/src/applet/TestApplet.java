/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

/**
 *
 * @author guilherme
 */
public class TestApplet extends Applet implements Runnable{
    
   StringBuffer buffer;
   BufferedImage barco;
   Thread t;
   int x,y;
   boolean suspended;
    @Override
    public void init() {
        this.setSize(800, 600);
        x=y=30;
        this.setBackground(Color.GRAY);
        buffer = new StringBuffer();
        addItem("initializing... ");
//        try {
//            SwingUtilities.invokeAndWait(new Runnable() {
//                @Override
//                public void run() {
//                    paintTabuleiro();    
//                }
//            });
//        } catch (InterruptedException ex) {
//            //Logger.getLogger(TestApplet.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InvocationTargetException ex) {
//            //Logger.getLogger(TestApplet.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
        addItem("starting... ");
    }

    @Override
    public void stop() {
        addItem("stopping... ");
        suspended=true;
    }

    @Override
    public void destroy() {
        addItem("preparing for unloading...");
    }

    private void addItem(String newWord) {
        System.out.println(newWord);
        buffer.append(newWord);
        repaint();
    }
    private void paintTabuleiro(Graphics g){
        
        try {
            barco = ImageIO.read(new File("images/ENG-BATTLESHIP.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        g.setColor(Color.gray);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.BLACK);
        g.fillRect(30, 30, 
		   getWidth() - 1,
		   getHeight() - 1);
        g.setColor(Color.RED);
        for(int i =0;i<getWidth() - 1;i+=30){
           g.drawLine(i, 30, i, getHeight()-1);
        }
        for(int i =0;i<getHeight() - 1;i+=30){
           g.drawLine(30, i,getWidth()-1,i);
        }
        //fundo.getSubimage(0, 0, 30, fundo.getHeight());
        g.drawImage(barco.getSubimage(0, 0, 30, barco.getHeight()), 30, x,this);
        g.drawImage(barco.getSubimage(61, 0, barco.getWidth()-61, 30), x, 120,this);
        repaint();
    }
    @Override
    public void paint(Graphics g) {
	//Draw a Rectangle around the applet's display area.
        paintTabuleiro(g);
        
        
//        try {
//            barco = ImageIO.read(new File("ENG-BATTLESHIP.jpg"));
//        } catch (IOException ex) {
//            Logger.getLogger(TestApplet.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        
       
//        g.drawImage(img, 0, 0,this);
        //g.drawString(getCodeBase().toString(),5,111);//http://localhost/Battleship


	//Draw the current string inside the rectangle.
        //g.drawString(buffer.toString(), 5, 15);
    }

    @Override
    public void run() {
       int i = 0;
        while(x<800 && y<600){
       x+=30;
       y+=30;
       repaint();
            try {
                t.sleep(10000);
            } catch (InterruptedException ex) {
            }
       }
    }
}
