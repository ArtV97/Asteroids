package asteroids;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Physics;
import jplay.Window;

public class Gameplay {
	Window janela;
	GameImage fundo;
	Keyboard teclado;
	Physics fisica;
	Nave player;
	boolean executando = true;
	
	public Gameplay(Window janela) {
		carregar(janela);
		loop();
	}
	
	public void carregar(Window janela) {
		this.janela = janela;
		this.teclado = janela.getKeyboard();
		this.fisica = new Physics();
		fisica.setGravity(0);
		fisica.createWorld(this.janela.getWidth(), this.janela.getHeight());
		this.fundo = new GameImage("Images/background.png");
		this.player = new Nave();
		fisica.createBodyFromSprite(player, false);
		player.setMass(1f);  
		player.setFriction(0.2f);  
		player.setRestitution(0f);
		player.setX(janela.getWidth()/2 - player.width/2);
		player.setY(janela.getHeight()/2 - player.height/2);
		fisica.createBodyFromSprite(player, false);
		//player.getBody().m_sweep.a = (float) Math.toRadians(Math.PI/2);
	}
	
	public void desenha() {
		this.fundo.draw();
		//player.update();
		this.player.draw();
		player.tiro.desenha_tiro(player);
		player.tiro.upadate_tiro(janela, player);
		fisica.update();
		this.janela.update();
		janela.delay(12);
	}
	
	public void loop() {
		while(executando) {
			desenha();
			player.ultimo_disparo += janela.deltaTime()/1000.0;
			player.getBody().setAngularVelocity(0);
			//comandos do jogador
			if (teclado.keyDown(Keyboard.LEFT_KEY)) {
				player.getBody().setAngularVelocity(4);
			}
			else if (teclado.keyDown(Keyboard.RIGHT_KEY)) {
				player.getBody().setAngularVelocity(-4);
			}
			if (teclado.keyDown(Keyboard.UP_KEY)){
				player.applyForceY(20*Math.sin(player.getBody().getAngle()));
				player.applyForceX(20*Math.cos(player.getBody().getAngle()));
			}
			if (teclado.keyDown(Keyboard.SPACE_KEY)) {
				player.tiro.inicializa_tiro(player, fisica);
				player.ultimo_disparo = 0;
			}
			//limites da tela
			if (player.y > janela.getHeight()) {
				player.setY(-player.height);
			}
			else if (player.y < -player.height) {
				player.setY(janela.getHeight());
			}
			else if (player.x > janela.getWidth()) {
				player.setX(-player.width);
			}
			else if (player.x < -player.width) {
				player.setX(janela.getWidth());
			}
			else if (teclado.keyDown(Keyboard.ESCAPE_KEY)) {
				return;
			}
		}
	}
}
