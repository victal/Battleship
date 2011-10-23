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
        g.drawRect(0, 0, 
		   getWidth() - 1,
		   getHeight() - 1);
        
//        for(int i =0;i<getWidth() - 1;i+=30){
//            g.setColor(Color.RED);
//            g.drawLine(i, 0, i, getHeight()-1);
          g.drawString(getCodeBase().toString(),5,111);
          g.drawString(getDocumentBase().toString(),5,222);
            
          
//            g.drawImage(image4, 0,0,image1.getWidth(null),image1.getHeight(null), null);
//        }

	//Draw the current string inside the rectangle.
        //g.drawString(buffer.toString(), 5, 15);
    }
}
