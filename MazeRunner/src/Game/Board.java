package Game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JPanel implements ActionListener {
    
    private Timer timer;
    private Mapa mapa;
    private Jogador jog;
    private int jogadas = 0;
    
    public  Board(){      
        mapa = new Mapa();
        jog = new Jogador();
        addKeyListener(new Al());
        setFocusable(true);
        
        timer = new Timer(25, this);
        timer.start();
        
        
    }
    
    
    public void actionPerformed(ActionEvent e) {
        if ( mapa.getMapa( jog.getTileX(), jog.getTileY() ).equals("c") ){
            JOptionPane.showMessageDialog(null, "Fuck yeah");
        }
        repaint();
    }
    
    public void paint(Graphics g){
        super.paint(g);
        
        for ( int y = 0; y < 14; y++ ){
            for ( int x = 0; x < 14; x++ ){
                if ( mapa.getMapa(x, y).equals( "g" ) ){
                    g.drawImage( mapa.getCaminho(), x * 32, y * 32, null );
                }
                
                if ( mapa.getMapa(x, y).equals( "w" ) ){
                    g.drawImage( mapa.getParede(), x * 32, y * 32, null );
                }
                
                if ( mapa.getMapa(x, y).equals( "c" ) ){
                    g.drawImage( mapa.getChegada(), x * 32, y * 32, null );
                }
            }
        } 
        
        g.drawImage(jog.getJogador(), jog.getTileX() * 32, jog.getTileY() * 32, null);
    }
    
    public class Al extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            int teclaChave = e.getKeyCode();
            
            if ( teclaChave == KeyEvent.VK_W ){
                if (!mapa.getMapa( jog.getTileX(), jog.getTileY() - 1).equals("w") ){
                jog.move(0, -1);
                jogadas++;
                }
            }
            if ( teclaChave == KeyEvent.VK_S ){
                if (!mapa.getMapa( jog.getTileX(), jog.getTileY() + 1).equals("w") ){
                jog.move(0, 1);
                jogadas++;
                }
            }
            if ( teclaChave == KeyEvent.VK_D ){
                if (!mapa.getMapa( jog.getTileX() + 1, jog.getTileY() ).equals("w") ){
                jog.move(1, 0);
                jogadas++;
                }
            }
            if ( teclaChave == KeyEvent.VK_A ){
                if (!mapa.getMapa( jog.getTileX() - 1, jog.getTileY() ).equals("w") ){
                jog.move(-1, 0);
                jogadas++;
                }
            }
        }
        
        public void keyReleased(KeyEvent e){
        
        }
        
        public void keyTyped(KeyEvent e){
        
        }
    }
}
