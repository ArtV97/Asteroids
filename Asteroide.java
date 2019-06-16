package asteroids;

import java.util.List;

import jplay.Physics;
import jplay.Sprite;
import jplay.Window;

public abstract class Asteroide extends Sprite{
	int direcao_X;
	int direcao_Y;

	public Asteroide(String fileName) {
		super(fileName);
		//Sorteando a direcao que o Asteroide se moverá
		if ((Math.random()) > 0.5) {
			direcao_X = 1;
		}
		else {
			direcao_X = -1;
		}
		if ((Math.random()) > 0.5) {
			direcao_Y = 1;
		}
		else {
			direcao_Y = -1;
		}
		//fisica.createBodyFromSprite(this, false);
		//Sorteando posicao do Asteroide
		double x = Math.random() * 800;
		double y = Math.random() * 600;
		//se esta na area de seguranca do jogador, sera recalculado
  		while (400 < x && x < 600) { 
			x = Math.random() * 800;
		}
  		while (200 < y && y < 300) {
  			y = Math.random() * 600;
  		}
		this.setX(x);
  		this.setY(y);
		//movimentando o Asteroide
		//this.getBody().setAngularVelocity(1*direcao_X);
		//this.applyForceY(direcao_Y*5*Math.sin(this.getBody().getAngle()));
		//this.applyForceX(direcao_X*5*Math.cos(this.getBody().getAngle()));
	}
	//verifica se o Asteroide saiu da tela
	public void verif_tela(Window janela) {
		if (this.y > janela.getHeight()) {
			this.setY(-this.height);
		}
		else if (this.y < -this.height) {
			this.setY(janela.getHeight());
		}
		else if (this.x > janela.getWidth()) {
			this.setX(-this.width);
		}
		else if (this.x < -this.width) {
			this.setX(janela.getWidth());
		}
	}
	
	public abstract void movimenta();
	public abstract void destroi(List pedrinhas, double pos_x, double pos_y);
	
}
