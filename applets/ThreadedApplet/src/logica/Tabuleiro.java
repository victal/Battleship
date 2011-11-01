/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Regis
 */
public interface Tabuleiro {
    public int getNumLinhas();
    public int getNumColunas();
    public int[][] getJogadas();
    public int[][] getPosicoes();
    public int getJogada(int x,int y); 
    // 0 se x,y não foi jogado
    // 1 se x,y já foi jogado
    // -1 não válido.
    public int setJogada(int x,int y);
    // -1 se não é valido.
    // faz a jogada em x,y e retorna o que havia em x,y. 
    public boolean isOver();
}
