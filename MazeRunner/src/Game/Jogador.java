package Game;

import java.awt.Image;
import javax.swing.*;

public class Jogador {
    
    private int tileX, tileY;
    private Image imgJogador;
    
    public Jogador(){
        ImageIcon img = new ImageIcon("C:\\Users\\Elizabeth\\Documents\\NetBeansProjects\\MazeRunner\\src\\Game\\jogador.png");
        imgJogador = img.getImage();
        
        tileX = 1;
        tileY = 1;
    }
    
    public void move(int tileX, int tileY ){
        this.tileX += tileX;
        this.tileY += tileY;
    }
 
    public Image getJogador(){
        return imgJogador;
    }
    
    public int getTileX(){
        return tileX;
    }
    public int getTileY(){
        return tileY;
    }
    
}
