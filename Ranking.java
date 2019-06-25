package asteroids;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Mouse;
import jplay.Window;

public class Ranking {
	Window janela;
	GameImage fundo;
	GameImage titulo;
	Keyboard teclado;
	boolean executando = true;
	Mouse mouse;
	
	public Ranking(Window janela) {
		carregar(janela);
		loop();
	}

	public void carregar(Window janela){
		this.janela = janela;
		this.teclado = janela.getKeyboard();
		fundo = new GameImage("Images/background.png");
		titulo = new GameImage("Images/tituloR.png");
		fundo.draw();
		posiciona_titulo();
		mouse = janela.getMouse();
		janela.update();
		janela.delay(2);
	}
	
	void posiciona_titulo() {
    	titulo.x = janela.getWidth()/2 - titulo.width/2;
    	titulo.y = 50;
	}

	public void desenha() {
		fundo.draw();
		titulo.draw();
		this.janela.update();
	}
	
	public void loop() {
		while (executando) {
			desenha();
		}
	}
	

}
