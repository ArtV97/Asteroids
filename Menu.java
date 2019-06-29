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
        posiciona_botoes();
        mouse = janela.getMouse();
    }
    void posiciona_botoes() {
    	play.x = janela.getWidth()/2 - play.width/2;
    	play.y = 6 * play.height;
    	rank.x = janela.getWidth()/2 - rank.width/2;
    	rank.y = 8 * rank.height;
    	quit.x = janela.getWidth()/2 - quit.width/2;
    	quit.y = 10 * quit.height;
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
            	play.loadImage("Images/PlaySelecionado.png");
            	if(mouse.isLeftButtonPressed()) {
            		new Gameplay(janela);
            	}
            }
            else {
            	play.loadImage("Images/Play.png");
            }
            if(mouse.isOverObject(rank)){
            	rank.loadImage("Images/RankSelecionado.png");
            	if(mouse.isLeftButtonPressed()) {
            		new Ranking(janela);
            	}
            }
            else {
            	rank.loadImage("Images/Rank.png");
            }
            if (mouse.isOverObject(quit)){
            	quit.loadImage("Images/QuitSelecionado.png");
            	if(mouse.isLeftButtonPressed()) {
            		janela.exit();
            	}
             }
            else {
            	quit.loadImage("Images/Quit.png");
            }
        }
    }
}
