package asteroids;

import java.util.ArrayList;

import jplay.GameImage;
import jplay.Sprite;
import jplay.Window;
//NUNCA HAVERÁ MAIS DE UM OVNI NA TELA
public class Ovni {
	public ArrayList <GameImage> et = new ArrayList<>();
	
	public void sorteia(int n_vidas) {
		if (et.size() == 0 && n_vidas < 3 && Math.random() < 0.0001) {
			et.add(new GameImage("Images/Ufo.png"));
			et.get(0).y = et.get(0).height/2;
			new Thread(new Som("Sounds/Ufo.wav")).start();
		}
	}
	
	public boolean update(Sprite disparo) {
		boolean valor = false;
		for (GameImage obj: et) {
			valor = disparo.collided(obj);
		}
		if (valor) {
			et.remove(0);
		}
		return valor;
	}
	
	public void movimenta(Window janela) {
		boolean remove = false;
		for (GameImage obj: et) {
			obj.x += 0.12 * janela.deltaTime();
			obj.draw();
			if (obj.x > janela.getWidth() + obj.width) {
				remove = true;
			}
		}
		if (remove) {
			et.remove(0);
		}
	}
}
