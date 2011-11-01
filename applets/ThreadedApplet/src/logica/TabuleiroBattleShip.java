/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Regis
 */
public class TabuleiroBattleShip implements Tabuleiro{
    private int numLinhas, numColunas;
    private int[][] jogadas, posicoes;
    private int casas;
    
    public TabuleiroBattleShip(int linhas, int colunas, int[][] Posicoes){
        this.posicoes = Posicoes;
        this.numLinhas = linhas;
        this.numColunas = colunas;
        this.jogadas = new int[linhas][colunas];
        int i,j;
        casas=0;
        for(i=0;i<linhas;i++){
            for(j=0;j<colunas;j++){
                jogadas[i][j]=0; //n�o houve nenhuma jogada ainda.
                if(posicoes[i][j]>0){
                    casas++;
                }
            }
        }
    }
    
    @Override
    public int getNumLinhas() {
        return numLinhas;
    }

    @Override
    public int getNumColunas() {
        return numColunas;
    }
    
    @Override
    public int[][] getJogadas() {
        return jogadas;
    }

    @Override
    public int[][] getPosicoes() {
        return posicoes;
    }

    @Override
    public int setJogada(int x, int y) {
        int barco=-1;
        if(x<numLinhas && x>=0 && y<numColunas && y>=0){
            if(jogadas[x][y]==0){
                jogadas[x][y]=1;
                if(posicoes[x][y]>0){
                    casas--;
                }
                barco = posicoes[x][y]; //fez a jogada e setou como valida.
            }
            else{
                barco=-1;
            }
        }
        else{
            barco=-1;
        }
        return barco;
    }
    
    @Override
    public int getJogada(int x, int y) {
        if(x<numLinhas && x>=0 && y<numColunas && y>=0){
            return jogadas[x][y]; 
        }
        return -1; //n�o est� no tabuleiro
    }

    @Override
    public boolean isOver() {
        if(casas==0){
            return true;
        }
        return false;
    }
        
}
