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
	public List<Integer> pontuacao = new ArrayList<>();
	public List<String> nome = new ArrayList<>();
	
	
	public void leitor() throws IOException, FileNotFoundException {
        BufferedReader arquivo = new BufferedReader(new FileReader("Ranking.txt"));
        String linha = "";
        while (true) {
        	linha = arquivo.readLine();
            if (linha != null) {
            	int a = Integer.parseInt(linha.split(" ")[0]);
            	String b = linha.split(" ")[1];
                pontuacao.add(a);
                nome.add(b);
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
    		if (pontuacao.size()<3) {
    			limite = pontuacao.size();
    		}else {
    			limite = 3;
    		}
    		for (int i = 0; i < limite;) {
    			int j = pontuacao.get(i);
    			if (pont>j) {
    				arquivo.append(pont +" " + jogador + "\r\n");
    				entrou = 1;
    				arquivo.append(pontuacao.get(i) +" " + nome.get(i) + "\r\n");
    				i+=2;
    			}
    			else {
    				arquivo.append(pontuacao.get(i) +" " + nome.get(i) + "\r\n");
    				i++;
    			}
    		}
    		if (limite < 3 & entrou == 0 ) {
				arquivo.append(pont +" " + jogador + "\r\n");
			}
		arquivo.close();
    	}else {
    		BufferedWriter arquivo = new BufferedWriter(new FileWriter("Ranking.txt"));
    		arquivo.append(pont +" " + jogador + "\r\n");
    		arquivo.close();
    	}
    }
    
    
}
