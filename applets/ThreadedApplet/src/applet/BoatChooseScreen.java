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
import java.util.ArrayList;
import java.util.Iterator;
import javax.imageio.ImageIO;


/**
 *
 * @author guilherme
 */
public class BoatChooseScreen extends ActiveCanvas implements ActionListener{
    int width,height;
    BufferedImage rarrow,larrow,gobutton;
    //HashMap<String,BufferedImage> flags;
    ArrayList<BufferedImage>flags;
    Iterator<BufferedImage> flagIterator;
    BufferedImage flag;
    int arrowsOffset;
    int buttonOffset;

    public BoatChooseScreen(ActionListener al){
        this(al,800,600);
    }
    public BoatChooseScreen(ActionListener al, int width,int height){
        this.canvasManager = al;
        this.width=width;
        this.height=height;
        //flags = new HashMap<String, BufferedImage>();
        flags = new ArrayList<BufferedImage>();
        for(Esquadra e: Esquadra.values()){
            try {
                //flags.put(e.name(), ImageIO.read(new File("images/flags/"+e.name()+".png")));
                flags.add(ImageIO.read(new File("images/flags/"+e.name()+".png")));
            } catch (IOException ignored) {
            }
        }
        flagIterator = flags.iterator();
        flag = flagIterator.next();
    }
    @Override
    public void init() {
        this.setSize(width, height);
        this.setBackground(Color.blue);
        try {    
            rarrow = ImageIO.read(new File("images/flags/rightarrow.jpg"));
            larrow = ImageIO.read(new File("images/flags/leftarrow.jpg"));
            gobutton = ImageIO.read(new File("images/go.png"));
            arrowsOffset = 100;
            buttonOffset = 30;
        } catch (IOException ex) {
            //do smth here;
        }
        addMouseListener(new MouseListener() {

            public boolean mouseIn(int centerx,int centery, BufferedImage i, MouseEvent me){
                boolean xs = (centerx-i.getWidth()/2)<me.getX();
                boolean xg = (centerx+i.getWidth()/2)>me.getX();
                boolean ys = (centery-i.getHeight()/2)<me.getY();
                boolean yg = (centery+i.getHeight()/2)>me.getY();
                return xs&&xg&&ys&&yg;
            }
            @Override
            public void mouseClicked(MouseEvent me) {
                
                if(mouseIn(getWidth()/2-arrowsOffset,getHeight()/2,larrow,me)){
                    canvasManager.actionPerformed(new ActionEvent(this, 4, "PreviousFlag"));
                }
                else if(mouseIn(getWidth()/2+arrowsOffset,getHeight()/2,rarrow,me)){
                    canvasManager.actionPerformed(new ActionEvent(this, 4, "NextFlag"));
                }
                else if(mouseIn(getWidth()/2,getHeight()/2+buttonOffset,gobutton,me)){
                    canvasManager.actionPerformed(new ActionEvent(this, 0, "Game"));
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
        
        g.setColor(Color.BLUE);
        g.fillRect(0,0,width,height);
        g.drawImage(flag, getWidth()/2-flag.getWidth()/2, getHeight()/2-flag.getHeight(), this);
        g.drawImage(larrow, getWidth()/2-flag.getWidth()/2-arrowsOffset, getHeight()/2-flag.getHeight(), this);
        g.drawImage(rarrow, getWidth()/2-flag.getWidth()/2+arrowsOffset, getHeight()/2-flag.getHeight(), this);
        g.drawImage(gobutton, getWidth()/2-flag.getWidth()/2, getHeight()/2-flag.getHeight()+buttonOffset, this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
