/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author guilherme
 */
public class GameScreen extends ActiveCanvas{

    BufferedImage barco;
    String esquadra="ENG";
    //Diagrama do tabuleiro de Jogo:
    //Top: 30 px para título e letras do tabuleiro
    //Left: 20 px para números do Tabuleiro
    //Tabuleiro x: 20 até 20 + 30*n, n= numero de colunas
    //Tabuleiro y: 30 até 30 + 30*n, n= numero de linhas
    int width,height;
    public GameScreen() {
        this(15,15);
    }
    public GameScreen(int columns, int rows){
        this.width=20+30*columns;
        this.height=30*(rows+1);
    }
    @Override
    public void init() {}    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        this.setSize(width, height);
        try {
            barco = ImageIO.read(new File("images/"+esquadra+"-BATTLESHIP.png"));
        } catch (IOException ex) {}
        g.setColor(Color.gray);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.BLACK);
        g.fillRect(20, 30, 
		   getWidth() - 1,
		   getHeight() - 1);
        g.setColor(Color.RED);
        for(int i =20;i<getWidth() - 1;i+=30){
           g.drawLine(i, 30, i, getHeight()-1);
        }
        for(int i =30;i<getHeight() - 1;i+=30){
           g.drawLine(20, i,getWidth()-1,i);
        }
        g.drawImage(barco.getSubimage(0, 0, 30, barco.getHeight()), 20, 30,this);
        g.drawImage(barco.getSubimage(61, 0, barco.getWidth()-61, 30), 110, 120,this);
    }
    public void setEsquadra(String e){
        //esquadra = e;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
