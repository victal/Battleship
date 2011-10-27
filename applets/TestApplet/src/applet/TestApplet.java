/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author guilherme
 */
public class TestApplet extends Applet {

   StringBuffer buffer;
   Image image1;
   Image image2;
   Image image3;

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
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, 
		   getWidth() - 1,
		   getHeight() - 1);
        g.setColor(Color.BLACK);
        g.fillRect(30, 30, 
		   getWidth() - 1,
		   getHeight() - 1);
        g.setColor(Color.RED);
        for(int i =1;i<getWidth() - 1;i+=30){
           g.drawLine(i, 31, i, getHeight()-1);
        }
        for(int i =1;i<getHeight() - 1;i+=30){
           g.drawLine(31, i,getWidth()-1,i);
        }
        //g.drawString(getCodeBase().toString(),5,111);//http://localhost/Battleship


	//Draw the current string inside the rectangle.
        //g.drawString(buffer.toString(), 5, 15);
    }
}
