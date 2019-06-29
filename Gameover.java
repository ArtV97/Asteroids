package asteroids;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JOptionPane;

import jplay.GameImage;
import jplay.Window;

public class Gameover {
	public String nome = "";
	public int pont_jogador;
	public Window janela;
	public GameImage fundo;
	
	public Gameover(int pontuacao, Window janela){
		this.janela = janela;
		fundo = new GameImage("Images/GameOver.jpg");
		pont_jogador = pontuacao;
		salva_score();
	}
	
	public void desenha() {
		fundo.draw();
		janela.drawText("Total Score: "+ pont_jogador, 200, 400,
				new Color(255,255,255),new Font("TimesRoman", Font.PLAIN, 20));
		janela.update();
	}
	
	public void salva_score() {
		desenha();
		nome = JOptionPane.showInputDialog("Digite seu nome");
		Arquivo arq = new Arquivo();
		try {
			arq.escritor(nome, pont_jogador);
		} catch (IOException e) {
			System.out.println("Erro");
}
	}
	
}
