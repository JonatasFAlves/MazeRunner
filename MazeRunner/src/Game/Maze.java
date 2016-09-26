package Game;

import javax.swing.*;

public class Maze {
    
    //Variável para o armazenamento do local
    private String localMap;
  
    //Quando classe Maze for chamada...
    public Maze(String localMap){
        this.localMap = localMap;
        
        //Cria novo JFrame e adiciona um título novo JFrame
        JFrame frame = new JFrame();
        frame.setTitle( "Super Mario Maze - Versão 0.9" );
        //Adiciona o panel Board ao JFrame.
        frame.add(new Board(this.localMap, frame));
        /* Seta tamanhos. Janela deverá ficar no centro da tela.
        JFrame com novo JPanel visível. Caso usuário aperte "x" o JFrame se encerra. */
        frame.setSize(616, 640);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }
}