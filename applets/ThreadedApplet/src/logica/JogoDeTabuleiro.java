/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Regis
 */
public interface JogoDeTabuleiro {
    public int getID();
    // id que identifica cada jogo.
    public int jogada(int idjogada,int tipo,int x,int y);
    // 
    public void atualiza();
    // vai atualizar todo o jogo.
    // verifica se houve jogada no servidor.
    public void start();
    // come�a o jogo.
    public int vezDaJogada();
    // diz quem deve jogar, se 1 ou 2.
    public Tabuleiro getTabuleiro();
    // retorna o tabuleiro em que o jogo ta ocorrendo.
}
