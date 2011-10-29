/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applet;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author guilherme
 */
public class TitleScreen extends Canvas{

    BufferedImage barco;
    int width,height;
    public TitleScreen() {
        this(800,600);
    }
    public TitleScreen(int width, int height){
        this.width=width;
        this.height=height;
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        this.setSize(width, height);
        try {
            barco = ImageIO.read(new File("images/ENG-BATTLESHIP.png"));
        } catch (IOException ex) {
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
        g.drawImage(barco.getSubimage(0, 0, 30, barco.getHeight()), 30, 30,null);
        g.drawImage(barco.getSubimage(61, 0, barco.getWidth()-61, 30), 120, 120,null);
    }
    
    
}
