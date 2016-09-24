package Game;

import javax.swing.*;

public class Maze {
    public static void main(String[] args) {
        new Maze();
    }
    
    public Maze(){
        JFrame frame = new JFrame();
        frame.setTitle( "Mazer Runner - Version 1.0" );
        
        frame.add(new Board());
        
        frame.setSize(464, 485);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }
}