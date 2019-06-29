package asteroids;

import java.util.List;


public class AsteroideM extends Asteroide{

	public AsteroideM() {
		super("Images/AsteroideM.png");
	}

	@Override
	public void destroi(List  pedrinhas, double pos_x, double pos_y) {
		AsteroideP a1 = new AsteroideP();
		a1.setX(pos_x);
		a1.setY(pos_y);
		AsteroideP a2 = new AsteroideP();
		a2.setX(pos_x);
		a2.setY(pos_y);
		pedrinhas.remove(this);
		pedrinhas.add(a1);
		pedrinhas.add(a2);
	}

	@Override
	public void movimenta() {
		this.x += direcao_X*0.8;
		this.y += direcao_Y*0.4;
	}

}
