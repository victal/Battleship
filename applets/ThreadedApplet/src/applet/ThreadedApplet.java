/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applet;

import java.applet.Applet;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guilherme
 */
public class ThreadedApplet extends Applet implements Runnable,ActionListener{
   final int OK=0,FAIL=1,CANCEL=2,COMM=4;
   HashMap<String,ActiveCanvas> panels;
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
        this.setSize(800,600);
        thisPanel = new Panel();
        cl = new CardLayout();
        thisPanel.setLayout(cl);
        thisPanel.setSize(this.getSize());
        panels = new HashMap<String,ActiveCanvas>();
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
        ActiveCanvas c = new TitleScreen(this,this.getWidth(),this.getHeight());
        ((TitleScreen)c).init();
        //Component c = new GameScreen(15,15);
        panels.put("Title",c);
        this.setLayout(new FlowLayout());
        this.add(thisPanel);
        thisPanel.add("Title", c);
        cl.show(thisPanel,"Title");
        
        
    }

    @Override
    public void start() {
    }

    @Override
    public void stop() {
        suspended=true;
    }

    @Override
    public void destroy() {
    }
    

    @Override
    public void run() {
            //try {
                ActiveCanvas c = new GameScreen(15,15);
                panels.put("Game",c);
                thisPanel.add("Game", c);
                c = new BoatChooseScreen(this);
                panels.put("BoatSelect",c);
                thisPanel.add("BoatSelect", c);
                //t.sleep(1000);
//            } catch (InterruptedException ex) {
//            }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object src = ae.getSource();
        String cmd = (String)ae.getActionCommand();
        //OK -> Ir para o próximo painel,
        //com nome especificado no ActionCommand.
        if(ae.getID()==OK){
            //Adicionar quando um método start se mostrar necessário
            //panels.get(cmd).start();
            cl.show(thisPanel, cmd);
        }
        else if(ae.getID()==COMM){
            String[] command = ae.getActionCommand().split("[.]");
            if(command.length==3){
                ActiveCanvas c = panels.get(command[0]);
                for(Method i:c.getClass().getMethods())
                    if(i.getName().equals(command[1]))
                        try {
                    i.invoke(c, command[2]);
                } catch (IllegalAccessException ex) {
                } catch (IllegalArgumentException ex) {
                } catch (InvocationTargetException ex) {
                }
            }
        }
    }
}
