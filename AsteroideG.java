package asteroids;

import java.util.List;


public class AsteroideG extends Asteroide{

	public AsteroideG() {
		super("Images/AsteroideG.png");
	}

	@Override
	public void destroi(List pedrinhas, double pos_x, double pos_y) {
		AsteroideM a1 = new AsteroideM();
		a1.setX(pos_x);
		a1.setY(pos_y);
		AsteroideM a2 = new AsteroideM();
		a2.setX(pos_x);
		a2.setY(pos_y);
		pedrinhas.add(a1);
		pedrinhas.add(a2);
	}

	@Override
	public void movimenta() {
		this.x += direcao_X*0.4;
		this.y += direcao_Y*0.2;
	}

}
