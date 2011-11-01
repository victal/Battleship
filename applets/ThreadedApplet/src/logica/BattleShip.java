/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Regis
 */
public class BattleShip implements JogoDeTabuleiro{
    private int ID;
    private Tabuleiro tabuleiro;
    private int vez;

    public BattleShip(int id, Tabuleiro t){
        this.ID=id;
        this.tabuleiro=t;
        vez=0;
    }
    
    @Override
    public int getID() {
        return ID;
    }

    @Override
    public int jogada(int idjogada, int tipo, int x, int y) {
        vez++;
        vez=vez%2;
        if(tipo==1){
            return tabuleiro.setJogada(x, y);
        }
        return -1;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void atualiza() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void start() {
        vez=0;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int vezDaJogada() {
        return vez;
    }

    @Override
    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
    
}
