package asteroids;

import java.util.ArrayList;
import java.util.List;

import jplay.Animation;
import jplay.Sprite;
import jplay.Window;

public class Asteroides extends Thread {
	public List<Asteroide> pedrinhas = new ArrayList<>();
	
	public Asteroides(int qtd_asteroides) {
		for (int i = 0; i < qtd_asteroides; i++) {
			if (Math.random() > 0.5) {
				pedrinhas.add(new AsteroideG());
			}
			else {
				pedrinhas.add(new AsteroideM());
			}
		}
	}
	//retorna true se o jogador perdeu
	public boolean colisao_jogador(Nave jogador, Window janela) { 
		for (Asteroide obj: pedrinhas) {
			if (jogador.collided(obj)) {
				if (jogador.get_vidas().size() > 1) {
					jogador.perde_vida();
					jogador.cancelForces();
					jogador.cont_ressurection = 0;
				}
				else {
					return true;
				}
				obj.destroi(pedrinhas, obj.getX(), obj.getY());
				pedrinhas.remove(obj);
				Animation animacao = new Animation("Images/Explosion.png",12);
				animacao.x = jogador.getX();
				animacao.y = jogador.getY();
				animacao.setTotalDuration(1000);
				while (animacao.getCurrFrame() < 11) {
					animacao.draw();
					animacao.update();
					janela.update();
				}
				jogador.setX(janela.getWidth()/2 - jogador.width/2);
				jogador.setY(janela.getHeight()/2 - jogador.height/2);
				return false;
			}
		}
		return false;//se nenhum deles colidiu
	}
	/*public void desenha(Window janela){
		for (Asteroide obj: pedrinhas) {
			obj.movimenta();
			obj.verif_tela(janela);
			obj.draw();
		}
	}*/
	
	public void verifica_bordas(Window janela) {
		for (Asteroide obj: pedrinhas) {
			obj.verif_tela(janela);
		}
	}
	
	public boolean update(Sprite disparo) {
		for (Asteroide target: pedrinhas) {
			if (disparo.collided(target)) {
				target.destroi(pedrinhas, target.getX(), target.getY());
				return true;
			}
		}
		return false;
	}
	@Override
	public void run() {
		for (Asteroide obj: pedrinhas) {
			obj.movimenta();
			obj.draw();
		}
		
	}
}
