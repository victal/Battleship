/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applet;

/**
 *
 * @author guilherme
 */
public enum Boat {
    SUBMARINE(1),CRUISER(2),CARRIER(3),BATTLESHIP(4),DESTROYER(5);
    
    private int size;
    private Boat(int size){
        this.size=size;
    }
    public int size(){return size;}
}
