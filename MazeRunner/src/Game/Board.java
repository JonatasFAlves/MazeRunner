package Game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JPanel implements ActionListener {
    //Variável de relógio, mapa e jogador das classes usadas.
    private Timer timer;
    private Mapa mapa;
    private Jogador jog;
    
    //Variáveis para local do mapa e auxilio na manipulação da frame atual
    private String localMap;
    private JFrame frame;
    
    //Variáveis para mudança de lado do jogador, e pixels das imagens
    private boolean lado;
    private int pixelsImg = 20;
    private int jogadas = 0;
    private final ImageIcon imgGif;
    
    //Construtor
    public  Board(String localMap, JFrame frame){
        //Recebe local do mapa e frame do Maze, inicía variável para checar lado
        this.localMap = localMap;
        this.frame = frame;
        this.lado = true;
        
        //Novo Mapa() e Jogador()
        mapa = new Mapa(this.localMap);
        jog = new Jogador();
        
        //Uso das teclas e focus ao Board 
        addKeyListener(new Al());
        setFocusable(true);
        
        //Relógio de 25ms em 25ms para checagem de ações
        timer = new Timer(25, this);
        timer.start(); 
        
        imgGif = new ImageIcon("icons\\gif.gif");
    }
    
    //Roda 25ms em 25ms
    public void actionPerformed(ActionEvent e) {
        //Variável para armazenamento de mensagem.
        String message;
        
        //Checa se jogador chegou ao final da fase
        if ( mapa.getMapa( jog.getTileX(), jog.getTileY() ).equals("c") ){
            
            //Troca a variável para carregar o local da próxima fase
            if (this.localMap.equals("mapas\\mapa1.txt")){
                this.localMap = "mapas\\mapa2.txt";
            } 
            else if (this.localMap.equals("mapas\\mapa2.txt")){
                this.localMap = "mapas\\mapa3.txt";
            }
            //Caso jogador passe da terceira fase ele completa modo easy
            else if (this.localMap.equals("mapas\\mapa3.txt")){
                
                message = "Parabéns. Você completou o easy mode!! \n Porquê não tentas o normal mode?";
                JOptionPane.showMessageDialog(null, message, "WIN", JOptionPane.INFORMATION_MESSAGE, imgGif);
                
                new Menu();
                frame.dispose();
            } 
            
            
            else if (this.localMap.equals("mapas\\mapa4.txt")){
                this.localMap = "mapas\\mapa5.txt";
            } 
            else if (this.localMap.equals("mapas\\mapa5.txt")){
                this.localMap = "mapas\\mapa6.txt";
            } 
            //Caso jogador passe da terceira fase ele completa modo normal
            else if (this.localMap.equals("mapas\\mapa6.txt")){
                
                message = "Parabéns. Você completou o normal mode!! \n Se achas que consegue, porquê não encaras o hard mode?";
                JOptionPane.showMessageDialog(null, message, "WIN", JOptionPane.INFORMATION_MESSAGE, imgGif);
                
                new Menu();
                frame.dispose();
            } 
            
            else if (this.localMap.equals("mapas\\mapa7.txt")){
                this.localMap = "mapas\\mapa8.txt";
            } 
            else if (this.localMap.equals("mapas\\mapa8.txt")){
                this.localMap = "mapas\\mapa9.txt";
            } 
            //Caso jogador passe da terceira fase ele completa modo hard
            else if (this.localMap.equals("mapas\\mapa9.txt")){
                
                message = "Parabén. Você completou o hard mode!! \n Você com certeza é digno do título 'Maze Runner'";
                JOptionPane.showMessageDialog(null, message, "WIN", JOptionPane.INFORMATION_MESSAGE, imgGif);
                
                new Menu();
                frame.dispose();              
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
        for ( int y = 0; y < 30; y++ ){
            for ( int x = 0; x < 30; x++ ){
                if ( mapa.getMapa(x, y).equals( "g" ) ){
                    g.drawImage( mapa.getCaminho(), x * pixelsImg, y * pixelsImg, null );
                }
                
                if ( mapa.getMapa(x, y).equals( "w" ) ){
                    g.drawImage( mapa.getParede(), x * pixelsImg, y * pixelsImg, null );
                }
                
                if ( mapa.getMapa(x, y).equals( "c" ) ){
                    g.drawImage( mapa.getChegada(), x * pixelsImg, y * pixelsImg, null );
                }
                   
            }
        } 
        
        //If para checagem de qual ultimo lado virado do jogador
        if ( lado == true ){
        g.drawImage(jog.getImgJogador(), jog.getTileX() * pixelsImg, jog.getTileY() * pixelsImg, null);
        } else {
        g.drawImage(jog.getImgJogadorL(), jog.getTileX() * pixelsImg, jog.getTileY() * pixelsImg, null);
        }
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
                lado = true;
                }
            }
            //Caso usuário aperte A, checa se não existe parede, anda ao local, adiciona +1 as jogadas.
            if ( teclaChave == KeyEvent.VK_A ){
                if (!mapa.getMapa( jog.getTileX() - 1, jog.getTileY() ).equals("w") ){
                jog.move(-1, 0);
                jogadas++;
                lado = false;
                }
            }
            
            //Caso usuário aperte ESC, Pergunta se jogador deseja sair, CAso sim, volta ao menu
            if ( teclaChave == KeyEvent.VK_ESCAPE ){
                
                int resposta;
                String messageQuit = "Você deseja voltar ao menu principal? \n"
                        + "Todo o seu progresso será perdido.";
                
                resposta = JOptionPane.showConfirmDialog( null, messageQuit, "Quit", JOptionPane.YES_NO_OPTION );
                
                if ( resposta == (JOptionPane.YES_OPTION) ){
                new Menu();
                frame.dispose();
                }               
            }
        }       
    }
}
