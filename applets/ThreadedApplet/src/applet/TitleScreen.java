/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author guilherme
 */
public class TitleScreen extends ActiveCanvas{
    int width,height;
    BufferedImage logo;
    BufferedImage jogar;
    int xlogo,ylogo;
    int xjogar,yjogar;

    public TitleScreen(ActionListener al){
        this(al,800,600);
    }
    public TitleScreen(ActionListener al, int width,int height){
        this.canvasManager = al;
        this.width=width;
        this.height=height;
    }
    @Override
    public void init() {
        this.setSize(width, height);
        this.setBackground(Color.blue);
        try {    
            logo = ImageIO.read(new File("images/title/logo.png"));
            jogar = ImageIO.read(new File("images/title/play.png"));
            xlogo=width/2-logo.getWidth()/2;
            ylogo=30;
            xjogar=width/2-jogar.getWidth()/2;
            yjogar=height-30-jogar.getHeight()/2;
        } catch (IOException ex) {
            //do smth here;
        }
        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                boolean xs = me.getX()>(xjogar-jogar.getWidth()/2);
                boolean xg = me.getX()<(xjogar+jogar.getWidth()/2);
                boolean ys = me.getY()>(yjogar-jogar.getHeight()/2);
                boolean yg = me.getY()<(yjogar+jogar.getHeight()/2);
                if(xs&&xg&&ys&&yg){
                    canvasManager.actionPerformed(new ActionEvent(this, 0, "BoatSelect"));
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {
                mouseClicked(me);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            @Override
            public void mouseEntered(MouseEvent me) {
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            @Override
            public void mouseExited(MouseEvent me) {
                //throw new UnsupportedOperationException("Not supported yet.");
            }
        });
    }

    @Override
    public void start() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void stop() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
//        g.setColor(Color.);
//        g.fillRect(0,0,width,height);
        g.drawImage(logo, xlogo,ylogo, this);
        g.drawImage(jogar, xjogar,yjogar, this);
    }
    
}
