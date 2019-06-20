package asteroids;

import java.io.IOException;

import javax.swing.JOptionPane;

public class Gameover {
	public String nome = "";
	
	public Gameover(int pontuacao){
		nome = JOptionPane.showInputDialog("Digite seu nome");
		Arquivo arq = new Arquivo();
		try {
			arq.escritor(nome, pontuacao);
		} catch (IOException e) {
			System.out.println("Erro");
		}
	}
}
