package Game;

import java.awt.Image;
import javax.swing.*;

public class Jogador {
    
    //Variáveis para localização do jogador e armazenamento dos ícones do jogador.
    private int tileX, tileY;
    private Image imgJogador, imgJogadorL;
                    
    
    public Jogador(){
        //Recebe os ícones do jogador
        ImageIcon img = new ImageIcon("icons\\jogador.png");
        imgJogador = img.getImage();
        img = new ImageIcon("icons\\jogador2.png");
        imgJogadorL = img.getImage();
        
        //Inicia o jogador na posição (1,1)
        tileX = 1;
        tileY = 1;
    }
    
    //Função para movimento do jogador, adiciona o X e Y ao local do jogador
    public void move(int tileX, int tileY ){
        this.setTileX(this.tileX + tileX);
        this.setTileY(this.tileY + tileY);
    }
    
    //Reseta posição do jogador
    public void resetPosition(){
        this.setTileX (1);
        this.setTileY (1);
    }
    
    //Gets e Sets
    public Image getImgJogador(){
        return imgJogador;
    }
    
    public int getTileX(){
        return tileX;
    }
    public int getTileY(){
        return tileY;
    }
    
    public void setTileX(int tileX){
        this.tileX = tileX;
    }
    
    public void setTileY(int tileY){
        this.tileY = tileY;
    }

    public Image getImgJogadorL() {
        return imgJogadorL;
    }
        
}
