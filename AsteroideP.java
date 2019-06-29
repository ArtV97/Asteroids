package asteroids;

import java.util.List;

public class AsteroideP extends Asteroide{

	public AsteroideP() {
		super("Images/AsteroideP.png");
	}

	@Override
	public void destroi(List  pedrinhas, double pos_x, double pos_y) {
		pedrinhas.remove(this);
	}

	@Override
	public void movimenta() {
		this.x += direcao_X*1.6;
		this.y += direcao_Y*0.8;
	}

}
