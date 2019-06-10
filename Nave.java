package asteroids;

import jplay.Sprite;

public class Nave extends Sprite{
	private int vidas = 3;
	public Tiro tiro = new Tiro();
	public int ultimo_disparo = 0;
	
	public Nave() {
		super("Images/nave2.png");
	}
}
