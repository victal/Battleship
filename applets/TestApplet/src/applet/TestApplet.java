/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author guilherme
 */
public class TestApplet extends Applet {

   StringBuffer buffer;
   BufferedImage fundo;
    @Override
    public void init() {
        buffer = new StringBuffer();
        addItem("initializing... ");
    }

    @Override
    public void start() {
        addItem("starting... ");
    }

    @Override
    public void stop() {
        addItem("stopping... ");
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

    @Override
    public void paint(Graphics g) {
	//Draw a Rectangle around the applet's display area.
        this.setSize(800, 600);
        Image img = getImage(getCodeBase(), "science.jpg");
        fundo = new BufferedImage(img.getWidth(this),img.getHeight(this),BufferedImage.TYPE_4BYTE_ABGR);
        Graphics gr = fundo.createGraphics();
        gr.drawImage(img, 0,0,null);
        gr.dispose();
        
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, 
		   getWidth() - 1,
		   getHeight() - 1);
        
        g.setColor(Color.BLACK);
        g.fillRect(30, 30, 
		   getWidth() - 1,
		   getHeight() - 1);
        g.setColor(Color.RED);
        for(int i =30;i<getWidth() - 1;i+=30){
           g.drawLine(i, 30, i, getHeight()-1);
        }
        for(int i =30;i<getHeight() - 1;i+=30){
           g.drawLine(30, i,getWidth()-1,i);
        }
        g.drawImage(fundo, 0, 0,this);
        //g.drawString(getCodeBase().toString(),5,111);//http://localhost/Battleship


	//Draw the current string inside the rectangle.
        //g.drawString(buffer.toString(), 5, 15);
    }
}
