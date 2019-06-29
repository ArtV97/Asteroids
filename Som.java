package asteroids;

import jplay.Sound;

public class Som extends Sound implements Runnable {
	public Som(String Path) {
		super(Path);
	}
	@Override
	public void run() {
		this.play();
	}

}
