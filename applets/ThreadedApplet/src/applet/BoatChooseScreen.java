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
import java.util.HashMap;
import java.util.ListIterator;
import javax.imageio.ImageIO;
import javax.swing.event.ChangeEvent;


/**
 *
 * @author guilherme
 */
public class BoatChooseScreen extends ActiveCanvas implements ActionListener{
    int width,height;
    BufferedImage rarrow,larrow,gobutton;
    //HashMap<String,BufferedImage> flags;
    HashMap<BufferedImage,String>flags;
    ListIterator<BufferedImage> flagIterator;
    ArrayList<BufferedImage> flaglist = new ArrayList<BufferedImage>();
    BufferedImage flag;
    String names="";
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
        flags = new HashMap<BufferedImage,String>();
        for(Esquadra e: Esquadra.values()){
            try {
                flags.put(ImageIO.read(new File("images/flags/"+e.name()+".png")),e.name());
            } catch (IOException ignored) {
            }
        }
        flaglist.addAll(flags.keySet());
        flagIterator = flaglist.listIterator();
        flag = flagIterator.next();
        init();
    }
    @Override
    public void init() {
        this.setSize(width, height);
        try {    
            rarrow = ImageIO.read(new File("images/flags/rightarrow.jpg"));
            larrow = ImageIO.read(new File("images/flags/leftarrow.jpg"));
            gobutton = ImageIO.read(new File("images/go.png"));
            arrowsOffset = 100;
            buttonOffset = 100;
        } catch (IOException ex) {
            //do smth here;
        }
        addMouseListener(new CanvasMouseListener(this) {
            @Override
            public void mouseClicked(MouseEvent me) {
                
                if(mouseIn(getWidth()/2-larrow.getWidth()-arrowsOffset, getHeight()/2-flag.getHeight(),larrow,me)){
                    getOwner().actionPerformed(new ActionEvent(this, 0, "PreviousFlag"));
                }
                else if(mouseIn(getWidth()/2+arrowsOffset, getHeight()/2-flag.getHeight(),rarrow,me)){
                    getOwner().actionPerformed(new ActionEvent(this,0, "NextFlag"));
                }
                else if(mouseIn(getWidth()/2-gobutton.getWidth()/2, getHeight()/2+buttonOffset,gobutton,me)){
                    canvasManager.actionPerformed(new ActionEvent(this, 4, "Game.setEsquadra."+flags.get(flag)));
                    canvasManager.actionPerformed(new ActionEvent(this, 0, "Game"));
                }
            }
        });
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        g.setColor(Color.BLUE);
        g.fillRect(0,0,width,height);
//        for(Esquadra e: Esquadra.values())
//                names+=e.name()+" ";
//        names+=flags.size();
        //g.drawString(names,30, 30);
        g.drawImage(flag, getWidth()/2-flag.getWidth()/2, getHeight()/2-flag.getHeight(), this);
        g.drawImage(larrow, getWidth()/2-larrow.getWidth()-arrowsOffset, getHeight()/2-flag.getHeight(), this);
        g.drawImage(rarrow, getWidth()/2+arrowsOffset, getHeight()/2-flag.getHeight(), this);
        g.drawImage(gobutton, getWidth()/2-gobutton.getWidth()/2, getHeight()/2+buttonOffset, this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
        String cmd = e.getActionCommand();
        if(cmd.equals("NextFlag")){
            if(flagIterator.hasNext()){
                flag = flagIterator.next();
            }else{
                flagIterator=flaglist.listIterator();
                flag = flagIterator.next();
            }
        }
        else if(cmd.equals("PreviousFlag")){
            if(flagIterator.hasPrevious())
                flag = flagIterator.previous();
            else {
                while(flagIterator.hasNext())
                    flagIterator.next();
                flag = flagIterator.previous();
            }
        }
        repaint();
    }
    
}
