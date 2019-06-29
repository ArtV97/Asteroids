package asteroids;

public class Pessoa implements Comparable{
	public String nome;
	public int pontuacao;
	
	public Pessoa(String nome, int pontuacao) {
		this.nome = nome;
		this.pontuacao = pontuacao;
	}

	@Override
	public int compareTo(Object arg0) {
		Pessoa p = (Pessoa)arg0;
		Integer a = this.pontuacao;
		Integer b = p.pontuacao;
		System.out.println(a.compareTo(b));
		return a.compareTo(b);
	}
	
}
