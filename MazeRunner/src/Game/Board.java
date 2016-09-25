package Game;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Board extends JPanel implements ActionListener {
    //Variável de relógio, mapa e jogador das classes usadas.
    private Timer timer;
    private Mapa mapa;
    private Jogador jog;
    //Variável que adiciona número de jogadas
    private int jogadas = 0;
    
    private String localMap;
    private JFrame frame;
    
    public  Board(String localMap, JFrame frame){
        this.localMap = localMap;
        this.frame = frame;
        
        //Novo Mapa() e Jogador()
        mapa = new Mapa(this.localMap);
        jog = new Jogador();
        //Uso das teclas 
        addKeyListener(new Al());
        //Focus ao Board
        setFocusable(true);
        
        //Relógio de 25ms em 25ms para checagem de ações
        timer = new Timer(25, this);
        timer.start();     
    }
    
        //Roda 25ms em 25ms
    public void actionPerformed(ActionEvent e) {
        //Checa se jogador chegou ao final da fase
        if ( mapa.getMapa( jog.getTileX(), jog.getTileY() ).equals("c") ){
            
            //Troca a variável para carregar o local da próxima fase
            if (this.localMap.equals("mapas\\mapa1.txt")){
                this.localMap = "mapas\\mapa2.txt";
            } 
            else if (this.localMap.equals("mapas\\mapa2.txt")){
                this.localMap = "mapas\\mapa3.txt";
            }
            else if (this.localMap.equals("mapas\\mapa3.txt")){
                //this.localMap = "mapas\\mapa4.txt";
            } 
            else if (this.localMap.equals("mapas\\mapa4.txt")){
                this.localMap = "mapas\\mapa5.txt";
            } 
            else if (this.localMap.equals("mapas\\mapa5.txt")){
                this.localMap = "mapas\\mapa6.txt";
            } 
            else if (this.localMap.equals("mapas\\mapa6.txt")){
                //this.localMap = "mapas\\mapa7.txt";
            } 
            else if (this.localMap.equals("mapas\\mapa7.txt")){
                this.localMap = "mapas\\mapa8.txt";
            } 
            else if (this.localMap.equals("mapas\\mapa8.txt")){
                this.localMap = "mapas\\mapa9.txt";
            } 
            else if (this.localMap.equals("mapas\\mapa9.txt")){
                //this.localMap = "mapas\\mapa3.txt";
            }             
            
            //Troca mapa e reseta posição do jogador
            mapa = new Mapa(localMap);
            jog.resetPosition();
        }
        //Muda os icones de lugares caso haja movimento 
        repaint();
    }
    
    public void paint(Graphics g){
        
        super.paint(g);
        //"Pinta" os blocos com paredes, caminho e o final da fase.
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
        
        //Posiciona o icone do jogador na posição (1,1)*32
        g.drawImage(jog.getJogador(), jog.getTileX() * 32, jog.getTileY() * 32, null);
    }
    
    //Classe para movimento do jogador
    public class Al extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            int teclaChave = e.getKeyCode();
            
            //Caso usuário aperte W, checa se não existe parede, anda ao local, adiciona +1 as jogadas.
            if ( teclaChave == KeyEvent.VK_W ){
                if (!mapa.getMapa( jog.getTileX(), jog.getTileY() - 1).equals("w") ){
                jog.move(0, -1);
                jogadas++;
                }
            }
            //Caso usuário aperte S, checa se não existe parede, anda ao local, adiciona +1 as jogadas.
            if ( teclaChave == KeyEvent.VK_S ){
                if (!mapa.getMapa( jog.getTileX(), jog.getTileY() + 1).equals("w") ){
                jog.move(0, 1);
                jogadas++;
                }
            }
            //Caso usuário aperte D, checa se não existe parede, anda ao local, adiciona +1 as jogadas.
            if ( teclaChave == KeyEvent.VK_D ){
                if (!mapa.getMapa( jog.getTileX() + 1, jog.getTileY() ).equals("w") ){
                jog.move(1, 0);
                jogadas++;
                }
            }
            //Caso usuário aperte A, checa se não existe parede, anda ao local, adiciona +1 as jogadas.
            if ( teclaChave == KeyEvent.VK_A ){
                if (!mapa.getMapa( jog.getTileX() - 1, jog.getTileY() ).equals("w") ){
                jog.move(-1, 0);
                jogadas++;
                }
            }
            
            //Caso usuário aperte ESC, Pergunta se jogador deseja sair, CAso sim, volta ao menu
            if ( teclaChave == KeyEvent.VK_ESCAPE ){
                
                int resposta;
                String messageQuit = "Você deseja voltar ao menu principal? \n"
                        + "Todo o seu progresso será perdido.";
                
                resposta = JOptionPane.showConfirmDialog( null, messageQuit, "Quit", JOptionPane.YES_NO_OPTION );
                
                if ( resposta == (JOptionPane.YES_OPTION) ){
                String[] args = {};
                Menu.main(args);
                frame.dispose();
                }               
            }
        }       
    }
}
