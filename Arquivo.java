package asteroids;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Arquivo {
	//public List<Integer> pontuacao = new ArrayList<>();
	//public List<String> nome = new ArrayList<>();
	public List<Pessoa> jogadores = new ArrayList<>();
	
	
	public void leitor() throws IOException, FileNotFoundException {
        BufferedReader arquivo = new BufferedReader(new FileReader("Ranking.txt"));
        String linha = "";
        while (true) {
        	linha = arquivo.readLine();
            if (linha != null) {
            	int a = Integer.parseInt(linha.split(" ")[1]);
            	String b = linha.split(" ")[0];
            	jogadores.add(new Pessoa(b,a));
                //pontuacao.add(a);
                //nome.add(b);
            } else
                break;
            
        }
        arquivo.close();
    }
 
	
    public void escritor(String jogador, int pont) throws IOException {
    	int limite;
    	int entrou = 0;
    	File teste = new File("Ranking.txt");
    	if(teste.exists()) {
    		leitor();
    		BufferedWriter arquivo = new BufferedWriter(new FileWriter("Ranking.txt"));
    		if (jogadores.size()<3) {
    			limite = jogadores.size();
    		}else {
    			limite = 3;
    		}
    		for (int i = 0; i < limite;) {
    			int j = jogadores.get(i).pontuacao;
    			if (pont>j) {
    				arquivo.append(jogador +" " + pont + "\n");
    				entrou = 1;
    				arquivo.append(jogadores.get(i).nome +" " + jogadores.get(i).pontuacao + "\n");
    				i+=2;
    			}
    			else {
    				arquivo.append(jogadores.get(i).nome +" " + jogadores.get(i).pontuacao + "\n");
    				i++;
    			}
    		}
    		if (limite < 3 & entrou == 0 ) {
				arquivo.append(jogador +" " + pont + "\n");
			}
		arquivo.close();
    	}else {
    		BufferedWriter arquivo = new BufferedWriter(new FileWriter("Ranking.txt"));
    		arquivo.append(jogador + " " + pont + "\n");
    		arquivo.close();
    	}
    }
    
    
}
