package Game;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class Mapa {
    //Variável para scanear imagens
    private Scanner scan;
    //VAriável para pintar o mapa
    private String Mapa[] = new String [30];
    //Variáveis para armazenamento dos ícones
    private Image caminho,
                  parede,
                  chegada;
    
    private String localMap;
    
    public Mapa(String localMap){
        //Recebe imagem da parede, caminho e da chegada e coloca em suas respectivas variáveis
        ImageIcon img = new ImageIcon( "icons\\caminho.png" );
        caminho = img.getImage();
        img = new ImageIcon( "icons\\parede.png" );
        parede = img.getImage();
        img = new ImageIcon ( "icons\\peach.png" );
        chegada = img.getImage();
        
        this.localMap = localMap;
        
        //Funções para ler os mapas
        openFile();
        readFile();
        closeFile();
    }
    
    //Procura o arquivo .txt do mapa
    public void openFile(){  
        try{
        scan = new Scanner(new File(localMap));
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Mapa não encontrado!");
        }
    }
    
    //Lê o arquivo e passa a string Mapa[30]
    public void readFile(){
        while( scan.hasNext() ){
            for(int i = 0; i < 30; i++){
                Mapa[i] = scan.next();
            }
        }
    }
    
    public void closeFile(){
        scan.close();
    }
    
     //Gets   
    public Image getCaminho(){
        return caminho;
    }
    
    public Image getParede(){
        return parede;
    }
    
    public Image getChegada(){
        return chegada;
    }
    
    public String getMapa( int x, int y ){
        String index = Mapa[y].substring(x, x + 1);
        return index;
    }

}
