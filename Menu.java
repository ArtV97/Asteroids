package asteroids;

import jplay.Window;
import jplay.GameImage;
import jplay.Mouse;


public class Menu {
    Window janela;
    GameImage menu;
    GameImage play;
    GameImage rank;
    GameImage quit;
    Mouse mouse;
    boolean executando = true;

    public Menu(){
        carregar();
        loop();
    }
    void carregar()
    {
        janela = new Window(800, 600);
        janela.setTitle("Asteroids");
        menu = new GameImage("Images/menu.jpg");
        play = new GameImage("Images/Play.png");
        rank = new GameImage("Images/Rank.png");
        quit = new GameImage("Images/Quit.png");
        posiciona_botao();
        mouse = janela.getMouse();

    }
    void posiciona_botao() {
    	play.x = janela.getWidth()/2 - play.width/2;
    	play.y = 2 * play.height;
    	rank.x = janela.getWidth()/2 - rank.width/2;
    	rank.y = 4 * rank.height;
    	quit.x = janela.getWidth()/2 - quit.width/2;
    	quit.y = 6 * quit.height;
    }
    void desenha()
    {
     menu.draw();
     play.draw();
     rank.draw();
     quit.draw();
     janela.update();
    }
    void loop(){
        while(executando){
            desenha();
            if(mouse.isOverObject(play)){
            	play = new GameImage("Images/PlaySelecionado.png");
            	posiciona_botao();
            	if(mouse.isLeftButtonPressed()) {
            		Gameplay jogo = new Gameplay(janela);
            	}
            }
            else {
            	play = new GameImage("Images/Play.png");
            	posiciona_botao();
            }
            if(mouse.isOverObject(rank)){
            	rank = new GameImage("Images/RankSelecionado.png");
            	posiciona_botao();
            	if(mouse.isLeftButtonPressed()) {
            		//Acessa arquivo e faz os paranauê;
            	}
            }
            else {
            	rank = new GameImage("Images/Rank.png");
            	posiciona_botao();
            }
            /*
            if ( teclado.keyDown(KeyEvent.VK_2)== true ){
             //Instrucao jogo = new Instrucao(janela);
             }

            if( teclado.keyDown(KeyEvent.VK_3) == true){
            //Creditos jogo = new Creditos(janela);

            }*/

            if (mouse.isOverObject(quit)){
            	quit = new GameImage("Images/QuitSelecionado.png");
            	posiciona_botao();
            	if(mouse.isLeftButtonPressed()) {
            		janela.exit();
            	}
             }
            else {
            	quit = new GameImage("Images/Quit.png");
            	posiciona_botao();
            }
        }
    }
}
