package Game;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class Mapa {
    
    private Scanner scan;
    private String Mapa[] = new String [14];
    private Image caminho,
                  parede;
    
    public Mapa(){
        ImageIcon img = new ImageIcon( "C:\\Users\\Elizabeth\\Documents\\NetBeansProjects\\MazeRunner\\src\\Game\\caminho.png" );
        caminho = img.getImage();
        img = new ImageIcon( "C:\\Users\\Elizabeth\\Documents\\NetBeansProjects\\MazeRunner\\src\\Game\\parede.png" );
        parede = img.getImage();
        
        openFile();
        readFile();
        closeFile();
    }
    
    public void openFile(){
        
        try{
        scan = new Scanner(new File("C:\\Users\\Elizabeth\\Documents\\NetBeansProjects\\MazeRunner\\src\\Game\\mapa1.txt"));
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Mapa não encontrado!");
        }
    }
    
    public void readFile(){
        while( scan.hasNext() ){
            for(int i = 0; i < 14; i++){
                Mapa[i] = scan.next();
            }
        }
    }
    
    public void closeFile(){
        scan.close();
    }
    
        
    public Image getCaminho(){
        return caminho;
    }
    
    public Image getParede(){
        return parede;
    }
    
    public String getMapa( int x, int y ){
        String index = Mapa[y].substring(x, x + 1);
        return index;
    }
}
