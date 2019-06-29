package asteroids;

import java.awt.Color;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.IOException;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;

public class Ranking {
	Window janela;
	GameImage fundo;
	GameImage titulo;
	Keyboard teclado;
	boolean executando = true;
	
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
		janela.update();
		janela.delay(2);
	}
	
	void posiciona_titulo() {
    	titulo.x = janela.getWidth()/2 - titulo.width/2;
    	titulo.y = 50;
	}

	public void desenha() throws FileNotFoundException, IOException {
		fundo.draw();
		titulo.draw();
		Arquivo arq = new Arquivo();
		arq.leitor();
		int altura_linha = 300;
		for (int i = 0; i < arq.jogadores.size(); i++) {
			janela.drawText((i+1) + " " + arq.jogadores.get(i).nome + " " + arq.jogadores.get(i).pontuacao,
							180,altura_linha,new Color(255,255,255),new Font("TimesRoman", Font.PLAIN, 50));
			altura_linha += 50;
		}
		this.janela.update();
	}
	

	
	public void loop() {
		try {
			desenha();
		} catch (FileNotFoundException e) {
			//Avisa ao jogador que não existe nenhum registro de Score
			GameImage msg = new GameImage("Images/msgRkNotFound.png");
			msg.x = this.janela.getWidth()/2 - msg.width/2;
			msg.y = this.janela.getHeight()/2 - msg.height/2;
			msg.draw();
		} catch (IOException e) {
			//Deu Ruim
			GameImage msg = new GameImage("Images/msgRkNotFound2.png");
			msg.x = this.janela.getWidth()/2 - msg.width/2;
			msg.y = this.janela.getHeight()/2 - msg.height/2;
			msg.draw();
		}
		finally {
			janela.update();
			while (executando) {
				if (teclado.keyDown(Keyboard.ESCAPE_KEY)) {
					return;
				}
			}
		}
	}
	

}
